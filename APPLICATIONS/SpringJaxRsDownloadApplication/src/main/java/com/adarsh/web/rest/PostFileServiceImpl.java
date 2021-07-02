package com.adarsh.web.rest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.File;


/**
 * @Author: Adarsh kumar
 * @Author: $LastChangeBy Adarsh
 * @Version $Revised Date: 8/1/13 Time: 2:02 PM
 */
@Path("/postFileDownload")
@Service(value = "postFileServiceImpl")
public class PostFileServiceImpl implements FileService {

    private static final String FILE_PATH_TXT = "sample.txt";
    private static final String FILE_PATH_PLAN = "sample.log";
    private static final String FILE_PATH_EXCEL = "sample.xls";
    private static final String FILE_PATH_WORD = "sample.doc";
    private static final String FILE_PATH_PPT = "sample.ppt";
    private static final String FILE_PATH_PDF = "sample.pdf";
    private static final String FILE_PATH_ZIP = "sample.zip";

    //http://localhost:8080/SpringJaxRsDownloadApplication/rest/postFileDownload/postLogFile
    @POST
    @Path("/postLogFile")
    @Produces("text/plain")
    @Override
    public Response logFile() throws Exception {
        File file = new File(this.getFilePath(FILE_PATH_PLAN));
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=" + FILE_PATH_PLAN);
        return response.build();
    }

    //http://localhost:8080/SpringJaxRsDownloadApplication/rest/postFileDownload/postTxtFile
    @POST
    @Path("/postTxtFile")
    @Produces("text/plain")
    @Override
    public Response textFile() throws Exception {
        File file = new File(this.getFilePath(FILE_PATH_TXT));
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=\"file_from_server.txt\"");
        return response.build();
    }

    //http://localhost:8080/SpringJaxRsDownloadApplication/rest/postFileDownload/postExcelFile
    @POST
    @Path("/postExcelFile")
    @Produces("application/vnd.ms-excel")
    @Override
    public Response excelFile() throws Exception {
        File file = new File(this.getFilePath(FILE_PATH_EXCEL));
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=\"file_from_server.xls\"");
        return response.build();
    }


    //http://localhost:8080/SpringJaxRsDownloadApplication/rest/postFileDownload/postWordFile
    @POST
    @Path("/postWordFile")
    @Produces("application/vnd.ms-doc")
    @Override
    public Response wordFile() throws Exception {
        File file = new File(this.getFilePath(FILE_PATH_WORD));
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=\"file_from_server.doc\"");
        return response.build();
    }


    //http://localhost:8080/SpringJaxRsDownloadApplication/rest/postFileDownload/postPptFile
    @POST
    @Path("/postPptFile")
    @Produces("application/vnd.ms-ppt")
    @Override
    public Response pptFile() throws Exception {
        File file = new File(this.getFilePath(FILE_PATH_PPT));
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=\"file_from_server.ppt\"");
        return response.build();
    }


    //http://localhost:8080/SpringJaxRsDownloadApplication/rest/postFileDownload/postPdfFile
    @POST
    @Path("/postPdfFile")
    @Produces("application/pdf")
    @Override
    public Response pdfFile() throws Exception {

        File file = new File(this.getFilePath(FILE_PATH_PDF));

        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
                "attachment; filename=server-file.pdf");
        return response.build();

    }

    //http://localhost:8080/SpringJaxRsDownloadApplication/rest/postFileDownload/postZipFile
    @GET
    @Path("/postZipFile")
    @Produces("application/zip")
    @Override
    public Response zipFile() throws Exception {
        File file = new File(this.getFilePath(FILE_PATH_ZIP));

        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
                "attachment; filename=server-file.zip");
        return response.build();
    }

    /**
     * getFilePath() provide the implementation  for
     * getting the file inside the
     * resources folder
     *
     * @param classpathRelativePath
     * @return
     * @throws Exception
     */
    private String getFilePath(String classpathRelativePath) throws Exception {
        final Resource pathResource = new ClassPathResource(classpathRelativePath);
        return pathResource.getFile().getAbsolutePath();
    }
}