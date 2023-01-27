package com.sadad.portal.services.client.proxy;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.sadad.ebpp.scm.schema.billernotification._1.NotifyPaymentBulkRqType;
import com.sadad.ebpp.scm.schema.billernotification._1.NotifyPaymentBulkRsType;
import com.sadad.ebpp.scm.schema.billernotification._1.NotifyRefundRqType;
import com.sadad.ebpp.scm.schema.billernotification._1.NotifyRefundRsType;
import com.sadad.ebpp.wsdl.billernotification._1.BillerNotification;
import com.sadad.ebpp.wsdl.billernotification._1.BillerNotificationPort;
import com.sadad.ebpp.wsdl.billernotification._1.NotifyPaymentBulkFault;
import com.sadad.ebpp.wsdl.billernotification._1.NotifyRefundFault;

public class BillerNotificationBindingProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private BillerNotification _service = null;
		private BillerNotificationPort _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new BillerNotification(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new BillerNotification();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getBillerNotificationBinding();
		}

		public com.sadad.ebpp.wsdl.billernotification._1.BillerNotificationPort getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("", "BillerNotificationBinding");
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

	public BillerNotificationBindingProxy()
	{
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public BillerNotificationBindingProxy(URL wsdlLocation, QName serviceName)
	{
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor()
	{
		return _descriptor;
	}

	public NotifyPaymentBulkRsType notifyPaymentBulk(NotifyPaymentBulkRqType notifyPaymentBulkRq) throws NotifyPaymentBulkFault
	{
		return _getDescriptor().getProxy().notifyPaymentBulk(notifyPaymentBulkRq);
	}

	public NotifyRefundRsType notifyRefund(NotifyRefundRqType notifyRefundRq) throws NotifyRefundFault
	{
		return _getDescriptor().getProxy().notifyRefund(notifyRefundRq);
	}

}