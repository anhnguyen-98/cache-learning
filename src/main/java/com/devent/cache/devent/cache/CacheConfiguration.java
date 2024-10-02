package com.devent.cache.devent.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfiguration {

    @Bean
    public CacheStore<Employee> employeeCache() {
        return new CacheStore<>(60, TimeUnit.SECONDS);
    }
}
