package com.adarsh.spring.jersy.rest;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public interface RestService {

    public Response getWish(@PathParam("param") String name);

    public Response postWish(@PathParam("param") String name);
}