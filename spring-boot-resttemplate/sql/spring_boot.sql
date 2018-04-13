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

