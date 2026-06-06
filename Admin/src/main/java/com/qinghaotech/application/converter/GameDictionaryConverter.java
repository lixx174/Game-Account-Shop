package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.game.dictionary.CreateGameDictionaryCommand;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryDetailDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPageDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerDto;
import com.qinghaotech.application.model.game.dictionary.ModifyGameDictionaryCommand;
import com.qinghaotech.domain.game.dictionary.GameDictionaryEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper(
        config = EntityIgnoreConfiguration.class
)
public interface GameDictionaryConverter {

    GameDictionaryDetailDto convertToDetail(GameDictionaryEntity entity);

    @Mappings({
            @Mapping(target = "gameName", source = "gameId", qualifiedByName = "resolveId"),
    })
    GameDictionaryPageDto convertToPage(GameDictionaryEntity entity, @Context IdNameResolver resolver);

    Collection<GameDictionaryPageDto> convertToPage(Collection<GameDictionaryEntity> entities, @Context IdNameResolver resolver);

    GameDictionaryPickerDto convertToPicker(GameDictionaryEntity entity);

    Collection<GameDictionaryPickerDto> convertToPicker(Collection<GameDictionaryEntity> entities);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    GameDictionaryEntity convert(CreateGameDictionaryCommand command);

    @Mappings({
            @Mapping(target = "gameId", ignore = true),
            @Mapping(target = "gameDictionary", ignore = true),
    })
    GameDictionaryEntity convert(ModifyGameDictionaryCommand command);

    @Named("resolveId")
    default String resolveId(Integer id, @Context IdNameResolver resolver) {
        return resolver.resolve(id);
    }

    @Named("resolveIds")
    default Collection<String> resolveIds(Collection<Integer> ids, @Context IdNameResolver resolver) {
        return resolver.resolve(ids);
    }
}
