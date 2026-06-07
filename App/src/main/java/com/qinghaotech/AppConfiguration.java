package com.qinghaotech;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author jinx
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "qinghaotech")
public class AppConfiguration {

    /**
     * 淘宝跳转链接
     */
    private String customerEndpoint;
}
