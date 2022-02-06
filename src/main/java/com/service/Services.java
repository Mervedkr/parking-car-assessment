package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.data.Request;
import com.data.Response;

@Component
public class Services {
	@Autowired
	private ServiceImpl serviceImpl;
	// TODO if you want to save your come in and out request and open code blok in the controller for this method
	void log(Request request, Response response) {
		serviceImpl.log(request, response);
	}
	public Response getStatus(Request request) {
		return serviceImpl.getStatus(request);
	}
	public Response leaveParking(Request request) {
		return serviceImpl.leaveParking(request);
	}
	public Response postParking(Request request) {
		return serviceImpl.postParking(request);
	}
	// TODO code for validation if the request link is correct  		
	public boolean	isValidLink(Request request) {
		return true;
	}
}
