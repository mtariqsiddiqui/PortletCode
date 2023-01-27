package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.wsdl.bulkuploadquery._1.BulkQueryFault;
import com.sadad.ebpp.wsdl.bulkuploadquery._1.BulkUploadQueryPort;
import com.sadad.portal.services.client.proxy.BulkUploadQueryPortProxy;
import com.sadad.schema.service.bulkuploadquery._1.GetRejectedRqType;
import com.sadad.schema.service.bulkuploadquery._1.GetRejectedRsType;
import com.sadad.schema.service.bulkuploadquery._1.ListRejectedRqType;
import com.sadad.schema.service.bulkuploadquery._1.ListRejectedRsType;

/**
 * @author Tariq Siddiqui
 *
 */

public class BulkUploadDelegateImpl implements BulkUploadDelegate
{

	private static BulkUploadDelegateImpl instance;
	private BulkUploadQueryPortProxy proxy;
	private BulkUploadQueryPort service;

	private BulkUploadDelegateImpl()
	{
		proxy = new BulkUploadQueryPortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.BULK_UPLOAD_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of BulkUploadDelegateImpl
	 * 
	 * @return
	 */
	public static BulkUploadDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new BulkUploadDelegateImpl();
		}
		return instance;
	}

	@Override
	public GetRejectedRsType getRejected(GetRejectedRqType req) throws BulkQueryFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.BULK_UPLOAD_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("GetRejectedRq", GetRejectedRqType.class, req);

		GetRejectedRsType res = service.getRejected(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("GetRejectedRs", GetRejectedRsType.class, res); 

		return res;
	}

	@Override
	public ListRejectedRsType listRejected(ListRejectedRqType listRejectedRq) throws BulkQueryFault
	{
		ListRejectedRsType listRejectedRs = service.listRejected(listRejectedRq);
		return listRejectedRs;
	}
}