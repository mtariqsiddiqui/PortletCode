package com.sadad.portal.services.client.proxy;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.UpdateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.UpdateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.UpdateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.UpdateConfigurationTemplateRsType;
import com.sadad.ebpp.wsdl.partnerconfigurationservice._1.PartnerConfigurationFault;
import com.sadad.ebpp.wsdl.partnerconfigurationservice._1.PartnerConfigurationService;
import com.sadad.ebpp.wsdl.partnerconfigurationservice._1.PartnerConfigurationService_Service;

public class PartnerConfigurationServiceSOAPProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private PartnerConfigurationService_Service _service = null;
		private PartnerConfigurationService _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new PartnerConfigurationService_Service(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new PartnerConfigurationService_Service();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getPartnerConfigurationService();
		}

		public PartnerConfigurationService getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("", "PartnerConfigurationServiceSOAP");
				_dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

				String proxyEndpointUrl = getEndpoint();
				BindingProvider bp = (BindingProvider) _dispatch;
				String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
				if (!dispatchEndpointUrl.equals(proxyEndpointUrl))
					bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
			}
			return _dispatch;
		}

		public String getEndpoint()
		{
			BindingProvider bp = (BindingProvider) _proxy;
			return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
		}

		public void setEndpoint(String endpointUrl)
		{
			BindingProvider bp = (BindingProvider) _proxy;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

			if (_dispatch != null)
			{
				bp = (BindingProvider) _dispatch;
				bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
			}
		}

		public void setMTOMEnabled(boolean enable)
		{
			SOAPBinding binding = (SOAPBinding) ((BindingProvider) _proxy).getBinding();
			binding.setMTOMEnabled(enable);
		}
	}

	public PartnerConfigurationServiceSOAPProxy()
	{
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public PartnerConfigurationServiceSOAPProxy(URL wsdlLocation, QName serviceName)
	{
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor()
	{
		return _descriptor;
	}

	public GetConfigurationRsType getConfiguration(GetConfigurationRqType getConfigurationRq) throws PartnerConfigurationFault
	{
		return _getDescriptor().getProxy().getConfiguration(getConfigurationRq);
	}

	public CreateConfigurationRsType createConfiguration(CreateConfigurationRqType createConfigurationRq) throws PartnerConfigurationFault
	{
		return _getDescriptor().getProxy().createConfiguration(createConfigurationRq);
	}

	public UpdateConfigurationRsType updateConfiguration(UpdateConfigurationRqType updateConfigurationRq) throws PartnerConfigurationFault
	{
		return _getDescriptor().getProxy().updateConfiguration(updateConfigurationRq);
	}

	public ActivateConfigurationRsType activateConfiguration(ActivateConfigurationRqType activateConfigurationRq) throws PartnerConfigurationFault
	{
		return _getDescriptor().getProxy().activateConfiguration(activateConfigurationRq);
	}

	public DeactivateConfigurationRsType deactivateConfiguration(DeactivateConfigurationRqType deactivateConfigurationRq) throws PartnerConfigurationFault
	{
		return _getDescriptor().getProxy().deactivateConfiguration(deactivateConfigurationRq);
	}

	public GetConfigurationTemplateRsType getConfigurationTemplate(GetConfigurationTemplateRqType getConfigurationTemplateRq) throws PartnerConfigurationFault
	{
		return _getDescriptor().getProxy().getConfigurationTemplate(getConfigurationTemplateRq);
	}

	public CreateConfigurationTemplateRsType createConfigurationTemplate(CreateConfigurationTemplateRqType createConfigurationTemplateRq) throws PartnerConfigurationFault
	{
		return _getDescriptor().getProxy().createConfigurationTemplate(createConfigurationTemplateRq);
	}

	public UpdateConfigurationTemplateRsType updateConfigurationTemplate(UpdateConfigurationTemplateRqType updateConfigurationTemplateRq) throws PartnerConfigurationFault
	{
		return _getDescriptor().getProxy().updateConfigurationTemplate(updateConfigurationTemplateRq);
	}

	public ActivateConfigurationTemplateRsType activateConfigurationTemplate(ActivateConfigurationTemplateRqType activateConfigurationTemplateRq) throws PartnerConfigurationFault
	{
		return _getDescriptor().getProxy().activateConfigurationTemplate(activateConfigurationTemplateRq);
	}

	public DeactivateConfigurationTemplateRsType deactivateConfigurationTemplate(DeactivateConfigurationTemplateRqType deactivateConfigurationTemplateRq) throws PartnerConfigurationFault
	{
		return _getDescriptor().getProxy().deactivateConfigurationTemplate(deactivateConfigurationTemplateRq);
	}

}