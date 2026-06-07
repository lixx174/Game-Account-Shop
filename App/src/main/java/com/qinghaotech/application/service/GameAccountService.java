package com.qinghaotech.application.service;

import com.qinghaotech.AppConfiguration;
import com.qinghaotech.application.converter.GameAccountConverter;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.game.account.GameAccountDetailDto;
import com.qinghaotech.application.model.game.account.GameAccountPageDto;
import com.qinghaotech.application.model.game.account.GameAccountPageQuery;
import com.qinghaotech.domain.game.GameEntity;
import com.qinghaotech.domain.game.GameRepository;
import com.qinghaotech.domain.game.account.GameAccountEntity;
import com.qinghaotech.domain.game.account.GameAccountRepository;
import com.qinghaotech.domain.game.dictionary.GameDictionaryEntity;
import com.qinghaotech.domain.game.dictionary.GameDictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Collections;
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
    private final GameRepository gRepo;
    private final GameAccountConverter converter;
    private final AppConfiguration configuration;

    public PageReply<GameAccountPageDto> page(GameAccountPageQuery query) {
        query.check();

        var page = repo.selectPage(query);

        if (page.getRecords().isEmpty()) {
            return PageReply.of(query);
        }

        var gameDictionaryMappings = getGameDictionaryMappings(page.getRecords());
        var data = converter.convertToPage(page.getRecords(), configuration.getCustomerEndpoint(), gameDictionaryMappings::get);

        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), data);
    }


    public GameAccountDetailDto detail(Integer id) {
        GameAccountEntity entity = repo.selectById(id);
        Assert.notNull(entity, "Illegal id: %s".formatted(id));
        GameEntity game = gRepo.selectById(entity.getGameId());
        Assert.notNull(game, "Illegal gameId: %s".formatted(entity.getGameId()));

        var gameDictionaryMappings = getGameDictionaryMappings(Collections.singleton(entity));

        return converter.convertToDetail(entity, game.getName(), gameDictionaryMappings::get);
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
