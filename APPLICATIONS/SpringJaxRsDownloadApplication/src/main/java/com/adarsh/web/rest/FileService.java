package com.adarsh.web.rest;


import javax.ws.rs.core.Response;

/**
 * @Author: Adarsh kumar
 * @Author: $LastChangeBy Adarsh
 * @Version $Revised Date: 8/1/13 Time: 2:02 PM
 */
public interface FileService {

    /**
     * http://localhost:8080/SpringJaxRsDownloadApplication/rest/..
     * <p/>
     * logFile() provide the specification for
     * downloading the log file using JAX-RS web service
     * implemented by Jersey Api
     *
     * @return instance of javax.ws.rs.core.Response
     *         containing the file.
     * @throws Exception when any abnormal situation
     *                   encountered during the
     *                   application execution
     */
    public Response logFile() throws Exception;

    /**
     * http://localhost:8080/SpringJaxRsDownloadApplication/rest/..
     * <p/>
     * textFile()  provide the specification for
     * downloading the txt file using JAX-RS web service
     * implemented by Jersey Api
     *
     * @return instance of javax.ws.rs.core.Response
     *         containing the file.
     * @throws Exception when any abnormal situation
     *                   encountered during the
     *                   application execution
     */
    public Response textFile() throws Exception;

    /**
     * http://localhost:8080/SpringJaxRsDownloadApplication/rest/..
     * <p/>
     * excelFile() provide the specification for
     * downloading the ms-excel file using JAX-RS web service
     * implemented by Jersey Api
     *
     * @return instance of javax.ws.rs.core.Response
     *         containing the file.
     * @throws Exception when any abnormal situation
     *                   encountered during the
     *                   application execution
     */
    public Response excelFile() throws Exception;

    /**
     * http://localhost:8080/SpringJaxRsDownloadApplication/rest/..
     * <p/>
     * wordFile() provide the specification for
     * downloading the ms-word file using JAX-RS web service
     * implemented by Jersey Api
     *
     * @return instance of javax.ws.rs.core.Response
     *         containing the file.
     * @throws Exception when any abnormal situation
     *                   encountered during the
     *                   application execution
     */
    public Response wordFile() throws Exception;

    /**
     * http://localhost:8080/SpringJaxRsDownloadApplication/rest/..
     * <p/>
     * pptFile() provide the specification for
     * downloading the ms-power point file using JAX-RS
     * web service implemented by Jersey Api
     *
     * @return instance of javax.ws.rs.core.Response
     *         containing the file.
     * @throws Exception when any abnormal situation
     *                   encountered during the
     *                   application execution
     */
    public Response pptFile() throws Exception;

    /**
     * http://localhost:8080/SpringJaxRsDownloadApplication/rest/..
     * <p/>
     * pdfFile() provide the specification for
     * downloading the pdf file using JAX-RS
     * web service implemented by Jersey Api
     *
     * @return instance of javax.ws.rs.core.Response
     *         containing the file.
     * @throws Exception when any abnormal situation
     *                   encountered during the
     *                   application execution
     */
    public Response pdfFile() throws Exception;


    /**
     * http://localhost:8080/SpringJaxRsDownloadApplication/rest/..
     * <p/>
     * zipFile() provide the specification for
     * downloading the zip file using JAX-RS
     * web service implemented by Jersey Api
     *
     * @return instance of javax.ws.rs.core.Response
     *         containing the file.
     * @throws Exception when any abnormal situation
     *                   encountered during the
     *                   application execution
     */
    public Response zipFile() throws Exception;

}