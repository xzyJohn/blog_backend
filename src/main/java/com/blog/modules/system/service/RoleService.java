package com.blog.modules.system.service;

import com.blog.modules.system.entity.Role;
import com.blog.modules.base.service.MyService;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-12
 */
public interface RoleService extends MyService<Role> {
    /**
     * 创建角色
     * @param role
     */
    void createRole(Role role);

    /**
     * 更新角色
     * @param role
     */
    void updateRole(Role role);

    /**
     * 根据id删除角色
     * @param id
     */
    void deleteRole(Long id);
}
