package com.callProviderService.Service;

import com.callProviderService.Model.ProxyCall;
import com.callProviderService.Model.ProxyCallConfig;
import com.callProviderService.Model.ProxyCallRequest;
import com.callProviderService.Model.call.TwilioProviderConfig;
import com.google.common.collect.Lists;

import enums.CallEvent;
import enums.Provider;
import enums.RecordingEvent;

public class ProxyCallUtils {
	public static TwilioProviderConfig toTwilioCallConfig() {
	    return TwilioProviderConfig.builder()
	        .provider(Provider.TWILIO)
	        .callEvents(Lists.newArrayList(CallEvent.HUNGUP, CallEvent.ANSWERED))
	        .callStatusCallbackUrl("status_url")
	        .recordingEvents(Lists.newArrayList(RecordingEvent.STARTED, RecordingEvent.STOPPED))
	        .recordingStatusCallBackUrl("recording_url")
	        .build();
	  }

	public static ProxyCall toTwilioProxyCall(ProxyCallRequest proxyCallRequest,
	      ProxyCallConfig proxyCallConfig) {
	    return ProxyCall.builder()
	        .proxyCallConfig(proxyCallConfig)
	        .callerId(proxyCallRequest.getCallerId())
	        .did(proxyCallRequest.getDid())
	        .toNumber(proxyCallRequest.getToNumber())
	        .fromNumber(proxyCallRequest.getFromNumber())
	        .authToken(proxyCallRequest.getAuthToken())
	        .accountId(proxyCallRequest.getAccountId())
	        .build();
	  }
}
