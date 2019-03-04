# OperationHandlerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**handleUsingGET**](OperationHandlerApi.md#handleUsingGET) | **GET** /actuator/health/{component}/{instance} | handle
[**handleUsingGET1**](OperationHandlerApi.md#handleUsingGET1) | **GET** /actuator/health/{component} | handle
[**handleUsingGET2**](OperationHandlerApi.md#handleUsingGET2) | **GET** /actuator/health | handle
[**handleUsingGET3**](OperationHandlerApi.md#handleUsingGET3) | **GET** /actuator/info | handle


<a name="handleUsingGET"></a>
# **handleUsingGET**
> Object handleUsingGET(body)

handle

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.OperationHandlerApi;


OperationHandlerApi apiInstance = new OperationHandlerApi();
Object body = null; // Object | body
try {
    Object result = apiInstance.handleUsingGET(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OperationHandlerApi#handleUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **Object**| body | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/vnd.spring-boot.actuator.v2+json

<a name="handleUsingGET1"></a>
# **handleUsingGET1**
> Object handleUsingGET1(body)

handle

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.OperationHandlerApi;


OperationHandlerApi apiInstance = new OperationHandlerApi();
Object body = null; // Object | body
try {
    Object result = apiInstance.handleUsingGET1(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OperationHandlerApi#handleUsingGET1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **Object**| body | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/vnd.spring-boot.actuator.v2+json

<a name="handleUsingGET2"></a>
# **handleUsingGET2**
> Object handleUsingGET2(body)

handle

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.OperationHandlerApi;


OperationHandlerApi apiInstance = new OperationHandlerApi();
Object body = null; // Object | body
try {
    Object result = apiInstance.handleUsingGET2(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OperationHandlerApi#handleUsingGET2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **Object**| body | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/vnd.spring-boot.actuator.v2+json

<a name="handleUsingGET3"></a>
# **handleUsingGET3**
> Object handleUsingGET3(body)

handle

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.OperationHandlerApi;


OperationHandlerApi apiInstance = new OperationHandlerApi();
Object body = null; // Object | body
try {
    Object result = apiInstance.handleUsingGET3(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OperationHandlerApi#handleUsingGET3");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **Object**| body | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/vnd.spring-boot.actuator.v2+json

