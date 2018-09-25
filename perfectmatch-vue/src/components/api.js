/* eslint-disable */
import axios from 'axios'
import qs from 'qs'
let domain = ''
let axiosInstance = axios.create()
export const getDomain = () => {
  return domain
}
export const setDomain = ($domain) => {
  domain = $domain
}
export const getAxiosInstance = () => {
  return axiosInstance
}
export const setAxiosInstance = ($axiosInstance) => {
  axiosInstance = $axiosInstance
}
export const request = (method, url, body, queryParameters, form, config) => {
  method = method.toLowerCase()
  let keys = Object.keys(queryParameters)
  let queryUrl = url
  if (keys.length > 0) {
    queryUrl = url + '?' + qs.stringify(queryParameters)
  }
  // let queryUrl = url+(keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
  if (body) {
    return axiosInstance[method](queryUrl, body, config)
  } else if (method === 'get' || method === 'delete' || method === 'head' || method === 'option') {
    return axiosInstance[method](queryUrl, config)
  } else {
    return axiosInstance[method](queryUrl, qs.stringify(form), config)
  }
}
/*==========================================================
 *                    Api Documentation
 ==========================================================*/
/**
 * error
 * request: errorUsingGET
 * url: errorUsingGETURL
 * method: errorUsingGET_TYPE
 * raw_url: errorUsingGET_RAW_URL
 */
export const errorUsingGET = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/error'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('get', domain + path, body, queryParameters, form, config)
}
export const errorUsingGET_RAW_URL = function() {
  return '/error'
}
export const errorUsingGET_TYPE = function() {
  return 'get'
}
export const errorUsingGETURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/error'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * error
 * request: errorUsingHEAD
 * url: errorUsingHEADURL
 * method: errorUsingHEAD_TYPE
 * raw_url: errorUsingHEAD_RAW_URL
 */
export const errorUsingHEAD = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/error'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('head', domain + path, body, queryParameters, form, config)
}
export const errorUsingHEAD_RAW_URL = function() {
  return '/error'
}
export const errorUsingHEAD_TYPE = function() {
  return 'head'
}
export const errorUsingHEADURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/error'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * error
 * request: errorUsingPOST
 * url: errorUsingPOSTURL
 * method: errorUsingPOST_TYPE
 * raw_url: errorUsingPOST_RAW_URL
 */
export const errorUsingPOST = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/error'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('post', domain + path, body, queryParameters, form, config)
}
export const errorUsingPOST_RAW_URL = function() {
  return '/error'
}
export const errorUsingPOST_TYPE = function() {
  return 'post'
}
export const errorUsingPOSTURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/error'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * error
 * request: errorUsingPUT
 * url: errorUsingPUTURL
 * method: errorUsingPUT_TYPE
 * raw_url: errorUsingPUT_RAW_URL
 */
export const errorUsingPUT = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/error'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('put', domain + path, body, queryParameters, form, config)
}
export const errorUsingPUT_RAW_URL = function() {
  return '/error'
}
export const errorUsingPUT_TYPE = function() {
  return 'put'
}
export const errorUsingPUTURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/error'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * error
 * request: errorUsingDELETE
 * url: errorUsingDELETEURL
 * method: errorUsingDELETE_TYPE
 * raw_url: errorUsingDELETE_RAW_URL
 */
export const errorUsingDELETE = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/error'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('delete', domain + path, body, queryParameters, form, config)
}
export const errorUsingDELETE_RAW_URL = function() {
  return '/error'
}
export const errorUsingDELETE_TYPE = function() {
  return 'delete'
}
export const errorUsingDELETEURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/error'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * error
 * request: errorUsingOPTIONS
 * url: errorUsingOPTIONSURL
 * method: errorUsingOPTIONS_TYPE
 * raw_url: errorUsingOPTIONS_RAW_URL
 */
