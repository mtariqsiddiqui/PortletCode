/**
 * 
 */
package com.sadad.portal.beans;

/**
 * @author Tariq Siddiqui
 *
 */
public class Screen
{
	private static final String NONE = "/jsp/html/common/NONE.jsp";
	
	private String container1;
	private String container2;
	
	public Screen()
	{
		this.container1 = "";
		this.container2 = NONE;
	}

	/**
	 * @return the NONE
	 */
	public String getNONE()
	{
		return NONE;
	}

	/**
	 * @return the container1
	 */
	public String getContainer1()
	{
		return container1;
	}
	/**
	 * @param container1 the container1 to set
	 */
	public void setContainer1(String container1)
	{
		this.container1 = container1;
	}
	/**
	 * @return the container2
	 */
	public String getContainer2()
	{
		return container2;
	}
	/**
	 * @param container2 the container2 to set, 
	 * incase of NULL, NONE will be set
	 */
	public void setContainer2(String container2)
	{
		if(container2 == null)
			this.container2 = NONE;

		this.container2 = container2;
	}
}
