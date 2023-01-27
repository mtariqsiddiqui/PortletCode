/**
 * 
 */
package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.billernotification._1.NotifyPaymentBulkRqType;
import com.sadad.ebpp.scm.schema.billernotification._1.NotifyRefundRqType;
import com.sadad.ebpp.scm.schema.bulkuploadconfirmationservice._1.GenerateBulkUploadConfirmationFileRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.FileSearchResultType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.FileStatusesType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesAdvancedRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesRsType;
import com.sadad.ebpp.scm.schema.fileoutbound._1.FileOutboundBaseType;
import com.sadad.ebpp.scm.schema.fileoutbound._1.FileOutboundRqType;
import com.sadad.ebpp.scm.schema.reconciliation.reconciliationcutoffservice._1.ReconciliationCutoffRqType;
import com.sadad.ebpp.scm.schema.reconciliation.reconciliationreportcommon._1.ReconciliationReportRqType;
import com.sadad.ebpp.scm.schema.settlement.settlementinstructuionsreportservice._1.SettlementInstructuionsReportRqType;
import com.sadad.ebpp.wsdl.billernotification._1.NotifyPaymentBulkFault;
import com.sadad.ebpp.wsdl.billernotification._1.NotifyRefundFault;
import com.sadad.ebpp.wsdl.filemanagementservice._1.FileManagementFault;
import com.sadad.ebpp.wsdl.reconciliation.reconciliationreportservice._1.ReconciliationReportFault;
import com.sadad.ebpp.wsdl.settlement.settlementinstructuionsreportservice._1.SettlementInstructuionsReportFault;
import com.sadad.portal.beans.BatchFilesSessionDataBean;
import com.sadad.portal.beans.BatchFilesTypeEnum;
import com.sadad.portal.beans.Files;
import com.sadad.portal.common.utils.SadadMessagingClient;
import com.sadad.portal.common.utils.SadadXmlUtils;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.DateRangeCType;
import com.sadad.scm.common._1.FileLifecycleEnums;
import com.sadad.scm.common._1.FileType;
import com.sadad.scm.error._1.ErrorType;
import com.sadad.scm.error._1.FaultType;
import com.sadad.scm.error._1.SeverityType;

/**
 * @author Tariq Siddiqui
 * 
 */
