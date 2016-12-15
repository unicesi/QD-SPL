package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import java.util.List
import domainmetamodel.Association
import co.shift.generators.domain.DomainCodeUtilities
import co.shift.generators.domain.DomainParams

class DAOImplTemplate {
	private static String className = new Object(){}.class.enclosingClass.simpleName

	def static generate (BusinessEntity be, String packageName, List<Association> associations) '''
		««« Establece la plantilla actual para contribución.
		«DomainCodeUtilities.beginTemplate(className)»
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».control;
		
		import java.util.ArrayList;
		import java.util.Date;
		import java.util.List;
		
		import javax.ejb.EJB;
		import javax.ejb.Stateless;
		import javax.persistence.EntityManager;
		import javax.persistence.NoResultException;
		import javax.persistence.PersistenceContext;
		import javax.persistence.Query;
		
		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
«««		«DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_BUSINESS_IMPORT, packageName, be.name)»

««« Jcifuentes: Comentado. 
««« Aquí en lugar de esta validacion, deberia un contribuyente retornar estos imports
««« por ahora se deja con la misma logica que tenia, solo se usa el nuevo modelo. Esto
««« es desafortunado porque esta seccion es realmente IMPORTS y no ATTRIBUTES.
««« NOTA: Esto siempre está generando el codigo para Encriptamiento, independientemente
««« de la configuracion. Se debe revisar en una mejora posterior.
«««		«val attribute2 = DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_BUSINESS_ATTRIBUTE)»
		«DomainCodeUtilities.beginSection(DomainParams.SECT_ATTRIBUTES)»
		«val attribute2 = DomainCodeUtilities.contribute2Template(1)»
		«DomainCodeUtilities.endSection»
		«IF (attribute2 != null && !attribute2.equals(""))»
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
		«ENDIF»
			
		@Stateless
		public class «be.name.toFirstUpper»DAO implements I«be.name.toFirstUpper»DAO {
			
			@PersistenceContext(unitName = "«packageName»")
			private EntityManager em;
			
«««			«IF (attribute2 != null && !attribute2.equals(""))»
«««				«attribute2»
«««			«ENDIF»
		
		«DomainCodeUtilities.beginSection(DomainParams.SECT_METHODS)»
			«FOR association : DomainCodeUtilities.getDetailSimpleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeUtilities.getID(container).dataType.literal»
				public «be.name»TO get«container.name.toFirstUpper»«association.name.toFirstUpper»(«DomainCodeUtilities.getType(type)» «container.name.
				toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper»){
					«IF (attribute2 != null && !attribute2.equals(""))»PBECryptographyManager.init();«ENDIF»
					Query query = em
					.createNativeQuery("SELECT u.* FROM «be.name.toFirstUpper» u, «container.name.toFirstUpper» p WHERE p.«association.name.toLowerCase» = u.«DomainCodeUtilities.getID(be).name.toLowerCase» AND p.«DomainCodeUtilities.getID(container).name.toLowerCase» = "
							+ «container.name.toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper»);
					try {
						Object[] «association.name.toLowerCase» = (Object[]) query.getSingleResult();
						«be.name.toFirstUpper»TO u = new «be.name.toFirstUpper»TO();
						«var i=0»
						«FOR attribute : be.attributes»
							«DomainCodeUtilities.getType(attribute)» t«attribute.name.toFirstUpper» = («DomainCodeUtilities.getType(attribute)») «association.name.toLowerCase»[«i»];
							«var c = i++»
						«ENDFOR»
««« Jcifuentes: Comentado
«««						«DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, null, 3)»
						«DomainCodeUtilities.contribute2Template(1, null, be, null, null, null, null, null, 3)»
						«FOR attribute : be.attributes»
						u.set«attribute.name.toFirstUpper»(t«attribute.name.toFirstUpper»);
						«ENDFOR»
						return u;
					} catch (NoResultException e) {
						return null;
					}
				}
			«ENDFOR»
			
			«FOR association : DomainCodeUtilities.getDetailMultipleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«var contType = DomainCodeUtilities.getType(DomainCodeUtilities.getID(container))»
				«val type = DomainCodeUtilities.getID(container).dataType.literal»
				public List<«be.name.toFirstUpper»TO> get«be.name.toFirstUpper»From«container.name.toFirstUpper»(«DomainCodeUtilities.getType(type)» «container.name.
				toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper»){
					List<«be.name.toFirstUpper»TO> «be.name.toLowerCase»s = new ArrayList<>();
					Query query;
					List<Object[]> found«be.name.toFirstUpper»s;
					try {
						query = em
								.createNativeQuery("SELECT u.* FROM «be.name.toFirstUpper» u, «container.name.toFirstUpper»«be.name.toFirstUpper» pu WHERE u.«DomainCodeUtilities.getID(be).name.toLowerCase» = pu.«be.name.toLowerCase»«DomainCodeUtilities.getID(be).name.toFirstUpper» AND pu.«container.name.toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper» = «IF contType.equals("String")»'«ENDIF»"
										+ «container.name.toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper»«IF contType.equals("String")»+"'"«ENDIF»);
						found«be.name.toFirstUpper»s = query.getResultList();
					} catch (Exception e) {
						query = em
								.createNativeQuery("SELECT u.* FROM «be.name.toFirstUpper» u, «be.name.toFirstUpper»«container.name.toFirstUpper» pu WHERE u.«DomainCodeUtilities.getID(be).name.toLowerCase» = pu.«be.name.toLowerCase»«DomainCodeUtilities.getID(be).name.toFirstUpper» AND pu.«container.name.toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper» = «IF contType.equals("String")»'«ENDIF»"
										+ «container.name.toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper»«IF contType.equals("String")»+"'"«ENDIF»);
						found«be.name.toFirstUpper»s = query.getResultList();
					}
					«be.name.toFirstUpper»TO u = null;
					«IF (attribute2 != null && !attribute2.equals(""))»PBECryptographyManager.init();«ENDIF»
					for (Object[] «be.name.toLowerCase» : found«be.name.toFirstUpper»s) {
						u = new «be.name.toFirstUpper»TO();
						«var i=0»
						«FOR attribute : be.attributes»
							«DomainCodeUtilities.getType(attribute)» t«attribute.name.toFirstUpper» = («DomainCodeUtilities.getType(attribute)») «be.name.toLowerCase»[«i»];
							«var c = i++»
						«ENDFOR»
««« Jcifuentes: Comentado
«««						«DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, null, 3)»
						«DomainCodeUtilities.contribute2Template(1, null, be, null, null, null, null, null, 3)»
						«FOR attribute : be.attributes»
						u.set«attribute.name.toFirstUpper»(t«attribute.name.toFirstUpper»);
						«ENDFOR»
						«be.name.toLowerCase»s.add(u);
					}
					return «be.name.toLowerCase»s;
				}
			«ENDFOR»
			}
«««			Esto se hace porque no se puede inyectar de nuevo el PBECryptographyManager, ya que se ha inyectado antes en el boundary y no se permiten dos inyecciones en una misma transaccion
			«IF (attribute2 != null && !attribute2.equals(""))»
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
			«ENDIF»
		«DomainCodeUtilities.endSection»
		«DomainCodeUtilities.endTemplate»
	'''
}