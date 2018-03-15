DROP DATABASE IF EXISTS spring_boot;
CREATE DATABASE IF NOT EXISTS spring_boot DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE spring_boot;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='用户表';


-- ----------------------------
-- Records of sys_user
-- ----------------------------

INSERT INTO `sys_user` VALUES ('1', '20', '武海升');
INSERT INTO `sys_user` VALUES ('2', '23', '慕小谦');