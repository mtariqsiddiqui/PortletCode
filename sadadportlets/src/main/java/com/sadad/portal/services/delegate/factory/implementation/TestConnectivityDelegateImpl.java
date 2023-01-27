/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.testconnectivity._1.TestConnectionRqType;
import com.sadad.ebpp.scm.schema.testconnectivity._1.TestConnectionRsType;
import com.sadad.ebpp.wsdl.testconnectivity._1.TestConnectionFault;
import com.sadad.ebpp.wsdl.testconnectivity._1.TestConnectivityPort;
import com.sadad.portal.services.client.proxy.TestConnectivityPortProxy;

/**
 * @author Reem Hasona
 *
 */
public class TestConnectivityDelegateImpl implements TestConnectivityDelegate
{
	private static TestConnectivityDelegateImpl instance;
	private TestConnectivityPortProxy proxy;
	private TestConnectivityPort service;

	private TestConnectivityDelegateImpl()
	{
		proxy = new TestConnectivityPortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.TEST_CONNECTIVITY_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of TestConnectivityDelegateImpl
	 * 
	 * @return
	 */
	public static TestConnectivityDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new TestConnectivityDelegateImpl();
		}
		return instance;
	}

	@Override
	public TestConnectionRsType testConnection(TestConnectionRqType req) throws TestConnectionFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.TEST_CONNECTIVITY_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("TestConnectionRq", TestConnectionRqType.class, req);

		TestConnectionRsType res = service.testConnection(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("TestConnectionRs", TestConnectionRsType.class, res); 

		return res;
	}

}
