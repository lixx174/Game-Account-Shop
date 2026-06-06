package com.qinghaotech.application.model.game.account;

import com.qinghaotech.application.model.PageQuery;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

/**
 * @author jinx
 */
@Getter
@Setter
public class GameAccountPageQuery extends PageQuery {

    /**
     * REQUIRED 游戏id
     */
    private Integer gameId;
    /**
     * 游戏来源id
     */
    private Integer originId;
    /**
     * 游戏系统id
     */
    private Integer systemId;
    /**
     * 标题
     */
    private String title;

    public void check() {
        Assert.notNull(gameId, "gameId为空");
    }
}
