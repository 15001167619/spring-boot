DROP DATABASE IF EXISTS spring_boot;
CREATE DATABASE IF NOT EXISTS spring_boot DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE spring_boot;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`age` INT(11) NULL COMMENT '年龄',
	`name` VARCHAR(255) NULL COMMENT '姓名',
	`mobile` VARCHAR(11) NULL COMMENT '手机号',
	`password` VARCHAR(64) NULL DEFAULT NULL COMMENT '密码',
	`salt` VARCHAR(64) NULL DEFAULT NULL COMMENT 'Md5加密盐',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `mobile` (`mobile`)
)
COMMENT='用户表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;


-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` (`age`, `name`, `mobile`, `password`) VALUES (18, '武海升', '15001167619', '666');
INSERT INTO `sys_user` (`age`, `name`, `mobile`, `password`) VALUES (20, '慕小谦', '15001167609', '666');


DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID 项目Id',
	`role_name` VARCHAR(100) NOT NULL COMMENT '角色名称',
	`create_user_id` VARCHAR(64) NOT NULL COMMENT '创建者',
	`create_date` DATETIME NOT NULL COMMENT '创建时间',
	`update_user_id` VARCHAR(64) NOT NULL COMMENT '修改者',
	`update_date` DATETIME NOT NULL COMMENT '修改时间',
	`remarks` VARCHAR(255) NULL DEFAULT NULL COMMENT '备注信息',
	`del_flag` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0' COMMENT '删除标记 0：正常；1：删除；默认0',
	PRIMARY KEY (`id`)
)
COMMENT='角色表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

INSERT INTO `sys_role`  VALUES (1, '皇帝', '10000', '2018-03-16 17:36:49', '10000', '2018-03-16 17:37:08', '创建皇帝角色',0);
INSERT INTO `sys_role`  VALUES (2, '皇后', '10001', '2018-03-16 17:36:50', '10001', '2018-03-16 17:37:11', '创建皇后角色',0);
INSERT INTO `sys_role`  VALUES (3, '太师', '10002', '2018-03-16 17:36:51', '10002', '2018-03-16 17:37:15', '创建太师角色',0);
INSERT INTO `sys_role`  VALUES (4, '士兵', '10003', '2018-03-16 17:36:52', '10003', '2018-03-16 17:37:28', '创建士兵角色',0);
INSERT INTO `sys_role`  VALUES (5, '贵人', '10004', '2018-03-16 17:36:53', '10004', '2018-03-16 17:37:38', '创建贵人角色',0);

CREATE TABLE `sys_role_user` (
	`role_id` INT(11) NOT NULL COMMENT '角色Id',
	`user_id` INT(11) NOT NULL COMMENT '用户Id',
	`role_grade` INT(11) NOT NULL DEFAULT '1' COMMENT '角色等级',
	PRIMARY KEY (`role_id`, `user_id`),
	INDEX `role_id` (`role_id`),
	INDEX `user_id` (`user_id`)
)
COMMENT='用户角色关联表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

INSERT INTO `sys_role_user`  VALUES (1, 1, 2);
INSERT INTO `sys_role_user`  VALUES (1, 2, 5);
INSERT INTO `sys_role_user`  VALUES (3, 1, 7);
INSERT INTO `sys_role_user`  VALUES (4, 1, 7);

DROP DATABASE IF EXISTS spring_boot_biz;
CREATE DATABASE IF NOT EXISTS spring_boot_biz DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
USE spring_boot_biz;
SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE `sys_user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`age` INT(11) NULL DEFAULT NULL COMMENT '年龄',
	`name` VARCHAR(255) NULL DEFAULT NULL COMMENT '姓名',
	`mobile` VARCHAR(11) NULL DEFAULT NULL COMMENT '手机号',
	`password` VARCHAR(64) NULL DEFAULT NULL COMMENT '密码',
	`salt` VARCHAR(64) NULL DEFAULT NULL COMMENT 'Md5加密盐',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `mobile` (`mobile`)
)
COMMENT='用户表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
