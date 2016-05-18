package co.shift.generators.domain;

@SuppressWarnings("all")
public class DomainParams {
  public static String GENERATION_DIR = "";
  
  public static String SRC_DIR = "";
  
  public final static String selectedQAsConfig = "1,0,0,0;1,0;1,1";
  
  public final static String QA_ROOT = "_r";
  
  public final static String VP_TIME_EXEC = "_r_1";
  
  public final static String VA_NORMAL_TE = "_r_1_3_4";
  
  public final static String VA_MEDIUM_TE = "_r_1_3_5";
  
  public final static String VP_FAST_TE = "_r_1_3_6";
  
  public final static String VA_FASTSYNC_TE = "_r_1_3_6_7_8";
  
  public final static String VA_FASTASYNC_TE = "_r_1_3_6_7_9";
  
  public final static String VP_SECURITY = "_r_2";
  
  public final static String VP_CONFIDENTIALITY = "_r_2_10";
  
  public final static String VA_DATA_ENCRYPTED = "_r_2_10_12_13";
  
  public final static String VA_DATA_UNENCRYPTED = "_r_2_10_12_14";
  
  public final static String VP_INTEGRITY_AUTHENTICITY = "_r_2_11";
  
  public final static String VA_AUTHORIZATION = "_r_2_11_15_16";
  
  public final static String VA_AUTHENTIC_LOCKOUT = "_r_2_11_15_17";
  
  public final static String CONF_NORMAL_TE = "1,0,0,0;_,_;_,_";
  
  public final static String CONF_MEDIUM_TE = "0,1,0,0;_,_;_,_";
  
  public final static String CONF_FASTSYNC_TE = "0,0,1,0;_,_;_,_";
  
  public final static String CONF_FASTASYNC_TE = "0,0,0,1;_,_;_,_";
  
  public final static String CONF_DATA_ENCRYPTED = "_,_,_,_;0,1;_,_";
  
  public final static String CONF_DATA_UNENCRYPTED = "_,_,_,_;1,0;_,_";
  
  public final static String CONF_AUTHORIZATION = "_,_,_,_;_,_;1,_";
  
  public final static String CONF_AUTHENTIC_LOCKOUT = "_,_,_,_;_,_;_,1";
  
  public final static String TPL_ROOT = "root";
  
  public final static String SECTION_BINTERFACE = "BusinessInterface";
  
  public final static String SECTION_BIMPL = "BusinessImplementation";
  
  public final static String SECTION_WEB_IMPL = "WebImpl";
  
  public final static String SECTION_WEB_ATTR = "WebAtt";
  
  public final static String SECTION_WEB_IMPORT = "WebImport";
  
  public final static String SECTION_BIMPORT = "Imports";
  
  public final static String SECTION_BATTR = "Attributes";
  
  public final static String SECTION_GENERATE = "Generate";
}
