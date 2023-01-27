package com.sadad.portal.beans;

/**
 * @author Tariq Siddiqui
 * 
 */
public class TestConnectionResults
{
	private long statusCode;
	private String statusDesc;

	/**
	 * @return the statusCode
	 */
	public long getStatusCode()
	{
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(long statusCode)
	{
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc()
	{
		return statusDesc;
	}

	/**
	 * @param statusDesc
	 *            the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}
}