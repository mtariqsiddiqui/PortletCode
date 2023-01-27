/**
 * 
 */
package com.sadad.portal.common.cache;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.schema.referencedata._1.AccessChannelType;
import com.sadad.ebpp.schema.referencedata._1.AccountTypeType;
import com.sadad.ebpp.schema.referencedata._1.DistrictCodeType;
import com.sadad.ebpp.schema.referencedata._1.ListAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccessChannelRsType;
import com.sadad.ebpp.schema.referencedata._1.ListAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccountTypeRsType;
import com.sadad.ebpp.schema.referencedata._1.ListDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.ListDistrictCodeRsType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataFault;
import com.sadad.portal.helper.PortalServiceCallHelper;

/**
 * @author Tariq Siddiqui
 *
 */
public class ReferenceDataListCache extends PortalServiceCallHelper
{
	private static final String CLASS_NAME = ReferenceDataListCache.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	public static boolean CACHE_REFRESH_FLAG = true;

	private String code;
	private String description;
	private String status;
	private static HashMap<String, ReferenceDataListCache> districtMap = new HashMap<String, ReferenceDataListCache>();
	private static HashMap<String, ReferenceDataListCache> accessChannelMap = new HashMap<String, ReferenceDataListCache>();
	private static HashMap<String, ReferenceDataListCache> accountTypeMap = new HashMap<String, ReferenceDataListCache>();

	private ReferenceDataListCache()
	{}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
	
	/**
	 * @return the districtList
	 */
	public static HashMap<String, ReferenceDataListCache> getDistrictList()
	{
		final String methodName = "getDistrictList";
		if (CACHE_REFRESH_FLAG || districtMap.size() == 0)
		{
			try
			{
				districtMap = new HashMap<String, ReferenceDataListCache>();
				callGetDistrictCodeList();
				CACHE_REFRESH_FLAG = false;
			}
			catch (ReferenceDataFault e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (DatatypeConfigurationException e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (Exception e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
		}
		return districtMap;	
	}	
	
	/**
	 * @return the accessChannelMap
	 */
	public static HashMap<String, ReferenceDataListCache> getAccessChannelList()
	{
		final String methodName = "getAccessChannelList";
		if (CACHE_REFRESH_FLAG || accessChannelMap.size() == 0)
		{
			try
			{
				accessChannelMap = new HashMap<String, ReferenceDataListCache>();
				callGetAccessChannelList();
				CACHE_REFRESH_FLAG = false;
			}
			catch (ReferenceDataFault e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (DatatypeConfigurationException e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (Exception e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
		}
		return accessChannelMap;	
	}
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 * @throws ReferenceDataFault 
	 */
	private static void callGetDistrictCodeList() throws DatatypeConfigurationException, ReferenceDataFault, PartnerProfileFaultMsg
	{
		final String methodName = "callDistrictCodeList";
		logger.entering(CLASS_NAME, methodName);

		ListDistrictCodeRqType dclReq = new ListDistrictCodeRqType();
		dclReq.setMessageHeader(getMessageHeaderType("GET_DISTRICT_CODE_LIST"));
		ListDistrictCodeRsType dclRes = referenceDataService.listDistrictCode(dclReq);

		for (DistrictCodeType dct : dclRes.getDistrictCode())
		{
			ReferenceDataListCache dlc = new ReferenceDataListCache();
			dlc.setCode(dct.getDistrictCode());
			dlc.setDescription(dct.getDescription());
			dlc.setStatus(dct.getStatus().toString());
			districtMap.put(dct.getDistrictCode(), dlc);
		}
		logger.exiting(CLASS_NAME, methodName);
	}	
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 * @throws ReferenceDataFault 
	 */
	private static void callGetAccessChannelList() throws DatatypeConfigurationException, ReferenceDataFault, PartnerProfileFaultMsg
	{
		final String methodName = "callAccessChannelList";
		logger.entering(CLASS_NAME, methodName);

		ListAccessChannelRqType accessListRq = new ListAccessChannelRqType();
		accessListRq.setMessageHeader(getMessageHeaderType("GET_ACCESS_CHANNEL_LIST"));
		ListAccessChannelRsType accessListRs = referenceDataService.listAccessChannel(accessListRq);

		for (AccessChannelType pt : accessListRs.getAccessChannel())
		{
			ReferenceDataListCache dlc = new ReferenceDataListCache();
			dlc.setCode(pt.getAccessChannel());
			dlc.setDescription(pt.getDescription());
			dlc.setStatus(pt.getStatus().toString());
			accessChannelMap.put(pt.getAccessChannel(), dlc);
		}
		logger.exiting(CLASS_NAME, methodName);
	}
	
	
	public static HashMap<String, ReferenceDataListCache> getAccountTypeList()
	{
		final String methodName = "getAccountTypeList";
		if (CACHE_REFRESH_FLAG || accountTypeMap.size() == 0)
		{
			try
			{
				accountTypeMap = new HashMap<String, ReferenceDataListCache>();
				callGetAccountTypeList();
				CACHE_REFRESH_FLAG = false;
			}
			catch (ReferenceDataFault e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (DatatypeConfigurationException e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (Exception e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
		}
		return accountTypeMap;	
	}	

	/**
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws ReferenceDataFault
	 * @throws PartnerProfileFaultMsg
	 */
	private static void callGetAccountTypeList() throws DatatypeConfigurationException, ReferenceDataFault, PartnerProfileFaultMsg
	{
		final String methodName = "callAccessChannelList";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListAccountTypeRqType accountTypeRq = new ListAccountTypeRqType();
			accountTypeRq.setMessageHeader(getMessageHeaderType("GET_ACCOUNT_TYPE_LIST"));
			ListAccountTypeRsType accountTypeRs = referenceDataService.listAccountType(accountTypeRq);
			for (AccountTypeType pt : accountTypeRs.getAccountType())
			{
				ReferenceDataListCache dlc = new ReferenceDataListCache();
				dlc.setCode(pt.getServiceType());
				dlc.setDescription(pt.getDescription());
				dlc.setStatus(pt.getStatus().toString());
				accountTypeMap.put(pt.getServiceType(), dlc);
			}
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, "callAccessChannelList", e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("ReferenceDataListCache");
		sb.append(" [code=").append(code)
			.append(", description=").append(description)
			.append(", status=").append(status)
			.append(']');

		return sb.toString();
	}
}