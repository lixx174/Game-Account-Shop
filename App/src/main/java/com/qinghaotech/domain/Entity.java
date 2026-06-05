package com.qinghaotech.domain;

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

    private Integer id;
    private LocalDateTime createAt;
    private Integer createBy;
    private LocalDateTime updateAt;
    private Integer updateBy;
}
