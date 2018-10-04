//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.ebpp.wsdl.accountquery._1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import com.sadad.schema.service.accountquery._1.GetByKeyRqType;
import com.sadad.schema.service.accountquery._1.GetByKeyRsType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRqType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRsType;

@WebService(name = "AccountQueryPort", targetNamespace = "http://www.sadad.com/EBPP/wsdl/AccountQuery/1.0")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.sadad.scm.common._1.ObjectFactory.class,
    com.sadad.schema.service.accountquery._1.ObjectFactory.class,
    com.sadad.scm.error._1.ObjectFactory.class,
    com.sadad.scm.common.system._1.ObjectFactory.class
})
public interface AccountQueryPort {


    /**
     * 
     * @param getByKeyRq
     * @return
     *     returns com.sadad.schema.service.accountquery._1.GetByKeyRsType
     * @throws AccountQueryFault
     */
    @WebMethod(operationName = "GetByKey", action = "http://sadad.com/EBPP/service/AccountQuery/1.0/GetByKey")
    @WebResult(name = "GetByKeyRs", targetNamespace = "http://sadad.com/schema/service/AccountQuery/1.0", partName = "GetByKeyRs")
    public GetByKeyRsType getByKey(
        @WebParam(name = "GetByKeyRq", targetNamespace = "http://sadad.com/schema/service/AccountQuery/1.0", partName = "GetByKeyRq")
        GetByKeyRqType getByKeyRq)
        throws AccountQueryFault
    ;

    /**
     * 
     * @param listByCustomerRq
     * @return
     *     returns com.sadad.schema.service.accountquery._1.ListByCustomerRsType
     * @throws AccountQueryFault
     */
    @WebMethod(operationName = "ListByCustomer", action = "http://sadad.com/EBPP/service/AccountQuery/1.0/ListByCustomer")
    @WebResult(name = "ListByCustomerRs", targetNamespace = "http://sadad.com/schema/service/AccountQuery/1.0", partName = "ListByCustomerRs")
    public ListByCustomerRsType listByCustomer(
        @WebParam(name = "ListByCustomerRq", targetNamespace = "http://sadad.com/schema/service/AccountQuery/1.0", partName = "ListByCustomerRq")
        ListByCustomerRqType listByCustomerRq)
        throws AccountQueryFault
    ;

}