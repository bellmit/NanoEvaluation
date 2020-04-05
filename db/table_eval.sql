

# 麻醉深度监测仪评价表
DROP TABLE IF EXISTS `eval_device_anesthesia_depth_monitor`;
CREATE TABLE `eval_device_anesthesia_depth_monitor` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `company_name`
    VARCHAR(64) NOT NULL COMMENT '公司名称',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '您对该仪器的熟悉程度',
    `control_panel_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '[硬件]控制面板（包括电源开关、传感器插头等）',
    `control_panel_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '[硬件]控制面板（包括电源开关、传感器插头等）',
    `display_screen_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '硬件]显示屏（显示颜色、字体或图形大小、布局、尺寸大小等）',
    `display_screen_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '硬件]显示屏（显示颜色、字体或图形大小、布局、尺寸大小等）',
    `lead_wire_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '[硬件]监测导联线与电极（连接是否方便、稳定）',
    `lead_wire_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '[硬件]监测导联线与电极（连接是否方便、稳定）',
    `move_and_fix_device_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '[硬件]移动与固定装置',
    `move_and_fix_device_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '[硬件]移动与固定装置',
    `backup_power_use_time_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '[硬件]备用电源使用时间',
    `backup_power_use_time_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '[硬件]备用电源使用时间',
    `monitor_parameter_set_and_value_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '[软件]监护参数指标设置与价值',
    `monitor_parameter_set_and_value_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '[软件]监护参数指标设置与价值',
    `monitor_parameter_display_way_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '[软件]监护参数指标的展现形式（数字、图、表等）',
    `monitor_parameter_display_way_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '[软件]监护参数指标的展现形式（数字、图、表等）',
    `turn_on_self_test_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '[软件]开机启动及自检功能设置与时间',
    `turn_on_self_test_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '[软件]开机启动及自检功能设置与时间',
    `monitor_parameter_comprehensive_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '[软件]监测参数全面性（可监测的其他脑电参数种类是否齐全）',
    `monitor_parameter_comprehensive_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '[软件]监测参数全面性（可监测的其他脑电参数种类是否齐全）',
    `data_store_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '[软件]数据存储功能',
    `data_store_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '[软件]数据存储功能',
    `data_export_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '[软件]数据导出功能',
    `data_export_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '[软件]数据导出功能',
    `parameter_accuracy_with_anesthesia_depth`
    VARCHAR(64) NOT NULL COMMENT '[临床可靠性_参数准确性]监护参数：与麻醉深度的相关性（麻醉科填写）',
    `parameter_accuracy_with_coma_depth`
    VARCHAR(64) NOT NULL COMMENT '[临床可靠性_参数准确性]监护参数：与麻醉深度的相关性（麻醉科填写）',
    `parameter_accuracy_with_brain_damage`
    VARCHAR(64) NOT NULL COMMENT '[临床可靠性_参数准确性]与脑功能损伤程度的相关性（神经内外科填写）',
    `parameter_accuracy_with_response_time`
    VARCHAR(64) NOT NULL COMMENT '[临床可靠性_参数准确性]监护参数响应时间（用药、操作、苏醒期等引起变化时监护参数的变化是否及时）',
    `jamproof_capability_with_monitor`
    VARCHAR(64) NOT NULL COMMENT '[临床可靠性_抗干扰能力]监测抗干扰能力',
    `alert_device_in_time`
    VARCHAR(64) NOT NULL COMMENT '[临床可靠性_报警装置]即时与可靠性',
    `fault_rate_with_mainframe`
    VARCHAR(64) NOT NULL COMMENT '[临床可靠性_故障发生率]主机',
    `fault_rate_with_monitor_module`
    VARCHAR(64) NOT NULL COMMENT '[临床可靠性_故障发生率]监测模块',
    `fault_rate_with_lead_wire_and_sensor`
    VARCHAR(64) NOT NULL COMMENT '[临床可靠性_故障发生率]导联线与传感器',
    `anesthesia_induction_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '[临床使用效果_麻醉诱导期满意度]指导麻醉诱导时深度判断及用药选择（麻醉科填写）',
    `anesthesia_maintain_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '[临床使用效果_麻醉维持期满意度]指导麻醉维持期间深度判断及用药选择（麻醉科填写）',
    `anesthesia_recovery_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '[临床使用效果_麻醉苏醒期满意度]指导麻醉苏醒情况（麻醉科填写）',
    `conscious_judge_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '[临床使用效果_意识情况判断满意度]辅助指导临床意识观察情况（神经内外科）',
    `brain_damage_judge_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '[临床使用效果_脑功能损伤情况判断满意度]辅助指导临床脑功能损伤情况（神经内外科）',
    `advantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '[优劣势]您觉得该仪器相比其他品牌最大的优势是什么',
    `disadvantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '[优劣势]您觉得该仪器相比其他品牌最大的不足是什么',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '设备信息表，信息需要手动输入';



CREATE table `eval_cerebral_oxygen` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '2.设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '3.其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '1.医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '2.单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '3.科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '4.职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '5.职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '6.工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '7.您对该仪器的熟悉程度',
    `control_panel_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '控制面板（包括电源开关、传感器插头等）',
    `control_panel_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `display_screen_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '显示屏（显示颜色、字体或图形大小、布局、尺寸大小等）',
    `display_screen_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `lead_wire_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '监测导联线与电极（连接是否方便、稳定）',
    `lead_wire_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `move_and_fix_device_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '移动与固定装置',
    `move_and_fix_device_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `backup_power_use_time_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '备用电源使用时间',
    `backup_power_use_time_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `monitor_parameter_set_and_value_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '监护参数指标设置与价值',
    `monitor_parameter_set_and_value_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `monitor_parameter_display_way_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '监护参数指标的展现形式（数字、图、表等）',
    `monitor_parameter_display_way_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `turn_on_self_test_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '开机启动及自检功能设置与时间',
    `turn_on_self_test_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `monitor_parameter_comprehensive_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '监测参数全面性（可监测的其他脑电参数种类是否齐全）',
    `monitor_parameter_comprehensive_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `data_store_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '数据存储功能',
    `data_store_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `data_export_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '数据导出功能',
    `data_export_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `parameter_accuracy_with_monitor_parameter`
    VARCHAR(64) NOT NULL COMMENT '监护参数：脑灌注与脉氧饱和度数值的相关性',
    `jamproof_capability_with_monitor`
    VARCHAR(64) NOT NULL COMMENT '监测抗干扰能力',
    `alert_device_in_time`
    VARCHAR(64) NOT NULL COMMENT '即时与可靠性',
    `fault_rate_with_mainframe`
    VARCHAR(64) NOT NULL COMMENT '主机',
    `fault_rate_with_monitor_module`
    VARCHAR(64) NOT NULL COMMENT '监测模块',
    `fault_rate_with_lead_wire_and_sensor`
    VARCHAR(64) NOT NULL COMMENT '导联线与传感器',
    `monitor_brain_oxygen_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '脑氧监护对防止术中脑缺氧的效果（麻醉科填写）',
    `monitor_kidney_damage_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '组织氧监护对防止术中肾损伤的效果（麻醉科填写）',
    `monitor_brain_ischemic_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '脑氧监护对脑缺血缺氧损伤识别的帮助（神经内、外科填写）',
    `advantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '您觉得该仪器相比其他品牌最大的优势是什么',
    `disadvantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '您觉得该仪器相比其他品牌最大的不足是什么',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '脑氧';

