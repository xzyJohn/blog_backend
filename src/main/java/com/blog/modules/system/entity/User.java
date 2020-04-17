package com.blog.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blog.modules.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author: xzy
 * @Description:
 * @Date: Created in 9:55 2020/4/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tbl_user")
public class User extends BaseEntity {

    private String userName;

    private String password;

    private String address;

    private String phone;

    private String status;

    private Integer userType;

    private String email;

    private String loginName;
}
