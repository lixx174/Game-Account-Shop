package com.qinghaotech.application.model.game.account;

import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.domain.primitive.SortColumn;
import com.qinghaotech.domain.primitive.SortType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.math.BigDecimal;

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
    /**
     * 排序字段
     */
    private SortColumn sortColumn;
    /**
     * 排序方式
     */
    private SortType sortType;
    /**
     * 最低价
     */
    private BigDecimal minPrice;
    /**
     * 最高价
     */
    private BigDecimal maxPrice;

    public void check() {
        Assert.notNull(gameId, "gameId为空");
    }
}
