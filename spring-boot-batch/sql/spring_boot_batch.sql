DROP DATABASE IF EXISTS spring_boot_batch;
CREATE DATABASE IF NOT EXISTS spring_boot_batch DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE spring_boot_batch;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`age` INT(11) NULL COMMENT '年龄',
	`name` VARCHAR(255) NULL COMMENT '姓名',
	PRIMARY KEY (`id`)
)
COMMENT='用户表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
