package co.shift.pcs.user.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.shift.pcs.to.UserTO;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.apache.commons.codec.binary.Base64;
	
@Stateless
public class UserDAO implements IUserDAO {
	
	@PersistenceContext(unitName = "pcs")
	private EntityManager em;
	

	public UserTO getProjectManager(int projectId){
		PBECryptographyManager.init();
		Query query = em
		.createNativeQuery("SELECT u.* FROM User u, Project p WHERE p.manager = u.cc AND p.id = "
				+ projectId);
		try {
			Object[] manager = (Object[]) query.getSingleResult();
			UserTO u = new UserTO();
			String tCc = (String) manager[0];
			String tName = (String) manager[1];
			String tCellphone = (String) manager[2];
			String tPassword = (String) manager[3];
			char[] eCcChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tCc);
			String eCc = new String(eCcChars);
			tCc = eCc;
			char[] eNameChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tName);
			String eName = new String(eNameChars);
			tName = eName;
			char[] eCellphoneChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tCellphone);
			String eCellphone = new String(eCellphoneChars);
			tCellphone = eCellphone;
			char[] ePasswordChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tPassword);
			String ePassword = new String(ePasswordChars);
			tPassword = ePassword;
			
			
			u.setCc(tCc);
			u.setName(tName);
			u.setCellphone(tCellphone);
			u.setPassword(tPassword);
			return u;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<UserTO> getUserFromProject(int projectId){
		List<UserTO> users = new ArrayList<>();
		Query query;
		List<Object[]> foundUsers;
		try {
			query = em
					.createNativeQuery("SELECT u.* FROM User u, ProjectUser pu WHERE u.cc = pu.userCc AND pu.projectId = "
							+ projectId);
			foundUsers = query.getResultList();
		} catch (Exception e) {
			query = em
					.createNativeQuery("SELECT u.* FROM User u, UserProject pu WHERE u.cc = pu.userCc AND pu.projectId = "
							+ projectId);
			foundUsers = query.getResultList();
		}
		UserTO u = null;
		PBECryptographyManager.init();
		for (Object[] user : foundUsers) {
			u = new UserTO();
			String tCc = (String) user[0];
			String tName = (String) user[1];
			String tCellphone = (String) user[2];
			String tPassword = (String) user[3];
			char[] eCcChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tCc);
			String eCc = new String(eCcChars);
			tCc = eCc;
			char[] eNameChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tName);
			String eName = new String(eNameChars);
			tName = eName;
			char[] eCellphoneChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tCellphone);
			String eCellphone = new String(eCellphoneChars);
			tCellphone = eCellphone;
			char[] ePasswordChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tPassword);
			String ePassword = new String(ePasswordChars);
			tPassword = ePassword;
			
			
			u.setCc(tCc);
			u.setName(tName);
			u.setCellphone(tCellphone);
			u.setPassword(tPassword);
			users.add(u);
		}
		return users;
	}
	}
	class PBECryptographyManager {
	
		private static PBEKeySpec pbeKeySpec;
		private static PBEParameterSpec pbeParamSpec;
		private static SecretKeyFactory keyFac;
		private static SecretKey pbeKey;
		private static Cipher pbeCipher;
		
		public static final int ENCRYPT = Cipher.ENCRYPT_MODE;
		public static final int DECRYPT = Cipher.DECRYPT_MODE;
		
		// Salt
		private static byte[] salt = { (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c,
				(byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99 };
		
		// Iteration count
		private static final int COUNT = 20;
		
		public static void init() {
			// Create PBE parameter set
			pbeParamSpec = new PBEParameterSpec(salt, COUNT);
		
		pbeKeySpec = new PBEKeySpec("PCSUI".toCharArray());
		try {
			keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			pbeKey = keyFac.generateSecret(pbeKeySpec);
		
			// Create PBE Cipher
			pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		public static char[] doFinal(int mode, String text) {
			try {
				switch (mode) {
				case ENCRYPT:
					pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);
					byte[] encryptedData = pbeCipher.doFinal(text.getBytes("UTF-8"));
					return new String(Base64.encodeBase64(encryptedData)).toCharArray();
				case DECRYPT:
					byte[] decodedData = Base64.decodeBase64(text);
					pbeCipher.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);
					byte[] utf8 = pbeCipher.doFinal(decodedData);
					return new String(utf8, "UTF8").toCharArray();
				default:
					break;
				}
			} catch (InvalidKeyException | InvalidAlgorithmParameterException
					| IllegalBlockSizeException | BadPaddingException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;				
		}
	}
