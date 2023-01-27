package com.sadad.portal.beans;

import java.util.LinkedHashMap;

public abstract class SadadAuditEnablingSessionDataBean extends SadadPortalSessionDataBean
{
	// Audit Request fields
	protected String auditEntity;
	protected String auditBusinessKey;
	protected String auditRefrenceKey;
	protected String auditSadadKey;
	protected LinkedHashMap<Integer, Audit> audits;
	

	public String getAuditEntity()
	{
		return auditEntity;
	}

	public void setAuditEntity(String auditEntity)
	{
		this.auditEntity = auditEntity;
	}

	public String getAuditBusinessKey()
	{
		return auditBusinessKey;
	}

	public void setAuditBusinessKey(String auditBusinessKey)
	{
		this.auditBusinessKey = auditBusinessKey;
	}

	public String getAuditRefrenceKey()
	{
		return auditRefrenceKey;
	}

	public void setAuditRefrenceKey(String auditRefrenceKey)
	{
		this.auditRefrenceKey = auditRefrenceKey;
	}

	public String getAuditSadadKey()
	{
		return auditSadadKey;
	}

	public void setAuditSadadKey(String auditSadadKey)
	{
		this.auditSadadKey = auditSadadKey;
	}

	/**
	 * @return the audits
	 */
	public LinkedHashMap<Integer, Audit> getAudits()
	{
		if (audits == null)
			audits = new LinkedHashMap<Integer, Audit>();
		return audits;
	}
}
