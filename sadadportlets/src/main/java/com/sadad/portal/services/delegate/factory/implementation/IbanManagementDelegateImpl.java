package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.schema.service.ibanmanagement._1.CreateIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.CreateIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ListIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ListIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ProcessIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ProcessIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.UpdateIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.UpdateIBANRsType;
import com.sadad.ebpp.wsdl.ibanmanagement._1.IBANManagementFault;
import com.sadad.ebpp.wsdl.ibanmanagement._1.IBANManagementPort;
import com.sadad.portal.services.client.proxy.IBANManagementPortProxy;

public class IbanManagementDelegateImpl implements IbanManagementDelegate
{
	private static IbanManagementDelegateImpl instance;
	private IBANManagementPortProxy proxy;
	private IBANManagementPort service;

	private IbanManagementDelegateImpl()
	{
		proxy = new IBANManagementPortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.IBAN_MANAGEMENT_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of IbanManagementDelegateImpl
	 * 
	 * @return
	 */
	public static IbanManagementDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new IbanManagementDelegateImpl();
		}
		return instance;
	}

	@Override
	public CreateIBANRsType createIBAN(CreateIBANRqType req) throws IBANManagementFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.IBAN_MANAGEMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CreateIBANRq", CreateIBANRqType.class, req);

		CreateIBANRsType res = service.createIBAN(req);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CreateIBANRs", CreateIBANRsType.class, res);

		return res;
	}

	@Override
	public ListIBANRsType listIBAN(ListIBANRqType req) throws IBANManagementFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.IBAN_MANAGEMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListIBANRq", ListIBANRqType.class, req);

		ListIBANRsType res = service.listIBAN(req);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListIBANRs", ListIBANRsType.class, res);

		return res;
	}

	@Override
	public ProcessIBANRsType processIBAN(ProcessIBANRqType req) throws IBANManagementFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.IBAN_MANAGEMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ProcessIBANRq", ProcessIBANRqType.class, req);

		ProcessIBANRsType res = service.processIBAN(req);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ProcessIBANRs", ProcessIBANRsType.class, res);
		
		return res;
	}

	@Override
	public UpdateIBANRsType updateIBAN(UpdateIBANRqType req) throws IBANManagementFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.IBAN_MANAGEMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdateIBANRq", UpdateIBANRqType.class, req);

		UpdateIBANRsType res = service.updateIBAN(req);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdateIBANRs", UpdateIBANRsType.class, res);

		return res;
	}
}