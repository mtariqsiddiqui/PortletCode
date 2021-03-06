//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Lookup data
 * 
 * <p>Java class for LookupData_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LookupData_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LookupKey" type="{http://www.sadad.com/scm/Common/System/1.0}C32_SType"/>
 *         &lt;element name="Status" type="{http://www.sadad.com/scm/Common/1.0}ConfigurationStatus_Enum"/>
 *         &lt;element name="Property" type="{http://www.sadad.com/scm/Common/1.0}Property_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LookupData_Type", propOrder = {
    "lookupKey",
    "status",
    "property"
})
public class LookupDataType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "LookupKey", required = true)
    protected String lookupKey;
    @XmlElement(name = "Status", required = true)
    protected ConfigurationStatusEnum status;
    @XmlElement(name = "Property")
    protected List<PropertyType> property;

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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigurationStatusEnum }
     *     
     */
    public ConfigurationStatusEnum getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigurationStatusEnum }
     *     
     */
    public void setStatus(ConfigurationStatusEnum value) {
        this.status = value;
    }

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyType }
     * 
     * 
     */
    public List<PropertyType> getProperty() {
        if (property == null) {
            property = new ArrayList<PropertyType>();
        }
        return this.property;
    }

}
