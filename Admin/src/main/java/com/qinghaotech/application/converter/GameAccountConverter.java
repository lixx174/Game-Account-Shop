package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.game.account.CreateGameAccountCommand;
import com.qinghaotech.application.model.game.account.GameAccountDetailDto;
import com.qinghaotech.application.model.game.account.GameAccountPageDto;
import com.qinghaotech.application.model.game.account.ModifyGameAccountCommand;
import com.qinghaotech.domain.game.account.GameAccountEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper(
        config = EntityIgnoreConfiguration.class
)
public interface GameAccountConverter {

    @Mappings({
            @Mapping(target = "originName", source = "originId", qualifiedByName = "resolveId"),
            @Mapping(target = "serverName", source = "serverId", qualifiedByName = "resolveId"),
            @Mapping(target = "systemName", source = "systemId", qualifiedByName = "resolveId"),
            @Mapping(target = "tags", source = "tagIds", qualifiedByName = "resolveIds"),
    })
    GameAccountDetailDto convertToDetail(GameAccountEntity entity, @Context IdNameResolver resolver);

    @Mappings({
            @Mapping(target = "originName", source = "originId", qualifiedByName = "resolveId"),
            @Mapping(target = "serverName", source = "serverId", qualifiedByName = "resolveId"),
            @Mapping(target = "systemName", source = "systemId", qualifiedByName = "resolveId"),
            @Mapping(target = "tags", source = "tagIds", qualifiedByName = "resolveIds"),
    })
    GameAccountPageDto convertToPage(GameAccountEntity entity, @Context IdNameResolver resolver);

    Collection<GameAccountPageDto> convertToPage(Collection<GameAccountEntity> entities, @Context IdNameResolver resolver);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    GameAccountEntity convert(CreateGameAccountCommand command);

    @Mappings({
            @Mapping(target = "gameId", ignore = true)
    })
    GameAccountEntity convert(ModifyGameAccountCommand command);

    @Named("resolveId")
    default String resolveId(Integer id, @Context IdNameResolver resolver) {
        return resolver.resolve(id);
    }

    @Named("resolveIds")
    default Collection<String> resolveIds(Collection<Integer> ids, @Context IdNameResolver resolver) {
        return resolver.resolve(ids);
    }
}
