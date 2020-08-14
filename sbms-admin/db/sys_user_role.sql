CREATE TABLE `sys_user_role` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
    `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
    `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='用户角色';