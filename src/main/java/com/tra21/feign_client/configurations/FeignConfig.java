package com.tra21.feign_client.configurations;

import feign.Logger;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Encoder feignEncoder() {
        return new UserQueryParamsEncoder();
    }
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // Logs request and response details
    }
}