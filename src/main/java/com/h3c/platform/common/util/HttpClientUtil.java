package com.h3c.platform.common.util;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class HttpClientUtil {

	// utf-8字符编码
	public static final String CHARSET_UTF_8 = "utf-8";

	// HTTP内容类型。
	public static final String CONTENT_TYPE_TEXT_HTML = "text/xml";

	// HTTP内容类型。相当于form表单的形式，提交数据
	public static final String CONTENT_TYPE_FORM_URL = "application/x-www-form-urlencoded";

	// HTTP内容类型。相当于form表单的形式，提交数据
	public static final String CONTENT_TYPE_JSON_URL = "application/json;charset=utf-8";

	// 连接管理器
	private static PoolingHttpClientConnectionManager pool;

	// 请求配置
	private static RequestConfig requestConfig;

	static {

		try {
			// System.out.porintln("初始化HttpClientTest~~~开始");
			SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
			// 配置同时支持 HTTP 和 HTPPS
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslsf).build();
			// 初始化连接管理器
			pool = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			// 将最大连接数增加到200，实际项目最好从配置文件中读取这个值
			pool.setMaxTotal(200);
			// 设置最大路由
			pool.setDefaultMaxPerRoute(2);
			// 根据默认超时限制初始化requestConfig
			int socketTimeout = 10000;
			int connectTimeout = 10000;
			int connectionRequestTimeout = 10000;
			requestConfig = RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout)
					.setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();

			// System.out.println("初始化HttpClientTest~~~结束");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}

		// 设置请求超时时间
		requestConfig = RequestConfig.custom().setSocketTimeout(50000).setConnectTimeout(50000)
				.setConnectionRequestTimeout(50000).build();
	}

	public static CloseableHttpClient getHttpClient() {

		CloseableHttpClient httpClient = HttpClients.custom()
				// 设置连接池管理
				.setConnectionManager(pool)
				// 设置请求配置
				.setDefaultRequestConfig(requestConfig)
				// 设置重试次数
				.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)).build();

		return httpClient;
	}
	
	/**
	 * 发送Post请求
	 * 
	 * @param httpPost
	 * @return
	 */
	private static String sendHttpPost(HttpPost httpPost) {

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		// 响应内容
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			httpClient = getHttpClient();
			// 配置请求信息
			httpPost.setConfig(requestConfig);
			
			// 执行请求
			response = httpClient.execute(httpPost);
			// 得到响应实例
			HttpEntity entity = response.getEntity();

			// 可以获得响应头
			// Header[] headers = response.getHeaders(HttpHeaders.CONTENT_TYPE);
			// for (Header header : headers) {
			// System.out.println(header.getName());
			// }

			// 得到响应类型
			// System.out.println(ContentType.getOrDefault(response.getEntity()).getMimeType());

			// 判断响应状态
			if (response.getStatusLine().getStatusCode() >= 300) {
				throw new Exception(
						"HTTP Request is not success, Response code is " + response.getStatusLine().getStatusCode());
			}

			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				responseContent = EntityUtils.toString(entity, CHARSET_UTF_8);
				EntityUtils.consume(entity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}

	/**
	 * 发送Post请求
	 * 
	 * @param httpPost
	 * @param headers 自定义头，可为空
	 * @return
	 */
	private static String sendHttpPost(HttpPost httpPost,Map<String,String> headers) {

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		// 响应内容
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			httpClient = getHttpClient();
			// 配置请求信息
			httpPost.setConfig(requestConfig);
			//增加自定义头
			if(!headers.isEmpty()) {
				for(String key : headers.keySet()) {
					httpPost.setHeader(key, headers.get(key));
				}
			}
			// 执行请求
			response = httpClient.execute(httpPost);
			// 得到响应实例
			HttpEntity entity = response.getEntity();

			// 可以获得响应头
			// Header[] headers = response.getHeaders(HttpHeaders.CONTENT_TYPE);
			// for (Header header : headers) {
			// System.out.println(header.getName());
			// }

			// 得到响应类型
			// System.out.println(ContentType.getOrDefault(response.getEntity()).getMimeType());

			// 判断响应状态
			if (response.getStatusLine().getStatusCode() >= 300) {
				throw new Exception(
						"HTTP Request is not success, Response code is " + response.getStatusLine().getStatusCode());
			}

			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				responseContent = EntityUtils.toString(entity, CHARSET_UTF_8);
				EntityUtils.consume(entity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}

	/**
	 * 发送Get请求
	 * 
	 * @param httpGet
	 * @param headers 自定义头，可为空
	 * @return
	 */
	private static String sendHttpGet(HttpGet httpGet, Map<String, String> headers) {

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		// 响应内容
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			httpClient = getHttpClient();
			// 配置请求信息
			httpGet.setConfig(requestConfig);
			if(!headers.isEmpty()) {
				for(String key: headers.keySet()) {
					httpGet.setHeader(key, headers.get(key));
				}
			}

			// 执行请求
			response = httpClient.execute(httpGet);
			// 得到响应实例
			HttpEntity entity = response.getEntity();

			// 可以获得响应头
			// Header[] headers = response.getHeaders(HttpHeaders.CONTENT_TYPE);
			// for (Header header : headers) {
			// System.out.println(header.getName());
			// }

			// 得到响应类型
			// System.out.println(ContentType.getOrDefault(response.getEntity()).getMimeType());

			// 判断响应状态
			if (response.getStatusLine().getStatusCode() >= 300) {
				throw new Exception(
						"HTTP Request is not success, Response code is " + response.getStatusLine().getStatusCode());
			}

			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				responseContent = EntityUtils.toString(entity, CHARSET_UTF_8);
				EntityUtils.consume(entity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}

	/**
	 * 发送 post请求
	 * 
	 * @param httpUrl
	 *            地址
	 * @param headers 自定义头，可为空
	 */
	public static String sendHttpPost(String httpUrl,Map<String, String> headers) {
		// 创建httpPost
		HttpPost httpPost = new HttpPost(httpUrl);
		return sendHttpPost(httpPost,headers);
	}

	/**
	 * 发送 get请求
	 * 
	 * @param httpUrl
	 * @param headers 自定义头 ，可为空
	 */
	public static String sendHttpGet(String httpUrl,Map<String,String> headers) {
		// 创建get请求
		HttpGet httpGet = new HttpGet(httpUrl);
		return sendHttpGet(httpGet, headers);
	}

	/**
	 * 发送 post请求（带文件）
	 * 
	 * @param httpUrl
	 *            地址
	 * @param maps
	 *            参数
	 * @param fileLists
	 *            附件
	 */
	public static String sendHttpPost(String httpUrl, Map<String, String> maps, List<File> fileLists) {
		HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
		MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
		if (maps != null) {
			for (String key : maps.keySet()) {
				meBuilder.addPart(key, new StringBody(maps.get(key), ContentType.TEXT_PLAIN));
			}
		}
		if (fileLists != null) {
			for (File file : fileLists) {
				FileBody fileBody = new FileBody(file);
				meBuilder.addPart("files", fileBody);
			}
		}
		HttpEntity reqEntity = meBuilder.build();
		httpPost.setEntity(reqEntity);
		return sendHttpPost(httpPost);
	}

	/**
	 * 发送 post请求
	 * 
	 * @param httpUrl
	 *            地址
	 * @param params
	 *            参数(格式:key1=value1&key2=value2)
	 * @param  headers    自定义header头  
	 * 
	 */
	public static String sendHttpPost(String httpUrl, String params,Map<String,String> headers) {
		HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
		try {			
			// 设置参数
			if (params != null && params.trim().length() > 0) {
				StringEntity stringEntity = new StringEntity(params, "UTF-8");
				stringEntity.setContentType(CONTENT_TYPE_FORM_URL);
				httpPost.setEntity(stringEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sendHttpPost(httpPost,headers);
	}

	/**
	 * 发送 post请求
	 * 
	 * @param maps
	 *            参数
	 * @param headers  自定义头   没有为空
	 */
	public static String sendHttpPost(String httpUrl, Map<String, String> maps, Map<String,String> headers) {
		String parem = convertStringParamter(maps);
		return sendHttpPost(httpUrl, parem,headers);
	}

	/**
	 * 发送 post请求 发送json数据
	 * 
	 * @param httpUrl
	 *            地址
	 * @param paramsJson
	 *            参数(格式 json)
	 * 
	 */
	public static String sendHttpPostJson(String httpUrl, String paramsJson) {
		HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
		try {
			// 设置参数
			if (paramsJson != null && paramsJson.trim().length() > 0) {
				StringEntity stringEntity = new StringEntity(paramsJson, "UTF-8");
				stringEntity.setContentType(CONTENT_TYPE_JSON_URL);
				httpPost.setEntity(stringEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sendHttpPost(httpPost);
	}

	public static String sendHttpPostJsonWithHeader(String httpUrl, String paramsJson, Map<String, String> headMap){
		HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
		
		if(headMap != null){
			for(Entry<String, String> entry : headMap.entrySet()){
				httpPost.addHeader(entry.getKey(), entry.getValue());
			}
		}

		try {
			// 设置参数
			if (paramsJson != null && paramsJson.trim().length() > 0) {
				StringEntity stringEntity = new StringEntity(paramsJson, "UTF-8");
				stringEntity.setContentType(CONTENT_TYPE_JSON_URL);
				httpPost.setEntity(stringEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sendHttpPost(httpPost);
	}
	/**
	 * 发送 post请求 发送xml数据
	 * 
	 * @param httpUrl
	 *            地址
	 * @param paramsXml
	 *            参数(格式 Xml)
	 * 
	 */
	public static String sendHttpPostXml(String httpUrl, String paramsXml) {
		HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
		try {
			// 设置参数
			if (paramsXml != null && paramsXml.trim().length() > 0) {
				StringEntity stringEntity = new StringEntity(paramsXml, "UTF-8");
				stringEntity.setContentType(CONTENT_TYPE_TEXT_HTML);
				httpPost.setEntity(stringEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sendHttpPost(httpPost);
	}

	/**
	 * 将map集合的键值对转化成：key1=value1&key2=value2 的形式
	 * 
	 * @param parameterMap
	 *            需要转化的键值对集合
	 * @return 字符串
	 */
	public static String convertStringParamter(Map parameterMap) {
		StringBuffer parameterBuffer = new StringBuffer();
		if (parameterMap != null) {
			Iterator iterator = parameterMap.keySet().iterator();
			String key = null;
			String value = null;
			while (iterator.hasNext()) {
				key = (String) iterator.next();
				if (parameterMap.get(key) != null) {
					value = (String) parameterMap.get(key);
				} else {
					value = "";
				}
				parameterBuffer.append(key).append("=").append(value);
				if (iterator.hasNext()) {
					parameterBuffer.append("&");
				}
			}
		}
		return parameterBuffer.toString();
	}
	
	

	public static String getDataGet(String loginUrl,String account,String password,String httpUrl) throws Exception {
		return getData(loginUrl, account, password, "get", httpUrl);
	}
	
	public static String getDataPost(String loginUrl,String account,String password,String httpUrl) throws Exception {
		return getData(loginUrl, account, password, "post", httpUrl);
	}
		
	@SuppressWarnings("unchecked")
	public static String getData(String loginUrl,String account,String password,String method,String httpUrl) throws Exception {
		String result=null;
		result=sendHttpPostJson(loginUrl, "{\"account\":\""+account+"\",\"password\":\""+password+"\"} ");
		JSONObject obj = JSONObject.parseObject(result);
		
		int code = Integer.parseInt(obj.get("code").toString()) ;
		if(code != 20220) {
			throw new Exception(obj.get("message").toString());
		}
		
		String authorization =  obj.getJSONObject("data").get("token").toString() ;
		
		if("post".equalsIgnoreCase(method)) {
			HttpPost httpPost = new HttpPost(httpUrl);
			httpPost.addHeader("Authorization",  "Bearer "+authorization);
			result = sendHttpPost(httpPost);
		} else if("get".equalsIgnoreCase(method)) {
			HttpGet httpGet = new HttpGet(httpUrl);
			httpGet.addHeader("Authorization",  "Bearer "+authorization);
			result = sendHttpGet(httpGet,new HashMap<String, String>());
		} else {
			throw new Exception("传入的 method 错误，请传入post 或 get");
		}
			
		return result;
	}
}