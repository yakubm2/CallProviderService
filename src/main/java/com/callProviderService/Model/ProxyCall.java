package com.callProviderService.Model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class ProxyCall {
	private String toNumber;
    private String fromNumber;
    private String did;
    private String callerId;
    private String accountId;
    private String authToken;
    private ProxyCallConfig proxyCallConfig;    
}
