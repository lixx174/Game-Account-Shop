package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerDto;
import com.qinghaotech.domain.game.dictionary.GameDictionaryEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper
public interface GameDictionaryConverter {

    GameDictionaryPickerDto convertToPicker(GameDictionaryEntity entity);

    Collection<GameDictionaryPickerDto> convertToPicker(Collection<GameDictionaryEntity> entities);
}