CREATE table `eval_anesthesia_machine` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `company_name`
    VARCHAR(64) NOT NULL COMMENT '1.公司名称',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '2.设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '3.其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '1.医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '2.单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '3.科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '4.职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '5.职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '6.工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '7.您对该仪器的熟悉程度',
    `control_panel_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '控制面板（包括电源开关、手/自动切换、参数调节）',
    `control_panel_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `display_screen_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '显示屏（显示颜色、字体或图形、布局、尺寸大小等）',
    `display_screen_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `hand_control_device_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '手控装置、位置与操控',
    `hand_control_device_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `bellows_and_its_position_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '风箱及摆放位置',
    `bellows_and_its_position_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `soda_lime_tank_with_load_and_unload_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '钠石灰罐与装卸设置',
    `soda_lime_tank_with_load_and_unload_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `breath_loop_and_interface_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '呼吸回路接口',
    `breath_loop_and_interface_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `gas_flow_control_device_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '气体流量调节装置（氧气、空气）',
    `gas_flow_control_device_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `backup_power_use_time_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '备用电源使用时间',
    `backup_power_use_time_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `volatilize_tank_and_switch_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '挥发罐与开关、加药设置',
    `volatilize_tank_and_switch_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `flue_gas_let_out_device_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '废气排放装置',
    `flue_gas_let_out_device_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `move_and_fix_device_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '麻醉机移动与固定装置',
    `move_and_fix_device_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `operating_floor_size_and_position_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '麻醉机操作台大小、位置、使用方便等',
    `operating_floor_size_and_position_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `locker_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '储物柜',
    `locker_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `data_interface_type_and_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '数据接口类型、数量、功能',
    `data_interface_type_and_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `breath_pattern_type_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '呼吸模式种类',
    `breath_pattern_type_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `etco2_module_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '呼气末CO2浓度监测模块',
    `etco2_module_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `anesthetic_mol_monitor_module_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '吸入麻醉剂浓度监测模块',
    `anesthetic_mol_monitor_module_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `turn_on_self_test_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '开机自检功能设置与自检速度',
    `turn_on_self_test_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `data_export_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '数据导出功能',
    `data_export_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `parameter_accuracy_with_self_test`
    VARCHAR(64) NOT NULL COMMENT '麻醉机自检准确性',
    `parameter_accuracy_with_tidal_volume`
    VARCHAR(64) NOT NULL COMMENT '呼吸参数：潮气量',
    `parameter_accuracy_with_breath_frequency`
    VARCHAR(64) NOT NULL COMMENT '呼吸参数：呼吸频率',
    `parameter_accuracy_with_airway_pressure`
    VARCHAR(64) NOT NULL COMMENT '呼吸参数：气道压',
    `parameter_accuracy_with_inspiratory_and_expiratory`
    VARCHAR(64) NOT NULL COMMENT '呼吸参数：吸呼比',
    `parameter_accuracy_with_oxygen_mol`
    VARCHAR(64) NOT NULL COMMENT '呼吸参数：氧浓度',
    `parameter_accuracy_with_volatilize_tanks_mol_control`
    VARCHAR(64) NOT NULL COMMENT '挥发罐浓度控制',
    `parameter_accuracy_with_mac`
    VARCHAR(64) NOT NULL COMMENT '监测参数：吸入麻醉药浓度或MAC',
    `parameter_accuracy_with_etc02`
    VARCHAR(64) NOT NULL COMMENT '监测参数：呼末CO2',
    `loop_closure_with_soda_lime_tank`
    VARCHAR(64) NOT NULL COMMENT '钠石灰罐',
    `loop_closure_with_breath_loop`
    VARCHAR(64) NOT NULL COMMENT '呼吸回路',
    `loop_closure_with_flue_gas_let_out_loop`
    VARCHAR(64) NOT NULL COMMENT '废气排放回路',
    `alert_device_in_time`
    VARCHAR(64) NOT NULL COMMENT '即时与可靠性',
    `fault_rate_with_mainframe`
    VARCHAR(64) NOT NULL COMMENT '主机',
    `fault_rate_with_monitor_module`
    VARCHAR(64) NOT NULL COMMENT '监测模块（呼末CO2、麻醉气体监测、氧浓度监测等）',
    `fault_rate_with_assist_device`
    VARCHAR(64) NOT NULL COMMENT '辅助配件',
    `mechanical_ventilation_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '综合考虑患者使用过程出现的高碳酸血症发生率；因机器故障缺氧意外等事件',
    `anesthetic_effect_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '吸入麻醉引起麻醉过深或过浅的发生情况',
    `advantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '您觉得该仪器相比其他品牌最大的优势是什么',
    `disadvantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '您觉得该仪器相比其他品牌最大的不足是什么',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '麻醉机';

