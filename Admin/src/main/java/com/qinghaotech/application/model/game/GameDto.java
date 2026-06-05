package com.qinghaotech.application.model.game;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author jinx
 */
@Getter
@Setter
public class GameDto {

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
    /**
     * 创建时间
     */
    private LocalDateTime createAt;
}
