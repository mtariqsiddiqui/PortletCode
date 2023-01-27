/**
 * 
 */
package com.sadad.portal.portlets.content;

import java.io.IOException;
import java.util.logging.Logger;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.sadad.portal.SadadGenericPortlet;
import com.sadad.portal.beans.ContentSessionDataBean;
import com.sadad.portal.constant.PortalConstant;

/**
 * @author Tariq Siddiqui
 *
 */
public class SadadTermsAndConditionsPortlet extends SadadGenericPortlet
{
	private static final String CLASS_NAME = SadadTermsAndConditionsPortlet.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	private static final String JSP_FOLDER = "/jsp/html/content/tac/"; // JSP folder name
	private static final String VIEW_JSP_INDEX = "TermsAndConditionsIndex"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_TERMS_AND_CONDITION = "TermsAndConditionsDisplay"; // JSP file name to be rendered on the view mode

	private ContentSessionDataBean sesObj;
	
	/**
	 * Serve up the <code>view</code> mode.
	 * 
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
	{
		final String methodName = "doView";
		logger.entering(CLASS_NAME, methodName);
		// Set the MIME type for the render response
		response.setContentType(request.getResponseContentType());

		sesObj = getSessionBeanObject(request, ContentSessionDataBean.class);
		if (sesObj == null)
		{
			sesObj = new ContentSessionDataBean();
			sesObj.getScreen().setContainer1(getJspFilePath(JSP_FOLDER, VIEW_JSP_TERMS_AND_CONDITION));
			sesObj.getScreen().setContainer2(null);
			sesObj = populateUserDetailsInSessionBean(request, sesObj, ContentSessionDataBean.class);
		}
				
		// Setting attributes in Request scope
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, sesObj);
		setSessionBeanObject(request, sesObj);
		
		// Invoke the JSP to render
		PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(JSP_FOLDER, VIEW_JSP_INDEX));
		rd.include(request, response);
		logger.exiting(CLASS_NAME, methodName);
	}
}
