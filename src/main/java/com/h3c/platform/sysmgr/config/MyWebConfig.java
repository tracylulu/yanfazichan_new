package com.h3c.platform.sysmgr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.h3c.platform.interceptor.AuthenticationInterceptor;
//import com.h3c.platform.sysmgr.filter.FirstFilter;
//import com.h3c.platform.sysmgr.filter.SSOFilter;


@Configuration
public class MyWebConfig implements WebMvcConfigurer{
	
//	@Autowired
//	private SSOFilter ssoFilter;
//
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Bean
//    public FilterRegistrationBean filterRegist1() {
//		FilterRegistrationBean frBean = new FilterRegistrationBean();
//        frBean.setFilter(new FirstFilter());
//        frBean.addUrlPatterns("/*");
//        //frBean.setOrder(1);
//        return frBean;
//    }
//	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Bean
//    public FilterRegistrationBean filterRegist() {
//		FilterRegistrationBean frBean = new FilterRegistrationBean();
//        frBean.setFilter(ssoFilter);
//        frBean.addUrlPatterns("/*");
//        //frBean.setOrder(1);
//        return frBean;
//    }
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        //将templates目录下的CSS、JS文件映射为静态资源，防止Spring把这些资源识别成thymeleaf模版
//	        registry.addResourceHandler("/templates/**.js").addResourceLocations("classpath:/templates/");
//	        registry.addResourceHandler("/templates/**.css").addResourceLocations("classpath:/templates/");
//	        //其他静态资源
//	        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//	        //swagger增加url映射
	        registry.addResourceHandler("swagger-ui.html")
	                .addResourceLocations("classpath:/META-INF/resources/");
//	        registry.addResourceHandler("/webjars/**")
//	                .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }

//    @Bean
//    public MyIntercetor myIntercetor(){
//	    return new MyIntercetor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//	    registry.addInterceptor(myIntercetor()).addPathPatterns("/flowable/productCodeApply/save",
//                "/flowable/productCodeApply/submit");
//    }
	 
	 	@Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(authenticationInterceptor())
	                .addPathPatterns("/**");   
	    }
	    @Bean
	    public AuthenticationInterceptor authenticationInterceptor() {
	        return new AuthenticationInterceptor();
	    }
}
