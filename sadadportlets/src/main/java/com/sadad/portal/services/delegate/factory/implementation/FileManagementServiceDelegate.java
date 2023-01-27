/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.filemanagementservice._1.MarkFileRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.MarkFileRsType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesAdvancedRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesRsType;
import com.sadad.ebpp.wsdl.filemanagementservice._1.FileManagementFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * @author Tariq Siddiqui
 * 
 */
public interface FileManagementServiceDelegate extends RequestResponseLogger
{
	public SearchFilesRsType searchFiles(SearchFilesRqType searchFilesRq) throws FileManagementFault;

	public MarkFileRsType markFile(MarkFileRqType markFileRq) throws FileManagementFault;

	public SearchFilesRsType searchFilesAdvanced(SearchFilesAdvancedRqType searchFilesAdvancedRq) throws FileManagementFault;
}