package com.sadad.portal.services.client.proxy;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

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
import com.sadad.ebpp.wsdl.partnermanagementservice._1.PartnerManagementService;

public class PartnerManagementPortProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private PartnerManagementService _service = null;
		private PartnerManagementPort _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new PartnerManagementService(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new PartnerManagementService();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getPartnerManagementPort();
		}

		public PartnerManagementPort getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("", "PartnerManagementPort");
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

	public PartnerManagementPortProxy()
	{
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public PartnerManagementPortProxy(URL wsdlLocation, QName serviceName)
	{
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor()
	{
		return _descriptor;
	}

	public CreatePartnerRsType createPartner(CreatePartnerRqType createPartnerRq) throws PartnerManagementFault
	{
		return _getDescriptor().getProxy().createPartner(createPartnerRq);
	}

	public UpdatePartnerStatusRsType updatePartnerStatus(UpdatePartnerStatusRqType updatePartnerStatusRq) throws PartnerManagementFault
	{
		return _getDescriptor().getProxy().updatePartnerStatus(updatePartnerStatusRq);
	}

	public TransferPartnerRsType transferPartner(TransferPartnerRqType transferPartnerRq) throws PartnerManagementFault
	{
		return _getDescriptor().getProxy().transferPartner(transferPartnerRq);
	}

	public UpdatePartnersDetailsRsType updatePartnersDetails(UpdatePartnersDetailsRqType updatePartnersDetailsRq) throws PartnerManagementFault
	{
		return _getDescriptor().getProxy().updatePartnersDetails(updatePartnersDetailsRq);
	}

}