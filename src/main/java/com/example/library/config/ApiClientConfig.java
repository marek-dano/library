package com.example.library.config;

import org.openapitools.client.api.FaqApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiClientConfig {

    @Bean
    public FaqApi faqApi() {
        return new FaqApi();
    }

}
