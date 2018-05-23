DROP DATABASE IF EXISTS spring_boot;
CREATE DATABASE IF NOT EXISTS spring_boot DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE spring_boot;
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR(50) NOT NULL COMMENT '用户名',
	`mobile` VARCHAR(50) NULL DEFAULT NULL COMMENT '手机号',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `username` (`user_name`)
)
COMMENT='用户'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;