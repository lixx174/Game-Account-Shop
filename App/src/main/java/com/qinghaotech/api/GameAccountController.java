package com.qinghaotech.api;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.Result;
import com.qinghaotech.application.model.game.account.GameAccountDetailDto;
import com.qinghaotech.application.model.game.account.GameAccountPageDto;
import com.qinghaotech.application.model.game.account.GameAccountPageQuery;
import com.qinghaotech.application.service.GameAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 游戏账号API
 *
 * @author jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/game-account")
public class GameAccountController {

    private final GameAccountService service;

    /**
     * 分页查询
     *
     * @param query 查询参数
     */
    @GetMapping("/page")
    public Result<PageReply<GameAccountPageDto>> page(GameAccountPageQuery query) {
        return Result.succeed(service.page(query));
    }

    /**
     * 查询详情
     *
     * @param id id
     */
    @GetMapping("/{id}")
    public Result<GameAccountDetailDto> detail(@PathVariable Integer id) {
        return Result.succeed(service.detail(id));
    }
}
