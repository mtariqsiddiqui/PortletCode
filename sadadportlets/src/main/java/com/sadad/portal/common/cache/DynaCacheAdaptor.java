package com.sadad.portal.common.cache;

import javax.naming.InitialContext;
import javax.naming.NamingException;


import com.ibm.websphere.cache.DistributedMap;
import com.sadad.portal.constant.PortalConstant;

/**
 * @author Tariq Siddiqui
 *
 */
public class DynaCacheAdaptor
{
	private static DistributedMap dynaCacheMap;

	protected DynaCacheAdaptor()
	{}

	public static DistributedMap getCacheMapObj() throws NamingException
	{
		if (dynaCacheMap == null)
		{
			InitialContext ic = new InitialContext();
			dynaCacheMap =  (DistributedMap) ic.lookup(PortalConstant.JNDI_DISTRIBUTED_MAP_CACHE); 
		}
		return dynaCacheMap;
	}
}
