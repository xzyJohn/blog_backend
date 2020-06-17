package com.blog.modules.system.mapper;

import com.blog.modules.system.entity.RolePermission;
import com.blog.modules.base.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-12
 */
public interface RolePermissionMapper extends MyMapper<RolePermission> {

    /**
     * 根据角色id删除数据
     * @param id
     * @return
     */
    int deleteByRoleId(@Param("id") Long id);

}
