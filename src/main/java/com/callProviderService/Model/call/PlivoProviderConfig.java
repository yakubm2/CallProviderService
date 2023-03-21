package com.callProviderService.Model.call;


import com.callProviderService.Model.ProxyCallConfig;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class PlivoProviderConfig extends ProxyCallConfig {
    private String answerUrl;
    private String ringUrl;
    private String hangupUrl;
    private String recordingUrl;
    private String callStatusUrl;
}