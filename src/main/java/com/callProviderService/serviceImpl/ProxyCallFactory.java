package com.callProviderService.serviceImpl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.callProviderService.Model.ProxyCall;
import com.callProviderService.Model.ProxyCallConfig;
import com.callProviderService.Model.ProxyCallRequest;
import com.callProviderService.Service.ProviderProxyCall;
import com.callProviderService.Service.ProxyCallUtils;
import com.google.common.collect.ImmutableMap;

import enums.Provider;

@Service
public class ProxyCallFactory {
	private static final Map<Integer, Provider> providerMap = ImmutableMap.<Integer, Provider>builder()
			.put(1, Provider.PLIVO).put(2, Provider.TWILIO).build();

	public ProviderProxyCall getProxyCallProvider(ProxyCallRequest proxyCallRequest) {
		Provider provider = providerMap.get(proxyCallRequest.getProviderId());
		switch (provider) {
		case TWILIO:
			return getTwilioProxyCallInstance(proxyCallRequest);
		default:
			return getTwilioProxyCallInstance(proxyCallRequest);
		}

	}

	private ProviderProxyCall getTwilioProxyCallInstance(ProxyCallRequest twilioCallRequest) {
		ProxyCallConfig twilioCallCallConfig = ProxyCallUtils.toTwilioCallConfig();
		ProxyCall twilioCallproperties = ProxyCallUtils.toTwilioProxyCall(twilioCallRequest,
				twilioCallCallConfig);
		return new TwilioProxyCall(twilioCallproperties);
	}
}
