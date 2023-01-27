/**
 * 
 */
package com.sadad.portal.common.utils;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.ServletContext;

import com.ibm.ws.portletcontainer.portlet.PortletUtils;

/**
 * @author Tariq Siddiqui
 * 
 */
public class SadadPortalUtils
{
	/**
	 * Formats the logging output, takes the input of String and desired length, then append blank space (upto desired length) in front of String and return
	 * 
	 * @param str
	 * @param len
	 * @return formatted String
	 */
	private static String logFormatter(String str, int len)
	{
		StringBuilder sb = new StringBuilder(str);
		char sp = ' ';
		char co = ':';

		if (str.length() >= len)
			sb.append(sp);
		else
		{
			int j = (len - str.length());
			for (int i = 0; i < j; i++)
			{
				sb.append(sp);
			}
		}
		sb.append(co).append(sp);
		return sb.toString();
	}

	/**
	 * Logging the list of all session attributes and their values
	 * 
	 * @param request
	 *            HttpServletRequest object required to read session and session attributes
	 * @param methodName
	 *            name of the delegator method
	 */
	public static void logSessionAttributesWithValues(PortletRequest request, String methodName, Logger logger)
	{
		if (logger.isLoggable(Level.FINE))
		{
			char[] ln = "------------------------------------------------------------------------------------------".toCharArray();
			char lsp = System.getProperty("line.separator").toCharArray()[0];
			StringBuilder sb = new StringBuilder(lsp);
			sb.append(lsp).append(ln).append(lsp);
			sb.append("Displaying all the Portlet Context Session Attributes Name / Values - Portlet Scope").append(lsp).append(ln).append(lsp);
			Enumeration<String> e = request.getPortletSession().getAttributeNames(PortletSession.PORTLET_SCOPE);
			while (e.hasMoreElements())
			{
				String attrName = e.nextElement();
				Object attrValue = (Object) request.getPortletSession().getAttribute(attrName);
				attrName = logFormatter(attrName, 50);
				sb.append(attrName).append(attrValue).append(lsp);
			}

			sb.append(lsp).append(ln).append(lsp);
			sb.append("Displaying all the Portlet Context Session Attributes Name / Values - Application Scope").append(lsp).append(ln).append(lsp);
			e = request.getPortletSession().getAttributeNames(PortletSession.APPLICATION_SCOPE);
			while (e.hasMoreElements())
			{
				String attrName = e.nextElement();
				Object attrValue = (Object) request.getPortletSession().getAttribute(attrName);
				attrName = logFormatter(attrName, 50);
				sb.append(attrName).append(attrValue).append(lsp);
			}

			sb.append(lsp).append(ln).append(lsp);
			sb.append("Displaying all the Servlet Context Session Attributes Name / Values").append(lsp).append(ln).append(lsp);			
			ServletContext sc = PortletUtils.getHttpServletRequest(request).getServletContext();
			e = sc.getAttributeNames();
			while (e.hasMoreElements())
			{
				String attrName = e.nextElement();
				Object attrValue = (Object) sc.getAttribute(attrName);
				attrName = logFormatter(attrName, 50);
				sb.append(attrName).append(attrValue).append(lsp);
			}
			
			sb.append(lsp).append(ln).append(lsp);
			sb.append("Displaying all the Request Attributes Name / Values").append(lsp).append(ln).append(lsp);			
			e = request.getAttributeNames();
			while (e.hasMoreElements())
			{
				String attrName = e.nextElement();
				Object attrValue = (Object) request.getAttribute(attrName);
				attrName = logFormatter(attrName, 25);
				sb.append(attrName).append(attrValue).append(lsp);
			}
			
			sb.append(lsp).append(ln).append(lsp);
			sb.append("Displaying all the Request Parameter Name / Values").append(lsp).append(ln).append(lsp);			
			e = request.getParameterNames();
			while (e.hasMoreElements())
			{
				String attrName = e.nextElement();
				Object attrValue = (Object) request.getParameter(attrName);
				attrName = logFormatter(attrName, 25);
				sb.append(attrName).append(attrValue).append(lsp);
			}
			
			logger.logp(Level.FINE, logger.getName(), methodName, sb.toString());
		}
	}
}