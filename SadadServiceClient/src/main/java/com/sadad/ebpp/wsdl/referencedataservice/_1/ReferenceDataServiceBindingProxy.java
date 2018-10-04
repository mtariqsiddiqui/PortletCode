package com.sadad.ebpp.wsdl.referencedataservice._1;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.sadad.ebpp.schema.referencedata._1.ActivateAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.ActivateAccessChannelRsType;
import com.sadad.ebpp.schema.referencedata._1.ActivateAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.ActivateAccountTypeRsType;
import com.sadad.ebpp.schema.referencedata._1.ActivateDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.ActivateDistrictCodeRsType;
import com.sadad.ebpp.schema.referencedata._1.ActivatePaymentMethodRqType;
import com.sadad.ebpp.schema.referencedata._1.ActivatePaymentMethodRsType;
import com.sadad.ebpp.schema.referencedata._1.CreateAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.CreateAccessChannelRsType;
import com.sadad.ebpp.schema.referencedata._1.CreateAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.CreateAccountTypeRsType;
import com.sadad.ebpp.schema.referencedata._1.CreateDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.CreateDistrictCodeRsType;
import com.sadad.ebpp.schema.referencedata._1.CreatePaymentMethodRqType;
import com.sadad.ebpp.schema.referencedata._1.CreatePaymentMethodRsType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateAccessChannelRsType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateAccountTypeRsType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateDistrictCodeRsType;
import com.sadad.ebpp.schema.referencedata._1.DeactivatePaymentMethodRqType;
import com.sadad.ebpp.schema.referencedata._1.DeactivatePaymentMethodRsType;
import com.sadad.ebpp.schema.referencedata._1.ListAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccessChannelRsType;
import com.sadad.ebpp.schema.referencedata._1.ListAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccountTypeRsType;
import com.sadad.ebpp.schema.referencedata._1.ListDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.ListDistrictCodeRsType;
import com.sadad.ebpp.schema.referencedata._1.ListPaymentMethodRqType;
import com.sadad.ebpp.schema.referencedata._1.ListPaymentMethodRsType;
import com.sadad.ebpp.schema.referencedata._1.UpdateAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.UpdateAccessChannelRsType;
import com.sadad.ebpp.schema.referencedata._1.UpdateAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.UpdateAccountTypeRsType;
import com.sadad.ebpp.schema.referencedata._1.UpdateDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.UpdateDistrictCodeRsType;
import com.sadad.ebpp.schema.referencedata._1.UpdatePaymentMethodRqType;
import com.sadad.ebpp.schema.referencedata._1.UpdatePaymentMethodRsType;

public class ReferenceDataServiceBindingProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataService _service = null;
		private com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataServicePort _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataService(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataService();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getReferenceDataServiceBinding();
		}

		public com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataServicePort getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("http://www.sadad.com/EBPP/wsdl/ReferenceDataService/1.0", "ReferenceDataServiceBinding");
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

	public ReferenceDataServiceBindingProxy()
	{
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public ReferenceDataServiceBindingProxy(URL wsdlLocation, QName serviceName)
	{
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor()
	{
		return _descriptor;
	}

	public ListAccessChannelRsType listAccessChannel(ListAccessChannelRqType listAccessChannelRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().listAccessChannel(listAccessChannelRq);
	}

	public ListAccessChannelRsType getAccessChannel(ListAccessChannelRqType getAccessChannelRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().getAccessChannel(getAccessChannelRq);
	}

	public CreateAccessChannelRsType createAccessChannel(CreateAccessChannelRqType createAccessChannelRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().createAccessChannel(createAccessChannelRq);
	}

	public UpdateAccessChannelRsType updateAccessChannel(UpdateAccessChannelRqType updateAccessChannelRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().updateAccessChannel(updateAccessChannelRq);
	}

	public ActivateAccessChannelRsType activateAccessChannel(ActivateAccessChannelRqType activateAccessChannelRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().activateAccessChannel(activateAccessChannelRq);
	}

	public DeactivateAccessChannelRsType deactivateAccessChannel(DeactivateAccessChannelRqType deactivateAccessChannelRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().deactivateAccessChannel(deactivateAccessChannelRq);
	}

	public ListDistrictCodeRsType listDistrictCode(ListDistrictCodeRqType listDistrictCodeRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().listDistrictCode(listDistrictCodeRq);
	}

	public CreateDistrictCodeRsType createDistrictCode(CreateDistrictCodeRqType createDistrictCodeRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().createDistrictCode(createDistrictCodeRq);
	}

	public UpdateDistrictCodeRsType updateDistrictCode(UpdateDistrictCodeRqType updateDistrictCodeRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().updateDistrictCode(updateDistrictCodeRq);
	}

	public ActivateDistrictCodeRsType activateDistrictCode(ActivateDistrictCodeRqType activateDistrictCodeRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().activateDistrictCode(activateDistrictCodeRq);
	}

	public DeactivateDistrictCodeRsType deactivateDistrictCode(DeactivateDistrictCodeRqType deactivateDistrictCodeRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().deactivateDistrictCode(deactivateDistrictCodeRq);
	}

	public ListAccountTypeRsType listAccountType(ListAccountTypeRqType listAccountTypeRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().listAccountType(listAccountTypeRq);
	}

	public ListAccountTypeRsType getAccountType(ListAccountTypeRqType getAccountTypeRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().getAccountType(getAccountTypeRq);
	}

	public CreateAccountTypeRsType createAccountType(CreateAccountTypeRqType createAccountTypeRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().createAccountType(createAccountTypeRq);
	}

	public UpdateAccountTypeRsType updateAccountType(UpdateAccountTypeRqType updateAccountTypeRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().updateAccountType(updateAccountTypeRq);
	}

	public ActivateAccountTypeRsType activateAccountType(ActivateAccountTypeRqType activateAccountTypeRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().activateAccountType(activateAccountTypeRq);
	}

	public DeactivateAccountTypeRsType deactivateAccountType(DeactivateAccountTypeRqType deactivateAccountTypeRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().deactivateAccountType(deactivateAccountTypeRq);
	}

	public ListPaymentMethodRsType listPaymentMethod(ListPaymentMethodRqType listPaymentMethodRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().listPaymentMethod(listPaymentMethodRq);
	}

	public CreatePaymentMethodRsType createPaymentMethod(CreatePaymentMethodRqType createPaymentMethodRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().createPaymentMethod(createPaymentMethodRq);
	}

	public UpdatePaymentMethodRsType updatePaymentMethod(UpdatePaymentMethodRqType updatePaymentMethodRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().updatePaymentMethod(updatePaymentMethodRq);
	}

	public ActivatePaymentMethodRsType activatePaymentMethod(ActivatePaymentMethodRqType activatePaymentMethodRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().activatePaymentMethod(activatePaymentMethodRq);
	}

	public DeactivatePaymentMethodRsType deactivatePaymentMethod(DeactivatePaymentMethodRqType deactivatePaymentMethodRq) throws ReferenceDataFault
	{
		return _getDescriptor().getProxy().deactivatePaymentMethod(deactivatePaymentMethodRq);
	}

}