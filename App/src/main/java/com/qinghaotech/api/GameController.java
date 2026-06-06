package com.qinghaotech.api;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.Result;
import com.qinghaotech.application.model.game.GamePageDto;
import com.qinghaotech.application.model.game.GamePageQuery;
import com.qinghaotech.application.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 游戏API
 *
 * @author jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {

    private final GameService service;

    /**
     * 分页查询
     *
     * @param query 查询参数
     */
    @GetMapping("/page")
    public Result<PageReply<GamePageDto>> page(GamePageQuery query) {
        return Result.succeed(service.page(query));
    }
}
