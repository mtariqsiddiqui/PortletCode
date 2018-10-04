package com.sadad.ebpp.portal.delegate.factory.clients;

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
import com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataFault;
import com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataServiceBindingProxy;
import com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataServicePort;

/**
 * @author Tariq Siddiqui
 * 
 */
public class ReferenceDataServiceDelegateImpl implements ReferenceDataServiceDelegate
{
	private static ReferenceDataServiceDelegateImpl instance;
	private ReferenceDataServiceBindingProxy proxy;
	private ReferenceDataServicePort service;
		
	private ReferenceDataServiceDelegateImpl()
	{
		proxy = new ReferenceDataServiceBindingProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(getEndPointUrl());
	}
	
	/**
	 * This method will return the endpoint URL after fetching it from WSRR
	 * @return endPointUrl
	 */
	private String getEndPointUrl()
	{
		// TODO - Get the URL from WSRR
		return "http://localhost:8090/referenceData/ReferenceDataServicePort";
	}

	/**
	 * Returns the singleton instance of BillSearchDelegateImpl
	 * @return
	 */
	public static ReferenceDataServiceDelegateImpl getInstance()
	{
		if(instance == null)
		{
			instance = new ReferenceDataServiceDelegateImpl();
		}
		return instance;
	}

	@Override
	public ListAccessChannelRsType listAccessChannel(ListAccessChannelRqType listAccessChannelRq) throws ReferenceDataFault
	{
		ListAccessChannelRsType accessChannelList = service.listAccessChannel(listAccessChannelRq);
		return accessChannelList;
	}

	@Override
	public ListAccessChannelRsType getAccessChannel(ListAccessChannelRqType getAccessChannelRq) throws ReferenceDataFault
	{
		ListAccessChannelRsType accessChannel = service.getAccessChannel(getAccessChannelRq);
		return accessChannel;
	}

	@Override
	public CreateAccessChannelRsType createAccessChannel(CreateAccessChannelRqType createAccessChannelRq) throws ReferenceDataFault
	{
		CreateAccessChannelRsType accessChannel = service.createAccessChannel(createAccessChannelRq);
		return accessChannel;
	}

	@Override
	public UpdateAccessChannelRsType updateAccessChannel(UpdateAccessChannelRqType updateAccessChannelRq) throws ReferenceDataFault
	{
		UpdateAccessChannelRsType accessChannel = service.updateAccessChannel(updateAccessChannelRq);
		return accessChannel;
	}

	@Override
	public ActivateAccessChannelRsType activateAccessChannel(ActivateAccessChannelRqType activateAccessChannelRq) throws ReferenceDataFault
	{
		ActivateAccessChannelRsType accessChannel = service.activateAccessChannel(activateAccessChannelRq);
		return accessChannel;
	}

	@Override
	public DeactivateAccessChannelRsType deactivateAccessChannel(DeactivateAccessChannelRqType deactivateAccessChannelRq) throws ReferenceDataFault
	{
		DeactivateAccessChannelRsType accessChannel = service.deactivateAccessChannel(deactivateAccessChannelRq);
		return accessChannel;
	}

	@Override
	public ListDistrictCodeRsType listDistrictCode(ListDistrictCodeRqType listDistrictCodeRq) throws ReferenceDataFault
	{
		ListDistrictCodeRsType districtCodeList = service.listDistrictCode(listDistrictCodeRq);
		return districtCodeList;
	}

	@Override
	public CreateDistrictCodeRsType createDistrictCode(CreateDistrictCodeRqType createDistrictCodeRq) throws ReferenceDataFault
	{
		CreateDistrictCodeRsType districtCode = service.createDistrictCode(createDistrictCodeRq);
		return districtCode;
	}

	@Override
	public UpdateDistrictCodeRsType updateDistrictCode(UpdateDistrictCodeRqType updateDistrictCodeRq) throws ReferenceDataFault
	{
		UpdateDistrictCodeRsType districtCode = service.updateDistrictCode(updateDistrictCodeRq);
		return districtCode;
	}

