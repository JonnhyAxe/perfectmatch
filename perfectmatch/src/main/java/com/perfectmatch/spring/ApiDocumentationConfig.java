package com.perfectmatch.spring;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
  info =
      @Info(
        description = "Perfect Match API for mixing in key managment tool",
        version = "V12.0.12",
        title = "Perfect Match API",
        contact = @Contact(name = "João Machado", email = "qwerty@hotmail.com"),
        license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0")
      ),
  consumes = {"application/json", "application/xml"},
  produces = {"application/json", "application/xml"},
  schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}
)
public interface ApiDocumentationConfig {}
