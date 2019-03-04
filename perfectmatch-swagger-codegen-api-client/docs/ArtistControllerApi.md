# ArtistControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createArtistUsingPOST**](ArtistControllerApi.md#createArtistUsingPOST) | **POST** /artist | createArtist
[**deleteArtistByNameUsingDELETE**](ArtistControllerApi.md#deleteArtistByNameUsingDELETE) | **DELETE** /artist/{name} | deleteArtistByName
[**getArtistByIdUsingGET**](ArtistControllerApi.md#getArtistByIdUsingGET) | **GET** /artist/id/{id} | getArtistById
[**getArtistByNameUsingGET**](ArtistControllerApi.md#getArtistByNameUsingGET) | **GET** /artist/{name} | getArtistByName


<a name="createArtistUsingPOST"></a>
# **createArtistUsingPOST**
> Artist createArtistUsingPOST(artist)

createArtist

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.ArtistControllerApi;


ArtistControllerApi apiInstance = new ArtistControllerApi();
Artist artist = new Artist(); // Artist | artist
try {
    Artist result = apiInstance.createArtistUsingPOST(artist);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ArtistControllerApi#createArtistUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **artist** | [**Artist**](Artist.md)| artist |

### Return type

[**Artist**](Artist.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteArtistByNameUsingDELETE"></a>
# **deleteArtistByNameUsingDELETE**
> Artist deleteArtistByNameUsingDELETE(name)

deleteArtistByName

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.ArtistControllerApi;


ArtistControllerApi apiInstance = new ArtistControllerApi();
String name = "name_example"; // String | name
try {
    Artist result = apiInstance.deleteArtistByNameUsingDELETE(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ArtistControllerApi#deleteArtistByNameUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| name |

### Return type

[**Artist**](Artist.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getArtistByIdUsingGET"></a>
# **getArtistByIdUsingGET**
> Artist getArtistByIdUsingGET(id)

getArtistById

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.ArtistControllerApi;


ArtistControllerApi apiInstance = new ArtistControllerApi();
String id = "id_example"; // String | id
try {
    Artist result = apiInstance.getArtistByIdUsingGET(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ArtistControllerApi#getArtistByIdUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id |

### Return type

[**Artist**](Artist.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getArtistByNameUsingGET"></a>
# **getArtistByNameUsingGET**
> Artist getArtistByNameUsingGET(name)

getArtistByName

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.ArtistControllerApi;


ArtistControllerApi apiInstance = new ArtistControllerApi();
String name = "name_example"; // String | name
try {
    Artist result = apiInstance.getArtistByNameUsingGET(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ArtistControllerApi#getArtistByNameUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| name |

### Return type

[**Artist**](Artist.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

