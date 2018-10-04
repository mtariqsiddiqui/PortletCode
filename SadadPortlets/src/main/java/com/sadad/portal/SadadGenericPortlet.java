/**
 * 
 */
package com.sadad.portal;

import javax.portlet.GenericPortlet;

import com.sadad.portal.beans.SadadPortalSessionBean;
import com.sadad.portal.constant.PortalConstant;

/**
 * @author Tariq Siddiqui
 *
 */
public abstract class SadadGenericPortlet extends GenericPortlet
{
	private static final String JSP_EXTENTION = ".jsp"; // JSP folder name
	private static final String JSP_CORE_FOLDER = "/jsp/html/ebpp/core/"; // JSP folder name

	/**
	 * Handle the Screen handling logic. Any Form or Detail pages are displayed in Container 1 and Container 2 is empty, 
	 * whereas all the Summary and List pages are displayed in Container 2.
	 * 
	 * @param so Session Bean object
	 * @param jspFolder - Folder in which jsp file resides
	 * @param jspResourceId - Name of jsp file without extension (case sensitive)
	 */
	protected void screenHandling(SadadPortalSessionBean so, String jspFolder, String jspResourceId)
	{
		// Clear any previous messages
		if(so.getMessageToDisplay() != null)
			so.setMessageToDisplay(null);
		
		if (jspResourceId.endsWith("Form") || jspResourceId.endsWith("Details"))
		{
			so.navigate(PortalConstant.NEXT);
			
			so.getScreen().setContainer1(getJspFilePath(jspFolder, jspResourceId));
			so.getScreen().setContainer2(null);
		}
		else if (jspResourceId.endsWith("Summary") || jspResourceId.endsWith("List"))
		{
			so.getScreen().setContainer2(getJspFilePath(jspFolder, jspResourceId));
		}
	}

	/**
	 * Returns JSP file path.
	 * 
	 * @param request
	 *            Render request
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
}
