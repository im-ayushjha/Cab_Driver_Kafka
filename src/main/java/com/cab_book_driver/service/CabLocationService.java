package com.cab_book_driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {
	
	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;
	
//	public boolean updateLocation(String location) {
//		kafkaTemplate.send("cab-location", location);
//		return true;
//	}
	
	public boolean updateLocation(String key,String location) {
//		kafkaTemplate.send("cab-location",key, location);
		kafkaTemplate.send("cab-location", key, location).addCallback(
			    result -> System.out.println("Message sent to partition: " + result.getRecordMetadata().partition()),
			    ex -> System.out.println("Failed to send message: " + ex.getMessage())
			);
		return true;
	}
	
//	public boolean updateLocation(String key,String location) {
//		if(key.equals("key0"))
//			kafkaTemplate.send("cab-location", 0, key, location);
//		else
//			kafkaTemplate.send("cab-location",1, key, location);
//		return true;
//	}
}
