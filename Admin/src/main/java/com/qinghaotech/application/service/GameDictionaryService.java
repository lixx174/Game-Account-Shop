package com.qinghaotech.application.service;

import com.qinghaotech.application.converter.GameDictionaryConverter;
import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.game.dictionary.CreateGameDictionaryCommand;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryDetailDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPageDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPageQuery;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerQuery;
import com.qinghaotech.application.model.game.dictionary.ModifyGameDictionaryCommand;
import com.qinghaotech.domain.game.GameEntity;
import com.qinghaotech.domain.game.GameRepository;
import com.qinghaotech.domain.game.dictionary.GameDictionaryEntity;
import com.qinghaotech.domain.game.dictionary.GameDictionaryQuery;
import com.qinghaotech.domain.game.dictionary.GameDictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author jinx
 */
@Service
@RequiredArgsConstructor
public class GameDictionaryService {

    private final GameDictionaryRepository repo;
    private final GameRepository gameRepo;
    private final GameDictionaryConverter converter;

    public PageReply<GameDictionaryPageDto> page(GameDictionaryPageQuery query) {
        var page = repo.selectPage(query);

        if(page.getRecords().isEmpty()){
            return PageReply.of(query);
        }

        var gameIds = page.getRecords()
                .stream()
                .map(GameDictionaryEntity::getGameId)
                .collect(Collectors.toSet());

        var gameIdNameMappings = gameRepo.selectBatchIds(gameIds)
                .stream()
                .collect(
                        Collectors.toMap(
                                GameEntity::getId,
                                GameEntity::getName,
                                (v1, v2) -> v1
                        )
                );

        var data = converter.convertToPage(page.getRecords(), gameIdNameMappings::get);
        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), data);
    }

    public PageReply<GameDictionaryPickerDto> picker(GameDictionaryPickerQuery query) {
        query.check();

        var page = repo.selectPage(query);
        var data = converter.convertToPicker(page.getRecords());
        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), data);
    }

    public GameDictionaryDetailDto detail(Integer id) {
        GameDictionaryEntity entity = repo.selectById(id);
        return converter.convertToDetail(entity);
    }

    public void create(CreateGameDictionaryCommand command) {
        GameDictionaryQuery query = GameDictionaryQuery.builder()
                .gameId(command.getGameId())
                .gameDictionary(command.getGameDictionary())
                .name(command.getName())
                .build();
        Collection<GameDictionaryEntity> existedEntities = repo.selectByCondition(query);

        Assert.isTrue(existedEntities.isEmpty(), "name:%s 已存在".formatted(command.getName()));

        GameDictionaryEntity entity = converter.convert(command);
        repo.insert(entity);
    }

    public void modify(ModifyGameDictionaryCommand command) {
        GameDictionaryEntity entity = repo.selectById(command.getId());
        Assert.notNull(entity, "Illegal Id: %s".formatted(command.getId()));

        GameDictionaryQuery query = GameDictionaryQuery.builder()
                .gameId(entity.getGameId())
                .gameDictionary(entity.getGameDictionary())
                .name(command.getName())
                .build();
        Collection<GameDictionaryEntity> existedEntities = repo.selectByCondition(query)
                .stream()
                .filter(e -> !e.getId().equals(command.getId()))
                .toList();

        Assert.isTrue(existedEntities.isEmpty(), "name:%s 已存在".formatted(command.getName()));

        repo.updateById(converter.convert(command));
    }

    public void remove(Integer id) {
        repo.deleteById(id);
    }
}
