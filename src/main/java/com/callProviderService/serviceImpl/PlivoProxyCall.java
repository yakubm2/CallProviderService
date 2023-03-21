package com.callProviderService.serviceImpl;

import java.net.URLEncoder;
import java.util.Collections;

import com.callProviderService.Model.ProxyCall;
import com.callProviderService.Model.ProxyCallResponse;
import com.callProviderService.Model.Property.BaseUrl;
import com.callProviderService.Service.ProviderProxyCall;
import com.plivo.api.Plivo;
import com.plivo.api.models.call.Call;
import com.plivo.api.models.call.CallCreateResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlivoProxyCall implements ProviderProxyCall{
	
	private ProxyCall proxyCallProperty;
	 public PlivoProxyCall(ProxyCall proxyCallProperty) {
		    this.proxyCallProperty = proxyCallProperty;
	
	 }
	@Override
	public ProxyCallResponse makeProxyCall() {
		// TODO Auto-generated method stub
		Plivo.init(proxyCallProperty.getAccountId(), proxyCallProperty.getAuthToken());
	    CallCreateResponse call = null;
	      try {
	        call = Call.creator(
	                            proxyCallProperty.getCallerId(),
	                            Collections.singletonList(proxyCallProperty.getFromNumber()),
	                            getPlivoAnswerUrl())
	                            .answerMethod("GET")
	                            .ringUrl(getPlivoRingUrl())
	                            .create();
	      } catch (Exception e) {
	        log.info("error occured while plivo proxy call", e);
	      }
	    return ProxyCallResponse.builder().callSid(call.getRequestUuid()).build();
	}
	  private String getPlivoRingUrl() {
		    String ringurl;

		    ringurl = new StringBuilder()
		            .append(BaseUrl.urlString)
		            .append("/plivo_status_ringing")
		            .toString();

		    return ringurl;

		  }

		  private String getPlivoAnswerUrl(){
		    String answerurl = null;
		    try {
		      answerurl = new StringBuilder()
		              .append(BaseUrl.urlString)
		              .append("/plivo_xml?caller_id=")
		              .append(URLEncoder.encode(proxyCallProperty.getCallerId(), "UTF-8"))
		              .append("&leg_2_number=")
		              .append(URLEncoder.encode(proxyCallProperty.getToNumber(), "UTF-8"))
		              .toString();
		    }
		    catch (Exception e){
		      log.error("error creating the answer url for plivo", e);
		    }
		    return answerurl;
		  }
}
