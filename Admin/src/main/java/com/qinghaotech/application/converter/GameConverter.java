package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.game.CreateGameCommand;
import com.qinghaotech.application.model.game.GameDetailDto;
import com.qinghaotech.application.model.game.GamePageDto;
import com.qinghaotech.application.model.game.ModifyGameCommand;
import com.qinghaotech.domain.game.GameEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

/**
 * @author jinx
 */
@Mapper(
        config = EntityIgnoreConfiguration.class
)
public interface GameConverter {

    GameDetailDto convertToDetail(GameEntity entity);

    GamePageDto convertToPage(GameEntity entity);

    Collection<GamePageDto> convertToPage(Collection<GameEntity> entities);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    GameEntity convert(CreateGameCommand command);

    GameEntity convert(ModifyGameCommand command);
}
