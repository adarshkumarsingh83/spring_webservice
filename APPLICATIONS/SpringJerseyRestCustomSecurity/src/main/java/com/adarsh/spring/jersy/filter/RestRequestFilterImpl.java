package com.adarsh.spring.jersy.filter;


import com.adarsh.spring.jersy.encryption.EncryptDecryptUtil;
import com.adarsh.spring.jersy.encryption.EncryptDecryptUtilImpl;
import com.adarsh.spring.jersy.properties.ApplicationPropertiesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Scope(value = "singleton")
@Service(value = "restRequestFilterImpl")
public class RestRequestFilterImpl implements RestRequestFilter, Filter, ApplicationContextAware {

    private static final Logger LOGGER= LoggerFactory.getLogger(RestRequestFilterImpl.class);
    private static ApplicationContext applicationContextObject;
    private static String authenticationHeader = null;
    private static String authenticationKey = null;
    private static EncryptDecryptUtil encryptDecryptUtil;
    private FilterConfig filterConfig;

    @PostConstruct
    public void init() {
        authenticationKey = applicationContextObject.getBean(ApplicationPropertiesImpl.class)
                .getStringProperty("app.rest.filter.authentication.token");
        authenticationHeader= applicationContextObject.getBean(ApplicationPropertiesImpl.class)
                .getStringProperty("app.rest.filter.authentication.header");
        encryptDecryptUtil = applicationContextObject.getBean(EncryptDecryptUtilImpl.class);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        doAuthentication(httpServletRequest, httpServletResponse, chain);
    }

    public void doAuthentication(HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse,
                                 FilterChain chain)
            throws IOException, ServletException {
        try {
            final Object tokenObject = httpServletRequest.getHeader(authenticationHeader);
            if (tokenObject != null) {
                final String stringToken = encryptDecryptUtil.deCryptData(tokenObject.toString().trim());
                if (!stringToken.isEmpty() && stringToken.equals(authenticationKey)) {
                    chain.doFilter(httpServletRequest, httpServletResponse);
                } else {
                    httpServletResponse.setStatus(401);
                    httpServletResponse.getWriter().write("UnAuthorised Request");
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        applicationContextObject = applicationContext;
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
