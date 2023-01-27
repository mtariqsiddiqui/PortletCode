package com.sadad.portal.beans;


import java.util.List;

import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.common._1.TimeLimitEnum;

public class PaymentTypeDetail
{
	private String paymentType;
	private ConfigurationStatusEnum status;
	private boolean prepaid;
	private boolean canReverse;
	private boolean asDefault;
	private TimeLimitEnum timeLimit;
	private List<String> accessChannel;

	public String getPaymentType()
	{
		return paymentType;
	}

	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}

	/**
	 * @return the status
	 */
	public ConfigurationStatusEnum getStatus()
	{
		return status;
	}

	/**
	 * @param configurationStatusEnum
	 *            the status to set
	 */
	public void setStatus(ConfigurationStatusEnum configurationStatusEnum)
	{
		this.status = configurationStatusEnum;
	}

	public boolean isPrepaid()
	{
		return prepaid;
	}

	public void setPrepaid(boolean prepaid)
	{
		this.prepaid = prepaid;
	}

	public boolean isCanReverse()
	{
		return canReverse;
	}

	public void setCanReverse(boolean canReverse)
	{
		this.canReverse = canReverse;
	}

	public boolean isAsDefault()
	{
		return asDefault;
	}

	public void setAsDefault(boolean asDefault)
	{
		this.asDefault = asDefault;
	}

	public TimeLimitEnum getTimeLimit()
	{
		return timeLimit;
	}

	public void setTimeLimit(TimeLimitEnum timeLimit)
	{
		this.timeLimit = timeLimit;
	}

	public List<String> getAccessChannel()
	{
		return accessChannel;
	}

	public void setAccessChannel(List<String> accessChannel)
	{
		this.accessChannel = accessChannel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PaymentTypeDetail [paymentType=" + paymentType + ", status=" + status + ", prepaid=" + prepaid + ", canReverse=" + canReverse + ", asDefault=" + asDefault + ", timeLimit=" + timeLimit + ", accessChannel="
				+ accessChannel + "]";
	}
}
