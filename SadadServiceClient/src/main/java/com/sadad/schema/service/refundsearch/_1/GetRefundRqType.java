//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//

package com.sadad.schema.service.refundsearch._1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.sadad.scm.common._1.BaseType;

/**
 * <p>
 * Java class for GetRefundRq_Type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetRefundRq_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}RefundKey"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRefundRq_Type", propOrder = { "refundKey" })
public class GetRefundRqType extends BaseType implements Serializable
{

	private final static long serialVersionUID = 1L;
	@XmlElement(name = "RefundKey", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
	protected String refundKey;

	/**
	 * Gets the value of the refundKey property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRefundKey()
	{
		return refundKey;
	}

	/**
	 * Sets the value of the refundKey property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRefundKey(String value)
	{
		this.refundKey = value;
	}
}