package com.qinghaotech.api;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.Result;
import com.qinghaotech.application.model.game.dictionary.CreateGameDictionaryCommand;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryDetailDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPageDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPageQuery;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerQuery;
import com.qinghaotech.application.model.game.dictionary.ModifyGameDictionaryCommand;
import com.qinghaotech.application.service.GameDictionaryService;
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
 * 游戏区服API
 *
 * @author jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/game-dictionary")
public class GameDictionaryController {

    private final GameDictionaryService service;

    /**
     * 分页查询
     * @param query 查询参数
     */
    @GetMapping("/page")
    public Result<PageReply<GameDictionaryPageDto>> page(GameDictionaryPageQuery query) {
        return Result.succeed(service.page(query));
    }

    /**
     * 下拉
     * @param query 查询参数
     */
    @GetMapping("/picker")
    public Result<PageReply<GameDictionaryPickerDto>> picker(GameDictionaryPickerQuery query) {
        return Result.succeed(service.picker(query));
    }

    /**
     * 查询详情
     *
     * @param id id
     */
    @GetMapping("/{id}")
    public Result<GameDictionaryDetailDto> detail(@PathVariable Integer id) {
        return Result.succeed(service.detail(id));
    }

    /**
     * 新增
     *
     * @param command 新增参数
     */
    @PostMapping
    public Result<Void> create(@RequestBody CreateGameDictionaryCommand command) {
        return Result.succeed(() -> service.create(command));
    }

    /**
     * 修改
     *
     * @param command 修改参数
     */
    @PutMapping
    public Result<Void> modify(@RequestBody ModifyGameDictionaryCommand command) {
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
