package com.sadad.portal.constant;

/**
 * @author Tariq Siddiqui
 *
 */
public final class PortalConstant
{
	// Private Constructor, the class is not meant to be initialized
	private PortalConstant()
	{
		throw new IllegalStateException("PortalConstant is a utility class, should be used in a static manner.");
	}
	
	/// Global variable declared for look up service like bank, biller, access channel
	public static final String LOOKUP_BILLER_ONLY_LIST = "BillerOnlyList";
	public static final String LOOKUP_BILLER_LIST = "BillerList";
	public static final String LOOKUP_SUBBILLER_LIST = "SubBillerList";
	public static final String LOOKUP_BANK_LIST = "BankList";
	public static final String LOOKUP_AGGREGATOR_LIST = "AggregatorList";
	public static final String LOOKUP_AGGREGATOR_BILLER_LIST = "AggregatorBillerList";

	public static final String JSON_BANK_QUERY_STRING = "32c7fcd2cd9c32b19841d743dc09d56f";
	public static final String JSON_BILLER_QUERY_STRING = "e13b5b1608ad566f94ba9fe7849aca38";
	public static final String JSON_BILLER_ONLY_QUERY_STRING = "76cff8fd2def7b0465d7f1979eb99cd0";
	public static final String JSON_SUBBILLER_QUERY_STRING = "c7993c30bbe57b9c54db07bdbb180e85"; 
	public static final String JSON_AGGREGATOR_QUERY_STRING = "43e028dfdaab976ddd27cc17c457542f";
	public static final String JSON_AGGREGATOR_BILLER_QUERY_STRING = "a5e383e5e7a87a6844dd02fa04944c35";

	public static final String JSON_MIXIN_SALT = "D5A9ad52F010338zZ8d0D9A55eEA5eb9";
	public static final String JSON_BANK_LIST = "jsonBanks";
	public static final String JSON_BILLER_LIST = "jsonBillers";
	public static final String JSON_BILLER_ONLY_LIST = "jsonBillersOnly";
	public static final String JSON_SUBBILLER_LIST = "jsonSubBillers";
	public static final String JSON_AGGREGATOR_LIST = "jsonAggregator";
	public static final String JSON_AGGREGATOR_BILLER_LIST = "jsonAggregatorBillers";
	public static final String LOOKUP_DISTRICT_LIST = "DistrictList";
	public static final String LOOKUP_ACCESS_CHANNEL_LIST = "AccessChannelList";
	public static final String LOOKUP_ACCOUNT_TYPE_LIST = "AccountTypeList";
	public static final String JSON_ACCESS_CHANNEL_LIST = "jsonAccessChannels";
	public static final String JSON_ACCOUNT_TYPE_LIST = "jsonAccountTypes";
	
	public static final String LOOKUP_BANK_RULES_LIST = "BankRulesList";
	public static final String LOOKUP_BILLER_RULES_LIST = "BillerRulesList";
	public static final String LOOKUP_SADAD_RULES_LIST = "SadadRulesList";
	public static final String LOOKUP_AGGREGATOR_RULES_LIST = "AggregatorRulesList";
	public static final String LOOKUP_SUBBILLER_RULES_LIST = "SubBillerRulesList";
	
	// Used to refresh all partners portal cache (Banks, biller, subbiller, aggregator etc.) 
	public static final String REFRESH_PARTNER_CACHE = "REFRESH_PARTNER_CACHE";
	
	public static final String SADAD_ADMIN_DATA = "SadadAdminData";

	public static final String PARTNER_TYPE_BANK = "bank";
	public static final String PARTNER_TYPE_BILLER = "biller";
	public static final String PARTNER_TYPE_SADAD = "sadad";
	public static final String PARTNER_TYPE_AGGREGATOR = "aggregator";
	public static final String PARTNER_TYPE_SUBBILLER= "subbiller";

	//// Constants for Portal Page IDs
	public static final String SADAD_HOME_PAGE = "ibm.portal.Home";
	public static final String SADAD_ACCEPT_TERMS_PAGE = "sadad.page.termsandconditionslogin";
	public static final String SADAD_CHANGE_PASSWORD_AT_LOGIN_PAGE = "sadad.page.passwordchange";

	/// Constants for general error and info messages
	public static final String SADAD_GENERIC_ERROR = "sadad-generic-error";
	public static final String SADAD_GENERIC_INFO = "sadad-generic-info";
	public static final String SADAD_COMMOM_RESOURCE = "nl.SadadCommon";

	/// Constant variable for Screen navigation
	public static final String REFRESH = "refresh";
	public static final String NEXT = "next";
	public static final String BACK = "back";
	public static final String FINISH = "finish";
	public static final String GO_BACK = "_go_back";
	
	/// Constant variable for Partner Status ACTIVE or INACTIVE
	public static final String STATUS_ACTIVE = "ACTIVE";
	public static final String STATUS_INACTIVE = "INACTIVE";
	public static final String STATUS_PENDING = "PENDING";
	public static final String STATUS_REJECTED = "REJECTED";
	public static final String STATUS_CLOSED = "CLOSED";
	
	/// Constant variable for Maker/Checker workflow actions 
	public static final String ACTION_CREATE = "CREATE";
	public static final String ACTION_ACTIVATE = "ACTIVATE";
	public static final String ACTION_DEACTIVATE = "DEACTIVATE";
	public static final String ACTION_APPROVE = "APPROVE";
	public static final String ACTION_REJECT = "REJECT";

	/// Use to access Portlet Session bean Object
	public static final String PORTLET_SESSION_BEAN = "psb";

	public static final String APPLICATION_SESSION_BEAN = "asb";

	/// Use to access Application Session bean Object
	public static final String USER_INFO_APPLICATION_SESSION = "uias";

	/// Use to access Global Session bean Object
	public static final String GLOBAL_SESSION_BEAN = "gsb";

	public static final String MESSAGE_TYPE = "messageType";
	public static final String DISPLAY_MESSAGE = "displayMessage";

	/// Use as the initial for all request parameter sends to server from JSP
	/// All request parameter which starts with params_ will be populate in SessionBean object
	/// based on criteria startsWith("param_"), if the same field is present there in SessionBean
	public static final String REQUEST_PARAMETER_INITIALS = "param_";

	// Use to define the queue and queue connection factory in SadadServicesEndPointUrls.properties file
	public static final String JNDI_QUEUE_PREFIX = "_QUEUE";
	public static final String JNDI_QUEUE_CONNECTION_FACTORY_PREFIX = "_QUEUE_CONNECTION_FACTORY";
	
	// Use to generate MD5Hash for fileToken with this mixin Salt 
	public static final String FILE_TOKEN_MIXIN_SALT = "b7e69802d2bZa7310f70f2X620Y6ee02b0949315aG36ae6178079bbeTf236f70";
	
	// JNDI Name for DynaCache DistributedMap, use to hold the Portal Cache objects
	public static final String JNDI_DISTRIBUTED_MAP_CACHE = "services/cache/Sadad/LookupData";
}