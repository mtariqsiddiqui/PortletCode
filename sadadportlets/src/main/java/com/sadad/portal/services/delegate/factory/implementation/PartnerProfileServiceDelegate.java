package com.sadad.portal.services.delegate.factory.implementation;

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
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * 
 * @author Tariq Siddiqui
 * 
 */

public interface PartnerProfileServiceDelegate extends RequestResponseLogger
{
	// Biller related services
	public ActivateBillerResponseType activateBiller(ActivateBillerRequestType activateBiller) throws PartnerProfileFaultMsg;

	public DeactivateBillerResponseType deactivateBiller(DeactivateBillerRequestType deactivateBiller) throws PartnerProfileFaultMsg;

	public GetBillerListResponseType getBillerList(GetBillerListRequestType getBillerList) throws PartnerProfileFaultMsg;

	public GetBillerDetailListResponseType getBillerDetailList(GetBillerDetailListRequestType getBillerDetailList) throws PartnerProfileFaultMsg;

	public GetBillerByKeyResponseType getBillerByKey(GetBillerByKeyRequestType getBillerByKeyRequest) throws PartnerProfileFaultMsg;

	public CreateBillerResponseType createBiller(CreateBillerRequestType createBillerRequest) throws PartnerProfileFaultMsg;

	public UpdateBillerResponseType updateBiller(UpdateBillerRequestType updateBiller) throws PartnerProfileFaultMsg;

	// Bank related services
	public ActivateBankResponseType activateBank(ActivateBankRequestType activateBank) throws PartnerProfileFaultMsg;

	public DeactivateBankResponseType deactivateBank(DeactivateBankRequestType deactivateBank) throws PartnerProfileFaultMsg;

	public GetBankListResponseType getBankList(GetBankListRequestType getBankList) throws PartnerProfileFaultMsg;

	public GetBankDetailListResponseType getBankDetailList(GetBankDetailListRequestType getBankDetailList) throws PartnerProfileFaultMsg;

	public GetBankByKeyResponseType getBankByKey(GetBankByKeyRequestType getBankByKey) throws PartnerProfileFaultMsg;

	public CreateBankResponseType createBank(CreateBankRequestType createBank) throws PartnerProfileFaultMsg;

	public UpdateBankResponseType updateBank(UpdateBankRequestType updateBank) throws PartnerProfileFaultMsg;

	// SADAD and SAMA related services
	public GetSADADResponseType getSADAD(GetSADADRequestType getSADAD) throws PartnerProfileFaultMsg;

	public UpdateSADADResponseType updateSADAD(UpdateSADADRequestType updateSADAD) throws PartnerProfileFaultMsg;

	public GetSAMAResponseType getSAMA(GetSAMARequestType getSAMA) throws PartnerProfileFaultMsg;

	// BillCategory related services
	public ListBillCategoryResponseType listBillCategory(ListBillCategoryRequestType listBillCategory) throws PartnerProfileFaultMsg;

	public GetBillCategoryResponseType getBillCategory(GetBillCategoryRequestType getBillCategory) throws PartnerProfileFaultMsg;

	public UpdateBillCategoryResponseType updateBillCategory(UpdateBillCategoryRequestType updateBillCategory) throws PartnerProfileFaultMsg;

	public ActivateBillCategoryResponseType activateBillCategory(ActivateBillCategoryRequestType activateBillCategoryReq) throws PartnerProfileFaultMsg;

	public DeactivateBillCategoryResponseType deactivateBillCategory(DeactivateBillCategoryRequestType deactivateBillCategoryReq) throws PartnerProfileFaultMsg;

	public CreateBillCategoryResponseType createBillCategory(CreateBillCategoryRequestType createBillCategory) throws PartnerProfileFaultMsg;

	// Partner Configuration related services
	public GetPartnerConfigurationResponseType getPartnerConfiguration(GetPartnerConfigurationRequestType getPartnerConfigurationRq) throws PartnerProfileFaultMsg;

