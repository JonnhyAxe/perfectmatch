# SampleControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSampleUsingPOST**](SampleControllerApi.md#createSampleUsingPOST) | **POST** /sample | createSample
[**findAllSamplesUsingGET**](SampleControllerApi.md#findAllSamplesUsingGET) | **GET** /sample | Find all Samples - without pagination
[**getSampleByNameUsingGET**](SampleControllerApi.md#getSampleByNameUsingGET) | **GET** /sample/{name} | Find Match by name


<a name="createSampleUsingPOST"></a>
# **createSampleUsingPOST**
> Sample createSampleUsingPOST(resource)

createSample

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.SampleControllerApi;


SampleControllerApi apiInstance = new SampleControllerApi();
Sample resource = new Sample(); // Sample | resource
try {
    Sample result = apiInstance.createSampleUsingPOST(resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SampleControllerApi#createSampleUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | [**Sample**](Sample.md)| resource |

### Return type

[**Sample**](Sample.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findAllSamplesUsingGET"></a>
# **findAllSamplesUsingGET**
> List&lt;Sample&gt; findAllSamplesUsingGET()

Find all Samples - without pagination

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.SampleControllerApi;


SampleControllerApi apiInstance = new SampleControllerApi();
try {
    List<Sample> result = apiInstance.findAllSamplesUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SampleControllerApi#findAllSamplesUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Sample&gt;**](Sample.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getSampleByNameUsingGET"></a>
# **getSampleByNameUsingGET**
> Sample getSampleByNameUsingGET(name)

Find Match by name

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.SampleControllerApi;


SampleControllerApi apiInstance = new SampleControllerApi();
String name = "name_example"; // String | name
try {
    Sample result = apiInstance.getSampleByNameUsingGET(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SampleControllerApi#getSampleByNameUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| name |

### Return type

[**Sample**](Sample.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

