package com.graphqljava.tutorial.bookdetails.core;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author unknow
 */
@Configuration
public class AutoConfigration {

    /**
     * 这个在最前面，保证接口的存在
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean apiExistFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TraceGraphqlFilter());
        registration.addUrlPatterns("/*");
        registration.setName("apiExistFilterRegistration_2020_4_10");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
