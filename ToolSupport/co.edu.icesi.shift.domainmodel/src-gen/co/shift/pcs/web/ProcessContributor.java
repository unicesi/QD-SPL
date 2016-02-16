package co.shift.pcs.web;

public interface ProcessContributor {

	/**
	 * Contributes a process using the specified data (optional).
	 * @param data required by the extension process (optional)
	 * @throws Exception if there was a problem extending the process
	 */
	public void contributeProcess(Object data) throws Exception;
}
