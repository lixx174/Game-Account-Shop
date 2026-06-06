package com.qinghaotech.application.service;

import com.aliyun.sdk.service.oss2.OSSClient;
import com.aliyun.sdk.service.oss2.OSSClientBuilder;
import com.aliyun.sdk.service.oss2.credentials.EnvironmentVariableCredentialsProvider;
import com.aliyun.sdk.service.oss2.models.PutObjectRequest;
import com.aliyun.sdk.service.oss2.models.PutObjectResult;
import com.aliyun.sdk.service.oss2.transport.BinaryData;
import com.qinghaotech.AdminConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OssService {

    private final AdminConfiguration configuration;

    public String upload(MultipartFile file) {
        var properties = configuration.getAliyunOss();
        OSSClientBuilder clientBuilder = OSSClient.newBuilder()
                .credentialsProvider(new EnvironmentVariableCredentialsProvider())
                .region(properties.getRegion())
                .endpoint(properties.getEndpoint());

        try (OSSClient client = clientBuilder.build()) {
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            var request = PutObjectRequest.newBuilder()
                    .bucket(properties.getBucket())
                    .key(fileName)
                    .body(BinaryData.fromBytes(file.getBytes()))
                    .build();
            PutObjectResult result = client.putObject(request);

            if (result == null || !StringUtils.hasText(result.eTag())) {
                throw new RuntimeException("OSS upload failed");
            }

            return String.format("https://%s.%s/%s", properties.getBucket(), properties.getEndpoint(), fileName);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}