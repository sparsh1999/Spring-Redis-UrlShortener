package com.example.sparsh.RedisUrlShortener;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = {"com.example.sparsh.RedisUrlShortener"})
@EnableSwagger2
@SpringBootApplication
public class RedisUrlShortenerApplication extends SpringBootServletInitializer {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(RedisUrlShortenerApplication.class);
//	}


	public static void main(String[] args) {
		SpringApplication.run(RedisUrlShortenerApplication.class, args);
	}
}
