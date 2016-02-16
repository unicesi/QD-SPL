/**
 * 
 */
package co.edu.uniandes.mdspl.util.resource;

/**
 * @author AndreS
 *
 */
public class File {

	/** */
	private String source;
	
	/** */
	private String target;
	
	/** */
	private String support;
	
	/**
	 * 
	 * @param source
	 * @param target
	 */
	public File(String source, String target,String support) {
		this.source = source;
		this.target = target;
		this.support = support;
	}

	/**
	 * 
	 */
	public File() {
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * @return the support
	 */
	public String getSupport() {
		return support;
	}

	/**
	 * @param support the support to set
	 */
	public void setSupport(String support) {
		this.support = support;
	}
	
	/**
	 * 
	 * @param idSupport
	 * @return
	 */
	public boolean hasSupport(String idSupport){
		if(support != null){
			if(support.indexOf(idSupport) != -1){
				return true;
			}
		}
		return false;
	}
}
