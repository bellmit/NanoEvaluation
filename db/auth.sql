#ums_admin：后台用户表
#ums_role：后台用户角色表
#ums_permission：后台用户权限表
#ums_admin_role_relation：后台用户和角色关系表，用户与角色是多对多关系
#ums_role_permission_relation：后台用户角色和权限关系表，角色与权限是多对多关系
#ums_admin_permission_relation：后台用户和权限关系表(除角色中定义的权限以外的加减权限)，加权限是指用户比角色多出的权限，减权限是指用户比角色少的权限

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `security_user`;
CREATE TABLE `security_user` (
`user_id` INT(5) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`role_id` INT(5) NOT NULL COMMENT '角色ID',
`username` VARCHAR(64) NOT NULL COMMENT '用户名，唯一',
`password` VARCHAR(64) NOT NULL COMMENT '密码',
`icon` VARCHAR(500) DEFAULT NULL COMMENT '头像',
`email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
`nick_name`  VARCHAR(200) DEFAULT NULL COMMENT '昵称',
`note` VARCHAR(500) DEFAULT NULL COMMENT '备注信息',
`login_time` DATETIME DEFAULT NULL COMMENT '最后登录时间',
`status` TINYINT(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
`gmt_create` DATETIME NOT NULL COMMENT '创建时间',
`gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
PRIMARY KEY(`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户表';

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
--INSERT INTO `security_user`
--VALUES ('1', 'test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG',
--'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', 'test@qq.com', '测试账号'
--, null, '2018-09-29 13:55:30', '2018-09-29 13:55:39', '1');
--INSERT INTO `ums_admin`
--VALUES ('3', 'admin', '$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO',
--'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', 'admin@163.com',
--'系统管理员', '系统管理员', '2018-10-08 13:32:47', '2019-04-20 12:45:16', '1');
--INSERT INTO `ums_admin`
--VALUES ('4', 'macro', '$2a$10$Bx4jZPR7GhEpIQfefDQtVeS58GfT5n6mxs/b4nLLK65eMFa16topa', 'string',
--'macro@qq.com', 'macro', 'macro专用', '2019-10-06 15:53:51', '2020-02-03 14:55:55', '1');
--INSERT INTO `ums_admin`
--VALUES ('6', 'productAdmin', '$2a$10$6/.J.p.6Bhn7ic4GfoB5D.pGd7xSiD1a9M6ht6yO0fxzlKJPjRAGm', null,
--'product@qq.com', '商品管理员', '只有商品权限', '2020-02-07 16:15:08', null, '1');
--INSERT INTO `ums_admin`
--VALUES ('7', 'orderAdmin', '$2a$10$UqEhA9UZXjHHA3B.L9wNG.6aerrBjC6WHTtbv1FdvYPUI.7lkL6E.', null,
--'order@qq.com', '订单管理员', '只有订单管理权限', '2020-02-07 16:15:50', null, '1');


-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `security_role`;
CREATE TABLE `security_role` (
`role_id` TINYINT (1) NOT NULL,
`name` VARCHAR(100) DEFAULT NULL COMMENT '角色名称',
`description` VARCHAR(500) DEFAULT NULL COMMENT '角色描述',
`user_count` INT(11) DEFAULT NULL COMMENT '后台用户数量',
`status` TINYINT(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
`sort` TINYINT(11) DEFAULT '0',
`gmt_create` DATETIME NOT NULL COMMENT '创建时间',
`gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
PRIMARY KEY(`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '后台用户角色表';

-- ----------------------------
-- Records of ums_role
-- ----------------------------
--INSERT INTO `security_role`
--VALUES ('1', 'Admin', '一切操作', '0', '2020-02-03 16:50:37', '1', '0');
--INSERT INTO `security_role`
--VALUES ('2', '订单管理员', '只能查看及操作订单', '0', '2018-09-30 15:53:45', '1', '0');
--INSERT INTO `security_role`
--VALUES ('5', '超级管理员', '拥有所有查看和操作功能', '0', '2020-02-02 15:11:05', '1', '0');


-- ----------------------------
-- Table structure for ums_permission
-- ----------------------------
DROP TABLE IF EXISTS `security_permission`;
CREATE TABLE `security_permission` (
    `permission_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
    `name` varchar(100) DEFAULT NULL COMMENT '名称',
    `value` varchar(200) DEFAULT NULL COMMENT '权限值',
    `icon` varchar(500) DEFAULT NULL COMMENT '图标',
    `type` int(1) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
    `uri` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
    `status` int(1) DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
    `sort` int(11) DEFAULT NULL COMMENT '排序',
    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
    PRIMARY KEY(`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '后台用户权限表';

---- ----------------------------
---- Records of ums_permission
---- ----------------------------
--INSERT INTO `ums_permission`
--VALUES ('1', '0', '商品', null, null, '0', null, '1', '2018-09-29 16:15:14', '0');
--INSERT INTO `ums_permission`
--VALUES ('2', '1', '商品列表', 'pms:product:read', null, '1', '/pms/product/index', '1',
--'2018-09-29 16:17:01', '0');
--INSERT INTO `ums_permission`
--VALUES ('3', '1', '添加商品', 'pms:product:create', null, '1', '/pms/product/add', '1',
--'2018-09-29 16:18:51', '0');
--INSERT INTO `ums_permission`
--VALUES ('4', '1', '商品分类', 'pms:productCategory:read', null, '1', '/pms/productCate/index', '1',
--'2018-09-29 16:23:07', '0');
--INSERT INTO `ums_permission`
--VALUES ('5', '1', '商品类型', 'pms:productAttribute:read', null, '1', '/pms/productAttr/index', '1',
--'2018-09-29 16:24:43', '0');
--INSERT INTO `ums_permission`
--VALUES ('6', '1', '品牌管理', 'pms:brand:read', null, '1', '/pms/brand/index', '1',
--'2018-09-29 16:25:45', '0');
--INSERT INTO `ums_permission`
--VALUES ('7', '2', '编辑商品', 'pms:product:update', null, '2', '/pms/product/updateProduct', '1',
--'2018-09-29 16:34:23', '0');
--INSERT INTO `ums_permission`
--VALUES ('8', '2', '删除商品', 'pms:product:delete', null, '2', '/pms/product/delete', '1',
--'2018-09-29 16:38:33', '0');
--INSERT INTO `ums_permission`
--VALUES ('9', '4', '添加商品分类', 'pms:productCategory:create', null, '2', '/pms/productCate/create', '1',
--'2018-09-29 16:43:23', '0');
--INSERT INTO `ums_permission`
--VALUES ('10', '4', '修改商品分类', 'pms:productCategory:update', null, '2', '/pms/productCate/update', '1'
--, '2018-09-29 16:43:55', '0');
--INSERT INTO `ums_permission`
--VALUES ('11', '4', '删除商品分类', 'pms:productCategory:delete', null, '2', '/pms/productAttr/delete', '1'
--, '2018-09-29 16:44:38', '0');
--INSERT INTO `ums_permission`
--VALUES ('12', '5', '添加商品类型', 'pms:productAttribute:create', null, '2', '/pms/productAttr/create',
--'1', '2018-09-29 16:45:25', '0');
--INSERT INTO `ums_permission`
--VALUES ('13', '5', '修改商品类型', 'pms:productAttribute:update', null, '2', '/pms/productAttr/update',
--'1', '2018-09-29 16:48:08', '0');
--INSERT INTO `ums_permission`
--VALUES ('14', '5', '删除商品类型', 'pms:productAttribute:delete', null, '2', '/pms/productAttr/delete',
--'1', '2018-09-29 16:48:44', '0');
--INSERT INTO `ums_permission`
--VALUES ('15', '6', '添加品牌', 'pms:brand:create', null, '2', '/pms/brand/add', '1',
--'2018-09-29 16:49:34', '0');
--INSERT INTO `ums_permission`
--VALUES ('16', '6', '修改品牌', 'pms:brand:update', null, '2', '/pms/brand/update', '1',
--'2018-09-29 16:50:55', '0');
--INSERT INTO `ums_permission`
--VALUES ('17', '6', '删除品牌', 'pms:brand:delete', null, '2', '/pms/brand/delete', '1',
--'2018-09-29 16:50:59', '0');
--INSERT INTO `ums_permission`
--VALUES ('18', '0', '首页', null, null, '0', null, '1', '2018-09-29 16:51:57', '0');



-- ----------------------------
-- Table structure for security_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `security_user_role_relation`;
CREATE TABLE `security_user_role_relation` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `user_id` INT(10) DEFAULT NULL,
    `role_id` INT(10) DEFAULT NULL,
    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
    PRIMARY KEY(`id`)
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '后台用户和角色关系表';

-- ----------------------------
-- Records of ums_admin_role_relation
-- ----------------------------
--INSERT INTO `ums_admin_role_relation`
--VALUES ('26', '3', '5');
--INSERT INTO `ums_admin_role_relation`
--VALUES ('27', '6', '1');
--INSERT INTO `ums_admin_role_relation`
--VALUES ('28', '7', '2');
--INSERT INTO `ums_admin_role_relation`
--VALUES ('29', '1', '5');
--INSERT INTO `ums_admin_role_relation`
--VALUES ('30', '4', '5');


-- ----------------------------
-- Table structure for security_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `security_role_permission_relation`;
CREATE TABLE `security_role_permission_relation` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `role_id` INT(10) DEFAULT NULL,
    `permission_id` INT(10) DEFAULT NULL,
    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
    PRIMARY KEY(`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '后台用户角色和权限关系表';

---- ----------------------------
---- Records of ums_role_permission_relation
---- ----------------------------
--INSERT INTO `ums_role_permission_relation`
--VALUES ('1', '1', '1');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('2', '1', '2');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('3', '1', '3');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('4', '1', '7');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('5', '1', '8');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('6', '2', '4');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('7', '2', '9');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('8', '2', '10');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('9', '2', '11');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('10', '3', '5');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('11', '3', '12');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('12', '3', '13');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('13', '3', '14');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('14', '4', '6');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('15', '4', '15');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('16', '4', '16');
--INSERT INTO `ums_role_permission_relation`
--VALUES ('17', '4', '17');


-- ----------------------------
-- Table structure for security_user_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `security_user_permission_relation`;
CREATE TABLE `security_user_permission_relation` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `admin_id` INT(10) DEFAULT NULL,
    `permission_id` INT(10) DEFAULT NULL,
    `type` TINYINT(1) DEFAULT NULL,
    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
    PRIMARY KEY(`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '后台用户和权限关系表(除角色中定义的权限以外的加减权限)';

-- ----------------------------
-- Records of ums_admin_permission_relation
-- ----------------------------
