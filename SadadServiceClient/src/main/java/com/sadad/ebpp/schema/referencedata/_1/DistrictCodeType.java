//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//

package com.sadad.ebpp.schema.referencedata._1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.sadad.scm.common._1.ConfigurationStatusEnum;

/**
 * <p>
 * Java class for DistrictCode_Type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistrictCode_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}DistrictCode"/>
 *         &lt;element name="Description" type="{http://www.sadad.com/scm/Common/System/1.0}C128_SType"/>
 *         &lt;element name="Status" type="{http://www.sadad.com/scm/Common/1.0}ConfigurationStatus_Enum"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistrictCode_Type", propOrder = { "districtCode", "description", "status" })
public class DistrictCodeType implements Serializable
{

	private final static long serialVersionUID = 1L;
	@XmlElement(name = "DistrictCode", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
	protected String districtCode;
	@XmlElement(name = "Description", required = true)
	protected String description;
	@XmlElement(name = "Status", required = true)
	protected ConfigurationStatusEnum status;

	/**
	 * Gets the value of the districtCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDistrictCode()
	{
		return districtCode;
	}

	/**
	 * Sets the value of the districtCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDistrictCode(String value)
	{
		this.districtCode = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value)
	{
		this.description = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link ConfigurationStatusEnum }
	 * 
	 */
	public ConfigurationStatusEnum getStatus()
	{
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value
	 *            allowed object is {@link ConfigurationStatusEnum }
	 * 
	 */
	public void setStatus(ConfigurationStatusEnum value)
	{
		this.status = value;
	}

}
