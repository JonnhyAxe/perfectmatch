# WebMvcLinksHandlerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**linksUsingGET**](WebMvcLinksHandlerApi.md#linksUsingGET) | **GET** /actuator | links


<a name="linksUsingGET"></a>
# **linksUsingGET**
> Map&lt;String, MapstringLink&gt; linksUsingGET()

links

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.WebMvcLinksHandlerApi;


WebMvcLinksHandlerApi apiInstance = new WebMvcLinksHandlerApi();
try {
    Map<String, MapstringLink> result = apiInstance.linksUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebMvcLinksHandlerApi#linksUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Map&lt;String, MapstringLink&gt;**](MapstringLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/vnd.spring-boot.actuator.v2+json

