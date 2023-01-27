/**
 * 
 */
package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.scm.schema.testconnectivity._1.ConnectionProtocolEnum;
import com.sadad.ebpp.scm.schema.testconnectivity._1.ManualTestType;
import com.sadad.ebpp.scm.schema.testconnectivity._1.PartnerListType;
import com.sadad.ebpp.scm.schema.testconnectivity._1.PartnerTestDetailsType;
import com.sadad.ebpp.scm.schema.testconnectivity._1.PartnerTestType;
import com.sadad.ebpp.scm.schema.testconnectivity._1.PartnerTypeEnums;
import com.sadad.ebpp.scm.schema.testconnectivity._1.TestConnectionRqType;
import com.sadad.ebpp.scm.schema.testconnectivity._1.TestConnectionRsType;
import com.sadad.ebpp.wsdl.testconnectivity._1.TestConnectionFault;
import com.sadad.portal.beans.TestConnectionResults;
import com.sadad.portal.beans.TestConnectivitySessionDataBean;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.error._1.ErrorType;

/**
 * @author Tariq Siddiqui
 *
 */
public class TestConnectivityHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = TestConnectivityHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);
	
	public TestConnectivitySessionDataBean callTestConnectionAutomatic(TestConnectivitySessionDataBean sesObj)
	{
		final String methodName = "callTestConnectionAutomatic";
		try
		{
			TestConnectionRqType req = new TestConnectionRqType();
			req.setMessageHeader(getMessageHeaderType("AUTOMATIC_TEST_CONNECTION", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.setConnectionProtocol(ConnectionProtocolEnum.fromValue(sesObj.getProtocol()));
			PartnerTestType pt = new PartnerTestType();
			pt.setPartnerList(new PartnerListType());
			pt.setPartnerType(PartnerTypeEnums.fromValue(sesObj.getOrgType().toUpperCase()));
			PartnerTestDetailsType ptdt = new PartnerTestDetailsType();
			ptdt.setPartnerKey(sesObj.getOrgId());
			ptdt.setMsgCode(sesObj.getMsgCode());
			pt.getPartnerList().getPartnerTestDetails().add(ptdt);
			req.setPartnerTest(pt);
			TestConnectionRsType res = connectionService.testConnection(req);
			// if it reaches here, it means there is no fault
			sesObj.getTestConnectionResults().clear();
			TestConnectionResults tcr = new TestConnectionResults();
			tcr.setStatusCode(res.getPartnerTestRs().getPartnerStatus().get(0).getStatus().getStatusCode());
			tcr.setStatusDesc(res.getPartnerTestRs().getPartnerStatus().get(0).getStatus().getStatusDesc());
			sesObj.getTestConnectionResults().add(tcr);
		}
		catch (TestConnectionFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		return sesObj;
	}
	
	public TestConnectivitySessionDataBean callTestConnectionManual(TestConnectivitySessionDataBean sesObj)
	{
		final String methodName = "callTestConnectionManual";
		try
		{
			TestConnectionRqType req = new TestConnectionRqType();
			req.setMessageHeader(getMessageHeaderType("MANUAL_TEST_CONNECTION", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.setConnectionProtocol(ConnectionProtocolEnum.fromValue(sesObj.getProtocol()));
			ManualTestType mt = new ManualTestType();
			mt.setIPAddress(sesObj.getIpAddress());
			mt.setPort(sesObj.getPort());
			req.setManualTest(mt);
			
			TestConnectionRsType res = connectionService.testConnection(req);
			// if it reaches here, it means there is no fault
			sesObj.getTestConnectionResults().clear();
			TestConnectionResults tcr = new TestConnectionResults();
			tcr.setStatusCode(res.getManualTestRs().getStatus().getStatusCode());
			tcr.setStatusDesc(res.getManualTestRs().getStatus().getStatusDesc());
			sesObj.getTestConnectionResults().add(tcr);
		}
		catch (TestConnectionFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		return sesObj;
	}
}