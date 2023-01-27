package com.sadad.portal.constant;

import java.util.ResourceBundle;

import com.sadad.portal.common.cache.PartnerListCacheSummary;

/**
 * The interface SadadDynamicDataConfiguration is used to define constants which values can be change. 
 * All the constants are defined in this interface are dynamic and read from the SadadDynamicDataConfiguration.properties. 
 * The properties file is located under profile_root/PortalServer/config folder.
 * 
 * Examples of constants are Groups defined in LDAP for SADAD, BANKS and BILLERS, or MOI BILLER
 * 
 * @author Tariq Siddiqui
 *
 */
public final class SadadDynamicDataConfiguration
{
	// Private Constructor, the class is not meant to be initialized
	private SadadDynamicDataConfiguration()
	{
		throw new IllegalStateException("SadadDynamicDataConfiguration is a utility class, should be used in a static manner.");
	}
	
	static final ResourceBundle rb = ResourceBundle.getBundle("com.sadad.SadadDynamicDataConfiguration");

	// User Creation Groups for Organisation Types
	public static final String[] GROUPS_FOR_SADAD = rb.getString("GROUPS_FOR_SADAD").split(",");
	public static final String[] GROUPS_FOR_BANK = rb.getString("GROUPS_FOR_BANK").split(",");
	public static final String[] GROUPS_FOR_BILLER = rb.getString("GROUPS_FOR_BILLER").split(",");
	public static final String[] GROUPS_FOR_AGGREGATOR = rb.getString("GROUPS_FOR_AGGREGATOR").split(",");
	
	// Groups defined for IBAN Management IBAN Maker & IBAN Checker
	public static final String GROUP_FOR_IBAN_MAKER = rb.getString("GROUP_FOR_IBAN_MAKER");
	public static final String GROUP_FOR_IBAN_CHECKER = rb.getString("GROUP_FOR_IBAN_CHECKER");
	
	// Secure Directory Server subentry used for users and groups creation, searching and replication
	public static final String SDS_SUB_ENTRY_USERS = rb.getString("SDS_SUB_ENTRY_USERS");
	public static final String SDS_SUB_ENTRY_GROUPS = rb.getString("SDS_SUB_ENTRY_GROUPS");
	
	// For fetching Payment for all MOI Billers
	public static final String[] MOI_BILLERS = PartnerListCacheSummary.MOI_BILLERS.toString().split(",");
	
	// For fetching Configuration Name for Listing Biller's Business Rules for Bills
	public static final String[] BILLER_BILL_RULES_CONFIGURATION_NAMES = rb.getString("BILLER_BILL_RULES_CONFIGURATION_NAMES").split(",");
	
	// File Upload Dynamic Configuration
	public static final String FILE_UPLOAD_URL = rb.getString("FILE_UPLOAD_URL");
	public static final String FILE_DOWNLOAD_URL = rb.getString("FILE_DOWNLOAD_URL");
	public static final int MAX_FILE_SIZE = Integer.parseInt(rb.getString("MAX_FILE_SIZE"));
	public static final int MAX_FILES_UPLOAD = Integer.parseInt(rb.getString("MAX_FILES_UPLOAD"));
}
