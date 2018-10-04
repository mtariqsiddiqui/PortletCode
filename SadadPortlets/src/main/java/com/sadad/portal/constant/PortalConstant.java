package com.sadad.portal.constant;

public interface PortalConstant
{
	/// Global variable declared for look up service like bank, biller, access channel
	public static final String LOOKUP_BILLER_LIST = "BillerList";
	public static final String LOOKUP_BANK_LIST = "BankList";
	public static final String LOOKUP_DISTRICT_LIST = "DistrictList";
	public static final String LOOKUP_ACCESS_CHANNEL_LIST = "AccessChannelList";
	public static final String LOOKUP_ACCOUNT_TYPE_LIST = "AccountTypeList";
	public static final String SADAD_ADMIN_DATA = "SadadAdminData";
	
	/// Constants for general error and info messages   
	public static final String SADAD_GENERIC_ERROR = "sadad-generic-error";
	public static final String SADAD_GENERIC_INFO = "sadad-generic-info";
	public static final String SADAD_COMMOM_RESOURCE = "nl.SadadCommon";
	
	/// Constant variable for Screen navigation
	public static final String NEXT = "next";
	public static final String BACK = "back";
	public static final String FINISH = "finish";

	/// Use to access Portlet Session bean Object
	public static final String PORTLET_SESSION_BEAN = "psb";
	
	/// Use to access Application Session bean Object
	public static final String APPLICATION_SESSION_BEAN = "asb";

	/// Use to access Global Session bean Object
	public static final String GLOBAL_SESSION_BEAN = "gsb";
}