CREATE TABLE timecard (
  `u_id` INT(11) NOT NULL,
  `datetime` DATETIME NOT NULL,
  `province` VARCHAR(20) NULL,
  `city` VARCHAR(20) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci' NULL,
  `county` VARCHAR(20) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci' NULL,
  `detailLocation` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci' NULL,
  `temperature` FLOAT NULL,
  `healthcode` VARCHAR(4) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci' NULL,
  PRIMARY KEY (`u_id`, `datetime`),
  CONSTRAINT `u_id`
    FOREIGN KEY (`u_id`)
    REFERENCES `user` (`u_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `timecard` (`u_id`, `datetime`, `province`, `city`, `county`, `detailLocation`,`temperature`, `healthcode`) 
VALUES (10001, '2021-05-18 07:22:14', '浙江省', '杭州市', '西湖区', NULL,'36.4', '绿码');
INSERT INTO `timecard` (`u_id`, `datetime`, `province`, `city`, `county`, `detailLocation`,`temperature`, `healthcode`) 
VALUES (10002, '2021-05-18 07:22:14', '浙江省', '杭州市', '下城区', NULL,'36.4', '绿码');