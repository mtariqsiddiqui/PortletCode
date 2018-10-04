package com.sadad.portal.beans;


import com.sadad.scm.common._1.ConfigurationStatusEnum;

public class ServiceTypeDetail
{
	private String serviceType;
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

	
	

	public ConfigurationStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ConfigurationStatusEnum status) {
		this.status = status;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public String toString() {
		return "ServiceTypeDetail [serviceType=" + serviceType + ", status="
				+ status + ", description=" + description + ", asDefault="
				+ asDefault + "]";
	}

	

	
}
