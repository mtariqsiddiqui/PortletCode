package com.sadad.portal.services.client.proxy;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankBranchResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBillCategoryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBillerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBillerResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivatePartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivatePartnerConfigurationResponseType;
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
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetFeeServiceProviderDetailsRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetFeeServiceProviderDetailsResponseType;
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
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSubscribedServiceListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSubscribedServiceListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSubscribedServiceRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSubscribedServiceResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSubscriptionToServiceRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSubscriptionToServiceResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.IsSubscribedToConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.IsSubscribedToConfigurationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.IsSubscribedToServiceRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.IsSubscribedToServiceResponseType;
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
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateSADADRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateSADADResponseType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileService;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.ServicePartnerProfileService;

public class ServicePartnerProfileServiceProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private ServicePartnerProfileService _service = null;
		private PartnerProfileService _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new ServicePartnerProfileService(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new ServicePartnerProfileService();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getPartnerProfileService();
		}

		public PartnerProfileService getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("", "ServicePartnerProfileService");
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

	public ServicePartnerProfileServiceProxy()
	{
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public ServicePartnerProfileServiceProxy(URL wsdlLocation, QName serviceName)
	{
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor()
	{
		return _descriptor;
	}

	public ListPartnerSummaryResponseType listPartnerSummary(ListPartnerSummaryRequestType listPartnerSummaryRequest) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().listPartnerSummary(listPartnerSummaryRequest);
	}

	public GetFeeServiceProviderDetailsResponseType getFeeServiceProviderDetails(GetFeeServiceProviderDetailsRequestType getFeeServiceProviderDetailsRequest) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getFeeServiceProviderDetails(getFeeServiceProviderDetailsRequest);
	}

	public GetSubscribedServiceListResponseType getSubscribedServiceList(GetSubscribedServiceListRequestType getSubscribedServiceList) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getSubscribedServiceList(getSubscribedServiceList);
	}

	public GetSubscribedServiceResponseType getSubscribedService(GetSubscribedServiceRequestType getSubscribedService) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getSubscribedService(getSubscribedService);
	}

	public GetPartnerConfigurationResponseType getPartnerConfiguration(GetPartnerConfigurationRequestType getPartnerConfigurationRq) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getPartnerConfiguration(getPartnerConfigurationRq);
	}

	public CreatePartnerConfigurationResponseType createPartnerConfiguration(CreatePartnerConfigurationRequestType createPartnerConfiguration) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().createPartnerConfiguration(createPartnerConfiguration);
	}

	public UpdatePartnerConfigurationResponseType updatePartnerConfiguration(UpdatePartnerConfigurationRequestType updatePartnerConfiguration) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().updatePartnerConfiguration(updatePartnerConfiguration);
	}

	public ActivatePartnerConfigurationResponseType activatePartnerConfiguration(ActivatePartnerConfigurationRequestType activatePartnerConfiguration) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().activatePartnerConfiguration(activatePartnerConfiguration);
	}

	public DeactivatePartnerConfigurationResponseType deactivatePartnerConfiguration(DeactivatePartnerConfigurationRequestType deactivatePartnerConfigurationRq) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().deactivatePartnerConfiguration(deactivatePartnerConfigurationRq);
	}

	public DeletePartnerConfigurationResponseType deletePartnerConfiguration(DeletePartnerConfigurationRequestType deletePartnerConfigurationRq) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().deletePartnerConfiguration(deletePartnerConfigurationRq);
	}

	public GetBankListResponseType getBankList(GetBankListRequestType getBankList) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getBankList(getBankList);
	}

	public GetBankDetailListResponseType getBankDetailList(GetBankDetailListRequestType getBankDetailList) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getBankDetailList(getBankDetailList);
	}

	public GetBankByKeyResponseType getBankByKey(GetBankByKeyRequestType getBankByKey) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getBankByKey(getBankByKey);
	}

	public CreateBankResponseType createBank(CreateBankRequestType createBank) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().createBank(createBank);
	}

	public UpdateBankResponseType updateBank(UpdateBankRequestType updateBank) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().updateBank(updateBank);
	}

	public ActivateBankResponseType activateBank(ActivateBankRequestType activateBank) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().activateBank(activateBank);
	}

	public DeactivateBankResponseType deactivateBank(DeactivateBankRequestType deactivateBank) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().deactivateBank(deactivateBank);
	}

	public GetBranchCodeResponseType getBankBranch(GetBranchCodeRequestType getBankBranch) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getBankBranch(getBankBranch);
	}

	public ListBankBranchResponseType listBankBranch(ListBankBranchRequestType listBankBranch) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().listBankBranch(listBankBranch);
	}

	public CreateBankBranchResponseType createBankBranch(CreateBankBranchRequestType createBankBranch) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().createBankBranch(createBankBranch);
	}

	public ActivateBankBranchResponseType activateBankBranch(ActivateBankBranchRequestType activateBankBranch) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().activateBankBranch(activateBankBranch);
	}

	public DeactivateBankBranchResponseType deactivateBankBranch(DeactivateBankBranchRequestType deactivateBankBranch) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().deactivateBankBranch(deactivateBankBranch);
	}

	public GetBillerListResponseType getBillerList(GetBillerListRequestType getBillerList) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getBillerList(getBillerList);
	}

	public GetBillerDetailListResponseType getBillerDetailList(GetBillerDetailListRequestType getBillerDetailList) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getBillerDetailList(getBillerDetailList);
	}

	public GetBillerByKeyResponseType getBillerByKey(GetBillerByKeyRequestType getBillerByKeyRequest) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getBillerByKey(getBillerByKeyRequest);
	}

	public GetPartnerDetailsResponseType getPartnerDetails(GetPartnerDetailsRequestType getPartnerDetailsRequest) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getPartnerDetails(getPartnerDetailsRequest);
	}

	public GetPartnerListResponseType getPartnerList(GetPartnerListRequestType getPartnerListRequest) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getPartnerList(getPartnerListRequest);
	}

	public CreateBillerResponseType createBiller(CreateBillerRequestType createBillerRequest) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().createBiller(createBillerRequest);
	}

	public UpdateBillerResponseType updateBiller(UpdateBillerRequestType updateBiller) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().updateBiller(updateBiller);
	}

	public UpdatePartnerResponseType updatePartner(UpdatePartnerRequestType updatePartner) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().updatePartner(updatePartner);
	}

	public ActivateBillerResponseType activateBiller(ActivateBillerRequestType activateBiller) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().activateBiller(activateBiller);
	}

	public DeactivateBillerResponseType deactivateBiller(DeactivateBillerRequestType deactivateBiller) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().deactivateBiller(deactivateBiller);
	}

	public GetBillCategoryResponseType getBillCategory(GetBillCategoryRequestType getBillCategory) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getBillCategory(getBillCategory);
	}

	public ListBillCategoryResponseType listBillCategory(ListBillCategoryRequestType listBillCategory) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().listBillCategory(listBillCategory);
	}

	public CreateBillCategoryResponseType createBillCategory(CreateBillCategoryRequestType createBillCategory) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().createBillCategory(createBillCategory);
	}

	public UpdateBillCategoryResponseType updateBillCategory(UpdateBillCategoryRequestType updateBillCategory) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().updateBillCategory(updateBillCategory);
	}

	public ActivateBillCategoryResponseType activateBillCategory(ActivateBillCategoryRequestType activateBillCategory) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().activateBillCategory(activateBillCategory);
	}

	public DeactivateBillCategoryResponseType deactivateBillCategory(DeactivateBillCategoryRequestType deactivateBiller) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().deactivateBillCategory(deactivateBiller);
	}

	public GetPaymentTypeResponseType getPaymentType(GetPaymentTypeRequestType getPaymentType) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getPaymentType(getPaymentType);
	}

	public ListPaymentTypeResponseType listPaymentType(ListPaymentTypeRequestType listPaymentType) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().listPaymentType(listPaymentType);
	}

	public CreatePaymentTypeResponseType createPaymentType(CreatePaymentTypeRequestType createPaymentType) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().createPaymentType(createPaymentType);
	}

	public UpdatePaymentTypeResponseType updatePaymentType(UpdatePaymentTypeRequestType updatePaymentType) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().updatePaymentType(updatePaymentType);
	}

	public ActivatePaymentTypeResponseType activatePaymentType(ActivatePaymentTypeRequestType activatePaymentType) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().activatePaymentType(activatePaymentType);
	}

	public DeactivatePaymentTypeResponseType deactivatePaymentType(DeactivatePaymentTypeRequestType deactivateBiller) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().deactivatePaymentType(deactivateBiller);
	}

	public IsSubscribedToConfigurationResponseType isSubscribedToConfiguration(IsSubscribedToConfigurationRequestType isSubscribedToConfiguration) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().isSubscribedToConfiguration(isSubscribedToConfiguration);
	}

	public IsSubscribedToServiceResponseType isSubscribedToService(IsSubscribedToServiceRequestType isSubscribedToService) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().isSubscribedToService(isSubscribedToService);
	}

	public GetSubscriptionToServiceResponseType getSubscriptionToService(GetSubscriptionToServiceRequestType getSubscriptionToService) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getSubscriptionToService(getSubscriptionToService);
	}

	public GetSADADResponseType getSADAD(GetSADADRequestType getSADAD) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getSADAD(getSADAD);
	}

	public UpdateSADADResponseType updateSADAD(UpdateSADADRequestType updateSADAD) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().updateSADAD(updateSADAD);
	}

	public GetSAMAResponseType getSAMA(GetSAMARequestType getSAMA) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().getSAMA(getSAMA);
	}

	public CreateBillerSettlementCorrelationResponseType createBillerSettlementCorrelation(CreateBillerSettlementCorrelationRequestType createBillerSettlementCorrelationRequest) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().createBillerSettlementCorrelation(createBillerSettlementCorrelationRequest);
	}

	public UpdateBillerSettlementCorrelationResponseType updateBillerSettlementCorrelation(UpdateBillerSettlementCorrelationRequestType updateBillerSettlementCorrelationRequest) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().updateBillerSettlementCorrelation(updateBillerSettlementCorrelationRequest);
	}

	public CreatePartnerResponseType createPartner(CreatePartnerRequestType createPartnerRequest) throws PartnerProfileFaultMsg
	{
		return _getDescriptor().getProxy().createPartner(createPartnerRequest);
	}

}