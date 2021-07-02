package com.adarsh.spring.jersey.rest;


import com.adarsh.spring.jersy.encryption.EncryptDecryptUtilImpl;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JerseyRestClient {

    private static final Logger LOGGER= LoggerFactory.getLogger(JerseyRestClient.class);
    private EncryptDecryptUtilImpl encryptDecryptUtil;

    @Before
    public void init() {
        encryptDecryptUtil = new EncryptDecryptUtilImpl();
        encryptDecryptUtil.setAlgorithm("AES");
        encryptDecryptUtil.setUnicodeFormat("UTF8");
        encryptDecryptUtil.setMyEncryptionKey("apollo@merittrac");
    }

    @Test
    public void testGetCall() {
        final String gettUrl = "http://localhost:8080/SpringJerseyRestCustomSecurity/rest/message/get/adarsh";
        ClientResponse clientResponse = callGetRestClient(gettUrl, "application/json");
        if (clientResponse.getStatus() == 200) {
            String output = clientResponse.getEntity(String.class);
            LOGGER.info("Request completed "+output);
        } else {
            LOGGER.error("Request not completed ");
        }
    }

    public ClientResponse callGetRestClient(final String url, final String mineType) {
        String key = null;
        try {
            key = encryptDecryptUtil.encryptData("adarsh");
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.accept(mineType).header("Authorization", key)
                .get(ClientResponse.class);
        return response;
    }

    @Test
    public void testPostCall() {
        final String postUrl = "http://localhost:8080/SpringJerseyRestCustomSecurity/rest/message/post/adarsh";
        ClientResponse clientResponse = callPostRestClient(postUrl, "application/json", "{'name':'adarsh'}");
        if (clientResponse.getStatus() == 200) {
            String output = clientResponse.getEntity(String.class);
            LOGGER.info("Request completed "+output);
        } else {
            LOGGER.error("Request not completed ");
        }
    }

    public ClientResponse callPostRestClient(final String url, final String mineType, final String input) {
        String key = null;
        try {
            key = encryptDecryptUtil.encryptData("adarsh");
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.type(mineType).header("Authorization", key)
                .post(ClientResponse.class, input);
        return response;
    }

}
