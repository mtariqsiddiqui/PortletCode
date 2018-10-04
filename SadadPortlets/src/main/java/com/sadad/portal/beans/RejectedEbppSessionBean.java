/**
 * 
 */
package com.sadad.portal.beans;

/**
 * @author Tariq Siddiqui
 * 
 */

public abstract class RejectedEbppSessionBean extends SadadPortalSessionBean
{
	protected String rquid;
	protected String ebppEntityKey;

	
	public RejectedEbppSessionBean()
	{
		super();
	}

	/**
	 * @return the rquid
	 */
	public String getRquid()
	{
		return rquid;
	}

	/**
	 * @param rquid
	 *            the rquid to set
	 */
	public void setRquid(String rquid)
	{
		this.rquid = rquid;
	}

	/**
	 * @return the ebppEntityKey
	 */
	public String getEbppEntityKey()
	{
		return ebppEntityKey;
	}

	/**
	 * @param ebppEntityKey
	 *            the ebppEntityKey to set
	 */
	public void setEbppEntityKey(String ebppEntityKey)
	{
		this.ebppEntityKey = ebppEntityKey;
	}
}
