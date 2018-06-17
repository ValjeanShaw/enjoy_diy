package com.lucky.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 600006
 * @version 1.0
 */
@Configuration
@PropertySource("classpath:freedom.properties")
@ConfigurationProperties(prefix="freedom")
@Data
public class TestFreedom {
    private String name;
    private String email;


}
