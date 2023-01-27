package com.sadad.portal.beans;

public class CacheSessionDataBean extends SadadPortalSessionDataBean
{
	private String cacheName;
	private String cacheKey;

	public String getCacheName()
	{
		return cacheName;
	}

	public void setCacheName(String cacheName)
	{
		this.cacheName = cacheName;
	}

	public String getCacheKey()
	{
		return cacheKey;
	}

	public void setCacheKey(String cacheKey)
	{
		this.cacheKey = cacheKey;
	}
}