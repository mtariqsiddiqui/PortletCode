/**
 * 
 */
package com.sadad.portal.beans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.constant.SadadDynamicDataConfiguration;

/**
 * @author Tariq Siddiqui
 * 
 */
public class Files
{
	private String fileName;
	private String filePath;
	private String rquid;
	private String uuid;
	private String cid;
	private String partnerKey;
	private String fileType;
	private Long fileSize;
	private Long recordCount;
	private String status;
	private Long successCount;
	private Long failureCount;
	private String fileCreationDate;
	private String fileProcessingDate;
	private Map<String, Files> associatedFiles;
	private String fileToken;
	private String fileDownloadUrl;

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
	 * @return the filePath
	 */
	public String getFilePath()
	{
		return filePath;
	}

	/**
	 * @param filePath
	 *            the filePath to set
	 */
	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
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
	 * @return the uuid
	 */
	public String getUuid()
	{
		return uuid;
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	/**
	 * @return the cid
	 */
	public String getCid()
	{
		return cid;
	}

	/**
	 * @param cid
	 *            the cid to set
	 */
	public void setCid(String cid)
	{
		this.cid = cid;
	}

	/**
	 * @return the partnerKey
	 */
	public String getPartnerKey()
	{
		return partnerKey;
	}

	/**
	 * @param partnerKey
	 *            the partnerKey to set
	 */
	public void setPartnerKey(String partnerKey)
	{
		this.partnerKey = partnerKey;
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
	 * @return the fileSize
	 */
	public Long getFileSize()
	{
		return fileSize;
	}

	/**
	 * @param fileSize
	 *            the fileSize to set
	 */
	public void setFileSize(Long fileSize)
	{
		this.fileSize = fileSize;
	}

	/**
	 * @return the recordCount
	 */
	public Long getRecordCount()
	{
		return recordCount;
	}

	/**
	 * @param recordCount
	 *            the recordCount to set
	 */
	public void setRecordCount(Long recordCount)
	{
		this.recordCount = recordCount;
	}

	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * @return the successCount
	 */
	public Long getSuccessCount()
	{
		return successCount;
	}

	/**
	 * @param successCount
	 *            the successCount to set
	 */
	public void setSuccessCount(Long successCount)
	{
		this.successCount = successCount;
	}

	/**
	 * @return the failureCount
	 */
	public Long getFailureCount()
	{
		return failureCount;
	}

	/**
	 * @param failureCount
	 *            the failureCount to set
	 */
	public void setFailureCount(Long failureCount)
	{
		this.failureCount = failureCount;
	}

	/**
	 * @return the fileProcessingDate
	 */
	public String getFileProcessingDate()
	{
		return fileProcessingDate;
	}

	/**
	 * @param fileProcessingDate
	 *            the fileProcessingDate to set
	 */
	public void setFileProcessingDate(String filePorcessingDate)
	{
		this.fileProcessingDate = filePorcessingDate;
	}

	/**
	 * @return the fileCreationDate
	 */
	public String getFileCreationDate()
	{
		return fileCreationDate;
	}

	/**
	 * @param fileCreationDate
	 *            the fileCreationDate to set
	 */
	public void setFileCreationDate(String fileCreationDate)
	{
		this.fileCreationDate = fileCreationDate;
	}

	/**
	 * @return the associatedFiles
	 */
	public Map<String, Files> getAssociatedFiles()
	{
		if (associatedFiles == null)
			associatedFiles = new HashMap<>();
		return associatedFiles;
	}

	/**
	 * @param associatedFiles
	 *            the associatedFiles to set
	 */
	public void setAssociatedFiles(Map<String, Files> associatedFiles)
	{
		this.associatedFiles = associatedFiles;
	}
	
	public String getFileToken()
	{
		return fileToken;
	}
	
	public void setFileToken(EbppFilesSessionDataBean so)
	{
		StringBuilder fileTokenBuilder = new StringBuilder("?fileToken=");
		this.fileToken = fileTokenBuilder.toString(); 
		try
		{
			// SALT + LTPA Token + File Path
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(PortalConstant.FILE_TOKEN_MIXIN_SALT.getBytes()); // Get the File token mixin Salt value
			md.update(so.ltpaTokenValue.getBytes()); // Get the LTPA Token of the logged-in user
			md.update(SadadDynamicDataConfiguration.FILE_DOWNLOAD_URL.getBytes()); // Get the file download prefix URL
			md.update(this.filePath.getBytes()); // Get the file Path
			md.update("/".getBytes()); // Add the backslash before the file name
			md.update(this.fileName.getBytes()); // Get the file Name
			fileTokenBuilder.append(Base64.getEncoder().encodeToString(md.digest()));
			this.fileToken = fileTokenBuilder.toString();
		}
		catch (NoSuchAlgorithmException | NullPointerException e)
		{}
	}
	
	public String getFileDownloadUrl()
	{
		StringBuilder fdu = new StringBuilder(SadadDynamicDataConfiguration.FILE_DOWNLOAD_URL);
		fdu.append(this.filePath).append('/').append(this.fileName).append(this.fileToken);
		fileDownloadUrl = fdu.toString(); 
		return fileDownloadUrl;
	}
}