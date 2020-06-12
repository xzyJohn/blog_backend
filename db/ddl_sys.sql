CREATE DATABASE `blog` ;

USE `blog`;

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `id` bigint(20) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `version` int(11) DEFAULT NULL,
  `user_name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名（昵称）',
  `password` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `phone` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `status` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '状态',
  `user_type` bigint(20) DEFAULT NULL COMMENT '用户类型（角色）',
  `email` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮件',
  `login_name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '登陆名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `tbl_menu`;

CREATE TABLE `tbl_menu` (
  `id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '路由名称',
  `type` int(11) DEFAULT NULL COMMENT '菜单类型',
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单标题',
  `seq_num` int(11) DEFAULT NULL COMMENT '排序字段',
  `icon` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图标',
  `path` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '路由路径',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级id',
  `permission_code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '权限字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `tbl_permission`;

CREATE TABLE `tbl_permission` (
  `id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '权限名称',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '权限描述',
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '权限代码',
  `menu_id` bigint(255) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `tbl_role`;

CREATE TABLE `tbl_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色描述',
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色代码',
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `tbl_role_menu`;

CREATE TABLE `tbl_role_menu` (
  `id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `tbl_role_permission`;

CREATE TABLE `tbl_role_permission` (
  `id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

