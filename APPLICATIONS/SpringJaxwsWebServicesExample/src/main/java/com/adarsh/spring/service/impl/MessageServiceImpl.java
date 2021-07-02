package com.adarsh.spring.service.impl;


import com.adarsh.spring.service.MessageService;
import org.springframework.stereotype.Service;


@Service
public class MessageServiceImpl implements MessageService{

	public String getWishMessage(){
		return "HI ADARSH JAX-WS SPRING WEB SERVICE";
	}
	
}