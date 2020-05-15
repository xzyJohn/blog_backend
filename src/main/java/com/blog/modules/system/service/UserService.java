package com.blog.modules.system.service;

import com.blog.modules.base.service.MyService;
import com.blog.modules.system.entity.User;

/**
 * @Author: xzy
 * @Description:
 * @Date: Created in 11:03 2020/4/17
 */
public interface UserService extends MyService<User> {
    /**
     * 根据用户名查询用户
     * @param name 用户名
     * @return User
     */
    User getByUsername(String name);
}
