package com.adarsh.web.rest;

import com.google.gson.Gson;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Adarsh kumar
 * @Author: $LastChangeBy Adarsh
 * @Version $Revised Date: 8/1/13 Time: 2:02 PM
 */
@Path("/getDataDownload")
@Service(value = "getDataServiceImpl")
public class GetDataServiceImpl implements DataService {


    //http://localhost:8080/SpringJaxRsDownloadApplication/rest/getDataDownload/getJsonData
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getJsonData")
    public String jonData(final String data) {
        final Map map = new HashMap();
        map.put("Adarsh", "Kumar");
        map.put("Amit", "Kumar");
        return gson.toJson(map);
    }

    //http://localhost:8080/SpringJaxRsDownloadApplication/rest/getDataDownload/getXmlData
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Path(value = "/getXmlData")
    public String xmlData(final String data) {
        final Map map =  new HashMap();
        map.put("Adarsh", "Kumar");
        map.put("Amit", "Kumar");
        return xstream.toXML(map);
    }

}
