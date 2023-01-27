package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.partnermanagementservice._1.CreatePartnerRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.CreatePartnerRsType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.TransferPartnerRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.TransferPartnerRsType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnerStatusRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnerStatusRsType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnersDetailsRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnersDetailsRsType;
import com.sadad.ebpp.wsdl.partnermanagementservice._1.PartnerManagementFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

public interface PartnerManagementDelegate extends RequestResponseLogger
{
	public CreatePartnerRsType createPartner(CreatePartnerRqType createPartnerRq) throws PartnerManagementFault;

	public UpdatePartnerStatusRsType updatePartnerStatus(UpdatePartnerStatusRqType updatePartnerStatusRq) throws PartnerManagementFault;

	public TransferPartnerRsType transferPartner(TransferPartnerRqType transferPartnerRq) throws PartnerManagementFault;

	public UpdatePartnersDetailsRsType updatePartnersDetails(UpdatePartnersDetailsRqType updatePartnersDetailsRq) throws PartnerManagementFault;
}