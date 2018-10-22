package com.sadad.wsdl.corepayment._1;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import com.sadad.schema.service.corepayment._1.CancelRqType;
import com.sadad.schema.service.corepayment._1.CancelRsType;
import com.sadad.schema.service.corepayment._1.ListByAccountRqType;
import com.sadad.schema.service.corepayment._1.ListByAccountRsType;
import com.sadad.schema.service.corepayment._1.ListByBeneficiaryRqType;
import com.sadad.schema.service.corepayment._1.ListByBeneficiaryRsType;
import com.sadad.schema.service.corepayment._1.ListByBillIdRqType;
import com.sadad.schema.service.corepayment._1.ListByBillIdRsType;
import com.sadad.schema.service.corepayment._1.ListByIdRqType;
import com.sadad.schema.service.corepayment._1.ListByIdRsType;
import com.sadad.schema.service.corepayment._1.ListByPayorRqType;
import com.sadad.schema.service.corepayment._1.ListByPayorRsType;
import com.sadad.schema.service.corepayment._1.UncancelRqType;
import com.sadad.schema.service.corepayment._1.UncancelRsType;

public class CorePaymentPortProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private com.sadad.wsdl.corepayment._1.CorePayment _service = null;
		private com.sadad.wsdl.corepayment._1.CorePaymentPort _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new com.sadad.wsdl.corepayment._1.CorePayment(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new com.sadad.wsdl.corepayment._1.CorePayment();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getCorePaymentPort();
		}

		public com.sadad.wsdl.corepayment._1.CorePaymentPort getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("http://sadad.com/wsdl/CorePayment/1.0", "CorePaymentPort");
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

	public CorePaymentPortProxy()
	{
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public CorePaymentPortProxy(URL wsdlLocation, QName serviceName)
	{
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor()
	{
		return _descriptor;
	}

	public CancelRsType cancel(CancelRqType cancelRq) throws PaymentFault
	{
		return _getDescriptor().getProxy().cancel(cancelRq);
	}

	public UncancelRsType uncancel(UncancelRqType uncancelRq) throws PaymentFault
	{
		return _getDescriptor().getProxy().uncancel(uncancelRq);
	}

	public ListByIdRsType listById(ListByIdRqType listByIdRq) throws PaymentFault
	{
		return _getDescriptor().getProxy().listById(listByIdRq);
	}

	public ListByPayorRsType listByPayor(ListByPayorRqType listByPayorRq) throws PaymentFault
	{
		return _getDescriptor().getProxy().listByPayor(listByPayorRq);
	}

	public ListByAccountRsType listByAccount(ListByAccountRqType listByAccountRq) throws PaymentFault
	{
		return _getDescriptor().getProxy().listByAccount(listByAccountRq);
	}

	public ListByBillIdRsType listByBillId(ListByBillIdRqType listByBillIdRq) throws PaymentFault
	{
		return _getDescriptor().getProxy().listByBillId(listByBillIdRq);
	}

	public ListByBeneficiaryRsType listByBeneficiary(ListByBeneficiaryRqType listByBeneficiaryRq) throws PaymentFault
	{
		return _getDescriptor().getProxy().listByBeneficiary(listByBeneficiaryRq);
	}

}