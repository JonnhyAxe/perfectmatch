# Lab 1: Creating an OAuth 2.0/OIDC compliant Resource Server

First we need to build an OAuth2/OIDC resource server.

In this first workshop lab you will be provided a complete spring mvc web server application together
with a corresponding spring mvc thymeleaf web client app (which will come into play in [lab 2](../lab2/README.md)).  
The server application is already secured by basic authentication and also includes authorization using static roles. 

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
### Users and roles

__Important:__ We will use the following users in all subsequent labs from now on:

| Username | Email                    | Password | Role            |
| ---------| ------------------------ | -------- | --------------- |
| ckent    | clark.kent@example.com   | kent     | LIBRARY_ADMIN   |

These users are configured for authenticating using keycloak.

## Lab 1 Tutorial

Lab-1 is actually split into two parts:

1. Build a resource server with __custom user & authorities mapping__ 

#### Explore the initial application
 

Curl:
```bash
curl http://localhost:9091/library-server/books -u bruce.wayne@example.com:wayne 
```

If this succeeds you should see a list of books in JSON format.  

Also try same request without specifying any user:

```bash
http localhost:9091/library-server/books
``` 

Then you should see the following response:

```http request
HTTP/1.1 401 
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Content-Type: application/json;charset=UTF-8
WWW-Authenticate: Basic realm="Realm"
{
    "error": "Unauthorized",
    "message": "Unauthorized",
    "path": "/library-server/books",
    "status": 401,
    "timestamp": "2019-05-09T17:26:17.571+0000"
}
``` 




Spring security 5 uses the 
[OpenID Connect Discovery](https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderConfig) specification 
to completely configure the resource server to use our keycloak instance.
  

