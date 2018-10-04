//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package com.sadad.ebpp.wsdl.customer._1;

import javax.xml.ws.WebFault;
import com.sadad.scm.error._1.FaultType;

@WebFault(name = "CustomerFault", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/Customer/1.0")
public class CustomerFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private FaultType faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public CustomerFault(String message, FaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public CustomerFault(String message, FaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.sadad.scm.error._1.FaultType
     */
    public FaultType getFaultInfo() {
        return faultInfo;
    }

}