CREATE table `eval_cerebral_oximetry` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `company_name`
    VARCHAR(64) NOT NULL COMMENT '1.公司名称',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '2.设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '3.其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '1.医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '2.单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '3.科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '4.职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '5.职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '6.工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '7.您对该仪器的熟悉程度',
    `control_panel_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '控制面板（包括电源开关、传感器插头等）',
    `control_panel_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `display_screen_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '显示屏（显示颜色、字体或图形大小、布局、尺寸大小等）',
    `display_screen_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `lead_wire_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '监测导联线与电极（连接是否方便、稳定）',
    `lead_wire_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `move_and_fix_device_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '移动与固定装置',
    `move_and_fix_device_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `backup_power_use_time_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '备用电源使用时间',
    `backup_power_use_time_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `monitor_parameter_set_and_value_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '监护参数指标设置与价值',
    `monitor_parameter_set_and_value_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `monitor_parameter_display_way_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '监护参数指标的展现形式（数字、图、表等）',
    `monitor_parameter_display_way_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `turn_on_self_test_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '开机启动及自检功能设置与时间',
    `turn_on_self_test_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `monitor_parameter_comprehensive_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '监测参数全面性（可监测的其他脑电参数种类是否齐全）',
    `monitor_parameter_comprehensive_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `data_store_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '数据存储功能',
    `data_store_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `data_export_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '数据导出功能',
    `data_export_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `parameter_accuracy_with_monitor_parameter`
    VARCHAR(64) NOT NULL COMMENT '监护参数：脑灌注与脉氧饱和度数值的相关性',
    `jamproof_capability_with_monitor`
    VARCHAR(64) NOT NULL COMMENT '监测抗干扰能力',
    `alert_device_in_time`
    VARCHAR(64) NOT NULL COMMENT '即时与可靠性',
    `fault_rate_with_mainframe`
    VARCHAR(64) NOT NULL COMMENT '主机',
    `fault_rate_with_monitor_module`
    VARCHAR(64) NOT NULL COMMENT '监测模块',
    `fault_rate_with_lead_wire_and_sensor`
    VARCHAR(64) NOT NULL COMMENT '导联线与传感器',
    `monitor_brain_oxygen_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '脑氧监护对防止术中脑缺氧的效果（麻醉科填写）',
    `monitor_kidney_damage_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '组织氧监护对防止术中肾损伤的效果（麻醉科填写）',
    `monitor_brain_ischemic_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '脑氧监护对脑缺血缺氧损伤识别的帮助（神经内、外科填写）',
    `advantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '您觉得该仪器相比其他品牌最大的优势是什么',
    `disadvantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '您觉得该仪器相比其他品牌最大的不足是什么',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '脑氧饱和度';

CREATE table `eval_monitor` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `company_name`
    VARCHAR(64) NOT NULL COMMENT '1.公司名称',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '2.设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '3.其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '1.医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '2.单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '3.科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '4.职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '5.职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '6.工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '7.您对该仪器的熟悉程度',
    `control_panel_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '控制面板（包括电源开关、各种监测参数与模式调节等）',
    `control_panel_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `display_screen_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '显示屏（显示颜色、字体或图形大小、布局、尺寸大小等）',
    `display_screen_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `pulse_oxygen_saturation_module_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '脉搏氧饱和度监测模块',
    `pulse_oxygen_saturation_module_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `ecg_module_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '心电图监测模块',
    `ecg_module_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `nibp_cuff_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '无创血压袖带',
    `nibp_cuff_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `ibp_module_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '有创血压监测模块',
    `ibp_module_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `ETCO2_module_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '呼气末CO2监测模块',
    `ETCO2_module_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `backup_power_use_time_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '备用电源使用时间',
    `backup_power_use_time_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `transport_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '转运功能（基于危重患者转运考虑的硬件设施配置）',
    `transport_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `monitor_parameter_layout_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '监护参数页面布局',
    `monitor_parameter_layout_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `monitor_parameter_adjust_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '监护参数调节（采集频率、数据形式等）',
    `monitor_parameter_adjust_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `monitor_parameter_comprehensive_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '监测参数全面性（可监测的参数种类是否齐全）',
    `monitor_parameter_comprehensive_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `turn_on_self_test_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '开机启动及自检功能设置',
    `turn_on_self_test_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `data_export_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '数据导出功能',
    `data_export_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `parameter_accuracy_with_heart_rate`
    VARCHAR(64) NOT NULL COMMENT '监护参数：心率',
    `parameter_accuracy_with_nibp`
    VARCHAR(64) NOT NULL COMMENT '监护参数：无创血压',
    `parameter_accuracy_with_ibp`
    VARCHAR(64) NOT NULL COMMENT '监护参数：有创血压',
    `parameter_accuracy_with_pulse_oxygen_saturation`
    VARCHAR(64) NOT NULL COMMENT '监护参数：脉搏氧饱和度',
    `parameter_accuracy_with_body_temperature`
    VARCHAR(64) NOT NULL COMMENT '监护参数：体温',
    `parameter_accuracy_with_ETCO2`
    VARCHAR(64) NOT NULL COMMENT '监护参数：呼气末CO2',
    `parameter_accuracy_with_et_anesthetics_mol`
    VARCHAR(64) NOT NULL COMMENT '监护参数：呼气末吸入麻醉剂浓度',
    `parameter_accuracy_with_other_parameter`
    VARCHAR(64) NOT NULL COMMENT '其他监护参数：麻醉深度、脑氧等',
    `jamproof_capability_with_ecg`
    VARCHAR(64) NOT NULL COMMENT '心电监护抗干扰能力',
    `jamproof_capability_with_bp`
    VARCHAR(64) NOT NULL COMMENT '血压监测抗干扰能力',
    `jamproof_capability_with_pulse_oxygen_saturation`
    VARCHAR(64) NOT NULL COMMENT '脉搏氧饱和度抗干扰能力',
    `alert_device_in_time`
    VARCHAR(64) NOT NULL COMMENT '即时与可靠性',
    `fault_rate_with_mainframe`
    VARCHAR(64) NOT NULL COMMENT '主机',
    `fault_rate_with_monitor_module`
    VARCHAR(64) NOT NULL COMMENT '监测模块（如呼末CO2）',
    `fault_rate_with_lead_wire_and_sensor`
    VARCHAR(64) NOT NULL COMMENT '各种导联线的主机接口',
    `monitor_bp_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '高血压、低血压识别准确率',
    `monitor_ecg_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '心率变化、心律失常识别准确率',
    `monitor_pulse_oxygen_saturation_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '患者缺氧识别准确率',
    `monitor_ECTO2_with_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '患者CO2蓄积识别准确率',
    `advantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '您觉得该仪器相比其他品牌最大的优势是什么',
    `disadvantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '您觉得该仪器相比其他品牌最大的不足是什么',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '监护仪';

CREATE table `eval_non_invasive_hemoglobin` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `company_name`
    VARCHAR(64) NOT NULL COMMENT '1.公司名称',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '2.设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '3.其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '1.医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '2.单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '3.科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '4.职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '5.职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '6.工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '7.您对该仪器的熟悉程度',
    `control_panel_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '1.[硬件]控制面板（包括电源开关、传感器插头等）',
    `control_panel_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `display_screen_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '2.[硬件]显示屏（显示颜色、字体或图形大小、布局、尺寸大小等）',
    `display_screen_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `lead_wire_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '3.[硬件]监测导联线与电极（连接是否方便、稳定）',
    `lead_wire_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `move_and_fix_device_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '4.[硬件]移动与固定装置',
    `move_and_fix_device_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `backup_power_use_time_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '5.[硬件]备用电源使用时间',
    `backup_power_use_time_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `monitor_parameter_set_and_value_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '6.[软件]监护参数指标设置与价值',
    `monitor_parameter_set_and_value_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `monitor_parameter_display_way_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '7.[软件]监护参数指标的展现形式（数字、图、表等）',
    `monitor_parameter_display_way_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `turn_on_self_test_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '8.[软件]开机启动及自检功能设置与时间',
    `turn_on_self_test_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `data_store_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '9.[软件]数据存储功能',
    `data_store_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `data_export_function_design_reasonable`
    VARCHAR(64) NOT NULL COMMENT '10.[软件]数据导出功能',
    `data_export_function_operation_convenient`
    VARCHAR(64) NOT NULL COMMENT '',
    `parameter_accuracy_with_monitor_parameter`
    VARCHAR(64) NOT NULL COMMENT '1.[临床可靠性_参数准确性]监护参数：血红蛋白数值与实际血红蛋白、术中输血与失血量的相关性',
    `jamproof_capability_with_monitor`
    VARCHAR(64) NOT NULL COMMENT '2.[临床可靠性_抗干扰能力]监测抗干扰能力',
    `alert_device_in_time`
    VARCHAR(64) NOT NULL COMMENT '3.[临床可靠性_报警装置]即时与可靠性',
    `fault_rate_with_mainframe`
    VARCHAR(64) NOT NULL COMMENT '4.[临床可靠性_故障发生率]主机',
    `fault_rate_with_monitor_module`
    VARCHAR(64) NOT NULL COMMENT '5.[临床可靠性_故障发生率]监测模块',
    `fault_rate_with_lead_wire_and_sensor`
    VARCHAR(64) NOT NULL COMMENT '6.[临床可靠性_故障发生率]导联线与传感器',
    `identity_bleed_with_accuracy`
    VARCHAR(64) NOT NULL COMMENT '7.[临床可靠性_识别出血/失血的准确性和及时性]能否及时、准确的发现出血/失血状态',
    `blood_transfusion_with_accuracy`
    VARCHAR(64) NOT NULL COMMENT '8.[临床可靠性_输血指导准确性]输血、输液临床改善情况指导准确性',
    `advantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '9.[优劣势]您觉得该仪器相比其他品牌最大的优势是什么',
    `disadvantage_compare_other_brand`
    VARCHAR(64) NOT NULL COMMENT '10.[优劣势]您觉得该仪器相比其他品牌最大的不足是什么',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '无创血红蛋白';