	@Override
	public ActivateDistrictCodeRsType activateDistrictCode(ActivateDistrictCodeRqType activateDistrictCodeRq) throws ReferenceDataFault
	{
		ActivateDistrictCodeRsType districtCode = service.activateDistrictCode(activateDistrictCodeRq);
		return districtCode;
	}

	@Override
	public DeactivateDistrictCodeRsType deactivateDistrictCode(DeactivateDistrictCodeRqType deactivateDistrictCodeRq) throws ReferenceDataFault
	{
		DeactivateDistrictCodeRsType districtCode = service.deactivateDistrictCode(deactivateDistrictCodeRq);
		return districtCode;
	}

	@Override
	public ListAccountTypeRsType listAccountType(ListAccountTypeRqType listAccountTypeRq) throws ReferenceDataFault
	{
		ListAccountTypeRsType accountTypeList = service.listAccountType(listAccountTypeRq);
		return accountTypeList;
	}

	@Override
	public ListAccountTypeRsType getAccountType(ListAccountTypeRqType getAccountTypeRq) throws ReferenceDataFault
	{
		ListAccountTypeRsType accountType = service.getAccountType(getAccountTypeRq);
		return accountType;
	}

	@Override
	public CreateAccountTypeRsType createAccountType(CreateAccountTypeRqType createAccountTypeRq) throws ReferenceDataFault
	{
		CreateAccountTypeRsType accountType = service.createAccountType(createAccountTypeRq);
		return accountType;
	}

	@Override
	public UpdateAccountTypeRsType updateAccountType(UpdateAccountTypeRqType updateAccountTypeRq) throws ReferenceDataFault
	{
		UpdateAccountTypeRsType accountType = service.updateAccountType(updateAccountTypeRq);
		return accountType;
	}

	@Override
	public ActivateAccountTypeRsType activateAccountType(ActivateAccountTypeRqType activateAccountTypeRq) throws ReferenceDataFault
	{
		ActivateAccountTypeRsType accountType = service.activateAccountType(activateAccountTypeRq);
		return accountType;
	}

	@Override
	public DeactivateAccountTypeRsType deactivateAccountType(DeactivateAccountTypeRqType deactivateAccountTypeRq) throws ReferenceDataFault
	{
		DeactivateAccountTypeRsType accountType = service.deactivateAccountType(deactivateAccountTypeRq);
		return accountType;
	}

	@Override
	public ListPaymentMethodRsType listPaymentMethod(ListPaymentMethodRqType listPaymentMethodRq) throws ReferenceDataFault
	{
		ListPaymentMethodRsType paymentMethod = service.listPaymentMethod(listPaymentMethodRq);
		return paymentMethod;
	}

	@Override
	public CreatePaymentMethodRsType createPaymentMethod(CreatePaymentMethodRqType createPaymentMethodRq) throws ReferenceDataFault
	{
		CreatePaymentMethodRsType paymentMethod = service.createPaymentMethod(createPaymentMethodRq);
		return paymentMethod;
	}

	@Override
	public UpdatePaymentMethodRsType updatePaymentMethod(UpdatePaymentMethodRqType updatePaymentMethodRq) throws ReferenceDataFault
	{
		UpdatePaymentMethodRsType paymentMethod = service.updatePaymentMethod(updatePaymentMethodRq);
		
		return paymentMethod;
	}

	@Override
	public ActivatePaymentMethodRsType activatePaymentMethod(ActivatePaymentMethodRqType activatePaymentMethodRq) throws ReferenceDataFault
	{
		ActivatePaymentMethodRsType paymentMethod = service.activatePaymentMethod(activatePaymentMethodRq);
		return paymentMethod;
	}

	@Override
	public DeactivatePaymentMethodRsType deactivatePaymentMethod(DeactivatePaymentMethodRqType deactivatePaymentMethodRq) throws ReferenceDataFault
	{
		DeactivatePaymentMethodRsType paymentMethod = service.deactivatePaymentMethod(deactivatePaymentMethodRq);
		return paymentMethod;
	}
}