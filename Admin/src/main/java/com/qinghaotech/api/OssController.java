package com.qinghaotech.api;

import com.qinghaotech.application.model.Result;
import com.qinghaotech.application.service.OssService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jinx
 */
@RestController
@RequestMapping("/oss")
@RequiredArgsConstructor
public class OssController {

    private final OssService service;

    /**
     * 上传图片
     *
     * @param file 图片
     * @return 图片url
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) {
        return Result.succeed(service.upload(file));
    }
}