CREATE table `eval_maintenance_schedule` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`
    VARCHAR(64) NOT NULL COMMENT '原始值',
    `hospital_name`
    VARCHAR(64) NOT NULL COMMENT '医院名称',
    `device_producer`
    VARCHAR(64) NOT NULL COMMENT '仪器厂家',
    `device_name`
    VARCHAR(64) NOT NULL COMMENT '仪器名称',
    `device_unique_id`
    VARCHAR(64) NOT NULL COMMENT '仪器编号',
    `has_been_used_years`
    VARCHAR(64) NOT NULL COMMENT '已使用年限',
    `guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '质保期',
    `extend_warranty_price`
    VARCHAR(64) NOT NULL COMMENT '延保费用',
    `charge_man`
    VARCHAR(64) NOT NULL COMMENT '负责人',
    `fault_happen_time`
    VARCHAR(64) NOT NULL COMMENT '发生故障时间',
    `inform_maintain_time`
    VARCHAR(64) NOT NULL COMMENT '通知维修时间',
    `start_maintain_time`
    VARCHAR(64) NOT NULL COMMENT '开始维修时间',
    `recover_use_time`
    VARCHAR(64) NOT NULL COMMENT '恢复使用时间',
    `maintain_way`
    VARCHAR(64) NOT NULL COMMENT '维修方式',
    `maintain_person`
    VARCHAR(64) NOT NULL COMMENT '维修人员',
    `is_in_warranty_period`
    VARCHAR(64) NOT NULL COMMENT '保修期内',
    `fault_reason`
    VARCHAR(64) NOT NULL COMMENT '故障原因',
    `is_change_accessory`
    VARCHAR(64) NOT NULL COMMENT '更换配件',
    `is_fix_fault`
    VARCHAR(64) NOT NULL COMMENT '故障解决',
    `maintain_response_time_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '维修响应时间满意度',
    `maintain_price_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '维修价格满意度',
    `maintain_service_attitude_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '维修服务态度满意度',
    `maintain_whole_process_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '维修过程整体满意度',
    `accessory_price`
    VARCHAR(64) NOT NULL COMMENT '费用_配件费',
    `maintain_price`
    VARCHAR(64) NOT NULL COMMENT '费用_维修费',
    `other_price`
    VARCHAR(64) NOT NULL COMMENT '费用_其他',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '维修情况表';

