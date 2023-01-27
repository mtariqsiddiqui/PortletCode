/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.reconciliation.reconciliationcutoffservice._1.ReconciliationCutoffRqType;
import com.sadad.ebpp.scm.schema.reconciliation.reconciliationcutoffservice._1.ReconciliationCutoffRsType;
import com.sadad.ebpp.wsdl.reconciliation.reconciliationcutoffservice._1.ReconciliationReportFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * @author Tariq Siddiqui
 *
 */
public interface ReconciliationCutoffServiceDelegate extends RequestResponseLogger
{
	public ReconciliationCutoffRsType generateReconciliationReport(ReconciliationCutoffRqType rcort) throws ReconciliationReportFault;
}
