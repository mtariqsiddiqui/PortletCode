/**
 * 
 */
package com.sadad.portal.common.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerListResponseType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.PartnerType;

/**
 * @author Tariq Siddiqui
 *
 */
@Deprecated
public class PartnerListCache extends PortalServiceCallHelper implements SadadListCache, Comparable<PartnerListCache>
{
	private static final String CLASS_NAME = PartnerListCache.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	public static boolean CACHE_REFRESH_FLAG = true;

	private String partnerKey;
	private String partnerName;
	private String partnerDescription;
	private String partnerStatus;
	public static String jsonBanks = new String();
	public static String jsonBillers = new String();
	private static Map<String, PartnerListCache> bankMap = new LinkedHashMap<String, PartnerListCache>();
	private static Map<String, PartnerListCache> billerMap = new LinkedHashMap<String, PartnerListCache>();

	private PartnerListCache()
	{}
	
	public PartnerListCache(String partnerKey, String partnerName, String partnerDescription, String partnerStatus)
	{
		super();
		this.partnerKey = partnerKey;
		this.partnerName = partnerName;
		this.partnerDescription = partnerDescription;
		this.partnerStatus = partnerStatus;
	}
	
	/**
	 * @return the partnerKey
	 */
	public String getPartnerKey()
	{
		return partnerKey;
	}

	/**
	 * @param partnerKey the partnerKey to set
	 */
	public void setPartnerKey(String partnerKey)
	{
		this.partnerKey = partnerKey;
	}

	/**
	 * @return the partnerName
	 */
	public String getPartnerName()
	{
		return partnerName;
	}

	/**
	 * @param partnerName the partnerName to set
	 */
	public void setPartnerName(String partnerName)
	{
		this.partnerName = partnerName;
	}

	/**
	 * @return the partnerDescription
	 */
	public String getPartnerDescription()
	{
		return partnerDescription;
	}

	/**
	 * @param partnerDescription the partnerDescription to set
	 */
	public void setPartnerDescription(String partnerDescription)
	{
		this.partnerDescription = partnerDescription;
	}

	/**
	 * @return the partnerStatus
	 */
	public String getPartnerStatus()
	{
		return partnerStatus;
	}

	/**
	 * @param partnerStatus the partnerStatus to set
	 */
	public void setPartnerStatus(String partnerStatus)
	{
		this.partnerStatus = partnerStatus;
	}

