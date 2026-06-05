package com.qinghaotech.application.convert;

import com.qinghaotech.application.model.game.CreateGameCommand;
import com.qinghaotech.application.model.game.GameDetailDto;
import com.qinghaotech.application.model.game.GamePageDto;
import com.qinghaotech.application.model.game.ModifyGameCommand;
import com.qinghaotech.domain.game.GameEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper
public interface GameConverter {

    GameDetailDto convertToDetail(GameEntity entity);

    GamePageDto convertToPage(GameEntity entity);

    Collection<GamePageDto> convertToPage(Collection<GameEntity> entities);

    GameEntity convert(CreateGameCommand command);

    GameEntity convert(ModifyGameCommand command);'
}
