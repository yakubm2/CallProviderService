package com.callProviderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.callProviderService.Model.ProxyCallRequest;
import com.callProviderService.Model.ProxyCallResponse;
import com.callProviderService.Service.ProxyCallService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(path = "/call")
public class Click2CallController {
	@Autowired
	private ProxyCallService proxyCallService;

	@PostMapping(path = "/proxy", produces = "application/json")
	public ResponseEntity callProvider(@RequestHeader("authToken") String authToken,@RequestBody ProxyCallRequest proxyCallRequest) {
		proxyCallRequest.setAuthToken(authToken);
		ProxyCallResponse proxyCallResponse = proxyCallService.proxyCall(proxyCallRequest);
		return ResponseEntity.ok().body(proxyCallResponse);

	}
}
