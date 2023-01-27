/**
 * 
 */
package com.sadad.portal.common.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;

/**
 * @author Tariq Siddiqui
 *
 */
public class ReferenceDataListCache extends PortalServiceCallHelper implements SadadListCache, Comparable<ReferenceDataListCache>
{
	private static final String CLASS_NAME = ReferenceDataListCache.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);
	
	private static final String NAME = "\"name\":";
	private static final String STATUS = "\"status\":";
	private static final char COMMA = ',';
	private static final char QUOTE = '\"';
	private static final char OB = '{';
	private static final char CB = '}';
	private static final char OL = '[';
	private static final char CL = ']';

	public static boolean CACHE_REFRESH_FLAG = true;

	private String code;
	private String description;
	private String status;
	public static String jsonAccountTypes = "";
	public static String jsonAccessChannels = "";
	private static Map<String, ReferenceDataListCache> districtMap = new LinkedHashMap<>();
	private static int districtListHashCode = districtMap.hashCode();
	private static Map<String, ReferenceDataListCache> accessChannelMap = new LinkedHashMap<>();
	private static int accessChannelListHashCode = accessChannelMap.hashCode();
	private static Map<String, ReferenceDataListCache> accountTypeMap = new LinkedHashMap<>();
	private static int accountTypeListHashCode = accountTypeMap.hashCode();

	private ReferenceDataListCache()
	{}

	public ReferenceDataListCache(String code, String description, String status)
	{
		super();
		this.code = code;
		this.description = description;
		this.status = status;
	}

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

	public static int getDistrictListHashCode()
	{
		return districtListHashCode;
	}

	public static int getAccessChannelListHashCode()
	{
		return accessChannelListHashCode;
	}

	public static int getAccountTypeListHashCode()
	{
		return accountTypeListHashCode;
	}

	public static Map<String, ReferenceDataListCache> getDistrictList()
	{
		final String methodName = "getDistrictList";
		if (CACHE_REFRESH_FLAG || districtMap.size() == 0)
		{
			try
			{
				districtMap = new HashMap<>();
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
		districtListHashCode = districtMap.hashCode();
		return districtMap;	
	}	
	
	/**
	 * @return the accessChannelMap
	 */
	public static Map<String, ReferenceDataListCache> getAccessChannelList()
	{
		final String methodName = "getAccessChannelList";
		if (CACHE_REFRESH_FLAG || accessChannelMap.size() == 0)
		{
			try
			{
				accessChannelMap = new HashMap<>();
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
		accessChannelListHashCode = accessChannelMap.hashCode();
		return accessChannelMap;	
	}
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 * @throws ReferenceDataFault 
	 */
	private static void callGetDistrictCodeList() throws DatatypeConfigurationException, ReferenceDataFault
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
		districtMap = districtMap
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(e1, e2) -> e1, LinkedHashMap::new));		
		logger.exiting(CLASS_NAME, methodName);
	}	
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 * @throws ReferenceDataFault 
	 */
	private static void callGetAccessChannelList() throws DatatypeConfigurationException, ReferenceDataFault
	{
		final String methodName = "callAccessChannelList";
		logger.entering(CLASS_NAME, methodName);

		ListAccessChannelRqType accessListRq = new ListAccessChannelRqType();
		accessListRq.setMessageHeader(getMessageHeaderType("GET_ACCESS_CHANNEL_LIST"));
		ListAccessChannelRsType accessListRs = referenceDataService.listAccessChannel(accessListRq);

		StringBuilder jb = new StringBuilder();
		jb.append(OL);
		int id = 0;
		for (AccessChannelType act : accessListRs.getAccessChannel())
		{
			ReferenceDataListCache dlc = new ReferenceDataListCache();
			dlc.setCode(act.getAccessChannel());
			dlc.setDescription(act.getDescription());
			dlc.setStatus(act.getStatus().value());
			accessChannelMap.put(act.getAccessChannel(), dlc);
			
			if(id > 0)
				jb.append(COMMA);
			id = 1;
			jb.append(OB);
			jb.append(NAME);
			jb.append(QUOTE).append(act.getAccessChannel()).append(QUOTE).append(COMMA);
			jb.append(STATUS);
			jb.append(QUOTE).append(act.getStatus().value()).append(QUOTE);
			jb.append(CB);
		}
		jb.append(CL);
		jsonAccessChannels = jb.toString();
		
		accessChannelMap = accessChannelMap
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(e1, e2) -> e1, LinkedHashMap::new));
		
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * 
	 * @return accountTypeList
	 */
	public static Map<String, ReferenceDataListCache> getAccountTypeList()
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
		accountTypeListHashCode = accountTypeMap.hashCode();
		return accountTypeMap;	
	}	

	/**
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws ReferenceDataFault
	 * @throws PartnerProfileFaultMsg
	 */
	private static void callGetAccountTypeList() throws DatatypeConfigurationException, ReferenceDataFault
	{
		final String methodName = "callGetAccountTypeList";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListAccountTypeRqType accountTypeRq = new ListAccountTypeRqType();
			accountTypeRq.setMessageHeader(getMessageHeaderType("GET_ACCOUNT_TYPE_LIST"));
			ListAccountTypeRsType accountTypeRs = referenceDataService.listAccountType(accountTypeRq);

			StringBuilder jb = new StringBuilder();
			jb.append(OL);
			int id = 0;
			
			for (AccountTypeType pt : accountTypeRs.getAccountType())
			{
				ReferenceDataListCache dlc = new ReferenceDataListCache();
				dlc.setCode(pt.getServiceType());
				dlc.setDescription(pt.getDescription());
				dlc.setStatus(pt.getStatus().toString());
				accountTypeMap.put(pt.getServiceType(), dlc);
				
				if(id > 0)
					jb.append(COMMA);
				id = 1;
				jb.append(OB);
				jb.append(NAME);
				jb.append(QUOTE).append(pt.getServiceType()).append(QUOTE).append(COMMA);
				jb.append(STATUS);
				jb.append(QUOTE).append(pt.getStatus().value()).append(QUOTE);
				jb.append(CB);
			}
			jb.append(CL);
			jsonAccountTypes = jb.toString();
			
			accountTypeMap = accountTypeMap
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
							(e1, e2) -> e1, LinkedHashMap::new));
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
	
	/**
	 * Calls to update the cache object of Reference Data type, the returned object should be added to the portal application cache, 
	 * other wise the applcition cache would not be changed.
	 * 
	 * @param code
	 *            - code of the reference data object
	 * @param desc
	 *            - description of the reference data object
	 * @param status
	 *            - status of the reference data object
	 * @param listType
	 *            - partner type, possible values are PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST, 
	 *            PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST and PortalConstant.LOOKUP_DISTRICT_LIST
	 * @return - returns the update ReferenceDataListCache object, whcih need to be added in application session
	 */
	public static Map<String, ReferenceDataListCache> updateReferenceDataListCache(ReferenceDataListCache urdlc, String listType)
	{
		StringBuilder jb = new StringBuilder();
		jb.append(OL);
		int id = 0;
		
		ReferenceDataListCache rdlc = new ReferenceDataListCache();
		rdlc.setCode(urdlc.getCode());
		rdlc.setDescription(urdlc.getDescription());
		rdlc.setStatus(urdlc.getStatus());
		
		if(listType.equalsIgnoreCase(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST))
		{
			accessChannelMap.put(rdlc.getCode(), rdlc);
			accessChannelMap = accessChannelMap
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
							(e1, e2) -> e1, LinkedHashMap::new));
			
			// Payment mismatch CR  
			for(Map.Entry<String, ReferenceDataListCache> entry : accessChannelMap.entrySet())
			{
				if(id > 0)
					jb.append(COMMA);
				id = 1;
				jb.append(OB);
				jb.append(NAME);
				jb.append(QUOTE).append(entry.getValue().getCode()).append(QUOTE).append(COMMA);
				jb.append(STATUS);
				jb.append(QUOTE).append(entry.getValue().getStatus()).append(QUOTE);
				jb.append(CB);
			}
			jb.append(CL);
			jsonAccessChannels = jb.toString(); // Payment mismatch CR

			accessChannelListHashCode = accessChannelMap.hashCode();
			return accessChannelMap;
		}
		if(listType.equalsIgnoreCase(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST))
		{
			accountTypeMap.put(rdlc.getCode(), rdlc);
			accountTypeMap = accountTypeMap
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
							(e1, e2) -> e1, LinkedHashMap::new));
			
			// Payment mismatch CR  
			for(Map.Entry<String, ReferenceDataListCache> entry : accountTypeMap.entrySet())
			{
				if(id > 0)
					jb.append(COMMA);
				id = 1;
				jb.append(OB);
				jb.append(NAME);
				jb.append(QUOTE).append(entry.getValue().getCode()).append(QUOTE).append(COMMA);
				jb.append(STATUS);
				jb.append(QUOTE).append(entry.getValue().getStatus()).append(QUOTE);
				jb.append(CB);
			}
			jb.append(CL);
			jsonAccountTypes = jb.toString(); // Payment mismatch CR

			accountTypeListHashCode = accountTypeMap.hashCode();
			return accountTypeMap;
		}
		if(listType.equalsIgnoreCase(PortalConstant.LOOKUP_DISTRICT_LIST))
		{
			districtMap.put(rdlc.getCode(), rdlc);
			districtMap = districtMap
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
							(e1, e2) -> e1, LinkedHashMap::new));
			
			districtListHashCode = districtMap.hashCode();
			return districtMap;
		}
		return Collections.emptyMap();
	}	

	@Override
	public int compareTo(ReferenceDataListCache o)
	{
		return this.code.compareToIgnoreCase(o.code);
	}
}