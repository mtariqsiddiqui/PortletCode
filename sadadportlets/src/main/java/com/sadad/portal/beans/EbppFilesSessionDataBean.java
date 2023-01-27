/**
 * 
 */
package com.sadad.portal.beans;

import java.util.HashMap;

import com.sadad.portal.constant.SadadDynamicDataConfiguration;

/**
 * @author Tariq Siddiqui
 * 
 */
public class EbppFilesSessionDataBean extends SadadAuditEnablingSessionDataBean
{
	private String orgType;
	private String orgId;
	private String rquid;
	private String fileType;
	private String fileName;
	private String arrivalDateFrom;
	private String arrivalDateRange;
	private String processDateFrom;
	private String processDateRange;
	private String fileStatus;

	// associatedFile Key
	private String ascFileKey; 
	private String fileKey;
	private HashMap<String, Files> files;
	
	// File upload and download setting same for all users
	private static String FILE_UPLOAD_URL = SadadDynamicDataConfiguration.FILE_UPLOAD_URL;
	private static String FILE_DOWNLOAD_URL = SadadDynamicDataConfiguration.FILE_DOWNLOAD_URL;
	private static int MAX_FILE_SIZE = SadadDynamicDataConfiguration.MAX_FILE_SIZE;
	private static int MAX_FILES_UPLOAD = SadadDynamicDataConfiguration.MAX_FILES_UPLOAD;

	// To handle the pagination on QueryFies for billers
	private int pageNumber;
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
	 * @return the arrivalDateFrom
	 */
	public String getArrivalDateFrom()
	{
		return arrivalDateFrom;
	}

	/**
	 * @param arrivalDateFrom the arrivalDateFrom to set
	 */
	public void setArrivalDateFrom(String arrivalDateFrom)
	{
		this.arrivalDateFrom = arrivalDateFrom;
	}

	/**
	 * @return the arrivalDateRange
	 */
	public String getArrivalDateRange()
	{
		return arrivalDateRange;
	}

	/**
	 * @param arrivalDateRange the arrivalDateRange to set
	 */
	public void setArrivalDateRange(String arrivalDateRange)
	{
		this.arrivalDateRange = arrivalDateRange;
	}

	/**
	 * @return the processDateFrom
	 */
	public String getProcessDateFrom()
	{
		return processDateFrom;
	}

	/**
	 * @param processDateFrom the processDateFrom to set
	 */
	public void setProcessDateFrom(String processDateFrom)
	{
		this.processDateFrom = processDateFrom;
	}

	/**
	 * @return the processDateRange
	 */
	public String getProcessDateRange()
	{
		return processDateRange;
	}

	/**
	 * @param processDateRange the processDateRange to set
	 */
	public void setProcessDateRange(String processDateRange)
	{
		this.processDateRange = processDateRange;
	}

	/**
	 * @return the fileStatus
	 */
	public String getFileStatus()
	{
		return fileStatus;
	}

	/**
	 * @param fileStatus
	 *            the fileStatus to set
	 */
	public void setFileStatus(String fileStatus)
	{
		this.fileStatus = fileStatus;
	}
	
	/**
	 * @return the ascFileKey
	 */
	public String getAscFileKey()
	{
		return ascFileKey;
	}

	/**
	 * @param ascFileKey the ascFileKey to set
	 */
	public void setAscFileKey(String ascFileKey)
	{
		this.ascFileKey = ascFileKey;
	}

	/**
	 * @return the fileKey
	 */
	public String getFileKey()
	{
		return fileKey;
	}

	/**
	 * @param fileKey the fileKey to set
	 */
	public void setFileKey(String fileKey)
	{
		this.fileKey = fileKey;
	}

	/**
	 * @return the files
	 */
	public HashMap<String, Files> getFiles()
	{
		if (files == null)
			files = new HashMap<String, Files>();
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(HashMap<String, Files> files)
	{
		this.files = files;
	}

	/**
	 * @return the fILE_UPLOAD_URL
	 */
	public String getFILE_UPLOAD_URL()
	{
		return FILE_UPLOAD_URL;
	}

	/**
	 * @return the fILE_DOWNLOAD_URL
	 */
	public String getFILE_DOWNLOAD_URL()
	{
		return FILE_DOWNLOAD_URL;		
	}

	/**
	 * @return the MAX_FILE_SIZE
	 */
	public int getMAX_FILE_SIZE()
	{
		return MAX_FILE_SIZE;
	}
	
	/**
	 * @return the MAX_FILES_UPLOAD
	 */
	public int getMAX_FILES_UPLOAD()
	{
		return MAX_FILES_UPLOAD;
	}

	/**
	 * @return the pageNumber
	 */
	public int getPageNumber()
	{
		return pageNumber;
	}

	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(int pageNumber)
	{
		this.pageNumber = pageNumber;
	}
}