//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeLimit_Enum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TimeLimit_Enum">
 *   &lt;restriction base="{http://www.sadad.com/scm/Common/System/1.0}NC16_SType">
 *     &lt;enumeration value="TILL_NEXT_DAY"/>
 *     &lt;enumeration value="TILL_RECON"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TimeLimit_Enum")
@XmlEnum
public enum TimeLimitEnum {

    TILL_NEXT_DAY,
    TILL_RECON;

    public String value() {
        return name();
    }

    public static TimeLimitEnum fromValue(String v) {
        return valueOf(v);
    }

}