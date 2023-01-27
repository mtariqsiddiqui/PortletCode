package com.sadad.portal.services.delegate.factory.implementation;

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
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * 
 * @author Tariq Siddiqui
 * 
 */

public interface ReferenceDataServiceDelegate extends RequestResponseLogger
{
	// Access Channel related services
	public ListAccessChannelRsType listAccessChannel(ListAccessChannelRqType listAccessChannelRq) throws ReferenceDataFault;

	public ListAccessChannelRsType getAccessChannel(ListAccessChannelRqType getAccessChannelRq) throws ReferenceDataFault;

	public CreateAccessChannelRsType createAccessChannel(CreateAccessChannelRqType createAccessChannelRq) throws ReferenceDataFault;

	public UpdateAccessChannelRsType updateAccessChannel(UpdateAccessChannelRqType updateAccessChannelRq) throws ReferenceDataFault;

	public ActivateAccessChannelRsType activateAccessChannel(ActivateAccessChannelRqType activateAccessChannelRq) throws ReferenceDataFault;

	public DeactivateAccessChannelRsType deactivateAccessChannel(DeactivateAccessChannelRqType deactivateAccessChannelRq) throws ReferenceDataFault;

	// District Code related services
	public ListDistrictCodeRsType listDistrictCode(ListDistrictCodeRqType listDistrictCodeRq) throws ReferenceDataFault;

	public CreateDistrictCodeRsType createDistrictCode(CreateDistrictCodeRqType createDistrictCodeRq) throws ReferenceDataFault;

	public UpdateDistrictCodeRsType updateDistrictCode(UpdateDistrictCodeRqType updateDistrictCodeRq) throws ReferenceDataFault;

	public ActivateDistrictCodeRsType activateDistrictCode(ActivateDistrictCodeRqType activateDistrictCodeRq) throws ReferenceDataFault;

	public DeactivateDistrictCodeRsType deactivateDistrictCode(DeactivateDistrictCodeRqType deactivateDistrictCodeRq) throws ReferenceDataFault;

	// Account Type related services
	public ListAccountTypeRsType listAccountType(ListAccountTypeRqType listAccountTypeRq) throws ReferenceDataFault;

	public ListAccountTypeRsType getAccountType(ListAccountTypeRqType getAccountTypeRq) throws ReferenceDataFault;

	public CreateAccountTypeRsType createAccountType(CreateAccountTypeRqType createAccountTypeRq) throws ReferenceDataFault;

	public UpdateAccountTypeRsType updateAccountType(UpdateAccountTypeRqType updateAccountTypeRq) throws ReferenceDataFault;

	public ActivateAccountTypeRsType activateAccountType(ActivateAccountTypeRqType activateAccountTypeRq) throws ReferenceDataFault;

	public DeactivateAccountTypeRsType deactivateAccountType(DeactivateAccountTypeRqType deactivateAccountTypeRq) throws ReferenceDataFault;

	// Payment Method related services
	public ListPaymentMethodRsType listPaymentMethod(ListPaymentMethodRqType listPaymentMethodRq) throws ReferenceDataFault;

	public CreatePaymentMethodRsType createPaymentMethod(CreatePaymentMethodRqType createPaymentMethodRq) throws ReferenceDataFault;

	public UpdatePaymentMethodRsType updatePaymentMethod(UpdatePaymentMethodRqType updatePaymentMethodRq) throws ReferenceDataFault;

	public ActivatePaymentMethodRsType activatePaymentMethod(ActivatePaymentMethodRqType activatePaymentMethodRq) throws ReferenceDataFault;

	public DeactivatePaymentMethodRsType deactivatePaymentMethod(DeactivatePaymentMethodRqType deactivatePaymentMethodRq) throws ReferenceDataFault;
}