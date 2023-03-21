package com.callProviderService.Service;

import com.callProviderService.Model.ProxyCall;
import com.callProviderService.Model.ProxyCallConfig;
import com.callProviderService.Model.ProxyCallRequest;
import com.callProviderService.Model.call.PlivoProviderConfig;
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
	
	public static PlivoProviderConfig toPlivoCallConfig() {
	    return PlivoProviderConfig.builder()
	            .provider(Provider.PLIVO)
	            .answerUrl("/plivo_xml")
	            .recordingUrl("/plivo_recording")
	            .ringUrl("/plivo_status_ringing")
	            .hangupUrl("hangupUrl")
	            .callStatusUrl("/plivo_status")
	            .build();
	  }
	
	public static ProxyCall toPlivoProxyCall(ProxyCallRequest proxyCallRequest,
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
