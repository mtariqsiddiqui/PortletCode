/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankBranchResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBillCategoryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBillerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBillerResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivatePaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBankBranchResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBankRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBankResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBillCategoryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBillerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBillerResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBillerSettlementCorrelationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBillerSettlementCorrelationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreatePartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreatePartnerConfigurationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreatePartnerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreatePartnerResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreatePaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBankBranchResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBankRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBankResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBillCategoryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBillerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBillerResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivatePartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivatePartnerConfigurationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivatePaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeletePartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeletePartnerConfigurationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankByKeyRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankByKeyResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankDetailListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankDetailListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillCategoryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerByKeyRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerByKeyResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerDetailListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerDetailListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBranchCodeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBranchCodeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerConfigurationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerDetailsRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerDetailsResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSADADRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSADADResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSAMARequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSAMAResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBankBranchResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBillCategoryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPartnerSummaryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPartnerSummaryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBankRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBankResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillCategoryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillerResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillerSettlementCorrelationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillerSettlementCorrelationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerConfigurationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerStatusRqType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerStatusRsType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateSADADRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateSADADResponseType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileService;
import com.sadad.portal.services.client.proxy.ServicePartnerProfileServiceProxy;

/**
 * @author Tariq Siddiqui
 * 
 */
public class PartnerProfileServiceDelegateImpl implements PartnerProfileServiceDelegate
{
	private static PartnerProfileServiceDelegateImpl instance;
	private ServicePartnerProfileServiceProxy proxy;
	private PartnerProfileService service;

