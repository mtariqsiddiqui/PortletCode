//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//

package com.sadad.ebpp.schema.referencedata._1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.sadad.scm.common._1.BaseType;

/**
 * Activate request
 * 
 * <p>
 * Java class for ActivateAccountTypeRq_Type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivateAccountTypeRq_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}ServiceType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivateAccountTypeRq_Type", propOrder = { "serviceType" })
public class ActivateAccountTypeRqType extends BaseType implements Serializable
{

	private final static long serialVersionUID = 1L;
	@XmlElement(name = "ServiceType", namespace = "http://www.sadad.com/scm/Common/1.0", required = true, defaultValue = "CCRD")
	protected String serviceType;

	/**
	 * Gets the value of the serviceType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getServiceType()
	{
		return serviceType;
	}

	/**
	 * Sets the value of the serviceType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setServiceType(String value)
	{
		this.serviceType = value;
	}

}
