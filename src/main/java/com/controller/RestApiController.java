package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.data.Request;
import com.data.Response;
import com.service.Services;

@RestController
@RequestMapping("api/parking")
public class RestApiController {
	
	private Services services;
	
	@Autowired
    public RestApiController(Services Services) {
		super();
		this.services = Services;
	}
	@GetMapping("/status")
    public ResponseEntity<Response> getStatusDetail(@RequestParam Request request) {
    	Response response = null;
    	if (services.isValidLink(request)) {
    		services.getStatus(request);
    		//services.log(request, response);
    		return new ResponseEntity<>(response, HttpStatus.OK);
    	} else
    		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/park")
    public ResponseEntity<Response> postParking(@RequestParam Request request){
    	Response response = null;
    	if (services.isValidLink(request)) {
    		response = services.postParking(request);
    		//services.log(request, response);
    		return new ResponseEntity<>(response, HttpStatus.OK);
    	} else
    		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/leave")
    public ResponseEntity<Response> leaveParking(@RequestParam Request request){
    	Response response = null;
    	if (services.isValidLink(request)) {
    		response = services.leaveParking(request);
    		//services.log(request, response);
    		return new ResponseEntity<>(response, HttpStatus.OK);
    	} else
    		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
