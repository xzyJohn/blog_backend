package com.blog.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blog.modules.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tbl_menu")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 路由名称
     */
    private String name;

    /**
     * 菜单类型
     */
    private Integer type;

    /**
     * 菜单标题
     */
    private String title;

    /**
     * 排序字段
     */
    private Integer seqNum;

    /**
     * 图标
     */
    private String icon;

    /**
     * 路由路径
     */
    private String path;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 权限字段
     */
    private String permissionCode;

    @TableField(exist = false)
    List<Menu> children;

}
