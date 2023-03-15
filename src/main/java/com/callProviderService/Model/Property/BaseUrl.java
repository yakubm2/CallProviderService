package com.callProviderService.Model.Property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseUrl {
	 public static String urlString;

	    public String getBASE_URL() {
	        return urlString;
	    }
	    @Value("${baseurl}")
	    public void setBASE_URL(String baseurl) {
	        urlString = baseurl;
	    }
}
