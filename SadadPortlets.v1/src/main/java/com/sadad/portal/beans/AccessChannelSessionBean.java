/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;

/**
 * @author Yameen Haji <YHaji@sadad.com>
 * 
 */
public class AccessChannelSessionBean extends SadadPortalSessionBean
{
	private ArrayList<AccessChannelDetail> accessChannelList;

	private String accessChannel;
	private AccessChannelDetail selectedAccessChannel;

	public AccessChannelSessionBean()
	{
		super();
	}

	public ArrayList<AccessChannelDetail> getAccessChannelList()
	{
		return accessChannelList;
	}

	public void setAccessChannelList(ArrayList<AccessChannelDetail> accessChannelList)
	{
		this.accessChannelList = accessChannelList;
	}

	public String getAccessChannel()
	{
		return accessChannel;
	}

	public void setAccessChannel(String accessChannel)
	{
		this.accessChannel = accessChannel;
	}

	public AccessChannelDetail getSelectedAccessChannel()
	{
		return selectedAccessChannel;
	}

	public void setSelectedAccessChannel(AccessChannelDetail selectedAccessChannel)
	{
		this.selectedAccessChannel = selectedAccessChannel;
	}

	@Override
	public String toString()
	{
		return "AccessChannelSessionBean [accessChannelList=" + accessChannelList + ", accessChannel=" + accessChannel + ", selectedAccessChannel=" + selectedAccessChannel + "]";
	}
}