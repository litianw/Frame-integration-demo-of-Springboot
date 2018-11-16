package com.ltw;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.ltw.conf.filter.TestFilter;
import com.ltw.conf.listener.TestListener;

@SpringBootApplication
@ComponentScan(basePackages= {"com.ltw"})
@MapperScan(basePackages= {"com.ltw.dao"})
//若使用jpa请保证dao service controller entity 所在的包在application类所在的包
//mybatis 可不在同一个包下  需配置application类注解@MapperScan(basePackages= {"com.XX.dao"})
//在同一个报下则不需要注解
public class DemoApplication implements ServletContextInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		 // 配置过滤器
		servletContext.addFilter("testFliter", new TestFilter())
		.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
		 // 配置监听器
        servletContext.addListener(new TestListener());
	}
}
