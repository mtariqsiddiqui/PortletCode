//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentMethod_Enum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentMethod_Enum">
 *   &lt;restriction base="{http://www.sadad.com/scm/Common/System/1.0}NC32_SType">
 *     &lt;enumeration value="CASH"/>
 *     &lt;enumeration value="CCARD"/>
 *     &lt;enumeration value="EFT"/>
 *     &lt;enumeration value="ACTDEB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentMethod_Enum")
@XmlEnum
public enum PaymentMethodEnum {

    CASH,
    CCARD,
    EFT,
    ACTDEB;

    public String value() {
        return name();
    }

    public static PaymentMethodEnum fromValue(String v) {
        return valueOf(v);
    }

}