//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package com.sadad.wsdl.corepayment._1;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "CorePayment", targetNamespace = "http://sadad.com/wsdl/CorePayment/1.0", wsdlLocation = "META-INF/wsdl/CorePayment.wsdl")
public class CorePayment
    extends Service
{

    private final static URL COREPAYMENT_WSDL_LOCATION;
    private final static WebServiceException COREPAYMENT_EXCEPTION;
    private final static QName COREPAYMENT_QNAME = new QName("http://sadad.com/wsdl/CorePayment/1.0", "CorePayment");

    static {
            COREPAYMENT_WSDL_LOCATION = com.sadad.wsdl.corepayment._1.CorePayment.class.getResource("/META-INF/wsdl/CorePayment.wsdl");
        WebServiceException e = null;
        if (COREPAYMENT_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'META-INF/wsdl/CorePayment.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        COREPAYMENT_EXCEPTION = e;
    }

    public CorePayment() {
        super(__getWsdlLocation(), COREPAYMENT_QNAME);
    }

    public CorePayment(WebServiceFeature... features) {
        super(__getWsdlLocation(), COREPAYMENT_QNAME, features);
    }

    public CorePayment(URL wsdlLocation) {
        super(wsdlLocation, COREPAYMENT_QNAME);
    }

    public CorePayment(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, COREPAYMENT_QNAME, features);
    }

    public CorePayment(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CorePayment(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CorePaymentPort
     */
    @WebEndpoint(name = "CorePaymentPort")
    public CorePaymentPort getCorePaymentPort() {
        return super.getPort(new QName("http://sadad.com/wsdl/CorePayment/1.0", "CorePaymentPort"), CorePaymentPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CorePaymentPort
     */
    @WebEndpoint(name = "CorePaymentPort")
    public CorePaymentPort getCorePaymentPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://sadad.com/wsdl/CorePayment/1.0", "CorePaymentPort"), CorePaymentPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (COREPAYMENT_EXCEPTION!= null) {
            throw COREPAYMENT_EXCEPTION;
        }
        return COREPAYMENT_WSDL_LOCATION;
    }

}
