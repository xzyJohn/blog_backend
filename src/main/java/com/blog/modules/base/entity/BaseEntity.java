package com.blog.modules.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: xzy
 * @Description:
 * @Date: Created in 14:13 2020/4/2
 */
@Data
public class BaseEntity {
    /**
     * id主键
     */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    /**
     * 创建人id
     */
    @TableField(fill = FieldFill.INSERT, updateStrategy = FieldStrategy.NOT_NULL)
    private Long createdBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT, updateStrategy = FieldStrategy.NOT_NULL)
    private Date createdDate;

    /**
     * 最后修改人id
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long lastModifiedBy;

    /**
     * 最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date lastModifiedDate;

    /**
     * 乐观锁
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer version;
}
