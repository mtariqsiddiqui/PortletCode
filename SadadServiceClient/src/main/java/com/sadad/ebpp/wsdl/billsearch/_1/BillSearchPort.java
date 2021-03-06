//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package com.sadad.ebpp.wsdl.billsearch._1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByPaymentRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByPaymentRsType;

@WebService(name = "BillSearchPort", targetNamespace = "http://www.sadad.com/EBPP/wsdl/BillSearch/1.0")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.sadad.scm.common._1.ObjectFactory.class,
    com.sadad.ebpp.scm.schema.billsearch._1.ObjectFactory.class,
    com.sadad.scm.error._1.ObjectFactory.class,
    com.sadad.scm.common.system._1.ObjectFactory.class
})
public interface BillSearchPort {


    /**
     * 
     * @param getByBillNumberRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRsType
     * @throws BillSearchFault
     */
    @WebMethod(operationName = "GetByBillNumber")
    @WebResult(name = "GetByBillNumberRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/BillSearch/1.0", partName = "GetByBillNumberRs")
    public GetByBillNumberRsType getByBillNumber(
        @WebParam(name = "GetByBillNumberRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/BillSearch/1.0", partName = "GetByBillNumberRq")
        GetByBillNumberRqType getByBillNumberRq)
        throws BillSearchFault
    ;

    /**
     * 
     * @param listByAccountRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRsType
     * @throws BillSearchFault
     */
    @WebMethod(operationName = "ListByAccount")
    @WebResult(name = "ListByAccountRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/BillSearch/1.0", partName = "ListByAccountRs")
    public ListByAccountRsType listByAccount(
        @WebParam(name = "ListByAccountRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/BillSearch/1.0", partName = "ListByAccountRq")
        ListByAccountRqType listByAccountRq)
        throws BillSearchFault
    ;

    /**
     * 
     * @param listByCustomerRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRsType
     * @throws BillSearchFault
     */
    @WebMethod(operationName = "ListByCustomer")
    @WebResult(name = "ListByCustomerRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/BillSearch/1.0", partName = "ListByCustomerRs")
    public ListByCustomerRsType listByCustomer(
        @WebParam(name = "ListByCustomerRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/BillSearch/1.0", partName = "ListByCustomerRq")
        ListByCustomerRqType listByCustomerRq)
        throws BillSearchFault
    ;

    /**
     * 
     * @param listByPaymentRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.billsearch._1.ListByPaymentRsType
     * @throws BillSearchFault
     */
    @WebMethod(operationName = "ListByPayment")
    @WebResult(name = "ListByPaymentRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/BillSearch/1.0", partName = "ListByPaymentRs")
    public ListByPaymentRsType listByPayment(
        @WebParam(name = "ListByPaymentRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/BillSearch/1.0", partName = "ListByPaymentRq")
        ListByPaymentRqType listByPaymentRq)
        throws BillSearchFault
    ;

}
