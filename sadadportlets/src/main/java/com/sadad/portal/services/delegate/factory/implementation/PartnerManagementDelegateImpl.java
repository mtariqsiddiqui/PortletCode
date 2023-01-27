package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.partnermanagementservice._1.CreatePartnerRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.CreatePartnerRsType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.TransferPartnerRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.TransferPartnerRsType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnerStatusRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnerStatusRsType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnersDetailsRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnersDetailsRsType;
import com.sadad.ebpp.wsdl.partnermanagementservice._1.PartnerManagementFault;
import com.sadad.ebpp.wsdl.partnermanagementservice._1.PartnerManagementPort;
import com.sadad.portal.services.client.proxy.PartnerManagementPortProxy;

public class PartnerManagementDelegateImpl implements PartnerManagementDelegate
{
	private static PartnerManagementDelegateImpl instance;
	private PartnerManagementPortProxy proxy;
	private PartnerManagementPort service;

	private PartnerManagementDelegateImpl()
	{
		proxy = new PartnerManagementPortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.PARTNER_MANAGEMENT_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of PartnerManagementDelegateImpl
	 * 
	 * @return
	 */
	public static PartnerManagementDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new PartnerManagementDelegateImpl();
		}
		return instance;
	}

	@Override
	public CreatePartnerRsType createPartner(CreatePartnerRqType rq) throws PartnerManagementFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_MANAGEMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CreatePartnerRq", CreatePartnerRqType.class, rq);
			
		CreatePartnerRsType rs = service.createPartner(rq);
			
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CreatePartnerRs", CreatePartnerRsType.class, rs);

		return rs;
	}

	@Override
	public UpdatePartnerStatusRsType updatePartnerStatus(UpdatePartnerStatusRqType rq) throws PartnerManagementFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_MANAGEMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdatePartnerStatusRq", UpdatePartnerStatusRqType.class, rq);
			
		UpdatePartnerStatusRsType rs = service.updatePartnerStatus(rq);
			
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdatePartnerStatusRs", UpdatePartnerStatusRsType.class, rs);

		return rs;
	}

	@Override
	public TransferPartnerRsType transferPartner(TransferPartnerRqType rq) throws PartnerManagementFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_MANAGEMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("TransferPartnerRq", TransferPartnerRqType.class, rq);
			
		TransferPartnerRsType rs = service.transferPartner(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("TransferPartnerRs", TransferPartnerRsType.class, rs);

		return rs;
	}

	@Override
	public UpdatePartnersDetailsRsType updatePartnersDetails(UpdatePartnersDetailsRqType rq) throws PartnerManagementFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_MANAGEMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("Q_Name", UpdatePartnersDetailsRqType.class, rq);
			
		UpdatePartnersDetailsRsType rs = service.updatePartnersDetails(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdatePartnersDetailsRs", UpdatePartnersDetailsRsType.class, rs);

		return rs;
	}
}