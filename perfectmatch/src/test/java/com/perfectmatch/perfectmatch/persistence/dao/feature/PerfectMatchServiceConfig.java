package com.perfectmatch.perfectmatch.persistence.dao.feature;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.perfectmatch.spring.PerfectMatchSecurityConfig;
import com.perfectmatch.spring.PerfectMatchServletConfig;
import com.perfectmatch.spring.PerfectMatchSetup;
import com.perfectmatch.spring.PerfectMatchWebConfig;
import com.perfectmatch.web.services.AdderService;

@Configuration
@Import({PerfectMatchWebConfig.class, 
	AdderService.class, 
	PerfectMatchSecurityConfig.class, 
	PerfectMatchServletConfig.class,
	PerfectMatchSetup.class })
public class PerfectMatchServiceConfig {

  public PerfectMatchServiceConfig() {
    super();
  }

  
}
