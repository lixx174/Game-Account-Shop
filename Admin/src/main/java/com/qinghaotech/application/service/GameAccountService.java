package com.qinghaotech.application.service;

import com.qinghaotech.application.converter.GameAccountConverter;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.game.account.CreateGameAccountCommand;
import com.qinghaotech.application.model.game.account.GameAccountDetailDto;
import com.qinghaotech.application.model.game.account.GameAccountPageDto;
import com.qinghaotech.application.model.game.account.GameAccountPageQuery;
import com.qinghaotech.application.model.game.account.ModifyGameAccountCommand;
import com.qinghaotech.domain.game.account.GameAccountEntity;
import com.qinghaotech.domain.game.account.GameAccountRepository;
import com.qinghaotech.domain.game.dictionary.GameDictionaryEntity;
import com.qinghaotech.domain.game.dictionary.GameDictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jinx
 */
@Service
@RequiredArgsConstructor
public class GameAccountService {

    private final GameAccountRepository repo;
    private final GameDictionaryRepository gdRepo;
    private final GameAccountConverter converter;

    public PageReply<GameAccountPageDto> page(GameAccountPageQuery query) {
        var page = repo.selectPage(query);

        if (page.getRecords().isEmpty()) {
            return PageReply.of(query);
        }

        var gameDictionaryMappings = getGameDictionaryMappings(page.getRecords());
        var data = converter.convertToPage(page.getRecords(), gameDictionaryMappings::get);

        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), data);
    }


    public GameAccountDetailDto detail(Integer id) {
        GameAccountEntity entity = repo.selectById(id);
        Assert.notNull(entity, "Illegal id: %s".formatted(id));

        return converter.convertToDetail(entity);
    }

    public void create(CreateGameAccountCommand command) {
        GameAccountEntity entity = converter.convert(command);
        repo.insert(entity);
    }

    public void modify(ModifyGameAccountCommand command) {
        GameAccountEntity entity = converter.convert(command);
        repo.updateById(entity);
    }

    public void remove(Integer id) {
        repo.deleteById(id);
    }


    private Map<Integer, String> getGameDictionaryMappings(Collection<GameAccountEntity> entities) {
        Set<Integer> ids = entities.stream()
                .flatMap(entity -> Stream.concat(
                        Set.of(entity.getOriginId(), entity.getServerId(), entity.getSystemId()).stream(),
                        entity.getTagIds().stream()
                ))
                .collect(Collectors.toSet());

        return gdRepo.selectBatchIds(ids)
                .stream()
                .collect(
                        Collectors.toMap(
                                GameDictionaryEntity::getId,
                                GameDictionaryEntity::getName,
                                (v1, v2) -> v1
                        )
                );
    }
}