	public CreatePartnerConfigurationResponseType createPartnerConfiguration(CreatePartnerConfigurationRequestType partnerConfig) throws PartnerProfileFaultMsg;

	public UpdatePartnerConfigurationResponseType updatePartnerConfiguration(UpdatePartnerConfigurationRequestType partnerConfig) throws PartnerProfileFaultMsg;

	public DeactivatePartnerConfigurationResponseType deactivatePartnerConfiguration(DeactivatePartnerConfigurationRequestType partnerConfig) throws PartnerProfileFaultMsg;

	public DeletePartnerConfigurationResponseType deletePartnerConfiguration(DeletePartnerConfigurationRequestType partnerConfig) throws PartnerProfileFaultMsg;

	// PaymentType related services
	public ListPaymentTypeResponseType listPaymentType(ListPaymentTypeRequestType listPaymentType) throws PartnerProfileFaultMsg;

	public GetPaymentTypeResponseType getPaymentType(GetPaymentTypeRequestType getPaymentType) throws PartnerProfileFaultMsg;

	public UpdatePaymentTypeResponseType updatePaymentType(UpdatePaymentTypeRequestType updatePaymentType) throws PartnerProfileFaultMsg;

	public ActivatePaymentTypeResponseType activatePaymentType(ActivatePaymentTypeRequestType activatePaymentType) throws PartnerProfileFaultMsg;

	public DeactivatePaymentTypeResponseType deactivatePaymentType(DeactivatePaymentTypeRequestType deactivatePaymentType) throws PartnerProfileFaultMsg;

	public CreatePaymentTypeResponseType createPaymentType(CreatePaymentTypeRequestType createPaymentType) throws PartnerProfileFaultMsg;

	// BankBranch related services
	public ListBankBranchResponseType listBankBranch(ListBankBranchRequestType listBankBranch) throws PartnerProfileFaultMsg;

	public GetBranchCodeResponseType getBankBranch(GetBranchCodeRequestType getBankBranch) throws PartnerProfileFaultMsg;

	public CreateBankBranchResponseType createBankBranch(CreateBankBranchRequestType createBankBranch) throws PartnerProfileFaultMsg;

	public ActivateBankBranchResponseType activateBankBranch(ActivateBankBranchRequestType activateBankBranch) throws PartnerProfileFaultMsg;

	public DeactivateBankBranchResponseType deactivateBankBranch(DeactivateBankBranchRequestType deactivateBankBranch) throws PartnerProfileFaultMsg;

	// Biller Settlement related services
	public CreateBillerSettlementCorrelationResponseType createBillerSettlementCorrelation(CreateBillerSettlementCorrelationRequestType req) throws PartnerProfileFaultMsg;

	public UpdateBillerSettlementCorrelationResponseType updateBillerSettlementCorrelation(UpdateBillerSettlementCorrelationRequestType req) throws PartnerProfileFaultMsg;
	
	// List Partner Summary, implemented for Aggregator feature
	public ListPartnerSummaryResponseType listPartnerSummary(ListPartnerSummaryRequestType listPartnerSummaryRequest) throws PartnerProfileFaultMsg;
	
	public GetPartnerDetailsResponseType getPartnerDetails(GetPartnerDetailsRequestType getPartnerDetailsRequest) throws PartnerProfileFaultMsg;

	public GetPartnerListResponseType getPartnerList(GetPartnerListRequestType getPartnerListRequest) throws PartnerProfileFaultMsg;
	
	public CreatePartnerResponseType createPartner(CreatePartnerRequestType createPartnerRequest) throws PartnerProfileFaultMsg;

	public UpdatePartnerResponseType updatePartner(UpdatePartnerRequestType updatePartner) throws PartnerProfileFaultMsg;
	
	public UpdatePartnerStatusRsType updatePartnerStatus(UpdatePartnerStatusRqType updatePartnerStatusRequest) throws PartnerProfileFaultMsg;
}