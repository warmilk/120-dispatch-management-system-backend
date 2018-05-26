package com.emgcy120.core.common.config;

import com.emgcy120.core.common.interceptor.RepeatDataInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author chenshuzhuo
 * @data 2017-11-15
 *
 */
@Configuration
public class WebMvcConfigAdapter extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RepeatDataInterceptor()).addPathPatterns("/**");
	}

}
