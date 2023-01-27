package com.sadad.portal.services.client.proxy;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.sadad.ebpp.wsdl.accountquery._1.AccountQuery;
import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryFault;
import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryPort;
import com.sadad.schema.service.accountquery._1.GetByKeyRqType;
import com.sadad.schema.service.accountquery._1.GetByKeyRsType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRqType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRsType;
import com.sadad.schema.service.accountquery._1.ListByKeysRqType;
import com.sadad.schema.service.accountquery._1.ListByKeysRsType;

public class AccountQueryPortProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private AccountQuery _service = null;
		private AccountQueryPort _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new AccountQuery(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new AccountQuery();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getAccountQueryPort();
		}

		public AccountQueryPort getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("http://www.sadad.com/EBPP/wsdl/AccountQuery/1.0", "AccountQueryPort");
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

	public AccountQueryPortProxy()
	{
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public AccountQueryPortProxy(URL wsdlLocation, QName serviceName)
	{
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor()
	{
		return _descriptor;
	}

	public GetByKeyRsType getByKey(GetByKeyRqType getByKeyRq) throws AccountQueryFault
	{
		return _getDescriptor().getProxy().getByKey(getByKeyRq);
	}

	public ListByKeysRsType listByKeys(ListByKeysRqType listByKeysRq) throws AccountQueryFault
	{
		return _getDescriptor().getProxy().listByKeys(listByKeysRq);
	}

	public ListByCustomerRsType listByCustomer(ListByCustomerRqType listByCustomerRq) throws AccountQueryFault
	{
		return _getDescriptor().getProxy().listByCustomer(listByCustomerRq);
	}

}