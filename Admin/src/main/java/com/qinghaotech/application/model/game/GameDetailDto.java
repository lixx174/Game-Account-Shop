package com.qinghaotech.application.model.game;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jinx
 */
@Getter
@Setter
public class GameDetailDto {
    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 图标地址
     */
    private String icon;
}
