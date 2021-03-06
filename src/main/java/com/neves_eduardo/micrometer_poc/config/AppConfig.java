package com.neves_eduardo.micrometer_poc.config;


import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MeterRegistry meterRegistry() {
        return  new SimpleMeterRegistry();
    }
}
