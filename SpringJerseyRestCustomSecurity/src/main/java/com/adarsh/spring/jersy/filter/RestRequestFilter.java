package com.adarsh.spring.jersy.filter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface RestRequestFilter {

    public void doAuthentication(HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse,
                                 FilterChain chain)
            throws IOException, ServletException;
}
