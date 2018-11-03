package com.perfectmatch.perfectmatch.persistence.dao.feature;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.perfectmatch.spring.PerfectMatchSetup;
import com.perfectmatch.spring.PerfectMatchWebConfig;

@Configuration
@Import({PerfectMatchWebConfig.class})
public class PerfectMatchServiceConfig {

    public PerfectMatchServiceConfig() {
        super();
    }

    @Bean 
    ServletWebServerFactory servletWebServerFactory(){
    	return new TomcatServletWebServerFactory();
    }
    
    @Bean PerfectMatchSetup perfectMatchSetup() {
    	return new PerfectMatchSetup();
    }
    
}
