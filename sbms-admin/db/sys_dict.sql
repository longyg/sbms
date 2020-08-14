CREATE TABLE `sys_dict` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `value` varchar(100) NOT NULL COMMENT '数据值',
    `label` varchar(100) NOT NULL COMMENT '标签名',
    `type` varchar(100) NOT NULL COMMENT '类型',
    `description` varchar(100) NOT NULL COMMENT '描述',
    `sort` decimal(10, 0) NOT NULL COMMENT '排序（升序）',
    `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
    `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除 -1: 已删除 0: 正常',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='字典表';