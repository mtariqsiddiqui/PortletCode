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
 * To hold additional properties for a Configuration Templates
 * 
 * <p>Java class for ConfigurationTemplateData_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigurationTemplateData_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}IdentifierName"/>
 *         &lt;element name="Identifiers" type="{http://www.sadad.com/scm/Common/System/1.0}NC20_SType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Templates" type="{http://www.sadad.com/scm/Common/1.0}ConfigurationTemplate_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigurationTemplateData_Type", propOrder = {
    "identifierName",
    "identifiers",
    "templates"
})
public class ConfigurationTemplateDataType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "IdentifierName", required = true)
    protected String identifierName;
    @XmlElement(name = "Identifiers")
    protected List<String> identifiers;
    @XmlElement(name = "Templates")
    protected List<ConfigurationTemplateType> templates;

    /**
     * Gets the value of the identifierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifierName() {
        return identifierName;
    }

    /**
     * Sets the value of the identifierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifierName(String value) {
        this.identifierName = value;
    }

    /**
     * Gets the value of the identifiers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identifiers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentifiers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIdentifiers() {
        if (identifiers == null) {
            identifiers = new ArrayList<String>();
        }
        return this.identifiers;
    }

    /**
     * Gets the value of the templates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the templates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemplates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConfigurationTemplateType }
     * 
     * 
     */
    public List<ConfigurationTemplateType> getTemplates() {
        if (templates == null) {
            templates = new ArrayList<ConfigurationTemplateType>();
        }
        return this.templates;
    }

}
