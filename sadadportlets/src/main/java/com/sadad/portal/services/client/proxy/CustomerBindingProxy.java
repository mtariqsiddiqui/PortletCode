package com.sadad.portal.services.client.proxy;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.sadad.ebpp.scm.schema.customer._1.ActivateRqType;
import com.sadad.ebpp.scm.schema.customer._1.ActivateRsType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileAssnRqType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileAssnRsType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileDisassnRqType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileDisassnRsType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileInqRqType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileInqRsType;
import com.sadad.ebpp.scm.schema.customer._1.DeactivateRqType;
import com.sadad.ebpp.scm.schema.customer._1.DeactivateRsType;
import com.sadad.ebpp.scm.schema.customer._1.GetByKeyRqType;
import com.sadad.ebpp.scm.schema.customer._1.GetByKeyRsType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRqType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRsType;
import com.sadad.ebpp.scm.schema.customer._1.ListByBillRqType;
import com.sadad.ebpp.scm.schema.customer._1.ListByBillRsType;
import com.sadad.ebpp.wsdl.customer._1.CustomerFault;
import com.sadad.ebpp.wsdl.customer._1.CustomerPort;
import com.sadad.ebpp.wsdl.customer._1.CustomerService;

public class CustomerBindingProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private CustomerService _service = null;
		private CustomerPort _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new CustomerService(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new CustomerService();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getCustomerPort();
		}

		public com.sadad.ebpp.wsdl.customer._1.CustomerPort getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("http://www.sadad.com/EBPP/wsdl/Customer/1.0", "CustomerBinding");
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

	public CustomerBindingProxy()
	{
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public CustomerBindingProxy(URL wsdlLocation, QName serviceName)
	{
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor()
	{
		return _descriptor;
	}

	public CustProfileAssnRsType customerAssociation(CustProfileAssnRqType customerAssociationRq) throws CustomerFault
	{
		return _getDescriptor().getProxy().customerAssociation(customerAssociationRq);
	}

	public CustProfileDisassnRsType customerDisassociation(CustProfileDisassnRqType customerDisassociationRq) throws CustomerFault
	{
		return _getDescriptor().getProxy().customerDisassociation(customerDisassociationRq);
	}

	public CustProfileInqRsType customerInquiry(CustProfileInqRqType customerInquiryRq) throws CustomerFault
	{
		return _getDescriptor().getProxy().customerInquiry(customerInquiryRq);
	}

	public ActivateRsType activate(ActivateRqType activateRq) throws CustomerFault
	{
		return _getDescriptor().getProxy().activate(activateRq);
	}

	public DeactivateRsType deactivate(DeactivateRqType deactivateRq) throws CustomerFault
	{
		return _getDescriptor().getProxy().deactivate(deactivateRq);
	}

	public GetByKeyRsType getByKey(GetByKeyRqType getByKeyRq) throws CustomerFault
	{
		return _getDescriptor().getProxy().getByKey(getByKeyRq);
	}

	public ListByAccountRsType listByAccount(ListByAccountRqType listByAccountRq) throws CustomerFault
	{
		return _getDescriptor().getProxy().listByAccount(listByAccountRq);
	}

	public ListByBillRsType listByBill(ListByBillRqType listByBillRq) throws CustomerFault
	{
		return _getDescriptor().getProxy().listByBill(listByBillRq);
	}

}