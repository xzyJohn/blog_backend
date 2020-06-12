package com.blog.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blog.modules.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tbl_permission")
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 权限代码
     */
    private String code;

    /**
     * 菜单id
     */
    private Long menuId;


}
