package com.callProviderService.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProxyCallRequest {
    private String toNumber;
    private String fromNumber;
    private String callerId;
    private String did;
    private Integer providerId;
    private String accountId;
    private String authToken;
	    
}
