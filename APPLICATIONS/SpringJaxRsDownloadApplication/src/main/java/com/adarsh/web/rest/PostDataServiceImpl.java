package com.adarsh.web.rest;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @Author: Adarsh kumar
 * @Author: $LastChangeBy Adarsh
 * @Version $Revised Date: 8/1/13 Time: 2:02 PM
 */
@Path("/postDataDownload")
@Service(value = "postDataServiceImpl")
public class PostDataServiceImpl implements DataService {

    //http://localhost:8080/SpringJaxRsDownloadApplication/rest/postDataDownload/postJsonData
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/postJsonData")
    public String jonData(final String data) throws Exception {
        final Map map = gson.fromJson(data, java.util.Map.class);
        map.put("Adarsh","Kumar");
        map.put("Amit","Kumar");
        return gson.toJson(map);
    }


    //http://localhost:8080/SpringJaxRsDownloadApplication/rest/postDataDownload/postXmlData
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path(value = "/postXmlData")
    public String xmlData(final String data) throws Exception {
        final Map map = gson.fromJson(data, java.util.Map.class);
        map.put("Adarsh","Kumar");
        map.put("Amit","Kumar");
        return xstream.toXML(map);
    }
}
