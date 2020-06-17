package com.blog.modules.system.service.impl;

import com.blog.modules.system.entity.Role;
import com.blog.modules.system.entity.RolePermission;
import com.blog.modules.system.mapper.RoleMapper;
import com.blog.modules.system.service.RolePermissionService;
import com.blog.modules.system.service.RoleService;
import com.blog.modules.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-12
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Resource
    RolePermissionService rolePermissionService;

    @Override
    public void createRole(Role role) {
        //先将role插入表中
        this.save(role);
        //取出role中的permissionIds，遍历，插入role-permission表
        List<Long> permissionIds = role.getPermissionIds();
        permissionIds.forEach(permissionId->{
            RolePermission rolePermission = new RolePermission();
            rolePermission.setPermissionId(permissionId);
            rolePermission.setRoleId(role.getId());
            rolePermissionService.save(rolePermission);
        });
    }

    @Override
    public void updateRole(Role role) {
        this.updateById(role);
        List<Long> permissionIds = role.getPermissionIds();
        rolePermissionService.deleteByRoleId(role.getId());
        permissionIds.forEach(permissionId->{
            RolePermission rolePermission = new RolePermission();
            rolePermission.setPermissionId(permissionId);
            rolePermission.setRoleId(role.getId());
            rolePermissionService.save(rolePermission);
        });
    }

    @Override
    public void deleteRole(Long id) {
        this.removeById(id);
        rolePermissionService.deleteByRoleId(id);
    }
}
