create TABLE `info_device`
(
    `pk_id`                SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `device_code`          VARCHAR(32)       NOT NULL COMMENT '设备号，自行定义，需要设备号对应的仪器名',
    `device_serial_number` VARCHAR(32)       NOT NULL COMMENT '设备序列号，不一定唯一',
    `device_produce_date`  DATE              NOT NULL COMMENT '设备购买时间 eg: 2017-08-01',
    `device_service_life`  FLOAT             NOT NULL COMMENT '设备使用年限',
    `gmt_create`           TIMESTAMP         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`         TIMESTAMP         NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_id`)
) COMMENT '设备信息表，信息需要手动输入';

create TABLE `info_hospital`
(
    `pk_hospital_code` VARCHAR(32) NOT NULL COMMENT '全国医院序列号，唯一',
    `hospital_name`    VARCHAR(32) NOT NULL COMMENT '医院名称',
    `hospital_area`    VARCHAR(32) NOT NULL COMMENT '医院区域',
    `hospital_level`   VARCHAR(32) NOT NULL COMMENT '医院的等级3甲等',
    `gmt_create`       TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_hospital_code`)
) COMMENT '医院信息表，信息需要手动输入';

create TABLE `info_operation`
(
    `pk_operation_number`       INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '手术顺序号',
    `operation_name`            VARCHAR(64)  NOT NULL COMMENT '手术名称',
    `operation_start_time`      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '手术开始时间',
    `operation_end_time`        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '手术结束时间',
    `operation_state`           TINYINT      NOT NULL DEFAULT 0 COMMENT '手术状态，0未开始，1正在进行，2已经结束',
    `gmt_create`                TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`              TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    `hospital_code`             VARCHAR(32)  NOT NULL COMMENT '医院国内代号，外键连接医院信息表',
    `hospital_operation_number` VARCHAR(32)  NOT NULL COMMENT '医院的手术顺序号',
    PRIMARY KEY (pk_operation_number)
) COMMENT '手术信息表4';

create TABLE `info_operation_mark`
(
    `pk_id`                INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标记id，自动增长',
    `mark_main_type`       VARCHAR(32)  NOT NULL COMMENT '标记大类型',
    `mark_sub_Type`        VARCHAR(32)  NOT NULL COMMENT '标记小类型',
    `mark_event`           VARCHAR(32)  NOT NULL COMMENT '事件类型',
    `give_medicine_method` VARCHAR(32)  NOT NULL COMMENT '途径',
    `give_medicine_volume` VARCHAR(32)  NOT NULL COMMENT '剂量',
    `side_effect`          VARCHAR(256) NOT NULL COMMENT '不良反应/特殊情况',
    `mark_time`            TIMESTAMP    NOT NULL COMMENT '标记信息标记的时间',
    `gmt_create`           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    `operation_number`     INT UNSIGNED NOT NULL COMMENT '手术顺序号，外键连接手术信息表',
    PRIMARY KEY (pk_id)
) COMMENT '标记信息表7';

create TABLE `info_patient`
(
    `pk_admission_number` VARCHAR(64)    NOT NULL COMMENT '住院号, 主键',
    `patient_id`       VARCHAR(32)       NOT NULL COMMENT '病人身份证号',
    `sex`              TINYINT           NOT NULL COMMENT '性别0--男，1--女',
    `height`           TINYINT UNSIGNED  NOT NULL COMMENT '身高',
    `weight`           TINYINT UNSIGNED  NOT NULL COMMENT '体重',
    `age`              TINYINT UNSIGNED  NOT NULL COMMENT '年龄',
    `gmt_create`       TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`     TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    `operation_number` INT UNSIGNED      NOT NULL COMMENT '手术顺序号，外键连接手术信息表',
    PRIMARY KEY (pk_admission_number)
) COMMENT '病人信息表9';

create TABLE `info_before_operation`
(
    `pk_id`            SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID, 主键',
    `anesthesia_mode`  VARCHAR(32)       NOT NULL COMMENT '麻醉方式',
    `is_urgent`        TINYINT           NOT NULL COMMENT '是否急诊',
    `ASA_level`        TINYINT           NOT NULL COMMENT 'ASA等级',
    `medical_history`  TEXT              NOT NULL COMMENT '既往病史',
    `special_case`     TEXT              NOT NULL COMMENT '特殊情况',
    `gmt_create`       TIMESTAMP         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`     TIMESTAMP         NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    `admission_number` VARCHAR(32)       NOT NULL COMMENT '住院号',
    PRIMARY KEY (pk_id)
) COMMENT '病人术前诊断信息表10';

