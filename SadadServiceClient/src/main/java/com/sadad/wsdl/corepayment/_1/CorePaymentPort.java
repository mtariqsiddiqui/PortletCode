//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package com.sadad.wsdl.corepayment._1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import com.sadad.schema.service.corepayment._1.CancelRqType;
import com.sadad.schema.service.corepayment._1.CancelRsType;
import com.sadad.schema.service.corepayment._1.ListByAccountRqType;
import com.sadad.schema.service.corepayment._1.ListByAccountRsType;
import com.sadad.schema.service.corepayment._1.ListByBeneficiaryRqType;
import com.sadad.schema.service.corepayment._1.ListByBeneficiaryRsType;
import com.sadad.schema.service.corepayment._1.ListByBillIdRqType;
import com.sadad.schema.service.corepayment._1.ListByBillIdRsType;
import com.sadad.schema.service.corepayment._1.ListByIdRqType;
import com.sadad.schema.service.corepayment._1.ListByIdRsType;
import com.sadad.schema.service.corepayment._1.ListByPayorRqType;
import com.sadad.schema.service.corepayment._1.ListByPayorRsType;
import com.sadad.schema.service.corepayment._1.UncancelRqType;
import com.sadad.schema.service.corepayment._1.UncancelRsType;

@WebService(name = "CorePaymentPort", targetNamespace = "http://sadad.com/wsdl/CorePayment/1.0")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.sadad.scm.common._1.ObjectFactory.class,
    com.sadad.schema.service.corepayment._1.ObjectFactory.class,
    com.sadad.scm.error._1.ObjectFactory.class,
    com.sadad.scm.common.system._1.ObjectFactory.class
})
public interface CorePaymentPort {


    /**
     * 
     * @param cancelRq
     * @return
     *     returns com.sadad.schema.service.corepayment._1.CancelRsType
     * @throws PaymentFault
     */
    @WebMethod(operationName = "Cancel", action = "http://sadad.com/EBPP/CorePayment/Cancel")
    @WebResult(name = "CancelRs", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "CancelRs")
    public CancelRsType cancel(
        @WebParam(name = "CancelRq", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "CancelRq")
        CancelRqType cancelRq)
        throws PaymentFault
    ;

    /**
     * 
     * @param uncancelRq
     * @return
     *     returns com.sadad.schema.service.corepayment._1.UncancelRsType
     * @throws PaymentFault
     */
    @WebMethod(operationName = "Uncancel", action = "http://sadad.com/EBPP/CorePayment/Uncancel")
    @WebResult(name = "UncancelRs", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "UncancelRs")
    public UncancelRsType uncancel(
        @WebParam(name = "UncancelRq", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "UncancelRq")
        UncancelRqType uncancelRq)
        throws PaymentFault
    ;

    /**
     * 
     * @param listByIdRq
     * @return
     *     returns com.sadad.schema.service.corepayment._1.ListByIdRsType
     * @throws PaymentFault
     */
    @WebMethod(operationName = "ListById", action = "http://sadad.com/EBPP/CorePayment/ListById")
    @WebResult(name = "ListByIdRs", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "ListByIdRs")
    public ListByIdRsType listById(
        @WebParam(name = "ListByIdRq", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "ListByIdRq")
        ListByIdRqType listByIdRq)
        throws PaymentFault
    ;

    /**
     * 
     * @param listByPayorRq
     * @return
     *     returns com.sadad.schema.service.corepayment._1.ListByPayorRsType
     * @throws PaymentFault
     */
    @WebMethod(operationName = "ListByPayor", action = "http://sadad.com/EBPP/CorePayment/ListByPayor")
    @WebResult(name = "ListByPayorRs", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "ListByPayorRs")
    public ListByPayorRsType listByPayor(
        @WebParam(name = "ListByPayorRq", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "ListByPayorRq")
        ListByPayorRqType listByPayorRq)
        throws PaymentFault
    ;

    /**
     * 
     * @param listByAccountRq
     * @return
     *     returns com.sadad.schema.service.corepayment._1.ListByAccountRsType
     * @throws PaymentFault
     */
    @WebMethod(operationName = "ListByAccount", action = "http://sadad.com/EBPP/CorePayment/ListByAccount")
    @WebResult(name = "ListByAccountRs", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "ListByAccountRs")
    public ListByAccountRsType listByAccount(
        @WebParam(name = "ListByAccountRq", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "ListByAccountRq")
        ListByAccountRqType listByAccountRq)
        throws PaymentFault
    ;

    /**
     * 
     * @param listByBillIdRq
     * @return
     *     returns com.sadad.schema.service.corepayment._1.ListByBillIdRsType
     * @throws PaymentFault
     */
    @WebMethod(operationName = "ListByBillId", action = "http://sadad.com/EBPP/CorePayment/ListByBillId")
    @WebResult(name = "ListByBillIdRs", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "ListByBillIdRs")
    public ListByBillIdRsType listByBillId(
        @WebParam(name = "ListByBillIdRq", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "ListByBillIdRq")
        ListByBillIdRqType listByBillIdRq)
        throws PaymentFault
    ;

    /**
     * 
     * @param listByBeneficiaryRq
     * @return
     *     returns com.sadad.schema.service.corepayment._1.ListByBeneficiaryRsType
     * @throws PaymentFault
     */
    @WebMethod(operationName = "ListByBeneficiary", action = "http://sadad.com/EBPP/CorePayment/ListByBillId")
    @WebResult(name = "ListByBeneficiaryRs", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "ListByBeneficiaryRs")
    public ListByBeneficiaryRsType listByBeneficiary(
        @WebParam(name = "ListByBeneficiaryRq", targetNamespace = "http://sadad.com/schema/service/CorePayment/1.0", partName = "ListByBeneficiaryRq")
        ListByBeneficiaryRqType listByBeneficiaryRq)
        throws PaymentFault
    ;

}