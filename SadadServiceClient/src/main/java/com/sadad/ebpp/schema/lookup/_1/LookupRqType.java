//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.ebpp.schema.lookup._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common._1.BaseType;


/**
 * Lookup request
 * 
 * <p>Java class for LookupRq_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LookupRq_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element name="LookupType" type="{http://www.sadad.com/EBPP/schema/Lookup/1.0}LookupType_Enums"/>
 *         &lt;element name="LookupKey" type="{http://www.sadad.com/scm/Common/System/1.0}C32_SType" minOccurs="0"/>
 *         &lt;element name="LookupCriterias" type="{http://www.sadad.com/EBPP/schema/Lookup/1.0}LookupCriterias_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LookupRq_Type", propOrder = {
    "lookupType",
    "lookupKey",
    "lookupCriterias"
})
public class LookupRqType
    extends BaseType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "LookupType", required = true)
    protected LookupTypeEnums lookupType;
    @XmlElement(name = "LookupKey")
    protected String lookupKey;
    @XmlElement(name = "LookupCriterias")
    protected LookupCriteriasType lookupCriterias;

    /**
     * Gets the value of the lookupType property.
     * 
     * @return
     *     possible object is
     *     {@link LookupTypeEnums }
     *     
     */
    public LookupTypeEnums getLookupType() {
        return lookupType;
    }

    /**
     * Sets the value of the lookupType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LookupTypeEnums }
     *     
     */
    public void setLookupType(LookupTypeEnums value) {
        this.lookupType = value;
    }

    /**
     * Gets the value of the lookupKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLookupKey() {
        return lookupKey;
    }

    /**
     * Sets the value of the lookupKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLookupKey(String value) {
        this.lookupKey = value;
    }

    /**
     * Gets the value of the lookupCriterias property.
     * 
     * @return
     *     possible object is
     *     {@link LookupCriteriasType }
     *     
     */
    public LookupCriteriasType getLookupCriterias() {
        return lookupCriterias;
    }

    /**
     * Sets the value of the lookupCriterias property.
     * 
     * @param value
     *     allowed object is
     *     {@link LookupCriteriasType }
     *     
     */
    public void setLookupCriterias(LookupCriteriasType value) {
        this.lookupCriterias = value;
    }

}