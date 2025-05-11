package com.cab_book_driver.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cab_book_driver.service.CabLocationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/location")
public class CabLocationController {
	@Autowired
	private CabLocationService ser;
	
	@PutMapping
	public ResponseEntity updateLocation() throws Exception  {
			int range=26;
			while(range>0) {
				ser.updateLocation("mykey-"+(26-range),Math.random()+" ");
				Thread.sleep(500);
				range--;
			}
		return new ResponseEntity<>(Collections.singletonMap("message", "Location updated"),HttpStatus.OK);
	}
}
