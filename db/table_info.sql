--
--/**
--* Copyright 2019-2029 nanodaemony(https://github.com/nanodaemony/NanoEvaluation)
--*
--* Licensed under the Apache License, Version 2.0 (the "License");
--* you may not use this file except in compliance with the License.
--* You may obtain a copy of the License at
--*
--* http: / / www.apache.org / licenses / LICENSE-2.0
--*
--* Unless required by applicable law or agreed to in writing, software
--* distributed under the License is distributed on an "AS IS" BASIS,
--* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--* See the License for the specific language governing permissions and
--* limitations under the License.
--* /

-- ----------------------------
-- 手术信息表
-- ----------------------------
create TABLE `info_operation`
(
    `pk_operation_number` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键，手术场次号,自增',
    `admission_id` VARCHAR(64)    NOT NULL COMMENT '住院号',
    `hospital_operation_number` VARCHAR(32)  NOT NULL COMMENT '医院的手术顺序号',

    `patient_id`       VARCHAR(32)       NOT NULL COMMENT '病人身份证号',
    `patient_sex`              TINYINT           NOT NULL COMMENT '性别0--男，1--女',
    `patient_height`           TINYINT UNSIGNED  NOT NULL COMMENT '身高',
    `patient_weight`           TINYINT UNSIGNED  NOT NULL COMMENT '体重',
    `patient_age`              TINYINT UNSIGNED  NOT NULL COMMENT '年龄',

    `operation_name`            VARCHAR(64)  NOT NULL COMMENT '手术名称',
    `operation_anesthesia_mode`  VARCHAR(32) NOT NULL COMMENT '麻醉方式',
    `operation_is_urgent`        TINYINT     NOT NULL COMMENT '是否急诊',
    `operation_asa_level`        TINYINT     NOT NULL COMMENT 'ASA等级',
    `past_medical_history`  TEXT              NOT NULL COMMENT '既往病史',
    `special_case`     TEXT              NOT NULL COMMENT '特殊情况',

    `collector_mac_address`     CHAR(20) NOT NULL COMMENT '采集器MAC地址',
    `operation_start_time`      DATETIME    NOT NULL COMMENT '手术开始时间',
    `operation_end_time`        DATETIME    NOT NULL COMMENT '手术结束时间',
    `operation_state`           TINYINT      NOT NULL DEFAULT 0 COMMENT '手术状态，0未开始，1正在进行，2已经结束,-1表示异常',

    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL COMMENT '更新时间',
    INDEX `admission_id` (`admission_id`),
    INDEX `operation_name` (`operation_name`),
    INDEX `operation_state` (`operation_state`),
    PRIMARY KEY(pk_operation_number)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '手术信息表';


-- ----------------------------
-- 仪器信息表
-- ----------------------------
create TABLE `info_device`
(
    `pk_id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
    `device_code`          VARCHAR(32)       NOT NULL COMMENT '设备号，自行定义，需要设备号对应的仪器名',
    `device_serial_number` VARCHAR(32)       NOT NULL COMMENT '设备序列号，不一定唯一',
    `device_produce_date`  DATE              COMMENT '设备购买时间 eg: 2017-08-01',
    `device_service_life`  FLOAT             NOT NULL COMMENT '设备使用年限',
    `device_name` VARCHAR(32) NOT NULL COMMENT '仪器名称',
    `company_name` VARCHAR(32) NOT NULL COMMENT '公司名称',
    `device_type` VARCHAR(32) NOT NULL COMMENT '仪器类型（大类：麻醉机、呼吸机、监护仪等），如果涉及多个类别存成字符串形式',

    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY(pk_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '仪器信息表';


---- ----------------------------
---- 仪器厂家及类型信息表
---- ----------------------------
--create TABLE `info_device_company`
--(
--    `pk_id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
--    `device_code`  VARCHAR(32) NOT NULL COMMENT '设备号，自行定义，需要设备号对应的仪器名',
--    `device_name`  VARCHAR(32) NOT NULL COMMENT '仪器名称',
--    `device_type`  VARCHAR(32) NOT NULL COMMENT '仪器类型（大类：麻醉机、呼吸机、监护仪等）',
--    `company_name` VARCHAR(32) NOT NULL COMMENT '公司名称',
--
--    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
--    `gmt_modified` DATETIME NOT NULL COMMENT '更新时间',
--    PRIMARY KEY(pk_id)
--) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '仪器信息表';




-- ----------------------------
-- 手术使用仪器信息表
-- ----------------------------
create TABLE `info_operation_device`
(
    `pk_id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
    `operation_number` INT UNSIGNED NOT NULL COMMENT '手术场次号',
    `device_code`          VARCHAR(32)       NOT NULL COMMENT '设备号，自行定义，需要设备号对应的仪器名',
    `device_info_id`  TINYINT NOT NULL COMMENT '外键，仪器信息表中仪器的行号ID',

    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY(`pk_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '手术使用仪器信息表';


-- ----------------------------
-- 手术标记信息表
-- ----------------------------
create TABLE `info_operation_mark`
(
    `pk_id`                INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标记id，自动增长',
    `operation_number`     INT UNSIGNED NOT NULL COMMENT '手术场次号，外键连接手术信息表',
    `mark_main_type`       VARCHAR(32)  NOT NULL COMMENT '标记大类型',
    `mark_sub_Type`        VARCHAR(32)  NOT NULL COMMENT '标记小类型',
    `mark_event`           VARCHAR(32)  NOT NULL COMMENT '事件类型',
    `give_medicine_method` VARCHAR(32)  NOT NULL COMMENT '途径',
    `give_medicine_volume` VARCHAR(32)  NOT NULL COMMENT '剂量',
    `side_effect`          VARCHAR(256) NOT NULL COMMENT '不良反应/特殊情况',
    `mark_time`            DATETIME    NOT NULL COMMENT '标记信息标记的时间',

    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY (pk_id)
) COMMENT '手术标记信息表';


-- ----------------------------
-- 术后仪器评价表
-- ----------------------------
CREATE TABLE `info_evaluation` (
    `pk_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID, 主键',
    `operation_number` INT NOT NULL COMMENT '手术场次号',
    `device_code` INT NOT NULL COMMENT '创建时间',
    `serial_number` VARCHAR(64) NOT NULL COMMENT '修改时间',
    `device_department` VARCHAR(256) NOT NULL COMMENT '使用科室',
    `experience_level` VARCHAR(256) NOT NULL COMMENT '使用评价等级',
    `reliability_level` VARCHAR(256) NOT NULL COMMENT '可靠性等级',
    `has_error` BOOL NOT NULL COMMENT '是否有错误信息',
    `known_error` VARCHAR(256) NOT NULL COMMENT '错误原因',
    `other_error` VARCHAR(256) NOT NULL COMMENT '其他错误',
    `remark` VARCHAR(256) NOT NULL COMMENT '记录人签名',
    `record_name` VARCHAR(32) NOT NULL COMMENT '错误原因',

    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY (pk_id)
) COMMENT '术后仪器评价表';


-- ----------------------------
-- 系统日志表
-- ----------------------------
CREATE TABLE `system_log`
(
    `pk_id`        SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `log_level`     TINYINT              NOT NULL COMMENT '日志级别',
    `message`      TEXT                 NOT NULL COMMENT '日志信息',
    `record_date`  VARCHAR(32)          NOT NULL COMMENT '日志记录时间',

    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY (pk_id)
) COMMENT '系统日志表';


