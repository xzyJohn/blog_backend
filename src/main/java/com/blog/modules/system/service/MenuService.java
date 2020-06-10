package com.blog.modules.system.service;

import com.blog.modules.system.entity.Menu;
import com.blog.modules.base.service.MyService;

import java.util.List;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-09
 */
public interface MenuService extends MyService<Menu> {

    /**
     * 获取前端菜单列表
     * @return 菜单列表
     */
    List<Menu> getMenuTree();

    /**
     * 根据菜单类型获取排序字段
     * @param type 类型
     * @param parentId 父菜单id
     * @return
     */
    Integer getMenuSeqNum(Long parentId,Integer type);

    /**
     * 根据id删除菜单
     * @param id
     * @return
     */
    Boolean deleteById(Long id);
}
