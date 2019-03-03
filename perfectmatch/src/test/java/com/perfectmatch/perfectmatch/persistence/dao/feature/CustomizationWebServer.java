package com.perfectmatch.perfectmatch.persistence.dao.feature;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

//@Component
public class CustomizationWebServer implements
  WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
  
    @Override
    public void customize(ConfigurableServletWebServerFactory container) {
//        container.setPort(8083);
        container.setSsl(null);
    }
}