//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for File_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="File_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}FileName"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}FilePath" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}RqUID"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}UUID" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}CorrelationId" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}PartnerKey"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}MsgCode"/>
 *         &lt;element name="FileSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="RecordCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileCreationDate" type="{http://www.sadad.com/scm/Common/System/1.0}Date_SType" minOccurs="0"/>
 *         &lt;element name="FileProcessDate" type="{http://www.sadad.com/scm/Common/System/1.0}Date_SType" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.sadad.com/scm/Common/1.0}FileLifecycle_Enums" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "File_Type", propOrder = {
    "fileName",
    "filePath",
    "rqUID",
    "uuid",
    "correlationId",
    "partnerKey",
    "msgCode",
    "fileSize",
    "recordCount",
    "fileCreationDate",
    "fileProcessDate",
    "status"
})
public class FileType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "FileName", required = true)
    protected String fileName;
    @XmlElement(name = "FilePath")
    protected String filePath;
    @XmlElement(name = "RqUID", required = true)
    protected String rqUID;
    @XmlElement(name = "UUID")
    protected String uuid;
    @XmlElement(name = "CorrelationId")
    protected String correlationId;
    @XmlElement(name = "PartnerKey", required = true)
    protected String partnerKey;
    @XmlElement(name = "MsgCode", required = true)
    protected String msgCode;
    @XmlElement(name = "FileSize")
    protected Long fileSize;
    @XmlElement(name = "RecordCount")
    protected Long recordCount;
    @XmlElement(name = "FileCreationDate")
    protected XMLGregorianCalendar fileCreationDate;
    @XmlElement(name = "FileProcessDate")
    protected XMLGregorianCalendar fileProcessDate;
    @XmlElement(name = "Status")
    protected FileLifecycleEnums status;

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the filePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the value of the filePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilePath(String value) {
        this.filePath = value;
    }

    /**
     * Gets the value of the rqUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRqUID() {
        return rqUID;
    }

    /**
     * Sets the value of the rqUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRqUID(String value) {
        this.rqUID = value;
    }

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUUID(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the correlationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Sets the value of the correlationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

    /**
     * Gets the value of the partnerKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerKey() {
        return partnerKey;
    }

    /**
     * Sets the value of the partnerKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerKey(String value) {
        this.partnerKey = value;
    }

    /**
     * Gets the value of the msgCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgCode() {
        return msgCode;
    }

    /**
     * Sets the value of the msgCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgCode(String value) {
        this.msgCode = value;
    }

    /**
     * Gets the value of the fileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * Sets the value of the fileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileSize(Long value) {
        this.fileSize = value;
    }

    /**
     * Gets the value of the recordCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRecordCount() {
        return recordCount;
    }

    /**
     * Sets the value of the recordCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRecordCount(Long value) {
        this.recordCount = value;
    }

    /**
     * Gets the value of the fileCreationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFileCreationDate() {
        return fileCreationDate;
    }

    /**
     * Sets the value of the fileCreationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFileCreationDate(XMLGregorianCalendar value) {
        this.fileCreationDate = value;
    }

    /**
     * Gets the value of the fileProcessDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFileProcessDate() {
        return fileProcessDate;
    }

    /**
     * Sets the value of the fileProcessDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFileProcessDate(XMLGregorianCalendar value) {
        this.fileProcessDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link FileLifecycleEnums }
     *     
     */
    public FileLifecycleEnums getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileLifecycleEnums }
     *     
     */
    public void setStatus(FileLifecycleEnums value) {
        this.status = value;
    }

}