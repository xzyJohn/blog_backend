package com.blog.modules.system.service;

import com.blog.modules.system.entity.RolePermission;
import com.blog.modules.base.service.MyService;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-12
 */
public interface RolePermissionService extends MyService<RolePermission> {
    /**
     * 根据角色id删除数据
     * @param id
     * @return
     */
    int deleteByRoleId(Long id);
}
