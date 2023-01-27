/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;

/**
 * @author Yameen Haji <YHaji@sadad.com>
 * 
 */
public class ServiceTypeSessionBean extends SadadPortalSessionBean
{
	private ArrayList<ServiceTypeDetail> serviceTypeList;
	private String serviceType;
	private ServiceTypeDetail selectedServiceType;

	public ServiceTypeSessionBean()
	{
		super();
	}

	public ArrayList<ServiceTypeDetail> getServiceTypeList()
	{
		return serviceTypeList;
	}

	public void setServiceTypeList(ArrayList<ServiceTypeDetail> serviceTypeList)
	{
		this.serviceTypeList = serviceTypeList;
	}

	public String getServiceType()
	{
		return serviceType;
	}

	public void setServiceType(String serviceType)
	{
		this.serviceType = serviceType;
	}

	public ServiceTypeDetail getSelectedServiceType()
	{
		return selectedServiceType;
	}

	public void setSelectedServiceType(ServiceTypeDetail selectedServiceType)
	{
		this.selectedServiceType = selectedServiceType;
	}

	@Override
	public String toString()
	{
		return "ServiceTypeSessionBean [serviceTypeList=" + serviceTypeList + ", serviceType=" + serviceType + ", selectedServiceType=" + selectedServiceType + "]";
	}
}