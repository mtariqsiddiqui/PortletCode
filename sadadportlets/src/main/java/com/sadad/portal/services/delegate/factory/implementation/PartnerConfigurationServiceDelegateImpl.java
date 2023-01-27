package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationRsType;
import com.sadad.ebpp.wsdl.partnerconfigurationservice._1.PartnerConfigurationFault;
import com.sadad.ebpp.wsdl.partnerconfigurationservice._1.PartnerConfigurationService;
import com.sadad.portal.services.client.proxy.PartnerConfigurationServiceSOAPProxy;

public class PartnerConfigurationServiceDelegateImpl implements PartnerConfigurationServiceDelegate
{
	private static PartnerConfigurationServiceDelegateImpl instance;
	private PartnerConfigurationServiceSOAPProxy proxy;
	private PartnerConfigurationService service;

	private PartnerConfigurationServiceDelegateImpl()
	{
		proxy = new PartnerConfigurationServiceSOAPProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.PARTNER_CONFIGURATION_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of PartnerConfigurationServiceDelegateImpl
	 * 
	 * @return
	 */
	public static PartnerConfigurationServiceDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new PartnerConfigurationServiceDelegateImpl();
		}
		return instance;
	}

	@Override
	public GetConfigurationRsType getConfiguration(GetConfigurationRqType req) throws PartnerConfigurationFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_CONFIGURATION_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("GetConfigurationRq", GetConfigurationRqType.class, req);

		GetConfigurationRsType res = service.getConfiguration(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("GetConfigurationRs", GetConfigurationRsType.class, res);

		return res;
	}

	@Override
	public CreateConfigurationTemplateRsType createConfigurationTemplate(CreateConfigurationTemplateRqType req) throws PartnerConfigurationFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_CONFIGURATION_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("CreateConfigurationTemplateRq", CreateConfigurationTemplateRqType.class, req);

		CreateConfigurationTemplateRsType res = service.createConfigurationTemplate(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("CreateConfigurationTemplateRs", CreateConfigurationTemplateRsType.class, res);

		return res;
	}

	@Override
	public ActivateConfigurationRsType activateConfiguration(ActivateConfigurationRqType req) throws PartnerConfigurationFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_CONFIGURATION_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ActivateConfigurationRq", ActivateConfigurationRqType.class, req);

		ActivateConfigurationRsType res = service.activateConfiguration(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ActivateConfigurationRs", ActivateConfigurationRsType.class, res);

		return res;
	}

	@Override
	public DeactivateConfigurationRsType deactivateConfiguration(DeactivateConfigurationRqType req) throws PartnerConfigurationFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_CONFIGURATION_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("DeactivateConfigurationRq", DeactivateConfigurationRqType.class, req);

		DeactivateConfigurationRsType res = service.deactivateConfiguration(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("DeactivateConfigurationRs", DeactivateConfigurationRsType.class, res);

		return res;
	}

	@Override
	public ActivateConfigurationTemplateRsType activateConfigurationTemplate(ActivateConfigurationTemplateRqType req) throws PartnerConfigurationFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_CONFIGURATION_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ActivateConfigurationTemplateRq", ActivateConfigurationTemplateRqType.class, req);

		ActivateConfigurationTemplateRsType res = service.activateConfigurationTemplate(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ActivateConfigurationTemplateRs", ActivateConfigurationTemplateRsType.class, res);

		return res;
	}

	@Override
	public DeactivateConfigurationTemplateRsType deactivateConfigurationTemplate(DeactivateConfigurationTemplateRqType req) throws PartnerConfigurationFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_CONFIGURATION_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("DeactivateConfigurationTemplateRq", DeactivateConfigurationTemplateRqType.class, req);

		DeactivateConfigurationTemplateRsType res = service.deactivateConfigurationTemplate(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("DeactivateConfigurationTemplateRs", DeactivateConfigurationTemplateRsType.class, res);

		return res;
	}
}