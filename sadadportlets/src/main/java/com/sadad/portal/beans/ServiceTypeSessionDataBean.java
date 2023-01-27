/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;

/**
 * @author Tariq Siddiqui
 * 
 */
public class ServiceTypeSessionDataBean extends SadadAuditEnablingSessionDataBean
{
	private String serviceTypeCode;
	private String serviceTypeTag;
	private String parentServiceTypeCode;
	private String parentServiceTypeTag;
	private String description;
	private String status;
	
	private ArrayList<ServiceTypeSessionDataBean> serviceTypeList;
	private ServiceTypeSessionDataBean selectedServiceType;

	public ServiceTypeSessionDataBean()
	{
		super();
	}

	public String getServiceTypeCode()
	{
		return serviceTypeCode;
	}

	public void setServiceTypeCode(String serviceTypeCode)
	{
		this.serviceTypeCode = serviceTypeCode;
	}

	public String getServiceTypeTag()
	{
		return serviceTypeTag;
	}

	public void setServiceTypeTag(String serviceTypeTag)
	{
		this.serviceTypeTag = serviceTypeTag;
	}

	public String getParentServiceTypeCode()
	{
		return parentServiceTypeCode;
	}

	public void setParentServiceTypeCode(String parentServiceTypeCode)
	{
		this.parentServiceTypeCode = parentServiceTypeCode;
	}

	public String getParentServiceTypeTag()
	{
		return parentServiceTypeTag;
	}

	public void setParentServiceTypeTag(String parentServiceTypeTag)
	{
		this.parentServiceTypeTag = parentServiceTypeTag;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public ArrayList<ServiceTypeSessionDataBean> getServiceTypeList()
	{
		return serviceTypeList;
	}

	public void setServiceTypeList(ArrayList<ServiceTypeSessionDataBean> serviceTypeList)
	{
		this.serviceTypeList = serviceTypeList;
	}

	public ServiceTypeSessionDataBean getSelectedServiceType()
	{
		return selectedServiceType;
	}

	public void setSelectedServiceType(ServiceTypeSessionDataBean selectedServiceType)
	{
		this.selectedServiceType = selectedServiceType;
	}

	@Override
	public String toString()
	{
		final int maxLen = 10;
		return "ServiceTypeSessionDataBean [" 
				+ (serviceTypeCode != null ? "serviceTypeCode=" + serviceTypeCode + ", " : "") 
				+ (serviceTypeTag != null ? "serviceTypeTag=" + serviceTypeTag + ", " : "")
				+ (parentServiceTypeCode != null ? "parentServiceTypeCode=" + parentServiceTypeCode + ", " : "")
				+ (parentServiceTypeTag != null ? "parentServiceTypeTag=" + parentServiceTypeTag + ", " : "")
				+ (description != null ? "description=" + description + ", " : "") 
				+ (status != null ? "status=" + status + ", " : "")
				+ (serviceTypeList != null ? "serviceTypeList=" + serviceTypeList.subList(0, Math.min(serviceTypeList.size(), maxLen)) + ", " : "")
				+ (selectedServiceType != null ? "selectedServiceType=" + selectedServiceType : "") + "]";
	}
}