Navigate your web browser to the url [localhost:8080/auth/realms/workshop/.well-known/openid-configuration](http://localhost:8080/auth/realms/workshop/.well-known/openid-configuration).  
Then you should see the public discovery information that keycloak provides 
(like the following that only shows partial information).

```json
{
  "issuer": "http://localhost:8080/auth/realms/workshop",
  "authorization_endpoint": "http://localhost:8080/auth/realms/workshop/protocol/openid-connect/auth",
  "token_endpoint": "http://localhost:8080/auth/realms/workshop/protocol/openid-connect/token",
  "userinfo_endpoint": "http://localhost:8080/auth/realms/workshop/protocol/openid-connect/userinfo",
  "jwks_uri": "http://localhost:8080/auth/realms/workshop/protocol/openid-connect/certs"
}  
```

For configuring a resource server the important entries are _issuer_ and _jwks_uri_.  
Spring Security 5 automatically configures a resource server by just specifying the _issuer_ uri value 
as part of the predefined spring property _spring.security.oauth2.resourceserver.jwt.issuer-uri_ 

To perform this step, open _application.yml__ and add the issuer uri property. 

With this configuration in place we have already a working resource server
that can handle JWt access tokens transmitted via http bearer token header. 
Spring Security also validates by default:

* the JWT signature against the queried public key(s) from jwks_url
* the JWT _iss_ claim against the configured issuer uri
* that the JWT is not expired

Usually this configuration would be sufficient but as we also want to make sure that 
our resource server is working with stateless token authentication we have to configure stateless
sessions (i.e. prevent _JSESSION_ cookies).  

Starting with Spring Boot 2 you always have to configure Spring Security
yourself as soon as you introduce a class that extends _WebSecurityConfigurerAdapter_.

Open the class _com.example.library.server.config.WebSecurityConfiguration_ and change the
existing configuration like this:

```java
package com.example.library.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .csrf()
        .disable()
        .authorizeRequests()
        .anyRequest()
        .fullyAuthenticated()
        .and()
        .oauth2ResourceServer()
        .jwt();
  }
  
  @Bean
  PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
}
```

This configuration above...
* configures stateless sessions (i.e. no 'JSESSION' cookies an more)
* disables CSRF protection (without session cookies we do not need this any more) 
  (which also makes it possible to make post requests on the command line)
* protects any request (i.e. requires authentication)
* enables this as a resource server with expecting access tokens in JWT format

<hr>

#### Step 2: Run and test basic resource server 

Now, the requests you have tried when starting this lab using basic authentication won't work any more
as we now require bearer tokens in JWT format to authenticate at our resource server.

To do this we will use the _resource owner password grant_ to directly obtain an access token
from keycloak by specifying our credentials as part of the request.  

__You may argue now: "This is just like doing basic authentication??"__

Yes, you're right. You should __ONLY__ use this grant flow for testing purposes as it
completely bypasses the base concepts of OAuth 2.

This is how this password grant request looks like:

httpie:

curl:

```bash
curl -X POST -d 'grant_type=password&username=ckent&password=kent&client_id=library-client&client_secret=9584640c-3804-4dcd-997b-93593cfb9ea7' \
http://localhost:8080/auth/realms/workshop/protocol/openid-connect/token
```

This should return an access token together with a refresh token:

```http request
HTTP/1.1 200 OK
Content-Type: application/json

{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgO...",
    "expires_in": 300,
    "not-before-policy": 1556650611,
    "refresh_expires_in": 1800,
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCIg...",
    "scope": "profile email user",
    "session_state": "c92a82d1-8e6d-44d7-a2f3-02f621066968",
    "token_type": "bearer"
}
```

To make the same request for a list of books (like in the beginning of this lab) we have to
specify the access token as part of a _Authorization_ header of type _Bearer_ like this:

curl:

```bash
curl -H 'Authorization: Bearer [access_token]' -v http://localhost:9091/library-server/users 
```

You have to replace _[access_token]_ with the one you have obtained in previous request.  
Now you will get a _'403'_ response (_Forbidden_). 
This is due to the fact that Spring Security 5 automatically maps all scopes that are part of the
JWT token to the corresponding authorities.

Navigate your web browser to [jwt.io](https://jwt.io) and paste your access token into the
_Encoded_ text field. 

If you scroll down a bit on the right hand side then you will see the following block:

```json
{
  "scope": "library_admin email profile",
  "email_verified": true,
  "name": "Clark Kent",
  "groups": [
    "library_admin"
  ],
  "preferred_username": "ckent",
  "given_name": "Clark",
  "family_name": "Kent",
  "email": "clark.kent@example.com"
}
```
As you can see our user has the scopes _library_admin_, _email_ and _profile_.
These scopes are now mapped to the Spring Security authorities 
_SCOPE_library_admin_, _SCOPE_email_ and _SCOPE_profile_.  


If you have a look inside the _com.example.library.server.business.UserService_ class
you will notice that the corresponding method has the following authorization check:

```
@PreAuthorize("hasRole('LIBRARY_ADMIN')")
public List<User> findAll() {
  return userRepository.findAll();
}
``` 
The required authority _ROLE_LIBRARY_ADMIN_ does not match the mapped authority _SCOPE_library_admin_.
To solve this we would have to add the _SCOPE_xxx_ authorities to the existing ones like this:

```
@PreAuthorize("hasRole('LIBRARY_ADMIN') || hasAuthority('SCOPE_library_admin')")
public List<User> findAll() {
  return userRepository.findAll();
}
```  


#### Step 3: Implement a custom JWT converter 
    
To add our custom mapping for a JWT access token Spring Security requires us to implement
the interface _Converter<Jwt, AbstractAuthenticationToken>_.

In general you have two choices here:

* Map the corresponding _LibraryUser_ to the JWT token user data and read the 
  authorization data from the token and map it to Spring Security authorities


In this workshop we will use the first approach and...
 
 * ...read the authorization data from the _groups_ claim inside the JWT token
 * ...map to our local _LibraryUser_ by reusing the _LibraryUserDetailsService_ to search
   for a user having the same email as the _email_ claim inside the JWT token

To achieve this please go ahead and create a new class _LibraryUserJwtAuthenticationConverter_
in package _com.example.library.server.security_ with the following contents:

```java
package com.example.library.server.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

/** JWT converter that takes the roles from 'groups' claim of JWT token. */
@SuppressWarnings("unused")
public class LibraryUserJwtAuthenticationConverter
    implements Converter<Jwt, AbstractAuthenticationToken> {
  private static final String GROUPS_CLAIM = "groups";
  private static final String ROLE_PREFIX = "ROLE_";

  private final LibraryUserDetailsService libraryUserDetailsService;

  public LibraryUserJwtAuthenticationConverter(
      LibraryUserDetailsService libraryUserDetailsService) {
    this.libraryUserDetailsService = libraryUserDetailsService;
  }

  @Override
  public AbstractAuthenticationToken convert(Jwt jwt) {
    Collection<GrantedAuthority> authorities = extractAuthorities(jwt);
    return Optional.ofNullable(
            libraryUserDetailsService.loadUserByUsername(jwt.getClaimAsString("email")))
        .map(u -> new UsernamePasswordAuthenticationToken(u, "n/a", authorities))
        .orElseThrow(() -> new BadCredentialsException("No user found"));
  }

  private Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
    return this.getGroups(jwt).stream()
        .map(authority -> ROLE_PREFIX + authority.toUpperCase())
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
  }

  @SuppressWarnings("unchecked")
  private Collection<String> getGroups(Jwt jwt) {
    Object groups = jwt.getClaims().get(GROUPS_CLAIM);
    if (groups instanceof Collection) {
      return (Collection<String>) groups;
    }

    return Collections.emptyList();
  }
}
```

This converter maps the JWT token information to a _LibraryUser_ by associating 
these via the _email_ claim. The authorities are read from _groups_ claim in the JWT token and mapped
to the corresponding authorities.  
This way we can map these groups again to our original authorities, e.g. _ROLE_LIBRARY_ADMIN_. 

No open again the class _com.example.library.server.config.WebSecurityConfiguration_ and add this new JWT 
converter to the JWT configuration:

```java
package com.example.library.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final LibraryUserDetailsService libraryUserDetailsService;

  public WebSecurityConfiguration(LibraryUserDetailsService libraryUserDetailsService) {
    this.libraryUserDetailsService = libraryUserDetailsService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .csrf()
        .disable()
        .authorizeRequests()
        .anyRequest()
        .fullyAuthenticated()
        .and()
        .oauth2ResourceServer()
        .jwt()
        .jwtAuthenticationConverter(libraryUserJwtAuthenticationConverter());
  }
  
  @Bean
  LibraryUserJwtAuthenticationConverter libraryUserJwtAuthenticationConverter() {
    return new LibraryUserJwtAuthenticationConverter(libraryUserDetailsService);
  }
  
  @Bean
  PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
}
```

#### Step 4: Add an additional JWT validator for the 'audience' claim 

Implementing an additional token validator is quite easy, you just have to implement the 
provided interface _OAuth2TokenValidator_.

According to [OpenID Connect 1.0 specification](https://openid.net/specs/openid-connect-core-1_0.html#IDToken) the _audience_ claim 
is mandatory for ID tokens:

<blockquote cite=https://openid.net/specs/openid-connect-core-1_0.html#IDToken">
Audience(s) that this ID Token is intended for. It MUST contain the OAuth 2.0 client_id of the Relying Party as an audience value. It MAY also contain identifiers for other audiences.
</blockquote>

Despite of the fact that the _audience_ claim is not specified or mandatory for access tokens
specifying and validating the _audience_ claim of access tokens is strongly recommended by OAuth 2 & OIDC experts
to avoid misusing access tokens for other resource servers.   
There is also a new [draft specification](https://tools.ietf.org/html/draft-ietf-oauth-access-token-jwt)
on the way to provide a standardized and interoperable profile as an alternative 
to the proprietary JWT access token layouts.

So we should also validate that only those requests bearing access tokens containing the 
expected value of "library-service" in the _audience_ claim are successfully authenticated.

So let's create a new class _AudienceValidator_ in package _com.example.library.server.security_
with the following contents:

```java
package com.example.library.server.security;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

/** Validator for expected audience in access tokens. */
public class AudienceValidator implements OAuth2TokenValidator<Jwt> {

  private OAuth2Error error =
      new OAuth2Error("invalid_token", "The required audience 'library-service' is missing", null);

  public OAuth2TokenValidatorResult validate(Jwt jwt) {
    if (jwt.getAudience().contains("library-service")) {
      return OAuth2TokenValidatorResult.success();
    } else {
      return OAuth2TokenValidatorResult.failure(error);
    }
  }
}
```

Adding such validator is a bit more effort as we have to replace the auto-configured JwtDecoder
with our own bean definition. An additional validator can only be added this way.

To achieve this open again the class _com.example.library.server.config.WebSecurityConfiguration_ 
one more time and add our customized JwtDecoder.

```java
package com.example.library.server.config;

import com.example.library.server.security.AudienceValidator;
import com.example.library.server.security.LibraryUserDetailsService;
import com.example.library.server.security.LibraryUserJwtAuthenticationConverter;
import com.example.library.server.security.LibraryUserRolesJwtAuthenticationConverter;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoderJwkSupport;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final OAuth2ResourceServerProperties oAuth2ResourceServerProperties;

  private final LibraryUserDetailsService libraryUserDetailsService;

  public WebSecurityConfiguration(
      OAuth2ResourceServerProperties oAuth2ResourceServerProperties,
      LibraryUserDetailsService libraryUserDetailsService) {
    this.oAuth2ResourceServerProperties = oAuth2ResourceServerProperties;
    this.libraryUserDetailsService = libraryUserDetailsService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .csrf()
        .disable()
        .authorizeRequests()
        .anyRequest()
        .fullyAuthenticated()
        .and()
        .oauth2ResourceServer()
        .jwt()
        .jwtAuthenticationConverter(libraryUserJwtAuthenticationConverter());
  }

  @Bean
  JwtDecoder jwtDecoder() {
    NimbusJwtDecoderJwkSupport jwtDecoder =
        (NimbusJwtDecoderJwkSupport)
            JwtDecoders.fromOidcIssuerLocation(
                oAuth2ResourceServerProperties.getJwt().getIssuerUri());

    OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator();
    OAuth2TokenValidator<Jwt> withIssuer =
        JwtValidators.createDefaultWithIssuer(
            oAuth2ResourceServerProperties.getJwt().getIssuerUri());
    OAuth2TokenValidator<Jwt> withAudience =
        new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

    jwtDecoder.setJwtValidator(withAudience);

    return jwtDecoder;
  }

  @Bean
  LibraryUserJwtAuthenticationConverter libraryUserJwtAuthenticationConverter() {
    return new LibraryUserJwtAuthenticationConverter(libraryUserDetailsService);
  }
  
  @Bean
  PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }  
}
```  

Now we can re-start the application and test again the same request we had retrieved an '403' error before.

First get another fresh access token:

httpie:

```bash
http --form http://localhost:8080/auth/realms/workshop/protocol/openid-connect/token grant_type=password \
username=ckent password=kent client_id=library-client client_secret=9584640c-3804-4dcd-997b-93593cfb9ea7
``` 

curl:

```bash
curl -X POST -d 'grant_type=password&username=ckent&password=kent&client_id=library-client&client_secret=9584640c-3804-4dcd-997b-93593cfb9ea7' \
http://localhost:8080/auth/realms/workshop/protocol/openid-connect/token
```

This should return an access token together with a refresh token:

```http request
HTTP/1.1 200 OK
Content-Type: application/json

{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgO...",
    "expires_in": 300,
    "not-before-policy": 1556650611,
    "refresh_expires_in": 1800,
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCIg...",
    "scope": "profile email user",
    "session_state": "c92a82d1-8e6d-44d7-a2f3-02f621066968",
    "token_type": "bearer"
}
```

To make the same request for a list of users we have to
specify the access token as part of a _Authorization_ header of type _Bearer_ like this:

httpie:

```bash
http localhost:9091/library-server/users \
'Authorization: Bearer [access_token]'
```

curl:

```bash
curl -H 'Authorization: Bearer [access_token]' \
-v http://localhost:9091/library-server/users | jq
```

Now, with our previous changes this request should succeed with an '200' OK status and return a list of users.

# Lab 2: Creating an OAuth 2.0/OIDC compliant Client

In the second lab we want to build an OAuth2/OIDC client for the resource server we have built.


__Important Note: The client credentials grant type MUST only be used by confidential clients.__

Later in [Lab 3](../lab3/README.md) we will build almost the same OAuth2 client but in Lab 3 we will be 
using the [client credentials grant flow](https://tools.ietf.org/html/rfc6749#section-4.4) instead. 

See [Spring Security 5 OAuth 2.0 Client reference doc](https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#oauth2client) 
for all details on how to build and configure an OAuth 2.0 client. 

## The workshop application

In this second workshop lab you will be provided a complete spring mvc web client application that works
together with the [resource server of Lab 1](../lab1/library-server-complete-custom/README.md). 

![Spring IO Workshop 2019](../docs/images/demo-architecture.png)

### The client application

The client is able to fulfill most of the provided uses cases by the server application like:

* View all available books in a list
* Borrow available books
* Return my borrowed books
* Create new books

All action buttons are visible depending on user authorizations, e.g. only users with _LIBRARY_USER_ role can see
the _Borrow_ and _Return_ buttons. The _Return_

![Spring IO Workshop 2019](../docs/images/library_client.png)

### Users and Roles

There are three target user roles for this client and server application:

* LIBRARY_USER: Standard library user who can list, borrow and return his currently borrowed books
* LIBRARY_CURATOR: A curator user who can add, edit or delete books
* LIBRARY_ADMIN: An administrator user who can list, add or remove users

| Username | Email                    | Password | Role            |
| ---------| ------------------------ | -------- | --------------- |
| bwayne   | bruce.wayne@example.com  | wayne    | LIBRARY_USER    |
| bbanner  | bruce.banner@example.com | banner   | LIBRARY_USER    |
| pparker  | peter.parker@example.com | parker   | LIBRARY_CURATOR |
| ckent    | clark.kent@example.com   | kent     | LIBRARY_ADMIN   |

These users are configured for authenticating using keycloak.

We will use [Keycloak](https://keycloak.org) as identity provider.  
Please again make sure you have setup keycloak as described in [Setup Keycloak](../setup_keycloak/README.md).

### Logout Users

After you have logged in into the library client using keycloak your session will remain valid until
the access token has expired or the session at keycloak is invalidated.

As the library client does not have a logout functionality, you have to follow the following steps to actually log out 
users:

* Login to keycloak [admin console](http://localhost:8080/auth/admin) and navigate on the left to menu item _session_
  Here you'll see all user sessions (active/offline ones). By clicking on button _Logout all_ you can revocate 
  all active sessions.

![Spring IO Workshop 2019](../docs/images/keycloak_sessions.png)


* After you have revocated sessions in keycloak you have to delete the current JSESSION cookie 
  for the library client. You can do this by opening the application tab in the developer tools of chrome.
  Navigate to the cookies entry on the left and select the url of the library client, then delete the cookie 
  on the right hand side 
  
![Spring IO Workshop 2019](../docs/images/devtools_cookies.png)

Now when you refresh the library client in the browser you should be redirected again to the login page of keycloak.

## Lab 2 Tutorial

Now, let's start with lab 2. Here we will implement the required additions to get an 
OAuth2/OIDC compliant client that calls the resource server we have implemented in lab 1.

### Lab 2 Contents

In the lab 2 folder you find 2 applications:

* __library-client-initial__: This is the client application we will use as starting point for this lab
* __library-client-complete__: This client application is the completed OAuth 2.0/OIDC client for this lab 

### Implement the Client

#### Explore the initial application

First start the resource server application of Lab 1. If you could not complete the previous Lab yourself
then use and start the completed reference application 
in project [lab1/library-server-complete-custom](../lab1/library-server-complete-custom)

Then navigate your Java IDE to the lab2/library-client-initial project and at first explore this project a bit.  
Then start the application by running the class _com.example.library.client.LibraryClientInitialApplication_.

To test if the application works as expected open a web browser and 
navigate to [localhost:9090/library-client](http://localhost:9090/library-client), when 
basic authentication popup appears use 'user' and 'secret' as login credentials.

Now you should see the message 'Not authenticated' as the library client only authenticates users for the client side
using basic authentication but is not prepared to send the required bearer access token to the resource server.

Now stop the client application again. You can leave the resource server running as we will need this after we have 
finished this client.

<hr>

#### Step 1: Configure as OAuth 2/OIDC client

To change this application into an OAuth2/OIDC client you have to make changes in the dependencies 
of the gradle build file _build.gradle_:

Remove this dependency:
```groovy
implementation('org.springframework.boot:spring-boot-starter-security')
```
and add this dependency instead:
```groovy
implementation('org.springframework.boot:spring-boot-starter-oauth2-client')
```

Spring security 5 uses the 
[OpenID Connect Discovery](https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderConfig) specification 
to completely configure the client to use our keycloak instance.

For configuring an OAuth2 client the important entries are _issuer_, _authorization_endpoint_, 
_token_endpoint_, _userinfo_endpoint_ and _jwks_uri_.  
Spring Security 5 automatically configures an OAuth2 client by just specifying the _issuer_ uri value 
as part of the predefined spring property _spring.security.oauth2.client.provider.[id].issuer-uri_.

For OAuth2 clients you always have to specify the client registration (with client id, client secret, 
authorization grant type, redirect uri to your client callback and optionally the scope).
The client registration requires an OAuth2 provider. If you want to use your own provider you have to configure
at least the _issuer uri_. We want to change the default user name mapping for the user identity as well (
using the user name instead of the default value 'sub'). 

To perform this step, open _application.yml__ and add the issuer uri property with the additional ones.
Please remove the existing entry for (user.password) as we don't need this any more.
 
After adding this it should look like this:

```
```

<hr>

#### Step 2: Configure web client to send bearer access token

For all requests to the resource server we use the reactive web client, that was introduced by Spring 5.
The next required step is to make this web client aware of transmitting the required bearer access tokens
in the _Authorization_ header.

To achieve this open the class _com.example.library.client.config.WebClientConfiguration_ and reconfigure the
web client as follows:

```java

```

<hr>

#### Step 3: Configure web client authorities

Same as on resource server side we don't want to use the automatic _SCOPE_xxx_ authorities but instead want to
map again the _groups_ claim we get from the automatically called _userinfo_ endpoint to the expected _ROLE_xxx_
authorities.

To achieve this we have to extend the class _com.example.library.client.config.WebSecurityConfiguration_:

```java
package com.example.library.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .anyRequest()
        .fullyAuthenticated()
        .and()
        .oauth2Client()
        .and()
        .oauth2Login()
        .userInfoEndpoint()
        .userAuthoritiesMapper(userAuthoritiesMapper());
  }

  private GrantedAuthoritiesMapper userAuthoritiesMapper() {
    return (authorities) -> {
      Set<GrantedAuthority> mappedAuthorities = new HashSet<>();

      authorities.forEach(
          authority -> {
            if (authority instanceof OidcUserAuthority) {
              OidcUserAuthority oidcUserAuthority = (OidcUserAuthority) authority;

              OidcIdToken idToken = oidcUserAuthority.getIdToken();
              OidcUserInfo userInfo = oidcUserAuthority.getUserInfo();

              List<SimpleGrantedAuthority> groupAuthorities =
                  userInfo.getClaimAsStringList("groups").stream()
                      .map(g -> new SimpleGrantedAuthority("ROLE_" + g.toUpperCase()))
                      .collect(Collectors.toList());
              mappedAuthorities.addAll(groupAuthorities);
            }
          });

      return mappedAuthorities;
    };
  }
}
```

With the snippet

```
...
.oauth2Client()
        .and()
        .oauth2Login()
        .userInfoEndpoint()
        .userAuthoritiesMapper(userAuthoritiesMapper());
```
we configure an OAuth2 client and an OIDC login client and reconfigure the _userinfo_ endpoint user mapping
to map authorities different as the standard one. The custom mapping is done in the implementation
of the _GrantedAuthoritiesMapper_ interface that maps entries of the _groups_ claim to authority roles . 

<hr>

