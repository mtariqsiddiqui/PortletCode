/**
 * 
 */
package com.sadad.portal.portlets.admin.config;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletContext;

import com.ibm.ws.portletcontainer.portlet.PortletUtils;
import com.sadad.portal.SadadGenericPortlet;
import com.sadad.portal.common.cache.BusinessRulesListCache;
import com.sadad.portal.common.cache.PartnerListCacheSummary;
import com.sadad.portal.common.cache.ReferenceDataListCache;
import com.sadad.portal.constant.PortalConstant;

public class SadadConfigurationPortlet extends SadadGenericPortlet
{
	private static final String CLASS_NAME = SadadConfigurationPortlet.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	private static final String JSP_FOLDER = "/jsp/html/admin/config/"; // JSP folder name
	private static final String VIEW_JSP = "SadadConfig"; // JSP file name to be rendered on the view mode

	private static ServletContext sc = null;

	@Override
	protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
	{
		final String methodName = "doView";
		logger.entering(CLASS_NAME, methodName);
		
		if(sc == null)
			sc = PortletUtils.getHttpServletRequest(request).getServletContext();
		
		// SadadPortalUtils.logSessionAttributesWithValues(request, methodName, logger);

		// Set the MIME type for the render response
		response.setContentType(request.getResponseContentType());

		// Invoke the JSP to render
		PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(JSP_FOLDER, VIEW_JSP));
		rd.include(request, response);

		logger.exiting(CLASS_NAME, methodName);
	}

	@Override
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException
	{
		final String methodName = "processAction";
		logger.entering(CLASS_NAME, methodName);
		
		logger.exiting(CLASS_NAME, methodName);
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException
	{ 
		final String methodName = "serveResource";
		logger.entering(CLASS_NAME, methodName);

		String jspResourceId = request.getResourceID();
		logger.logp(Level.INFO, CLASS_NAME, methodName, jspResourceId);

		if(jspResourceId.equals(PortalConstant.REFRESH_PARTNER_CACHE))
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Refreshing All Partners List lookup data in Application Scope of Servlet Context " + PortalConstant.REFRESH_PARTNER_CACHE);
			PartnerListCacheSummary.CACHE_REFRESH_FLAG = true;
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
		}
		else if(jspResourceId.equals(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST))
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Refreshing lookup data in Application Scope of Servlet Context " + PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST);
			ReferenceDataListCache.CACHE_REFRESH_FLAG = true;
			sc.setAttribute(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST, ReferenceDataListCache.getAccessChannelList());
		}
		else if(jspResourceId.equals(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST))
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Refreshing lookup data in Application Scope of Servlet Context " + PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST);
			ReferenceDataListCache.CACHE_REFRESH_FLAG = true;
			sc.setAttribute(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST, ReferenceDataListCache.getAccountTypeList());
		}
		else if(jspResourceId.equals(PortalConstant.LOOKUP_DISTRICT_LIST))
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Refreshing lookup data in Application Scope of Servlet Context " + PortalConstant.LOOKUP_DISTRICT_LIST);
			ReferenceDataListCache.CACHE_REFRESH_FLAG = true;
			sc.setAttribute(PortalConstant.LOOKUP_DISTRICT_LIST, ReferenceDataListCache.getDistrictList());
		}
		// Start of FIXME - Need to update similar to Partners List, instead of buttons should be only one
		else if(jspResourceId.equals(PortalConstant.LOOKUP_BANK_RULES_LIST))
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Refreshing business rules list data in Application Scope of Servlet Context " + PortalConstant.LOOKUP_BANK_RULES_LIST);
			BusinessRulesListCache.CACHE_REFRESH_FLAG = true;
			sc.setAttribute(PortalConstant.LOOKUP_BANK_RULES_LIST, BusinessRulesListCache.getBankRules());
		}
		else if(jspResourceId.equals(PortalConstant.LOOKUP_BILLER_RULES_LIST))
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Refreshing business rules list data in Application Scope of Servlet Context " + PortalConstant.LOOKUP_BILLER_RULES_LIST);
			BusinessRulesListCache.CACHE_REFRESH_FLAG = true;
			sc.setAttribute(PortalConstant.LOOKUP_BILLER_RULES_LIST, BusinessRulesListCache.getBillerRules());
		}
		else if(jspResourceId.equals(PortalConstant.LOOKUP_SADAD_RULES_LIST))
		{
			logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Refreshing business rules list data in Application Scope of Servlet Context " + PortalConstant.LOOKUP_SADAD_RULES_LIST);
			BusinessRulesListCache.CACHE_REFRESH_FLAG = true;
			sc.setAttribute(PortalConstant.LOOKUP_SADAD_RULES_LIST, BusinessRulesListCache.getSadadRules());
		}
		// End of FIXME - Need to update similar to Partners List, instead of buttons should be only one
		logger.exiting(CLASS_NAME, methodName);
	}
}