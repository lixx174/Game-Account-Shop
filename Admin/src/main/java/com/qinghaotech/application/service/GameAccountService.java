package com.qinghaotech.application.service;

import com.qinghaotech.application.convert.GameAccountConverter;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.game.account.CreateGameAccountCommand;
import com.qinghaotech.application.model.game.account.GameAccountDetailDto;
import com.qinghaotech.application.model.game.account.GameAccountPageDto;
import com.qinghaotech.application.model.game.account.GameAccountPageQuery;
import com.qinghaotech.application.model.game.account.ModifyGameAccountCommand;
import com.qinghaotech.domain.game.account.GameAccountEntity;
import com.qinghaotech.domain.game.account.GameAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author jinx
 */
@Service
@RequiredArgsConstructor
public class GameAccountService {

    private final GameAccountRepository repo;
    private final GameAccountConverter converter;

    public PageReply<GameAccountPageDto> page(GameAccountPageQuery query) {
        var page = repo.selectPage(query);
        var data = converter.convertToPage(page.getRecords());
        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), data);
    }


    public GameAccountDetailDto detail(Integer id) {
        GameAccountEntity entity = repo.selectById(id);
        return converter.convertToDetail(entity);
    }

    public void create(CreateGameAccountCommand command) {
        GameAccountEntity entity = converter.convert(command);
        repo.insert(entity);
    }

    public void modify(ModifyGameAccountCommand command) {
        GameAccountEntity entity = converter.convert(command);
        repo.updateById(entity);
    }

    public void remove(Integer id) {
        repo.deleteById(id);
    }
}
