DROP DATABASE IF EXISTS spring_boot_core;
CREATE DATABASE IF NOT EXISTS spring_boot_core DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
DROP DATABASE IF EXISTS spring_boot_biz_one;
CREATE DATABASE IF NOT EXISTS spring_boot_biz_one DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
DROP DATABASE IF EXISTS spring_boot_biz_two;
CREATE DATABASE IF NOT EXISTS spring_boot_biz_two DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE spring_boot_core;
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `core_user`;
CREATE TABLE `core_user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`age` INT(11) NULL COMMENT '年龄',
	`name` VARCHAR(255) NULL COMMENT '姓名',
	`mobile` VARCHAR(11) NULL COMMENT '手机号',
	`password` VARCHAR(64) NULL DEFAULT NULL COMMENT '密码',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `mobile` (`mobile`)
)
COMMENT='用户表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

USE spring_boot_biz_one;
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `one_user`;
CREATE TABLE `one_user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`age` INT(11) NULL COMMENT '年龄',
	`name` VARCHAR(255) NULL COMMENT '姓名',
	`mobile` VARCHAR(11) NULL COMMENT '手机号',
	`password` VARCHAR(64) NULL DEFAULT NULL COMMENT '密码',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `mobile` (`mobile`)
)
COMMENT='用户表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

USE spring_boot_biz_two;
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `two_user`;
CREATE TABLE `two_user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`age` INT(11) NULL COMMENT '年龄',
	`name` VARCHAR(255) NULL COMMENT '姓名',
	`mobile` VARCHAR(11) NULL COMMENT '手机号',
	`password` VARCHAR(64) NULL DEFAULT NULL COMMENT '密码',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `mobile` (`mobile`)
)
COMMENT='用户表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

