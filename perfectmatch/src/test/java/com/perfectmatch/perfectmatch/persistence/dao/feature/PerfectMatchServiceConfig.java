package com.perfectmatch.perfectmatch.persistence.dao.feature;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.perfectmatch.perfectmatch.persistence.dao.feature.steps.MusicDaoRepositorySteps;
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
    
    
}
