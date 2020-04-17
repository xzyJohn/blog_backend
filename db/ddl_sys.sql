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
