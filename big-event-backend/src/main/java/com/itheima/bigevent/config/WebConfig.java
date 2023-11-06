package com.itheima.bigevent.config;

import com.itheima.bigevent.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final List<String> BYPASS_PATHS = List.of(
            "/user/login",
            "/user/register");

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        // For login and register, not intercept.
        registry.addInterceptor(loginInterceptor).excludePathPatterns(BYPASS_PATHS);
    }
}
