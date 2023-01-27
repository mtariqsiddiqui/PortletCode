package com.sadad.portal.services.client.proxy;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.sadad.ebpp.wsdl.refundsearch._1.RefundFault;
import com.sadad.ebpp.wsdl.refundsearch._1.RefundSearch;
import com.sadad.ebpp.wsdl.refundsearch._1.RefundSearchPort;
import com.sadad.schema.service.refundsearch._1.GetRefundRqType;
import com.sadad.schema.service.refundsearch._1.GetRefundRsType;
import com.sadad.schema.service.refundsearch._1.ListRefundRqType;
import com.sadad.schema.service.refundsearch._1.ListRefundRqTypePortal;
import com.sadad.schema.service.refundsearch._1.ListRefundRsType;
import com.sadad.schema.service.refundsearch._1.ListRefundRsTypePortal;

public class RefundSearchPortProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private RefundSearch _service = null;
		private RefundSearchPort _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new RefundSearch(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new RefundSearch();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getRefundSearchPort();
		}

		public RefundSearchPort getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("", "RefundSearchPort");
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

	public RefundSearchPortProxy()
	{
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public RefundSearchPortProxy(URL wsdlLocation, QName serviceName)
	{
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor()
	{
		return _descriptor;
	}

	public GetRefundRsType getRefund(GetRefundRqType getRefundRq) throws RefundFault
	{
		return _getDescriptor().getProxy().getRefund(getRefundRq);
	}

	public ListRefundRsType listRefund(ListRefundRqType listRefundRq) throws RefundFault
	{
		return _getDescriptor().getProxy().listRefund(listRefundRq);
	}

	public ListRefundRsTypePortal listRefundPortal(ListRefundRqTypePortal listRefundRqPortal) throws RefundFault
	{
		return _getDescriptor().getProxy().listRefundPortal(listRefundRqPortal);
	}

}