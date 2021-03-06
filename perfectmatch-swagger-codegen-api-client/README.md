# spring-swagger-codegen-api-client

Api Documentation
- API version: 1.0
  - Build date: 2019-03-04T00:50:30.218Z

Api Documentation


*Automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.baeldung</groupId>
  <artifactId>spring-swagger-codegen-api-client</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.baeldung:spring-swagger-codegen-api-client:0.0.1-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/spring-swagger-codegen-api-client-0.0.1-SNAPSHOT.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.perfectmatch.web.client.invoker.*;
import com.perfectmatch.web.client.invoker.auth.*;
import com.perfectmatch.web.client.model.*;
import com.perfectmatch.web.client.api.ArtistControllerApi;

import java.io.File;
import java.util.*;

public class ArtistControllerApiExample {

    public static void main(String[] args) {
        
        ArtistControllerApi apiInstance = new ArtistControllerApi();
        Artist artist = new Artist(); // Artist | artist
        try {
            Artist result = apiInstance.createArtistUsingPOST(artist);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ArtistControllerApi#createArtistUsingPOST");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ArtistControllerApi* | [**createArtistUsingPOST**](docs/ArtistControllerApi.md#createArtistUsingPOST) | **POST** /artist | createArtist
*ArtistControllerApi* | [**deleteArtistByNameUsingDELETE**](docs/ArtistControllerApi.md#deleteArtistByNameUsingDELETE) | **DELETE** /artist/{name} | deleteArtistByName
*ArtistControllerApi* | [**getArtistByIdUsingGET**](docs/ArtistControllerApi.md#getArtistByIdUsingGET) | **GET** /artist/id/{id} | getArtistById
*ArtistControllerApi* | [**getArtistByNameUsingGET**](docs/ArtistControllerApi.md#getArtistByNameUsingGET) | **GET** /artist/{name} | getArtistByName
*BasicErrorControllerApi* | [**errorHtmlUsingDELETE**](docs/BasicErrorControllerApi.md#errorHtmlUsingDELETE) | **DELETE** /error | errorHtml
*BasicErrorControllerApi* | [**errorHtmlUsingGET**](docs/BasicErrorControllerApi.md#errorHtmlUsingGET) | **GET** /error | errorHtml
*BasicErrorControllerApi* | [**errorHtmlUsingHEAD**](docs/BasicErrorControllerApi.md#errorHtmlUsingHEAD) | **HEAD** /error | errorHtml
*BasicErrorControllerApi* | [**errorHtmlUsingOPTIONS**](docs/BasicErrorControllerApi.md#errorHtmlUsingOPTIONS) | **OPTIONS** /error | errorHtml
*BasicErrorControllerApi* | [**errorHtmlUsingPATCH**](docs/BasicErrorControllerApi.md#errorHtmlUsingPATCH) | **PATCH** /error | errorHtml
*BasicErrorControllerApi* | [**errorHtmlUsingPOST**](docs/BasicErrorControllerApi.md#errorHtmlUsingPOST) | **POST** /error | errorHtml
*BasicErrorControllerApi* | [**errorHtmlUsingPUT**](docs/BasicErrorControllerApi.md#errorHtmlUsingPUT) | **PUT** /error | errorHtml
*MatchControllerApi* | [**createMatchUsingPOST**](docs/MatchControllerApi.md#createMatchUsingPOST) | **POST** /match | createMatch
*MatchControllerApi* | [**findAllMatchByMusicUsingGET**](docs/MatchControllerApi.md#findAllMatchByMusicUsingGET) | **GET** /match/{music} | Find all Matchs by music name - without pagination
*MatchControllerApi* | [**findAllMatchsUsingGET**](docs/MatchControllerApi.md#findAllMatchsUsingGET) | **GET** /match | Find all Matchs - without pagination
*MatchControllerApi* | [**findMatchByMusicPairUsingGET**](docs/MatchControllerApi.md#findMatchByMusicPairUsingGET) | **GET** /match/{music}/{music2} | Find Match by music pair - without pagination
*MusicControllerApi* | [**createMusicUsingPOST**](docs/MusicControllerApi.md#createMusicUsingPOST) | **POST** /music | createMusic
*MusicControllerApi* | [**getAllMusicsUsingGET**](docs/MusicControllerApi.md#getAllMusicsUsingGET) | **GET** /music | Find all musics - without pagination
*MusicControllerApi* | [**getMusicByNameUsingGET**](docs/MusicControllerApi.md#getMusicByNameUsingGET) | **GET** /music/{name} | Find Music by name
*MusicControllerApi* | [**updateMusicUsingPUT**](docs/MusicControllerApi.md#updateMusicUsingPUT) | **PUT** /music | updateMusic
*OperationHandlerApi* | [**handleUsingGET**](docs/OperationHandlerApi.md#handleUsingGET) | **GET** /actuator/health/{component}/{instance} | handle
*OperationHandlerApi* | [**handleUsingGET1**](docs/OperationHandlerApi.md#handleUsingGET1) | **GET** /actuator/health/{component} | handle
*OperationHandlerApi* | [**handleUsingGET2**](docs/OperationHandlerApi.md#handleUsingGET2) | **GET** /actuator/health | handle
*OperationHandlerApi* | [**handleUsingGET3**](docs/OperationHandlerApi.md#handleUsingGET3) | **GET** /actuator/info | handle
*PerfectMatchControllerApi* | [**createPerfectMatchUsingPOST**](docs/PerfectMatchControllerApi.md#createPerfectMatchUsingPOST) | **POST** /perfect_match | createPerfectMatch
*PerfectMatchControllerApi* | [**findAllPerfectMatchsUsingGET**](docs/PerfectMatchControllerApi.md#findAllPerfectMatchsUsingGET) | **GET** /perfect_match | Find all Perfect Matchs - without pagination
*PerfectMatchControllerApi* | [**getPerfectMatchByNameUsingGET**](docs/PerfectMatchControllerApi.md#getPerfectMatchByNameUsingGET) | **GET** /perfect_match/{name} | Find Match by name
*SampleControllerApi* | [**createSampleUsingPOST**](docs/SampleControllerApi.md#createSampleUsingPOST) | **POST** /sample | createSample
*SampleControllerApi* | [**findAllSamplesUsingGET**](docs/SampleControllerApi.md#findAllSamplesUsingGET) | **GET** /sample | Find all Samples - without pagination
*SampleControllerApi* | [**getSampleByNameUsingGET**](docs/SampleControllerApi.md#getSampleByNameUsingGET) | **GET** /sample/{name} | Find Match by name
*WebMvcLinksHandlerApi* | [**linksUsingGET**](docs/WebMvcLinksHandlerApi.md#linksUsingGET) | **GET** /actuator | links


## Documentation for Models

 - [Artist](docs/Artist.md)
 - [Link](docs/Link.md)
 - [MapstringLink](docs/MapstringLink.md)
 - [Match](docs/Match.md)
 - [ModelAndView](docs/ModelAndView.md)
 - [Music](docs/Music.md)
 - [PerfectMatch](docs/PerfectMatch.md)
 - [Sample](docs/Sample.md)
 - [URL](docs/URL.md)
 - [URLStreamHandler](docs/URLStreamHandler.md)
 - [View](docs/View.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



