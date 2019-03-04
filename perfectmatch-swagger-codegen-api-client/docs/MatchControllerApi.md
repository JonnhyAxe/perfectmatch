# MatchControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createMatchUsingPOST**](MatchControllerApi.md#createMatchUsingPOST) | **POST** /match | createMatch
[**findAllMatchByMusicUsingGET**](MatchControllerApi.md#findAllMatchByMusicUsingGET) | **GET** /match/{music} | Find all Matchs by music name - without pagination
[**findAllMatchsUsingGET**](MatchControllerApi.md#findAllMatchsUsingGET) | **GET** /match | Find all Matchs - without pagination
[**findMatchByMusicPairUsingGET**](MatchControllerApi.md#findMatchByMusicPairUsingGET) | **GET** /match/{music}/{music2} | Find Match by music pair - without pagination


<a name="createMatchUsingPOST"></a>
# **createMatchUsingPOST**
> Match createMatchUsingPOST(resource)

createMatch

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.MatchControllerApi;


MatchControllerApi apiInstance = new MatchControllerApi();
Match resource = new Match(); // Match | resource
try {
    Match result = apiInstance.createMatchUsingPOST(resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MatchControllerApi#createMatchUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | [**Match**](Match.md)| resource |

### Return type

[**Match**](Match.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findAllMatchByMusicUsingGET"></a>
# **findAllMatchByMusicUsingGET**
> List&lt;Match&gt; findAllMatchByMusicUsingGET(music)

Find all Matchs by music name - without pagination

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.MatchControllerApi;


MatchControllerApi apiInstance = new MatchControllerApi();
String music = "music_example"; // String | music
try {
    List<Match> result = apiInstance.findAllMatchByMusicUsingGET(music);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MatchControllerApi#findAllMatchByMusicUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **music** | **String**| music |

### Return type

[**List&lt;Match&gt;**](Match.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findAllMatchsUsingGET"></a>
# **findAllMatchsUsingGET**
> List&lt;Match&gt; findAllMatchsUsingGET()

Find all Matchs - without pagination

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.MatchControllerApi;


MatchControllerApi apiInstance = new MatchControllerApi();
try {
    List<Match> result = apiInstance.findAllMatchsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MatchControllerApi#findAllMatchsUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Match&gt;**](Match.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findMatchByMusicPairUsingGET"></a>
# **findMatchByMusicPairUsingGET**
> Match findMatchByMusicPairUsingGET(music, music2)

Find Match by music pair - without pagination

### Example
```java
// Import classes:
//import com.perfectmatch.web.client.invoker.ApiException;
//import com.perfectmatch.web.client.api.MatchControllerApi;


MatchControllerApi apiInstance = new MatchControllerApi();
String music = "music_example"; // String | music
String music2 = "music2_example"; // String | music2
try {
    Match result = apiInstance.findMatchByMusicPairUsingGET(music, music2);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MatchControllerApi#findMatchByMusicPairUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **music** | **String**| music |
 **music2** | **String**| music2 |

### Return type

[**Match**](Match.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

