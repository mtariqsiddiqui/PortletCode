package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

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
import com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataServicePort;
import com.sadad.portal.services.client.proxy.ReferenceDataServiceBindingProxy;

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
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of ReferenceDataServiceDelegateImpl
	 * 
	 * @return
	 */
	public static ReferenceDataServiceDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new ReferenceDataServiceDelegateImpl();
		}
		return instance;
	}

	@Override
	public ListAccessChannelRsType listAccessChannel(ListAccessChannelRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ListAccessChannelRq", ListAccessChannelRqType.class, rq);
		
		ListAccessChannelRsType rs = service.listAccessChannel(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ListAccessChannelRs", ListAccessChannelRsType.class, rs);
		return rs;
	}

	@Override
	public ListAccessChannelRsType getAccessChannel(ListAccessChannelRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ListAccessChannelRq", ListAccessChannelRqType.class, rq);
		
		ListAccessChannelRsType rs = service.getAccessChannel(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ListAccessChannelRs", ListAccessChannelRsType.class, rs);
		return rs;
	}

	@Override
	public CreateAccessChannelRsType createAccessChannel(CreateAccessChannelRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("CreateAccessChannelRq", CreateAccessChannelRqType.class, rq);

		CreateAccessChannelRsType rs = service.createAccessChannel(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("CreateAccessChannelRs", CreateAccessChannelRsType.class, rs);
		return rs;
	}

	@Override
	public UpdateAccessChannelRsType updateAccessChannel(UpdateAccessChannelRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("UpdateAccessChannelRq", UpdateAccessChannelRqType.class, rq);

		UpdateAccessChannelRsType rs = service.updateAccessChannel(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("UpdateAccessChannelRs", UpdateAccessChannelRsType.class, rs);
		return rs;
	}

	@Override
	public ActivateAccessChannelRsType activateAccessChannel(ActivateAccessChannelRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ActivateAccessChannelRq", ActivateAccessChannelRqType.class, rq);

		ActivateAccessChannelRsType rs = service.activateAccessChannel(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ActivateAccessChannelRs", ActivateAccessChannelRsType.class, rs);

		return rs;
	}

	@Override
	public DeactivateAccessChannelRsType deactivateAccessChannel(DeactivateAccessChannelRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("DeactivateAccessChannelRs", DeactivateAccessChannelRsType.class, rq);

		DeactivateAccessChannelRsType rs = service.deactivateAccessChannel(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("DeactivateAccessChannelRs", DeactivateAccessChannelRsType.class, rs);

		return rs;
	}

	@Override
	public ListDistrictCodeRsType listDistrictCode(ListDistrictCodeRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ListDistrictCodeRq", ListDistrictCodeRqType.class, rq);

		ListDistrictCodeRsType rs = service.listDistrictCode(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ListDistrictCodeRs", ListDistrictCodeRsType.class, rs);

		return rs;
	}

	@Override
	public CreateDistrictCodeRsType createDistrictCode(CreateDistrictCodeRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("CreateDistrictCodeRq", CreateDistrictCodeRqType.class, rq);

		CreateDistrictCodeRsType rs = service.createDistrictCode(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("CreateDistrictCodeRs", CreateDistrictCodeRsType.class, rs);

		return rs;
	}

	@Override
	public UpdateDistrictCodeRsType updateDistrictCode(UpdateDistrictCodeRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("UpdateDistrictCodeRq", UpdateDistrictCodeRqType.class, rq);

		UpdateDistrictCodeRsType rs = service.updateDistrictCode(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("UpdateDistrictCodeRs", UpdateDistrictCodeRsType.class, rs);

		return rs;
	}

	@Override
	public ActivateDistrictCodeRsType activateDistrictCode(ActivateDistrictCodeRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ActivateDistrictCodeRq", ActivateDistrictCodeRqType.class, rq);

		ActivateDistrictCodeRsType rs = service.activateDistrictCode(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ActivateDistrictCodeRs", ActivateDistrictCodeRsType.class, rs);

		return rs;
	}

	@Override
	public DeactivateDistrictCodeRsType deactivateDistrictCode(DeactivateDistrictCodeRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("DeactivateDistrictCodeRq", DeactivateDistrictCodeRqType.class, rq);

		DeactivateDistrictCodeRsType rs = service.deactivateDistrictCode(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("DeactivateDistrictCodeRs", DeactivateDistrictCodeRsType.class, rs);

		return rs;
	}

	@Override
	public ListAccountTypeRsType listAccountType(ListAccountTypeRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ListAccountTypeRq", ListAccountTypeRqType.class, rq);

		ListAccountTypeRsType rs = service.listAccountType(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ListAccountTypeRs", ListAccountTypeRsType.class, rs);

		return rs;
	}

	@Override
	public ListAccountTypeRsType getAccountType(ListAccountTypeRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ListAccountTypeRq", ListAccountTypeRqType.class, rq);

		ListAccountTypeRsType rs = service.getAccountType(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ListAccountTypeRs", ListAccountTypeRsType.class, rs);

		return rs;
	}

	@Override
	public CreateAccountTypeRsType createAccountType(CreateAccountTypeRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("CreateAccountTypeRq", CreateAccountTypeRqType.class, rq);

		CreateAccountTypeRsType rs = service.createAccountType(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("CreateAccountTypeRs", CreateAccountTypeRsType.class, rs);

		return rs;
	}

	@Override
	public UpdateAccountTypeRsType updateAccountType(UpdateAccountTypeRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("UpdateAccountTypeRq", UpdateAccountTypeRqType.class, rq);

		UpdateAccountTypeRsType rs = service.updateAccountType(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("UpdateAccountTypeRs", UpdateAccountTypeRsType.class, rs);

		return rs;
	}

	@Override
	public ActivateAccountTypeRsType activateAccountType(ActivateAccountTypeRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ActivateAccountTypeRq", ActivateAccountTypeRqType.class, rq);

		ActivateAccountTypeRsType rs = service.activateAccountType(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ActivateAccountTypeRs", ActivateAccountTypeRsType.class, rs);

		return rs;
	}

	@Override
	public DeactivateAccountTypeRsType deactivateAccountType(DeactivateAccountTypeRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("DeactivateAccountTypeRq", DeactivateAccountTypeRqType.class, rq);

		DeactivateAccountTypeRsType rs = service.deactivateAccountType(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("DeactivateAccountTypeRs", DeactivateAccountTypeRsType.class, rs);

		return rs;
	}

	@Override
	public ListPaymentMethodRsType listPaymentMethod(ListPaymentMethodRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ListPaymentMethodRq", ListPaymentMethodRqType.class, rq);

		ListPaymentMethodRsType rs = service.listPaymentMethod(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ListPaymentMethodRs", ListPaymentMethodRsType.class, rs);

		return rs;
	}

	@Override
	public CreatePaymentMethodRsType createPaymentMethod(CreatePaymentMethodRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("CreatePaymentMethodRq", CreatePaymentMethodRqType.class, rq);

		CreatePaymentMethodRsType rs = service.createPaymentMethod(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("CreatePaymentMethodRs", CreatePaymentMethodRsType.class, rs);

		return rs;
	}

	@Override
	public UpdatePaymentMethodRsType updatePaymentMethod(UpdatePaymentMethodRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("UpdatePaymentMethodRq", UpdatePaymentMethodRqType.class, rq);

		UpdatePaymentMethodRsType rs = service.updatePaymentMethod(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("UpdatePaymentMethodRs", UpdatePaymentMethodRsType.class, rs);

		return rs;
	}

	@Override
	public ActivatePaymentMethodRsType activatePaymentMethod(ActivatePaymentMethodRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ActivatePaymentMethodRq", ActivatePaymentMethodRqType.class, rq);

		ActivatePaymentMethodRsType rs = service.activatePaymentMethod(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ActivatePaymentMethodRs", ActivatePaymentMethodRsType.class, rs);

		return rs;
	}

	@Override
	public DeactivatePaymentMethodRsType deactivatePaymentMethod(DeactivatePaymentMethodRqType rq) throws ReferenceDataFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFERENCE_DATA_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("DeactivatePaymentMethodRq", DeactivatePaymentMethodRqType.class, rq);

		DeactivatePaymentMethodRsType rs = service.deactivatePaymentMethod(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("DeactivatePaymentMethodRs", DeactivatePaymentMethodRsType.class, rs);

		return rs;
	}
}