package com.blog.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.modules.base.mapper.MyMapper;
import com.blog.modules.base.service.MyService;

/**
 * @Author: xzy
 * @Description:
 * @Date: Created in 13:36 2020/4/2
 */
public abstract class BaseServiceImpl<T> extends ServiceImpl<MyMapper<T>,T> implements MyService<T>{
}
