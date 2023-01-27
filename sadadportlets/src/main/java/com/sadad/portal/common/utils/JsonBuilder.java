package com.sadad.portal.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Tariq Siddiqui
 *
 */
public class JsonBuilder // FIXME -- Not able to download Maven Jar for javax.json provider due to Security Restriction
{
	static char comma = ',';
	static char quote = '\"';
	static char ob = '{';
	static char cb = '}';
	static char ol = '[';
	static char cl = ']';
	static char sp = ':';

	public static String toJson(Object o)
	{
		StringBuilder jb = new StringBuilder();
		jb.append(ob);

		Class<?> clas = o.getClass();

		// FIXME - Either download javax.json Implementation or GSON or add the below 2 scenarios.
		// if(java.util.List.class.isAssignableFrom(clas))
		// {
		// List<?> list = new ArrayList<>();
		// list = (List<?>) f.get(o);
		// jb.append(convertCollectionToJsonString(list));
		// }
		// else if(java.util.Map.class.isAssignableFrom(clas))
		// {
		// Map<?,?> map = new HashMap<>();
		// map = (Map<?, ?>) f.get(o);
		// jb.append(convertMapToJsonString(map));
		// }
		try
		{
			Field[] fields = clas.getDeclaredFields();

			for (Field f : fields)
			{
				try
				{
					jb.append(quote);
					jb.append(f.getName());
					jb.append(quote);
					jb.append(sp);

					f.setAccessible(true);

					if (f.getType() == String.class)
						jb.append(quote).append(f.get(o)).append(quote);
					else if (f.getType() == boolean.class)
						jb.append(f.getBoolean(o));
					else if (f.getType() == int.class)
						jb.append(f.getInt(o));
					else if (f.getType() == long.class)
						jb.append(f.getLong(o));
					else if (f.getType() == float.class)
						jb.append(f.getFloat(o));
					else if (f.getType() == double.class)
						jb.append(f.getDouble(o));
					else if (f.getType() == byte.class)
						jb.append(f.getByte(o));
					else if (f.getType() == char.class)
						jb.append(f.getChar(o));
					else if (f.getType() == short.class)
						jb.append(f.getShort(o));
					else if (f.getType().isArray())
						jb.append(convertArrayToJson(f.get(o), f.getType().getComponentType()));
					else
					{
						Type type = f.getGenericType();
						if (type instanceof ParameterizedType)
						{
							ParameterizedType pType = (ParameterizedType) type;

							if (java.util.List.class.isAssignableFrom(Class.forName(pType.getRawType().getTypeName())))
							{
								List<?> list = new ArrayList<>();
								list = (List<?>) f.get(o);
								if (list == null || list.size() == 0)
									jb.append("null");
								else
									jb.append(convertCollectionToJsonString(list));
							}
							else if (java.util.Map.class.isAssignableFrom(Class.forName(pType.getRawType().getTypeName())))
							{
								Map<?, ?> map = new HashMap<>();
								map = (Map<?, ?>) f.get(o);
								if (map == null || map.size() == 0)
									jb.append("null");
								else
									jb.append(convertMapToJsonString(map));
							}
						}
						else
							jb.append(toJson(f.get(o)));
					}
				}
				catch (NullPointerException e)
				{
					jb.append("null");
				}
				jb.append(comma);
			}
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
			clas = clas.getSuperclass();
		}
		catch (IllegalAccessException e)
		{
			System.err.println(e.getMessage());
			clas = clas.getSuperclass();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		if (jb.lastIndexOf(",") == jb.length() - 1)
			jb.deleteCharAt(jb.lastIndexOf(","));

		jb.append(cb);
		return jb.toString().replaceAll("\"null\"", "null").replaceAll("[\\r\\n\\t]+", "").replaceAll("\\\\", "\\\\\\\\");
	}

	private static String convertCollectionToJsonString(List<?> list)
	{
		StringBuilder jb = new StringBuilder();
		jb.append(ol);

		for (Object item : list)
			jb.append(extractSingleValue(item)).append(comma);

		if (jb.lastIndexOf(",") == jb.length() - 1)
			jb.deleteCharAt(jb.lastIndexOf(","));

		jb.append(cl);
		return jb.toString();
	}

	private static String convertArrayToJson(Object oa, Class<?> arCls)
	{
		StringBuilder jb = new StringBuilder();
		jb.append(ol);

		if (arCls == Integer.TYPE)
		{
			int[] ar = (int[]) oa;
			for (int index = 0; index < ar.length; index++)
				jb.append(extractSingleValue(ar[index])).append(comma);
		}
		else if (arCls == Boolean.TYPE)
		{
			boolean[] ar = (boolean[]) oa;
			for (int index = 0; index < ar.length; index++)
				jb.append(extractSingleValue(ar[index])).append(comma);
		}
		else if (arCls == Float.TYPE)
		{
			float[] ar = (float[]) oa;
			for (int index = 0; index < ar.length; index++)
				jb.append(extractSingleValue(ar[index])).append(comma);
		}
		else if (arCls == Character.TYPE)
		{
			char[] ar = (char[]) oa;
			for (int index = 0; index < ar.length; index++)
				jb.append(extractSingleValue(ar[index])).append(comma);
		}
		else if (arCls == Double.TYPE)
		{
			char[] ar = (char[]) oa;
			for (int index = 0; index < ar.length; index++)
				jb.append(extractSingleValue(ar[index])).append(comma);
		}
		else if (arCls == Long.TYPE)
		{
			long[] ar = (long[]) oa;
			for (int index = 0; index < ar.length; index++)
				jb.append(extractSingleValue(ar[index])).append(comma);
		}
		else if (arCls == Short.TYPE)
		{
			short[] ar = (short[]) oa;
			for (int index = 0; index < ar.length; index++)
				jb.append(extractSingleValue(ar[index])).append(comma);
		}
		else if (arCls == Byte.TYPE)
		{
			byte[] ar = (byte[]) oa;
			for (int index = 0; index < ar.length; index++)
				jb.append(extractSingleValue(ar[index])).append(comma);
		}
		else
		{
			Object[] ar = (Object[]) oa;
			for (int index = 0; index < ar.length; index++)
				jb.append(extractSingleValue(ar[index])).append(comma);
		}

		if (jb.lastIndexOf(",") == jb.length() - 1)
			jb.deleteCharAt(jb.lastIndexOf(","));

		jb.append(cl);
		return jb.toString();
	}

	private static String convertMapToJsonString(Map<?, ?> map)
	{
		StringBuilder jb = new StringBuilder();
		jb.append(ob);
		for (Entry<?, ?> entry : map.entrySet())
			jb.append(convertSingleKey(entry.getKey())).append(toJson(entry.getValue())).append(comma);

		if (jb.lastIndexOf(",") == jb.length() - 1)
			jb.deleteCharAt(jb.lastIndexOf(","));

		jb.append(cb);
		return jb.toString();
	}

	private static String extractSingleValue(Object o)
	{
		StringBuilder jb = new StringBuilder();
		if (o.getClass() == String.class)
			jb.append(quote).append(o).append(quote);
		else if (o.getClass() == int.class || o.getClass() == Integer.class || o.getClass() == long.class || o.getClass() == Long.class || o.getClass() == float.class || o.getClass() == Float.class || o.getClass() == double.class
				|| o.getClass() == Double.class || o.getClass() == byte.class || o.getClass() == Byte.class || o.getClass() == char.class || o.getClass() == Character.class || o.getClass() == short.class || o.getClass() == Short.class)
			jb.append(o);
		else
			jb.append(toJson(o));

		return jb.toString();
	}

	private static String convertSingleKey(Object o)
	{
		StringBuilder jb = new StringBuilder();
		jb.append(quote).append(o).append(quote);
		jb.append(sp);
		return jb.toString();
	}
}