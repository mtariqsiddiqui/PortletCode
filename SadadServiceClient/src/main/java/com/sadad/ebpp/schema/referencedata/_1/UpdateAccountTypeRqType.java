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
 * Update request
 * 
 * <p>
 * Java class for UpdateAccountTypeRq_Type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateAccountTypeRq_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/EBPP/schema/ReferenceData/1.0}AccountType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateAccountTypeRq_Type", propOrder = { "accountType" })
public class UpdateAccountTypeRqType extends BaseType implements Serializable
{

	private final static long serialVersionUID = 1L;
	@XmlElement(name = "AccountType", required = true)
	protected AccountTypeType accountType;

	/**
	 * Gets the value of the accountType property.
	 * 
	 * @return possible object is {@link AccountTypeType }
	 * 
	 */
	public AccountTypeType getAccountType()
	{
		return accountType;
	}

	/**
	 * Sets the value of the accountType property.
	 * 
	 * @param value
	 *            allowed object is {@link AccountTypeType }
	 * 
	 */
	public void setAccountType(AccountTypeType value)
	{
		this.accountType = value;
	}

}
