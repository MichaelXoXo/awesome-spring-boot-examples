SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `users` VALUES (1,'michael翔', '123', 'MAN', 'zx');
INSERT INTO `users` VALUES (2,'张小敬', '123', 'MAN', 'zxj');
INSERT INTO `users` VALUES (3,'李司辰', '123', 'MAN', 'lsc');
INSERT INTO `users` VALUES (4,'崔器', '123', 'MAN', 'cq');
INSERT INTO `users` VALUES (5,'姚汝能', '123', 'MAN', 'yrn');
INSERT INTO `users` VALUES (null,'檀棋', '123', ' WOMAN', 'tq');
INSERT INTO `users` (`userName`,`passWord`,`user_sex`,`nick_name`) VALUES ('michael', '123', 'MAN', 'zx');

