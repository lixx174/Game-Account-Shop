package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.game.account.GameAccountDetailDto;
import com.qinghaotech.application.model.game.account.GameAccountPageDto;
import com.qinghaotech.domain.game.account.GameAccountEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper
public interface GameAccountConverter {

    @Mappings({
            @Mapping(target = "originName", source = "entity.originId", qualifiedByName = "resolveId"),
            @Mapping(target = "serverName", source = "entity.serverId", qualifiedByName = "resolveId"),
            @Mapping(target = "systemName", source = "entity.systemId", qualifiedByName = "resolveId"),
    })
    GameAccountDetailDto convertToDetail(GameAccountEntity entity, String gameName, @Context IdNameResolver resolver);

    @Mappings({
            @Mapping(target = "originName", source = "entity.originId", qualifiedByName = "resolveId"),
            @Mapping(target = "serverName", source = "entity.serverId", qualifiedByName = "resolveId"),
            @Mapping(target = "systemName", source = "entity.systemId", qualifiedByName = "resolveId"),
            @Mapping(target = "tags", source = "entity.tagIds", qualifiedByName = "resolveIds"),
            @Mapping(target = "img", source = "entity.images", qualifiedByName = "resolveImg"),
    })
    GameAccountPageDto convertToPage(GameAccountEntity entity,
                                     String customerEndpoint,
                                     @Context IdNameResolver resolver);

    Collection<GameAccountPageDto> convertToPage(Collection<GameAccountEntity> entities,
                                                 String customerEndpoint,
                                                 @Context IdNameResolver resolver);


    @Named("resolveId")
    default String resolveId(Integer id, @Context IdNameResolver resolver) {
        return resolver.resolve(id);
    }

    @Named("resolveIds")
    default Collection<String> resolveIds(Collection<Integer> ids, @Context IdNameResolver resolver) {
        return resolver.resolve(ids);
    }

    @Named("resolveImg")
    default String resolve(Collection<String> images) {
        return images.isEmpty() ? "" : images.iterator().next();
    }
}
