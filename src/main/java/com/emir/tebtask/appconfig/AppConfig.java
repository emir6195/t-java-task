package com.emir.tebtask.appconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${zeroshot.url}")
    private String zeroshotUrl;

    public String getZeroshotUrl() {
        return zeroshotUrl;
    }
}
