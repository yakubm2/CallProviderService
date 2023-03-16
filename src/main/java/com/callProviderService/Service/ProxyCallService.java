package com.callProviderService.Service;

import com.callProviderService.Model.ProxyCallRequest;
import com.callProviderService.Model.ProxyCallResponse;

public interface ProxyCallService {
	  public ProxyCallResponse proxyCall(ProxyCallRequest proxyCallRequest);	 
}
