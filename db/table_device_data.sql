

-- ----------------------------
-- 诺和NW9002S
-- ----------------------------
create TABLE `data_norwamd_9002s`
(
    `pk_id`              INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增长',
    `operation_number`     INT UNSIGNED NOT NULL COMMENT '手术顺序号，外键连接手术信息表',
    `device_serial_number` VARCHAR(32)  NOT NULL DEFAULT '-1' COMMENT '设备序列号，不一定唯一',
    `BS`                   TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `EMG`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `SQI`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `CSI`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `gmt_create`           DATETIME     NOT NULL COMMENT '创建时间',
    `gmt_modified`         DATETIME    NOT NULL COMMENT '修改时间',
    PRIMARY KEY (pk_id)
) COMMENT '诺和9002s的数据表5';


-- ----------------------------
-- 普可YY106
-- ----------------------------
create TABLE `data_pearlcare_yy106`
(
    `pk_id`                INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增长',
    `operation_number`     INT UNSIGNED NOT NULL COMMENT '手术顺序号，外键连接手术信息表',
    `device_serial_number` VARCHAR(32)  NOT NULL DEFAULT '-1' COMMENT '设备序列号，不一定唯一',
    `SQI`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `AI`                   TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `EMG`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `BSR`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `gmt_create`           TIMESTAMP    NOT NULL COMMENT '创建时间',
    `gmt_modified`         TIMESTAMP    NOT NULL COMMENT '修改时间',
    PRIMARY KEY (pk_id)
) COMMENT '普可yy106的数据表6';
