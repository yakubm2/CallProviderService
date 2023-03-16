package com.callProviderService.Model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProxyCallRequest {
    private String toNumber;
    private String fromNumber;
    private String callerId;
    private String did;
    private Integer providerId;
    private String accountId;
    private String authToken;
	    
}
