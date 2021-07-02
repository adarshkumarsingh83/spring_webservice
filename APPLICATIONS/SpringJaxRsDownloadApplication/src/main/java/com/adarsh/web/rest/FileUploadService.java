package com.adarsh.web.rest;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


/**
 * @Author: Adarsh kumar
 * @Author: $LastChangeBy Adarsh
 * @Version $Revised Date: 8/1/13 Time: 2:02 PM
 */
public interface FileUploadService {

    /**
     * uploadFile() provide the specification for uploading file to the server
     * no size and type restriction.
     *
     * @param uploadedFileInputStream
     * @param uploadedFileDetails
     * @return
     * @throws Exception
     */
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedFileInputStream,
            @FormDataParam("file") FormDataContentDisposition uploadedFileDetails)
            throws Exception;
}