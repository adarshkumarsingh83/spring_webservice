package com.adarsh.web.rest;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

/**
 * @Author: Adarsh kumar
 * @Author: $LastChangeBy Adarsh
 * @Version $Revised Date: 8/1/13 Time: 2:02 PM
 */

public interface DataService {

    public static final Gson gson = new Gson();

    public static final XStream xstream = new XStream();

    /**
     * jonData()
     *
     * @param data
     * @return
     * @throws Exception
     */
    public String jonData(final String data) throws Exception;

    /**
     * xmlData()
     *
     * @param data
     * @return
     * @throws Exception
     */
    public String xmlData(final String data) throws Exception;
}
