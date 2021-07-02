package com.adarsh.spring.jersy.encryption;

/**
 * @Author: Adarsh_K
 * @Author: $LastChangeBy Adarsh_K
 * @Version $Revised Date: 8/1/13 Time: 2:02 PM
 * @see
 */
public interface EncryptDecryptUtil {


    /**
     * encryptData() provide the specification for encryption of the
     * supplied data into specified algorithms
     *
     * @param data accept the instance of the java.lang.String containing
     *             the actual data which need to be encrypted
     * @return the instance of the java.lang.String containing the encrypted
     *         data using specified algorithms.
     * @throws Exception if any abnormal condition is encountered during the
     *                   execution of the application.
     */
    public String encryptData(String data) throws Exception;

    /**
     * deCryptData() provide the specification for decryption of the
     * supplied encrypted data using specified algorithms
     *
     * @param data accept the instance of the java.lang.String containing
     *             the actual data which need to be decrypt.
     * @return the instance of the java.lang.String containing the decrypted
     *         data using specified algorithms.
     * @throws Exception if any abnormal condition is encountered during the
     *                   execution of the application.
     */
    public String deCryptData(String data) throws Exception;

}
