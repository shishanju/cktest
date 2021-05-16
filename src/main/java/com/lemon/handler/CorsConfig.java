package com.lemon.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 比@CrossOrigin强大的跨域方法，但是不能在每一个控制层上加上，都在代码冗余且容易忽略
 * 于是增加过滤器
 */

@Configuration
public class CorsConfig {

	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedOrigin("*"); // 1
		
		corsConfiguration.addAllowedHeader("*"); // 2

		corsConfiguration.addAllowedMethod("*"); // 3
		return corsConfiguration;
	}

	@Bean
	public CorsFilter corsFilter() {

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		source.registerCorsConfiguration("/**", buildConfig()); // 4

		return new CorsFilter(source);
	}

}
