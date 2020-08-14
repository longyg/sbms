CREATE TABLE `sys_role` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
    `remark` varchar(100) DEFAULT NULL COMMENT '备注',
    `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除 -1: 已删除 0: 正常',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色管理';