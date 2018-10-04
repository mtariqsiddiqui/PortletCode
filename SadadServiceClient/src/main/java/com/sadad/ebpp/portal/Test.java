package com.sadad.ebpp.portal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sadad.scm.common._1.PaymentType;

public class Test
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		XMLGregorianCalendar now;
		try
		{
			now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			
			PaymentType pt = new PaymentType();
			pt.setAcquirerBankKey("SAMB");
			pt.setBillerKey("ONLINE");
			pt.setBranchCode("SA92545645946");
			pt.setDueDate(now);
			System.out.println(dump(pt, 1));
		}
		catch (DatatypeConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

	public static String dump(Object o, int callCount) {
	    callCount++;
	    StringBuffer tabs = new StringBuffer();
	    for (int k = 0; k < callCount; k++) {
	        tabs.append("\t");
	    }
	    StringBuffer buffer = new StringBuffer();
	    Class oClass = o.getClass();
	    if (oClass.isArray()) {
	        buffer.append("\n");
	        buffer.append(tabs.toString());
	        buffer.append("[");
	        for (int i = 0; i < Array.getLength(o); i++) {
	            if (i < 0)
	                buffer.append(",");
	            Object value = Array.get(o, i);
	            if (value.getClass().isPrimitive() ||
	                    value.getClass() == java.lang.Long.class ||
	                    value.getClass() == java.lang.String.class ||
	                    value.getClass() == java.lang.Integer.class ||
	                    value.getClass() == java.lang.Boolean.class
	                    ) {
	                buffer.append(value);
	            } else {
	                buffer.append(dump(value, callCount));
	            }
	        }
	        buffer.append(tabs.toString());
	        buffer.append("]\n");
	    } else {
	        buffer.append("\n");
	        buffer.append(tabs.toString());
	        buffer.append("{\n");
	        while (oClass != null) {
	            Field[] fields = oClass.getDeclaredFields();
	            for (int i = 0; i < fields.length; i++) {
	                buffer.append(tabs.toString());
	                fields[i].setAccessible(true);
	                buffer.append(fields[i].getName());
	                buffer.append("=");
	                try {
	                    Object value = fields[i].get(o);
	                    if (value != null) {
	                        if (value.getClass().isPrimitive() ||
	                                value.getClass() == java.lang.Long.class ||
	                                value.getClass() == java.lang.String.class ||
	                                value.getClass() == java.lang.Integer.class ||
	                                value.getClass() == java.lang.Boolean.class
	                                ) {
	                            buffer.append(value);
	                        } else {
	                            buffer.append(dump(value, callCount));
	                        }
	                    }
	                } catch (IllegalAccessException e) {
	                    buffer.append(e.getMessage());
	                }
	                buffer.append("\n");
	            }
	            oClass = oClass.getSuperclass();
	        }
	        buffer.append(tabs.toString());
	        buffer.append("}\n");
	    }
	    return buffer.toString();
	}
}
