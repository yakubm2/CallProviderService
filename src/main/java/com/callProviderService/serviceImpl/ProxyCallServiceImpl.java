package com.callProviderService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callProviderService.Model.ProxyCallRequest;
import com.callProviderService.Model.ProxyCallResponse;
import com.callProviderService.Service.ProviderProxyCall;
import com.callProviderService.Service.ProxyCallService;
import com.fasterxml.jackson.databind.ObjectMapper;


import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class ProxyCallServiceImpl implements ProxyCallService{

	    @Autowired
	    private ProxyCallFactory proxyCallFactory;

	    @Autowired
	    private ObjectMapper objectMapper;


	@Override
	public ProxyCallResponse proxyCall(ProxyCallRequest proxyCallRequest) {
		// TODO Auto-generated method stub
		log.info("inside proxy call service", proxyCallRequest);
		ProviderProxyCall providerProxyCall  = proxyCallFactory.getProxyCallProvider(proxyCallRequest);
        ProxyCallResponse proxyCallResponse = providerProxyCall.makeProxyCall();
		return proxyCallResponse;
	}



}
