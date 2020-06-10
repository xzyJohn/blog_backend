package com.blog.modules.system.mapper;

import com.blog.modules.system.entity.Menu;
import com.blog.modules.base.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-09
 */
public interface MenuMapper extends MyMapper<Menu> {

    /**
     * 根据菜单类型获取排序字段
     * @param type 类型
     * @param parentId 父菜单id
     * @return
     */
    Integer getMenuSeqNum(@Param("parentId") Long parentId, @Param("type") Integer type);

    /**
     * 根据parentId删除子菜单
     * @param parentId
     * @return
     */
    Integer deleteByParentId(@Param("parentId") Long parentId);
}
