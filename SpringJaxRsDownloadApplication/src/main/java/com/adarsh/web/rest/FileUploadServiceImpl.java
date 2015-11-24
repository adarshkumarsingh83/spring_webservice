package com.adarsh.web.rest;

import java.io.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

/**
 * @Author: Adarsh kumar
 * @Author: $LastChangeBy Adarsh
 * @Version $Revised Date: 8/1/13 Time: 2:02 PM
 */
@Path("/postService")
public class FileUploadServiceImpl implements FileUploadService {

    @POST
    @Path("/fileUpload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedFileInputStream,
            @FormDataParam("file") FormDataContentDisposition uploadedFileDetails)
            throws Exception {

        final String destinationDirPath=System.getProperty("user.home")+File.separator+"Downloads"+File.separator+uploadedFileDetails.getFileName();
        final File fileObject = new File(destinationDirPath);
        fileObject.createNewFile();
        IOUtils.copy(uploadedFileInputStream, new FileOutputStream(fileObject.getAbsoluteFile()));
        return Response.status(HttpStatus.OK.value()).entity("File Upload to :" + fileObject.getAbsolutePath()).build();
    }
}