package com.callProviderService.Model;

import lombok.Builder;

@Builder
public class ProxyCallResponse {
	private String callSid;

	public String getCallSid() {
		return callSid;
	}

	public void setCallSid(String callSid) {
		this.callSid = callSid;
	}
	
}
