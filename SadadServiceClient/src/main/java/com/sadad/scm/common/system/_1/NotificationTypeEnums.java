//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common.system._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NotificationType_Enums.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NotificationType_Enums">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EMAIL"/>
 *     &lt;enumeration value="TESTMESSAGE"/>
 *     &lt;enumeration value="FAX"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NotificationType_Enums", namespace = "http://www.sadad.com/scm/Common/System/1.0")
@XmlEnum
public enum NotificationTypeEnums {

    EMAIL,
    TESTMESSAGE,
    FAX;

    public String value() {
        return name();
    }

    public static NotificationTypeEnums fromValue(String v) {
        return valueOf(v);
    }

}