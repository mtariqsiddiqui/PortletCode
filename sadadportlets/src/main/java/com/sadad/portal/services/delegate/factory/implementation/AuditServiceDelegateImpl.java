/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.auditservice._1.ListAuditRqType;
import com.sadad.ebpp.scm.schema.auditservice._1.ListAuditRsType;
import com.sadad.ebpp.wsdl.auditservice._1.AuditServicePort;
import com.sadad.ebpp.wsdl.auditservice._1.ListAuditFault;
import com.sadad.portal.services.client.proxy.AuditServiceProxy;

/**
 * @author Tariq Siddiqui
 *
 */
public class AuditServiceDelegateImpl implements AuditServiceDelegate
{
	private static AuditServiceDelegateImpl instance;
	private AuditServiceProxy proxy;
	private AuditServicePort service;

	private AuditServiceDelegateImpl()
	{
		proxy = new AuditServiceProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.AUDIT_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of AuditServiceDelegateImpl
	 * 
	 * @return
	 */
	public static AuditServiceDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new AuditServiceDelegateImpl();
		}
		return instance;
	}

	@Override
	public ListAuditRsType listAudit(ListAuditRqType auditRequest) throws ListAuditFault
	{
		ListAuditRsType auditResponse = service.listAudit(auditRequest);
		return auditResponse;
	}
}