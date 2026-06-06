package com.qinghaotech.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    @TableField(fill = FieldFill.INSERT)
    private Integer createBy = -1;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateAt;

    @TableField(fill = FieldFill.UPDATE)
    private Integer updateBy = -1;

    @TableLogic
    private Boolean isDeleted = true;
}
