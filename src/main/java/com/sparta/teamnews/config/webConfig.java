package com.sparta.teamnews.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Users/selging/img/**")    //이미지호출 URL
                .addResourceLocations("file:/Users/selging/img/");           //실제 이미지가 있는 외부 위치
//                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }
}
