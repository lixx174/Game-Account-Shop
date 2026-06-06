package com.qinghaotech.application.service;

import com.qinghaotech.application.converter.GameConverter;
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

import java.util.Collection;

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
        Collection<GameEntity> existedEntities = repo.selectByName(command.getName());
        if (!existedEntities.isEmpty()) {
            throw new UnsupportedOperationException("name:%s 已存在".formatted(command.getName()));
        }

        GameEntity entity = converter.convert(command);
        repo.insert(entity);
    }

    public void modify(ModifyGameCommand command) {
        Collection<GameEntity> existedEntities = repo.selectByName(command.getName())
                .stream()
                .filter(e -> !e.getId().equals(command.getId()))
                .toList();

        if (!existedEntities.isEmpty()) {
            throw new UnsupportedOperationException("name:%s 已存在".formatted(command.getName()));
        }

        GameEntity entity = converter.convert(command);
        repo.updateById(entity);
    }

    public void remove(Integer id) {
        repo.deleteById(id);
    }
}
