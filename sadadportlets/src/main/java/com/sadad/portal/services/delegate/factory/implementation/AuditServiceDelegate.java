package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.auditservice._1.ListAuditRqType;
import com.sadad.ebpp.scm.schema.auditservice._1.ListAuditRsType;
import com.sadad.ebpp.wsdl.auditservice._1.ListAuditFault;

/**
 * @author Tariq Siddiqui
 *
 */
public interface AuditServiceDelegate
{
	public ListAuditRsType listAudit(ListAuditRqType listAuditRq) throws ListAuditFault;
}