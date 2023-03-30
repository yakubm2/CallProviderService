package com.callProviderService.serviceImpl;

import com.callProviderService.Model.ProxyCall;
import com.callProviderService.Model.ProxyCallResponse;
import com.callProviderService.Model.Property.BaseUrl;
import com.callProviderService.Service.ProviderProxyCall;
import com.callProviderService.Service.ProxyCallService;
import com.twilio.Twilio;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Call;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Arrays;

public class TwilioProxyCall implements ProviderProxyCall {
	 private ProxyCall proxyCallProperty;
	 public TwilioProxyCall(ProxyCall proxyCallProperty) {
		    this.proxyCallProperty = proxyCallProperty;
	
	 }
	
	 @Override
	 public ProxyCallResponse makeProxyCall() {
		// TODO Auto-generated method stub
		 String recordingStatusCallback = BaseUrl.urlString + "/twilio_recording";
		    Twilio.init(proxyCallProperty.getAccountId(), proxyCallProperty.getAuthToken());
		    String answerurl = null;

		    answerurl="http://demo.twilio.com/docs/voice.xml";
		    Call call=null;
		    try{
		      call = Call
		              .creator(new com.twilio.type.PhoneNumber(proxyCallProperty.getFromNumber()), new com.twilio.type.PhoneNumber(proxyCallProperty.getToNumber()),
		                      URI.create(answerurl))
		              .create();
		      return ProxyCallResponse.builder().callSid(call.getSid()).build();
		    }catch (TwilioException e){
		      e.printStackTrace();
		    }
		    return ProxyCallResponse.builder().callSid("Account not verified").build();
	 }

}
