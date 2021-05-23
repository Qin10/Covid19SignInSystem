DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
    `u_id` int(11) NOT NULL AUTO_INCREMENT,
    `u_nickname` varchar(255) DEFAULT NULL COMMENT '用户昵称',
    `u_gender` tinyint(1) DEFAULT NULL COMMENT '用户性别(1:男, 0:女)',
    `u_type_id` int(11) DEFAULT NULL COMMENT '用户类别',
    `u_avatar_url` varchar(255) DEFAULT NULL COMMENT '用户头像文件保存路径',
    `u_school` varchar(255) DEFAULT NULL COMMENT '用户学校',
    `u_academy` varchar(255) DEFAULT NULL COMMENT '用户学院',
    `u_major` varchar(255) DEFAULT NULL COMMENT '用户主修专业',
    `u_grade` int(11) DEFAULT NULL COMMENT '用户当前年级',
    `u_class` varchar(255) DEFAULT NULL COMMENT '用户当前班级',
    `u_stu_num` varchar(255) DEFAULT NULL COMMENT '用户学号',
    `u_true_name` varchar(255) DEFAULT NULL COMMENT '用户真实姓名',
    `u_created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '账户首次登录时间',
    PRIMARY KEY (`u_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` VALUES (10001, 'patricy', 1, 0, '/usr', '浙江大学', '软件学院', '软件工程', 2019, '软工1903', '201906150312', '秦政瀚', '2021-05-17 19:04:31');
INSERT INTO `user` VALUES (10002, ' mike', 1, 1, NULL, '浙江工业大学', '计算机', '计算机科学与技术', 2018, '计科1901', '201906010135', 'C罗', '2021-05-16 22:40:03');

DROP TABLE IF EXISTS `oauth`;
CREATE TABLE `oauth` (
  `oa_user_id` int(11) NOT NULL COMMENT '被授权用户id',
  `oa_oauth_type` varchar(255) NOT NULL COMMENT '授权类型',
  `oa_oauth_id` varchar(255) NOT NULL COMMENT '授权码(手机号，微信号等)',
  `oa_unionid` varchar(255) DEFAULT NULL COMMENT '微信unionid(预留字段)',
  `oa_credential` varchar(255) DEFAULT NULL COMMENT '授权秘钥(预留字段)',
  PRIMARY KEY (`oa_user_id`,`oa_oauth_type`) USING BTREE,
  KEY `oauth_ibfk_1` (`oa_user_id`) USING BTREE,
  CONSTRAINT `oauth_ibfk_1` FOREIGN KEY (`oa_user_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `oauth` VALUES (10001, 'wechat', 'oOyAT5NTT-AJAuF4RMoyaXVUxgas', NULL, NULL);

DROP TABLE IF EXISTS `timecard`;
CREATE TABLE `timecard` (
  `u_id` INT NOT NULL, 
  `datetime` DATETIME NOT NULL,
  `province` VARCHAR(20) NULL,
  `city` VARCHAR(20) NULL,
  `county` VARCHAR(20) NULL,
  `temperature` FLOAT NULL,
  `healthcode` VARCHAR(4) NULL,
  PRIMARY KEY (`u_id`, `datetime`),
  UNIQUE INDEX `county_UNIQUE` (`county` ASC),
  CONSTRAINT `fk_timecard_uid`
    FOREIGN KEY (`u_id`)
    REFERENCES `user` (`u_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `timecard` VALUES (10001, '2021-05-12 07:22:14', '浙江省', '杭州市', '西湖区', 36.4, '绿码');