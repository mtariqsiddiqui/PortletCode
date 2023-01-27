package com.sadad.portal.beans;

import javax.xml.datatype.XMLGregorianCalendar;

public class Audit
{
	private XMLGregorianCalendar auditDate;
	private String auditAction;
	private String auditType;
	private String auditSource;
	private String auditOption;

	/**
	 * @return the auditDate
	 */
	public XMLGregorianCalendar getAuditDate()
	{
		return auditDate;
	}

	/**
	 * @param auditDate
	 *            the auditDate to set
	 */
	public void setAuditDate(XMLGregorianCalendar auditDate)
	{
		this.auditDate = auditDate;
	}

	/**
	 * @return the auditAction
	 */
	public String getAuditAction()
	{
		return auditAction;
	}

	/**
	 * @param auditAction
	 *            the auditAction to set
	 */
	public void setAuditAction(String auditAction)
	{
		this.auditAction = auditAction;
	}

	/**
	 * @return the auditType
	 */
	public String getAuditType()
	{
		return auditType;
	}

	/**
	 * @param auditType
	 *            the auditType to set
	 */
	public void setAuditType(String auditType)
	{
		this.auditType = auditType;
	}

	/**
	 * @return the auditSource
	 */
	public String getAuditSource()
	{
		return auditSource;
	}

	/**
	 * @param auditSource
	 *            the auditSource to set
	 */
	public void setAuditSource(String auditSource)
	{
		this.auditSource = auditSource;
	}

	/**
	 * @return the auditOption
	 */
	public String getAuditOption()
	{
		return auditOption;
	}

	/**
	 * @param auditOption
	 *            the auditOption to set
	 */
	public void setAuditOption(String auditOption)
	{
		this.auditOption = auditOption;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Audit [auditDate=" + auditDate + ", auditAction=" + auditAction + ", auditType=" + auditType + ", auditSource=" + auditSource + ", auditOption=" + auditOption + "]";
	}
}
