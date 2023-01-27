package com.sadad.portal.common.cache;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import com.sadad.portal.constant.PortalConstant;

public class PortalConstantMap extends HashMap<String, String>
{
	private static final long serialVersionUID = 6405976705135216792L;

	public PortalConstantMap()
	{
		Class<PortalConstant> c = PortalConstant.class;
		Field[] fields = c.getDeclaredFields();
		for (Field f : fields)
		{
			int m = f.getModifiers();
			if (Modifier.isPublic(m) && Modifier.isStatic(m) && Modifier.isFinal(m))
			{
				try
				{
					Object o = f.get(null);
					put(f.getName(), o != null ? o.toString() : null);
				}
				catch (IllegalAccessException ignored)
				{}
			}
		}
	}

	@Override
	public String get(Object key)
	{
		String result = super.get(key);
		if (result == null)
		{
			throw new IllegalArgumentException("Check the constant key! The key is wrong, no constant defined for key " + key);
		}
		return result;
	}
}
