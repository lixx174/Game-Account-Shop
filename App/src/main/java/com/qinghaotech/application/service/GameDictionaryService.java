package com.qinghaotech.application.service;

import com.qinghaotech.application.converter.GameDictionaryConverter;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerQuery;
import com.qinghaotech.domain.game.dictionary.GameDictionaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author jinx
 */
@Service
@RequiredArgsConstructor
public class GameDictionaryService {

    private final GameDictionaryRepository repo;
    private final GameDictionaryConverter converter;

    public PageReply<GameDictionaryPickerDto> picker(GameDictionaryPickerQuery query) {
        query.check();

        var page = repo.selectPage(query);
        var data = converter.convertToPicker(page.getRecords());
        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), data);
    }
}
