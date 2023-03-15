package com.callProviderService.Model.call;



import java.util.List;

import com.callProviderService.Model.ProxyCallConfig;

import enums.CallEvent;
import enums.RecordingEvent;
import lombok.experimental.SuperBuilder;



@SuperBuilder
public class TwilioProviderConfig extends  ProxyCallConfig{	
	    private String callStatusCallbackUrl;
	    private String recordingStatusCallBackUrl;
	    private List<CallEvent> callEvents;
	    private List<RecordingEvent> recordingEvents;

}
