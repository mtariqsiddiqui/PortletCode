/**
 * 
 */
package com.sadad.portal.beans;

import java.util.HashMap;

/**
 * @author Tariq Siddiqui
 * 
 */
public class BatchFilesSessionDataBean extends SadadPortalSessionDataBean
{
	private String orgType;
	private String orgId;
	private String fileType;
	private String fileName;
	private String rquid;
	private String asyncRquid;
	private String dateRangeFrom;
	private String dateRangeTo;
	private String arrivalDateFrom;
	private String arrivalDateTo;
	private String processedDateFrom;
	private String processedDateTo;
	private String fileStatus;
	private String fileKey;
	private HashMap<String, Files> files;
	private String sendBatchFiles;

	/**
	 * @return the orgType
	 */
	public String getOrgType()
	{
		return orgType;
	}

	/**
	 * @param orgType
	 *            the orgType to set
	 */
	public void setOrgType(String orgType)
	{
		this.orgType = orgType;
	}

	/**
	 * @return the orgId
	 */
	public String getOrgId()
	{
		return orgId;
	}

	/**
	 * @param orgId
	 *            the orgId to set
	 */
	public void setOrgId(String orgId)
	{
		this.orgId = orgId;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType()
	{
		return fileType;
	}

	/**
	 * @param fileType
	 *            the fileType to set
	 */
	public void setFileType(String fileType)
	{
		this.fileType = fileType;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName()
	{
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	/**
	 * @return the rquid
	 */
	public String getRquid()
	{
		return rquid;
	}

	/**
	 * @param rquid
	 *            the rquid to set
	 */
	public void setRquid(String rquid)
	{
		this.rquid = rquid;
	}

	/**
	 * @return the asyncRquid
	 */
	public String getAsyncRquid()
	{
		return asyncRquid;
	}

	/**
	 * @param asyncRquid
	 *            the asyncRquid to set
	 */
	public void setAsyncRquid(String asyncRquid)
	{
		this.asyncRquid = asyncRquid;
	}

	/**
	 * @return the dateRangeFrom
	 */
	public String getDateRangeFrom()
	{
		return dateRangeFrom;
	}

	/**
	 * @param dateRangeFrom
	 *            the dateRangeFrom to set
	 */
	public void setDateRangeFrom(String dateRangeFrom)
	{
		this.dateRangeFrom = dateRangeFrom;
	}

	/**
	 * @return the dateRangeTo
	 */
	public String getDateRangeTo()
	{
		return dateRangeTo;
	}

	/**
	 * @param dateRangeTo
	 *            the dateRangeTo to set
	 */
	public void setDateRangeTo(String dateRangeTo)
	{
		this.dateRangeTo = dateRangeTo;
	}
	
	/**
	 * @return the arrivalDateFrom
	 */
	public String getArrivalDateFrom()
	{
		return arrivalDateFrom;
	}

	/**
	 * @param arrivalDateFrom
	 *            the arrivalDateFrom to set
	 */
	public void setArrivalDateFrom(String arrivalDateFrom)
	{
		this.arrivalDateFrom = arrivalDateFrom;
	}

	/**
	 * @return the arrivalDateTo
	 */
	public String getArrivalDateTo()
	{
		return arrivalDateTo;
	}

	/**
	 * @param arrivalDateTo
	 *            the arrivalDateTo to set
	 */
	public void setArrivalDateTo(String arrivalDateTo)
	{
		this.arrivalDateTo = arrivalDateTo;
	}

	/**
	 * @return the processedDateFrom
	 */
	public String getProcessedDateFrom()
	{
		return processedDateFrom;
	}

	/**
	 * @param processedDateFrom
	 *            the processedDateFrom to set
	 */
	public void setProcessedDateFrom(String processedDateFrom)
	{
		this.processedDateFrom = processedDateFrom;
	}

	/**
	 * @return the processedDateTo
	 */
	public String getProcessedDateTo()
	{
		return processedDateTo;
	}

	/**
	 * @param processedDateTo
	 *            the processedDateTo to set
	 */
	public void setProcessedDateTo(String processedDateTo)
	{
		this.processedDateTo = processedDateTo;
	}

	public String getFileStatus()
	{
		return fileStatus;
	}

	public void setFileStatus(String fileStatus)
	{
		this.fileStatus = fileStatus;
	}

	public String getFileKey()
	{
		return fileKey;
	}

	public void setFileKey(String fileKey)
	{
		this.fileKey = fileKey;
	}

	public HashMap<String, Files> getFiles()
	{
		if (files == null)
			files = new HashMap<String, Files>();
		;
		return files;
	}

	public String getSendBatchFiles()
	{
		return sendBatchFiles;
	}

	public void setSendBatchFiles(String sendBatchFiles)
	{
		this.sendBatchFiles = sendBatchFiles;
	}
}