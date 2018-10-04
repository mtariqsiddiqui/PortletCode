//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.ebpp.wsdl.lookupservice._1;

import javax.xml.ws.WebFault;
import com.sadad.scm.error._1.FaultType;

@WebFault(name = "LookupFault", targetNamespace = "http://www.sadad.com/EBPP/schema/Lookup/1.0")
public class LookupFault
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
    public LookupFault(String message, FaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public LookupFault(String message, FaultType faultInfo, Throwable cause) {
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