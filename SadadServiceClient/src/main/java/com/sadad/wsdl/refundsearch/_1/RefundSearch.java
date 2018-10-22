//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//

package com.sadad.wsdl.refundsearch._1;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "RefundSearch", targetNamespace = "http://sadad.com/wsdl/RefundSearch/1.0", wsdlLocation = "META-INF/wsdl/RefundSearch.wsdl")
public class RefundSearch extends Service
{

	private final static URL REFUNDSEARCH_WSDL_LOCATION;
	private final static WebServiceException REFUNDSEARCH_EXCEPTION;
	private final static QName REFUNDSEARCH_QNAME = new QName("http://sadad.com/wsdl/RefundSearch/1.0", "RefundSearch");

	static
	{
		REFUNDSEARCH_WSDL_LOCATION = com.sadad.wsdl.refundsearch._1.RefundSearch.class.getResource("/META-INF/wsdl/RefundSearch.wsdl");
		WebServiceException e = null;
		if (REFUNDSEARCH_WSDL_LOCATION == null)
		{
			e = new WebServiceException("Cannot find 'META-INF/wsdl/RefundSearch.wsdl' wsdl. Place the resource correctly in the classpath.");
		}
		REFUNDSEARCH_EXCEPTION = e;
	}

	public RefundSearch()
	{
		super(__getWsdlLocation(), REFUNDSEARCH_QNAME);
	}

	public RefundSearch(WebServiceFeature... features)
	{
		super(__getWsdlLocation(), REFUNDSEARCH_QNAME, features);
	}

	public RefundSearch(URL wsdlLocation)
	{
		super(wsdlLocation, REFUNDSEARCH_QNAME);
	}

	public RefundSearch(URL wsdlLocation, WebServiceFeature... features)
	{
		super(wsdlLocation, REFUNDSEARCH_QNAME, features);
	}

	public RefundSearch(URL wsdlLocation, QName serviceName)
	{
		super(wsdlLocation, serviceName);
	}

	public RefundSearch(URL wsdlLocation, QName serviceName, WebServiceFeature... features)
	{
		super(wsdlLocation, serviceName, features);
	}

	/**
	 * 
	 * @return returns RefundSearchPort
	 */
	@WebEndpoint(name = "RefundSearchPort")
	public RefundSearchPort getRefundSearchPort()
	{
		return super.getPort(new QName("http://sadad.com/wsdl/RefundSearch/1.0", "RefundSearchPort"), RefundSearchPort.class);
	}

	/**
	 * 
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy. Supported features not in the <code>features</code> parameter will have their default values.
	 * @return returns RefundSearchPort
	 */
	@WebEndpoint(name = "RefundSearchPort")
	public RefundSearchPort getRefundSearchPort(WebServiceFeature... features)
	{
		return super.getPort(new QName("http://sadad.com/wsdl/RefundSearch/1.0", "RefundSearchPort"), RefundSearchPort.class, features);
	}

	private static URL __getWsdlLocation()
	{
		if (REFUNDSEARCH_EXCEPTION != null)
		{
			throw REFUNDSEARCH_EXCEPTION;
		}
		return REFUNDSEARCH_WSDL_LOCATION;
	}

}