export const errorUsingOPTIONS = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/error'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('options', domain + path, body, queryParameters, form, config)
}
export const errorUsingOPTIONS_RAW_URL = function() {
  return '/error'
}
export const errorUsingOPTIONS_TYPE = function() {
  return 'options'
}
export const errorUsingOPTIONSURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/error'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * error
 * request: errorUsingPATCH
 * url: errorUsingPATCHURL
 * method: errorUsingPATCH_TYPE
 * raw_url: errorUsingPATCH_RAW_URL
 */
export const errorUsingPATCH = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/error'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('patch', domain + path, body, queryParameters, form, config)
}
export const errorUsingPATCH_RAW_URL = function() {
  return '/error'
}
export const errorUsingPATCH_TYPE = function() {
  return 'patch'
}
export const errorUsingPATCHURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/error'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * findByRepo
 * request: findByRepoUsingGET
 * url: findByRepoUsingGETURL
 * method: findByRepoUsingGET_TYPE
 * raw_url: findByRepoUsingGET_RAW_URL
 */
export const findByRepoUsingGET = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/match/repo'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('get', domain + path, body, queryParameters, form, config)
}
export const findByRepoUsingGET_RAW_URL = function() {
  return '/match/repo'
}
export const findByRepoUsingGET_TYPE = function() {
  return 'get'
}
export const findByRepoUsingGETURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/match/repo'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * create
 * request: createUsingPOST
 * url: createUsingPOSTURL
 * method: createUsingPOST_TYPE
 * raw_url: createUsingPOST_RAW_URL
 * @param resource - resource
 */
export const createUsingPOST = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/music'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters['resource'] !== undefined) {
    body = parameters['resource']
  }
  if (parameters['resource'] === undefined) {
    return Promise.reject(new Error('Missing required  parameter: resource'))
  }
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('post', domain + path, body, queryParameters, form, config)
}
export const createUsingPOST_RAW_URL = function() {
  return '/music'
}
export const createUsingPOST_TYPE = function() {
  return 'post'
}
export const createUsingPOSTURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/music'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * findByRepo
 * request: findByRepoUsingGET_1
 * url: findByRepoUsingGET_1URL
 * method: findByRepoUsingGET_1_TYPE
 * raw_url: findByRepoUsingGET_1_RAW_URL
 */
export const findByRepoUsingGET_1 = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/music/repo'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('get', domain + path, body, queryParameters, form, config)
}
export const findByRepoUsingGET_1_RAW_URL = function() {
  return '/music/repo'
}
export const findByRepoUsingGET_1_TYPE = function() {
  return 'get'
}
export const findByRepoUsingGET_1URL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/music/repo'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * findByName
 * request: findByNameUsingGET
 * url: findByNameUsingGETURL
 * method: findByNameUsingGET_TYPE
 * raw_url: findByNameUsingGET_RAW_URL
 * @param name - musicName
 */
export const findByNameUsingGET = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/music/{name}'
  let body
  let queryParameters = {}
  let form = {}
  path = path.replace('{name}', `${parameters['name']}`)
  if (parameters['name'] === undefined) {
    return Promise.reject(new Error('Missing required  parameter: name'))
  }
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('get', domain + path, body, queryParameters, form, config)
}
export const findByNameUsingGET_RAW_URL = function() {
  return '/music/{name}'
}
export const findByNameUsingGET_TYPE = function() {
  return 'get'
}
export const findByNameUsingGETURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/music/{name}'
  path = path.replace('{name}', `${parameters['name']}`)
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * findByRepo
 * request: findByRepoUsingGET_2
 * url: findByRepoUsingGET_2URL
 * method: findByRepoUsingGET_2_TYPE
 * raw_url: findByRepoUsingGET_2_RAW_URL
 */
export const findByRepoUsingGET_2 = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/sample/repo'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('get', domain + path, body, queryParameters, form, config)
}
export const findByRepoUsingGET_2_RAW_URL = function() {
  return '/sample/repo'
}
export const findByRepoUsingGET_2_TYPE = function() {
  return 'get'
}
export const findByRepoUsingGET_2URL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/sample/repo'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}