	private PartnerProfileServiceDelegateImpl()
	{
		proxy = new ServicePartnerProfileServiceProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of PartnerProfileServiceDelegateImpl
	 * 
	 * @return
	 */
	public static PartnerProfileServiceDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new PartnerProfileServiceDelegateImpl();
		}
		return instance;
	}

	@Override
	public GetBillerListResponseType getBillerList(GetBillerListRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetBillerListRequest", GetBillerListRequestType.class, rq);
			
		GetBillerListResponseType rs = service.getBillerList(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetBillerListResponse", GetBillerListResponseType.class, rs);

		return rs;
	}

	@Override
	public GetBillerDetailListResponseType getBillerDetailList(GetBillerDetailListRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetBillerDetailListRequest", GetBillerDetailListRequestType.class, rq);

		GetBillerDetailListResponseType rs = service.getBillerDetailList(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetBillerDetailListResponse", GetBillerDetailListResponseType.class, rs);

		return rs;
	}

	@Override
	public GetBankListResponseType getBankList(GetBankListRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("GetBankListRequest", GetBankListRequestType.class, rq);

		GetBankListResponseType rs = service.getBankList(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("GetBankListResponse", GetBankListResponseType.class, rs);

		return rs;
	}

	@Override
	public GetBankDetailListResponseType getBankDetailList(GetBankDetailListRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetBankDetailListRequest", GetBankDetailListRequestType.class, rq);

		GetBankDetailListResponseType rs = service.getBankDetailList(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetBankDetailListResponse", GetBankDetailListResponseType.class, rs);

		return rs;
	}

	@Override
	public GetBankByKeyResponseType getBankByKey(GetBankByKeyRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetBankByKeyRequest", GetBankByKeyRequestType.class, rq);

		GetBankByKeyResponseType rs = service.getBankByKey(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetBankByKeyResponse", GetBankByKeyResponseType.class, rs);

		return rs;
	}

	@Override
	public GetSADADResponseType getSADAD(GetSADADRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetSADADRequest", GetSADADRequestType.class, rq);

		GetSADADResponseType rs = service.getSADAD(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetSADADResponse", GetSADADResponseType.class, rs);

		return rs;
	}

	@Override
	public UpdateSADADResponseType updateSADAD(UpdateSADADRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdateSADADRequest", UpdateSADADRequestType.class, rq);

		UpdateSADADResponseType rs = service.updateSADAD(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdateSADADResponse", UpdateSADADResponseType.class, rs);

		return rs;
	}

	@Override
	public GetSAMAResponseType getSAMA(GetSAMARequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetSAMARequest", GetSAMARequestType.class, rq);

		GetSAMAResponseType rs = service.getSAMA(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetSAMAResponse", GetSAMAResponseType.class, rs);

		return rs;
	}

	@Override
	public ListBillCategoryResponseType listBillCategory(ListBillCategoryRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListBillCategoryRequest", ListBillCategoryRequestType.class, rq);

		ListBillCategoryResponseType rs = service.listBillCategory(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListBillCategoryResponse", ListBillCategoryResponseType.class, rs);

		return rs;
	}

	@Override
	public GetBillCategoryResponseType getBillCategory(GetBillCategoryRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetBillCategoryRequest", GetBillCategoryRequestType.class, rq);

		GetBillCategoryResponseType rs = service.getBillCategory(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetBillCategoryResponse", GetBillCategoryResponseType.class, rs);

		return rs;
	}

	@Override
	public UpdateBillCategoryResponseType updateBillCategory(UpdateBillCategoryRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdateBillCategoryRequest", UpdateBillCategoryRequestType.class, rq);

		UpdateBillCategoryResponseType rs = service.updateBillCategory(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdateBillCategoryResponse", UpdateBillCategoryResponseType.class, rs);

		return rs;
	}

	@Override
	public ActivateBillCategoryResponseType activateBillCategory(ActivateBillCategoryRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ActivateBillCategoryRequest", ActivateBillCategoryRequestType.class, rq);

		ActivateBillCategoryResponseType rs = service.activateBillCategory(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ActivateBillCategoryResponse", ActivateBillCategoryResponseType.class, rs);

		return rs;
	}

	@Override
	public DeactivateBillCategoryResponseType deactivateBillCategory(DeactivateBillCategoryRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("DeactivateBillCategoryRequest", DeactivateBillCategoryRequestType.class, rq);

		DeactivateBillCategoryResponseType rs = service.deactivateBillCategory(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("DeactivateBillCategoryResponse", DeactivateBillCategoryResponseType.class, rs);

		return rs;
	}

	@Override
	public GetPartnerConfigurationResponseType getPartnerConfiguration(GetPartnerConfigurationRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetPartnerConfigurationRequest", GetPartnerConfigurationRequestType.class, rq);

		GetPartnerConfigurationResponseType rs = service.getPartnerConfiguration(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetPartnerConfigurationResponse", GetPartnerConfigurationResponseType.class, rs);

		return rs;
	}

	@Override
	public CreatePartnerConfigurationResponseType createPartnerConfiguration(CreatePartnerConfigurationRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CreatePartnerConfigurationRequest", CreatePartnerConfigurationRequestType.class, rq);

		CreatePartnerConfigurationResponseType rs = service.createPartnerConfiguration(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CreatePartnerConfigurationResponse", CreatePartnerConfigurationResponseType.class, rs);

		return rs;
	}

	@Override
	public DeactivatePartnerConfigurationResponseType deactivatePartnerConfiguration(DeactivatePartnerConfigurationRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("DeactivatePartnerConfigurationRequest", DeactivatePartnerConfigurationRequestType.class, rq);

		DeactivatePartnerConfigurationResponseType rs = service.deactivatePartnerConfiguration(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("DeactivatePartnerConfigurationResponse", DeactivatePartnerConfigurationResponseType.class, rs);

		return rs;
	}

	@Override
	public DeletePartnerConfigurationResponseType deletePartnerConfiguration(DeletePartnerConfigurationRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("DeletePartnerConfigurationRequest", DeletePartnerConfigurationRequestType.class, rq);

		DeletePartnerConfigurationResponseType rs = service.deletePartnerConfiguration(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("DeletePartnerConfigurationResponse", DeletePartnerConfigurationResponseType.class, rs);

		return rs;
	}

	@Override
	public UpdatePartnerConfigurationResponseType updatePartnerConfiguration(UpdatePartnerConfigurationRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdatePartnerConfigurationRequest", UpdatePartnerConfigurationRequestType.class, rq);

		UpdatePartnerConfigurationResponseType rs = service.updatePartnerConfiguration(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdatePartnerConfigurationResponse", UpdatePartnerConfigurationResponseType.class, rs);

		return rs;
	}

	@Override
	public ListPaymentTypeResponseType listPaymentType(ListPaymentTypeRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListPaymentTypeRequest", ListPaymentTypeRequestType.class, rq);

		ListPaymentTypeResponseType rs = service.listPaymentType(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListPaymentTypeResponse", ListPaymentTypeResponseType.class, rs);

		return rs;
	}

	@Override
	public GetPaymentTypeResponseType getPaymentType(GetPaymentTypeRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetPaymentTypeRequest", GetPaymentTypeRequestType.class, rq);

		GetPaymentTypeResponseType rs = service.getPaymentType(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetPaymentTypeResponse", GetPaymentTypeResponseType.class, rs);

		return rs;
	}

	@Override
	public UpdatePaymentTypeResponseType updatePaymentType(UpdatePaymentTypeRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdatePaymentTypeRequest", UpdatePaymentTypeRequestType.class, rq);

		UpdatePaymentTypeResponseType rs = service.updatePaymentType(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdatePaymentTypeResponse", UpdatePaymentTypeResponseType.class, rs);

		return rs;
	}

	@Override
	public ActivatePaymentTypeResponseType activatePaymentType(ActivatePaymentTypeRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ActivatePaymentTypeRequest", ActivatePaymentTypeRequestType.class, rq);

		ActivatePaymentTypeResponseType rs = service.activatePaymentType(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ActivatePaymentTypeResponse", ActivatePaymentTypeResponseType.class, rs);

		return rs;
	}

	@Override
	public DeactivatePaymentTypeResponseType deactivatePaymentType(DeactivatePaymentTypeRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("DeactivatePaymentTypeRequest", DeactivatePaymentTypeRequestType.class, rq);

		DeactivatePaymentTypeResponseType rs = service.deactivatePaymentType(rq);

		if (logger.isLoggable(Level.FINEST))
			logResponse("DeactivatePaymentTypeResponse", DeactivatePaymentTypeResponseType.class, rs);

		return rs;
	}

	@Override
	public CreatePaymentTypeResponseType createPaymentType(CreatePaymentTypeRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CreatePaymentTypeRequest", CreatePaymentTypeRequestType.class, rq);

		CreatePaymentTypeResponseType rs = service.createPaymentType(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CreatePaymentTypeResponse", CreatePaymentTypeResponseType.class, rs);

		return rs;
	}

	@Override
	public GetBillerByKeyResponseType getBillerByKey(GetBillerByKeyRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetBillerByKeyRequest", GetBillerByKeyRequestType.class, rq);

		GetBillerByKeyResponseType rs = service.getBillerByKey(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetBillerByKeyResponse", GetBillerByKeyResponseType.class, rs);

		return rs;
	}

	@Override
	public CreateBillerResponseType createBiller(CreateBillerRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CreateBillerRequest", CreateBillerRequestType.class, rq);

		CreateBillerResponseType rs = service.createBiller(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CreateBillerResponse", CreateBillerResponseType.class, rs);

		return rs;
	}

	@Override
	public UpdateBillerResponseType updateBiller(UpdateBillerRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdateBillerRequest", UpdateBillerRequestType.class, rq);

		UpdateBillerResponseType rs = service.updateBiller(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdateBillerResponse", UpdateBillerResponseType.class, rs);

		return rs;
	}

	@Override
	public CreateBankResponseType createBank(CreateBankRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CreateBankRequest", CreateBankRequestType.class, rq);

		CreateBankResponseType rs = service.createBank(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CreateBankResponse", CreateBankResponseType.class, rs);

		return rs;
	}

	@Override
	public UpdateBankResponseType updateBank(UpdateBankRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdateBankRequest", UpdateBankRequestType.class, rq);

		UpdateBankResponseType rs = service.updateBank(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdateBankResponse", UpdateBankResponseType.class, rs);

		return rs;
	}

	@Override
	public CreateBillCategoryResponseType createBillCategory(CreateBillCategoryRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CreateBillCategoryRequest", CreateBillCategoryRequestType.class, rq);

		CreateBillCategoryResponseType rs = service.createBillCategory(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CreateBillCategoryResponse", CreateBillCategoryResponseType.class, rs);

		return rs;
	}

	@Override
	public ListBankBranchResponseType listBankBranch(ListBankBranchRequestType rq) throws PartnerProfileFaultMsg
	{
		ListBankBranchResponseType rs = service.listBankBranch(rq);
		return rs;
	}

	@Override
	public GetBranchCodeResponseType getBankBranch(GetBranchCodeRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetBranchCodeRequest", GetBranchCodeRequestType.class, rq);

		GetBranchCodeResponseType rs = service.getBankBranch(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetBranchCodeResponse", GetBranchCodeResponseType.class, rs);

		return rs;
	}

	@Override
	public CreateBankBranchResponseType createBankBranch(CreateBankBranchRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CreateBankBranchRequest", CreateBankBranchRequestType.class, rq);

		CreateBankBranchResponseType rs = service.createBankBranch(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CreateBankBranchResponse", CreateBankBranchResponseType.class, rs);

		return rs;
	}

	@Override
	public ActivateBankBranchResponseType activateBankBranch(ActivateBankBranchRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ActivateBankBranchRequest", ActivateBankBranchRequestType.class, rq);

		ActivateBankBranchResponseType rs = service.activateBankBranch(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ActivateBankBranchResponse", ActivateBankBranchResponseType.class, rs);

		return rs;
	}

	@Override
	public DeactivateBankBranchResponseType deactivateBankBranch(DeactivateBankBranchRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("DeactivateBankBranchRequest", DeactivateBankBranchRequestType.class, rq);

		DeactivateBankBranchResponseType rs = service.deactivateBankBranch(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("DeactivateBankBranchResponse", DeactivateBankBranchResponseType.class, rs);

		return rs;
	}

	@Override
	public ActivateBillerResponseType activateBiller(ActivateBillerRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ActivateBillerRequest", ActivateBillerRequestType.class, rq);

		ActivateBillerResponseType rs = service.activateBiller(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ActivateBillerResponse", ActivateBillerResponseType.class, rs);

		return rs;
	}

	@Override
	public DeactivateBillerResponseType deactivateBiller(DeactivateBillerRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("DeactivateBillerRequest", DeactivateBillerRequestType.class, rq);

		DeactivateBillerResponseType rs = service.deactivateBiller(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("DeactivateBillerResponse", DeactivateBillerResponseType.class, rs);

		return rs;
	}

	@Override
	public ActivateBankResponseType activateBank(ActivateBankRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ActivateBankRequest", ActivateBankRequestType.class, rq);

		ActivateBankResponseType rs = service.activateBank(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ActivateBankResponse", ActivateBankResponseType.class, rs);

		return rs;
	}

	@Override
	public DeactivateBankResponseType deactivateBank(DeactivateBankRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("DeactivateBankRequest", DeactivateBankRequestType.class, rq);
		
		DeactivateBankResponseType rs = service.deactivateBank(rq);
		
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("DeactivateBankResponse", DeactivateBankResponseType.class, rs);

		return rs;
	}

	@Override
	public CreateBillerSettlementCorrelationResponseType createBillerSettlementCorrelation(CreateBillerSettlementCorrelationRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CreateBillerSettlementCorrelationRequest", CreateBillerSettlementCorrelationRequestType.class, rq);

		CreateBillerSettlementCorrelationResponseType rs = service.createBillerSettlementCorrelation(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CreateBillerSettlementCorrelationResponse", CreateBillerSettlementCorrelationResponseType.class, rs);
		
		return rs;
	}

	@Override
	public UpdateBillerSettlementCorrelationResponseType updateBillerSettlementCorrelation(UpdateBillerSettlementCorrelationRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdateBillerSettlementCorrelationRequest", UpdateBillerSettlementCorrelationRequestType.class, rq);

		UpdateBillerSettlementCorrelationResponseType rs = service.updateBillerSettlementCorrelation(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdateBillerSettlementCorrelationResponse", UpdateBillerSettlementCorrelationResponseType.class, rs);

		return rs;
	}

	@Override
	public ListPartnerSummaryResponseType listPartnerSummary(ListPartnerSummaryRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListPartnerSummaryRequest", ListPartnerSummaryRequestType.class, rq);

		ListPartnerSummaryResponseType rs = service.listPartnerSummary(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListPartnerSummaryResponse", ListPartnerSummaryResponseType.class, rs);

		return rs;
	}

	@Override
	public GetPartnerDetailsResponseType getPartnerDetails(GetPartnerDetailsRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetPartnerDetailsRequest", GetPartnerDetailsRequestType.class, rq);

		GetPartnerDetailsResponseType rs = service.getPartnerDetails(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetPartnerDetailsResponse", GetPartnerDetailsResponseType.class, rs);		

		return rs;
	}

	@Override
	public GetPartnerListResponseType getPartnerList(GetPartnerListRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetPartnerListRequest", GetPartnerListRequestType.class, rq);

		GetPartnerListResponseType rs = service.getPartnerList(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetPartnerListResponse", GetPartnerListResponseType.class, rs);

		return rs;
	}

	@Override
	public CreatePartnerResponseType createPartner(CreatePartnerRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CreatePartnerRequest", CreatePartnerRequestType.class, rq);

		CreatePartnerResponseType rs = service.createPartner(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CreatePartnerResponse", CreatePartnerResponseType.class, rs);

		return rs;
	}

	@Override
	public UpdatePartnerResponseType updatePartner(UpdatePartnerRequestType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdatePartnerRequest", UpdatePartnerRequestType.class, rq);

		UpdatePartnerResponseType rs = service.updatePartner(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdatePartnerResponse", UpdatePartnerResponseType.class, rs);

		return rs;
	}

	@Override
	public UpdatePartnerStatusRsType updatePartnerStatus(UpdatePartnerStatusRqType rq) throws PartnerProfileFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PARTNER_PROFILE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdatePartnerStatusRq", UpdatePartnerStatusRqType.class, rq);

		UpdatePartnerStatusRsType rs = service.updatePartnerStatus(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdatePartnerStatusRs", UpdatePartnerStatusRsType.class, rs);

		return rs;
	}
}