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

INSERT INTO `user` VALUES (10001, 'leo', 1, 0, NULL, '浙江工业大学', '计算机', '软件工程（中外合作）', 2019, '软外1903班', '201906150366', '梅西', '2021-05-11 00:55:22');

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

INSERT INTO `timecard` (`u_id`, `datetime`, `province`, `city`, `county`, `temperature`, `healthcode`) 
VALUES ('10001', '2021-05-12 07:22:14', '浙江省', '杭州市', '西湖区', '36.4', '绿码');

{
  "uId": 10001,
  "uNickname": "patricy",
  "uGender": true,
  "uTypeId": 0,
  "uAvatarUrl": "/home",
  "uSchool": "浙江工业大学",
  "uAcademy": "计算机",
  "uMajor": "软外",
  "uGrade": 2019,
  "uClass": "软外1903",
  "uStuNum": "201906150312",
  "uTrueName": "秦政瀚",
  "uCreatedTime": "2021-05-17 07:56:15"
}

