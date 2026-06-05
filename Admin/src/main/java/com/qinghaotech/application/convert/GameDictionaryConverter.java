package com.qinghaotech.application.convert;

import com.qinghaotech.application.model.game.dictionary.CreateGameDictionaryCommand;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryDetailDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPageDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerDto;
import com.qinghaotech.application.model.game.dictionary.ModifyGameDictionaryCommand;
import com.qinghaotech.domain.game.dictionary.GameDictionaryEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper
public interface GameDictionaryConverter {

    GameDictionaryDetailDto convertToDetail(GameDictionaryEntity entity);

    GameDictionaryPageDto convertToPage(GameDictionaryEntity entity);

    Collection<GameDictionaryPageDto> convertToPage(Collection<GameDictionaryEntity> entities);

    GameDictionaryPickerDto convertToPicker(GameDictionaryEntity entity);

    Collection<GameDictionaryPickerDto> convertToPicker(Collection<GameDictionaryEntity> entities);

    GameDictionaryEntity convert(CreateGameDictionaryCommand command);

    GameDictionaryEntity convert(ModifyGameDictionaryCommand command);
}
