package com.sadad.portal.services.client.proxy;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.sadad.ebpp.schema.service.ibanmanagement._1.CreateIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.CreateIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ListIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ListIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ProcessIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ProcessIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.UpdateIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.UpdateIBANRsType;
import com.sadad.ebpp.wsdl.ibanmanagement._1.IBANManagementFault;

public class IBANManagementPortProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private com.sadad.ebpp.wsdl.ibanmanagement._1.IBANManagement _service = null;
		private com.sadad.ebpp.wsdl.ibanmanagement._1.IBANManagementPort _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new com.sadad.ebpp.wsdl.ibanmanagement._1.IBANManagement(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new com.sadad.ebpp.wsdl.ibanmanagement._1.IBANManagement();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getIBANManagementPort();
		}

		public com.sadad.ebpp.wsdl.ibanmanagement._1.IBANManagementPort getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("", "IBANManagementPort");
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

	public IBANManagementPortProxy()
	{
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public IBANManagementPortProxy(URL wsdlLocation, QName serviceName)
	{
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor()
	{
		return _descriptor;
	}

	public CreateIBANRsType createIBAN(CreateIBANRqType createIBANRq) throws IBANManagementFault
	{
		return _getDescriptor().getProxy().createIBAN(createIBANRq);
	}

	public UpdateIBANRsType updateIBAN(UpdateIBANRqType updateIBANRq) throws IBANManagementFault
	{
		return _getDescriptor().getProxy().updateIBAN(updateIBANRq);
	}

	public ListIBANRsType listIBAN(ListIBANRqType listIBANRq) throws IBANManagementFault
	{
		return _getDescriptor().getProxy().listIBAN(listIBANRq);
	}

	public ProcessIBANRsType processIBAN(ProcessIBANRqType processIBANRq) throws IBANManagementFault
	{
		return _getDescriptor().getProxy().processIBAN(processIBANRq);
	}

}