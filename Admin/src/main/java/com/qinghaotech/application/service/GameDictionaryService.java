package com.qinghaotech.application.service;

import com.qinghaotech.application.convert.GameDictionaryConverter;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.game.dictionary.CreateGameDictionaryCommand;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryDetailDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPageDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPageQuery;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerDto;
import com.qinghaotech.application.model.game.dictionary.GameDictionaryPickerQuery;
import com.qinghaotech.application.model.game.dictionary.ModifyGameDictionaryCommand;
import com.qinghaotech.domain.game.dictionary.GameDictionaryEntity;
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

    public PageReply<GameDictionaryPageDto> page(GameDictionaryPageQuery query) {
        var page = repo.selectPage(query);
        var data = converter.convertToPage(page.getRecords());
        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), data);
    }

    public PageReply<GameDictionaryPickerDto> picker(GameDictionaryPickerQuery query) {
        var page = repo.selectPage(query);
        var data = converter.convertToPicker(page.getRecords());
        return PageReply.of(page.getCurrent(), page.getSize(), page.getPages(), data);
    }

    public GameDictionaryDetailDto detail(Integer id) {
        GameDictionaryEntity entity = repo.selectById(id);
        return converter.convertToDetail(entity);
    }

    public void create(CreateGameDictionaryCommand command) {
        GameDictionaryEntity entity = converter.convert(command);
        repo.insert(entity);
    }

    public void modify(ModifyGameDictionaryCommand command) {
        GameDictionaryEntity entity = converter.convert(command);
        repo.updateById(entity);
    }

    public void remove(Integer id) {
        repo.deleteById(id);
    }
}
