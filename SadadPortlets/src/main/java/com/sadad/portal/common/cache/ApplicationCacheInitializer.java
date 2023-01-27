/**
 * 
 */
package com.sadad.portal.common.cache;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
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
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
		final String methodName = "contextDestroyed";
		logger.entering(CLASS_NAME, methodName);
		logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Removing lookup data from Application Scope of Servlet Context.");

		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_BILLER_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.JSON_BILLER_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_BILLER_ONLY_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.JSON_BILLER_ONLY_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_BANK_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.JSON_BANK_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_AGGREGATOR_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.JSON_AGGREGATOR_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.JSON_AGGREGATOR_BILLER_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.JSON_AGGREGATOR_BILLER_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_DISTRICT_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_BANK_RULES_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_BILLER_RULES_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_SADAD_RULES_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_AGGREGATOR_RULES_LIST);
		sce.getServletContext().removeAttribute(PortalConstant.LOOKUP_SUBBILLER_RULES_LIST);
		sce.getServletContext().removeAttribute("PortalConstant");
		logger.exiting(CLASS_NAME, methodName);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		final String methodName = "contextInitialized";
		logger.entering(CLASS_NAME, methodName, sce.getServletContext().getServletContextName());

		// Initializing PortalConstant for JSP access
		// Initializing Bank, Biller and Aggregator Lists using Partner Summary call
		try
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Adding lookup data in Application Scope of Servlet Context for Banks, Billers and Aggregators");
			// Adding Bank List to Servlet Context
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_BANK_LIST, PartnerListCacheSummary.getBankList());
			sce.getServletContext().setAttribute(PortalConstant.JSON_BANK_LIST, PartnerListCacheSummary.jsonBanks);
			// Adding Biller List to Servlet Context
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_BILLER_LIST, PartnerListCacheSummary.getBillerList());
			sce.getServletContext().setAttribute(PortalConstant.JSON_BILLER_LIST, PartnerListCacheSummary.jsonBillers);
			// Adding Biller Only (without SubBillers) List to Servlet Context
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_BILLER_ONLY_LIST, PartnerListCacheSummary.getBillerOnlyList());
			sce.getServletContext().setAttribute(PortalConstant.JSON_BILLER_ONLY_LIST, PartnerListCacheSummary.jsonBillersOnly);
			// Adding SubBillers List to Servlet Context
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_SUBBILLER_LIST, PartnerListCacheSummary.getSubBillerList());
			sce.getServletContext().setAttribute(PortalConstant.JSON_SUBBILLER_LIST, PartnerListCacheSummary.jsonSubBillers);
			// Adding Aggregator's Biller List to Servlet Context
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST, PartnerListCacheSummary.getAggregatorBillerList());
			sce.getServletContext().setAttribute(PortalConstant.JSON_AGGREGATOR_BILLER_LIST, PartnerListCacheSummary.jsonAggregatorBillers);
			// Adding Aggregator List to Servlet Context
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_AGGREGATOR_LIST, PartnerListCacheSummary.getAggregatorList());
			sce.getServletContext().setAttribute(PortalConstant.JSON_AGGREGATOR_LIST, PartnerListCacheSummary.jsonAggregators);
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		
		final String logStmt = "Adding lookup data in Application Scope of Servlet Context {0}";
		// Initializing District List
		try
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, logStmt, PortalConstant.LOOKUP_DISTRICT_LIST);
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_DISTRICT_LIST, ReferenceDataListCache.getDistrictList());
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		// Initializing Access Channel List
		try
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, logStmt, PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST);
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST, ReferenceDataListCache.getAccessChannelList());
			sce.getServletContext().setAttribute(PortalConstant.JSON_ACCESS_CHANNEL_LIST, ReferenceDataListCache.jsonAccessChannels);
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		// Initializing Account type List
		try
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, logStmt, PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST);
			sce.getServletContext().setAttribute(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST, ReferenceDataListCache.getAccountTypeList());
			sce.getServletContext().setAttribute(PortalConstant.JSON_ACCOUNT_TYPE_LIST, ReferenceDataListCache.jsonAccountTypes);
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		
		// Initializing Rules list for Bank, Biller and SADAD
		try
		{
			// FIXME Disabled due the the scope of Business Rules Portlet Testing
			String configType[] = { PortalConstant.PARTNER_TYPE_BANK, PortalConstant.PARTNER_TYPE_BILLER, PortalConstant.PARTNER_TYPE_SADAD, PortalConstant.PARTNER_TYPE_AGGREGATOR, PortalConstant.PARTNER_TYPE_SUBBILLER };
			// String configType[] = { PortalConstant.PARTNER_TYPE_BILLER, PortalConstant.PARTNER_TYPE_SUBBILLER };
			for (String ct : configType)
			{
				logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Adding Rules data in Application Scope of Servlet Context for partner type " + ct);
				switch (ct)
				{
					case PortalConstant.PARTNER_TYPE_BANK:
						sce.getServletContext().setAttribute(PortalConstant.LOOKUP_BANK_RULES_LIST, BusinessRulesListCache.getBankRules());
						break;
					case PortalConstant.PARTNER_TYPE_BILLER:
						sce.getServletContext().setAttribute(PortalConstant.LOOKUP_BILLER_RULES_LIST, BusinessRulesListCache.getBillerRules());
						break;
					case PortalConstant.PARTNER_TYPE_SADAD:
						sce.getServletContext().setAttribute(PortalConstant.LOOKUP_SADAD_RULES_LIST, BusinessRulesListCache.getSadadRules());
						break;
					case PortalConstant.PARTNER_TYPE_AGGREGATOR:
						sce.getServletContext().setAttribute(PortalConstant.LOOKUP_AGGREGATOR_RULES_LIST, BusinessRulesListCache.getAggregatorRules());
						break;
					case PortalConstant.PARTNER_TYPE_SUBBILLER:
						sce.getServletContext().setAttribute(PortalConstant.LOOKUP_SUBBILLER_RULES_LIST, BusinessRulesListCache.getSubBillerRules());
						break;
				}
			}
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		// Adding All List's hashcodes to DynaCache 
		try
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Adding Constants from PortalConstant interface in Application Scope of Servlet Context.");
	        sce.getServletContext().setAttribute("PortalConstant", new PortalConstantMap());
	        
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Putting initial hasCode for Portal Cached lookup values in DynaCache Objects");
			// All Partners Lists
	        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_BANK_LIST, PartnerListCacheSummary.getBankListHashCode());
	        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_BILLER_LIST, PartnerListCacheSummary.getBillerListHashCode());
	        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_BILLER_ONLY_LIST, PartnerListCacheSummary.getBillerOnlyListHashCode());
	        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_SUBBILLER_LIST, PartnerListCacheSummary.getSubBillerListHashCode());
	        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_AGGREGATOR_LIST, PartnerListCacheSummary.getAggregatorListHashCode());
	        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST, PartnerListCacheSummary.getAggregatorBillerListHashCode());
	        // Reference Data Lists
	        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_DISTRICT_LIST, ReferenceDataListCache.getDistrictListHashCode());
			DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST, ReferenceDataListCache.getAccessChannelListHashCode());
			DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST, ReferenceDataListCache.getAccountTypeListHashCode());
			// Business Rules Lists
			DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_BANK_RULES_LIST, BusinessRulesListCache.getBankRulesHashCode());
			DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_BILLER_RULES_LIST, BusinessRulesListCache.getBillerRulesHashCode());
			DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_SADAD_RULES_LIST, BusinessRulesListCache.getSadadRulesHashCode());
			DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_AGGREGATOR_RULES_LIST, BusinessRulesListCache.getAggregatorRulesHashCode());
			DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_SUBBILLER_RULES_LIST , BusinessRulesListCache.getSubBillerRulesHashCode());
		}
		catch (NamingException e)
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

		logger.exiting(CLASS_NAME, methodName);
	}
}