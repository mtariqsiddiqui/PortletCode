/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.reconciliation.reconciliationreportcommon._1.ReconciliationReportRqType;
import com.sadad.ebpp.scm.schema.reconciliation.reconciliationreportcommon._1.ReconciliationReportRsType;
import com.sadad.ebpp.wsdl.reconciliation.reconciliationreportservice._1.ReconciliationReportFault;

/**
 * @author Tariq Siddiqui
 *
 */
public interface BillerReconciliationReportServiceDelegate
{
	public ReconciliationReportRsType generateReconciliationReport(ReconciliationReportRqType rrrt) throws ReconciliationReportFault;
}
