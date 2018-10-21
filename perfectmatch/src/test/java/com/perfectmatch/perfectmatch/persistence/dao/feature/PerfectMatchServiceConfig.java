package com.perfectmatch.perfectmatch.persistence.dao.feature;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.perfectmatch.web.services.MusicService;
import com.perfectmatch.web.services.SampleMatchService;
import com.perfectmatch.web.services.SampleService;
import com.perfectmatch.web.services.impl.MusicServiceBean;
import com.perfectmatch.web.services.impl.SampleMatchServiceBean;
import com.perfectmatch.web.services.impl.SampleServiceBean;

@Configuration
public class PerfectMatchServiceConfig {

    public PerfectMatchServiceConfig() {
        super();
    }

    // beans

    @Bean
    public MusicService musicServiceBean() {
        return new MusicServiceBean();
    }
    
    @Bean
    public SampleMatchService sampleMatchService() {
        return new SampleMatchServiceBean();
    }
    
    @Bean
    public SampleService SampleService() {
        return new SampleServiceBean();
    }

}
