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
 * Java class for GetRefundRs_Type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetRefundRs_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element name="Refund" type="{http://sadad.com/schema/service/RefundSearch/1.0}Refund_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRefundRs_Type", propOrder = { "refund" })
public class GetRefundRsType extends BaseType implements Serializable
{

	private final static long serialVersionUID = 1L;
	@XmlElement(name = "Refund")
	protected RefundType refund;

	/**
	 * Gets the value of the refund property.
	 * 
	 * @return possible object is {@link RefundType }
	 * 
	 */
	public RefundType getRefund()
	{
		return refund;
	}

	/**
	 * Sets the value of the refund property.
	 * 
	 * @param value
	 *            allowed object is {@link RefundType }
	 * 
	 */
	public void setRefund(RefundType value)
	{
		this.refund = value;
	}

}
