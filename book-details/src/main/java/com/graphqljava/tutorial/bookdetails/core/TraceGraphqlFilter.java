package com.graphqljava.tutorial.bookdetails.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TraceGraphqlFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Log logger = LogFactory.getLog(TraceGraphqlFilter.class);

        logger.info(request.getMethod() + "=>" + request.getRequestURI());
        logger.info(request.getContentType());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
