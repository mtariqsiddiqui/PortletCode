//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//

package com.sadad.schema.service.refundsearch._1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.sadad.scm.common._1.BaseType;

/**
 * <p>
 * Java class for ListRefundRs_Type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListRefundRs_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element name="Refunds" type="{http://sadad.com/schema/service/RefundSearch/1.0}Refunds_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListRefundRs_Type", propOrder = { "refunds" })
public class ListRefundRsType extends BaseType implements Serializable
{

	private final static long serialVersionUID = 1L;
	@XmlElement(name = "Refunds")
	protected List<RefundsType> refunds;

	/**
	 * Gets the value of the refunds property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
	 * refunds property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRefunds().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link RefundsType }
	 * 
	 * 
	 */
	public List<RefundsType> getRefunds()
	{
		if (refunds == null)
		{
			refunds = new ArrayList<RefundsType>();
		}
		return this.refunds;
	}

}
