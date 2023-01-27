/**
 * 
 */
package com.sadad.portal.common.cache;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerListResponseType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.PartnerType;

/**
 * @author Tariq Siddiqui
 *
 */
public class PartnerListCache extends PortalServiceCallHelper
{
	private static final String CLASS_NAME = PartnerListCache.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	public static boolean CACHE_REFRESH_FLAG = true;

	private String partnerKey;
	private String partnerName;
	private String partnerDescription;
	private String partnerStatus;
	private static HashMap<String, PartnerListCache> bankMap = new HashMap<String, PartnerListCache>();
	private static HashMap<String, PartnerListCache> billerMap = new HashMap<String, PartnerListCache>();

	private PartnerListCache()
	{}

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
	public static HashMap<String, PartnerListCache> getBankList()
	{
		final String methodName = "getBankList";
		if (CACHE_REFRESH_FLAG || bankMap.size() == 0)
		{
			try
			{
				bankMap = new HashMap<String, PartnerListCache>();
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
		GetBankListResponseType bankListResponseType = partnerProfileServices.getBankList(bankListRq);
		
		for (PartnerType pt : bankListResponseType.getPartner())
		{
			PartnerListCache blc = new PartnerListCache();
			blc.setPartnerKey(pt.getPartnerKey());
			blc.setPartnerName(pt.getName());
			blc.setPartnerDescription(pt.getDescription());
			blc.setPartnerStatus(pt.getStatus());
			bankMap.put(pt.getPartnerKey(), blc);
		}		
		logger.exiting(CLASS_NAME, methodName);
	}
	
	/**
	 * @return the billerList
	 */
	public static HashMap<String, PartnerListCache> getBillerList()
	{
		final String methodName = "getBillerList";
		if (CACHE_REFRESH_FLAG || billerMap.size() == 0)
		{
			try
			{
				billerMap = new HashMap<String, PartnerListCache>();
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
		GetBillerListResponseType billerListResponseType = partnerProfileServices.getBillerList(billerListRq);

		for (PartnerType pt : billerListResponseType.getPartner())
		{
			PartnerListCache blc = new PartnerListCache();
			blc.setPartnerKey(pt.getPartnerKey());
			blc.setPartnerName(pt.getName());
			blc.setPartnerDescription(pt.getDescription());
			blc.setPartnerStatus(pt.getStatus());
			billerMap.put(pt.getPartnerKey(), blc);
		}
		logger.exiting(CLASS_NAME, methodName);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("PartnerListCache");
		sb.append(" [partnerKey=").append(partnerKey)
			.append(", partnerName=").append(partnerName)
			.append(", partnerDescription=").append(partnerDescription)
			.append(", partnerStatus=").append(partnerStatus)
			.append(']');

		return sb.toString();
	}
}