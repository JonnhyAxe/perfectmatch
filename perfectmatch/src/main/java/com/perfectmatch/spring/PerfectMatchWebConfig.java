package com.perfectmatch.spring;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.swagger.models.auth.In;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 */
@Configuration
@ComponentScan({"com.perfectmatch.web"})
@EnableSwagger2
public class PerfectMatchWebConfig extends WebMvcConfigurationSupport {

  private static final String AUTH_SERVER = null;
  private static final String CLIENT_ID = null;
  private static final String CLIENT_SECRET = null;

  @Bean
  public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {

    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    jsonConverter.setObjectMapper(objectMapper);
    return jsonConverter;
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    converters.add(customJackson2HttpMessageConverter());
    super.addDefaultHttpMessageConverters(converters);
  }

  @Bean // Enabling and configuring Swagger
  public Docket mainConfig() { // @formatter:off

    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .pathMapping("/")
        .directModelSubstitute(LocalDate.class, String.class)
        .genericModelSubstitutes(ResponseEntity.class) // The model
      
        .securitySchemes(Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
        .securityContexts(Arrays.asList(securityContext()));
    // data rather
    // Spring
    // specific
    // artifacts
  } // @formatter:on

  //

  private SecurityScheme securityScheme() {
    GrantType grantType =
        new AuthorizationCodeGrantBuilder()
            .tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
            .tokenRequestEndpoint(
                new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_SECRET))
            .build();

    SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
        .grantTypes(Arrays.asList(grantType)).scopes(Arrays.asList(scopes())).build();
    return oauth;
  }

  private AuthorizationScope[] scopes() {
    AuthorizationScope[] scopes = {new AuthorizationScope("read", "for read operations"),
        new AuthorizationScope("write", "for write operations"),
        new AuthorizationScope("foo", "Access foo API")};
    return scopes;
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder().securityReferences(defaultAuth())
        .forPaths(PathSelectors.ant("/artist/**")).build();
  }

  List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("ADMIN", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Arrays.asList(new SecurityReference("Token Access", authorizationScopes));
  }

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {

    registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
    registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/META-INF/resources/index.html");
    registry.addResourceHandler("/static/**")
        .addResourceLocations("classpath:/META-INF/resources/static/");
    registry.addResourceHandler("/")
        .addResourceLocations("classpath:/META-INF/resources/index.html");
  }

  @Bean
  public FilterRegistrationBean<Filter> someFilterRegistration() {

    final FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
    registration.setFilter(etagFilter());
    registration.addUrlPatterns("/*");
    registration.setName("etagFilter");
    registration.setOrder(1);
    return registration;
  }

  @Bean(name = "etagFilter")
  public Filter etagFilter() {

    return new ShallowEtagHeaderFilter();
  }
}
