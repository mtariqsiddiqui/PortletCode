//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common.system._1.LanguagePrefSType;


/**
 * -communicates a localized text string the message recipient
 * 
 * <p>Java class for VeryShortMsg_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VeryShortMsg_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Lang" minOccurs="0"/>
 *         &lt;element name="Text" type="{http://www.sadad.com/scm/Common/System/1.0}C32_SType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VeryShortMsg_Type", propOrder = {
    "lang",
    "text"
})
public class VeryShortMsgType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Lang", defaultValue = "en-gb")
    protected LanguagePrefSType lang;
    @XmlElement(name = "Text", required = true)
    protected String text;

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link LanguagePrefSType }
     *     
     */
    public LanguagePrefSType getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguagePrefSType }
     *     
     */
    public void setLang(LanguagePrefSType value) {
        this.lang = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

}
