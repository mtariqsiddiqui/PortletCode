/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;

/**
 * @author Tariq Siddiqui
 * 
 */
public class DistrictCodeSessionDataBean extends SadadAuditEnablingSessionDataBean
{
	private String districtCode;
	private String status;
	private String description;
	private ArrayList<DistrictCodeSessionDataBean> districtCodeList;
	private DistrictCodeSessionDataBean selectedDistrictCode;

	public DistrictCodeSessionDataBean()
	{
		super();
	}

	public String getDistrictCode()
	{
		return districtCode;
	}

	public void setDistrictCode(String districtCode)
	{
		this.districtCode = districtCode;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the paymentTypeList
	 */
	public ArrayList<DistrictCodeSessionDataBean> getDistrictCodeList()
	{
		return districtCodeList;
	}

	/**
	 * @param paymentTypeList
	 *            the paymentTypeList to set
	 */
	public void setDistrictCodeList(ArrayList<DistrictCodeSessionDataBean> districtCodeList)
	{
		this.districtCodeList = districtCodeList;
	}

	/**
	 * @return the selectedPaymentType
	 */
	public DistrictCodeSessionDataBean getSelectedDistrictCode()
	{
		return selectedDistrictCode;
	}

	/**
	 * @param selectedPaymentType
	 *            the selectedPaymentType to set
	 */
	public void setSelectedDistrictCode(DistrictCodeSessionDataBean selectedDistrictCode)
	{
		this.selectedDistrictCode = selectedDistrictCode;
	}
}