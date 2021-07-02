package com.adarsh.spring.webservice;

import com.adarsh.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Service
@WebService
public class MessageWebService {

    @Autowired(required = true)
    private MessageService messageService;

    @WebMethod(exclude = true)
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }


    @WebMethod(operationName = "getHelloWorld")
    public String getWishMessage() {
        return this.messageService.getWishMessage();
    }

}