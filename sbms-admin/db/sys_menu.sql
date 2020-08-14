CREATE TABLE `sys_menu` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
    `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
    `url` varchar(200) DEFAULT NULL COMMENT '菜单URL，类型: 1. 普通页面（如用户管理，/sys/user 2. 嵌套完整页面，以http(s)开头的链接 3. 嵌套服务器页面，使用iframe:前缀+目标URL（如SQL监控，iframe:/druid/login.html, iframe前缀会替换成服务器地址）',
    `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔, 如sys:user:add,sys:user:edit)',
    `type` int(11) DEFAULT NULL COMMENT '类型 0：目录，1：菜单，2：按钮',
    `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
    `order_num` int(11) DEFAULT NULL COMMENT '排序',
    `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除 -1: 已删除 0: 正常',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='菜单管理';