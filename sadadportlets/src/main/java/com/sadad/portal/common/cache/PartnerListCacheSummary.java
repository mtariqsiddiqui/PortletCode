/**
 * 
 */
package com.sadad.portal.common.cache;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPartnerSummaryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPartnerSummaryResponseType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.PartnerInfoType;
import com.sadad.scm.common._1.PartnerTypeEnums;

/**
 * @author Tariq Siddiqui
 *
 */
public class PartnerListCacheSummary extends PortalServiceCallHelper implements SadadListCache, Comparable<PartnerListCacheSummary>
{
	private static final String CLASS_NAME = PartnerListCacheSummary.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);
	
	private static final String CODE = "\"Code\":";
	private static final String NAME = "\"Name\":";
	private static final char COMMA = ',';
	private static final char QUOTE = '\"';
	private static final char OB = '{';
	private static final char CB = '}';
	private static final char OL = '[';
	private static final char CL = ']';
	
	public static boolean CACHE_REFRESH_FLAG = true;

	private String partnerKey;
	private String partnerName;
	private String partnerStatus;
	private String partnerDescription;
	public static String jsonBanks = "";
	public static String jsonBillers = "";
	public static String jsonBillersOnly = "";
	public static String jsonSubBillers = "";
	public static String jsonAggregators = "";
	public static String jsonAggregatorBillers = new String();
	public static StringBuilder MOI_BILLERS = new StringBuilder(); // comma separated list of MOI billers
	private static Map<String, PartnerListCacheSummary> bankMap = new LinkedHashMap<>();
	private static int bankListHashCode = bankMap.hashCode();
	private static Map<String, PartnerListCacheSummary> billerMap = new LinkedHashMap<>();
	private static int billerListHashCode = billerMap.hashCode();
	private static Map<String, PartnerListCacheSummary> billerOnlyMap = new LinkedHashMap<>();
	private static int billerOnlyListHashCode = billerOnlyMap.hashCode();
	private static Map<String, PartnerListCacheSummary> subBillerMap = new LinkedHashMap<>();
	private static int subBillerListHashCode = subBillerMap.hashCode();
	private static Map<String, PartnerListCacheSummary> aggregatorMap = new LinkedHashMap<>();
	private static int aggregatorListHashCode = aggregatorMap.hashCode();
	private static Map<String, LinkedHashMap<String, PartnerListCacheSummary>> aggregatorBillerMap = new HashMap<>();
	private static int aggregatorBillerListHashCode = aggregatorBillerMap.hashCode();

	private PartnerListCacheSummary()
	{}

	public PartnerListCacheSummary(String partnerKey, String partnerName, String partnerType, String partnerStatus)
	{
		super();
		this.partnerKey = partnerKey;
		this.partnerName = partnerName;
		this.partnerStatus = partnerStatus;
	}

	public String getPartnerKey()
	{
		return partnerKey;
	}

	public void setPartnerKey(String partnerKey)
	{
		this.partnerKey = partnerKey;
	}

	public String getPartnerName()
	{
		return partnerName;
	}

	public void setPartnerName(String partnerName)
	{
		this.partnerName = partnerName;
	}

	public String getPartnerStatus()
	{
		return partnerStatus;
	}

	public void setPartnerStatus(String partnerStatus)
	{
		this.partnerStatus = partnerStatus;
	}

	public String getPartnerDescription()
	{
		return partnerDescription;
	}

	public void setPartnerDescription(String partnerDescription)
	{
		this.partnerDescription = partnerDescription;
	}

	public static int getBankListHashCode()
	{
		return bankListHashCode;
	}

	public static int getBillerListHashCode()
	{
		return billerListHashCode;
	}

	public static int getBillerOnlyListHashCode()
	{
		return billerOnlyListHashCode;
	}

	public static int getSubBillerListHashCode()
	{
		return subBillerListHashCode;
	}

	public static int getAggregatorListHashCode()
	{
		return aggregatorListHashCode;
	}
	
	public static int getAggregatorBillerListHashCode()
	{
		return aggregatorBillerListHashCode;
	}

	/**
	 * @return the bankList
	 */
	public static Map<String, PartnerListCacheSummary> getBankList()
	{
		final String methodName = "getBankList";
		if (CACHE_REFRESH_FLAG || bankMap.size() == 0)
		{
			try
			{
				callListPartnerSummary();
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
		bankListHashCode = bankMap.hashCode();
		return bankMap;
	}

	/**
	 * @return the billerList
	 */
	public static Map<String, PartnerListCacheSummary> getBillerList()
	{
		final String methodName = "getBillerList";
		if (CACHE_REFRESH_FLAG || billerMap.size() == 0)
		{
			try
			{
				callListPartnerSummary();
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
		billerListHashCode = billerMap.hashCode();
		return billerMap;
	}
	
	public static Map<String, PartnerListCacheSummary> getBillerOnlyList()
	{
		final String methodName = "getBillerOnlyList";
		if (CACHE_REFRESH_FLAG || billerOnlyMap.size() == 0)
		{
			try
			{
				callListPartnerSummary();
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
		billerOnlyListHashCode = billerOnlyMap.hashCode();
		return billerOnlyMap;
	}

	/**
	 * @return the billerList
	 */
	public static Map<String, PartnerListCacheSummary> getSubBillerList()
	{
		final String methodName = "getSubBillerList";
		if (CACHE_REFRESH_FLAG || subBillerMap.size() == 0)
		{
			try
			{
				callListPartnerSummary();
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
		subBillerListHashCode = subBillerMap.hashCode();
		return subBillerMap;
	}
	
	/**
	 * @return the Aggregator List
	 */
	public static Map<String, PartnerListCacheSummary> getAggregatorList()
	{
		final String methodName = "getAggregatorBillerList";
		if (CACHE_REFRESH_FLAG || aggregatorMap.size() == 0)
		{
			try
			{
				callListPartnerSummary();
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
		aggregatorListHashCode = aggregatorMap.hashCode();
		return aggregatorMap;
	}

	/**
	 * @return the Biller List
	 */
	public static Map<String, LinkedHashMap<String, PartnerListCacheSummary>> getAggregatorBillerList()
	{
		final String methodName = "getAggregatorBillerList";
		if (CACHE_REFRESH_FLAG || aggregatorBillerMap.size() == 0)
		{
			try
			{
				callListPartnerSummary();
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
		aggregatorBillerListHashCode = aggregatorBillerMap.hashCode();
		return aggregatorBillerMap;
	}

	/**
	 * Calls the backend web-service ListPartnerSummary from PartnerProfile web-service interface
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 */
	private static void callListPartnerSummary() throws DatatypeConfigurationException, PartnerProfileFaultMsg
	{
		final String methodName = "callListPartnerSummary";
		logger.entering(CLASS_NAME, methodName);
		
		MessageDigest md = null;
		try{md = MessageDigest.getInstance("MD5");}catch (NoSuchAlgorithmException e){}

		ListPartnerSummaryRequestType listReq = new ListPartnerSummaryRequestType();
		listReq.setMessageHeader(getMessageHeaderType("LIST_PARTNER_SUMMARY"));
		ListPartnerSummaryResponseType listRes = partnerProfileService.listPartnerSummary(listReq);


		StringBuilder jbBank = new StringBuilder();
		jbBank.append(OL);
		StringBuilder jbBiller = new StringBuilder();
		jbBiller.append(OL);
		StringBuilder jbBillerOnly = new StringBuilder();
		jbBillerOnly.append(OL);
		StringBuilder jbSubBiller = new StringBuilder();
		jbSubBiller.append(OL);
		StringBuilder jbAggregator = new StringBuilder();
		jbAggregator.append(OL);
		StringBuilder jbAggregatorBiller = new StringBuilder();
		jbAggregatorBiller.append(OB);
		boolean moiIndex = false;
		boolean bankIndex = false;
		boolean billerIndex = false;
		boolean billerOnlyIndex = false;
		boolean subBillerIndex = false;
		boolean aggregatorIndex = false;
		boolean aggregatorBillerIndex = false;

		for (PartnerInfoType pit : listRes.getPartnerInfo())
		{
			PartnerListCacheSummary pls = new PartnerListCacheSummary();
			pls.setPartnerKey(pit.getPartnerKey());
			pls.setPartnerName(pit.getName());
			pls.setPartnerStatus(pit.getStatus());
			// Fix after seen backslash \ in Biller Name in Production Environment 
			String escapedPartnerName = pit.getName().replaceAll("[\\r\\n\\t]+", "").replaceAll("\\\\", "\\\\\\\\");
			switch (pit.getType())
			{
				case BANK:
					bankMap.put(pit.getPartnerKey(), pls);

					if (bankIndex)
						jbBank.append(COMMA);
					bankIndex = true;
					jbBank.append(OB);
					jbBank.append(CODE);
					jbBank.append(QUOTE).append(pit.getPartnerKey()).append(QUOTE).append(COMMA);
					jbBank.append(NAME);
					jbBank.append(QUOTE).append(escapedPartnerName).append(QUOTE);
					jbBank.append(CB);
					break;

				case BILLER: // The Biller case should be without break the BILLER map should have both BILLER + SUB BILLER
					billerOnlyMap.put(pit.getPartnerKey(), pls);
					
					if (billerOnlyIndex)
						jbBillerOnly.append(COMMA);
					billerOnlyIndex = true;
					jbBillerOnly.append(OB);
					jbBillerOnly.append(CODE);
					jbBillerOnly.append(QUOTE).append(pit.getPartnerKey()).append(QUOTE).append(COMMA);
					jbBillerOnly.append(NAME);
					jbBillerOnly.append(QUOTE).append(escapedPartnerName).append(QUOTE);
					jbBillerOnly.append(CB);
					
					// BREAK - SHOULD NOT APPEAR HERE, AS BILLER WILL BE REQUIRED FOR BILLER + SUB BILLER MERGED LIST

				case SUBBILLER:
					billerMap.put(pit.getPartnerKey(), pls);

					// Start Specific to SubBiller only
					if(pit.getType().equals(PartnerTypeEnums.SUBBILLER))
					{
						subBillerMap.put(pit.getPartnerKey(), pls);

						if (subBillerIndex)
							jbSubBiller.append(COMMA);
						subBillerIndex = true;
						jbSubBiller.append(OB);
						jbSubBiller.append(CODE);
						jbSubBiller.append(QUOTE).append(pit.getPartnerKey()).append(QUOTE).append(COMMA);
						jbSubBiller.append(NAME);
						jbSubBiller.append(QUOTE).append(escapedPartnerName).append(QUOTE);
						jbSubBiller.append(CB);
					}
					// End of Specific to SubBiller only
					
					if (billerIndex)
						jbBiller.append(COMMA);
					billerIndex = true;
					jbBiller.append(OB);
					jbBiller.append(CODE);
					jbBiller.append(QUOTE).append(pit.getPartnerKey()).append(QUOTE).append(COMMA);
					jbBiller.append(NAME);
					jbBiller.append(QUOTE).append(escapedPartnerName).append(QUOTE);
					jbBiller.append(CB);

					// Handling Sub-Billers
					if (pit.getOwnerKey() != null)
					{
						if (aggregatorBillerMap.get(pit.getOwnerKey()) != null)
						{
							aggregatorBillerMap.get(pit.getOwnerKey()).put(pit.getPartnerKey(), pls);
						}
						else
						{
							LinkedHashMap<String, PartnerListCacheSummary> abm = new LinkedHashMap<String, PartnerListCacheSummary>();
							abm.put(pit.getPartnerKey(), pls);
							aggregatorBillerMap.put(pit.getOwnerKey(), abm);
						}
					}

					// If Fee Service Provider is TRUE - add to MOI Biller CSV
					if (pit.isFeeServiceProvider())
					{
						if (moiIndex)
							MOI_BILLERS.append(COMMA).append(pit.getPartnerKey());
						else 
							MOI_BILLERS.append(pit.getPartnerKey());
						moiIndex = true;
					}

					break;

				case AGGREGATOR:
					aggregatorMap.put(pit.getPartnerKey(), pls);
					
					if (aggregatorIndex)
						jbAggregator.append(COMMA);
					aggregatorIndex = true;
					jbAggregator.append(OB);
					jbAggregator.append(CODE);
					jbAggregator.append(QUOTE).append(pit.getPartnerKey()).append(QUOTE).append(COMMA);
					jbAggregator.append(NAME);
					jbAggregator.append(QUOTE).append(escapedPartnerName).append(QUOTE);
					jbAggregator.append(CB);
					break;

				default:
					break;
			}
		}
		
		jbBank.append(CL);
		jsonBanks = jbBank.toString();
		jbBiller.append(CL);
		jsonBillers = jbBiller.toString();
		jbBillerOnly.append(CL);
		jsonBillersOnly = jbBillerOnly.toString();
		jbSubBiller.append(CL);
		jsonSubBillers = jbSubBiller.toString();
		jbAggregator.append(CL);
		jsonAggregators = jbAggregator.toString();

		// Sorting bankMap
		bankMap = bankMap
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(e1, e2) -> e1, LinkedHashMap::new));
		// Sorting billerMap
		billerMap = billerMap
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(e1, e2) -> e1, LinkedHashMap::new));
		// Sorting billerOnlyMap
		billerOnlyMap = billerOnlyMap
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(e1, e2) -> e1, LinkedHashMap::new));
		// Sorting aggregatorMap
		aggregatorMap = aggregatorMap
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(e1, e2) -> e1, LinkedHashMap::new));
		// Sorting subBillerMap		
		subBillerMap = subBillerMap
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(e1, e2) -> e1, LinkedHashMap::new));		
		
		// Sorting aggregatorBillerMap & creating JSON from aggregatorBillerMap
		for (Map.Entry<String, LinkedHashMap<String, PartnerListCacheSummary>> entry : aggregatorBillerMap.entrySet())
		{
			// Sorting
			entry.setValue(entry.getValue()
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
							(e1, e2) -> e1, LinkedHashMap::new)));

			 aggregatorBillerMap.put(entry.getKey(), entry.getValue());
			 
			 // Constructing JSON
			 md.update(PortalConstant.JSON_MIXIN_SALT.getBytes());
			 md.update(entry.getKey().getBytes());
			 aggregatorBillerIndex = false;
			 jbAggregatorBiller.append(QUOTE).append(DatatypeConverter.printHexBinary(md.digest())).append(QUOTE).append(':').append(OL);
			for (Map.Entry<String, PartnerListCacheSummary> iEntry : entry.getValue().entrySet())
			{
				if (aggregatorBillerIndex)
					jbAggregatorBiller.append(COMMA);
				aggregatorBillerIndex = true;
				jbAggregatorBiller.append(OB);
				jbAggregatorBiller.append(CODE);
				jbAggregatorBiller.append(QUOTE).append(iEntry.getValue().getPartnerKey()).append(QUOTE).append(COMMA);
				jbAggregatorBiller.append(NAME);
				jbAggregatorBiller.append(QUOTE).append(iEntry.getValue().getPartnerName()).append(QUOTE);
				jbAggregatorBiller.append(CB);
			}
			jbAggregatorBiller.append(CL).append(COMMA);
		}
		int i = jbAggregatorBiller.lastIndexOf(",");
		if(i > 0) 
			jbAggregatorBiller.replace(i, i+1, "");
		jbAggregatorBiller.append(CB);
		jsonAggregatorBillers = jbAggregatorBiller.toString();

		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * Calls to update the cache object of Partner type, the returned object should be added to the portal application cache, 
	 * other wise the application cache would not be changed.
	 * 
	 * @param listType
	 *            - partner type, possible values are PortalConstant.LOOKUP_BANK_LIST and PortalConstant.LOOKUP_BILLER_LIST
	 * @return - returns the update PartnerListCache object, which need to be added in application session
	 */
	public static Map<String, PartnerListCacheSummary> updatePartnerListCache(PartnerListCacheSummary uplc, String listType)
	{
		StringBuilder jb = new StringBuilder();
		jb.append(OL);
		int id = 0;

		PartnerListCacheSummary plc = new PartnerListCacheSummary();
		plc.setPartnerKey(uplc.getPartnerKey());
		plc.setPartnerName(uplc.getPartnerName());
		// plc.setPartnerType(uplc.getPartnerType());
		plc.setPartnerStatus(uplc.getPartnerStatus());

		if (listType.equalsIgnoreCase(PortalConstant.LOOKUP_BANK_LIST))
		{
			bankMap.put(plc.getPartnerKey(), plc);
			bankMap = bankMap
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
							(e1, e2) -> e1, LinkedHashMap::new));

			// Fix for defect 3510
			for (Map.Entry<String, PartnerListCacheSummary> entry : bankMap.entrySet())
			{
				if (id > 0)
					jb.append(COMMA);
				id = 1;
				jb.append(OB);
				jb.append(CODE);
				jb.append(QUOTE).append(entry.getValue().getPartnerKey()).append(QUOTE).append(COMMA);
				jb.append(NAME);
				jb.append(QUOTE).append(entry.getValue().getPartnerName()).append(QUOTE);
				jb.append(CB);
			}
			jb.append(CL);
			jsonBanks = jb.toString(); // End of fix defect 3510

			bankListHashCode = bankMap.hashCode();
			return bankMap;
		}
		if (listType.equalsIgnoreCase(PortalConstant.LOOKUP_BILLER_LIST))
		{
			billerMap.put(plc.getPartnerKey(), plc);
			billerMap = billerMap
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
							(e1, e2) -> e1, LinkedHashMap::new));

			// Fix for defect 3510
			for (Map.Entry<String, PartnerListCacheSummary> entry : billerMap.entrySet())
			{
				if (id > 0)
					jb.append(COMMA);
				id = 1;
				jb.append(OB);
				jb.append(CODE);
				jb.append(QUOTE).append(entry.getValue().getPartnerKey()).append(QUOTE).append(COMMA);
				jb.append(NAME);
				jb.append(QUOTE).append(entry.getValue().getPartnerName()).append(QUOTE);
				jb.append(CB);
			}
			jb.append(CL);
			jsonBillers = jb.toString(); // End of fix defect 3510

			billerListHashCode = billerMap.hashCode();
			return billerMap;
		}
		if (listType.equalsIgnoreCase(PortalConstant.LOOKUP_AGGREGATOR_LIST))
		{
			aggregatorMap.put(plc.getPartnerKey(), plc);
			aggregatorMap = aggregatorMap
					.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, 
							Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

			// Fix for defect 3510
			for (Map.Entry<String, PartnerListCacheSummary> entry : aggregatorMap.entrySet())
			{
				if (id > 0)
					jb.append(COMMA);
				id = 1;
				jb.append(OB);
				jb.append(CODE);
				jb.append(QUOTE).append(entry.getValue().getPartnerKey()).append(QUOTE).append(COMMA);
				jb.append(NAME);
				jb.append(QUOTE).append(entry.getValue().getPartnerName()).append(QUOTE);
				jb.append(CB);
			}
			jb.append(CL);
			jsonAggregators = jb.toString(); // End of fix defect 3510

			aggregatorListHashCode = aggregatorMap.hashCode();
			return aggregatorMap;
		}
		return Collections.emptyMap();
	}


	/**
	 * The overloaded methods for calls to update the cache object of Partner type, the returned object should be added to the portal application cache, 
	 * other wise the application cache would not be changed.
	 * 
	 * @param listType
	 *            - partner type, possible values are PortalConstant.LOOKUP_BANK_LIST, PortalConstant.LOOKUP_BILLER_LIST and PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST
	 * @param agggregatorId
	 *            - The Aggregator ID of the sub-biller
	 * @return - returns the update PartnerListCache object, which need to be added in application session
	 */
	public static Map<String, LinkedHashMap<String, PartnerListCacheSummary>> updatePartnerListCache(PartnerListCacheSummary uplc, String listType, String agggregatorId)
	{
		StringBuilder jb = new StringBuilder();
		jb.append(OB);
		boolean aggregatorBillerIndex = false;

		if (listType.equalsIgnoreCase(PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST) && agggregatorId != null)
		{
			if (aggregatorBillerMap.get(agggregatorId) != null)
			{
				aggregatorBillerMap.get(agggregatorId).put(uplc.getPartnerKey(), uplc);
			}
			else
			{
				LinkedHashMap<String, PartnerListCacheSummary> abm = new LinkedHashMap<String, PartnerListCacheSummary>();
				abm.put(uplc.getPartnerKey(), uplc);
				aggregatorBillerMap.put(agggregatorId, abm);
			}
			
			MessageDigest md = null;
			try{md = MessageDigest.getInstance("MD5");}catch (NoSuchAlgorithmException e){}
			
			for (Map.Entry<String, LinkedHashMap<String, PartnerListCacheSummary>> entry : aggregatorBillerMap.entrySet())
			{
				// Sorting
				entry.setValue(entry.getValue()
						.entrySet()
						.stream()
						.sorted(Map.Entry.comparingByValue())
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
								(e1, e2) -> e1, LinkedHashMap::new)));

				 aggregatorBillerMap.put(entry.getKey(), entry.getValue());
				 
				 // Constructing JSON
				 md.update(PortalConstant.JSON_MIXIN_SALT.getBytes());
				 md.update(entry.getKey().getBytes());
				 aggregatorBillerIndex = false;
				 jb.append(QUOTE).append(DatatypeConverter.printHexBinary(md.digest())).append(QUOTE).append(':').append(OL);
				for (Map.Entry<String, PartnerListCacheSummary> iEntry : entry.getValue().entrySet())
				{
					if (aggregatorBillerIndex)
						jb.append(COMMA);
					aggregatorBillerIndex = true;
					jb.append(OB);
					jb.append(CODE);
					jb.append(QUOTE).append(iEntry.getValue().getPartnerKey()).append(QUOTE).append(COMMA);
					jb.append(NAME);
					jb.append(QUOTE).append(iEntry.getValue().getPartnerName()).append(QUOTE);
					jb.append(CB);
				}
				jb.append(CL).append(COMMA);
			}
			int i = jb.lastIndexOf(",");
			if (i > 0)
				jb.replace(i, i+1, "");
			jb.append(CB);
			jsonAggregatorBillers = jb.toString();

			aggregatorBillerListHashCode = aggregatorBillerMap.hashCode();
			return aggregatorBillerMap;
		}
		return Collections.emptyMap();
	}

	@Override
	public int compareTo(PartnerListCacheSummary o)
	{
		return this.partnerName.compareToIgnoreCase(o.partnerName);
	}

	@Override
	public String toString()
	{
		return "PartnerListCacheSummary [partnerKey=" + partnerKey + ", partnerName=" + partnerName + ", partnerStatus=" + partnerStatus + "]";
	}
}