CREATE table `eval_service_system_questionnaire_anesthesia_depth` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`
    VARCHAR(64) NOT NULL COMMENT '原始值',
    `company_name`
    VARCHAR(64) NOT NULL COMMENT '1.公司名称',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '2.设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '3.其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '1.医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '2.单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '3.科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '4.职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '5.职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '6.工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '7.您对该仪器的熟悉程度',
    `is_provide_consult_before_sale`
    VARCHAR(64) NOT NULL COMMENT '1. 该仪器销售厂家（以下简称厂家）提供销售前技术信息咨询服务：',
    `is_know_your_demand`
    VARCHAR(64) NOT NULL COMMENT '2.厂家详细了解您对该仪器功能与性能方面的需求：',
    `is_provide_trial`
    VARCHAR(64) NOT NULL COMMENT '3.厂家提供购买前仪器试用',
    `is_explain_function`
    VARCHAR(64) NOT NULL COMMENT '4.厂家在销售过程中详细讲解仪器的功能与性能及售后服务内容',
    `is_introduction_device_maintain_and_update_detail`
    VARCHAR(64) NOT NULL COMMENT '5. 厂家在售后详细交代仪器维护、定期回访、升级换代指导服务',
    `is_provide_install_and_train`
    VARCHAR(64) NOT NULL COMMENT '6. 厂家在该仪器售后提供上门安装和培训',
    `guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '7. 厂家承诺的该仪器质保年限是',
    `visit_customer_period`
    VARCHAR(64) NOT NULL COMMENT '8.厂家定期回访时间是',
    `visit_customer_way`
    VARCHAR(64) NOT NULL COMMENT '9. 厂家定期回访形式',
    `average_response_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '10.仪器故障服务平均响应时间是',
    `average_maintain_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '11. 故障后平均维修时间是',
    `jing_xiao_bi_device_work_year`
    VARCHAR(64) NOT NULL COMMENT '12.1仪器购入年限',
    `jing_xiao_bi_patient_num_every_year`
    VARCHAR(64) NOT NULL COMMENT '12.2平均每年使用仪器患者数量',
    `jing_xiao_bi_average_pay_every_patient`
    VARCHAR(64) NOT NULL COMMENT '12.3平均收费单价',
    `jing_xiao_bi_device_sale_price`
    VARCHAR(64) NOT NULL COMMENT '12.4仪器购入总价格',
    `jing_xiao_bi_total_pay_for_maintain_after_buy`
    VARCHAR(64) NOT NULL COMMENT '12.5仪器购入至今维护保养总费用',
    `economic_applicability_performance_rate`
    VARCHAR(64) NOT NULL COMMENT '仪器整体性价比',
    `economic_applicability_first_guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的首次保修年限',
    `economic_applicability_renewal_method_and_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的续保方式和价格',
    `economic_applicability_warranty_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的保修价格',
    `economic_applicability_software_update_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的软件升级价格',
    `train_service_description_practical`
    VARCHAR(64) NOT NULL COMMENT '仪器产品说明书实用性',
    `train_service_feedback_in_time`
    VARCHAR(64) NOT NULL COMMENT '厂家咨询反馈及时性',
    `train_service_remote_technical_support`
    VARCHAR(64) NOT NULL COMMENT '厂家远程技术支持',
    `train_service_clinical_application_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的临床应用培训',
    `train_service_device_install_maintain_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的仪器安装保养培训',
    `after_sale_service_response_time`
    VARCHAR(64) NOT NULL COMMENT '厂家售后响应时间',
    `after_sale_service_fault_exclude_time`
    VARCHAR(64) NOT NULL COMMENT '厂家维修故障排除时间',
    `after_sale_service_maintain_price`
    VARCHAR(64) NOT NULL COMMENT '需要的维修价格',
    `after_sale_service_producer_attitude`
    VARCHAR(64) NOT NULL COMMENT '厂家售后服务态度',
    `after_sale_service_complaint_handing_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '厂家投诉处理满意度',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '服务体系调查表_麻醉深度';

CREATE table `eval_service_system_questionnaire_non_invasive_hemoglobin` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`
    VARCHAR(64) NOT NULL COMMENT '原始值',
    `company_name`
    VARCHAR(64) NOT NULL COMMENT '1.公司名称',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '2.设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '3.其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '1.医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '2.单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '3.科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '4.职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '5.职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '6.工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '7.您对该仪器的熟悉程度',
    `is_provide_consult_before_sale`
    VARCHAR(64) NOT NULL COMMENT '1. 该仪器销售厂家（以下简称厂家）提供销售前技术信息咨询服务：',
    `is_know_your_demand`
    VARCHAR(64) NOT NULL COMMENT '2.厂家详细了解您对该仪器功能与性能方面的需求：',
    `is_provide_trial`
    VARCHAR(64) NOT NULL COMMENT '3.厂家提供购买前仪器试用',
    `is_explain_function`
    VARCHAR(64) NOT NULL COMMENT '4.厂家在销售过程中详细讲解仪器的功能与性能及售后服务内容',
    `is_introduction_device_maintain_and_update_detail`
    VARCHAR(64) NOT NULL COMMENT '5. 厂家在售后详细交代仪器维护、定期回访、升级换代指导服务',
    `is_provide_install_and_train`
    VARCHAR(64) NOT NULL COMMENT '6. 厂家在该仪器售后提供上门安装和培训',
    `guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '7. 厂家承诺的该仪器质保年限是',
    `visit_customer_period`
    VARCHAR(64) NOT NULL COMMENT '8.厂家定期回访时间是',
    `visit_customer_way`
    VARCHAR(64) NOT NULL COMMENT '9. 厂家定期回访形式',
    `average_response_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '10.仪器故障服务平均响应时间是',
    `average_maintain_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '11. 故障后平均维修时间是',
    `jing_xiao_bi_device_work_year`
    VARCHAR(64) NOT NULL COMMENT '12.1仪器购入年限',
    `jing_xiao_bi_patient_num_every_year`
    VARCHAR(64) NOT NULL COMMENT '12.2平均每年使用仪器患者数量',
    `jing_xiao_bi_average_pay_every_patient`
    VARCHAR(64) NOT NULL COMMENT '12.3平均收费单价',
    `jing_xiao_bi_device_sale_price`
    VARCHAR(64) NOT NULL COMMENT '12.4仪器购入总价格',
    `jing_xiao_bi_total_pay_for_maintain_after_buy`
    VARCHAR(64) NOT NULL COMMENT '12.5仪器购入至今维护保养总费用',
    `economic_applicability_performance_rate`
    VARCHAR(64) NOT NULL COMMENT '仪器整体性价比',
    `economic_applicability_first_guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的首次保修年限',
    `economic_applicability_renewal_method_and_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的续保方式和价格',
    `economic_applicability_warranty_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的保修价格',
    `economic_applicability_software_update_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的软件升级价格',
    `train_service_description_practical`
    VARCHAR(64) NOT NULL COMMENT '仪器产品说明书实用性',
    `train_service_feedback_in_time`
    VARCHAR(64) NOT NULL COMMENT '厂家咨询反馈及时性',
    `train_service_remote_technical_support`
    VARCHAR(64) NOT NULL COMMENT '厂家远程技术支持',
    `train_service_clinical_application_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的临床应用培训',
    `train_service_device_install_maintain_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的仪器安装保养培训',
    `after_sale_service_response_time`
    VARCHAR(64) NOT NULL COMMENT '厂家售后响应时间',
    `after_sale_service_fault_exclude_time`
    VARCHAR(64) NOT NULL COMMENT '厂家维修故障排除时间',
    `after_sale_service_maintain_price`
    VARCHAR(64) NOT NULL COMMENT '需要的维修价格',
    `after_sale_service_producer_attitude`
    VARCHAR(64) NOT NULL COMMENT '厂家售后服务态度',
    `after_sale_service_complaint_handing_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '厂家投诉处理满意度',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '服务体系调查表_无创血红蛋白';

