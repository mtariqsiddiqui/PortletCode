package com.sadad.portal.beans;

import com.sadad.scm.common._1.ConfigurationStatusEnum;

public class DistrictCodeDetail
{
	private String districtCode;
	private ConfigurationStatusEnum status;
	private String description;
	private boolean asDefault;

	public boolean isAsDefault()
	{
		return asDefault;
	}

	public void setAsDefault(boolean asDefault)
	{
		this.asDefault = asDefault;
	}

	public String getDistrictCode()
	{
		return districtCode;
	}

	public void setDistrictCode(String districtCode)
	{
		this.districtCode = districtCode;
	}

	public ConfigurationStatusEnum getStatus()
	{
		return status;
	}

	public void setStatus(ConfigurationStatusEnum status)
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
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DistrictCodeDetail [districtCode=" + districtCode + ", status=" + status + ", asDefault=" + asDefault + "]";
	}
}
