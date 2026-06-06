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
public class AdminConfiguration {

    private final OssProperties aliyunOss = new OssProperties();

    @Getter
    @Setter
    public static class OssProperties {
        private String region;
        private String endpoint;
        private String bucket;
        /**
         * oss自定义域名,用于资源访问
         */
        private String customEndpoint;
    }
}
