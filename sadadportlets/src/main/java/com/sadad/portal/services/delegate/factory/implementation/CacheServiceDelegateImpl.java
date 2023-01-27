package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.cacheservice._1.GenericRefreshCacheRequestType;
import com.sadad.ebpp.scm.schema.cacheservice._1.RefreshCacheRequestType;
import com.sadad.ebpp.scm.schema.cacheservice._1.RefreshCacheResponseType;
import com.sadad.ebpp.wsdl.cacheservice._1.CacheFaultMsg;
import com.sadad.ebpp.wsdl.cacheservice._1.CacheService;
import com.sadad.portal.services.client.proxy.ServiceCacheServiceProxy;

public class CacheServiceDelegateImpl implements CacheServiceDelegate
{

	private static CacheServiceDelegateImpl instance;
	private ServiceCacheServiceProxy proxy;
	private CacheService service;

	private CacheServiceDelegateImpl()
	{
		proxy = new ServiceCacheServiceProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.CACHE_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of CacheServiceDelegateImpl
	 * 
	 * @return
	 */
	public static CacheServiceDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new CacheServiceDelegateImpl();
		}
		return instance;
	}

	@Override
	public RefreshCacheResponseType refreshCache(RefreshCacheRequestType req) throws CacheFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.CACHE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("RefreshCacheRequest", RefreshCacheRequestType.class, req);

		RefreshCacheResponseType res = service.refreshCache(req);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("RefreshCacheResponse", RefreshCacheResponseType.class, res);

		return res;
	}

	@Override
	public RefreshCacheResponseType genericRefreshCache(GenericRefreshCacheRequestType req) throws CacheFaultMsg
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.CACHE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GenericRefreshCacheRequest", GenericRefreshCacheRequestType.class, req);

		RefreshCacheResponseType res = service.genericRefreshCache(req);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("RefreshCacheResponse", RefreshCacheResponseType.class, res);
		
		return res;
	}
}
