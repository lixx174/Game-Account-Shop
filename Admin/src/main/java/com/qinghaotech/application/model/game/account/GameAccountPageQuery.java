package com.qinghaotech.application.model.game.account;

import com.qinghaotech.application.model.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jinx
 */
@Getter
@Setter
public class GameAccountPageQuery extends PageQuery {

    /**
     * 游戏id
     */
    private Integer gameId;
    /**
     * 账号编号
     */
    private String accountNo;
    /**
     * 标题
     */
    private String title;
}
