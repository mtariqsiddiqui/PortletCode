/**
 * The SadadPortletsRenderFilter class is used as the filters for all SADAD Portlets Render Requests.
 * The render request is intercepted for two reasons. 
 *  i) Checking the validity of Portal Cache objects which includes the list of following.
 * 	   a) Partners
 *     b) District Codes
 *     c) Access Channels
 *     d) Accout Types 
 *     e) Business Rules
 * ii) Checking the validity of Portal user's password. 
 */
package com.sadad.portal.filters;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;
import javax.servlet.ServletContext;

import com.sadad.portal.common.cache.BusinessRulesListCache;
import com.sadad.portal.common.cache.DynaCacheAdaptor;
import com.sadad.portal.common.cache.PartnerListCacheSummary;
import com.sadad.portal.common.cache.ReferenceDataListCache;
import com.sadad.portal.common.utils.SadadPortalUtils;
import com.sadad.portal.constant.PortalConstant;

/**
 * @author Tariq Siddiqui
 *
 */
public class SadadPortletsRenderFilter implements RenderFilter
{
	private static final String CLASS_NAME = SadadPortletsRenderFilter.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	@Override
	public void init(FilterConfig filterConfig) throws PortletException
	{}

	@Override
	public void doFilter(RenderRequest renderRequest, RenderResponse renderResponse, FilterChain filterChain) throws IOException, PortletException
	{
		final String methodName = "doFilter";
		logger.entering(CLASS_NAME, methodName);
		long start = System.currentTimeMillis();

		ServletContext sc = SadadPortalUtils.getServletContextForRequest(renderRequest);
		try
		{
			// START OF ALL PARTNER LIST CACHE CHECKING
			int bankListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_BANK_LIST);
			int billerListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_BILLER_LIST);
			int subBillerListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_SUBBILLER_LIST);
			int billerOnlyListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_BILLER_ONLY_LIST);
			int aggregatorListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_AGGREGATOR_LIST);
			int aggregatorBillerListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST);

			// Checking ALL PARTNER List Hashes together because,
			// If any of the Partner List type is updated, the ListPartnerSummary will return all partner, so refreshing all partners together.
			if (bankListHash != PartnerListCacheSummary.getBankListHashCode() || billerListHash != PartnerListCacheSummary.getBillerListHashCode() || subBillerListHash != PartnerListCacheSummary.getSubBillerListHashCode()
					|| billerOnlyListHash != PartnerListCacheSummary.getBillerOnlyListHashCode() || aggregatorListHash != PartnerListCacheSummary.getAggregatorListHashCode()
					|| aggregatorBillerListHash != PartnerListCacheSummary.getAggregatorBillerListHashCode())
			{
				try
				{
					PartnerListCacheSummary.CACHE_REFRESH_FLAG = true; // Set the CACHE_REFRESH_FLAG to TRUE for WAS Service Call
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Refreshing the lookup data in Application Scope of Servlet Context for all partner type.");
					sc.setAttribute(PortalConstant.LOOKUP_BANK_LIST, PartnerListCacheSummary.getBankList());
					sc.setAttribute(PortalConstant.JSON_BANK_LIST, PartnerListCacheSummary.jsonBanks);

					sc.setAttribute(PortalConstant.LOOKUP_BILLER_LIST, PartnerListCacheSummary.getBillerList());
					sc.setAttribute(PortalConstant.JSON_BILLER_LIST, PartnerListCacheSummary.jsonBillers);

					sc.setAttribute(PortalConstant.LOOKUP_BILLER_ONLY_LIST, PartnerListCacheSummary.getBillerOnlyList());
					sc.setAttribute(PortalConstant.JSON_BILLER_ONLY_LIST, PartnerListCacheSummary.jsonBillersOnly);

					sc.setAttribute(PortalConstant.LOOKUP_SUBBILLER_LIST, PartnerListCacheSummary.getSubBillerList());
					sc.setAttribute(PortalConstant.JSON_SUBBILLER_LIST, PartnerListCacheSummary.jsonSubBillers);

					sc.setAttribute(PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST, PartnerListCacheSummary.getAggregatorBillerList());
					sc.setAttribute(PortalConstant.JSON_AGGREGATOR_BILLER_LIST, PartnerListCacheSummary.jsonAggregatorBillers);

					sc.setAttribute(PortalConstant.LOOKUP_AGGREGATOR_LIST, PartnerListCacheSummary.getAggregatorList());
					sc.setAttribute(PortalConstant.JSON_AGGREGATOR_LIST, PartnerListCacheSummary.jsonAggregators);
				
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Putting updated hasCode of all Partners list for Portal Cached lookup values in DynaCache Objects");
			        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_BANK_LIST, PartnerListCacheSummary.getBankListHashCode());
			        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_BILLER_LIST, PartnerListCacheSummary.getBillerListHashCode());
			        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_BILLER_ONLY_LIST, PartnerListCacheSummary.getBillerOnlyListHashCode());
			        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_SUBBILLER_LIST, PartnerListCacheSummary.getSubBillerListHashCode());
			        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_AGGREGATOR_LIST, PartnerListCacheSummary.getAggregatorListHashCode());
			        DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST, PartnerListCacheSummary.getAggregatorBillerListHashCode());
				}
				catch (Exception e) // Catches any exception to prevent failures for other caches
				{
					logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
					if (logger.isLoggable(Level.FINEST))
						e.printStackTrace();
				}
			}
			// END OF ALL PARTNER LIST CACHE CHECKING
			
			// START OF REFERENCE DATA LIST CACHE CHECKING
			// Getting the currently saved values for Reference Data List Caches from DynaCache
			int districtListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_DISTRICT_LIST);
			int accoutTypeListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST);
			int accessChannelListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST);

			// Checking District Code List Hash
			if (districtListHash != ReferenceDataListCache.getDistrictListHashCode())
			{
				try
				{
					ReferenceDataListCache.CACHE_REFRESH_FLAG = true; // Set the CACHE_REFRESH_FLAG to TRUE for WAS Service Call
					sc.setAttribute(PortalConstant.LOOKUP_DISTRICT_LIST, ReferenceDataListCache.getDistrictList());
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Putting updated hasCode of District Code list for Portal Cached lookup values in DynaCache Objects");
					DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_DISTRICT_LIST, ReferenceDataListCache.getDistrictListHashCode());
				}
				catch (Exception e) // Catches any exception to prevent failures for other caches
				{
					logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
					if (logger.isLoggable(Level.FINEST))
						e.printStackTrace();
				}
			}
			// Checking Account Type List Hash
			if (accoutTypeListHash != ReferenceDataListCache.getAccountTypeListHashCode())
			{
				try
				{
					ReferenceDataListCache.CACHE_REFRESH_FLAG = true; // Set the CACHE_REFRESH_FLAG to TRUE for WAS Service Call
					sc.setAttribute(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST, ReferenceDataListCache.getAccountTypeList());
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Putting updated hasCode of Account Type list for Portal Cached lookup values in DynaCache Objects");
					DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST, ReferenceDataListCache.getAccountTypeListHashCode());
				}
				catch (Exception e) // Catches any exception to prevent failures for other caches
				{
					logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
					if (logger.isLoggable(Level.FINEST))
						e.printStackTrace();
				}
			}
			// Checking Access Channel List Hash
			if (accessChannelListHash != ReferenceDataListCache.getAccessChannelListHashCode())
			{
				try
				{
					ReferenceDataListCache.CACHE_REFRESH_FLAG = true; // Set the CACHE_REFRESH_FLAG to TRUE for WAS Service Call
					sc.setAttribute(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST, ReferenceDataListCache.getAccessChannelList());
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Putting updated hasCode of Access Channels list for Portal Cached lookup values in DynaCache Objects");
					DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST, ReferenceDataListCache.getAccessChannelListHashCode());
				}
				catch (Exception e) // Catches any exception to prevent failures for other caches
				{
					logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
					if (logger.isLoggable(Level.FINEST))
						e.printStackTrace();
				}
			}
			// END OF REFERENCE DATA LIST CACHE CHECKING
			
			// START OF BUSINESS RULES LIST CACHE CHECKING
			// Getting the currently saved values for Business Rules List Caches from DynaCache
			int bankRulesListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_BANK_RULES_LIST);
			int billerRulesListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_BILLER_RULES_LIST);
			int sadadRulesListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_SADAD_RULES_LIST);
			int subBillerRulesListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_SUBBILLER_RULES_LIST);
			int aggregatorRulesListHash = (int) DynaCacheAdaptor.getCacheMapObj().get(PortalConstant.LOOKUP_AGGREGATOR_RULES_LIST);

			// Checking BANK Rules List Hash
			if (bankRulesListHash != BusinessRulesListCache.getBankRulesHashCode())
			{
				try
				{
					BusinessRulesListCache.CACHE_REFRESH_FLAG = true; // Set the CACHE_REFRESH_FLAG to TRUE for WAS Service Call
					sc.setAttribute(PortalConstant.LOOKUP_BANK_RULES_LIST, BusinessRulesListCache.getBankRules());
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Putting updated hasCode of Bank Business Rules list for Portal Cached lookup values in DynaCache Objects");
					DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_BANK_RULES_LIST, BusinessRulesListCache.getBankRulesHashCode());
				}
				catch (Exception e) // Catches any exception to prevent failures for other caches
				{
					logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
					if (logger.isLoggable(Level.FINEST))
						e.printStackTrace();
				}
			}
			// Checking BILLER Rules List Hash
			if (billerRulesListHash != BusinessRulesListCache.getBillerRulesHashCode())
			{
				try
				{
					BusinessRulesListCache.CACHE_REFRESH_FLAG = true; // Set the CACHE_REFRESH_FLAG to TRUE for WAS Service Call
					sc.setAttribute(PortalConstant.LOOKUP_BILLER_RULES_LIST, BusinessRulesListCache.getBillerRules());
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Putting updated hasCode of Biller Business Rules list for Portal Cached lookup values in DynaCache Objects");
					DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_BILLER_RULES_LIST, BusinessRulesListCache.getBillerRulesHashCode());
				}
				catch (Exception e) // Catches any exception to prevent failures for other caches
				{
					logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
					if (logger.isLoggable(Level.FINEST))
						e.printStackTrace();
				}
			}
			// Checking SADAD Rules List Hash
			if (sadadRulesListHash != BusinessRulesListCache.getSadadRulesHashCode())
			{
				try
				{
					BusinessRulesListCache.CACHE_REFRESH_FLAG = true; // Set the CACHE_REFRESH_FLAG to TRUE for WAS Service Call
					sc.setAttribute(PortalConstant.LOOKUP_SADAD_RULES_LIST, BusinessRulesListCache.getSadadRules());
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Putting updated hasCode of SADAD Business Rules list for Portal Cached lookup values in DynaCache Objects");
					DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_SADAD_RULES_LIST, BusinessRulesListCache.getSadadRulesHashCode());
				}
				catch (Exception e) // Catches any exception to prevent failures for other caches
				{
					logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
					if (logger.isLoggable(Level.FINEST))
						e.printStackTrace();
				}
			}
			// Checking SUBBILLER Rules List Hash
			if (subBillerRulesListHash != BusinessRulesListCache.getSubBillerRulesHashCode())
			{
				try
				{
					BusinessRulesListCache.CACHE_REFRESH_FLAG = true; // Set the CACHE_REFRESH_FLAG to TRUE for WAS Service Call
					sc.setAttribute(PortalConstant.LOOKUP_SUBBILLER_RULES_LIST, BusinessRulesListCache.getSubBillerRules());
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Putting updated hasCode of SubBiller Business Rules list for Portal Cached lookup values in DynaCache Objects");
					DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_SUBBILLER_RULES_LIST, BusinessRulesListCache.getSubBillerRulesHashCode());
				}
				catch (Exception e) // Catches any exception to prevent failures for other caches
				{
					logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
					if (logger.isLoggable(Level.FINEST))
						e.printStackTrace();
				}
			}
			// Checking AGGREGATOR Rules List Hash
			if (aggregatorRulesListHash != BusinessRulesListCache.getAggregatorRulesHashCode())
			{
				try
				{
					BusinessRulesListCache.CACHE_REFRESH_FLAG = true; // Set the CACHE_REFRESH_FLAG to TRUE for WAS Service Call
					sc.setAttribute(PortalConstant.LOOKUP_AGGREGATOR_RULES_LIST, BusinessRulesListCache.getAggregatorRules());
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Putting updated hasCode of SubBiller Business Rules list for Portal Cached lookup values in DynaCache Objects");
					DynaCacheAdaptor.getCacheMapObj().put(PortalConstant.LOOKUP_AGGREGATOR_RULES_LIST, BusinessRulesListCache.getAggregatorRulesHashCode());
				}
				catch (Exception e) // Catches any exception to prevent failures for other caches
				{
					logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
					if (logger.isLoggable(Level.FINEST))
						e.printStackTrace();
				}
			}
			// END OF BUSINESS RULES LIST CACHE CHECKING

			// Logging all the Hashes from Node's and DynaCache
			if (logger.isLoggable(Level.FINEST))
			{
				// Logging all the Partners List Hashes from Node's and DynaCache
				StringBuilder sb = new StringBuilder("Logging all the DynaCache < and > Portal cached objects hash codes.");
				sb.append(System.getProperty("line.separator"));
				sb.append("# Partner List Hashes #").append(System.getProperty("line.separator"));
				sb.append(bankListHash).append(" < bankListHash > ").append(PartnerListCacheSummary.getBankListHashCode()).append(System.getProperty("line.separator"));
				sb.append(billerListHash).append(" < billerListHash > ").append(PartnerListCacheSummary.getBillerListHashCode()).append(System.getProperty("line.separator"));
				sb.append(billerOnlyListHash).append(" < billerOnlyListHash > ").append(PartnerListCacheSummary.getBillerOnlyListHashCode()).append(System.getProperty("line.separator"));
				sb.append(subBillerListHash).append(" < subBillerListHash > ").append(PartnerListCacheSummary.getSubBillerListHashCode()).append(System.getProperty("line.separator"));
				sb.append(aggregatorListHash).append(" < aggregatorListHash > ").append(PartnerListCacheSummary.getAggregatorListHashCode()).append(System.getProperty("line.separator"));
				sb.append(aggregatorBillerListHash).append(" < aggregatorBillerListHash > ").append(PartnerListCacheSummary.getAggregatorBillerListHashCode()).append(System.getProperty("line.separator"));
				// Logging the Reference Data List Hashes from Node's and DynaCache
				sb.append("# Reference Data List Hashes #").append(System.getProperty("line.separator"));
				sb.append(districtListHash).append(" < districtListHash > ").append(ReferenceDataListCache.getDistrictListHashCode()).append(System.getProperty("line.separator"));
				sb.append(accoutTypeListHash).append(" < accoutTypeListHash > ").append(ReferenceDataListCache.getAccountTypeListHashCode()).append(System.getProperty("line.separator"));
				sb.append(accessChannelListHash).append(" < accessChannelListHash > ").append(ReferenceDataListCache.getAccessChannelListHashCode()).append(System.getProperty("line.separator"));
				// Logging the Business Rules List Hashes from Node's and DynaCache
				sb.append("# Business Rules List Hashes #").append(System.getProperty("line.separator"));
				sb.append(bankRulesListHash).append(" < bankRulesListHash > ").append(BusinessRulesListCache.getBankRulesHashCode()).append(System.getProperty("line.separator"));
				sb.append(billerRulesListHash).append(" < billerRulesListHash > ").append(BusinessRulesListCache.getBillerRulesHashCode()).append(System.getProperty("line.separator"));
				sb.append(sadadRulesListHash).append(" < sadadRulesListHash > ").append(BusinessRulesListCache.getSadadRulesHashCode()).append(System.getProperty("line.separator"));
				sb.append(subBillerRulesListHash).append(" < subBillerRulesListHash > ").append(BusinessRulesListCache.getSubBillerRulesHashCode()).append(System.getProperty("line.separator"));
				sb.append(aggregatorRulesListHash).append(" < aggregatorRulesListHash > ").append(BusinessRulesListCache.getAggregatorRulesHashCode());
				logger.logp(Level.FINEST, CLASS_NAME, methodName, sb.toString());
			}
		}
		catch (NamingException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		filterChain.doFilter(renderRequest, renderResponse);
		long time = System.currentTimeMillis()-start;
		logger.exiting(CLASS_NAME, methodName, "The processing took "+time+"ms");
	}

	@Override
	public void destroy()
	{}
}