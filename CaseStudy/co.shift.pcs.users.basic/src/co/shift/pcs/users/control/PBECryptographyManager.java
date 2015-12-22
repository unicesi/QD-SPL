package co.shift.pcs.users.control;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
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
import javax.ejb.Stateless;

@Stateless
public class PBECryptographyManager {

	private PBEKeySpec pbeKeySpec;
	private PBEParameterSpec pbeParamSpec;
	private SecretKeyFactory keyFac;
	private SecretKey pbeKey;
	private Cipher pbeCipher;

	public static final int ENCRYPT = Cipher.ENCRYPT_MODE;
	public static final int DECRYPT = Cipher.DECRYPT_MODE;
	
	// Salt
	private byte[] salt = { (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c,
			(byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99 };

	// Iteration count
	private static final int COUNT = 20;

	public PBECryptographyManager() {
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

	public char[] doFinal(int mode, String text) {
		byte[] data = null;
		CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
	    decoder.onMalformedInput(CodingErrorAction.REPLACE);
	    decoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
	    decoder.replaceWith("?");
	    
		try {
			switch (mode) {
			case ENCRYPT:
				pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);
				break;
			case DECRYPT:
				pbeCipher.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);
				break;
			default:
				break;
			}
			data = pbeCipher.doFinal(text.getBytes());
			ByteBuffer bb = ByteBuffer.wrap(data);
			return decoder.decode(bb).array();
		} catch (InvalidKeyException | InvalidAlgorithmParameterException
				| IllegalBlockSizeException | BadPaddingException | CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
