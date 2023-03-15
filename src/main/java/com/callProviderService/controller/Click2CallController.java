package com.callProviderService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.callProviderService.Model.CallRequest;

@RestController
public class Click2CallController {
	@PostMapping("/call") 
	public ResponseEntity callProvider(@RequestBody CallRequest callRequest){
		 return ResponseEntity.ok(HttpStatus.OK);
	 }
}
