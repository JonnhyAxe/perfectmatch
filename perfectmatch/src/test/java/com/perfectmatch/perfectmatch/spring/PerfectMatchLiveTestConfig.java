package com.perfectmatch.perfectmatch.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.perfectmatch.spring.PerfectMatchPersistenceJpaConfig;
import com.perfectmatch.spring.PerfectMatchServletConfig;


/**
 *
 */
@Configuration
@Import({ PerfectMatchPersistenceJpaConfig.class, PerfectMatchWebConfig.class, PerfectMatchServletConfig.class })
public class PerfectMatchLiveTestConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {

        final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        return pspc;
    }

}
