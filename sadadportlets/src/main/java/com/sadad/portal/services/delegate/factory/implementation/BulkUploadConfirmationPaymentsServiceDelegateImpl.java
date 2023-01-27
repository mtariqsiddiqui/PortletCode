package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.bulkuploadconfirmationservice._1.GenerateBulkUploadConfirmationFileRqType;
import com.sadad.ebpp.scm.schema.bulkuploadconfirmationservice._1.GenerateBulkUploadConfirmationFileRsType;
import com.sadad.ebpp.wsdl.bulkuploadconfirmationservice._1.BulkUploadConfirmationFault;
import com.sadad.ebpp.wsdl.bulkuploadconfirmationservice._1.BulkUploadConfirmationService;
import com.sadad.portal.services.client.proxy.BulkUploadConfirmationServicePortProxy;

public class BulkUploadConfirmationPaymentsServiceDelegateImpl implements BulkUploadConfirmationServiceDelegate
{
	private static BulkUploadConfirmationPaymentsServiceDelegateImpl instance;
	private BulkUploadConfirmationServicePortProxy proxy;
	private BulkUploadConfirmationService service;

	private BulkUploadConfirmationPaymentsServiceDelegateImpl()
	{
		proxy = new BulkUploadConfirmationServicePortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.BULK_UPLOAD_CONFIRMATION_PAYMENTS_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of BulkUploadConfirmationPaymentsServiceDelegateImpl
	 * 
	 * @return
	 */
	public static BulkUploadConfirmationPaymentsServiceDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new BulkUploadConfirmationPaymentsServiceDelegateImpl();
		}
		return instance;
	}

	@Override
	public GenerateBulkUploadConfirmationFileRsType generateBulkUploadConfirmation(GenerateBulkUploadConfirmationFileRqType req) throws BulkUploadConfirmationFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.BULK_UPLOAD_CONFIRMATION_PAYMENTS_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("GenerateBulkUploadConfirmationFileRq", GenerateBulkUploadConfirmationFileRqType.class, req);

		GenerateBulkUploadConfirmationFileRsType res = service.generateBulkUploadConfirmation(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("GenerateBulkUploadConfirmationFileRs", GenerateBulkUploadConfirmationFileRsType.class, res); 

		return res;
	}
}