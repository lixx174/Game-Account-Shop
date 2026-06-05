package com.qinghaotech.api;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.Result;
import com.qinghaotech.application.model.game.CreateGameCommand;
import com.qinghaotech.application.model.game.GameDetailDto;
import com.qinghaotech.application.model.game.GamePageDto;
import com.qinghaotech.application.model.game.GamePageQuery;
import com.qinghaotech.application.model.game.ModifyGameCommand;
import com.qinghaotech.application.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * @param query 查询参数
     */
    @GetMapping("/page")
    public Result<PageReply<GamePageDto>> page(GamePageQuery query) {
        return Result.succeed(service.page(query));
    }

    /**
     * 查询详情
     *
     * @param id id
     */
    @GetMapping("/{id}")
    public Result<GameDetailDto> detail(@PathVariable Integer id) {
        return Result.succeed(service.detail(id));
    }

    /**
     * 新增
     *
     * @param command 新增参数
     */
    @PostMapping
    public Result<Void> create(@RequestBody CreateGameCommand command) {
        return Result.succeed(() -> service.create(command));
    }

    /**
     * 修改
     *
     * @param command 修改参数
     */
    @PutMapping
    public Result<Void> modify(@RequestBody ModifyGameCommand command) {
        return Result.succeed(() -> service.modify(command));
    }

    /**
     * 删除
     *
     * @param id id
     */
    @DeleteMapping("/{id}")
    public Result<Void> remove(@PathVariable Integer id) {
        return Result.succeed(() -> service.remove(id));
    }
}
