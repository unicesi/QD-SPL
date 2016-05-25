package co.shift.generators.domain

//import co.shift.generators.domain.DomainCodeSetup

//import org.eclipse.ui.handlers.HandlerUtil

class DomainParams {
	
	public static String GENERATION_DIR = ""; // = "/Users/daviddurangiraldo/Desktop/"
	public static String SRC_DIR = ""; // = "/Users/daviddurangiraldo/Desktop/"

//Inicio jcifuentes
// Constante para configuración de QAs por defecto. Esta dependerá en realidad de
// los qas seleccionados por el configurador de qas
// Note: 0: Unselected, 1: Selected
// VP delimited by ";". Variants delimited by ","
// Note: "NormalTE,MediumTE,FastSyncTE,FastAsyncTE;Encrypted,Unencrypted;Authorization,AuthenticLockout"
	public val final static selectedQAsConfig = "1,0,0,0;1,0;1,1";

//Se crean constantes para mnemotecnia de los códigos del QA Config
	public val final static QA_ROOT = "_r";
	public val final static VP_TIME_EXEC = "_r_1";
	public val final static VA_NORMAL_TE = "_r_1_3_4";
	public val final static VA_MEDIUM_TE = "_r_1_3_5";

	public val final static VP_FAST_TE = "_r_1_3_6";
	public val final static VA_FASTSYNC_TE = "_r_1_3_6_7_8";
	public val final static VA_FASTASYNC_TE = "_r_1_3_6_7_9";

	public val final static VP_SECURITY = "_r_2";
	public val final static VP_CONFIDENTIALITY = "_r_2_10";

	public val final static VA_DATA_ENCRYPTED = "_r_2_10_12_13";
	public val final static VA_DATA_UNENCRYPTED = "_r_2_10_12_14";
	public val final static VP_INTEGRITY_AUTHENTICITY = "_r_2_11";

	public val final static VA_AUTHORIZATION = "_r_2_11_15_16";
	public val final static VA_AUTHENTIC_LOCKOUT = "_r_2_11_15_17";
	
// Configuraciones actuales disponibles
	public val final static CONF_NORMAL_TE         = "101"//"1,0,0,0;_,_;_,_";//Normal TE selected
	public val final static CONF_MEDIUM_TE         = "102"//"0,1,0,0;_,_;_,_";//Medium TE selected
	public val final static CONF_FASTSYNC_TE       = "103"//"0,0,1,0;_,_;_,_";//Fast Sync selected
	public val final static CONF_FASTASYNC_TE      = "104"//"0,0,0,1;_,_;_,_";//Fast Async seleted

	public val final static CONF_DATA_ENCRYPTED    = "105"//"_,_,_,_;0,1;_,_";//Encrypted selected
	public val final static CONF_DATA_UNENCRYPTED  = "106"//"_,_,_,_;1,0;_,_";//Unencrypted selected

	public val final static CONF_AUTHORIZATION     = "107"//"_,_,_,_;_,_;1,_"; //Authenticator selected
	public val final static CONF_AUTHENTIC_LOCKOUT = "108"//"_,_,_,_;_,_;_,1";//Lockout selected
	
	//Templates
	public val final static TPL_ROOT = "1" //root template
	//...Add templates as needed
	
	//Template sections (podrían inicializarse con números)
	public val final static SECTION_BINTERFACE = "1" //"BusinessInterface";
	public val final static SECTION_BIMPL = "2" //"BusinessImplementation";
	public val final static SECTION_WEB_IMPL = "3" //"WebImpl";
	public val final static SECTION_WEB_ATTR = "4" //"WebAtt";
	public val final static SECTION_WEB_IMPORT = "5" //"WebImport";
	public val final static SECTION_BIMPORT = "6" //"Imports";
	public val final static SECTION_BATTR = "7" //"Attributes";
	public val final static SECTION_GENERATE = "8" //"Generate";

}
