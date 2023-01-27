/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.reconciliation.reconciliationreportcommon._1.ReconciliationReportRqType;
import com.sadad.ebpp.scm.schema.reconciliation.reconciliationreportcommon._1.ReconciliationReportRsType;
import com.sadad.ebpp.wsdl.reconciliation.reconciliationreportservice._1.ReconciliationReportFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * @author Tariq Siddiqui
 *
 */
public interface ReconciliationReportServiceDelegate extends RequestResponseLogger
{
	public ReconciliationReportRsType generateReconciliationReport(ReconciliationReportRqType rrrt) throws ReconciliationReportFault;
}
