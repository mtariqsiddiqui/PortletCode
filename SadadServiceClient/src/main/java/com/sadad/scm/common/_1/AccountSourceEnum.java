//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountSource_Enum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccountSource_Enum">
 *   &lt;restriction base="{http://www.sadad.com/scm/Common/System/1.0}NC8_SType">
 *     &lt;enumeration value="AUPLRQ"/>
 *     &lt;enumeration value="BUPLRQ"/>
 *     &lt;enumeration value="BLODRQ"/>
 *     &lt;enumeration value="PVALRQ"/>
 *     &lt;enumeration value="PORTAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccountSource_Enum")
@XmlEnum
public enum AccountSourceEnum {

    AUPLRQ,
    BUPLRQ,
    BLODRQ,
    PVALRQ,
    PORTAL;

    public String value() {
        return name();
    }

    public static AccountSourceEnum fromValue(String v) {
        return valueOf(v);
    }

}
