CREATE TABLE `sys_dept` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(50) DEFAULT NULL COMMENT '机构名称',
    `parent_id` bigint(20) DEFAULT NULL COMMENT '上级机构ID，一级机构为0',
    `order_num` int(11) DEFAULT NULL COMMENT '排序',
    `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除 -1: 已删除 0: 正常',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='机构管理';