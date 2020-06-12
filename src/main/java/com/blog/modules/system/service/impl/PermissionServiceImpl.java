package com.blog.modules.system.service.impl;

import com.blog.modules.system.entity.Permission;
import com.blog.modules.system.mapper.PermissionMapper;
import com.blog.modules.system.service.PermissionService;
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
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {

}
