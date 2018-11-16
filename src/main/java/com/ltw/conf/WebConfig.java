package com.ltw.conf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ltw.interceptor.TestInterceptor;
/**
 * 次类中做一下初始化配置
 * @author Administrator
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private TestInterceptor testInterceptor;
	/**
	 * 配置 fastJson
	 * @return
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		
		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
		
		return new HttpMessageConverters(converter);

	}
	//配置监听器也可以在这里
	/*@Bean
	public ServletListenerRegistrationBean<TestListener> servletListenerRegistrationBean() {
	    return new ServletListenerRegistrationBean<TestListener>(new TestListener());
	}*/
	//同理过滤器也可以
	/*@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		TestFilter timeFilter = new TestFilter();
		registrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
	}*/
	
	/**
	 * CORS 支持
	 * @return
	 */
	/*方式一
	   @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	          @Override
	          public void addCorsMappings(CorsRegistry registry) {
	              registry.addMapping("/springboot/**")
	                      .allowedOrigins("http://localhost:8088");// 允许 8088 端口访问
	          }
	        };
	    }*/
	//方式二
	/* @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/fastjson/**")
	              .allowedOrigins("http://localhost:8088");// 允许 8088 端口访问
	    }*/
	//配置拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testInterceptor);
	}
}
