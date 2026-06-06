package com.qinghaotech.domain.game.account;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qinghaotech.domain.Entity;
import com.qinghaotech.infra.configuration.mp.IntegerCollectionStringTypeHandler;
import com.qinghaotech.infra.configuration.mp.StringCollectionStringTypeHandler;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author jinx
 */
@Getter
@Setter
@TableName(value = "game_account", autoResultMap = true)
public class GameAccountEntity extends Entity {

    private Integer gameId;
    private String title;
    private Integer originId;
    private Integer serverId;
    private Integer systemId;
    @TableField(typeHandler = IntegerCollectionStringTypeHandler.class)
    private Collection<Integer> tagIds;
    private BigDecimal price;
    @TableField(typeHandler = StringCollectionStringTypeHandler.class)
    private Collection<String> images;
    private String remark;
}
