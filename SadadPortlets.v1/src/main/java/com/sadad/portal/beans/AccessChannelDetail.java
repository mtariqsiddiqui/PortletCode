package com.sadad.portal.beans;


import com.sadad.scm.common._1.ConfigurationStatusEnum;

public class AccessChannelDetail
{
	private String accessChannel;
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

	public String getAccessChannel()
	{
		return accessChannel;
	}

	public void setAccessChannel(String accessChannel)
	{
		this.accessChannel = accessChannel;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "AccessChannelDetail [accessChannel=" + accessChannel + ", status=" + status + ", asDefault=" + asDefault + "]";
	}
}
