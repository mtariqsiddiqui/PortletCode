/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;

/**
 * @author Yameen Haji <YHaji@sadad.com>
 * 
 */
public class DistrictCodeSessionBean extends SadadPortalSessionBean
{
	private String districtCode;
	private ArrayList<DistrictCodeDetail> districtCodeList;
	private DistrictCodeDetail selectedDistrictCode;

	public DistrictCodeSessionBean()
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
	
	/**
	 * @return the paymentTypeList
	 */
	public ArrayList<DistrictCodeDetail> getDistrictCodeList()
	{
		return districtCodeList;
	}

	/**
	 * @param paymentTypeList the paymentTypeList to set
	 */
	public void setDistrictCodeList(ArrayList<DistrictCodeDetail> districtCodeList)
	{
		this.districtCodeList = districtCodeList;
	}
	
	/**
	 * @return the selectedPaymentType
	 */
	public DistrictCodeDetail getSelectedDistrictCode()
	{
		return selectedDistrictCode;
	}
	
	/**
	 * @param selectedPaymentType the selectedPaymentType to set
	 */
	public void setSelectedDistrictCode(DistrictCodeDetail selectedDistrictCode)
	{
		this.selectedDistrictCode = selectedDistrictCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DistrictCodeSessionBean [districtCodeList=" + districtCodeList + ", districtCode=" + districtCode + ", selectedDistrictCode=" + selectedDistrictCode + "]";
	}
}