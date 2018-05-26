package com.emgcy120.core.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by weijieliao on 2018/1/9.
 */
@Configuration
public class RestConfig {

    @Autowired
    private RestTemplateBuilder builder ;

    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }

}
