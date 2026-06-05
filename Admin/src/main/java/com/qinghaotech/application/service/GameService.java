package com.qinghaotech.application.service;

import com.qinghaotech.application.convert.GameConverter;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.game.CreateGameCommand;
import com.qinghaotech.application.model.game.GameDetailDto;
import com.qinghaotech.application.model.game.GamePageDto;
import com.qinghaotech.application.model.game.GamePageQuery;
import com.qinghaotech.application.model.game.ModifyGameCommand;
import com.qinghaotech.domain.game.GameEntity;
import com.qinghaotech.domain.game.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author jinx
 */
@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository repo;
    private final GameConverter converter;

    public PageReply<GamePageDto> page(GamePageQuery query) {
        var page = repo.selectPage(query);
        var data = converter.convertToPage(page.getRecords());
        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), data);
    }


    public GameDetailDto detail(Integer id) {
        GameEntity entity = repo.selectById(id);
        return converter.convertToDetail(entity);
    }

    public void create(CreateGameCommand command) {
        GameEntity entity = converter.convert(command);
        repo.insert(entity);
    }

    public void modify(ModifyGameCommand command) {
        GameEntity entity = converter.convert(command);
        repo.updateById(entity);
    }

    public void remove(Integer id) {
        repo.deleteById(id);
    }
}
