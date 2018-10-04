//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BillerPaymentStatus_Enums.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BillerPaymentStatus_Enums">
 *   &lt;restriction base="{http://www.sadad.com/scm/Common/System/1.0}NC32_SType">
 *     &lt;enumeration value="PAYMENT_NEW"/>
 *     &lt;enumeration value="PAYMENT_UPDATED"/>
 *     &lt;enumeration value="PAYMENT_ANY"/>
 *     &lt;enumeration value="PAYMENT_DUPLICATE"/>
 *     &lt;enumeration value="PAYMENT_REVERSAL"/>
 *     &lt;enumeration value="PAYMENT_TRANSFERED"/>
 *     &lt;enumeration value="PAYMENT_NOT_TRANSFERED"/>
 *     &lt;enumeration value="PAYMENT_NOT_ADVICED"/>
 *     &lt;enumeration value="PAYMENT_Recon"/>
 *     &lt;enumeration value="PAYMENT_ALREADY_RECONCONCILED"/>
 *     &lt;enumeration value="PAYMENT_NOT_RECONCONCILED"/>
 *     &lt;enumeration value="PAYMENT_NOT_IN_BANK"/>
 *     &lt;enumeration value="PAYMENT_NOT_IN_SADAD"/>
 *     &lt;enumeration value="PAYMENT_MISMATCH"/>
 *     &lt;enumeration value="PAYMENT_COMPLETED"/>
 *     &lt;enumeration value="PAYMENT_NOT_COMPLETED"/>
 *     &lt;enumeration value="PAYMENT_BILLER_MISMATCH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BillerPaymentStatus_Enums")
@XmlEnum
public enum BillerPaymentStatusEnums {

    PAYMENT_NEW("PAYMENT_NEW"),
    PAYMENT_UPDATED("PAYMENT_UPDATED"),
    PAYMENT_ANY("PAYMENT_ANY"),
    PAYMENT_DUPLICATE("PAYMENT_DUPLICATE"),
    PAYMENT_REVERSAL("PAYMENT_REVERSAL"),
    PAYMENT_TRANSFERED("PAYMENT_TRANSFERED"),
    PAYMENT_NOT_TRANSFERED("PAYMENT_NOT_TRANSFERED"),
    PAYMENT_NOT_ADVICED("PAYMENT_NOT_ADVICED"),
    @XmlEnumValue("PAYMENT_Recon")
    PAYMENT_RECON("PAYMENT_Recon"),
    PAYMENT_ALREADY_RECONCONCILED("PAYMENT_ALREADY_RECONCONCILED"),
    PAYMENT_NOT_RECONCONCILED("PAYMENT_NOT_RECONCONCILED"),
    PAYMENT_NOT_IN_BANK("PAYMENT_NOT_IN_BANK"),
    PAYMENT_NOT_IN_SADAD("PAYMENT_NOT_IN_SADAD"),
    PAYMENT_MISMATCH("PAYMENT_MISMATCH"),
    PAYMENT_COMPLETED("PAYMENT_COMPLETED"),
    PAYMENT_NOT_COMPLETED("PAYMENT_NOT_COMPLETED"),
    PAYMENT_BILLER_MISMATCH("PAYMENT_BILLER_MISMATCH");
    private final String value;

    BillerPaymentStatusEnums(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BillerPaymentStatusEnums fromValue(String v) {
        for (BillerPaymentStatusEnums c: BillerPaymentStatusEnums.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}