/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.filemanagementservice._1.MarkFileRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.MarkFileRsType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesAdvancedRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesRsType;
import com.sadad.ebpp.wsdl.filemanagementservice._1.FileManagementFault;
import com.sadad.ebpp.wsdl.filemanagementservice._1.FileManagementServicePort;
import com.sadad.portal.services.client.proxy.FileManagementServiceBindingProxy;

/**
 * @author Tariq Siddiqui
 * 
 */
public class FileManagementServiceDelegateImpl implements FileManagementServiceDelegate
{

	private static FileManagementServiceDelegateImpl instance;
	private FileManagementServiceBindingProxy proxy;
	private FileManagementServicePort service;

	private FileManagementServiceDelegateImpl()
	{
		proxy = new FileManagementServiceBindingProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.FILE_MANAGEMENT_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of FileManagementServiceDelegateImpl
	 * 
	 * @return
	 */
	public static FileManagementServiceDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new FileManagementServiceDelegateImpl();
		}
		return instance;
	}

	@Override
	public SearchFilesRsType searchFiles(SearchFilesRqType req) throws FileManagementFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.FILE_MANAGEMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("SearchFilesRq", SearchFilesRqType.class, req);

		SearchFilesRsType res = service.searchFiles(req);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("SearchFilesRs", SearchFilesRsType.class, res);
		
		return res;
	}

	@Override
	public MarkFileRsType markFile(MarkFileRqType req) throws FileManagementFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.FILE_MANAGEMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("MarkFileRq", MarkFileRqType.class, req);

		MarkFileRsType res = service.markFile(req);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("MarkFileRs", MarkFileRsType.class, res);

		return res;
	}

	@Override
	public SearchFilesRsType searchFilesAdvanced(SearchFilesAdvancedRqType req) throws FileManagementFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.FILE_MANAGEMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("SearchFilesAdvancedRq", SearchFilesAdvancedRqType.class, req);

		SearchFilesRsType res = service.searchFilesAdvanced(req);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("SearchFilesRs", SearchFilesRsType.class, res);
		return res;
	}
}