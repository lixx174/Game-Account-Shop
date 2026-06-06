package com.qinghaotech.domain.game;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinghaotech.domain.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jinx
 */
@Getter
@Setter
@TableName(value = "game")
public class GameEntity extends Entity {

    private String name;

    private String icon;
}
