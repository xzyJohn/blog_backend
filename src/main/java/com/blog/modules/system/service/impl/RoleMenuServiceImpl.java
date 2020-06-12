package com.blog.modules.system.service.impl;

import com.blog.modules.system.entity.RoleMenu;
import com.blog.modules.system.mapper.RoleMenuMapper;
import com.blog.modules.system.service.RoleMenuService;
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
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements RoleMenuService {

}
