package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.game.GamePageDto;
import com.qinghaotech.domain.game.GameEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper
public interface GameConverter {

    GamePageDto convertToPage(GameEntity entity);

    Collection<GamePageDto> convertToPage(Collection<GameEntity> entities);
}
