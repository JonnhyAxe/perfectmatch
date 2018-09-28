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
 * links
 * request: linksUsingGET
 * url: linksUsingGETURL
 * method: linksUsingGET_TYPE
 * raw_url: linksUsingGET_RAW_URL
 */
export const linksUsingGET = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/actuator'
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
export const linksUsingGET_RAW_URL = function() {
  return '/actuator'
}
export const linksUsingGET_TYPE = function() {
  return 'get'
}
export const linksUsingGETURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/actuator'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * handle
 * request: handleUsingGET
 * url: handleUsingGETURL
 * method: handleUsingGET_TYPE
 * raw_url: handleUsingGET_RAW_URL
 * @param body - body
 */
export const handleUsingGET = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/actuator/health'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters['body'] !== undefined) {
    body = parameters['body']
  }
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('get', domain + path, body, queryParameters, form, config)
}
export const handleUsingGET_RAW_URL = function() {
  return '/actuator/health'
}
export const handleUsingGET_TYPE = function() {
  return 'get'
}
export const handleUsingGETURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/actuator/health'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * handle
 * request: handleUsingGET_1
 * url: handleUsingGET_1URL
 * method: handleUsingGET_1_TYPE
 * raw_url: handleUsingGET_1_RAW_URL
 * @param body - body
 */
export const handleUsingGET_1 = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/actuator/info'
  let body
  let queryParameters = {}
  let form = {}
  if (parameters['body'] !== undefined) {
    body = parameters['body']
  }
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    });
  }
  return request('get', domain + path, body, queryParameters, form, config)
}
export const handleUsingGET_1_RAW_URL = function() {
  return '/actuator/info'
}
export const handleUsingGET_1_TYPE = function() {
  return 'get'
}
export const handleUsingGET_1URL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/actuator/info'
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
 * Find all Matchs - without pagination
 * request: findAllMatchsUsingGET
 * url: findAllMatchsUsingGETURL
 * method: findAllMatchsUsingGET_TYPE
 * raw_url: findAllMatchsUsingGET_RAW_URL
 */
export const findAllMatchsUsingGET = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/match'
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
export const findAllMatchsUsingGET_RAW_URL = function() {
  return '/match'
}
export const findAllMatchsUsingGET_TYPE = function() {
  return 'get'
}
export const findAllMatchsUsingGETURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/match'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}
/**
 * Find all musics - without pagination
 * request: getAllMusicsUsingGET
 * url: getAllMusicsUsingGETURL
 * method: getAllMusicsUsingGET_TYPE
 * raw_url: getAllMusicsUsingGET_RAW_URL
 */
export const getAllMusicsUsingGET = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/music'
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
export const getAllMusicsUsingGET_RAW_URL = function() {
  return '/music'
}
export const getAllMusicsUsingGET_TYPE = function() {
  return 'get'
}
export const getAllMusicsUsingGETURL = function(parameters = {}) {
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
 * createMusic
 * request: createMusicUsingPOST
 * url: createMusicUsingPOSTURL
 * method: createMusicUsingPOST_TYPE
 * raw_url: createMusicUsingPOST_RAW_URL
 * @param resource - resource
 */
export const createMusicUsingPOST = function(parameters = {}) {
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
export const createMusicUsingPOST_RAW_URL = function() {
  return '/music'
}
export const createMusicUsingPOST_TYPE = function() {
  return 'post'
}
export const createMusicUsingPOSTURL = function(parameters = {}) {
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
 * Find Music by name
 * request: getMusicByNameUsingGET
 * url: getMusicByNameUsingGETURL
 * method: getMusicByNameUsingGET_TYPE
 * raw_url: getMusicByNameUsingGET_RAW_URL
 * @param name - name
 */
export const getMusicByNameUsingGET = function(parameters = {}) {
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
export const getMusicByNameUsingGET_RAW_URL = function() {
  return '/music/{name}'
}
export const getMusicByNameUsingGET_TYPE = function() {
  return 'get'
}
export const getMusicByNameUsingGETURL = function(parameters = {}) {
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
 * Find all Samples - without pagination
 * request: findAllSamplesUsingGET
 * url: findAllSamplesUsingGETURL
 * method: findAllSamplesUsingGET_TYPE
 * raw_url: findAllSamplesUsingGET_RAW_URL
 */
export const findAllSamplesUsingGET = function(parameters = {}) {
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  const config = parameters.$config
  let path = '/sample'
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
export const findAllSamplesUsingGET_RAW_URL = function() {
  return '/sample'
}
export const findAllSamplesUsingGET_TYPE = function() {
  return 'get'
}
export const findAllSamplesUsingGETURL = function(parameters = {}) {
  let queryParameters = {}
  const domain = parameters.$domain ? parameters.$domain : getDomain()
  let path = '/sample'
  if (parameters.$queryParameters) {
    Object.keys(parameters.$queryParameters).forEach(function(parameterName) {
      queryParameters[parameterName] = parameters.$queryParameters[parameterName]
    })
  }
  let keys = Object.keys(queryParameters)
  return domain + path + (keys.length > 0 ? '?' + (keys.map(key => key + '=' + encodeURIComponent(queryParameters[key])).join('&')) : '')
}