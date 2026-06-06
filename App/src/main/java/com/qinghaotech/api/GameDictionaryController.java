package com.qinghaotech.api;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.Result;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerQuery;
import com.qinghaotech.application.service.GameDictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 游戏字典API
 *
 * @author jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/game-dictionary")
public class GameDictionaryController {

    private final GameDictionaryService service;

    /**
     * 下拉
     *
     * @param query 查询参数
     */
    @GetMapping("/picker")
    public Result<PageReply<GameDictionaryPickerDto>> picker(GameDictionaryPickerQuery query) {
        return Result.succeed(service.picker(query));
    }
}
