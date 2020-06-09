DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `id` bigint(20) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` bigint(20) NOT NULL,
  `last_modified_date` datetime NOT NULL,
  `version` int(11) DEFAULT NULL,
  `user_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `login_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
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

