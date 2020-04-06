create table user
(
  `pk_id` TINYINT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `phone` CHAR(11) NOT NULL COMMENT '电话,唯一',
  `user_name` char(15) not null COMMENT '用户姓名',
  `user_password` char(15) not null COMMENT '用户密码',
  `email` varchar(20) not null COMMENT '用户邮箱,唯一',
  `forbidden` BOOLEAN NOT NULL DEFAULT FALSE COMMENT '是否禁用，默认为False不禁用',
  `gmt_create`           DATETIME     NOT NULL COMMENT '创建时间',
  `gmt_modified`         DATETIME    NOT NULL COMMENT '修改时间',
  INDEX `phone` (`phone`),
  INDEX `email` (`email`),
  PRIMARY KEY(`pk_id`)
) engine = innodb default charset = utf8;



