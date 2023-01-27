/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.testconnectivity._1.TestConnectionRqType;
import com.sadad.ebpp.scm.schema.testconnectivity._1.TestConnectionRsType;
import com.sadad.ebpp.wsdl.testconnectivity._1.TestConnectionFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * @author Reem Hasona
 * 
 */
public interface TestConnectivityDelegate extends RequestResponseLogger
{
	public TestConnectionRsType testConnection(TestConnectionRqType testConnectionRq) throws TestConnectionFault;
}
