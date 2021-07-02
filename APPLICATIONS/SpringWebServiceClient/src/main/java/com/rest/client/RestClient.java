package com.rest.client;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.*;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Adarsh
 * Date: 2/10/12
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestClient {

    private static Map<String, String> serviceMehodUrl;

    public void setServiceMehodUrl(Map<String, String> serviceMehodUrl) {
        this.serviceMehodUrl = serviceMehodUrl;
    }

    public static void main(String[] args)throws Exception{
        String[] methodName = new String[]{"get","put","post","delete","head"};
         String methodResult=null;
             if(methodName.equals("get")){
                 methodResult=__getGetMehodService();
             }else if(methodName.equals("post")){
                methodResult=__postMehodService();
             }else if(methodName.equals("put")){
                  methodResult=__getPutMethodService();
             }else if(methodName.equals("delete")){
                  methodResult=__getDeleteMethodService();
             }else if(methodName.equals("option")){
                  methodResult=__getOptionMethodService();
             }else if(methodName.equals("head")){
                  methodResult=__getHeadMethodService();
             }
    }

      private static String __postMehodService() throws Exception {
        final PostMethod postMethod = new PostMethod(serviceMehodUrl.get("post"));
        postMethod.addParameter("gender", "men");
        return __methodOpertion(postMethod);
    }

    private static String __getGetMehodService() throws Exception {
        GetMethod getMethod = new GetMethod(serviceMehodUrl.get("get"));
        return __methodOpertion(getMethod);
    }

    private static String __getPutMethodService() throws Exception {
        final PutMethod putMethod = new PutMethod(serviceMehodUrl.get("put"));
        return __methodOpertion(putMethod);
    }

    private  static String __getDeleteMethodService() throws Exception {
        final DeleteMethod deleteMethod = new DeleteMethod(serviceMehodUrl.get("delete"));
        return __methodOpertion(deleteMethod);
    }

    private  static String __getOptionMethodService() throws Exception {
        final OptionsMethod optionsMethod = new OptionsMethod(serviceMehodUrl.get("option"));
        return __methodOpertion(optionsMethod);
    }

     private static String __getHeadMethodService() throws Exception {
        final HeadMethod headMethod = new HeadMethod(serviceMehodUrl.get("head"));
        return __methodOpertion(headMethod);
    }

    private static String __methodOpertion(org.apache.commons.httpclient.HttpMethod httpMethod) throws Exception {
        final HttpClient httpClient = new HttpClient();
        httpClient.startSession("localhost", 8080,false);
        httpClient.executeMethod(httpMethod);
        String result = httpMethod.getResponseBodyAsString();
        return result;
    }

}
