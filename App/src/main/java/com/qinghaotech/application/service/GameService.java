package com.qinghaotech.application.service;

import com.qinghaotech.application.converter.GameConverter;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.game.GamePageDto;
import com.qinghaotech.application.model.game.GamePageQuery;
import com.qinghaotech.domain.game.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author jinx
 */
@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository repo;
    private final GameConverter converter;

    public PageReply<GamePageDto> page(GamePageQuery query) {
        var page = repo.selectPage(query);
        var data = converter.convertToPage(page.getRecords());
        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), data);
    }
}
