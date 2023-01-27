package com.sadad.portal.exception;

import com.sadad.scm.error._1.FaultType;

public class SadadGenericFault extends Exception
{
	private static final long serialVersionUID = -4632204670779566724L;

	/**
	 * Java type that goes as soapenv:Fault detail element.
	 * 
	 */
	private FaultType faultInfo;

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 */
	public SadadGenericFault(String message, FaultType faultInfo)
	{
		super(message);
		this.faultInfo = faultInfo;
	}

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 * @param cause
	 */
	public SadadGenericFault(String message, FaultType faultInfo, Throwable cause)
	{
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	/**
	 * 
	 * @return returns fault bean: com.sadad.scm.error._1.FaultType
	 */
	public FaultType getFaultInfo()
	{
		return faultInfo;
	}
}