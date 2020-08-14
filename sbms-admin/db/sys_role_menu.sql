CREATE TABLE `sys_role_menu` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
    `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
    `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=469 DEFAULT CHARSET=utf8 COMMENT='角色菜单';