/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;

/**
 * @author Tariq Siddiqui
 * 
 */
public class AccessChannelSessionDataBean extends SadadAuditEnablingSessionDataBean
{
	private String accessChannel;
	private String description;
	private String status;
	private ArrayList<AccessChannelSessionDataBean> accessChannelList;
	private AccessChannelSessionDataBean selectedAccessChannel;

	public AccessChannelSessionDataBean()
	{
		super();
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getAccessChannel()
	{
		return accessChannel;
	}

	public void setAccessChannel(String accessChannel)
	{
		this.accessChannel = accessChannel;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public ArrayList<AccessChannelSessionDataBean> getAccessChannelList()
	{
		return accessChannelList;
	}

	public void setAccessChannelList(ArrayList<AccessChannelSessionDataBean> accessChannelList)
	{
		this.accessChannelList = accessChannelList;
	}

	public AccessChannelSessionDataBean getSelectedAccessChannel()
	{
		return selectedAccessChannel;
	}

	public void setSelectedAccessChannel(AccessChannelSessionDataBean selectedAccessChannel)
	{
		this.selectedAccessChannel = selectedAccessChannel;
	}
}