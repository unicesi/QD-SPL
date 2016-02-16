package co.shift.pcs.risk.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.shift.pcs.to.RiskTO;
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
public class RiskDAO implements IRiskDAO {
	
	@PersistenceContext(unitName = "pcs")
	private EntityManager em;
	

	public RiskTO getProjectPriorityRisk(int projectId){
		PBECryptographyManager.init();
		Query query = em
		.createNativeQuery("SELECT u.* FROM Risk u, Project p WHERE p.priorityrisk = u.id AND p.id = "
				+ projectId);
		try {
			Object[] priorityrisk = (Object[]) query.getSingleResult();
			RiskTO u = new RiskTO();
			int tId = (int) priorityrisk[0];
			String tDescription = (String) priorityrisk[1];
			double tImpact = (double) priorityrisk[2];
			String tName = (String) priorityrisk[3];
			double tProbability = (double) priorityrisk[4];
			char[] eDescriptionChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tDescription);
			String eDescription = new String(eDescriptionChars);
			tDescription = eDescription;
			char[] eNameChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tName);
			String eName = new String(eNameChars);
			tName = eName;
			
			
			u.setId(tId);
			u.setDescription(tDescription);
			u.setImpact(tImpact);
			u.setName(tName);
			u.setProbability(tProbability);
			return u;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<RiskTO> getRiskFromProject(int projectId){
		List<RiskTO> risks = new ArrayList<>();
		Query query;
		List<Object[]> foundRisks;
		try {
			query = em
					.createNativeQuery("SELECT u.* FROM Risk u, ProjectRisk pu WHERE u.id = pu.riskId AND pu.projectId = "
							+ projectId);
			foundRisks = query.getResultList();
		} catch (Exception e) {
			query = em
					.createNativeQuery("SELECT u.* FROM Risk u, RiskProject pu WHERE u.id = pu.riskId AND pu.projectId = "
							+ projectId);
			foundRisks = query.getResultList();
		}
		RiskTO u = null;
		PBECryptographyManager.init();
		for (Object[] risk : foundRisks) {
			u = new RiskTO();
			int tId = (int) risk[0];
			String tDescription = (String) risk[1];
			double tImpact = (double) risk[2];
			String tName = (String) risk[3];
			double tProbability = (double) risk[4];
			char[] eDescriptionChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tDescription);
			String eDescription = new String(eDescriptionChars);
			tDescription = eDescription;
			char[] eNameChars = PBECryptographyManager.doFinal(
			PBECryptographyManager.DECRYPT, tName);
			String eName = new String(eNameChars);
			tName = eName;
			
			
			u.setId(tId);
			u.setDescription(tDescription);
			u.setImpact(tImpact);
			u.setName(tName);
			u.setProbability(tProbability);
			risks.add(u);
		}
		return risks;
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
