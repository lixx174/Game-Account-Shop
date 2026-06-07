package com.qinghaotech.application.model.game.account;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author jinx
 */
@Getter
@Setter
public class GameAccountDetailDto {
    /**
     * id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 游戏名称
     */
    private String gameName;
    /**
     * 账号来源
     */
    private String originName;
    /**
     * 账号区服
     */
    private String serverName;
    /**
     * 游戏系统
     */
    private String systemName;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 流程
     */
    private String process;
    /**
     * 政策
     */
    private String policy;
    /**
     * 账号截图
     */
    private Collection<String> images;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private LocalDateTime createAt;
}