	/**
	 * @return the bankList
	 */
	public static Map<String, PartnerListCache> getBankList()
	{
		final String methodName = "getBankList";
		if (CACHE_REFRESH_FLAG || bankMap.size() == 0)
		{
			try
			{
				bankMap = new LinkedHashMap<String, PartnerListCache>();
				callGetBankList();
				CACHE_REFRESH_FLAG = false;
			}
			catch (PartnerProfileFaultMsg e)
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
		return bankMap;
	}

	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 */
	private static void callGetBankList() throws DatatypeConfigurationException, PartnerProfileFaultMsg
	{
		final String methodName = "callGetBankList";
		logger.entering(CLASS_NAME, methodName);
		
		GetBankListRequestType bankListRq = new GetBankListRequestType();
		bankListRq.setMessageHeader(getMessageHeaderType("GET_BANK_LIST"));
		// bankListRq.setActiveOnly(true);
		GetBankListResponseType bankListResponseType = partnerProfileService.getBankList(bankListRq);
		
		char comma = ',';
		char quote = '\"';
		char ob = '{';
		char cb = '}';
		char ol = '[';
		char cl = ']';
		StringBuilder jb = new StringBuilder();
		jb.append(ol);
		int id = 0;
		for (PartnerType pt : bankListResponseType.getPartner())
		{
			PartnerListCache blc = new PartnerListCache();
			blc.setPartnerKey(pt.getPartnerKey());
			blc.setPartnerName(pt.getName());
			blc.setPartnerDescription(pt.getDescription());
			blc.setPartnerStatus(pt.getStatus());
			bankMap.put(pt.getPartnerKey(), blc);
			
			if(id > 0)
				jb.append(comma);
			id = 1;
			jb.append(ob);
			jb.append("\"Code\":");
			jb.append(quote).append(pt.getPartnerKey()).append(quote).append(comma);
			jb.append("\"Name\":");
			jb.append(quote).append(pt.getName()).append(quote);
			jb.append(cb);
		}
		jb.append(cl);
		jsonBanks = jb.toString();
		
		bankMap = bankMap
			        .entrySet()
			        .stream()
			        .sorted(Map.Entry.comparingByValue())
			        .collect(Collectors.toMap(
			        		Map.Entry::getKey, 
			        		Map.Entry::getValue, 
			        		(e1, e2) -> e1, LinkedHashMap::new));
		
		logger.exiting(CLASS_NAME, methodName);
	}
	
	/**
	 * @return the billerList
	 */
	public static Map<String, PartnerListCache> getBillerList()
	{
		final String methodName = "getBillerList";
		if (CACHE_REFRESH_FLAG || billerMap.size() == 0)
		{
			try
			{
				billerMap = new LinkedHashMap<String, PartnerListCache>();
				callGetBillerList();
				CACHE_REFRESH_FLAG = false;
			}
			catch (PartnerProfileFaultMsg e)
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
		return billerMap;	
	}


	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 */
	private static void callGetBillerList() throws DatatypeConfigurationException, PartnerProfileFaultMsg
	{
		final String methodName = "callGetBillerList";
		logger.entering(CLASS_NAME, methodName);

		GetBillerListRequestType billerListRq = new GetBillerListRequestType();
		billerListRq.setMessageHeader(getMessageHeaderType("GET_BILLER_LIST"));
		// billerListRq.setActiveOnly(true);
		GetBillerListResponseType billerListResponseType = partnerProfileService.getBillerList(billerListRq);

		char comma = ',';
		char quote = '\"';
		char ob = '{';
		char cb = '}';
		char ol = '[';
		char cl = ']';
		StringBuilder jb = new StringBuilder();
		jb.append(ol);
		int id = 0;
		for (PartnerType pt : billerListResponseType.getPartner())
		{
			PartnerListCache plc = new PartnerListCache();
			plc.setPartnerKey(pt.getPartnerKey());
			plc.setPartnerName(pt.getName());
			plc.setPartnerDescription(pt.getDescription());
			plc.setPartnerStatus(pt.getStatus());
			
			 billerMap.put(pt.getPartnerKey(), plc);

			if(id > 0)
				jb.append(comma);
			id = 1;
			jb.append(ob);
			jb.append("\"Code\":");
			jb.append(quote).append(pt.getPartnerKey()).append(quote).append(comma);
			jb.append("\"Name\":");
			jb.append(quote).append(pt.getName()).append(quote);
			jb.append(cb);
		}
		jb.append(cl);
		jsonBillers = jb.toString();
		
		billerMap = billerMap
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(e1, e2) -> e1, LinkedHashMap::new));
		
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * Calls to update the cache object of Partner type, the returned object should be added to the portal application cache, 
	 * other wise the applcition cache would not be changed.
	 *  
	 * @param key - Partner key
	 * @param name - name of the partner 
	 * @param desc - Description of the partner
	 * @param status - Status of the partner
	 * @param listType - partner type, possible values are PortalConstant.LOOKUP_BANK_LIST and PortalConstant.LOOKUP_BILLER_LIST
	 * @return - returns the update PartnerListCache object, whcih need to be added in application session
	 */
	public static Map<String, PartnerListCache> updatePartnerListCache(PartnerListCache uplc, String listType)
	{
		// Fix for defect 3510
		char comma = ',';
		char quote = '\"';
		char ob = '{';
		char cb = '}';
		char ol = '[';
		char cl = ']';
		StringBuilder jb = new StringBuilder();
		jb.append(ol);
		int id = 0;
		
		PartnerListCache plc = new PartnerListCache();
		plc.setPartnerKey(uplc.getPartnerKey());
		plc.setPartnerName(uplc.getPartnerName());
		plc.setPartnerDescription(uplc.getPartnerDescription());
		plc.setPartnerStatus(uplc.getPartnerStatus());
		
		if(listType.equalsIgnoreCase(PortalConstant.LOOKUP_BANK_LIST))
		{
			bankMap.put(plc.getPartnerKey(), plc);
			bankMap = bankMap
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
							(e1, e2) -> e1, LinkedHashMap::new));
			
			// Fix for defect 3510
			for(Map.Entry<String, PartnerListCache> entry : bankMap.entrySet())
			{
				if(id > 0)
					jb.append(comma);
				id = 1;
				jb.append(ob);
				jb.append("\"Code\":");
				jb.append(quote).append(entry.getValue().getPartnerKey()).append(quote).append(comma);
				jb.append("\"Name\":");
				jb.append(quote).append(entry.getValue().getPartnerName()).append(quote);
				jb.append(cb);
			}
			jb.append(cl);
			jsonBanks = jb.toString(); // End of fix defect 3510

			return bankMap;
		}
		if(listType.equalsIgnoreCase(PortalConstant.LOOKUP_BILLER_LIST))
		{
			billerMap.put(plc.getPartnerKey(), plc);
			billerMap = billerMap
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
							(e1, e2) -> e1, LinkedHashMap::new));
			
			// Fix for defect 3510
			for(Map.Entry<String, PartnerListCache> entry : billerMap.entrySet())
			{
				if(id > 0)
					jb.append(comma);
				id = 1;
				jb.append(ob);
				jb.append("\"Code\":");
				jb.append(quote).append(entry.getValue().getPartnerKey()).append(quote).append(comma);
				jb.append("\"Name\":");
				jb.append(quote).append(entry.getValue().getPartnerName()).append(quote);
				jb.append(cb);
			}
			jb.append(cl);
			jsonBillers = jb.toString(); // End of fix defect 3510
			
			return billerMap;
		}
		return null;
	}

	@Override
	public int compareTo(PartnerListCache o)
	{
		return this.partnerName.compareToIgnoreCase(o.partnerName);
	}
}