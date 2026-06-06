package com.qinghaotech.application.model.game;

import com.qinghaotech.application.model.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jinx
 */
@Getter
@Setter
public class GamePageQuery extends PageQuery {
    /**
     * 名称
     */
    private String name;
}
