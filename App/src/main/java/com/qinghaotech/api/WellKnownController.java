package com.qinghaotech.api;

import com.qinghaotech.application.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jinx
 */
@RestController
public class WellKnownController {

    @GetMapping("/ping")
    public Result<String> ping(){
        return Result.succeed("pong");
    }
}
