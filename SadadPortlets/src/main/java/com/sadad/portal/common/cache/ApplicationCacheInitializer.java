/**
 * 
 */
package com.sadad.portal.common.cache;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sadad.portal.constant.PortalConstant;

/**
 * @author Tariq Siddiqui
 * 
 */
public class ApplicationCacheInitializer implements ServletContextListener
{
	private static final String CLASS_NAME = ApplicationCacheInitializer.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	private HashMap<String, PartnerListCache> bankList = new HashMap<String, PartnerListCache>() ;
	private HashMap<String, PartnerListCache> billerList = new HashMap<String, PartnerListCache>();
	private HashMap<String, ReferenceDataListCache> districtList = new HashMap<String, ReferenceDataListCache>();
	private HashMap<String, ReferenceDataListCache> accessChannelList = new HashMap<String, ReferenceDataListCache>();
	private HashMap<String, ReferenceDataListCache> accountTypeList = new HashMap<String, ReferenceDataListCache>();
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
		final String methodName = "contextDestroyed";
		logger.entering(CLASS_NAME, methodName);
		logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Removing lookup data from Application Scope of Servlet Context.");

		billerList = null;
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_BILLER_LIST);
		bankList = null;
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_BANK_LIST);

		logger.exiting(CLASS_NAME, methodName);
	}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		final String methodName = "contextInitialized";
		logger.entering(CLASS_NAME, methodName);

		// Initializing Biller List
		try
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Adding lookup data in Application Scope of Servlet Context " + PortalConstant.LOOKUP_BILLER_LIST);
			billerList = PartnerListCache.getBillerList();
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_BILLER_LIST, billerList);
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
		}

		// Initializing Bank List
		try 
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Adding lookup data in Application Scope of Servlet Context " + PortalConstant.LOOKUP_BANK_LIST);
			bankList = PartnerListCache.getBankList();
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_BANK_LIST, bankList);
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
		}
		
		// Initializing District List
		try
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Adding lookup data in Application Scope of Servlet Context " + PortalConstant.LOOKUP_DISTRICT_LIST);
			districtList = ReferenceDataListCache.getDistrictList();
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_DISTRICT_LIST, districtList);
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
		}		
		
		logger.exiting(CLASS_NAME, methodName);
		
		try
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Adding lookup data in Application Scope of Servlet Context " + PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST);
			accessChannelList = ReferenceDataListCache.getAccessChannelList();
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST, accessChannelList);
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
		}		
		
		try
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Adding lookup data in Application Scope of Servlet Context " + PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST);
			accountTypeList = ReferenceDataListCache.getAccountTypeList();
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST, accountTypeList);
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
		}	
		
		
		logger.exiting(CLASS_NAME, methodName);
		
	}
}
