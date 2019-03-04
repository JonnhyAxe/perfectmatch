# PerfectMatchControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPerfectMatchUsingPOST**](PerfectMatchControllerApi.md#createPerfectMatchUsingPOST) | **POST** /perfect_match | createPerfectMatch
[**findAllPerfectMatchsUsingGET**](PerfectMatchControllerApi.md#findAllPerfectMatchsUsingGET) | **GET** /perfect_match | Find all Perfect Matchs - without pagination
[**getPerfectMatchByNameUsingGET**](PerfectMatchControllerApi.md#getPerfectMatchByNameUsingGET) | **GET** /perfect_match/{name} | Find Match by name


<a name="createPerfectMatchUsingPOST"></a>
# **createPerfectMatchUsingPOST**
> PerfectMatch createPerfectMatchUsingPOST(resource)

createPerfectMatch

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.PerfectMatchControllerApi;


PerfectMatchControllerApi apiInstance = new PerfectMatchControllerApi();
PerfectMatch resource = new PerfectMatch(); // PerfectMatch | resource
try {
    PerfectMatch result = apiInstance.createPerfectMatchUsingPOST(resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PerfectMatchControllerApi#createPerfectMatchUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | [**PerfectMatch**](PerfectMatch.md)| resource |

### Return type

[**PerfectMatch**](PerfectMatch.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findAllPerfectMatchsUsingGET"></a>
# **findAllPerfectMatchsUsingGET**
> List&lt;PerfectMatch&gt; findAllPerfectMatchsUsingGET()

Find all Perfect Matchs - without pagination

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.PerfectMatchControllerApi;


PerfectMatchControllerApi apiInstance = new PerfectMatchControllerApi();
try {
    List<PerfectMatch> result = apiInstance.findAllPerfectMatchsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PerfectMatchControllerApi#findAllPerfectMatchsUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;PerfectMatch&gt;**](PerfectMatch.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getPerfectMatchByNameUsingGET"></a>
# **getPerfectMatchByNameUsingGET**
> PerfectMatch getPerfectMatchByNameUsingGET(name)

Find Match by name

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.PerfectMatchControllerApi;


PerfectMatchControllerApi apiInstance = new PerfectMatchControllerApi();
String name = "name_example"; // String | name
try {
    PerfectMatch result = apiInstance.getPerfectMatchByNameUsingGET(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PerfectMatchControllerApi#getPerfectMatchByNameUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| name |

### Return type

[**PerfectMatch**](PerfectMatch.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

