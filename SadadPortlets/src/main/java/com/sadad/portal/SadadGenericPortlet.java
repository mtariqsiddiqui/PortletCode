/**
 * 
 */
package com.sadad.portal;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;

import com.ibm.portal.portlet.service.PortletServiceHome;
import com.sadad.portal.beans.SadadPortalSessionDataBean;
import com.sadad.portal.common.cache.BusinessRulesListCache;
import com.sadad.portal.common.cache.PartnerListCacheSummary;
import com.sadad.portal.common.cache.ReferenceDataListCache;
import com.sadad.portal.common.utils.SadadPortalUtils;
import com.sadad.portal.common.utils.SadadPumaUtils;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;

/**
 * @author Tariq Siddiqui
 *
 */
public abstract class SadadGenericPortlet extends GenericPortlet
{
	private static final String CLASS_NAME = SadadGenericPortlet.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);
	
	private static PortletServiceHome psh = null;
	
	protected static final String JSP_EXTENTION = ".jsp"; // JSP folder name
	protected static final String JSP_CORE_FOLDER = "/jsp/html/ebpp/core/"; // JSP folder name
	
	static
	{
		try
		{
			Context ctx = new InitialContext();
			psh = (PortletServiceHome) ctx.lookup("portletservice/com.ibm.portal.um.portletservice.PumaHome");
			if (psh != null)
				logger.logp(Level.CONFIG, CLASS_NAME, "static-code", "Portlet Service Home Initialized successfully.....");
		}
		catch(NamingException ex)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, "static-code_Exception", ex.getMessage());
			if (logger.isLoggable(Level.FINEST))
				ex.printStackTrace();
			throw new IllegalStateException();
		}
	}

	/**
	 * Handle the Screen handling logic. Any Form or Detail pages are displayed in Container 1 and Container 2 is empty, 
	 * whereas all the Summary and List pages are displayed in Container 2.
	 * 
	 * @param so Session Bean object
	 * @param jspFolder - Folder in which jsp file resides
	 * @param jspResourceId - Name of jsp file without extension (case sensitive)
	 */
	protected void screenHandling(SadadPortalSessionDataBean so, String jspFolder, String jspResourceId)
	{
		// in case of error or in case of JSON response
		// next screen should not be rendered, just return 
		if(so.getMessageToDisplay() != null || so.getJsonObj() != null)
			return;
				
		if (jspResourceId.endsWith("Form") || jspResourceId.endsWith("Details"))
		{
			if(so.getScreen().getContainer1().equals(getJspFilePath(jspFolder, jspResourceId)))
				so.navigate(PortalConstant.REFRESH);
			else
				so.navigate(PortalConstant.NEXT);
			
			so.getScreen().setContainer1(getJspFilePath(jspFolder, jspResourceId));
			so.getScreen().setContainer2(null);
		}
		else if (jspResourceId.endsWith("Summary") || jspResourceId.endsWith("List"))
			so.getScreen().setContainer2(getJspFilePath(jspFolder, jspResourceId));
		else if (jspResourceId.endsWith(PortalConstant.GO_BACK))
			so.setScreen(so.navigate(PortalConstant.BACK));
	}
	
	/**
	 * Handle the screen rendering for different permissions for different organization types.
	 * @param so Session Bean object 
	 * @param jspFolder - folder in which jsp files resides
	 * @param jspFile - JSP file for rendering
	 * @return
	 */
	protected String permissionHandling(SadadPortalSessionDataBean so, String jspFolder, String jspFile)
	{
		String fallbackFolder = jspFolder;
		jspFolder = jspFolder + so.getPartnerType() + "/";
		String absolutePath = this.getPortletContext().getRealPath(getJspFilePath(jspFolder, jspFile));
		File f = new File(absolutePath);
		if (f.exists())
		{
			logger.log(Level.CONFIG, "File Path exists, {0}", absolutePath);
			return jspFolder;
		}
		else
		{
			logger.log(Level.CONFIG, "File Path DOES NOT exists, {0}", absolutePath);
			return fallbackFolder;
		}
	}
	
	/**
	 * Retrieve the sesion bean data object from Portlet Session - Portlet Scope
	 * @param request - Portlet request object from doView or serveResource
	 * @param castTo - 
	 * @return - session bean object from session or null
	 */
	protected <T> T getSessionBeanObject(PortletRequest request, Class<T> castTo)
	{
		SadadPortalSessionDataBean obj = (SadadPortalSessionDataBean) request.getPortletSession().getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);
		// Clear any previous error or success messages
		if(obj != null && obj.getMessageToDisplay() != null)
			obj.setMessageToDisplay(null);
		// return the object after casting it to required class
		return castTo.cast(obj);
	}
	
	/**
	 * Stores the session bean data object in Portlet Session - Portlet Scope
	 * Update the Application Level cache conditionally
	 * @param request - Portlet request object from doView or serveResource
	 * @param sesObj - session bean object to be stored in portlet session 
	 */
	protected void setSessionBeanObject(PortletRequest request, SadadPortalSessionDataBean sesObj)
	{
		// Updating Cache Objects in Servlet Context - Application Scope
		if(sesObj != null && sesObj.getCacheObj() != null && sesObj.getCacheRefreshType() != null)
		{
			ServletContext sc = SadadPortalUtils.getServletContextForRequest(request);
			switch(sesObj.getCacheRefreshType())
			{
				case PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST:
				case PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST:
				case PortalConstant.LOOKUP_DISTRICT_LIST:
					sc.setAttribute(sesObj.getCacheRefreshType(), 
							ReferenceDataListCache.updateReferenceDataListCache(
									(ReferenceDataListCache)sesObj.getCacheObj(), sesObj.getCacheRefreshType()));
					sc.setAttribute(PortalConstant.JSON_ACCESS_CHANNEL_LIST, ReferenceDataListCache.jsonAccessChannels);
					sc.setAttribute(PortalConstant.JSON_ACCOUNT_TYPE_LIST, ReferenceDataListCache.jsonAccountTypes);

					break;

				case PortalConstant.LOOKUP_BANK_LIST:
					sc.setAttribute(sesObj.getCacheRefreshType(), 
							PartnerListCacheSummary.updatePartnerListCache(
									(PartnerListCacheSummary)sesObj.getCacheObj(), sesObj.getCacheRefreshType()));
					sc.setAttribute(PortalConstant.JSON_BANK_LIST, PartnerListCacheSummary.jsonBanks);
					
					break;
					
				case PortalConstant.LOOKUP_BILLER_LIST:
					sc.setAttribute(sesObj.getCacheRefreshType(), 
							PartnerListCacheSummary.updatePartnerListCache(
									(PartnerListCacheSummary)sesObj.getCacheObj(), sesObj.getCacheRefreshType()));
					sc.setAttribute(PortalConstant.JSON_BILLER_LIST, PartnerListCacheSummary.jsonBillers);
					
					break;
					
				case PortalConstant.LOOKUP_AGGREGATOR_LIST:
					sc.setAttribute(sesObj.getCacheRefreshType(), 
							PartnerListCacheSummary.updatePartnerListCache(
									(PartnerListCacheSummary)sesObj.getCacheObj(), sesObj.getCacheRefreshType()));
					sc.setAttribute(PortalConstant.JSON_AGGREGATOR_LIST, PartnerListCacheSummary.jsonAggregators);
					
					break;
					
				case PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST:
				case PortalConstant.LOOKUP_SUBBILLER_LIST:

					logger.logp(Level.CONFIG, CLASS_NAME, "setSessionBeanObject", "Case is PortalConstant->[LOOKUP_AGGREGATOR_BILLER_LIST, LOOKUP_SUBBILLER_LIST] " + sesObj.getCacheRefreshType());
					// When Sub Biller is updated, it should be updated in 3 places (aggregator-biller, subbiller and biller)
					// Aggregator Biller List
					sc.setAttribute(sesObj.getCacheRefreshType(), 
							PartnerListCacheSummary.updatePartnerListCache(
									(PartnerListCacheSummary)sesObj.getCacheObj(), sesObj.getCacheRefreshType(), sesObj.getCacheParent()));
					sc.setAttribute(PortalConstant.JSON_AGGREGATOR_BILLER_LIST, PartnerListCacheSummary.jsonAggregatorBillers);
					// SubBiller List
					sc.setAttribute(PortalConstant.LOOKUP_SUBBILLER_LIST, 
							PartnerListCacheSummary.updatePartnerListCache(
									(PartnerListCacheSummary)sesObj.getCacheObj(), PortalConstant.LOOKUP_SUBBILLER_LIST));
					sc.setAttribute(PortalConstant.JSON_SUBBILLER_LIST, PartnerListCacheSummary.jsonSubBillers);
					// Biller List
					sc.setAttribute(PortalConstant.LOOKUP_BILLER_LIST, 
							PartnerListCacheSummary.updatePartnerListCache(
									(PartnerListCacheSummary)sesObj.getCacheObj(), PortalConstant.LOOKUP_BILLER_LIST));
					sc.setAttribute(PortalConstant.JSON_BILLER_LIST, PartnerListCacheSummary.jsonBillers);

					break;

				case PortalConstant.LOOKUP_BANK_RULES_LIST:
				case PortalConstant.LOOKUP_AGGREGATOR_RULES_LIST:
				case PortalConstant.LOOKUP_BILLER_RULES_LIST:
				case PortalConstant.LOOKUP_SUBBILLER_RULES_LIST:
				case PortalConstant.LOOKUP_SADAD_RULES_LIST:
					sc.setAttribute(sesObj.getCacheRefreshType(), 
							BusinessRulesListCache.updteBusinessRulesListCache(
									(BusinessRulesListCache)sesObj.getCacheObj(), sesObj.getCacheRefreshType()));
					
					break;
					
				default: // There is no other case need to be implemented.
					break;
			}

			sesObj.setCacheObj(null);
			sesObj.setCacheRefreshType(null);
		}
		
		// To add sesObj to Portlet Session Scope
		request.getPortletSession().setAttribute(PortalConstant.PORTLET_SESSION_BEAN, sesObj, PortletSession.PORTLET_SCOPE);
	}	
	
	/**
	 * Returns JSP file path.
	 * 
	 * @param jspFile
	 *            JSP file name
	 * @return JSP file path
	 */
	protected static String getJspFilePath(String jspFolder, String jspFile)
	{
		StringBuilder filePath = new StringBuilder();
		if (jspFile.startsWith("core_"))
			filePath.append(JSP_CORE_FOLDER).append(jspFile).append(JSP_EXTENTION);
		else
			filePath.append(jspFolder).append(jspFile).append(JSP_EXTENTION);
		return filePath.toString();
	}
	
	/**
	 * Reads all the request attributes starting with param_ and populate the values in SessionBean object
	 * 
	 * @param request - PortletRequest object which contains the request parameter to process
	 * @param so - SadadPortalSessionDataBean object which needs to be populated with request parameters
	 * @param castTo - Class of the object which returned object will be casted to
	 * @return - SadadPortalSessionDataBean object after setting the request parameter in session object and casted to castTo
	 */
	protected <T>T populateRequestParamsInSessionBean(PortletRequest request, SadadPortalSessionDataBean so, Class<T> castTo)
	{
		so.setLanguageCode(request.getLocale().getLanguage()); // sets the request language code
		Enumeration<String> enm = request.getParameterNames();
		while (enm.hasMoreElements())
		{
			String attrName = enm.nextElement();
			if (attrName.startsWith(PortalConstant.REQUEST_PARAMETER_INITIALS)) // starts with param_
			{
				String fieldName = attrName.substring(PortalConstant.REQUEST_PARAMETER_INITIALS.length());
				String attrValue = request.getParameter(attrName).trim(); // Trim to fix defect # 3615
				
				// Handling PortletRequest assignment - Special Case for PUMA class
				if(fieldName.equalsIgnoreCase("request"))
				{
					so.setRequest(request);
					continue;
				}
				
				// Setting blank or empty value to null
				if (attrValue.trim().length() == 0) 
					attrValue = null;
				
				Class<?> clas = so.getClass();
				do
				{
					try
					{
						Field field = clas.getDeclaredField(fieldName);
						field.setAccessible(true);
						// Most of the time, the incoming params are in String
						if (field.getType() == String.class)
							field.set(so, attrValue);
						else if (field.getType() == boolean.class)
							field.setBoolean(so, Boolean.parseBoolean(attrValue));
						else if (field.getType() == int.class)
							field.setInt(so, Integer.parseInt(attrValue));
						else if (field.getType() == long.class)
							field.setLong(so, Long.parseLong(attrValue));
						else if (field.getType() == float.class)
							field.setFloat(so, Float.parseFloat(attrValue));
						else if (field.getType() == double.class)
							field.setDouble(so, Double.parseDouble(attrValue));
						else if (field.getType() == byte.class)
							field.setByte(so, Byte.parseByte(attrValue));
						else if (field.getType() == char.class)
							field.setChar(so, attrValue.charAt(0));
						else if (field.getType() == short.class)
							field.setShort(so, Short.valueOf(attrValue));

						break;
					}
					catch (NoSuchFieldException e)
					{
						clas = clas.getSuperclass();
					}
					catch (Exception e)
					{
						throw new IllegalStateException(e);
					}
				} while (clas != null);
			}
		}
		return castTo.cast(so);
	}
	
	/**
	 * Calls the backend web service operation, which is provided in so.operation field and called using ch.operationName method.
	 * 
	 * @param so - SadadPortalSessionDataBean object which is required for extracting operation name to be called.
	 * @param ch - PortalServiceCallHelper or it subclass object from which the method will be called.
	 * @param castTo - Class of the object which returned object will be casted to
	 * @return - SadadPortalSessionDataBean object after setting the request parameter in session object and casted to castTo
	 */
	protected <T>T callRequiredBackEndServiceOperation(SadadPortalSessionDataBean so, PortalServiceCallHelper ch, Class<T> castTo)
	{
		if(so.getOperation() != null)
		{
			Class<?> clas = ch.getClass();
			do
			{
				try
				{
					Class<?>[] paramType = { so.getClass(), };
					Method method = clas.getMethod(so.getOperation(), paramType);
					method.setAccessible(true);
					so.setOperation(null); // Sets the operation explicitly to NULL to avoid any un-necessary operations call
					return castTo.cast(method.invoke(ch, so));
				}
				catch (NoSuchMethodException e)
				{
					clas = clas.getSuperclass();
				}
				catch (Exception e)
				{
					throw new IllegalStateException(e);
				}
			} while (clas != null);
		}
		else
			return castTo.cast(so);
		
		logger.logp(Level.WARNING, CLASS_NAME, "callRequiredBackEndServiceOperation", 
				"NoSuchMethodException occurs or no method found for {0} in {1}, and in its parent class.", new Object[]{so.getOperation(), ch.getClass().getName()});

		return null;
	}
	
	/**
	 * Call to extract the current user name from the request and pull his/her more details from LDAP server,
	 * like which organisation he/she belongs to.
	 * 
	 * @param request - PortletRequest object to get the user of the request.
	 * @param so - Session Data Bean object to set the values of permission and partner key 
	 * @param castTo - at the time of return cast the so object to this class
	 * @return
	 */
	protected <T>T populateUserDetailsInSessionBean(PortletRequest request, SadadPortalSessionDataBean so, Class<T> castTo) 
	{
		so.setRemoteUser(request.getRemoteUser());
		// Read the userInfo from the application session scope
		String[] userInfo = (String[]) request.getPortletSession().getAttribute(PortalConstant.USER_INFO_APPLICATION_SESSION, PortletSession.APPLICATION_SCOPE);

		if(userInfo != null)
		{
			so.setPartnerKey(userInfo[0]);
			so.setPartnerType(userInfo[1]);
			so.setUserType(userInfo[2]);
			so.setUserGroups(userInfo[3]);
		}
		else
		{
			userInfo = SadadPumaUtils.whoAmI(psh, request);
			if (userInfo != null)
			{
				so.setPartnerKey(userInfo[0]);
				so.setPartnerType(userInfo[1]);
				so.setUserType(userInfo[2]);
				so.setUserGroups(userInfo[3]);
			}
			else
			{
				logger.logp(Level.INFO, CLASS_NAME, "populateUserDetailsInSessionBean", "Unable to get the custom LDAP user attributes from LDAP. Checking for DEVELOPMENT mode in absence of LDAP attributes.");
				final ResourceBundle rb = ResourceBundle.getBundle("com.sadad.SadadDynamicDataConfiguration");
				if (Boolean.parseBoolean(rb.getString("DEVELOPER_MODE")))
				{
					logger.logp(Level.INFO, CLASS_NAME, "populateUserDetailsInSessionBean", "Portal is running in DEVELOPMENT mode.");
					so.setPartnerKey(rb.getString("DEVELOPER_MODE_PARTNER_KEY"));
					so.setPartnerType(rb.getString("DEVELOPER_MODE_PARTNER_TYPE"));
					so.setUserType(rb.getString("DEVELOPER_MODE_USER_TYPE"));
					so.setUserGroups(rb.getString("DEVELOPER_MODE_USER_GROUP"));
					// setting in Array for Application Session storage
					userInfo = new String[4];
					userInfo[0] = so.getPartnerKey();
					userInfo[1] = so.getPartnerType();
					userInfo[2] = so.getUserType();
					userInfo[3] = so.getUserGroups();
				}
				else
					// Throwing IllegalStateException here instead of inside whoAmI method is because of Testing of Portlet on Portal Server without LDAP integration will not work.
					throw new IllegalStateException();
			}
			request.getPortletSession().setAttribute(PortalConstant.USER_INFO_APPLICATION_SESSION, userInfo, PortletSession.APPLICATION_SCOPE);
		}
		return castTo.cast(so);
	}
	
	/**
	 * Compose a JSON string error object to be rendered on JSP using JavaScript callback.
	 * 
	 * @param so - SadadPortalSessionDataBean object which
	 * @return - returns the JSON error string object 
	 */
	protected String composeJsonResponse(SadadPortalSessionDataBean so)
	{
		char col = ':';
		char comma = ',';
		char quote = '"';
		char ob = '{';
		char cb = '}';
		StringBuilder response = new StringBuilder();
		response.append(ob);
		response.append(quote).append(PortalConstant.MESSAGE_TYPE).append(quote).append(col);
		response.append(quote).append(so.getMessageToDisplay().getMessageType().toString()).append(quote).append(comma);
		response.append(quote).append(PortalConstant.DISPLAY_MESSAGE).append(quote).append(col);
		response.append(quote).append(so.getMessageToDisplay().getDisplayMessage()).append(quote);
		response.append(cb);
		return response.toString();
	}
	
	/**
	 * Call to extract the LTPA Token value form the Request Cookie, and save in the Sesion Bean object.
	 * 
	 * @param request - PortletRequest object to get the attached HTTP Cookies from the request.
	 * @param so - Session Data Bean object to set the values of LTPA Tokeb value 
	 * @param castTo - at the time of return cast the so object to this class
	 * @return
	 */
	protected <T>T grabLtpaToken(PortletRequest request, SadadPortalSessionDataBean so, Class<T> castTo)
	{
		String ltpaToken = Arrays.stream(request.getCookies()).filter(c -> "LtpaToken2".equals(c.getName())).map(Cookie::getValue).findAny().get();
		so.setLtpaTokenValue(ltpaToken);
		return castTo.cast(so);
	}
}