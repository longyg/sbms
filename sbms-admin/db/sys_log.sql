CREATE TABLE `sys_log` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
    `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
    `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
    `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
    `time` bigint(20) NOT NULL COMMENT '执行时长（毫秒）',
    `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
    `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2798 DEFAULT CHARSET=utf8 COMMENT='系统操作日志';