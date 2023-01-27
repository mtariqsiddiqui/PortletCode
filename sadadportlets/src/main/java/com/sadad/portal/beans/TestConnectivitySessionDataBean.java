/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tariq Siddiqui
 * 
 */
public class TestConnectivitySessionDataBean extends SadadPortalSessionDataBean
{
	private String orgType;
	private String orgId;
	private String protocol;
	private String testType;
	private String ipAddress;
	private int port;
	private String msgCode;
	private List<TestConnectionResults> testConnectionResults;

	/**
	 * @return the orgType
	 */
	public String getOrgType()
	{
		return orgType;
	}

	/**
	 * @param orgType
	 *            the orgType to set
	 */
	public void setOrgType(String orgType)
	{
		this.orgType = orgType;
	}

	/**
	 * @return the orgId
	 */
	public String getOrgId()
	{
		return orgId;
	}

	/**
	 * @param orgId
	 *            the orgId to set
	 */
	public void setOrgId(String orgId)
	{
		this.orgId = orgId;
	}

	/**
	 * @return the protocol
	 */
	public String getProtocol()
	{
		return protocol;
	}

	/**
	 * @param protocol
	 *            the protocol to set
	 */
	public void setProtocol(String protocol)
	{
		this.protocol = protocol;
	}

	/**
	 * @return the testType
	 */
	public String getTestType()
	{
		return testType;
	}

	/**
	 * @param testType
	 *            the testType to set
	 */
	public void setTestType(String testType)
	{
		this.testType = testType;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress()
	{
		return ipAddress;
	}

	/**
	 * @param ipAddress
	 *            the ipAddress to set
	 */
	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}

	/**
	 * @return the port
	 */
	public int getPort()
	{
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(int port)
	{
		this.port = port;
	}

	/**
	 * @return the msgCode
	 */
	public String getMsgCode()
	{
		return msgCode;
	}

	/**
	 * @param msgCode
	 *            the msgCode to set
	 */
	public void setMsgCode(String msgCode)
	{
		this.msgCode = msgCode;
	}

	/**
	 * @return the testConnectionResults
	 */
	public List<TestConnectionResults> getTestConnectionResults()
	{
		if (testConnectionResults == null)
			testConnectionResults = new ArrayList<TestConnectionResults>();
		return testConnectionResults;
	}
}