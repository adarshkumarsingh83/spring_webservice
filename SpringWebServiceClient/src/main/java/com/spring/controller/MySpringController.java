package com.spring.controller;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Adarsh
 * Date: 2/10/12
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class MySpringController extends AbstractController {

    private Map<String, String> serviceMehodUrl;

    public void setServiceMehodUrl(Map<String, String> serviceMehodUrl) {
        this.serviceMehodUrl = serviceMehodUrl;
    }

    @Override
    protected ModelAndView handleRequestInternal(javax.servlet.http.HttpServletRequest request
            , javax.servlet.http.HttpServletResponse response) throws Exception {
             String methodName=request.getParameter("methodName");
             String methodResult=null;
             if(methodName.equals("get")){
                 methodResult=this.__getGetMehodService();
             }else if(methodName.equals("post")){
                methodResult=this.__postMehodService();
             }else if(methodName.equals("put")){
                  methodResult=this.__getPutMethodService();
             }else if(methodName.equals("delete")){
                  methodResult=this.__getDeleteMethodService();
             }else if(methodName.equals("option")){
                  methodResult=this.__getOptionMethodService();
             }else if(methodName.equals("head")){
                  methodResult=this.__getHeadMethodService();
             }
        System.out.println("Mehod Name :=> "+methodName+" , Method Result :=>"+methodResult);
         if(methodResult==null)
           methodResult="Method not executed ";
       return new ModelAndView("resultPage","resultMessage",methodResult);
    }

    private String __postMehodService() throws Exception {
        final PostMethod postMethod = new PostMethod(serviceMehodUrl.get("post"));
        return this.__methodOpertion(postMethod);
    }

    private String __getGetMehodService() throws Exception {
        final GetMethod getMethod = new GetMethod(serviceMehodUrl.get("get"));
        return this.__methodOpertion(getMethod);
    }

    private String __getPutMethodService() throws Exception {
        final PutMethod putMethod = new PutMethod(serviceMehodUrl.get("put"));
        return this.__methodOpertion(putMethod);
    }

    private String __getDeleteMethodService() throws Exception {
        final DeleteMethod deleteMethod = new DeleteMethod(serviceMehodUrl.get("delete"));
        return this.__methodOpertion(deleteMethod);
    }

    private String __getOptionMethodService() throws Exception {
        final OptionsMethod optionsMethod = new OptionsMethod(serviceMehodUrl.get("option"));
        return this.__methodOpertion(optionsMethod);
    }

     private String __getHeadMethodService() throws Exception {
        final HeadMethod headMethod = new HeadMethod(serviceMehodUrl.get("head"));
        return this.__methodOpertion(headMethod);
    }

    private String __methodOpertion(org.apache.commons.httpclient.HttpMethod httpMethod) throws Exception {
        final HttpClient httpClient = new HttpClient();
        httpClient.startSession("localhost", 8080,false);
        httpClient.executeMethod(httpMethod);
        String result = httpMethod.getResponseBodyAsString();
        return result;
    }


}
