SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
# 麻醉深度监测仪评价表
DROP TABLE IF EXISTS `eval_application_anesthesia_depth_monitor`;
CREATE TABLE `eval_application_anesthesia_depth_monitor` (
    `pk_id` SMALLINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',

    `company_name` VARCHAR(64) NOT NULL,
    `device_type` VARCHAR(64) NOT NULL,
    `other_device_type` VARCHAR(64) NOT NULL,
    `doctor_name` VARCHAR(64) NOT NULL,
    `doctor_company` VARCHAR(64) NOT NULL,
    `doctor_department` VARCHAR(64) NOT NULL,
    `doctor_duty` VARCHAR(64) NOT NULL,
    `doctor_professional_title` VARCHAR(64) NOT NULL,
    `doctor_work_year` VARCHAR(64) NOT NULL,
    `doctor_familiar_with_device` VARCHAR(64) NOT NULL,
    `control_panel_design_reasonable` VARCHAR(64) NOT NULL,
    `control_panel_operation_convenient` VARCHAR(64) NOT NULL,
    `display_screen_design_reasonable` VARCHAR(64) NOT NULL,
    `display_screen_operation_convenient` VARCHAR(64) NOT NULL,
    `lead_wire_design_reasonable` VARCHAR(64) NOT NULL,
    `lead_wire_operation_convenient` VARCHAR(64) NOT NULL,
    `move_and_fix_device_design_reasonable` VARCHAR(64) NOT NULL,
    `move_and_fix_device_operation_convenient` VARCHAR(64) NOT NULL,
    `backup_power_use_time_design_reasonable` VARCHAR(64) NOT NULL,
    `backup_power_use_time_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_parameter_set_and_value_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_set_and_value_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_parameter_display_way_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_display_way_operation_convenient` VARCHAR(64) NOT NULL,
    `turn_on_self_test_design_reasonable` VARCHAR(64) NOT NULL,
    `turn_on_self_test_operation_convenient` VARCHAR(64) NOT NULL,

    `monitor_parameter_comprehensive_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_comprehensive_operation_convenient` VARCHAR(64) NOT NULL,

    `data_store_function_design_reasonable` VARCHAR(64) NOT NULL,
    `data_store_function_operation_convenient` VARCHAR(64) NOT NULL,
    `data_export_function_design_reasonable` VARCHAR(64) NOT NULL,
    `data_export_function_operation_convenient` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_anesthesia_depth` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_coma_depth` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_brain_damage` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_response_time` VARCHAR(64) NOT NULL,

    `jamproof_capability_with_monitor` VARCHAR(64) NOT NULL,
    `alert_device_in_time` VARCHAR(64) NOT NULL,

    `fault_rate_with_mainframe` VARCHAR(64) NOT NULL,
    `fault_rate_with_monitor_module` VARCHAR(64) NOT NULL,
    `fault_rate_with_lead_wire_and_sensor` VARCHAR(64) NOT NULL,

    `anesthesia_induction_satisfaction` VARCHAR(64) NOT NULL,
    `anesthesia_maintain_satisfaction` VARCHAR(64) NOT NULL,
    `anesthesia_recovery_satisfaction` VARCHAR(64) NOT NULL,

    `conscious_judge_satisfaction` VARCHAR(64) NOT NULL,
    `brain_damage_judge_satisfaction` VARCHAR(64) NOT NULL,
    `advantage_compare_other_brand` VARCHAR(64) NOT NULL,
    `disadvantage_compare_other_brand` VARCHAR(64) NOT NULL,

    `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8;


# 无创血红蛋白监测仪评价表
DROP TABLE IF EXISTS `eval_application_hemoglobin_monitor`;
CREATE TABLE `eval_application_hemoglobin_monitor` (
    `pk_id` SMALLINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `company_name` VARCHAR(64) NOT NULL,
    `device_type` VARCHAR(64) NOT NULL,
    `other_device_type` VARCHAR(64) NOT NULL,
    `doctor_name` VARCHAR(64) NOT NULL,
    `doctor_company` VARCHAR(64) NOT NULL,
    `doctor_department` VARCHAR(64) NOT NULL,
    `doctor_duty` VARCHAR(64) NOT NULL,
    `doctor_professional_title` VARCHAR(64) NOT NULL,
    `doctor_work_year` VARCHAR(64) NOT NULL,
    `doctor_familiar_with_device` VARCHAR(64) NOT NULL,
    `control_panel_design_reasonable` VARCHAR(64) NOT NULL,
    `control_panel_operation_convenient` VARCHAR(64) NOT NULL,
    `display_screen_design_reasonable` VARCHAR(64) NOT NULL,
    `display_screen_operation_convenient` VARCHAR(64) NOT NULL,
    `lead_wire_design_reasonable` VARCHAR(64) NOT NULL,
    `lead_wire_operation_convenient` VARCHAR(64) NOT NULL,
    `move_and_fix_device_design_reasonable` VARCHAR(64) NOT NULL,
    `move_and_fix_device_operation_convenient` VARCHAR(64) NOT NULL,
    `backup_power_use_time_design_reasonable` VARCHAR(64) NOT NULL,
    `backup_power_use_time_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_parameter_set_and_value_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_set_and_value_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_parameter_display_way_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_display_way_operation_convenient` VARCHAR(64) NOT NULL,
    `turn_on_self_test_design_reasonable` VARCHAR(64) NOT NULL,
    `turn_on_self_test_operation_convenient` VARCHAR(64) NOT NULL,
    `data_store_function_design_reasonable` VARCHAR(64) NOT NULL,
    `data_store_function_operation_convenient` VARCHAR(64) NOT NULL,
    `data_export_function_design_reasonable` VARCHAR(64) NOT NULL,
    `data_export_function_operation_convenient` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_monitor_parameter` VARCHAR(64) NOT NULL,
    `jamproof_capability_with_monitor` VARCHAR(64) NOT NULL,
    `alert_device_in_time` VARCHAR(64) NOT NULL,
    `fault_rate_with_mainframe` VARCHAR(64) NOT NULL,
    `fault_rate_with_monitor_module` VARCHAR(64) NOT NULL,
    `fault_rate_with_lead_wire_and_sensor` VARCHAR(64) NOT NULL,
    `identity_bleed_with_accuracy` VARCHAR(64) NOT NULL,
    `blood_transfusion_with_accuracy` VARCHAR(64) NOT NULL,
    `advantage_compare_other_brand` VARCHAR(64) NOT NULL,
    `disadvantage_compare_other_brand` VARCHAR(64) NOT NULL,
    `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8;


# 脑氧饱和度监测仪类评价表
DROP TABLE IF EXISTS `eval_application_Brain_Oxygen_Monitor`;
CREATE TABLE `eval_application_Brain_Oxygen_Monitor` (
    `pk_id` SMALLINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `company_name` VARCHAR(64) NOT NULL,
    `device_type` VARCHAR(64) NOT NULL,
    `other_device_type` VARCHAR(64) NOT NULL,
    `doctor_name` VARCHAR(64) NOT NULL,
    `doctor_company` VARCHAR(64) NOT NULL,
    `doctor_department` VARCHAR(64) NOT NULL,
    `doctor_duty` VARCHAR(64) NOT NULL,
    `doctor_professional_title` VARCHAR(64) NOT NULL,
    `doctor_work_year` VARCHAR(64) NOT NULL,
    `doctor_familiar_with_device` VARCHAR(64) NOT NULL,
    `control_panel_design_reasonable` VARCHAR(64) NOT NULL,
    `control_panel_operation_convenient` VARCHAR(64) NOT NULL,
    `display_screen_design_reasonable` VARCHAR(64) NOT NULL,
    `display_screen_operation_convenient` VARCHAR(64) NOT NULL,
    `lead_wire_design_reasonable` VARCHAR(64) NOT NULL,
    `lead_wire_operation_convenient` VARCHAR(64) NOT NULL,
    `move_and_fix_device_design_reasonable` VARCHAR(64) NOT NULL,
    `move_and_fix_device_operation_convenient` VARCHAR(64) NOT NULL,
    `backup_power_use_time_design_reasonable` VARCHAR(64) NOT NULL,
    `backup_power_use_time_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_parameter_set_and_value_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_set_and_value_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_parameter_display_way_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_display_way_operation_convenient` VARCHAR(64) NOT NULL,
    `turn_on_self_test_design_reasonable` VARCHAR(64) NOT NULL,
    `turn_on_self_test_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_parameter_comprehensive_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_comprehensive_operation_convenient` VARCHAR(64) NOT NULL,
    `data_store_function_design_reasonable` VARCHAR(64) NOT NULL,
    `data_store_function_operation_convenient` VARCHAR(64) NOT NULL,
    `data_export_function_design_reasonable` VARCHAR(64) NOT NULL,
    `data_export_function_operation_convenient` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_monitor_parameter` VARCHAR(64) NOT NULL,
    `jamproof_capability_with_monitor` VARCHAR(64) NOT NULL,
    `alert_device_in_time` VARCHAR(64) NOT NULL,
    `fault_rate_with_mainframe` VARCHAR(64) NOT NULL,
    `fault_rate_with_monitor_module` VARCHAR(64) NOT NULL,
    `fault_rate_with_lead_wire_and_sensor` VARCHAR(64) NOT NULL,
    `monitor_brain_oxygen_with_satisfaction` VARCHAR(64) NOT NULL,
    `monitor_kidney_damage_with_satisfaction` VARCHAR(64) NOT NULL,
    `monitor_brain_ischemic_with_satisfaction` VARCHAR(64) NOT NULL,
    `advantage_compare_other_brand` VARCHAR(64) NOT NULL,
    `disadvantage_compare_other_brand` VARCHAR(64) NOT NULL,
    `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8;


# 监护仪评价记录表
DROP TABLE IF EXISTS `eval_application_normal_monitor`;
CREATE TABLE `eval_application_normal_monitor` (
    `pk_id` SMALLINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `company_name` VARCHAR(64) NOT NULL,
    `device_type` VARCHAR(64) NOT NULL,
    `other_device_type` VARCHAR(64) NOT NULL,
    `doctor_name` VARCHAR(64) NOT NULL,
    `doctor_company` VARCHAR(64) NOT NULL,
    `doctor_department` VARCHAR(64) NOT NULL,
    `doctor_duty` VARCHAR(64) NOT NULL,
    `doctor_professional_title` VARCHAR(64) NOT NULL,
    `doctor_work_year` VARCHAR(64) NOT NULL,
    `doctor_familiar_with_device` VARCHAR(64) NOT NULL,
    `control_panel_design_reasonable` VARCHAR(64) NOT NULL,
    `control_panel_operation_convenient` VARCHAR(64) NOT NULL,
    `display_screen_design_reasonable` VARCHAR(64) NOT NULL,
    `display_screen_operation_convenient` VARCHAR(64) NOT NULL,
    `pulse_oxygen_saturation_module_design_reasonable` VARCHAR(64) NOT NULL,
    `pulse_oxygen_saturation_module_operation_convenient` VARCHAR(64) NOT NULL,
    `ecg_module_design_reasonable` VARCHAR(64) NOT NULL,
    `ecg_module_operation_convenient` VARCHAR(64) NOT NULL,
    `nibp_cuff_design_reasonable` VARCHAR(64) NOT NULL,
    `nibp_cuff_operation_convenient` VARCHAR(64) NOT NULL,
    `ibp_module_design_reasonable` VARCHAR(64) NOT NULL,
    `ibp_module_operation_convenient` VARCHAR(64) NOT NULL,
    `etco2_module_design_reasonable` VARCHAR(64) NOT NULL,
    `etco2_module_operation_convenient` VARCHAR(64) NOT NULL,
    `backup_power_use_time_design_reasonable` VARCHAR(64) NOT NULL,
    `backup_power_use_time_operation_convenient` VARCHAR(64) NOT NULL,
    `transport_function_design_reasonable` VARCHAR(64) NOT NULL,
    `transport_function_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_parameter_layout_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_layout_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_parameter_adjust_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_adjust_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_parameter_comprehensive_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_comprehensive_operation_convenient` VARCHAR(64) NOT NULL,
    `turn_on_self_test_design_reasonable` VARCHAR(64) NOT NULL,
    `turn_on_self_test_operation_convenient` VARCHAR(64) NOT NULL,
    `data_export_function_design_reasonable` VARCHAR(64) NOT NULL,
    `data_export_function_operation_convenient` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_heart_rate` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_nibp` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_ibp` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_pulse_oxygen_saturation` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_body_temperature` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_etco2` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_et_anesthetics_mol` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_other_parameter` VARCHAR(64) NOT NULL,
    `jamproof_capability_with_ecg` VARCHAR(64) NOT NULL,
    `jamproof_capability_with_bp` VARCHAR(64) NOT NULL,
    `jamproof_capability_with_pulse_oxygen_saturation` VARCHAR(64) NOT NULL,
    `alert_device_in_time` VARCHAR(64) NOT NULL,
    `fault_rate_with_mainframe` VARCHAR(64) NOT NULL,
    `fault_rate_with_monitor_module` VARCHAR(64) NOT NULL,
    `fault_rate_with_lead_wire_and_sensor` VARCHAR(64) NOT NULL,
    `monitor_bp_with_satisfaction` VARCHAR(64) NOT NULL,
    `monitor_ecg_with_satisfaction` VARCHAR(64) NOT NULL,
    `monitor_pulse_oxygen_saturation_with_satisfaction` VARCHAR(64) NOT NULL,
    `monitor_etco2_with_satisfaction` VARCHAR(64) NOT NULL,
    `advantage_compare_other_brand` VARCHAR(64) NOT NULL,
    `disadvantage_compare_other_brand` VARCHAR(64) NOT NULL,

    `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8;




# 麻醉机评价记录表
DROP TABLE IF EXISTS `eval_application_anesthesia_machine`;
CREATE TABLE `eval_application_anesthesia_machine` (
    `pk_id` SMALLINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `company_name` VARCHAR(64) NOT NULL,
    `device_type` VARCHAR(64) NOT NULL,
    `other_device_type` VARCHAR(64) NOT NULL,
    `doctor_name` VARCHAR(64) NOT NULL,
    `doctor_company` VARCHAR(64) NOT NULL,
    `doctor_department` VARCHAR(64) NOT NULL,
    `doctor_duty` VARCHAR(64) NOT NULL,
    `doctor_professional_title` VARCHAR(64) NOT NULL,
    `doctor_work_year` VARCHAR(64) NOT NULL,
    `doctor_familiar_with_device` VARCHAR(64) NOT NULL,
    `control_panel_design_reasonable` VARCHAR(64) NOT NULL,
    `control_panel_operation_convenient` VARCHAR(64) NOT NULL,
    `display_screen_design_reasonable` VARCHAR(64) NOT NULL,
    `display_screen_operation_convenient` VARCHAR(64) NOT NULL,
    `hand_control_device_design_reasonable` VARCHAR(64) NOT NULL,
    `hand_control_device_operation_convenient` VARCHAR(64) NOT NULL,
    `bellows_and_its_position_design_reasonable` VARCHAR(64) NOT NULL,
    `bellows_and_its_position_operation_convenient` VARCHAR(64) NOT NULL,
    `soda_lime_tank_with_load_and_unload_design_reasonable` VARCHAR(64) NOT NULL,
    `soda_lime_tank_with_load_and_unload_operation_convenient` VARCHAR(64) NOT NULL,
    `breath_loop_and_interface_design_reasonable` VARCHAR(64) NOT NULL,
    `breath_loop_and_interface_operation_convenient` VARCHAR(64) NOT NULL,
    `gas_flow_control_device_design_reasonable` VARCHAR(64) NOT NULL,
    `gas_flow_control_device_operation_convenient` VARCHAR(64) NOT NULL,
    `backup_power_use_time_design_reasonable` VARCHAR(64) NOT NULL,
    `backup_power_use_time_operation_convenient` VARCHAR(64) NOT NULL,
    `volatilize_tank_and_switch_design_reasonable` VARCHAR(64) NOT NULL,
    `volatilize_tank_and_switch_operation_convenient` VARCHAR(64) NOT NULL,
    `flue_gas_let_out_device_design_reasonable` VARCHAR(64) NOT NULL,
    `flue_gas_let_out_device_operation_convenient` VARCHAR(64) NOT NULL,
    `move_and_fix_device_design_reasonable` VARCHAR(64) NOT NULL,
    `move_and_fix_device_operation_convenient` VARCHAR(64) NOT NULL,
    `operating_floor_size_and_position_design_reasonable` VARCHAR(64) NOT NULL,
    `operating_floor_size_and_position_operation_convenient` VARCHAR(64) NOT NULL,
    `locker_design_reasonable` VARCHAR(64) NOT NULL,
    `locker_operation_convenient` VARCHAR(64) NOT NULL,
    `data_interface_type_and_function_design_reasonable` VARCHAR(64) NOT NULL,
    `data_interface_type_and_function_operation_convenient` VARCHAR(64) NOT NULL,
    `breath_pattern_type_design_reasonable` VARCHAR(64) NOT NULL,
    `breath_pattern_type_operation_convenient` VARCHAR(64) NOT NULL,
    `etco2_module_design_reasonable` VARCHAR(64) NOT NULL,
    `etco2_module_operation_convenient` VARCHAR(64) NOT NULL,
    `anesthetic_mol_monitor_module_design_reasonable` VARCHAR(64) NOT NULL,
    `anesthetic_mol_monitor_module_operation_convenient` VARCHAR(64) NOT NULL,
    `turn_on_self_test_design_reasonable` VARCHAR(64) NOT NULL,
    `turn_on_self_test_operation_convenient` VARCHAR(64) NOT NULL,
    `data_export_function_design_reasonable` VARCHAR(64) NOT NULL,
    `data_export_function_operation_convenient` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_self_test` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_tidal_volume` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_breath_frequency` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_airway_pressure` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_inspiratory_and_expiratory` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_oxygen_mol` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_volatilize_tanks_mol_control` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_mac` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_etco2` VARCHAR(64) NOT NULL,
    `loop_closure_with_soda_lime_tank` VARCHAR(64) NOT NULL,
    `loop_closure_with_brethe_loop` VARCHAR(64) NOT NULL,
    `loop_closure_with_flue_gas_let_out_loop` VARCHAR(64) NOT NULL,
    `alert_device_in_time` VARCHAR(64) NOT NULL,
    `fault_rate_with_mainframe` VARCHAR(64) NOT NULL,
    `fault_rate_with_monitor_module` VARCHAR(64) NOT NULL,
    `fault_rate_with_assist_device` VARCHAR(64) NOT NULL,
    `mechanical_ventilation_with_satisfaction` VARCHAR(64) NOT NULL,
    `anesthetic_effect_with_satisfaction` VARCHAR(64) NOT NULL,
    `advantage_compare_other_brand` VARCHAR(64) NOT NULL,
    `disadvantage_compare_other_brand` VARCHAR(64) NOT NULL,

    `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8;


# 呼吸机评价记录表
DROP TABLE IF EXISTS `eval_application_respirator_machine`;
CREATE TABLE `eval_application_respirator_machine` (
    `pk_id` SMALLINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `company_name` VARCHAR(64) NOT NULL,
    `device_type` VARCHAR(64) NOT NULL,
    `other_device_type` VARCHAR(64) NOT NULL,
    `doctor_name` VARCHAR(64) NOT NULL,
    `doctor_company` VARCHAR(64) NOT NULL,
    `doctor_department` VARCHAR(64) NOT NULL,
    `doctor_duty` VARCHAR(64) NOT NULL,
    `doctor_professional_title` VARCHAR(64) NOT NULL,
    `doctor_work_year` VARCHAR(64) NOT NULL,
    `doctor_familiar_with_device` VARCHAR(64) NOT NULL,
    `control_panel_design_reasonable` VARCHAR(64) NOT NULL,
    `control_panel_operation_convenient` VARCHAR(64) NOT NULL,
    `display_screen_design_reasonable` VARCHAR(64) NOT NULL,
    `display_screen_operation_convenient` VARCHAR(64) NOT NULL,
    `air_compressor_design_reasonable` VARCHAR(64) NOT NULL,
    `air_compressor_operation_convenient` VARCHAR(64) NOT NULL,
    `wet_device_design_reasonable` VARCHAR(64) NOT NULL,
    `wet_device_operation_convenient` VARCHAR(64) NOT NULL,
    `breath_loop_and_interface_design_reasonable` VARCHAR(64) NOT NULL,
    `breath_loop_and_interface_operation_convenient` VARCHAR(64) NOT NULL,
    `move_and_fix_device_design_reasonable` VARCHAR(64) NOT NULL,
    `move_and_fix_device_operation_convenient` VARCHAR(64) NOT NULL,
    `backup_power_use_time_design_reasonable` VARCHAR(64) NOT NULL,
    `backup_power_use_time_operation_convenient` VARCHAR(64) NOT NULL,
    `transport_function_design_reasonable` VARCHAR(64) NOT NULL,
    `transport_function_operation_convenient` VARCHAR(64) NOT NULL,
    `gas_flow_adjust_device_design_reasonable` VARCHAR(64) NOT NULL,
    `gas_flow_adjust_device_operation_convenient` VARCHAR(64) NOT NULL,
    `breath_pattern_type_design_reasonable` VARCHAR(64) NOT NULL,
    `breath_pattern_type_operation_convenient` VARCHAR(64) NOT NULL,
    `etco2_module_design_reasonable` VARCHAR(64) NOT NULL,
    `etco2_module_operation_convenient` VARCHAR(64) NOT NULL,
    `o2_module_design_reasonable` VARCHAR(64) NOT NULL,
    `o2_module_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_airway_pressure_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_airway_pressure_operation_convenient` VARCHAR(64) NOT NULL,
    `monitor_parameter_comprehensive_design_reasonable` VARCHAR(64) NOT NULL,
    `monitor_parameter_comprehensive_operation_convenient` VARCHAR(64) NOT NULL,
    `turn_on_self_test_design_reasonable` VARCHAR(64) NOT NULL,
    `turn_on_self_test_operation_convenient` VARCHAR(64) NOT NULL,
    `data_export_function_design_reasonable` VARCHAR(64) NOT NULL,
    `data_export_function_operation_convenient` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_tidal_volume` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_breath_frequency` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_airway_pressure` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_inspiratory_and_expiratory` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_oxygen_mol` VARCHAR(64) NOT NULL,
    `parameter_accuracy_with_etco2` VARCHAR(64) NOT NULL,
    `alert_device_in_time` VARCHAR(64) NOT NULL,
    `fault_rate_with_mainframe` VARCHAR(64) NOT NULL,
    `fault_rate_with_monitor_module` VARCHAR(64) NOT NULL,
    `fault_rate_with_assist_device` VARCHAR(64) NOT NULL,
    `lung_ventilation_complication` VARCHAR(64) NOT NULL,
    `lung_infection_complication` VARCHAR(64) NOT NULL,
    `advantage_compare_other_brand` VARCHAR(64) NOT NULL,
    `disadvantage_compare_other_brand` VARCHAR(64) NOT NULL,
    `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8;





# 服务体系评价记录表
DROP TABLE IF EXISTS `eval_service_system_evaluation`;
CREATE TABLE `eval_service_system_evaluation` (
    `pk_id` SMALLINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `company_name` VARCHAR(64) NOT NULL,
    `device_category` VARCHAR(16) NOT NULL,
    `device_type` VARCHAR(64) NOT NULL,
    `other_device_type` VARCHAR(64) NOT NULL,
    `doctor_name` VARCHAR(64) NOT NULL,
    `doctor_company` VARCHAR(64) NOT NULL,
    `doctor_department` VARCHAR(64) NOT NULL,
    `doctor_duty` VARCHAR(64) NOT NULL,
    `doctor_professional_title` VARCHAR(64) NOT NULL,
    `doctor_work_year` VARCHAR(64) NOT NULL,
    `doctor_familiar_with_device` VARCHAR(64) NOT NULL,
    `is_provide_consult_before_sale` VARCHAR(64) NOT NULL,
    `is_know_your_demand` VARCHAR(64) NOT NULL,
    `is_provide_trial` VARCHAR(64) NOT NULL,
    `is_explain_function` VARCHAR(64) NOT NULL,
    `is_introduction_device_maintain_and_update_detail` VARCHAR(64) NOT NULL,
    `is_provide_install_and_train` VARCHAR(64) NOT NULL,
    `guarantee_period` VARCHAR(64) NOT NULL,
    `visit_customer_period` VARCHAR(64) NOT NULL,
    `visit_customer_way` VARCHAR(64) NOT NULL,
    `average_response_time_when_device_fault` VARCHAR(64) NOT NULL,
    `average_maintain_time_when_device_fault` VARCHAR(64) NOT NULL,
    `jing_xiao_bi_device_work_year` VARCHAR(64) NOT NULL,
    `jing_xiao_bi_patient_num_every_year` VARCHAR(64) NOT NULL,
    `jing_xiao_bi_average_pay_every_patient` VARCHAR(64) NOT NULL,
    `jing_xiao_bi_device_sale_price` VARCHAR(64) NOT NULL,
    `jing_xiao_bi_total_pay_for_maintain_after_buy` VARCHAR(64) NOT NULL,
    `economic_applicability_performance_rate` VARCHAR(64) NOT NULL,
    `economic_applicability_first_guarantee_period` VARCHAR(64) NOT NULL,
    `economic_applicability_renewal_method_and_price` VARCHAR(64) NOT NULL,
    `economic_applicability_warranty_price` VARCHAR(64) NOT NULL,
    `economic_applicability_software_update_price` VARCHAR(64) NOT NULL,
    `train_service_description_practical` VARCHAR(64) NOT NULL,
    `train_service_feedback_in_time` VARCHAR(64) NOT NULL,
    `train_service_remote_technical_support` VARCHAR(64) NOT NULL,
    `train_service_clinical_application_training` VARCHAR(64) NOT NULL,
    `train_service_device_install_maintain_training` VARCHAR(64) NOT NULL,
    `after_sale_service_response_time` VARCHAR(64) NOT NULL,
    `after_sale_service_fault_exclude_time` VARCHAR(64) NOT NULL,
    `after_sale_service_maintain_price` VARCHAR(64) NOT NULL,
    `after_sale_service_producer_attitude` VARCHAR(64) NOT NULL,
    `after_sale_service_complaint_handing_satisfaction` VARCHAR(64) NOT NULL,
    `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8;



# 维修情况记录表
DROP TABLE IF EXISTS `eval_maintenance_record`;
CREATE TABLE `eval_maintenance_record` (
    `pk_id` SMALLINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `hospital_name` VARCHAR(64) NOT NULL,
    `device_producer` VARCHAR(64) NOT NULL,
    `device_name` VARCHAR(64) NOT NULL,
    `device_unique_id` VARCHAR(64) NOT NULL,
    `has_been_used_years` VARCHAR(64) NOT NULL,
    `guarantee_period` VARCHAR(64) NOT NULL,
    `extend_warranty_price` VARCHAR(64) NOT NULL,
    `charge_man` VARCHAR(64) NOT NULL,
    `fault_happen_time` VARCHAR(64) NOT NULL,
    `inform_maintain_time` VARCHAR(64) NOT NULL,
    `start_maintain_time` VARCHAR(64) NOT NULL,
    `recover_use_time` VARCHAR(64) NOT NULL,
    `maintain_way` VARCHAR(64) NOT NULL,
    `maintain_person` VARCHAR(64) NOT NULL,
    `is_in_warranty_period` VARCHAR(64) NOT NULL,
    `fault_reason` VARCHAR(64) NOT NULL,
    `is_change_accessory` VARCHAR(64) NOT NULL,
    `is_fix_fault` VARCHAR(64) NOT NULL,
    `maintain_response_time_satisfaction` VARCHAR(64) NOT NULL,
    `maintain_price_satisfaction` VARCHAR(64) NOT NULL,
    `maintain_service_attitude_satisfaction` VARCHAR(64) NOT NULL,
    `maintain_whole_process_satisfaction` VARCHAR(64) NOT NULL,
    `accessory_price` VARCHAR(64) NOT NULL,
    `maintain_price` VARCHAR(64) NOT NULL,
    `other_price` VARCHAR(64) NOT NULL,
    `gmt_create` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8;





































































