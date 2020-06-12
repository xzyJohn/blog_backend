package com.blog.modules.system.service.impl;

import com.blog.modules.system.entity.RolePermission;
import com.blog.modules.system.mapper.RolePermissionMapper;
import com.blog.modules.system.service.RolePermissionService;
import com.blog.modules.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-12
 */
@Service
@Transactional
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermission> implements RolePermissionService {

}
