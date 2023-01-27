package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.cacheservice._1.GenericRefreshCacheRequestType;
import com.sadad.ebpp.scm.schema.cacheservice._1.RefreshCacheRequestType;
import com.sadad.ebpp.scm.schema.cacheservice._1.RefreshCacheResponseType;
import com.sadad.ebpp.wsdl.cacheservice._1.CacheFaultMsg;
import com.sadad.portal.common.utils.RequestResponseLogger;

public interface CacheServiceDelegate extends RequestResponseLogger
{
	public RefreshCacheResponseType refreshCache(RefreshCacheRequestType refreshCacheRequest) throws CacheFaultMsg;

	public RefreshCacheResponseType genericRefreshCache(GenericRefreshCacheRequestType genericRefreshCacheRequest) throws CacheFaultMsg;
}