CREATE table `eval_service_system_questionnaire_cerebral_oxygen` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`
    VARCHAR(64) NOT NULL COMMENT '原始值',
    `company_name`
    VARCHAR(64) NOT NULL COMMENT '1.公司名称',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '2.设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '3.其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '1.医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '2.单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '3.科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '4.职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '5.职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '6.工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '7.您对该仪器的熟悉程度',
    `is_provide_consult_before_sale`
    VARCHAR(64) NOT NULL COMMENT '1. 该仪器销售厂家（以下简称厂家）提供销售前技术信息咨询服务：',
    `is_know_your_demand`
    VARCHAR(64) NOT NULL COMMENT '2.厂家详细了解您对该仪器功能与性能方面的需求：',
    `is_provide_trial`
    VARCHAR(64) NOT NULL COMMENT '3.厂家提供购买前仪器试用',
    `is_explain_function`
    VARCHAR(64) NOT NULL COMMENT '4.厂家在销售过程中详细讲解仪器的功能与性能及售后服务内容',
    `is_introduction_device_maintain_and_update_detail`
    VARCHAR(64) NOT NULL COMMENT '5. 厂家在售后详细交代仪器维护、定期回访、升级换代指导服务',
    `is_provide_install_and_train`
    VARCHAR(64) NOT NULL COMMENT '6. 厂家在该仪器售后提供上门安装和培训',
    `guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '7. 厂家承诺的该仪器质保年限是',
    `visit_customer_period`
    VARCHAR(64) NOT NULL COMMENT '8.厂家定期回访时间是',
    `visit_customer_way`
    VARCHAR(64) NOT NULL COMMENT '9. 厂家定期回访形式',
    `average_response_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '10.仪器故障服务平均响应时间是',
    `average_maintain_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '11. 故障后平均维修时间是',
    `jing_xiao_bi_device_work_year`
    VARCHAR(64) NOT NULL COMMENT '12.1仪器购入年限',
    `jing_xiao_bi_patient_num_every_year`
    VARCHAR(64) NOT NULL COMMENT '12.2平均每年使用仪器患者数量',
    `jing_xiao_bi_average_pay_every_patient`
    VARCHAR(64) NOT NULL COMMENT '12.3平均收费单价',
    `jing_xiao_bi_device_sale_price`
    VARCHAR(64) NOT NULL COMMENT '12.4仪器购入总价格',
    `jing_xiao_bi_total_pay_for_maintain_after_buy`
    VARCHAR(64) NOT NULL COMMENT '12.5仪器购入至今维护保养总费用',
    `economic_applicability_performance_rate`
    VARCHAR(64) NOT NULL COMMENT '仪器整体性价比',
    `economic_applicability_first_guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的首次保修年限',
    `economic_applicability_renewal_method_and_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的续保方式和价格',
    `economic_applicability_warranty_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的保修价格',
    `economic_applicability_software_update_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的软件升级价格',
    `train_service_description_practical`
    VARCHAR(64) NOT NULL COMMENT '仪器产品说明书实用性',
    `train_service_feedback_in_time`
    VARCHAR(64) NOT NULL COMMENT '厂家咨询反馈及时性',
    `train_service_remote_technical_support`
    VARCHAR(64) NOT NULL COMMENT '厂家远程技术支持',
    `train_service_clinical_application_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的临床应用培训',
    `train_service_device_install_maintain_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的仪器安装保养培训',
    `after_sale_service_response_time`
    VARCHAR(64) NOT NULL COMMENT '厂家售后响应时间',
    `after_sale_service_fault_exclude_time`
    VARCHAR(64) NOT NULL COMMENT '厂家维修故障排除时间',
    `after_sale_service_maintain_price`
    VARCHAR(64) NOT NULL COMMENT '需要的维修价格',
    `after_sale_service_producer_attitude`
    VARCHAR(64) NOT NULL COMMENT '厂家售后服务态度',
    `after_sale_service_complaint_handing_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '厂家投诉处理满意度',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '服务体系调查表_脑氧饱和度 ';

CREATE table `eval_service_system_questionnaire_monitor` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`
    VARCHAR(64) NOT NULL COMMENT '原始值',
    `company_name`
    VARCHAR(64) NOT NULL COMMENT '1.公司名称',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '2.设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '3.其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '1.医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '2.单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '3.科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '4.职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '5.职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '6.工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '7.您对该仪器的熟悉程度',
    `is_provide_consult_before_sale`
    VARCHAR(64) NOT NULL COMMENT '1. 该仪器销售厂家（以下简称厂家）提供销售前技术信息咨询服务：',
    `is_know_your_demand`
    VARCHAR(64) NOT NULL COMMENT '2.厂家详细了解您对该仪器功能与性能方面的需求：',
    `is_provide_trial`
    VARCHAR(64) NOT NULL COMMENT '3.厂家提供购买前仪器试用',
    `is_explain_function`
    VARCHAR(64) NOT NULL COMMENT '4.厂家在销售过程中详细讲解仪器的功能与性能及售后服务内容',
    `is_introduction_device_maintain_and_update_detail`
    VARCHAR(64) NOT NULL COMMENT '5. 厂家在售后详细交代仪器维护、定期回访、升级换代指导服务',
    `is_provide_install_and_train`
    VARCHAR(64) NOT NULL COMMENT '6. 厂家在该仪器售后提供上门安装和培训',
    `guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '7. 厂家承诺的该仪器质保年限是',
    `visit_customer_period`
    VARCHAR(64) NOT NULL COMMENT '8.厂家定期回访时间是',
    `visit_customer_way`
    VARCHAR(64) NOT NULL COMMENT '9. 厂家定期回访形式',
    `average_response_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '10.仪器故障服务平均响应时间是',
    `average_maintain_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '11. 故障后平均维修时间是',
    `jing_xiao_bi_device_work_year`
    VARCHAR(64) NOT NULL COMMENT '12.1仪器购入年限',
    `jing_xiao_bi_patient_num_every_year`
    VARCHAR(64) NOT NULL COMMENT '12.2平均每年使用仪器患者数量',
    `jing_xiao_bi_average_pay_every_patient`
    VARCHAR(64) NOT NULL COMMENT '12.3平均收费单价',
    `jing_xiao_bi_device_sale_price`
    VARCHAR(64) NOT NULL COMMENT '12.4仪器购入总价格',
    `jing_xiao_bi_total_pay_for_maintain_after_buy`
    VARCHAR(64) NOT NULL COMMENT '12.5仪器购入至今维护保养总费用',
    `economic_applicability_performance_rate`
    VARCHAR(64) NOT NULL COMMENT '仪器整体性价比',
    `economic_applicability_first_guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的首次保修年限',
    `economic_applicability_renewal_method_and_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的续保方式和价格',
    `economic_applicability_warranty_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的保修价格',
    `economic_applicability_software_update_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的软件升级价格',
    `train_service_description_practical`
    VARCHAR(64) NOT NULL COMMENT '仪器产品说明书实用性',
    `train_service_feedback_in_time`
    VARCHAR(64) NOT NULL COMMENT '厂家咨询反馈及时性',
    `train_service_remote_technical_support`
    VARCHAR(64) NOT NULL COMMENT '厂家远程技术支持',
    `train_service_clinical_application_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的临床应用培训',
    `train_service_device_install_maintain_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的仪器安装保养培训',
    `after_sale_service_response_time`
    VARCHAR(64) NOT NULL COMMENT '厂家售后响应时间',
    `after_sale_service_fault_exclude_time`
    VARCHAR(64) NOT NULL COMMENT '厂家维修故障排除时间',
    `after_sale_service_maintain_price`
    VARCHAR(64) NOT NULL COMMENT '需要的维修价格',
    `after_sale_service_producer_attitude`
    VARCHAR(64) NOT NULL COMMENT '厂家售后服务态度',
    `after_sale_service_complaint_handing_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '厂家投诉处理满意度',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '服务体系调查表_监护仪';

