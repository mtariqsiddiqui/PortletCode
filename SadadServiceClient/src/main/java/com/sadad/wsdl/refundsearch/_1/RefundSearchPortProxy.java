package com.sadad.wsdl.refundsearch._1;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.sadad.schema.service.refundsearch._1.GetRefundRqType;
import com.sadad.schema.service.refundsearch._1.GetRefundRsType;
import com.sadad.schema.service.refundsearch._1.ListRefundRqType;
import com.sadad.schema.service.refundsearch._1.ListRefundRsType;

public class RefundSearchPortProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private com.sadad.wsdl.refundsearch._1.RefundSearch _service = null;
		private com.sadad.wsdl.refundsearch._1.RefundSearchPort _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new com.sadad.wsdl.refundsearch._1.RefundSearch(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new com.sadad.wsdl.refundsearch._1.RefundSearch();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getRefundSearchPort();
		}

		public com.sadad.wsdl.refundsearch._1.RefundSearchPort getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("http://sadad.com/wsdl/RefundSearch/1.0", "RefundSearchPort");
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

}