public class BatchFilesHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = BatchFilesHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Calls the backend webservice to get the partner files based on the input provded
	 * 
	 * @param sesObj
	 *            - Session bean object contain the necesary information to populate the SOAP request
	 * @return sesObj after the reflected updates from SOAP response
	 */
	public BatchFilesSessionDataBean callSearchFilesAdvanced(BatchFilesSessionDataBean sesObj)
	{
		final String methodName = "callSearchFilesAdvanced";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			SearchFilesAdvancedRqType sfReq = new SearchFilesAdvancedRqType();
			sfReq.setMessageHeader(getMessageHeaderType("SEARCH_FILES", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			sfReq.setPartnerKey(sesObj.getOrgId());
			sfReq.getFileType().add(sesObj.getFileType());
			sfReq.setAsyncRqUID(sesObj.getAsyncRquid());
			sfReq.setFileName(sesObj.getFileName());
			if (sesObj.getDateRangeFrom() != null)
			{
				sfReq.setArrivalDateRange(new DateRangeCType());
				sfReq.getArrivalDateRange().setFrom(sesObj.parseXmlFromDate(sesObj.getDateRangeFrom()));
				sfReq.getArrivalDateRange().setTo(sesObj.parseXmlToDate(sesObj.getDateRangeTo()));
			}

			// Added File Status for service to work, otherwise there is no statuses mentioned in OW screen
			// File Status added as hidden fields on regenerate and send batch files 
			sfReq.setFileStatuses(new FileStatusesType());
			for(String status : sesObj.getFileStatus().split(","))
				sfReq.getFileStatuses().getStatus().add(FileLifecycleEnums.fromValue(status));					

			SearchFilesRsType sfRes = fileService.searchFilesAdvanced(sfReq);

			sesObj.getFiles().clear();
			if (sfRes.getFile().size() > 0)
			{
				for (FileSearchResultType fsrt : sfRes.getFile())
				{
					Files rf = new Files();
					rf.setFileName(fsrt.getFileName());
					rf.setFilePath(fsrt.getFilePath());
					rf.setRquid(fsrt.getRqUID());
					rf.setUuid(fsrt.getUUID() != null ? fsrt.getUUID() : null);
					rf.setCid(fsrt.getUUID() != null ? fsrt.getUUID() : null);
					rf.setPartnerKey(fsrt.getPartnerKey());
					rf.setFileType(fsrt.getMsgCode());
					rf.setFileSize(fsrt.getFileSize() != null ? fsrt.getFileSize() : (Long) null);
					rf.setRecordCount(fsrt.getRecordCount() != null ? fsrt.getRecordCount() : (Long) null);
					rf.setStatus(fsrt.getStatus().toString());
					if (fsrt.getProcessingSummary() != null)
					{
						rf.setSuccessCount(fsrt.getProcessingSummary().getSuccessCount());
						rf.setFailureCount(fsrt.getProcessingSummary().getFailureCount());
					}
					rf.setFileCreationDate(fsrt.getFileCreationDate() != null ? fsrt.getFileCreationDate().toString() : null);
					rf.setFileProcessingDate(fsrt.getFileProcessDate() != null ? fsrt.getFileProcessDate().toString() : null);

					if (fsrt.getAssociatedFiles().size() > 0)
					{
						for (FileType aft : fsrt.getAssociatedFiles())
						{
							Files af = new Files();
							af.setFileName(aft.getFileName());
							af.setFilePath(aft.getFilePath() != null ? aft.getFilePath() : null);
							af.setRquid(aft.getRqUID());
							af.setUuid(aft.getUUID());
							af.setCid(aft.getCorrelationId() != null ? aft.getCorrelationId() : null);
							af.setPartnerKey(aft.getPartnerKey());
							af.setFileType(aft.getMsgCode());
							af.setFileSize(aft.getFileSize() != null ? aft.getFileSize() : (Long) null);
							af.setRecordCount(aft.getRecordCount() != null ? aft.getRecordCount() : (Long) null);
							af.setStatus(aft.getStatus() != null ? aft.getStatus().toString() : null);
							af.setFileCreationDate(aft.getFileCreationDate() != null ? aft.getFileCreationDate().toString() : null);
							af.setFileProcessingDate(aft.getFileProcessDate() != null ? aft.getFileProcessDate().toString() : null);

							rf.getAssociatedFiles().put(af.getFileName(), af);
						}
					}
					sesObj.getFiles().put(rf.getFileName(), rf);
				}
			}
			else
			{
				// Throwing FileManagementFault
				String message = "No file found for the search criteria.";
				FaultType ft = new FaultType();
				ft.setType(ErrorType.BUSINESS);
				ft.setSeverity(SeverityType.ERROR);
				ft.setCode(19818);
				ft.setDescription(message);
				throw new FileManagementFault(message, ft);
			}
		}
		catch (FileManagementFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	/**
	 * 
	 * @param sesObj
	 * @return
	 */
	public BatchFilesSessionDataBean callDropMessageInQueueForSendingFile(BatchFilesSessionDataBean sesObj)
	{
		final String methodName = "callDropMessageInQueueForSendingFile";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			FileOutboundRqType fort = new FileOutboundRqType();
			fort.setMessageHeader(getMessageHeaderType("SEND_FILE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			Files file2Send = sesObj.getFiles().get(sesObj.getSendBatchFiles());
			FileOutboundBaseType fobt = new FileOutboundBaseType();
			FileType ft = new FileType();
			ft.setFileName(file2Send.getFileName());
			ft.setFilePath(file2Send.getFilePath());
			ft.setRqUID(file2Send.getRquid());
			ft.setCorrelationId(file2Send.getCid());
			ft.setPartnerKey(sesObj.getOrgId());
			ft.setMsgCode(file2Send.getFileType());
			ft.setFileSize(file2Send.getFileSize());
			ft.setFileCreationDate(sesObj.parseXmlFullDate(file2Send.getFileCreationDate()));
			if (file2Send.getFileProcessingDate() != null)
				ft.setFileProcessDate(sesObj.parseXmlFullDate(file2Send.getFileProcessingDate()));
			ft.setStatus(FileLifecycleEnums.fromValue(file2Send.getStatus()));
			fobt.setFile(ft);
			fobt.setProcessId(sesObj.getRandomGloballyUniqueIdentifier());
			fobt.setStepId(sesObj.getRandomGloballyUniqueIdentifier());
			fort.setMessageDetails(fobt);

			SadadMessagingClient.sendMessage("FILE_OUTBOUND_JMS_CONN", 
					SadadXmlUtils.xmlMarshaller("FileOutboundRq", 
							FileOutboundRqType.class, fort));

			sesObj.setInfoMessage(18001);
		}
		catch (DatatypeConfigurationException e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	/**
	 * Call this method to regenerate several types of batch files
	 * 
	 * @param sesObj
	 * @return
	 */
	public BatchFilesSessionDataBean regenerateBatchFile(BatchFilesSessionDataBean sesObj)
	{
		final String methodName = "regenerateBatchFile";
		logger.entering(CLASS_NAME, methodName);
		
		BatchFilesTypeEnum fileType = BatchFilesTypeEnum.valueOf(sesObj.getFileType());
		switch (fileType)
		{
			// 1 - a) BillerNotification.wsdl --> NotifyRefund
			case RNUBRQ: // Refund Batch Notification
			case RNOCRQ: // Refund Bulk Notification
				sesObj = callNotifyRefund(sesObj);
				break;
			// 1 - b) BillerNotification.wsdl --> NotifyPaymentBulk
			case PNUPRQ: // Payment Batch Notification
				sesObj = callNotifyPaymentBulk(sesObj);
				break;

			// 2) BulkUploadConfirmationService.wsdl --> GenerateBulkUploadConfirmation
			case ACONRQ: // Account Upload Confirmation
			case BCONRQ: // Bill Upload Confirmation
			case PCONRQ: // Payment Upload Confirmation
			case RCONRQ: // Refund Upload Confirmation
				sesObj = callGenerateBulkUploadConfirmation(sesObj);
				break;

			// 3) ReconciliationCutoffService.wsdl --> GenerateReconciliationReport
			case BCUTRQ: // Payment Cutoff
			case RCUTRQ: // Refund Cutoff
				sesObj = callGenerateReconciliationCutOffReport(sesObj);
				break;

			// 4) ReconciliationReportService.wsdl --> GenerateReconciliationReport
			case BKRRRQ: // Bank Refund Reconciliation
			case BKRCRQ: // Bank Payment Reconciliation
			case BLRCRQ: // Biller Payment Reconciliation
			case BSPLRQ: // Biller Payment SPL
			case BLRRRQ: // Biller Refund Reconciliation Report
				sesObj = callGenerateReconciliationReport(sesObj);
				break;

			// SettlementInstructionsReportService.wsdl --> GenerateSettlementInstructionsReport
			case XADRRQ: // Refund Intrabank 1
			case XACRRQ: // Refund Intrabank 2
			case XADDRQ: // Payment Intrabank Instruction File
				sesObj = callGenerateSettlementInstructionsReport(sesObj);
				break;

			default:
				break;
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	public BatchFilesSessionDataBean callNotifyRefund(BatchFilesSessionDataBean sesObj)
	{
		final String methodName = "callNotifyRefund";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			Files f = sesObj.getFiles().get(sesObj.getFileKey());
			NotifyRefundRqType req = new NotifyRefundRqType();
			req.setMessageHeader(getMessageHeaderType(f.getFileType(), sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.getMessageHeader().setUUID(f.getRquid());
			req.setPartnerKey(f.getPartnerKey());
			req.setCorrelationId(f.getCid());
			req.setProcessDate(sesObj.parseXmlFullDate(f.getFileProcessingDate()));
			billerNotificationService.notifyRefund(req);
		}
		catch (NotifyRefundFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	public BatchFilesSessionDataBean callNotifyPaymentBulk(BatchFilesSessionDataBean sesObj)
	{
		final String methodName = "callNotifyPaymentBulk";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			Files f = sesObj.getFiles().get(sesObj.getFileKey());
			NotifyPaymentBulkRqType req = new NotifyPaymentBulkRqType();
			req.setMessageHeader(getMessageHeaderType(f.getFileType(), sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.getMessageHeader().setUUID(f.getRquid());
			req.setPartnerKey(f.getPartnerKey());
			req.setCorrelationId(f.getCid());
			req.setProcessDate(sesObj.parseXmlFullDate(f.getFileProcessingDate()));
			
			DateRangeCType dr = new DateRangeCType();
			dr.setFrom(sesObj.parseXmlFromDate(sesObj.getDateRangeFrom()));
			dr.setTo(sesObj.parseXmlToDate(sesObj.getDateRangeTo()));
			req.setDateRange(dr);
			billerNotificationService.notifyPaymentBulk(req);
		}
		catch (NotifyPaymentBulkFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	public BatchFilesSessionDataBean callGenerateBulkUploadConfirmation(BatchFilesSessionDataBean sesObj)
	{
		final String methodName = "callGenerateBulkUploadConfirmation";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			Files f = sesObj.getFiles().get(sesObj.getFileKey());
			GenerateBulkUploadConfirmationFileRqType req = new GenerateBulkUploadConfirmationFileRqType();
			req.setMessageHeader(getMessageHeaderType(f.getFileType(), sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.getMessageHeader().setUUID(f.getRquid());
			req.setPartnerKey(f.getPartnerKey());
			req.setCorrelationId(f.getCid());
			FileType ft = new FileType();
			ft.setFileName(f.getFileName());
			ft.setRqUID(f.getRquid());
			ft.setPartnerKey(f.getPartnerKey());
			ft.setMsgCode(f.getFileType());
			req.setUploadFile(ft);
			req.setSuccessCount(f.getSuccessCount());
			req.setFailureCount(f.getFailureCount());

			BatchFilesTypeEnum fileType = BatchFilesTypeEnum.valueOf(f.getFileType());
			switch (fileType)
			{
				case ACONRQ:
//					bulkUpldCnfrmAcctService.generateBulkUploadConfirmation(req);
					SadadMessagingClient.sendMessage("ACCOUNTS_CONFIRM_JMS_CONN", 
							SadadXmlUtils.xmlMarshaller("GenerateBulkUploadConfirmationFileRq", 
									GenerateBulkUploadConfirmationFileRqType.class, req));
					break;
				case BCONRQ:
//					bulkUpldCnfrmBillService.generateBulkUploadConfirmation(req);
					SadadMessagingClient.sendMessage("BILLS_CONFIRM_JMS_CONN", 
							SadadXmlUtils.xmlMarshaller("GenerateBulkUploadConfirmationFileRq", 
									GenerateBulkUploadConfirmationFileRqType.class, req));

					break;
				case PCONRQ:
//					bulkUpldCnfrmPmntService.generateBulkUploadConfirmation(req);
					SadadMessagingClient.sendMessage("PAYMENTS_CONFIRM_JMS_CONN", 
							SadadXmlUtils.xmlMarshaller("GenerateBulkUploadConfirmationFileRq", 
									GenerateBulkUploadConfirmationFileRqType.class, req));
					break;
				case RCONRQ:
					logger.logp(Level.WARNING, CLASS_NAME, methodName, "Refund Upload Confirmation Service is not implemented yet.");
					break;
				default:
					logger.logp(Level.WARNING, CLASS_NAME, methodName, "The service input parameters are wrong.");
					break;
			}
		}
//		catch (BulkUploadConfirmationFault e)
//		{
//			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
//			if (sesObj.getMessageToDisplay().getMessageType() == null)
//				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
//					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
//				else
//					sesObj.setGenericErrorMessage();
//
//			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
//			if (logger.isLoggable(Level.FINEST))
//				e.printStackTrace();
//		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	public BatchFilesSessionDataBean callGenerateReconciliationCutOffReport(BatchFilesSessionDataBean sesObj)
	{
		final String methodName = "callGenerateReconciliationCutOffReport";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			Files f = sesObj.getFiles().get(sesObj.getFileKey());
			ReconciliationCutoffRqType req = new ReconciliationCutoffRqType();
			req.setMessageHeader(getMessageHeaderType(f.getFileType(), sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.getMessageHeader().setUUID(f.getRquid());
			req.setPartnerKey(f.getPartnerKey());
			req.setCorrelationId(f.getCid());
			req.setPrcDate(sesObj.parseXmlFullDate((f.getFileProcessingDate() != null ? f.getFileProcessingDate() : f.getFileCreationDate())));
			req.setMaxNumber(10);
			
			reconCutOffService.generateReconciliationReport(req);
		}
		catch (com.sadad.ebpp.wsdl.reconciliation.reconciliationcutoffservice._1.ReconciliationReportFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	public BatchFilesSessionDataBean callGenerateReconciliationReport(BatchFilesSessionDataBean sesObj)
	{
		final String methodName = "callGenerateReconciliationReport";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			Files f = sesObj.getFiles().get(sesObj.getFileKey());
			ReconciliationReportRqType req = new ReconciliationReportRqType();
			req.setMessageHeader(getMessageHeaderType(f.getFileType(), sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.getMessageHeader().setUUID(f.getRquid());
			req.setPartnerKey(f.getPartnerKey());
			req.setCorrelationId(f.getCid());
			req.setPrcDate(sesObj.parseXmlFullDate((f.getFileProcessingDate() != null ? f.getFileProcessingDate() : f.getFileCreationDate())));

			BatchFilesTypeEnum fileType = BatchFilesTypeEnum.valueOf(f.getFileType());
			switch (fileType)
			{
				case BKRRRQ:
				case BKRCRQ:
					reconReportBankService.generateReconciliationReport(req);
					break;
				case BLRCRQ:
				case BSPLRQ:
				case BLRRRQ:
					reconReportBillerService.generateReconciliationReport(req);
					break;
				default:
					logger.logp(Level.WARNING, CLASS_NAME, methodName, "The service input parameters are wrong.");
					break;
			}
		}
		catch (ReconciliationReportFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	public BatchFilesSessionDataBean callGenerateSettlementInstructionsReport(BatchFilesSessionDataBean sesObj)
	{
		final String methodName = "callGenerateSettlementInstructionsReport";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			Files f = sesObj.getFiles().get(sesObj.getFileKey());
			SettlementInstructuionsReportRqType req = new SettlementInstructuionsReportRqType();
			req.setMessageHeader(getMessageHeaderType(f.getFileType(), sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.getMessageHeader().setUUID(f.getRquid());
			req.setPartnerKey(f.getPartnerKey());
			req.setCorrelationId(f.getCid());
			req.setProcessDate(sesObj.parseXmlDate(f.getFileProcessingDate()));

			stltInstRptServie.generateSettlementInstructuionsReport(req);
		}
		catch (SettlementInstructuionsReportFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	public BatchFilesSessionDataBean clearSessionBeanObject(BatchFilesSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}