/**
 * 
 */
package com.sadad.ebpp.portal.delegate.factory.clients;

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
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivatePaymentTypeResponseType;
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
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBankRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBankResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillCategoryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillerResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateSADADRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateSADADResponseType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileService;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.ServicePartnerProfileServiceProxy;

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
		proxy._getDescriptor().setEndpoint(getEndPointUrl());
	}
	
	/**
	 * This method will return the endpoint URL after fetching it from WSRR
	 * @return endPointUrl
	 */
	private String getEndPointUrl()
	{
		// TODO - Get the EndPoint URL from the WSRR
		return "http://localhost:8090/PartnerProfileComponent/PartnerProfileServiceInterface/";
	}

	/**
	 * Returns the singleton instance of BillSearchDelegateImpl
	 * @return
	 */
	public static PartnerProfileServiceDelegateImpl getInstance()
	{
		if(instance == null)
		{
			instance = new PartnerProfileServiceDelegateImpl();
		}
		return instance;
	}
		
	@Override
	public GetBillerListResponseType getBillerList(GetBillerListRequestType billerList) throws PartnerProfileFaultMsg
	{
		GetBillerListResponseType billerListResponseType = service.getBillerList(billerList);
		return billerListResponseType;
	}

	@Override
	public GetBillerDetailListResponseType getBillerDetailList(GetBillerDetailListRequestType billerDetailList) throws PartnerProfileFaultMsg
	{
		GetBillerDetailListResponseType billerDetailListResponseType = service.getBillerDetailList(billerDetailList);
		return billerDetailListResponseType;
	}

	@Override
	public GetBankListResponseType getBankList(GetBankListRequestType bankList) throws PartnerProfileFaultMsg
	{
		GetBankListResponseType bankListResponseType = service.getBankList(bankList);
		return bankListResponseType;
	}

	@Override
	public GetBankDetailListResponseType getBankDetailList(GetBankDetailListRequestType bankDetailList) throws PartnerProfileFaultMsg
	{
		GetBankDetailListResponseType bankDetailListResponseType = service.getBankDetailList(bankDetailList);
		return bankDetailListResponseType;
	}

	@Override
	public GetBankByKeyResponseType getBankByKey(GetBankByKeyRequestType bankKey) throws PartnerProfileFaultMsg
	{
		GetBankByKeyResponseType bankByKeyResponseType = service.getBankByKey(bankKey);
		return bankByKeyResponseType;
	}

	@Override
	public GetSADADResponseType getSADAD(GetSADADRequestType sadadRequestType) throws PartnerProfileFaultMsg
	{
		GetSADADResponseType sadadResponseType = service.getSADAD(sadadRequestType);
		return sadadResponseType;
	}
	
	@Override
	public UpdateSADADResponseType updateSADAD(UpdateSADADRequestType updateSADAD) throws PartnerProfileFaultMsg
	{
		UpdateSADADResponseType sadadResponseType = service.updateSADAD(updateSADAD);
		return sadadResponseType;
	}

	@Override
	public GetSAMAResponseType getSAMA(GetSAMARequestType samaRequestType) throws PartnerProfileFaultMsg
	{
		GetSAMAResponseType samaResponseType = service.getSAMA(samaRequestType);
		return samaResponseType;
	}
	
	@Override
	 public ListBillCategoryResponseType listBillCategory(ListBillCategoryRequestType listBillCategory) throws PartnerProfileFaultMsg
	{
		ListBillCategoryResponseType listBillCategoryResponse = service.listBillCategory(listBillCategory);
		return listBillCategoryResponse;
	}

	@Override
	public GetBillCategoryResponseType getBillCategory(GetBillCategoryRequestType getBillCategory) throws PartnerProfileFaultMsg
	{
		GetBillCategoryResponseType getBillCategoryResponse = service.getBillCategory(getBillCategory);
		return getBillCategoryResponse;
	}

	@Override
	public UpdateBillCategoryResponseType updateBillCategory(UpdateBillCategoryRequestType updateBillCategoryReq) throws PartnerProfileFaultMsg
	{
		UpdateBillCategoryResponseType updateBillCategoryResp = service.updateBillCategory(updateBillCategoryReq);
		return updateBillCategoryResp;
	}

	@Override
	public ActivateBillCategoryResponseType activateBillCategory(ActivateBillCategoryRequestType activateBillCategoryReq) throws PartnerProfileFaultMsg
	{
		ActivateBillCategoryResponseType activateBillCategoryRes = service.activateBillCategory(activateBillCategoryReq);
		return activateBillCategoryRes;
	}

	@Override
	public DeactivateBillCategoryResponseType deactivateBillCategory(DeactivateBillCategoryRequestType deactivateBillCategoryReq) throws PartnerProfileFaultMsg
	{
		DeactivateBillCategoryResponseType deactivateBillCategoryRes = service.deactivateBillCategory(deactivateBillCategoryReq);
		return deactivateBillCategoryRes;
	}
	
	@Override
	 public ListPaymentTypeResponseType listPaymentType(ListPaymentTypeRequestType listPaymentType) throws PartnerProfileFaultMsg
	{
		ListPaymentTypeResponseType listPaymentTypeResponse = service.listPaymentType(listPaymentType);
		return listPaymentTypeResponse;
	}

	@Override	
    public GetPaymentTypeResponseType getPaymentType(GetPaymentTypeRequestType getPaymentType) throws PartnerProfileFaultMsg
    {
		GetPaymentTypeResponseType getPaymentTypeResponse = service.getPaymentType(getPaymentType);
		return getPaymentTypeResponse;
	}
	
	@Override
	public UpdatePaymentTypeResponseType updatePaymentType(UpdatePaymentTypeRequestType updatePaymentType) throws PartnerProfileFaultMsg
	{
		UpdatePaymentTypeResponseType updatePaymentTypeResponse = service.updatePaymentType(updatePaymentType);
		return updatePaymentTypeResponse;
	}
	
	@Override
	public ActivatePaymentTypeResponseType activatePaymentType(ActivatePaymentTypeRequestType activatePaymentType) throws PartnerProfileFaultMsg
	{
		ActivatePaymentTypeResponseType activatePaymentTypeResponse = service.activatePaymentType(activatePaymentType);
		return activatePaymentTypeResponse;
	}
	
	@Override
	public DeactivatePaymentTypeResponseType deactivatePaymentType(DeactivatePaymentTypeRequestType deactivatePaymentType) throws PartnerProfileFaultMsg
	{
		DeactivatePaymentTypeResponseType deactivatePaymentTypeResponse = service.deactivatePaymentType(deactivatePaymentType);
		return deactivatePaymentTypeResponse;
	}
	
	@Override
	public CreatePaymentTypeResponseType createPaymentType(CreatePaymentTypeRequestType createPaymentType) throws PartnerProfileFaultMsg
	{
		CreatePaymentTypeResponseType createPaymentTypeResponse = service.createPaymentType(createPaymentType);
		return createPaymentTypeResponse;
	}

	@Override
	public GetBillerByKeyResponseType getBillerByKey(GetBillerByKeyRequestType getBillerByKeyRequest) throws PartnerProfileFaultMsg
	{
		GetBillerByKeyResponseType biller = service.getBillerByKey(getBillerByKeyRequest);
		return biller;
	}

	@Override
	public CreateBillerResponseType createBiller(CreateBillerRequestType createBillerRequest) throws PartnerProfileFaultMsg
	{
		CreateBillerResponseType biller = service.createBiller(createBillerRequest);
		return biller;
	}

	@Override
	public UpdateBillerResponseType updateBiller(UpdateBillerRequestType updateBiller) throws PartnerProfileFaultMsg
	{
		UpdateBillerResponseType biller = service.updateBiller(updateBiller);
		return biller;
	}

	@Override
	public CreateBankResponseType createBank(CreateBankRequestType createBank) throws PartnerProfileFaultMsg
	{
		CreateBankResponseType bank = service.createBank(createBank);
		return bank;
	}

	@Override
	public UpdateBankResponseType updateBank(UpdateBankRequestType updateBank) throws PartnerProfileFaultMsg
	{
		UpdateBankResponseType bank = service.updateBank(updateBank);
		return bank;
	}

	@Override
	public CreateBillCategoryResponseType createBillCategory(CreateBillCategoryRequestType createBillCategory) throws PartnerProfileFaultMsg
	{
		CreateBillCategoryResponseType billCategory = service.createBillCategory(createBillCategory);
		return billCategory;
	}

	@Override
	public ListBankBranchResponseType listBankBranch(ListBankBranchRequestType listBankBranch) throws PartnerProfileFaultMsg
	{
		ListBankBranchResponseType bankList = service.listBankBranch(listBankBranch);
		return bankList;
	}

	@Override
	public GetBranchCodeResponseType getBankBranch(GetBranchCodeRequestType getBankBranch) throws PartnerProfileFaultMsg
	{
		GetBranchCodeResponseType branchCode = service.getBankBranch(getBankBranch);
		return branchCode;
	}

	@Override
	public CreateBankBranchResponseType createBankBranch(CreateBankBranchRequestType createBankBranch) throws PartnerProfileFaultMsg
	{
		CreateBankBranchResponseType bankBranch = service.createBankBranch(createBankBranch);
		return bankBranch;
	}

	@Override
	public ActivateBankBranchResponseType activateBankBranch(ActivateBankBranchRequestType activateBankBranch) throws PartnerProfileFaultMsg
	{
		ActivateBankBranchResponseType bankBranch = service.activateBankBranch(activateBankBranch);
		return bankBranch;
	}

	@Override
	public DeactivateBankBranchResponseType deactivateBankBranch(DeactivateBankBranchRequestType deactivateBankBranch) throws PartnerProfileFaultMsg
	{
		DeactivateBankBranchResponseType bankBranch = service.deactivateBankBranch(deactivateBankBranch);
		return bankBranch;
	}

	@Override
	public ActivateBillerResponseType activateBiller(ActivateBillerRequestType activateBiller) throws PartnerProfileFaultMsg
	{
		ActivateBillerResponseType activeBiller = service.activateBiller(activateBiller);
		return activeBiller;
	}

	@Override
	public DeactivateBillerResponseType deactivateBiller(DeactivateBillerRequestType deactivateBiller) throws PartnerProfileFaultMsg
	{
		DeactivateBillerResponseType deactiveBiller = service.deactivateBiller(deactivateBiller);
		return deactiveBiller;
	}

	@Override
	public ActivateBankResponseType activateBank(ActivateBankRequestType activateBank) throws PartnerProfileFaultMsg
	{
		ActivateBankResponseType activeBank = service.activateBank(activateBank);
		return activeBank;
	}

	@Override
	public DeactivateBankResponseType deactivateBank(DeactivateBankRequestType deactivateBank) throws PartnerProfileFaultMsg
	{
		DeactivateBankResponseType deactiveBank = service.deactivateBank(deactivateBank);
		return deactiveBank;
	}
}