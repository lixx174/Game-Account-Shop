package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.game.account.CreateGameAccountCommand;
import com.qinghaotech.application.model.game.account.GameAccountDetailDto;
import com.qinghaotech.application.model.game.account.GameAccountPageDto;
import com.qinghaotech.application.model.game.account.ModifyGameAccountCommand;
import com.qinghaotech.domain.game.account.GameAccountEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper
public interface GameAccountConverter {

    GameAccountDetailDto convertToDetail(GameAccountEntity entity);

    GameAccountPageDto convertToPage(GameAccountEntity entity);

    Collection<GameAccountPageDto> convertToPage(Collection<GameAccountEntity> entities);

    GameAccountEntity convert(CreateGameAccountCommand command);

    GameAccountEntity convert(ModifyGameAccountCommand command);

    @AfterMapping
    default void afterPropertySet(GameAccountEntity entity,
                                  @MappingTarget GameAccountPageDto dto,
                                  @Context IdNameResolver resolver) {
        dto.setOriginName(resolver.resolve(entity.getOriginId()));
        dto.setServerName(resolver.resolve(entity.getServerId()));
        dto.setSystemName(resolver.resolve(entity.getSystemId()));
    }

    @AfterMapping
    default void afterPropertySet(GameAccountEntity entity,
                                  @MappingTarget GameAccountDetailDto dto,
                                  @Context IdNameResolver resolver) {
        dto.setOriginName(resolver.resolve(entity.getOriginId()));
        dto.setServerName(resolver.resolve(entity.getServerId()));
        dto.setSystemName(resolver.resolve(entity.getSystemId()));
        dto.setTags(resolver.resolve(entity.getTagIds()));
    }
}
