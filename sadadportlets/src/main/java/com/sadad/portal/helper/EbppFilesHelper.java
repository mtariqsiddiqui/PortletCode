/**
 * 
 */
package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.scm.schema.filemanagementservice._1.FileSearchResultType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.FileStatusesType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesAdvancedRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesRsType;
import com.sadad.ebpp.wsdl.filemanagementservice._1.FileManagementFault;
import com.sadad.portal.beans.EbppFilesSessionDataBean;
import com.sadad.portal.beans.Files;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.DateRangeCType;
import com.sadad.scm.common._1.EBPPFileTypesEnums;
import com.sadad.scm.common._1.FileLifecycleEnums;
import com.sadad.scm.common._1.FileType;
import com.sadad.scm.error._1.ErrorType;
import com.sadad.scm.error._1.FaultType;
import com.sadad.scm.error._1.SeverityType;

/**
 * @author Tariq Siddiqui
 * 
 */
public class EbppFilesHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = EbppFilesHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Calls the backend webservice to get the partner files based on the input provded
	 * 
	 * @param sesObj
	 *            - Session bean object contain the necesary information to populate the SOAP request
	 * @return sesObj after the reflected updates from SOAP response
	 */
	public EbppFilesSessionDataBean callSearchFilesAdvanced(EbppFilesSessionDataBean sesObj)
	{
		final String methodName = "callSearchFilesAdvanced";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			SearchFilesAdvancedRqType sfReq = new SearchFilesAdvancedRqType();
			sfReq.setMessageHeader(getMessageHeaderType("SEARCH_FILES", sesObj.getRemoteUser(), sesObj.getLanguageCode()));			
			sfReq.setPartnerKey(sesObj.getOrgId());
			// Set Partner Key for logged-in users, and Organisation Type as it is disabled on the form for NON-SADAD organisation users
			if(sesObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK) || sesObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
			{
				sfReq.setPartnerKey(sesObj.getPartnerKey());
				sesObj.setOrgType(sesObj.getPartnerType());
			}
				
			sfReq.getFileType().add(sesObj.getFileType());
			sfReq.setRqUID(sesObj.getRquid());
			if(sesObj.getArrivalDateFrom() != null)
			{
				sfReq.setArrivalDateRange(new DateRangeCType());
				sfReq.getArrivalDateRange().setFrom(sesObj.parseXmlDate(sesObj.getArrivalDateFrom()));				
				sfReq.getArrivalDateRange().setTo(sesObj.getNextDate(sesObj.getArrivalDateFrom(), Integer.parseInt(sesObj.getArrivalDateRange())));
			}
			if(sesObj.getProcessDateFrom() != null)
			{
				sfReq.setProcessedDateRange(new DateRangeCType());
				sfReq.getProcessedDateRange().setFrom(sesObj.parseXmlDate(sesObj.getProcessDateFrom()));
				sfReq.getProcessedDateRange().setTo(sesObj.getNextDate(sesObj.getProcessDateFrom(), Integer.parseInt(sesObj.getProcessDateRange())));
			}
			if(sesObj.getFileStatus() != null)
			{
				if(sesObj.getFileStatus().indexOf(',') > 0)
				{
					sfReq.setFileStatuses(new FileStatusesType());
					for(String status : sesObj.getFileStatus().split(","))
						sfReq.getFileStatuses().getStatus().add(FileLifecycleEnums.fromValue(status));					
				}
			}

			// START of Database Results Pagination Support
			if(sesObj.getPageNumber() == 0)
				sesObj.setPageNumber(1);
			// TODO - Once the pagination surpport is enabled on Service Level, just un-comment the below line and test the pagination support.
			//sfReq.setPage(sesObj.getPageNumber());
			// END of Database Results Pagination Support
			SearchFilesRsType sfRes = fileService.searchFilesAdvanced(sfReq);
			if(sesObj.getPageNumber() == 1)
				sesObj.getFiles().clear();
			if (!sfRes.getFile().isEmpty())
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
					rf.setFileSize(fsrt.getFileSize() != null ? fsrt.getFileSize() : (Long)null);
					rf.setRecordCount(fsrt.getRecordCount() != null ? fsrt.getRecordCount() : (Long) null);
					rf.setStatus(fsrt.getStatus().toString());
					if(fsrt.getProcessingSummary() != null)
					{
						rf.setSuccessCount(fsrt.getProcessingSummary().getSuccessCount());
						rf.setFailureCount(fsrt.getProcessingSummary().getFailureCount());
					}
					rf.setFileCreationDate(fsrt.getFileCreationDate() != null ? fsrt.getFileCreationDate().toString() : null);
					rf.setFileProcessingDate(fsrt.getFileProcessDate()!= null ? fsrt.getFileProcessDate().toString() : null);

					if (!fsrt.getAssociatedFiles().isEmpty())
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
							af.setFileSize(aft.getFileSize() != null ? aft.getFileSize() : (Long)null);
							af.setRecordCount(aft.getRecordCount() != null ? aft.getRecordCount() : (Long)null);
							af.setStatus(aft.getStatus() != null ? aft.getStatus().toString() : null);
							af.setFileCreationDate(aft.getFileCreationDate() != null ? aft.getFileCreationDate().toString() : null);
							af.setFileProcessingDate(aft.getFileProcessDate() != null ? aft.getFileProcessDate().toString() : null);

							rf.getAssociatedFiles().put(af.getFileName(), af);
						}
					}
					
					if(rf.getFilePath() != null)
						rf.setFileToken(sesObj);

					sesObj.getFiles().put(rf.getFileName(), rf);
				}

				if(sesObj.getFiles().size() % 100 == 0)
					sesObj.setPageNumber(sesObj.getPageNumber()+1);
				else
					sesObj.setPageNumber(-1); // Setting -1 value will not display Fetch more data button on JSP page
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
			if(e.getFaultInfo().getCode() == 13030) // ERROR:13030:The Page requested in the request is out of Page Ranges
				sesObj.setPageNumber(-1); // Setting -1 value will not display Fetch more data button on JSP page

			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(sesObj.getMessageToDisplay().getMessageType() == null)
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
	 * Calls the backend webservice to get the details of associated files based on the input provded
	 * 
	 * @param sesObj
	 *            - Session bean object contain the necesary information to populate the SOAP request
	 * @return sesObj after the reflected updates from SOAP response
	 */
	public EbppFilesSessionDataBean callSearchAssociatedFileDetails(EbppFilesSessionDataBean sesObj)
	{
		final String methodName = "callSearchAssociatedFileDetails";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			SearchFilesRqType sfReq = new SearchFilesRqType();
			sfReq.setMessageHeader(getMessageHeaderType("SEARCH_FILES", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			sfReq.setPartnerKey(sesObj.getOrgId());
			sfReq.getFileType().add(EBPPFileTypesEnums.fromValue(sesObj.getFileType()));
			sfReq.setRqUID(sesObj.getRquid());
			sfReq.setFileName(sesObj.getFileName());
			
			SearchFilesRsType sfRes = fileService.searchFiles(sfReq);

			if (sfRes.getFile().size() > 0)
			{
				for (FileSearchResultType fsrt : sfRes.getFile())
				{
					if(sesObj.getJsonObj() != null)
					{
						char col = ':';
						char comma = ',';
						char quote = '"';
						char ob = '{';
						char cb = '}';
						StringBuilder response = new StringBuilder();

						response.append(ob);
						response.append(quote).append("rquid").append(quote).append(col);
						response.append(quote).append(fsrt.getRqUID() != null ? fsrt.getRqUID() : "Not Defined").append(quote).append(comma);
						response.append(quote).append("fileStatus").append(quote).append(col);
						response.append(quote).append(fsrt.getStatus().toString()).append(quote).append(comma);
						response.append(quote).append("fileName").append(quote).append(col);
						response.append(quote).append(fsrt.getFileName()).append(quote).append(comma);
						response.append(quote).append("filePath").append(quote).append(col);
						response.append(quote).append(fsrt.getFilePath()).append(quote).append(comma);
						response.append(quote).append("fileSize").append(quote).append(col);
						response.append(quote).append(fsrt.getFileSize() != null ? fsrt.getFileSize() : "").append(quote).append(comma);
						response.append(quote).append("fileArrivalDate").append(quote).append(col);
						response.append(quote).append(fsrt.getFileCreationDate() != null ? fsrt.getFileCreationDate().toString() : "").append(quote).append(comma);
						response.append(quote).append("fileProcessedDate").append(quote).append(col);
						response.append(quote).append(fsrt.getFileProcessDate() != null ? fsrt.getFileProcessDate().toString() : "").append(quote);
						response.append(cb);
						sesObj.setJsonObj(response.toString());
						break;
					}
				}
			}
		}
		catch (FileManagementFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(sesObj.getMessageToDisplay().getMessageType() == null)
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
	 * Clear session object from server and restore the Screen-->Container 1, partner, partner and user type values back in object
	 * 
	 * @param sesObj
	 * @return
	 */
	public EbppFilesSessionDataBean clearSessionBeanObject(EbppFilesSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}