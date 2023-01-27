/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.settlement.settlementinstructuionsreportservice._1.SettlementInstructuionsReportRqType;
import com.sadad.ebpp.scm.schema.settlement.settlementinstructuionsreportservice._1.SettlementInstructuionsReportRsType;
import com.sadad.ebpp.wsdl.settlement.settlementinstructuionsreportservice._1.SettlementInstructuionsReportFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * @author Tariq Siddiqui
 *
 */
public interface SettlementInstructuionsReportServiceDelegate extends RequestResponseLogger
{
	public SettlementInstructuionsReportRsType generateSettlementInstructuionsReport(SettlementInstructuionsReportRqType sirrt) throws SettlementInstructuionsReportFault;
}
