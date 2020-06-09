package com.blog.core.utils;

/**
 *
 * 常用常量
 * @author xzy
 * @date Created in 17:51 2020/6/9
 */
public interface Constants {
    /**
     * 菜单状态
     */
    interface MenuStatus{
        /**
         * 可用的
         */
        Integer AVAILABLE = 1;
        /**
         * 不可用的
         */
        Integer UNAVAILABLE = 0;
    }

    /**
     * 菜单类型
     */
    interface MenuType{
        /**
         * 子菜单
         */
        Integer CHILDREN = 0;
        /**
         * 父级菜单
         */
        Integer PARENT = 1;
    }
}
