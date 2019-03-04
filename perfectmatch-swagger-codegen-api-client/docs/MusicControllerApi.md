# MusicControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createMusicUsingPOST**](MusicControllerApi.md#createMusicUsingPOST) | **POST** /music | createMusic
[**getAllMusicsUsingGET**](MusicControllerApi.md#getAllMusicsUsingGET) | **GET** /music | Find all musics - without pagination
[**getMusicByNameUsingGET**](MusicControllerApi.md#getMusicByNameUsingGET) | **GET** /music/{name} | Find Music by name
[**updateMusicUsingPUT**](MusicControllerApi.md#updateMusicUsingPUT) | **PUT** /music | updateMusic


<a name="createMusicUsingPOST"></a>
# **createMusicUsingPOST**
> Music createMusicUsingPOST(resource)

createMusic

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.MusicControllerApi;


MusicControllerApi apiInstance = new MusicControllerApi();
Music resource = new Music(); // Music | resource
try {
    Music result = apiInstance.createMusicUsingPOST(resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MusicControllerApi#createMusicUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | [**Music**](Music.md)| resource |

### Return type

[**Music**](Music.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getAllMusicsUsingGET"></a>
# **getAllMusicsUsingGET**
> List&lt;Music&gt; getAllMusicsUsingGET()

Find all musics - without pagination

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.MusicControllerApi;


MusicControllerApi apiInstance = new MusicControllerApi();
try {
    List<Music> result = apiInstance.getAllMusicsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MusicControllerApi#getAllMusicsUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Music&gt;**](Music.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getMusicByNameUsingGET"></a>
# **getMusicByNameUsingGET**
> Music getMusicByNameUsingGET(name)

Find Music by name

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.MusicControllerApi;


MusicControllerApi apiInstance = new MusicControllerApi();
String name = "name_example"; // String | name
try {
    Music result = apiInstance.getMusicByNameUsingGET(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MusicControllerApi#getMusicByNameUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| name |

### Return type

[**Music**](Music.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="updateMusicUsingPUT"></a>
# **updateMusicUsingPUT**
> Music updateMusicUsingPUT(resource)

updateMusic

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.MusicControllerApi;


MusicControllerApi apiInstance = new MusicControllerApi();
Music resource = new Music(); // Music | resource
try {
    Music result = apiInstance.updateMusicUsingPUT(resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MusicControllerApi#updateMusicUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | [**Music**](Music.md)| resource |

### Return type

[**Music**](Music.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

