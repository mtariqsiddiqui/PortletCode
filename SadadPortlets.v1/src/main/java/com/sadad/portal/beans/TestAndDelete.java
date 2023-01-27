package com.sadad.portal.beans;

import java.lang.reflect.Field;

public class TestAndDelete
{
	public static void main(String[] args)
	{
		String p = "param_billerId";
		if (p.startsWith("param_"))
			p = p.substring("param_".length());
		CoreEbppSessionBean csb = new CoreEbppSessionBean();
		try
		{
			Field fld = csb.getClass().getDeclaredField(p);
			if(!fld.isAccessible())
				fld.setAccessible(!fld.isAccessible());
			
			fld.set(csb, "001");
			
			System.out.println(fld.get(csb));
			
//			Field[] fields = CoreEbppSessionBean.class.getDeclaredFields();
//			for (Field f : fields)
//			{
//				System.out.println(f);
//			}
//			
////			Method[] methods = CoreEbppSessionBean.class.getMethods();
////			for (Method m : methods)
////			{
////				System.out.println(m);
////			}
//
//			System.out.println();System.out.println();
		}
		catch (Exception e)
		{}
		System.out.println("Terminated.");
	}
}