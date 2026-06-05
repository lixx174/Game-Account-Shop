package com.qinghaotech.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 *
 * @author Jinx
 */
@Getter
@Setter
public abstract class Entity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private LocalDateTime createAt;

    private Integer createBy;

    private LocalDateTime updateAt;

    private Integer updateBy;

    @TableLogic
    private Boolean isDeleted;
}
