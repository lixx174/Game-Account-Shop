package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.game.dictionary.CreateGameDictionaryCommand;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryDetailDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPageDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerDto;
import com.qinghaotech.application.model.game.dictionary.ModifyGameDictionaryCommand;
import com.qinghaotech.domain.game.dictionary.GameDictionaryEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper
public interface GameDictionaryConverter {

    GameDictionaryDetailDto convertToDetail(GameDictionaryEntity entity);

    GameDictionaryPageDto convertToPage(GameDictionaryEntity entity, IdNameResolver resolver);

    Collection<GameDictionaryPageDto> convertToPage(Collection<GameDictionaryEntity> entities, IdNameResolver resolver);

    GameDictionaryPickerDto convertToPicker(GameDictionaryEntity entity);

    Collection<GameDictionaryPickerDto> convertToPicker(Collection<GameDictionaryEntity> entities);

    GameDictionaryEntity convert(CreateGameDictionaryCommand command);

    GameDictionaryEntity convert(ModifyGameDictionaryCommand command);

    @AfterMapping
    default void afterPropertySet(@MappingTarget GameDictionaryPageDto dto,
                                  GameDictionaryEntity entity,
                                  @Context IdNameResolver resolver) {
        dto.setGameName(resolver.resolve(entity.getGameId()));
    }
}
