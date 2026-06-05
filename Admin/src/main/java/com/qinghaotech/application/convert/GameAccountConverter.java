package com.qinghaotech.application.convert;

import com.qinghaotech.application.model.game.account.CreateGameAccountCommand;
import com.qinghaotech.application.model.game.account.GameAccountDetailDto;
import com.qinghaotech.application.model.game.account.GameAccountPageDto;
import com.qinghaotech.application.model.game.account.ModifyGameAccountCommand;
import com.qinghaotech.domain.game.account.GameAccountEntity;
import org.mapstruct.Mapper;

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
}