CREATE table `eval_service_system_questionnaire_anesthesia_machine` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`
    VARCHAR(64) NOT NULL COMMENT '原始值',
    `company_name`
    VARCHAR(64) NOT NULL COMMENT '1.公司名称',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '2.设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '3.其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '1.医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '2.单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '3.科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '4.职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '5.职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '6.工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '7.您对该仪器的熟悉程度',
    `is_provide_consult_before_sale`
    VARCHAR(64) NOT NULL COMMENT '1. 该仪器销售厂家（以下简称厂家）提供销售前技术信息咨询服务：',
    `is_know_your_demand`
    VARCHAR(64) NOT NULL COMMENT '2.厂家详细了解您对该仪器功能与性能方面的需求：',
    `is_provide_trial`
    VARCHAR(64) NOT NULL COMMENT '3.厂家提供购买前仪器试用',
    `is_explain_function`
    VARCHAR(64) NOT NULL COMMENT '4.厂家在销售过程中详细讲解仪器的功能与性能及售后服务内容',
    `is_introduction_device_maintain_and_update_detail`
    VARCHAR(64) NOT NULL COMMENT '5. 厂家在售后详细交代仪器维护、定期回访、升级换代指导服务',
    `is_provide_install_and_train`
    VARCHAR(64) NOT NULL COMMENT '6. 厂家在该仪器售后提供上门安装和培训',
    `guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '7. 厂家承诺的该仪器质保年限是',
    `visit_customer_period`
    VARCHAR(64) NOT NULL COMMENT '8.厂家定期回访时间是',
    `visit_customer_way`
    VARCHAR(64) NOT NULL COMMENT '9. 厂家定期回访形式',
    `average_response_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '10.仪器故障服务平均响应时间是',
    `average_maintain_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '11. 故障后平均维修时间是',
    `jing_xiao_bi_device_work_year`
    VARCHAR(64) NOT NULL COMMENT '12.1仪器购入年限',
    `jing_xiao_bi_patient_num_every_year`
    VARCHAR(64) NOT NULL COMMENT '12.2平均每年使用仪器患者数量',
    `jing_xiao_bi_average_pay_every_patient`
    VARCHAR(64) NOT NULL COMMENT '12.3平均收费单价',
    `jing_xiao_bi_device_sale_price`
    VARCHAR(64) NOT NULL COMMENT '12.4仪器购入总价格',
    `jing_xiao_bi_total_pay_for_maintain_after_buy`
    VARCHAR(64) NOT NULL COMMENT '12.5仪器购入至今维护保养总费用',
    `economic_applicability_performance_rate`
    VARCHAR(64) NOT NULL COMMENT '仪器整体性价比',
    `economic_applicability_first_guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的首次保修年限',
    `economic_applicability_renewal_method_and_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的续保方式和价格',
    `economic_applicability_warranty_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的保修价格',
    `economic_applicability_software_update_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的软件升级价格',
    `train_service_description_practical`
    VARCHAR(64) NOT NULL COMMENT '仪器产品说明书实用性',
    `train_service_feedback_in_time`
    VARCHAR(64) NOT NULL COMMENT '厂家咨询反馈及时性',
    `train_service_remote_technical_support`
    VARCHAR(64) NOT NULL COMMENT '厂家远程技术支持',
    `train_service_clinical_application_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的临床应用培训',
    `train_service_device_install_maintain_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的仪器安装保养培训',
    `after_sale_service_response_time`
    VARCHAR(64) NOT NULL COMMENT '厂家售后响应时间',
    `after_sale_service_fault_exclude_time`
    VARCHAR(64) NOT NULL COMMENT '厂家维修故障排除时间',
    `after_sale_service_maintain_price`
    VARCHAR(64) NOT NULL COMMENT '需要的维修价格',
    `after_sale_service_producer_attitude`
    VARCHAR(64) NOT NULL COMMENT '厂家售后服务态度',
    `after_sale_service_complaint_handing_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '厂家投诉处理满意度',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '服务体系调查表_麻醉机';

CREATE table `eval_service_system_questionnaire_breathing_machine` (
    `pk_id`
    SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`
    VARCHAR(64) NOT NULL COMMENT '原始值',
    `company_name`
    VARCHAR(64) NOT NULL COMMENT '1.公司名称',
    `device_type`
    VARCHAR(64) NOT NULL COMMENT '2.设备型号',
    `other_device_type`
    VARCHAR(64) NOT NULL COMMENT '3.其他型号',
    `doctor_name`
    VARCHAR(64) NOT NULL COMMENT '1.医生姓名',
    `doctor_company`
    VARCHAR(64) NOT NULL COMMENT '2.单位',
    `doctor_department`
    VARCHAR(64) NOT NULL COMMENT '3.科室',
    `doctor_duty`
    VARCHAR(64) NOT NULL COMMENT '4.职务',
    `doctor_professional_title`
    VARCHAR(64) NOT NULL COMMENT '5.职称',
    `doctor_work_year`
    VARCHAR(64) NOT NULL COMMENT '6.工作年限',
    `doctor_familiar_with_device`
    VARCHAR(64) NOT NULL COMMENT '7.您对该仪器的熟悉程度',
    `is_provide_consult_before_sale`
    VARCHAR(64) NOT NULL COMMENT '1. 该仪器销售厂家（以下简称厂家）提供销售前技术信息咨询服务：',
    `is_know_your_demand`
    VARCHAR(64) NOT NULL COMMENT '2.厂家详细了解您对该仪器功能与性能方面的需求：',
    `is_provide_trial`
    VARCHAR(64) NOT NULL COMMENT '3.厂家提供购买前仪器试用',
    `is_explain_function`
    VARCHAR(64) NOT NULL COMMENT '4.厂家在销售过程中详细讲解仪器的功能与性能及售后服务内容',
    `is_introduction_device_maintain_and_update_detail`
    VARCHAR(64) NOT NULL COMMENT '5. 厂家在售后详细交代仪器维护、定期回访、升级换代指导服务',
    `is_provide_install_and_train`
    VARCHAR(64) NOT NULL COMMENT '6. 厂家在该仪器售后提供上门安装和培训',
    `guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '7. 厂家承诺的该仪器质保年限是',
    `visit_customer_period`
    VARCHAR(64) NOT NULL COMMENT '8.厂家定期回访时间是',
    `visit_customer_way`
    VARCHAR(64) NOT NULL COMMENT '9. 厂家定期回访形式',
    `average_response_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '10.仪器故障服务平均响应时间是',
    `average_maintain_time_when_device_fault`
    VARCHAR(64) NOT NULL COMMENT '11. 故障后平均维修时间是',
    `jing_xiao_bi_device_work_year`
    VARCHAR(64) NOT NULL COMMENT '12.1仪器购入年限',
    `jing_xiao_bi_patient_num_every_year`
    VARCHAR(64) NOT NULL COMMENT '12.2平均每年使用仪器患者数量',
    `jing_xiao_bi_average_pay_every_patient`
    VARCHAR(64) NOT NULL COMMENT '12.3平均收费单价',
    `jing_xiao_bi_device_sale_price`
    VARCHAR(64) NOT NULL COMMENT '12.4仪器购入总价格',
    `jing_xiao_bi_total_pay_for_maintain_after_buy`
    VARCHAR(64) NOT NULL COMMENT '12.5仪器购入至今维护保养总费用',
    `economic_applicability_performance_rate`
    VARCHAR(64) NOT NULL COMMENT '仪器整体性价比',
    `economic_applicability_first_guarantee_period`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的首次保修年限',
    `economic_applicability_renewal_method_and_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的续保方式和价格',
    `economic_applicability_warranty_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的保修价格',
    `economic_applicability_software_update_price`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的软件升级价格',
    `train_service_description_practical`
    VARCHAR(64) NOT NULL COMMENT '仪器产品说明书实用性',
    `train_service_feedback_in_time`
    VARCHAR(64) NOT NULL COMMENT '厂家咨询反馈及时性',
    `train_service_remote_technical_support`
    VARCHAR(64) NOT NULL COMMENT '厂家远程技术支持',
    `train_service_clinical_application_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的临床应用培训',
    `train_service_device_install_maintain_training`
    VARCHAR(64) NOT NULL COMMENT '厂家提供的仪器安装保养培训',
    `after_sale_service_response_time`
    VARCHAR(64) NOT NULL COMMENT '厂家售后响应时间',
    `after_sale_service_fault_exclude_time`
    VARCHAR(64) NOT NULL COMMENT '厂家维修故障排除时间',
    `after_sale_service_maintain_price`
    VARCHAR(64) NOT NULL COMMENT '需要的维修价格',
    `after_sale_service_producer_attitude`
    VARCHAR(64) NOT NULL COMMENT '厂家售后服务态度',
    `after_sale_service_complaint_handing_satisfaction`
    VARCHAR(64) NOT NULL COMMENT '厂家投诉处理满意度',
    `gmt_create`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`
    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY(`pk_id`)
) COMMENT '服务体系调查表_呼吸机';