create TABLE `info_after_operation`
(
    `pk_id`            SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID, 主键',
    `feedback_content` TEXT              NOT NULL COMMENT '反馈信息',
    `gmt_create`       TIMESTAMP         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`     TIMESTAMP         NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    `admission_number` VARCHAR(32)       NOT NULL COMMENT '住院号',
    PRIMARY KEY (pk_id)
) COMMENT '病人术后反馈表11';

CREATE TABLE `info_evaluation` (
    `pk_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID, 主键',
    `operation_number` INT NOT NULL COMMENT '反馈信息',
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
    `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (pk_id)
)COMMENT '评估表';

create TABLE `info_device_hospital_relation`
(
    `pk_id`                   SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `device_code`             VARCHAR(45)          NOT NULL COMMENT '设备生产厂商',
    `device_serial_number`    VARCHAR(45)          NOT NULL COMMENT '设备序列号，不一定唯一',
    `hospital_id`             VARCHAR(45)          NOT NULL COMMENT '全国医院序列号，唯一',
    `device_produce_date`     TIME                 NOT NULL COMMENT '设备购买时间 eg: 2017-08-01',
    `device_purchase_address` VARCHAR(45)          NOT NULL COMMENT '购买地址',
    `device_comment`          TEXT                 NOT NULL COMMENT '仪器的备注信息',
    `gmt_create`              TIMESTAMP            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`            TIMESTAMP            NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (pk_id)
) COMMENT '医院——医疗设备关系表3';

create TABLE `data_norwamd_9002s`
(
    `pk_id`              INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增长',
    `BS`                   TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `EMG`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `SQI`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `CSI`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `gmt_create`           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    `device_serial_number` VARCHAR(32)  NOT NULL DEFAULT '-1' COMMENT '设备序列号，不一定唯一',
    `operation_number`     INT UNSIGNED NOT NULL COMMENT '手术顺序号，外键连接手术信息表',
    PRIMARY KEY (pk_id)
) COMMENT '诺和9002s的数据表5';

create TABLE `data_pearlcare_yy106`
(
    `pk_id`                INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增长',
    `SQI`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `AI`                   TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `EMG`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `BSR`                  TINYINT      NOT NULL DEFAULT -1 COMMENT '0-100 无效值 -1',
    `gmt_create`           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    `device_serial_number` VARCHAR(32)  NOT NULL DEFAULT '-1' COMMENT '设备序列号，不一定唯一',
    `operation_number`     INT UNSIGNED NOT NULL COMMENT '手术顺序号，外键连接手术信息表',
    PRIMARY KEY (pk_id)
) COMMENT '普可yy106的数据表6';

create TABLE `info_operation_device`
(
    `pk_id`                 INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增长',
    `operation_number`      INT UNSIGNED NOT NULL COMMENT '手术顺序号',
    `device_code`           SMALLINT UNSIGNED NOT NULL COMMENT '设备代码',
    `device_serial_number`  VARCHAR(32)  NOT NULL COMMENT '设备序列号',
    `gmt_create`            TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (pk_id)
) COMMENT '手术使用的设备表';

CREATE TABLE `info_log`
(
    `pk_id`        SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `error`        TEXT                 NOT NULL COMMENT '错误日志信息',
    `gmt_create`   TIMESTAMP            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` TIMESTAMP            NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (pk_id)
) COMMENT '错误日志信息表';


CREATE TABLE `system_log`
(
    `pk_id`        SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `log_level`     TINYINT              NOT NULL COMMENT '日志级别',
    `message`      TEXT                 NOT NULL COMMENT '日志信息',
    `record_date`  VARCHAR(32)          NOT NULL COMMENT '日志记录时间',
    `gmt_create`   TIMESTAMP            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` TIMESTAMP            NOT NULL DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (pk_id)
) COMMENT '日志信息表';
