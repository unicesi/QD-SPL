package co.shift.qualiyatributes;

import java.util.HashMap;

import co.shift.contributors.Contribution;
import co.shift.contributors.authenticity.Authenticator;
import co.shift.contributors.authenticity.Lockout;
import co.shift.contributors.confidentiality.EncConf;
import co.shift.contributors.confidentiality.UnencConf;
import co.shift.contributors.timeexecution.FastAsyncTE;
import co.shift.contributors.timeexecution.FastSyncTE;
import co.shift.contributors.timeexecution.MediumTE;
import co.shift.contributors.timeexecution.NormalTE;


public class ImplMapping {

	public static HashMap<String, Contribution> mapping = new HashMap();

	public static void performMapping() {
		mapping.put("_r", null); // QAs root
//		mapping.put("_r_1", null); // Time Execution
		mapping.put("_r_1_3_4", new NormalTE()); // Normal
		mapping.put("_r_1_3_5", new MediumTE()); // Medium
//		mapping.put("_r_1_3_6", null); // Fast
		mapping.put("_r_1_3_6_7_8", new FastSyncTE()); // Sync
		mapping.put("_r_1_3_6_7_9", new FastAsyncTE()); // Async
//		mapping.put("_r_2", null); // Security
//		mapping.put("_r_2_10", null); // Confidentiality
		mapping.put("_r_2_10_12_13", new EncConf()); // Data Encrypted
		mapping.put("_r_2_10_12_14", new UnencConf()); // Data Unencrypted
//		mapping.put("_r_2_11", null); // Integrity and Authenticity
		mapping.put("_r_2_11_15_16", new Authenticator()); // Authorization
		mapping.put("_r_2_11_15_17", new Lockout()); // Authentication Lockout
	}
	
	public static Contribution getContributorImpl(String key){
		return mapping.get(key);
	}
}
