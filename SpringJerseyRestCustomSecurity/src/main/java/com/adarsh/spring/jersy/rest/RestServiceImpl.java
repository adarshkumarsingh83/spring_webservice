package com.adarsh.spring.jersy.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.adarsh.spring.jersy.bean.MessageBeanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Lazy(value = false)
@Scope(value = "singleton")
@Service(value = "restServiceImpl")
@Path("/message")
public class RestServiceImpl implements RestService {

    private static final Logger LOGGER= LoggerFactory.getLogger(RestServiceImpl.class);

    @Qualifier("messageBeanServiceImpl")
    @Autowired(required = true)
    private MessageBeanService messageBeanService;

    //http://localhost:8080/SpringJerseyRestCustomSecurity/rest/message/get/adarsh
    @GET
    @Path("/get/{param}")
    public Response getWish(@PathParam("param") String name) {
        LOGGER.info("getWish() "+name);
        return Response.status(200).entity(messageBeanService.getMessage()).build();
    }

    //http://localhost:8080/SpringJerseyRestCustomSecurity/rest/message/post/adarsh
    @POST
    @Path("/post/{param}")
    public Response postWish(@PathParam("param") String name) {
        LOGGER.info("postWish() "+name);
        return Response.status(200).entity(messageBeanService.getMessage()).build();
    }

}