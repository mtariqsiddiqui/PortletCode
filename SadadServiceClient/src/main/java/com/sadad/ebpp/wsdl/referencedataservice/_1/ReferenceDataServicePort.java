//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//

package com.sadad.ebpp.wsdl.referencedataservice._1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

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

@WebService(name = "ReferenceDataServicePort", targetNamespace = "http://www.sadad.com/EBPP/wsdl/ReferenceDataService/1.0")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ com.sadad.scm.common._1.ObjectFactory.class, com.sadad.ebpp.schema.referencedata._1.ObjectFactory.class, com.sadad.scm.error._1.ObjectFactory.class, com.sadad.scm.common.system._1.ObjectFactory.class })
public interface ReferenceDataServicePort
{

	/**
	 * 
	 * @param listAccessChannelRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.ListAccessChannelRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "ListAccessChannel")
	@WebResult(name = "ListAccessChannelRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ListAccessChannelRs")
	public ListAccessChannelRsType listAccessChannel(
			@WebParam(name = "ListAccessChannelRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ListAccessChannelRq") ListAccessChannelRqType listAccessChannelRq) throws ReferenceDataFault;

	/**
	 * 
	 * @param getAccessChannelRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.ListAccessChannelRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "GetAccessChannel")
	@WebResult(name = "GetAccessChannelRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "GetAccessChannelRs")
	public ListAccessChannelRsType getAccessChannel(@WebParam(name = "GetAccessChannelRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "GetAccessChannelRq") ListAccessChannelRqType getAccessChannelRq)
			throws ReferenceDataFault;

	/**
	 * 
	 * @param createAccessChannelRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.CreateAccessChannelRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "CreateAccessChannel")
	@WebResult(name = "CreateAccessChannelRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "CreateAccessChannelRs")
	public CreateAccessChannelRsType createAccessChannel(
			@WebParam(name = "CreateAccessChannelRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "CreateAccessChannelRq") CreateAccessChannelRqType createAccessChannelRq) throws ReferenceDataFault;

	/**
	 * 
	 * @param updateAccessChannelRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.UpdateAccessChannelRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "UpdateAccessChannel")
	@WebResult(name = "UpdateAccessChannelRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "UpdateAccessChannelRs")
	public UpdateAccessChannelRsType updateAccessChannel(
			@WebParam(name = "UpdateAccessChannelRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "UpdateAccessChannelRq") UpdateAccessChannelRqType updateAccessChannelRq) throws ReferenceDataFault;

	/**
	 * 
	 * @param activateAccessChannelRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.ActivateAccessChannelRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "ActivateAccessChannel")
	@WebResult(name = "ActivateAccessChannelRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ActivateAccessChannelRs")
	public ActivateAccessChannelRsType activateAccessChannel(
			@WebParam(name = "ActivateAccessChannelRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ActivateAccessChannelRq") ActivateAccessChannelRqType activateAccessChannelRq)
			throws ReferenceDataFault;

	/**
	 * 
	 * @param deactivateAccessChannelRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.DeactivateAccessChannelRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "DeactivateAccessChannel")
	@WebResult(name = "DeactivateAccessChannelRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "DeactivateAccessChannelRs")
	public DeactivateAccessChannelRsType deactivateAccessChannel(
			@WebParam(name = "DeactivateAccessChannelRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "DeactivateAccessChannelRq") DeactivateAccessChannelRqType deactivateAccessChannelRq)
			throws ReferenceDataFault;

	/**
	 * 
	 * @param listDistrictCodeRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.ListDistrictCodeRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "ListDistrictCode")
	@WebResult(name = "ListDistrictCodeRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ListDistrictCodeRs")
	public ListDistrictCodeRsType listDistrictCode(@WebParam(name = "ListDistrictCodeRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ListDistrictCodeRq") ListDistrictCodeRqType listDistrictCodeRq)
			throws ReferenceDataFault;

	/**
	 * 
	 * @param createDistrictCodeRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.CreateDistrictCodeRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "CreateDistrictCode")
	@WebResult(name = "CreateDistrictCodeRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "CreateDistrictCodeRs")
	public CreateDistrictCodeRsType createDistrictCode(
			@WebParam(name = "CreateDistrictCodeRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "CreateDistrictCodeRq") CreateDistrictCodeRqType createDistrictCodeRq) throws ReferenceDataFault;

	/**
	 * 
	 * @param updateDistrictCodeRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.UpdateDistrictCodeRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "UpdateDistrictCode")
	@WebResult(name = "UpdateDistrictCodeRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "UpdateDistrictCodeRs")
	public UpdateDistrictCodeRsType updateDistrictCode(
			@WebParam(name = "UpdateDistrictCodeRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "UpdateDistrictCodeRq") UpdateDistrictCodeRqType updateDistrictCodeRq) throws ReferenceDataFault;

	/**
	 * 
	 * @param activateDistrictCodeRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.ActivateDistrictCodeRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "ActivateDistrictCode")
	@WebResult(name = "ActivateDistrictCodeRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ActivateDistrictCodeRs")
	public ActivateDistrictCodeRsType activateDistrictCode(
			@WebParam(name = "ActivateDistrictCodeRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ActivateDistrictCodeRq") ActivateDistrictCodeRqType activateDistrictCodeRq)
			throws ReferenceDataFault;

	/**
	 * 
	 * @param deactivateDistrictCodeRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.DeactivateDistrictCodeRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "DeactivateDistrictCode")
	@WebResult(name = "DeactivateDistrictCodeRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "DeactivateDistrictCodeRs")
	public DeactivateDistrictCodeRsType deactivateDistrictCode(
			@WebParam(name = "DeactivateDistrictCodeRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "DeactivateDistrictCodeRq") DeactivateDistrictCodeRqType deactivateDistrictCodeRq)
			throws ReferenceDataFault;

	/**
	 * 
	 * @param listAccountTypeRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.ListAccountTypeRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "ListAccountType")
	@WebResult(name = "ListAccountTypeRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ListAccountTypeRs")
	public ListAccountTypeRsType listAccountType(@WebParam(name = "ListAccountTypeRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ListAccountTypeRq") ListAccountTypeRqType listAccountTypeRq)
			throws ReferenceDataFault;

	/**
	 * 
	 * @param getAccountTypeRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.ListAccountTypeRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "GetAccountType")
	@WebResult(name = "GetAccountTypeRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "GetAccountTypeRs")
	public ListAccountTypeRsType getAccountType(@WebParam(name = "GetAccountTypeRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "GetAccountTypeRq") ListAccountTypeRqType getAccountTypeRq)
			throws ReferenceDataFault;

	/**
	 * 
	 * @param createAccountTypeRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.CreateAccountTypeRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "CreateAccountType")
	@WebResult(name = "CreateAccountTypeRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "CreateAccountTypeRs")
	public CreateAccountTypeRsType createAccountType(
			@WebParam(name = "CreateAccountTypeRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "CreateAccountTypeRq") CreateAccountTypeRqType createAccountTypeRq) throws ReferenceDataFault;

	/**
	 * 
	 * @param updateAccountTypeRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.UpdateAccountTypeRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "UpdateAccountType")
	@WebResult(name = "UpdateAccountTypeRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "UpdateAccountTypeRs")
	public UpdateAccountTypeRsType updateAccountType(
			@WebParam(name = "UpdateAccountTypeRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "UpdateAccountTypeRq") UpdateAccountTypeRqType updateAccountTypeRq) throws ReferenceDataFault;

	/**
	 * 
	 * @param activateAccountTypeRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.ActivateAccountTypeRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "ActivateAccountType")
	@WebResult(name = "ActivateAccountTypeRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ActivateAccountTypeRs")
	public ActivateAccountTypeRsType activateAccountType(
			@WebParam(name = "ActivateAccountTypeRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ActivateAccountTypeRq") ActivateAccountTypeRqType activateAccountTypeRq) throws ReferenceDataFault;

	/**
	 * 
	 * @param deactivateAccountTypeRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.DeactivateAccountTypeRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "DeactivateAccountType")
	@WebResult(name = "DeactivateAccountTypeRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "DeactivateAccountTypeRs")
	public DeactivateAccountTypeRsType deactivateAccountType(
			@WebParam(name = "DeactivateAccountTypeRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "DeactivateAccountTypeRq") DeactivateAccountTypeRqType deactivateAccountTypeRq)
			throws ReferenceDataFault;

	/**
	 * 
	 * @param listPaymentMethodRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.ListPaymentMethodRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "ListPaymentMethod")
	@WebResult(name = "ListPaymentMethodRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ListPaymentMethodRs")
	public ListPaymentMethodRsType listPaymentMethod(
			@WebParam(name = "ListPaymentMethodRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ListPaymentMethodRq") ListPaymentMethodRqType listPaymentMethodRq) throws ReferenceDataFault;

	/**
	 * 
	 * @param createPaymentMethodRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.CreatePaymentMethodRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "CreatePaymentMethod")
	@WebResult(name = "CreatePaymentMethodRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "CreatePaymentMethodRs")
	public CreatePaymentMethodRsType createPaymentMethod(
			@WebParam(name = "CreatePaymentMethodRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "CreatePaymentMethodRq") CreatePaymentMethodRqType createPaymentMethodRq) throws ReferenceDataFault;

	/**
	 * 
	 * @param updatePaymentMethodRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.UpdatePaymentMethodRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "UpdatePaymentMethod")
	@WebResult(name = "UpdatePaymentMethodRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "UpdatePaymentMethodRs")
	public UpdatePaymentMethodRsType updatePaymentMethod(
			@WebParam(name = "UpdatePaymentMethodRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "UpdatePaymentMethodRq") UpdatePaymentMethodRqType updatePaymentMethodRq) throws ReferenceDataFault;

	/**
	 * 
	 * @param activatePaymentMethodRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.ActivatePaymentMethodRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "ActivatePaymentMethod")
	@WebResult(name = "ActivatePaymentMethodRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ActivatePaymentMethodRs")
	public ActivatePaymentMethodRsType activatePaymentMethod(
			@WebParam(name = "ActivatePaymentMethodRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "ActivatePaymentMethodRq") ActivatePaymentMethodRqType activatePaymentMethodRq)
			throws ReferenceDataFault;

	/**
	 * 
	 * @param deactivatePaymentMethodRq
	 * @return returns com.sadad.ebpp.schema.referencedata._1.DeactivatePaymentMethodRsType
	 * @throws ReferenceDataFault
	 */
	@WebMethod(operationName = "DeactivatePaymentMethod")
	@WebResult(name = "DeactivatePaymentMethodRs", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "DeactivatePaymentMethodRs")
	public DeactivatePaymentMethodRsType deactivatePaymentMethod(
			@WebParam(name = "DeactivatePaymentMethodRq", targetNamespace = "http://www.sadad.com/EBPP/schema/ReferenceData/1.0", partName = "DeactivatePaymentMethodRq") DeactivatePaymentMethodRqType deactivatePaymentMethodRq)
			throws ReferenceDataFault;

}
