package com.callProviderService.serviceImpl;

import com.callProviderService.Model.ProxyCall;
import com.callProviderService.Model.ProxyCallResponse;
import com.callProviderService.Model.Property.BaseUrl;
import com.callProviderService.Service.ProviderProxyCall;
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
		    try {
		      answerurl = BaseUrl.urlString + "/twilio_xml?caller_id=" + proxyCallProperty.getCallerId() + "&caller_id="
		              + URLEncoder.encode(proxyCallProperty.getFromNumber(), "UTF-8") + "&leg_2_number="
		              + URLEncoder.encode(proxyCallProperty.getToNumber(), "UTF-8") + "&recording_call_back="
		              + URLEncoder.encode(recordingStatusCallback, "UTF-8");
		    } catch (UnsupportedEncodingException e) {
		      e.printStackTrace();
		    }
		    Call call=null;
		    try{
		      call = Call
		              .creator(new com.twilio.type.PhoneNumber(proxyCallProperty.getFromNumber()), new com.twilio.type.PhoneNumber(proxyCallProperty.getCallerId()),
		                      URI.create(answerurl))
		              .setStatusCallback(BaseUrl.urlString + "/twilio_callstatus")
		              .setStatusCallbackEvent(Arrays.asList("initiated", "ringing", "answered", "completed"))
		              .create();
		      return ProxyCallResponse.builder().callSid(call.getSid()).build();
		    }catch (TwilioException e){
		      e.printStackTrace();
		    }
		    return ProxyCallResponse.builder().callSid("Account not verified").build();
	 }

}
