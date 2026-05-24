-- MySQL DDL for module: MES (制造执行系统)
-- Generated from Java DO classes in yudao-module-mes
-- Total tables: 133
-- Engine: InnoDB, Charset: utf8mb4

-- ============================================================================
-- Module: cal (排班管理)
-- ============================================================================

-- MES 排班计划
DROP TABLE IF EXISTS `mes_cal_plan`;
CREATE TABLE `mes_cal_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '计划编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '计划名称',
  `calendar_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '班组类型',
  `start_date` datetime DEFAULT NULL COMMENT '开始日期',
  `end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `shift_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '轮班方式',
  `shift_method` tinyint(4) NOT NULL DEFAULT 0 COMMENT '倒班方式',
  `shift_count` int(11) NOT NULL DEFAULT 0 COMMENT '倒班天数',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_cal_plan_code` (`code`),
  INDEX `idx_cal_plan_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 计划班次
DROP TABLE IF EXISTS `mes_cal_plan_shift`;
CREATE TABLE `mes_cal_plan_shift` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '班次编号',
  `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '排班计划编号',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '显示顺序',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '班次名称',
  `start_time` varchar(64) NOT NULL DEFAULT '' COMMENT '开始时间（HH:mm格式）',
  `end_time` varchar(64) NOT NULL DEFAULT '' COMMENT '结束时间（HH:mm格式）',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_cal_plan_shift_plan_id` (`plan_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 计划班组关联
DROP TABLE IF EXISTS `mes_cal_plan_team`;
CREATE TABLE `mes_cal_plan_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '排班计划编号',
  `team_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '班组编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_cal_plan_team_plan_id` (`plan_id`),
  INDEX `idx_cal_plan_team_team_id` (`team_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 班组
DROP TABLE IF EXISTS `mes_cal_team`;
CREATE TABLE `mes_cal_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '班组编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '班组编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '班组名称',
  `calendar_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '班组类型',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_cal_team_code` (`code`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 班组成员
DROP TABLE IF EXISTS `mes_cal_team_member`;
CREATE TABLE `mes_cal_team_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '班组成员编号',
  `team_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '班组编号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_cal_team_member_team_id` (`team_id`),
  INDEX `idx_cal_team_member_user_id` (`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 班组排班
DROP TABLE IF EXISTS `mes_cal_team_shift`;
CREATE TABLE `mes_cal_team_shift` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '排班计划编号',
  `team_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '班组编号',
  `shift_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '班次编号',
  `day` datetime DEFAULT NULL COMMENT '日期',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_cal_team_shift_plan_id` (`plan_id`),
  INDEX `idx_cal_team_shift_team_id` (`team_id`),
  INDEX `idx_cal_team_shift_shift_id` (`shift_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 假期设置
DROP TABLE IF EXISTS `mes_cal_holiday`;
CREATE TABLE `mes_cal_holiday` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `day` datetime DEFAULT NULL COMMENT '日期',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '日期类型',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_cal_holiday_day` (`day`),
  INDEX `idx_cal_holiday_type` (`type`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- ============================================================================
-- Module: dv (设备管理)
-- ============================================================================

-- MES 点检保养方案
DROP TABLE IF EXISTS `mes_dv_check_plan`;
CREATE TABLE `mes_dv_check_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '方案编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '方案名称',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '方案类型',
  `start_date` datetime DEFAULT NULL COMMENT '开始日期',
  `end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `cycle_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '周期类型',
  `cycle_count` int(11) NOT NULL DEFAULT 0 COMMENT '周期数量',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_check_plan_code` (`code`),
  INDEX `idx_dv_check_plan_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 点检保养方案设备
DROP TABLE IF EXISTS `mes_dv_check_plan_machinery`;
CREATE TABLE `mes_dv_check_plan_machinery` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '方案编号',
  `machinery_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '设备编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_check_plan_machinery_plan_id` (`plan_id`),
  INDEX `idx_dv_check_plan_machinery_machinery_id` (`machinery_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 点检保养方案项目
DROP TABLE IF EXISTS `mes_dv_check_plan_subject`;
CREATE TABLE `mes_dv_check_plan_subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '方案编号',
  `subject_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '项目编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_check_plan_subject_plan_id` (`plan_id`),
  INDEX `idx_dv_check_plan_subject_subject_id` (`subject_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 设备点检记录
DROP TABLE IF EXISTS `mes_dv_check_record`;
CREATE TABLE `mes_dv_check_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '点检计划编号',
  `machinery_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '设备编号',
  `check_time` datetime DEFAULT NULL COMMENT '点检时间',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '点检人编号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_check_record_plan_id` (`plan_id`),
  INDEX `idx_dv_check_record_machinery_id` (`machinery_id`),
  INDEX `idx_dv_check_record_user_id` (`user_id`),
  INDEX `idx_dv_check_record_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 设备点检记录明细
DROP TABLE IF EXISTS `mes_dv_check_record_line`;
CREATE TABLE `mes_dv_check_record_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '点检记录编号',
  `subject_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '点检项目编号',
  `check_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '点检结果',
  `check_result` varchar(500) DEFAULT '' COMMENT '异常描述',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_check_record_line_record_id` (`record_id`),
  INDEX `idx_dv_check_record_line_subject_id` (`subject_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 设备台账
DROP TABLE IF EXISTS `mes_dv_machinery`;
CREATE TABLE `mes_dv_machinery` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '设备编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '设备名称',
  `brand` varchar(255) DEFAULT '' COMMENT '品牌',
  `specification` varchar(255) DEFAULT '' COMMENT '规格型号',
  `machinery_type_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '设备类型编号',
  `workshop_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '所属车间编号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '设备状态',
  `last_mainten_time` datetime DEFAULT NULL COMMENT '最近保养时间',
  `last_check_time` datetime DEFAULT NULL COMMENT '最近点检时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_machinery_code` (`code`),
  INDEX `idx_dv_machinery_machinery_type_id` (`machinery_type_id`),
  INDEX `idx_dv_machinery_workshop_id` (`workshop_id`),
  INDEX `idx_dv_machinery_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 设备类型
DROP TABLE IF EXISTS `mes_dv_machinery_type`;
CREATE TABLE `mes_dv_machinery_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '类型编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '类型名称',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父类型编号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '显示排序',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_machinery_type_code` (`code`),
  INDEX `idx_dv_machinery_type_parent_id` (`parent_id`),
  INDEX `idx_dv_machinery_type_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 设备保养记录
DROP TABLE IF EXISTS `mes_dv_mainten_record`;
CREATE TABLE `mes_dv_mainten_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '计划编号',
  `machinery_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '设备编号',
  `mainten_time` datetime DEFAULT NULL COMMENT '保养时间',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_mainten_record_plan_id` (`plan_id`),
  INDEX `idx_dv_mainten_record_machinery_id` (`machinery_id`),
  INDEX `idx_dv_mainten_record_user_id` (`user_id`),
  INDEX `idx_dv_mainten_record_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 设备保养记录明细
DROP TABLE IF EXISTS `mes_dv_mainten_record_line`;
CREATE TABLE `mes_dv_mainten_record_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '保养记录编号',
  `subject_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '项目编号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '保养结果',
  `result` varchar(500) DEFAULT '' COMMENT '异常描述',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_mainten_record_line_record_id` (`record_id`),
  INDEX `idx_dv_mainten_record_line_subject_id` (`subject_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 维修工单
DROP TABLE IF EXISTS `mes_dv_repair`;
CREATE TABLE `mes_dv_repair` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '维修工单编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '维修工单名称',
  `machinery_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '设备编号',
  `require_date` datetime DEFAULT NULL COMMENT '报修日期',
  `finish_date` datetime DEFAULT NULL COMMENT '维修完成日期',
  `confirm_date` datetime DEFAULT NULL COMMENT '验收日期',
  `result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '维修结果',
  `accepted_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '维修人用户编号',
  `confirm_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '验收人用户编号',
  `source_doc_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '来源单据类型',
  `source_doc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据编号',
  `source_doc_code` varchar(64) DEFAULT '' COMMENT '来源单据编码',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_repair_code` (`code`),
  INDEX `idx_dv_repair_machinery_id` (`machinery_id`),
  INDEX `idx_dv_repair_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 维修工单行
DROP TABLE IF EXISTS `mes_dv_repair_line`;
CREATE TABLE `mes_dv_repair_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `repair_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '维修工单编号',
  `subject_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '点检保养项目编号',
  `malfunction` varchar(500) DEFAULT '' COMMENT '故障描述',
  `malfunction_url` varchar(500) DEFAULT '' COMMENT '故障图片URL',
  `description` varchar(500) DEFAULT '' COMMENT '维修描述',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_repair_line_repair_id` (`repair_id`),
  INDEX `idx_dv_repair_line_subject_id` (`subject_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 点检保养项目
DROP TABLE IF EXISTS `mes_dv_subject`;
CREATE TABLE `mes_dv_subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '项目编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '项目名称',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '项目类型',
  `content` text COMMENT '项目内容',
  `standard` varchar(500) DEFAULT '' COMMENT '标准',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_dv_subject_code` (`code`),
  INDEX `idx_dv_subject_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- ============================================================================
-- Module: md (主数据管理)
-- ============================================================================

-- MES 编码规则
DROP TABLE IF EXISTS `mes_md_auto_code_rule`;
CREATE TABLE `mes_md_auto_code_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规则ID',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '规则编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '规则名称',
  `description` varchar(500) DEFAULT '' COMMENT '描述',
  `max_length` int(11) NOT NULL DEFAULT 0 COMMENT '最大长度',
  `padded` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否补齐',
  `padded_char` varchar(64) DEFAULT '' COMMENT '补齐字符',
  `padded_method` tinyint(4) NOT NULL DEFAULT 0 COMMENT '补齐方式',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_auto_code_rule_code` (`code`),
  INDEX `idx_md_auto_code_rule_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 编码规则组成
DROP TABLE IF EXISTS `mes_md_auto_code_part`;
CREATE TABLE `mes_md_auto_code_part` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分段ID',
  `rule_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '规则ID',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '分段序号',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '分段类型',
  `length` int(11) NOT NULL DEFAULT 0 COMMENT '分段长度',
  `date_format` varchar(64) DEFAULT '' COMMENT '日期格式',
  `fix_character` varchar(64) DEFAULT '' COMMENT '固定字符',
  `serial_start_no` int(11) NOT NULL DEFAULT 0 COMMENT '流水号起始值',
  `serial_step` int(11) NOT NULL DEFAULT 0 COMMENT '流水号步长',
  `cycle_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '流水号是否循环',
  `cycle_method` tinyint(4) NOT NULL DEFAULT 0 COMMENT '循环方式',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_auto_code_part_rule_id` (`rule_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 编码生成记录
DROP TABLE IF EXISTS `mes_md_auto_code_record`;
CREATE TABLE `mes_md_auto_code_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `rule_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '规则ID',
  `result` varchar(255) DEFAULT '' COMMENT '生成的编码',
  `serial_no` bigint(20) NOT NULL DEFAULT 0 COMMENT '生成的流水号',
  `input_char` varchar(255) DEFAULT '' COMMENT '传入的参数',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_auto_code_record_rule_id` (`rule_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 客户
DROP TABLE IF EXISTS `mes_md_client`;
CREATE TABLE `mes_md_client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '客户编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '客户名称',
  `nickname` varchar(100) DEFAULT '' COMMENT '客户简称',
  `english_name` varchar(255) DEFAULT '' COMMENT '客户英文名称',
  `description` varchar(500) DEFAULT '' COMMENT '客户简介',
  `logo` varchar(500) DEFAULT '' COMMENT '客户LOGO地址',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '客户类型',
  `address` varchar(500) DEFAULT '' COMMENT '客户地址',
  `website` varchar(500) DEFAULT '' COMMENT '客户官网地址',
  `email` varchar(100) DEFAULT '' COMMENT '客户邮箱地址',
  `telephone` varchar(64) DEFAULT '' COMMENT '客户电话',
  `contact1_name` varchar(100) DEFAULT '' COMMENT '联系人1',
  `contact1_telephone` varchar(64) DEFAULT '' COMMENT '联系人1-电话',
  `contact1_email` varchar(100) DEFAULT '' COMMENT '联系人1-邮箱',
  `contact2_name` varchar(100) DEFAULT '' COMMENT '联系人2',
  `contact2_telephone` varchar(64) DEFAULT '' COMMENT '联系人2-电话',
  `contact2_email` varchar(100) DEFAULT '' COMMENT '联系人2-邮箱',
  `credit_code` varchar(64) DEFAULT '' COMMENT '统一社会信用代码',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_client_code` (`code`),
  INDEX `idx_md_client_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 物料产品
DROP TABLE IF EXISTS `mes_md_item`;
CREATE TABLE `mes_md_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物料编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '物料编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '物料名称',
  `specification` varchar(255) DEFAULT '' COMMENT '规格型号',
  `unit_measure_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '计量单位编号',
  `item_type_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料分类编号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `safe_stock_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否启用安全库存',
  `min_stock` decimal(24,6) DEFAULT NULL COMMENT '最低库存量',
  `max_stock` decimal(24,6) DEFAULT NULL COMMENT '最高库存量',
  `high_value` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否高值物料',
  `batch_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否启用批次管理',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_item_code` (`code`),
  INDEX `idx_md_item_unit_measure_id` (`unit_measure_id`),
  INDEX `idx_md_item_item_type_id` (`item_type_id`),
  INDEX `idx_md_item_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 物料批次属性配置
DROP TABLE IF EXISTS `mes_md_item_batch_config`;
CREATE TABLE `mes_md_item_batch_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `produce_date_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-生产日期',
  `expire_date_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-有效期',
  `receipt_date_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-入库日期',
  `vendor_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-供应商',
  `client_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-客户',
  `sales_order_code_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-销售订单编号',
  `purchase_order_code_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-采购订单编号',
  `work_order_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-生产工单',
  `task_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-生产任务',
  `workstation_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-工作站',
  `tool_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-工具',
  `mold_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-模具',
  `lot_number_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-生产批号',
  `quality_status_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '批次属性-质量状态',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_item_batch_config_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 物料产品分类
DROP TABLE IF EXISTS `mes_md_item_type`;
CREATE TABLE `mes_md_item_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '分类编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '分类名称',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父分类编号',
  `item_or_product` varchar(64) DEFAULT '' COMMENT '物料/产品标识',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '显示排序',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_item_type_code` (`code`),
  INDEX `idx_md_item_type_parent_id` (`parent_id`),
  INDEX `idx_md_item_type_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 产品BOM
DROP TABLE IF EXISTS `mes_md_product_bom`;
CREATE TABLE `mes_md_product_bom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'BOM编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料产品编号',
  `bom_item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT 'BOM物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '物料使用比例',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否启用',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_product_bom_item_id` (`item_id`),
  INDEX `idx_md_product_bom_bom_item_id` (`bom_item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 产品SIP
DROP TABLE IF EXISTS `mes_md_product_sip`;
CREATE TABLE `mes_md_product_sip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料产品编号',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排列顺序',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序编号',
  `title` varchar(255) DEFAULT '' COMMENT '标题',
  `description` varchar(500) DEFAULT '' COMMENT '详细描述',
  `url` varchar(500) DEFAULT '' COMMENT '图片地址',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_product_sip_item_id` (`item_id`),
  INDEX `idx_md_product_sip_process_id` (`process_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 产品SOP
DROP TABLE IF EXISTS `mes_md_product_sop`;
CREATE TABLE `mes_md_product_sop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料产品编号',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排列顺序',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序编号',
  `title` varchar(255) DEFAULT '' COMMENT '标题',
  `description` varchar(500) DEFAULT '' COMMENT '详细描述',
  `url` varchar(500) DEFAULT '' COMMENT '图片地址',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_product_sop_item_id` (`item_id`),
  INDEX `idx_md_product_sop_process_id` (`process_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 计量单位
DROP TABLE IF EXISTS `mes_md_unit_measure`;
CREATE TABLE `mes_md_unit_measure` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '单位编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '单位编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '单位名称',
  `primary_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否主单位',
  `primary_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '主单位编号',
  `change_rate` decimal(10,2) DEFAULT NULL COMMENT '与主单位换算比例',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_unit_measure_code` (`code`),
  INDEX `idx_md_unit_measure_primary_id` (`primary_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 供应商
DROP TABLE IF EXISTS `mes_md_vendor`;
CREATE TABLE `mes_md_vendor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '供应商编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '供应商编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '供应商名称',
  `nickname` varchar(100) DEFAULT '' COMMENT '供应商简称',
  `english_name` varchar(255) DEFAULT '' COMMENT '供应商英文名称',
  `description` varchar(500) DEFAULT '' COMMENT '供应商简介',
  `logo` varchar(500) DEFAULT '' COMMENT '供应商LOGO地址',
  `level` varchar(64) DEFAULT '' COMMENT '供应商等级',
  `score` int(11) NOT NULL DEFAULT 0 COMMENT '供应商评分',
  `address` varchar(500) DEFAULT '' COMMENT '供应商地址',
  `website` varchar(500) DEFAULT '' COMMENT '供应商官网地址',
  `email` varchar(100) DEFAULT '' COMMENT '供应商邮箱地址',
  `telephone` varchar(64) DEFAULT '' COMMENT '供应商电话',
  `contact1_name` varchar(100) DEFAULT '' COMMENT '联系人1',
  `contact1_telephone` varchar(64) DEFAULT '' COMMENT '联系人1-电话',
  `contact1_email` varchar(100) DEFAULT '' COMMENT '联系人1-邮箱',
  `contact2_name` varchar(100) DEFAULT '' COMMENT '联系人2',
  `contact2_telephone` varchar(64) DEFAULT '' COMMENT '联系人2-电话',
  `contact2_email` varchar(100) DEFAULT '' COMMENT '联系人2-邮箱',
  `credit_code` varchar(64) DEFAULT '' COMMENT '统一社会信用代码',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_vendor_code` (`code`),
  INDEX `idx_md_vendor_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 车间
DROP TABLE IF EXISTS `mes_md_workshop`;
CREATE TABLE `mes_md_workshop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '车间编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '车间名称',
  `area` decimal(24,6) DEFAULT NULL COMMENT '面积（平方米）',
  `charge_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '负责人用户编号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_workshop_code` (`code`),
  INDEX `idx_md_workshop_charge_user_id` (`charge_user_id`),
  INDEX `idx_md_workshop_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 工作站
DROP TABLE IF EXISTS `mes_md_workstation`;
CREATE TABLE `mes_md_workstation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '工作站编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '工作站名称',
  `address` varchar(500) DEFAULT '' COMMENT '工作站地点',
  `workshop_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '所在车间编号',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序编号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '线边库编号',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区编号',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位编号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_workstation_code` (`code`),
  INDEX `idx_md_workstation_workshop_id` (`workshop_id`),
  INDEX `idx_md_workstation_process_id` (`process_id`),
  INDEX `idx_md_workstation_warehouse_id` (`warehouse_id`),
  INDEX `idx_md_workstation_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 设备资源（工作站关联）
DROP TABLE IF EXISTS `mes_md_workstation_machine`;
CREATE TABLE `mes_md_workstation_machine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站编号',
  `machinery_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '设备编号',
  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_workstation_machine_workstation_id` (`workstation_id`),
  INDEX `idx_md_workstation_machine_machinery_id` (`machinery_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 工装夹具资源
DROP TABLE IF EXISTS `mes_md_workstation_tool`;
CREATE TABLE `mes_md_workstation_tool` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站编号',
  `tool_type_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工具类型编号',
  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_workstation_tool_workstation_id` (`workstation_id`),
  INDEX `idx_md_workstation_tool_tool_type_id` (`tool_type_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 人力资源（工作站关联）
DROP TABLE IF EXISTS `mes_md_workstation_worker`;
CREATE TABLE `mes_md_workstation_worker` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站编号',
  `post_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '岗位编号',
  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_md_workstation_worker_workstation_id` (`workstation_id`),
  INDEX `idx_md_workstation_worker_post_id` (`post_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- ============================================================================
-- Module: pro (生产管理)
-- ============================================================================

-- MES 安灯呼叫配置
DROP TABLE IF EXISTS `mes_pro_andon_config`;
CREATE TABLE `mes_pro_andon_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `reason` varchar(500) DEFAULT '' COMMENT '呼叫原因',
  `level` tinyint(4) NOT NULL DEFAULT 0 COMMENT '级别',
  `handler_role_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '处置人角色编号',
  `handler_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '处置人编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 安灯呼叫记录
DROP TABLE IF EXISTS `mes_pro_andon_record`;
CREATE TABLE `mes_pro_andon_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `config_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '安灯配置编号',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站编号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '发起用户编号',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单编号',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序编号',
  `reason` varchar(500) DEFAULT '' COMMENT '呼叫原因（快照值）',
  `level` tinyint(4) NOT NULL DEFAULT 0 COMMENT '级别（快照值）',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '处置状态',
  `handle_time` datetime DEFAULT NULL COMMENT '处置时间',
  `handler_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '处置人编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_andon_record_workstation_id` (`workstation_id`),
  INDEX `idx_pro_andon_record_user_id` (`user_id`),
  INDEX `idx_pro_andon_record_work_order_id` (`work_order_id`),
  INDEX `idx_pro_andon_record_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产流转卡
DROP TABLE IF EXISTS `mes_pro_card`;
CREATE TABLE `mes_pro_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '流转卡编码',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `transfered_quantity` decimal(24,6) DEFAULT NULL COMMENT '流转数量',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_card_code` (`code`),
  INDEX `idx_pro_card_work_order_id` (`work_order_id`),
  INDEX `idx_pro_card_item_id` (`item_id`),
  INDEX `idx_pro_card_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 流转卡工序记录
DROP TABLE IF EXISTS `mes_pro_card_process`;
CREATE TABLE `mes_pro_card_process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `card_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '流转卡编号',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '序号',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序编号',
  `input_time` datetime DEFAULT NULL COMMENT '进入工序时间',
  `output_time` datetime DEFAULT NULL COMMENT '出工序时间',
  `input_quantity` decimal(24,6) DEFAULT NULL COMMENT '投入数量',
  `output_quantity` decimal(24,6) DEFAULT NULL COMMENT '产出数量',
  `unqualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '不合格品数量',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工位编号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '操作人编号',
  `ipqc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '过程检验单编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_card_process_card_id` (`card_id`),
  INDEX `idx_pro_card_process_process_id` (`process_id`),
  INDEX `idx_pro_card_process_workstation_id` (`workstation_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产报工
DROP TABLE IF EXISTS `mes_pro_feedback`;
CREATE TABLE `mes_pro_feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '报工单编号',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '报工类型',
  `channel` varchar(64) DEFAULT '' COMMENT '报工途径',
  `feedback_time` datetime DEFAULT NULL COMMENT '报工时间',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站编号',
  `route_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工艺路线编号',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序编号',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单编号',
  `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产任务编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料编号',
  `expire_date` datetime DEFAULT NULL COMMENT '过期日期',
  `lot_number` varchar(64) DEFAULT '' COMMENT '生产批号',
  `scheduled_quantity` decimal(24,6) DEFAULT NULL COMMENT '排产数量',
  `feedback_quantity` decimal(24,6) DEFAULT NULL COMMENT '本次报工数量',
  `qualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '合格品数量',
  `unqualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '不良品数量',
  `uncheck_quantity` decimal(24,6) DEFAULT NULL COMMENT '待检测数量',
  `labor_scrap_quantity` decimal(24,6) DEFAULT NULL COMMENT '工废数量',
  `material_scrap_quantity` decimal(24,6) DEFAULT NULL COMMENT '料废数量',
  `other_scrap_quantity` decimal(24,6) DEFAULT NULL COMMENT '其他废品数量',
  `feedback_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '报工用户编号',
  `approve_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审核用户编号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_feedback_code` (`code`),
  INDEX `idx_pro_feedback_workstation_id` (`workstation_id`),
  INDEX `idx_pro_feedback_work_order_id` (`work_order_id`),
  INDEX `idx_pro_feedback_process_id` (`process_id`),
  INDEX `idx_pro_feedback_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产工序
DROP TABLE IF EXISTS `mes_pro_process`;
CREATE TABLE `mes_pro_process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '工序编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '工序名称',
  `attention` varchar(500) DEFAULT '' COMMENT '工艺要求',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_process_code` (`code`),
  INDEX `idx_pro_process_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产工序内容
DROP TABLE IF EXISTS `mes_pro_process_content`;
CREATE TABLE `mes_pro_process_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序编号',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '顺序编号',
  `content` text COMMENT '步骤说明',
  `device` varchar(255) DEFAULT '' COMMENT '辅助设备',
  `material` varchar(255) DEFAULT '' COMMENT '辅助材料',
  `doc_url` varchar(500) DEFAULT '' COMMENT '材料文档URL',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_process_content_process_id` (`process_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 工艺路线
DROP TABLE IF EXISTS `mes_pro_route`;
CREATE TABLE `mes_pro_route` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '工艺路线编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '工艺路线名称',
  `description` varchar(500) DEFAULT '' COMMENT '工艺路线说明',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_route_code` (`code`),
  INDEX `idx_pro_route_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 工艺路线工序
DROP TABLE IF EXISTS `mes_pro_route_process`;
CREATE TABLE `mes_pro_route_process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `route_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工艺路线编号',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序编号',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '序号',
  `next_process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '下一道工序编号',
  `link_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '与下一道工序关系',
  `prepare_time` int(11) NOT NULL DEFAULT 0 COMMENT '准备时间（分钟）',
  `wait_time` int(11) NOT NULL DEFAULT 0 COMMENT '等待时间（分钟）',
  `color_code` varchar(64) DEFAULT '' COMMENT '甘特图显示颜色',
  `key_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否关键工序',
  `check_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否质检工序',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_route_process_route_id` (`route_id`),
  INDEX `idx_pro_route_process_process_id` (`process_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 工艺路线产品
DROP TABLE IF EXISTS `mes_pro_route_product`;
CREATE TABLE `mes_pro_route_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `route_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工艺路线编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料编号',
  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '生产数量',
  `production_time` decimal(24,6) DEFAULT NULL COMMENT '生产用时',
  `time_unit_type` varchar(64) DEFAULT '' COMMENT '时间单位',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_route_product_route_id` (`route_id`),
  INDEX `idx_pro_route_product_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 工艺路线产品BOM
DROP TABLE IF EXISTS `mes_pro_route_product_bom`;
CREATE TABLE `mes_pro_route_product_bom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `route_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工艺路线编号',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序编号',
  `product_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT 'BOM物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '用料比例',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_route_product_bom_route_id` (`route_id`),
  INDEX `idx_pro_route_product_bom_process_id` (`process_id`),
  INDEX `idx_pro_route_product_bom_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产任务
DROP TABLE IF EXISTS `mes_pro_task`;
CREATE TABLE `mes_pro_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '任务编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '任务名称',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单编号',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站编号',
  `route_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工艺路线编号',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '排产数量',
  `produced_quantity` decimal(24,6) DEFAULT NULL COMMENT '已生产数量',
  `qualify_quantity` decimal(24,6) DEFAULT NULL COMMENT '合格品数量',
  `unqualify_quantity` decimal(24,6) DEFAULT NULL COMMENT '不良品数量',
  `changed_quantity` decimal(24,6) DEFAULT NULL COMMENT '调整数量',
  `client_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '客户编号',
  `start_time` datetime DEFAULT NULL COMMENT '开始生产时间',
  `duration` int(11) NOT NULL DEFAULT 0 COMMENT '生产时长（工作日）',
  `end_time` datetime DEFAULT NULL COMMENT '结束生产时间',
  `color_code` varchar(64) DEFAULT '' COMMENT '甘特图显示颜色',
  `finish_date` datetime DEFAULT NULL COMMENT '完成日期',
  `cancel_date` datetime DEFAULT NULL COMMENT '取消日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '任务状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_task_code` (`code`),
  INDEX `idx_pro_task_work_order_id` (`work_order_id`),
  INDEX `idx_pro_task_workstation_id` (`workstation_id`),
  INDEX `idx_pro_task_process_id` (`process_id`),
  INDEX `idx_pro_task_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产任务投料
DROP TABLE IF EXISTS `mes_pro_task_issue`;
CREATE TABLE `mes_pro_task_issue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产任务编号',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单编号',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站编号',
  `source_doc_type` varchar(64) DEFAULT '' COMMENT '来源单据类型',
  `source_doc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据编号',
  `source_line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据行编号',
  `source_doc_code` varchar(64) DEFAULT '' COMMENT '来源单据编码',
  `batch_code` varchar(64) DEFAULT '' COMMENT '投料批次',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料编号',
  `unit_measure_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '单位编号',
  `issued_quantity` decimal(24,6) DEFAULT NULL COMMENT '总投料数量',
  `available_quantity` decimal(24,6) DEFAULT NULL COMMENT '当前可用数量',
  `used_quantity` decimal(24,6) DEFAULT NULL COMMENT '当前使用数量',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_task_issue_task_id` (`task_id`),
  INDEX `idx_pro_task_issue_work_order_id` (`work_order_id`),
  INDEX `idx_pro_task_issue_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产工单
DROP TABLE IF EXISTS `mes_pro_work_order`;
CREATE TABLE `mes_pro_work_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '工单编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '工单名称',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '工单类型',
  `order_source_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '来源类型',
  `order_source_code` varchar(64) DEFAULT '' COMMENT '来源单据编号',
  `product_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '生产数量',
  `quantity_produced` decimal(24,6) DEFAULT NULL COMMENT '已生产数量',
  `quantity_changed` decimal(24,6) DEFAULT NULL COMMENT '调整数量',
  `quantity_scheduled` decimal(24,6) DEFAULT NULL COMMENT '已排产数量',
  `client_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '客户编号',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '供应商编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `request_date` datetime DEFAULT NULL COMMENT '需求日期',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父工单编号',
  `finish_date` datetime DEFAULT NULL COMMENT '完成时间',
  `cancel_date` datetime DEFAULT NULL COMMENT '取消时间',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '工单状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_work_order_code` (`code`),
  INDEX `idx_pro_work_order_product_id` (`product_id`),
  INDEX `idx_pro_work_order_client_id` (`client_id`),
  INDEX `idx_pro_work_order_parent_id` (`parent_id`),
  INDEX `idx_pro_work_order_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产工单BOM
DROP TABLE IF EXISTS `mes_pro_work_order_bom`;
CREATE TABLE `mes_pro_work_order_bom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT 'BOM物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '预计使用量',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_work_order_bom_work_order_id` (`work_order_id`),
  INDEX `idx_pro_work_order_bom_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 用户工作站绑定关系（当前快照）
DROP TABLE IF EXISTS `mes_pro_work_record`;
CREATE TABLE `mes_pro_work_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站编号',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '当前状态',
  `clock_in_time` datetime DEFAULT NULL COMMENT '上工时间',
  `clock_out_time` datetime DEFAULT NULL COMMENT '下工时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_work_record_user_id` (`user_id`),
  INDEX `idx_pro_work_record_workstation_id` (`workstation_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 上下工记录流水
DROP TABLE IF EXISTS `mes_pro_work_record_log`;
CREATE TABLE `mes_pro_work_record_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站编号',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '操作类型',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_pro_work_record_log_user_id` (`user_id`),
  INDEX `idx_pro_work_record_log_workstation_id` (`workstation_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- ============================================================================
-- Module: qc (质量管理)
-- ============================================================================

-- MES 缺陷类型
DROP TABLE IF EXISTS `mes_qc_defect`;
CREATE TABLE `mes_qc_defect` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '缺陷编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '缺陷描述',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检测项类型',
  `level` tinyint(4) NOT NULL DEFAULT 0 COMMENT '缺陷等级',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_defect_code` (`code`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 质检缺陷记录
DROP TABLE IF EXISTS `mes_qc_defect_record`;
CREATE TABLE `mes_qc_defect_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `qc_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检验类型',
  `qc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验单ID',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验行ID',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '缺陷描述',
  `level` tinyint(4) NOT NULL DEFAULT 0 COMMENT '缺陷等级',
  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '缺陷数量',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_defect_record_qc_id` (`qc_id`),
  INDEX `idx_qc_defect_record_line_id` (`line_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 质检指标
DROP TABLE IF EXISTS `mes_qc_indicator`;
CREATE TABLE `mes_qc_indicator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '检测项编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '检测项名称',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检测项类型',
  `tool` varchar(255) DEFAULT '' COMMENT '检测工具',
  `result_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '结果值类型',
  `result_specification` varchar(500) DEFAULT '' COMMENT '结果值属性',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_indicator_code` (`code`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 检验结果记录
DROP TABLE IF EXISTS `mes_qc_indicator_result`;
CREATE TABLE `mes_qc_indicator_result` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '样品编号',
  `qc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联质检单ID',
  `qc_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '质检类型',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料ID',
  `sn` varchar(64) DEFAULT '' COMMENT '物资SN',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_indicator_result_qc_id` (`qc_id`),
  INDEX `idx_qc_indicator_result_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 检验结果明细记录
DROP TABLE IF EXISTS `mes_qc_indicator_result_detail`;
CREATE TABLE `mes_qc_indicator_result_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `result_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联检验结果ID',
  `indicator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检测指标ID',
  `value` varchar(255) DEFAULT '' COMMENT '检测值',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_indicator_result_detail_result_id` (`result_id`),
  INDEX `idx_qc_indicator_result_detail_indicator_id` (`indicator_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 过程检验单（IPQC）
DROP TABLE IF EXISTS `mes_qc_ipqc`;
CREATE TABLE `mes_qc_ipqc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '检验单编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '检验单名称',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT 'IPQC检验类型',
  `template_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验模板ID',
  `source_doc_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '来源单据类型',
  `source_doc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据ID',
  `source_line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据行ID',
  `source_doc_code` varchar(64) DEFAULT '' COMMENT '来源单据编号',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单ID',
  `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产任务ID',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工位ID',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料ID',
  `check_quantity` decimal(24,6) DEFAULT NULL COMMENT '检测数量',
  `qualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '合格品数量',
  `unqualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '不合格品数量',
  `labor_scrap_quantity` decimal(24,6) DEFAULT NULL COMMENT '工废数量',
  `material_scrap_quantity` decimal(24,6) DEFAULT NULL COMMENT '料废数量',
  `other_scrap_quantity` decimal(24,6) DEFAULT NULL COMMENT '其他废品数量',
  `critical_rate` decimal(10,2) DEFAULT NULL COMMENT '致命缺陷率（%）',
  `major_rate` decimal(10,2) DEFAULT NULL COMMENT '严重缺陷率（%）',
  `minor_rate` decimal(10,2) DEFAULT NULL COMMENT '轻微缺陷率（%）',
  `critical_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '致命缺陷数量',
  `major_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '严重缺陷数量',
  `minor_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '轻微缺陷数量',
  `check_result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检测结果',
  `inspect_date` datetime DEFAULT NULL COMMENT '检测日期',
  `inspector_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检测人员用户ID',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_ipqc_code` (`code`),
  INDEX `idx_qc_ipqc_work_order_id` (`work_order_id`),
  INDEX `idx_qc_ipqc_item_id` (`item_id`),
  INDEX `idx_qc_ipqc_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 过程检验单行
DROP TABLE IF EXISTS `mes_qc_ipqc_line`;
CREATE TABLE `mes_qc_ipqc_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `ipqc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '过程检验单ID',
  `indicator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检测指标ID',
  `tool` varchar(255) DEFAULT '' COMMENT '检测工具',
  `check_method` varchar(255) DEFAULT '' COMMENT '检测方法',
  `standard_value` decimal(24,6) DEFAULT NULL COMMENT '标准值',
  `unit_measure_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '计量单位ID',
  `max_threshold` decimal(24,6) DEFAULT NULL COMMENT '误差上限',
  `min_threshold` decimal(24,6) DEFAULT NULL COMMENT '误差下限',
  `critical_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '致命缺陷数量',
  `major_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '严重缺陷数量',
  `minor_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '轻微缺陷数量',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_ipqc_line_ipqc_id` (`ipqc_id`),
  INDEX `idx_qc_ipqc_line_indicator_id` (`indicator_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 来料检验单（IQC）
DROP TABLE IF EXISTS `mes_qc_iqc`;
CREATE TABLE `mes_qc_iqc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '检验单编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '检验单名称',
  `template_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验模板ID',
  `source_doc_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '来源单据类型',
  `source_doc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据ID',
  `source_line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据行ID',
  `source_doc_code` varchar(64) DEFAULT '' COMMENT '来源单据编号',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '供应商ID',
  `vendor_batch` varchar(64) DEFAULT '' COMMENT '供应商批次号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料ID',
  `received_quantity` decimal(24,6) DEFAULT NULL COMMENT '本次接收数量',
  `check_quantity` decimal(24,6) DEFAULT NULL COMMENT '本次检测数量',
  `qualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '合格品数量',
  `unqualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '不合格品数量',
  `critical_rate` decimal(10,2) DEFAULT NULL COMMENT '致命缺陷率（%）',
  `major_rate` decimal(10,2) DEFAULT NULL COMMENT '严重缺陷率（%）',
  `minor_rate` decimal(10,2) DEFAULT NULL COMMENT '轻微缺陷率（%）',
  `critical_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '致命缺陷数量',
  `major_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '严重缺陷数量',
  `minor_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '轻微缺陷数量',
  `check_result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检测结果',
  `receive_date` datetime DEFAULT NULL COMMENT '来料日期',
  `inspect_date` datetime DEFAULT NULL COMMENT '检测日期',
  `inspector_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检测人员用户ID',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_iqc_code` (`code`),
  INDEX `idx_qc_iqc_vendor_id` (`vendor_id`),
  INDEX `idx_qc_iqc_item_id` (`item_id`),
  INDEX `idx_qc_iqc_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 来料检验单行
DROP TABLE IF EXISTS `mes_qc_iqc_line`;
CREATE TABLE `mes_qc_iqc_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `iqc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来料检验单ID',
  `indicator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检测指标ID',
  `tool` varchar(255) DEFAULT '' COMMENT '检测工具',
  `check_method` varchar(255) DEFAULT '' COMMENT '检测方法',
  `standard_value` decimal(24,6) DEFAULT NULL COMMENT '标准值',
  `unit_measure_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '计量单位ID',
  `max_threshold` decimal(24,6) DEFAULT NULL COMMENT '误差上限',
  `min_threshold` decimal(24,6) DEFAULT NULL COMMENT '误差下限',
  `critical_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '致命缺陷数量',
  `major_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '严重缺陷数量',
  `minor_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '轻微缺陷数量',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_iqc_line_iqc_id` (`iqc_id`),
  INDEX `idx_qc_iqc_line_indicator_id` (`indicator_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 出货检验单（OQC）
DROP TABLE IF EXISTS `mes_qc_oqc`;
CREATE TABLE `mes_qc_oqc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '检验单编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '检验单名称',
  `template_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验模板ID',
  `source_doc_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '来源单据类型',
  `source_doc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据ID',
  `source_line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据行ID',
  `source_doc_code` varchar(64) DEFAULT '' COMMENT '来源单据编号',
  `client_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '客户ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料ID',
  `min_check_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '最低检测数',
  `max_unqualified_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '最大不合格数',
  `out_quantity` decimal(24,6) DEFAULT NULL COMMENT '本次出货数量',
  `check_quantity` decimal(24,6) DEFAULT NULL COMMENT '本次检测数量',
  `qualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '合格品数量',
  `unqualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '不合格品数量',
  `critical_rate` decimal(10,2) DEFAULT NULL COMMENT '致命缺陷率（%）',
  `major_rate` decimal(10,2) DEFAULT NULL COMMENT '严重缺陷率（%）',
  `minor_rate` decimal(10,2) DEFAULT NULL COMMENT '轻微缺陷率（%）',
  `critical_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '致命缺陷数量',
  `major_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '严重缺陷数量',
  `minor_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '轻微缺陷数量',
  `check_result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检测结果',
  `out_date` datetime DEFAULT NULL COMMENT '出货日期',
  `inspect_date` datetime DEFAULT NULL COMMENT '检测日期',
  `inspector_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检测人员用户ID',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_oqc_code` (`code`),
  INDEX `idx_qc_oqc_client_id` (`client_id`),
  INDEX `idx_qc_oqc_item_id` (`item_id`),
  INDEX `idx_qc_oqc_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 出货检验单行
DROP TABLE IF EXISTS `mes_qc_oqc_line`;
CREATE TABLE `mes_qc_oqc_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `oqc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '出货检验单ID',
  `indicator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检测指标ID',
  `tool` varchar(255) DEFAULT '' COMMENT '检测工具',
  `check_method` varchar(255) DEFAULT '' COMMENT '检测方法',
  `standard_value` decimal(24,6) DEFAULT NULL COMMENT '标准值',
  `unit_measure_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '计量单位ID',
  `max_threshold` decimal(24,6) DEFAULT NULL COMMENT '误差上限',
  `min_threshold` decimal(24,6) DEFAULT NULL COMMENT '误差下限',
  `critical_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '致命缺陷数量',
  `major_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '严重缺陷数量',
  `minor_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '轻微缺陷数量',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_oqc_line_oqc_id` (`oqc_id`),
  INDEX `idx_qc_oqc_line_indicator_id` (`indicator_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 退货检验单（RQC）
DROP TABLE IF EXISTS `mes_qc_rqc`;
CREATE TABLE `mes_qc_rqc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '检验单编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '检验单名称',
  `template_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验模板ID',
  `source_doc_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '来源单据类型',
  `source_doc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据ID',
  `source_line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据行ID',
  `source_doc_code` varchar(64) DEFAULT '' COMMENT '来源单据编码',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检验类型',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `check_quantity` decimal(24,6) DEFAULT NULL COMMENT '检测数量',
  `qualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '合格品数量',
  `unqualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '不合格数量',
  `critical_rate` decimal(10,2) DEFAULT NULL COMMENT '致命缺陷率（%）',
  `major_rate` decimal(10,2) DEFAULT NULL COMMENT '严重缺陷率（%）',
  `minor_rate` decimal(10,2) DEFAULT NULL COMMENT '轻微缺陷率（%）',
  `critical_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '致命缺陷数量',
  `major_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '严重缺陷数量',
  `minor_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '轻微缺陷数量',
  `check_result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检测结果',
  `inspect_date` datetime DEFAULT NULL COMMENT '检测日期',
  `inspector_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检测人员用户ID',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_rqc_code` (`code`),
  INDEX `idx_qc_rqc_item_id` (`item_id`),
  INDEX `idx_qc_rqc_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 退货检验行
DROP TABLE IF EXISTS `mes_qc_rqc_line`;
CREATE TABLE `mes_qc_rqc_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `rqc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '退货检验单ID',
  `indicator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检测指标ID',
  `tool` varchar(255) DEFAULT '' COMMENT '检测工具',
  `check_method` varchar(255) DEFAULT '' COMMENT '检测方法',
  `standard_value` decimal(24,6) DEFAULT NULL COMMENT '标准值',
  `unit_measure_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '计量单位ID',
  `max_threshold` decimal(24,6) DEFAULT NULL COMMENT '误差上限',
  `min_threshold` decimal(24,6) DEFAULT NULL COMMENT '误差下限',
  `critical_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '致命缺陷数量',
  `major_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '严重缺陷数量',
  `minor_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '轻微缺陷数量',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_rqc_line_rqc_id` (`rqc_id`),
  INDEX `idx_qc_rqc_line_indicator_id` (`indicator_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 质检方案
DROP TABLE IF EXISTS `mes_qc_template`;
CREATE TABLE `mes_qc_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '方案编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '方案名称',
  `types` varchar(2000) DEFAULT '' COMMENT '检测种类（JSON列表）',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_template_code` (`code`),
  INDEX `idx_qc_template_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 质检方案-检测指标项
DROP TABLE IF EXISTS `mes_qc_template_indicator`;
CREATE TABLE `mes_qc_template_indicator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `template_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '质检方案编号',
  `indicator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '质检指标编号',
  `check_method` varchar(255) DEFAULT '' COMMENT '检测方法',
  `standard_value` decimal(24,6) DEFAULT NULL COMMENT '标准值',
  `unit_measure_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '计量单位编号',
  `threshold_max` decimal(24,6) DEFAULT NULL COMMENT '误差上限',
  `threshold_min` decimal(24,6) DEFAULT NULL COMMENT '误差下限',
  `doc_url` varchar(500) DEFAULT '' COMMENT '说明图URL',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_template_indicator_template_id` (`template_id`),
  INDEX `idx_qc_template_indicator_indicator_id` (`indicator_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 质检方案-产品关联
DROP TABLE IF EXISTS `mes_qc_template_item`;
CREATE TABLE `mes_qc_template_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `template_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '质检方案编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料编号',
  `quantity_check` int(11) NOT NULL DEFAULT 0 COMMENT '最低检测数',
  `quantity_unqualified` int(11) NOT NULL DEFAULT 0 COMMENT '最大不合格数',
  `critical_rate` decimal(10,2) DEFAULT NULL COMMENT '最大致命缺陷率（%）',
  `major_rate` decimal(10,2) DEFAULT NULL COMMENT '最大严重缺陷率（%）',
  `minor_rate` decimal(10,2) DEFAULT NULL COMMENT '最大轻微缺陷率（%）',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_qc_template_item_template_id` (`template_id`),
  INDEX `idx_qc_template_item_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- ============================================================================
-- Module: tm (工具管理)
-- ============================================================================

-- MES 工具台账
DROP TABLE IF EXISTS `mes_tm_tool`;
CREATE TABLE `mes_tm_tool` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '工具编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '工具名称',
  `brand` varchar(255) DEFAULT '' COMMENT '品牌',
  `specification` varchar(255) DEFAULT '' COMMENT '型号规格',
  `tool_type_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工具类型编号',
  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
  `available_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '可用数量',
  `mainten_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '保养维护类型',
  `next_mainten_period` int(11) NOT NULL DEFAULT 0 COMMENT '下次保养周期',
  `next_mainten_date` datetime DEFAULT NULL COMMENT '下次保养日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_tm_tool_code` (`code`),
  INDEX `idx_tm_tool_tool_type_id` (`tool_type_id`),
  INDEX `idx_tm_tool_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 工具类型
DROP TABLE IF EXISTS `mes_tm_tool_type`;
CREATE TABLE `mes_tm_tool_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '类型编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '类型名称',
  `code_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否编码管理',
  `mainten_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '保养维护类型',
  `mainten_period` int(11) NOT NULL DEFAULT 0 COMMENT '保养周期',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_tm_tool_type_code` (`code`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- ============================================================================
-- Module: wm (仓库管理)
-- ============================================================================

-- MES 到货通知单
DROP TABLE IF EXISTS `mes_wm_arrival_notice`;
CREATE TABLE `mes_wm_arrival_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '通知单编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '通知单名称',
  `purchase_order_code` varchar(64) DEFAULT '' COMMENT '采购订单编号',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '供应商编号',
  `arrival_date` datetime DEFAULT NULL COMMENT '到货日期',
  `contact_name` varchar(100) DEFAULT '' COMMENT '联系人',
  `contact_telephone` varchar(64) DEFAULT '' COMMENT '联系电话',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_arrival_notice_code` (`code`),
  INDEX `idx_wm_arrival_notice_vendor_id` (`vendor_id`),
  INDEX `idx_wm_arrival_notice_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 到货通知单行
DROP TABLE IF EXISTS `mes_wm_arrival_notice_line`;
CREATE TABLE `mes_wm_arrival_notice_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `notice_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '到货通知单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `arrival_quantity` decimal(24,6) DEFAULT NULL COMMENT '到货数量',
  `qualified_quantity` decimal(24,6) DEFAULT NULL COMMENT '合格数量',
  `iqc_check_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否需要来料检验',
  `iqc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来料检验单编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_arrival_notice_line_notice_id` (`notice_id`),
  INDEX `idx_wm_arrival_notice_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 条码配置
DROP TABLE IF EXISTS `mes_wm_barcode_config`;
CREATE TABLE `mes_wm_barcode_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `format` tinyint(4) NOT NULL DEFAULT 0 COMMENT '条码格式',
  `biz_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '业务类型',
  `content_format` varchar(500) DEFAULT '' COMMENT '内容格式模板',
  `content_example` varchar(255) DEFAULT '' COMMENT '内容样例',
  `auto_generate_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否自动生成',
  `default_template` varchar(255) DEFAULT '' COMMENT '默认打印模板',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_barcode_config_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 条码清单
DROP TABLE IF EXISTS `mes_wm_barcode`;
CREATE TABLE `mes_wm_barcode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `config_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '条码配置编号',
  `format` tinyint(4) NOT NULL DEFAULT 0 COMMENT '条码格式',
  `biz_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '业务类型',
  `content` text COMMENT '条码内容',
  `biz_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '业务编号',
  `biz_code` varchar(64) DEFAULT '' COMMENT '业务编码',
  `biz_name` varchar(255) DEFAULT '' COMMENT '业务名称',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_barcode_config_id` (`config_id`),
  INDEX `idx_wm_barcode_biz_id` (`biz_id`),
  INDEX `idx_wm_barcode_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 批次管理
DROP TABLE IF EXISTS `mes_wm_batch`;
CREATE TABLE `mes_wm_batch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '批次ID',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '批次编码',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `produce_date` datetime DEFAULT NULL COMMENT '生产日期',
  `expire_date` datetime DEFAULT NULL COMMENT '有效期',
  `receipt_date` datetime DEFAULT NULL COMMENT '入库日期',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '供应商ID',
  `client_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '客户ID',
  `sales_order_code` varchar(64) DEFAULT '' COMMENT '销售订单编号',
  `purchase_order_code` varchar(64) DEFAULT '' COMMENT '采购订单编号',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单ID',
  `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产任务ID',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站ID',
  `tool_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工具ID',
  `mold_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '模具ID',
  `lot_number` varchar(64) DEFAULT '' COMMENT '生产批号',
  `quality_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '质量状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_batch_code` (`code`),
  INDEX `idx_wm_batch_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 物料消耗记录
DROP TABLE IF EXISTS `mes_wm_item_consume`;
CREATE TABLE `mes_wm_item_consume` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单编号',
  `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产任务编号',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站编号',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序编号',
  `feedback_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '报工记录编号',
  `consume_date` datetime DEFAULT NULL COMMENT '消耗日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_item_consume_work_order_id` (`work_order_id`),
  INDEX `idx_wm_item_consume_workstation_id` (`workstation_id`),
  INDEX `idx_wm_item_consume_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 物料消耗记录行
DROP TABLE IF EXISTS `mes_wm_item_consume_line`;
CREATE TABLE `mes_wm_item_consume_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `consume_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '消耗记录编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '消耗数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_item_consume_line_consume_id` (`consume_id`),
  INDEX `idx_wm_item_consume_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 物料消耗记录明细
DROP TABLE IF EXISTS `mes_wm_item_consume_detail`;
CREATE TABLE `mes_wm_item_consume_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `consume_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '消耗记录编号',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '消耗记录行编号',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存台账编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '消耗数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区编号',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_item_consume_detail_consume_id` (`consume_id`),
  INDEX `idx_wm_item_consume_detail_line_id` (`line_id`),
  INDEX `idx_wm_item_consume_detail_material_stock_id` (`material_stock_id`),
  INDEX `idx_wm_item_consume_detail_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 采购入库单
DROP TABLE IF EXISTS `mes_wm_item_receipt`;
CREATE TABLE `mes_wm_item_receipt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '入库单编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '入库单名称',
  `iqc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来料检验单编号',
  `notice_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '到货通知单编号',
  `purchase_order_code` varchar(64) DEFAULT '' COMMENT '采购订单号',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '供应商编号',
  `receipt_date` datetime DEFAULT NULL COMMENT '入库日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_item_receipt_code` (`code`),
  INDEX `idx_wm_item_receipt_vendor_id` (`vendor_id`),
  INDEX `idx_wm_item_receipt_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 采购入库单行
DROP TABLE IF EXISTS `mes_wm_item_receipt_line`;
CREATE TABLE `mes_wm_item_receipt_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `receipt_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '入库单编号',
  `arrival_notice_line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '到货通知单行编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `received_quantity` decimal(24,6) DEFAULT NULL COMMENT '入库数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次编码',
  `production_date` datetime DEFAULT NULL COMMENT '生产日期',
  `expire_date` datetime DEFAULT NULL COMMENT '有效期',
  `lot_number` varchar(64) DEFAULT '' COMMENT '生产批号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_item_receipt_line_receipt_id` (`receipt_id`),
  INDEX `idx_wm_item_receipt_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 采购入库明细
DROP TABLE IF EXISTS `mes_wm_item_receipt_detail`;
CREATE TABLE `mes_wm_item_receipt_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '入库单行编号',
  `receipt_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '入库单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '上架数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区编号',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_item_receipt_detail_receipt_id` (`receipt_id`),
  INDEX `idx_wm_item_receipt_detail_line_id` (`line_id`),
  INDEX `idx_wm_item_receipt_detail_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 库存台账（仓库现有量）
DROP TABLE IF EXISTS `mes_wm_material_stock`;
CREATE TABLE `mes_wm_material_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `item_type_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料分类编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区编号',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位编号',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '供应商编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '在库数量',
  `receipt_time` datetime DEFAULT NULL COMMENT '入库时间',
  `frozen` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否冻结',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_material_stock_item_id` (`item_id`),
  INDEX `idx_wm_material_stock_warehouse_id` (`warehouse_id`),
  INDEX `idx_wm_material_stock_batch_id` (`batch_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 杂项出库单
DROP TABLE IF EXISTS `mes_wm_misc_issue`;
CREATE TABLE `mes_wm_misc_issue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '出库单编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '出库单名称',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '杂项类型',
  `source_doc_type` varchar(64) DEFAULT '' COMMENT '来源单据类型',
  `source_doc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据ID',
  `source_doc_code` varchar(64) DEFAULT '' COMMENT '来源单据编号',
  `issue_date` datetime DEFAULT NULL COMMENT '出库日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_misc_issue_code` (`code`),
  INDEX `idx_wm_misc_issue_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 杂项出库单行
DROP TABLE IF EXISTS `mes_wm_misc_issue_line`;
CREATE TABLE `mes_wm_misc_issue_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `issue_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '出库单编号',
  `source_doc_line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据行ID',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存记录ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '出库数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区编号',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_misc_issue_line_issue_id` (`issue_id`),
  INDEX `idx_wm_misc_issue_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 杂项出库明细
DROP TABLE IF EXISTS `mes_wm_misc_issue_detail`;
CREATE TABLE `mes_wm_misc_issue_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `issue_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '出库单ID',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '行ID',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存记录ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '出库数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库ID',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区ID',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位ID',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_misc_issue_detail_issue_id` (`issue_id`),
  INDEX `idx_wm_misc_issue_detail_line_id` (`line_id`),
  INDEX `idx_wm_misc_issue_detail_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 杂项入库单
DROP TABLE IF EXISTS `mes_wm_misc_receipt`;
CREATE TABLE `mes_wm_misc_receipt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '入库单编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '入库单名称',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '杂项类型',
  `source_doc_type` varchar(64) DEFAULT '' COMMENT '来源单据类型',
  `source_doc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源单据ID',
  `source_doc_code` varchar(64) DEFAULT '' COMMENT '来源单据编码',
  `receipt_date` datetime DEFAULT NULL COMMENT '入库日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_misc_receipt_code` (`code`),
  INDEX `idx_wm_misc_receipt_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 杂项入库单行
DROP TABLE IF EXISTS `mes_wm_misc_receipt_line`;
CREATE TABLE `mes_wm_misc_receipt_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `receipt_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '入库单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '入库数量',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区编号',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_misc_receipt_line_receipt_id` (`receipt_id`),
  INDEX `idx_wm_misc_receipt_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 杂项入库明细
DROP TABLE IF EXISTS `mes_wm_misc_receipt_detail`;
CREATE TABLE `mes_wm_misc_receipt_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `receipt_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '入库单ID',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '行ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '入库数量',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库ID',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区ID',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位ID',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_misc_receipt_detail_receipt_id` (`receipt_id`),
  INDEX `idx_wm_misc_receipt_detail_line_id` (`line_id`),
  INDEX `idx_wm_misc_receipt_detail_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 外协发料单
DROP TABLE IF EXISTS `mes_wm_outsource_issue`;
CREATE TABLE `mes_wm_outsource_issue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '发料单ID',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '发料单编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '发料单名称',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '供应商ID',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单ID',
  `issue_date` datetime DEFAULT NULL COMMENT '发料日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '单据状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_outsource_issue_code` (`code`),
  INDEX `idx_wm_outsource_issue_vendor_id` (`vendor_id`),
  INDEX `idx_wm_outsource_issue_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 外协发料单行
DROP TABLE IF EXISTS `mes_wm_outsource_issue_line`;
CREATE TABLE `mes_wm_outsource_issue_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '行ID',
  `issue_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '发料单ID',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '发料数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_outsource_issue_line_issue_id` (`issue_id`),
  INDEX `idx_wm_outsource_issue_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 外协发料明细
DROP TABLE IF EXISTS `mes_wm_outsource_issue_detail`;
CREATE TABLE `mes_wm_outsource_issue_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细ID',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '行ID',
  `issue_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '发料单ID',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库ID',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位ID',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区ID',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_outsource_issue_det_issue_id` (`issue_id`),
  INDEX `idx_wm_outsource_issue_det_line_id` (`line_id`),
  INDEX `idx_wm_outsource_issue_det_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 外协入库单
DROP TABLE IF EXISTS `mes_wm_outsource_receipt`;
CREATE TABLE `mes_wm_outsource_receipt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '入库单编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '入库单名称',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '外协工单编号',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '供应商编号',
  `receipt_date` datetime DEFAULT NULL COMMENT '入库日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_outsource_receipt_code` (`code`),
  INDEX `idx_wm_outsource_receipt_vendor_id` (`vendor_id`),
  INDEX `idx_wm_outsource_receipt_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 外协入库单行
DROP TABLE IF EXISTS `mes_wm_outsource_receipt_line`;
CREATE TABLE `mes_wm_outsource_receipt_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `receipt_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '入库单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '入库数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `production_date` datetime DEFAULT NULL COMMENT '生产日期',
  `expire_date` datetime DEFAULT NULL COMMENT '有效期',
  `lot_number` varchar(64) DEFAULT '' COMMENT '生产批号',
  `iqc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来料检验单编号',
  `iqc_check_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否需要质检',
  `quality_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '质量状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_outsource_receipt_line_receipt_id` (`receipt_id`),
  INDEX `idx_wm_outsource_receipt_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 外协入库明细
DROP TABLE IF EXISTS `mes_wm_outsource_receipt_detail`;
CREATE TABLE `mes_wm_outsource_receipt_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '入库单行编号',
  `receipt_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '入库单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '上架数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区编号',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_outsource_receipt_det_receipt_id` (`receipt_id`),
  INDEX `idx_wm_outsource_receipt_det_line_id` (`line_id`),
  INDEX `idx_wm_outsource_receipt_det_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 装箱单
DROP TABLE IF EXISTS `mes_wm_package`;
CREATE TABLE `mes_wm_package` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '装箱单编号',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父箱ID',
  `package_date` datetime DEFAULT NULL COMMENT '装箱日期',
  `sales_order_code` varchar(64) DEFAULT '' COMMENT '销售订单编号',
  `invoice_code` varchar(64) DEFAULT '' COMMENT '发票编号',
  `client_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '客户ID',
  `length` decimal(24,6) DEFAULT NULL COMMENT '箱长度',
  `width` decimal(24,6) DEFAULT NULL COMMENT '箱宽度',
  `height` decimal(24,6) DEFAULT NULL COMMENT '箱高度',
  `size_unit_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '尺寸单位ID',
  `net_weight` decimal(24,6) DEFAULT NULL COMMENT '净重',
  `gross_weight` decimal(24,6) DEFAULT NULL COMMENT '毛重',
  `weight_unit_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '重量单位ID',
  `inspector_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检查员用户ID',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_package_code` (`code`),
  INDEX `idx_wm_package_client_id` (`client_id`),
  INDEX `idx_wm_package_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 装箱明细
DROP TABLE IF EXISTS `mes_wm_package_line`;
CREATE TABLE `mes_wm_package_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `package_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '装箱单ID',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存记录ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '装箱数量',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单ID',
  `expire_date` datetime DEFAULT NULL COMMENT '有效期',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_package_line_package_id` (`package_id`),
  INDEX `idx_wm_package_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 领料出库单
DROP TABLE IF EXISTS `mes_wm_product_issue`;
CREATE TABLE `mes_wm_product_issue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '领料单编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '领料单名称',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站ID',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单ID',
  `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产任务ID',
  `issue_date` datetime DEFAULT NULL COMMENT '领料日期',
  `required_time` datetime DEFAULT NULL COMMENT '需求时间',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_issue_code` (`code`),
  INDEX `idx_wm_product_issue_workstation_id` (`workstation_id`),
  INDEX `idx_wm_product_issue_work_order_id` (`work_order_id`),
  INDEX `idx_wm_product_issue_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 领料出库单行
DROP TABLE IF EXISTS `mes_wm_product_issue_line`;
CREATE TABLE `mes_wm_product_issue_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `issue_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '领料单ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '领料数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_issue_line_issue_id` (`issue_id`),
  INDEX `idx_wm_product_issue_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 领料出库明细
DROP TABLE IF EXISTS `mes_wm_product_issue_detail`;
CREATE TABLE `mes_wm_product_issue_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `issue_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '领料单ID',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '行ID',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存记录ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '领料数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库ID',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区ID',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位ID',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_issue_det_issue_id` (`issue_id`),
  INDEX `idx_wm_product_issue_det_line_id` (`line_id`),
  INDEX `idx_wm_product_issue_det_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产入库单
DROP TABLE IF EXISTS `mes_wm_product_produce`;
CREATE TABLE `mes_wm_product_produce` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单ID',
  `feedback_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '报工记录ID',
  `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产任务ID',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站ID',
  `process_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工序ID',
  `produce_date` datetime DEFAULT NULL COMMENT '生产日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_produce_work_order_id` (`work_order_id`),
  INDEX `idx_wm_product_produce_workstation_id` (`workstation_id`),
  INDEX `idx_wm_product_produce_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产入库单行
DROP TABLE IF EXISTS `mes_wm_product_produce_line`;
CREATE TABLE `mes_wm_product_produce_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `produce_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '入库单ID',
  `feedback_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '报工记录ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '入库数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `expire_date` datetime DEFAULT NULL COMMENT '过期日期',
  `lot_number` varchar(64) DEFAULT '' COMMENT '生产批号',
  `quality_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '质量状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_produce_line_produce_id` (`produce_id`),
  INDEX `idx_wm_product_produce_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产入库明细
DROP TABLE IF EXISTS `mes_wm_product_produce_detail`;
CREATE TABLE `mes_wm_product_produce_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `produce_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '入库单ID',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '行ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '入库数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库ID',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区ID',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位ID',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_produce_det_produce_id` (`produce_id`),
  INDEX `idx_wm_product_produce_det_line_id` (`line_id`),
  INDEX `idx_wm_product_produce_det_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 产品收货（入库）单
DROP TABLE IF EXISTS `mes_wm_product_receipt`;
CREATE TABLE `mes_wm_product_receipt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '收货单编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '收货单名称',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品物料编号',
  `receipt_date` datetime DEFAULT NULL COMMENT '收货日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_receipt_code` (`code`),
  INDEX `idx_wm_product_receipt_item_id` (`item_id`),
  INDEX `idx_wm_product_receipt_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 产品收货（入库）单行
DROP TABLE IF EXISTS `mes_wm_product_receipt_line`;
CREATE TABLE `mes_wm_product_receipt_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `receipt_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '收货单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存物资记录编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '收货数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_receipt_line_receipt_id` (`receipt_id`),
  INDEX `idx_wm_product_receipt_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 产品收货（入库）单明细
DROP TABLE IF EXISTS `mes_wm_product_receipt_detail`;
CREATE TABLE `mes_wm_product_receipt_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '收货单行编号',
  `receipt_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '收货单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '上架数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区编号',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_receipt_det_receipt_id` (`receipt_id`),
  INDEX `idx_wm_product_receipt_det_line_id` (`line_id`),
  INDEX `idx_wm_product_receipt_det_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 销售出库单
DROP TABLE IF EXISTS `mes_wm_product_sales`;
CREATE TABLE `mes_wm_product_sales` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '出库单号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '出库单名称',
  `client_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '客户ID',
  `sales_order_code` varchar(64) DEFAULT '' COMMENT '销售订单号',
  `notice_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '发货通知单ID',
  `sales_date` datetime DEFAULT NULL COMMENT '出库日期',
  `contact_name` varchar(100) DEFAULT '' COMMENT '联系人',
  `contact_telephone` varchar(64) DEFAULT '' COMMENT '联系电话',
  `contact_address` varchar(500) DEFAULT '' COMMENT '收货地址',
  `carrier` varchar(255) DEFAULT '' COMMENT '承运商',
  `shipping_number` varchar(64) DEFAULT '' COMMENT '运输单号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_sales_code` (`code`),
  INDEX `idx_wm_product_sales_client_id` (`client_id`),
  INDEX `idx_wm_product_sales_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 销售出库单行
DROP TABLE IF EXISTS `mes_wm_product_sales_line`;
CREATE TABLE `mes_wm_product_sales_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sales_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '出库单ID',
  `notice_line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '发货通知单行ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '出库数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存记录ID',
  `oqc_check_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否出厂检验',
  `oqc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '出厂检验单ID',
  `quality_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '质量状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_sales_line_sales_id` (`sales_id`),
  INDEX `idx_wm_product_sales_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 销售出库明细
DROP TABLE IF EXISTS `mes_wm_product_sales_detail`;
CREATE TABLE `mes_wm_product_sales_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '出库单行ID',
  `sales_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '出库单ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '拣货数量',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存记录ID',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库ID',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区ID',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位ID',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_product_sales_det_sales_id` (`sales_id`),
  INDEX `idx_wm_product_sales_det_line_id` (`line_id`),
  INDEX `idx_wm_product_sales_det_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产退料单
DROP TABLE IF EXISTS `mes_wm_return_issue`;
CREATE TABLE `mes_wm_return_issue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '退料单编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '退料单名称',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单ID',
  `workstation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '工作站ID',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '退料类型',
  `return_date` datetime DEFAULT NULL COMMENT '退料日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_return_issue_code` (`code`),
  INDEX `idx_wm_return_issue_work_order_id` (`work_order_id`),
  INDEX `idx_wm_return_issue_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产退料单行
DROP TABLE IF EXISTS `mes_wm_return_issue_line`;
CREATE TABLE `mes_wm_return_issue_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `issue_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '退料单ID',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存记录ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '退料数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次编码',
  `rqc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '退货检验单ID',
  `rqc_check_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否需要质检',
  `quality_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '质量状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_return_issue_line_issue_id` (`issue_id`),
  INDEX `idx_wm_return_issue_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 生产退料明细
DROP TABLE IF EXISTS `mes_wm_return_issue_detail`;
CREATE TABLE `mes_wm_return_issue_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `issue_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '退料单ID',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '行ID',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存记录ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '退料数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库ID',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区ID',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位ID',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_return_issue_det_issue_id` (`issue_id`),
  INDEX `idx_wm_return_issue_det_line_id` (`line_id`),
  INDEX `idx_wm_return_issue_det_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 销售退货单
DROP TABLE IF EXISTS `mes_wm_return_sales`;
CREATE TABLE `mes_wm_return_sales` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '退货单编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '退货单名称',
  `sales_order_code` varchar(64) DEFAULT '' COMMENT '销售订单编号',
  `client_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '客户ID',
  `return_date` datetime DEFAULT NULL COMMENT '退货日期',
  `return_reason` varchar(500) DEFAULT '' COMMENT '退货原因',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_return_sales_code` (`code`),
  INDEX `idx_wm_return_sales_client_id` (`client_id`),
  INDEX `idx_wm_return_sales_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 销售退货单行
DROP TABLE IF EXISTS `mes_wm_return_sales_line`;
CREATE TABLE `mes_wm_return_sales_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `return_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '退货单ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '退货数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `rqc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '退货检验单ID',
  `rqc_check_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否需要质检',
  `quality_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '质量状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_return_sales_line_return_id` (`return_id`),
  INDEX `idx_wm_return_sales_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 销售退货明细
DROP TABLE IF EXISTS `mes_wm_return_sales_detail`;
CREATE TABLE `mes_wm_return_sales_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `return_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '退货单ID',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '行ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库ID',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区ID',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位ID',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_return_sales_det_return_id` (`return_id`),
  INDEX `idx_wm_return_sales_det_line_id` (`line_id`),
  INDEX `idx_wm_return_sales_det_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 供应商退货单
DROP TABLE IF EXISTS `mes_wm_return_vendor`;
CREATE TABLE `mes_wm_return_vendor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '退货单编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '退货单名称',
  `purchase_order_code` varchar(64) DEFAULT '' COMMENT '采购订单编号',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '供应商ID',
  `return_date` datetime DEFAULT NULL COMMENT '退货日期',
  `return_reason` varchar(500) DEFAULT '' COMMENT '退货原因',
  `transport_code` varchar(64) DEFAULT '' COMMENT '物流单号',
  `transport_telephone` varchar(64) DEFAULT '' COMMENT '物流联系电话',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_return_vendor_code` (`code`),
  INDEX `idx_wm_return_vendor_vendor_id` (`vendor_id`),
  INDEX `idx_wm_return_vendor_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 供应商退货单行
DROP TABLE IF EXISTS `mes_wm_return_vendor_line`;
CREATE TABLE `mes_wm_return_vendor_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `return_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '退货单ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '退货数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_return_vendor_line_return_id` (`return_id`),
  INDEX `idx_wm_return_vendor_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 供应商退货明细
DROP TABLE IF EXISTS `mes_wm_return_vendor_detail`;
CREATE TABLE `mes_wm_return_vendor_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `return_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '退货单ID',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '行ID',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存记录ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '退货数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库ID',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区ID',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位ID',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_return_vendor_det_return_id` (`return_id`),
  INDEX `idx_wm_return_vendor_det_line_id` (`line_id`),
  INDEX `idx_wm_return_vendor_det_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 发货通知单
DROP TABLE IF EXISTS `mes_wm_sales_notice`;
CREATE TABLE `mes_wm_sales_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '通知单编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '通知单名称',
  `sales_order_code` varchar(64) DEFAULT '' COMMENT '销售订单编号',
  `client_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '客户编号',
  `sales_date` datetime DEFAULT NULL COMMENT '发货日期',
  `recipient_name` varchar(100) DEFAULT '' COMMENT '收货人',
  `recipient_telephone` varchar(64) DEFAULT '' COMMENT '联系方式',
  `recipient_address` varchar(500) DEFAULT '' COMMENT '收货地址',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_sales_notice_code` (`code`),
  INDEX `idx_wm_sales_notice_client_id` (`client_id`),
  INDEX `idx_wm_sales_notice_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 发货通知单行
DROP TABLE IF EXISTS `mes_wm_sales_notice_line`;
CREATE TABLE `mes_wm_sales_notice_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `notice_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '发货通知单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '发货数量',
  `oqc_check_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否检验',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_sales_notice_line_notice_id` (`notice_id`),
  INDEX `idx_wm_sales_notice_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES SN码
DROP TABLE IF EXISTS `mes_wm_sn`;
CREATE TABLE `mes_wm_sn` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `uuid` varchar(64) NOT NULL DEFAULT '' COMMENT '批次UUID',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT 'SN码',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `work_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产工单编号',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_sn_code` (`code`),
  INDEX `idx_wm_sn_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 盘点方案
DROP TABLE IF EXISTS `mes_wm_stock_taking_plan`;
CREATE TABLE `mes_wm_stock_taking_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '方案编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '方案名称',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '盘点类型',
  `start_time` datetime DEFAULT NULL COMMENT '计划开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '计划结束时间',
  `blind_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否盲盘',
  `frozen` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否冻结库存',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_stock_taking_plan_code` (`code`),
  INDEX `idx_wm_stock_taking_plan_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 盘点方案参数
DROP TABLE IF EXISTS `mes_wm_stock_taking_plan_param`;
CREATE TABLE `mes_wm_stock_taking_plan_param` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '盘点方案编号',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '参数值类型',
  `value_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '参数值编号',
  `value_code` varchar(64) DEFAULT '' COMMENT '参数值编码',
  `value_name` varchar(255) DEFAULT '' COMMENT '参数值名称',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_stock_taking_plan_param_plan_id` (`plan_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 盘点任务
DROP TABLE IF EXISTS `mes_wm_stock_taking_task`;
CREATE TABLE `mes_wm_stock_taking_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '任务编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '任务名称',
  `taking_date` datetime DEFAULT NULL COMMENT '盘点日期',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '盘点类型',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '盘点人编号',
  `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '盘点计划编号',
  `blind_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否盲盘',
  `frozen` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否冻结库存',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '任务状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_stock_taking_task_code` (`code`),
  INDEX `idx_wm_stock_taking_task_user_id` (`user_id`),
  INDEX `idx_wm_stock_taking_task_plan_id` (`plan_id`),
  INDEX `idx_wm_stock_taking_task_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 盘点任务行
DROP TABLE IF EXISTS `mes_wm_stock_taking_task_line`;
CREATE TABLE `mes_wm_stock_taking_task_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '盘点任务编号',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次编码',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '在库数量',
  `taking_quantity` decimal(24,6) DEFAULT NULL COMMENT '盘点数量',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位编号',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区编号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '盘点状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_stock_taking_task_line_task_id` (`task_id`),
  INDEX `idx_wm_stock_taking_task_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 盘点结果
DROP TABLE IF EXISTS `mes_wm_stock_taking_task_result`;
CREATE TABLE `mes_wm_stock_taking_task_result` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '盘点任务编号',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '盘点任务行编号',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次编码',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位编号',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '在库数量',
  `taking_quantity` decimal(24,6) DEFAULT NULL COMMENT '盘点数量',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_stock_taking_task_res_task_id` (`task_id`),
  INDEX `idx_wm_stock_taking_task_res_line_id` (`line_id`),
  INDEX `idx_wm_stock_taking_task_res_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 库存事务流水
DROP TABLE IF EXISTS `mes_wm_transaction`;
CREATE TABLE `mes_wm_transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '事务类型',
  `biz_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '业务类型',
  `biz_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源业务主单ID',
  `biz_code` varchar(64) DEFAULT '' COMMENT '来源业务单号',
  `biz_line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源业务行ID',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存记录ID',
  `related_transaction_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联的事务ID',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料ID',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '本次变动数量（正数=入库，负数=出库）',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次ID',
  `batch_code` varchar(64) DEFAULT '' COMMENT '批次号',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库ID',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区ID',
  `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库位ID',
  `transaction_time` datetime DEFAULT NULL COMMENT '事务发生时间',
  `erp_time` datetime DEFAULT NULL COMMENT 'ERP账期',
  `receipt_time` datetime DEFAULT NULL COMMENT '入库时间',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_transaction_type` (`type`),
  INDEX `idx_wm_transaction_biz_id` (`biz_id`),
  INDEX `idx_wm_transaction_item_id` (`item_id`),
  INDEX `idx_wm_transaction_warehouse_id` (`warehouse_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 转移单
DROP TABLE IF EXISTS `mes_wm_transfer`;
CREATE TABLE `mes_wm_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '转移单编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '转移单名称',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '转移单类型',
  `delivery_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否配送',
  `recipient_name` varchar(100) DEFAULT '' COMMENT '收货人',
  `recipient_telephone` varchar(64) DEFAULT '' COMMENT '联系方式',
  `destination_address` varchar(500) DEFAULT '' COMMENT '目的地',
  `carrier` varchar(255) DEFAULT '' COMMENT '承运商',
  `shipping_number` varchar(64) DEFAULT '' COMMENT '运输单号',
  `confirm_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否已确认',
  `transfer_date` datetime DEFAULT NULL COMMENT '转移日期',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_transfer_code` (`code`),
  INDEX `idx_wm_transfer_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 转移单行
DROP TABLE IF EXISTS `mes_wm_transfer_line`;
CREATE TABLE `mes_wm_transfer_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `transfer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '转移单编号',
  `material_stock_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存记录编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '转移数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `from_warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '移出仓库编号',
  `from_location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '移出库区编号',
  `from_area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '移出库位编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_transfer_line_transfer_id` (`transfer_id`),
  INDEX `idx_wm_transfer_line_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 调拨明细
DROP TABLE IF EXISTS `mes_wm_transfer_detail`;
CREATE TABLE `mes_wm_transfer_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `line_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '转移单行编号',
  `transfer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '转移单编号',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物料编号',
  `quantity` decimal(24,6) DEFAULT NULL COMMENT '上架数量',
  `batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批次编号',
  `to_warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '移入仓库编号',
  `to_location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '移入库区编号',
  `to_area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '移入库位编号',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_transfer_detail_transfer_id` (`transfer_id`),
  INDEX `idx_wm_transfer_detail_line_id` (`line_id`),
  INDEX `idx_wm_transfer_detail_item_id` (`item_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 仓库
DROP TABLE IF EXISTS `mes_wm_warehouse`;
CREATE TABLE `mes_wm_warehouse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '仓库编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '仓库名称',
  `address` varchar(500) DEFAULT '' COMMENT '仓库地址',
  `area` decimal(24,6) DEFAULT NULL COMMENT '面积',
  `charge_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '负责人用户编号',
  `frozen` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否冻结',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_warehouse_code` (`code`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 库区
DROP TABLE IF EXISTS `mes_wm_warehouse_location`;
CREATE TABLE `mes_wm_warehouse_location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '库区编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '库区名称',
  `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
  `area` decimal(24,6) DEFAULT NULL COMMENT '面积',
  `frozen` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否冻结',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_warehouse_location_code` (`code`),
  INDEX `idx_wm_warehouse_location_warehouse_id` (`warehouse_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- MES 库位
DROP TABLE IF EXISTS `mes_wm_warehouse_area`;
CREATE TABLE `mes_wm_warehouse_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT '库位编码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '库位名称',
  `location_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库区编号',
  `area` decimal(24,6) DEFAULT NULL COMMENT '面积',
  `max_load` decimal(24,6) DEFAULT NULL COMMENT '最大载重',
  `position_x` int(11) NOT NULL DEFAULT 0 COMMENT '位置X',
  `position_y` int(11) NOT NULL DEFAULT 0 COMMENT '位置Y',
  `position_z` int(11) NOT NULL DEFAULT 0 COMMENT '位置Z',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `frozen` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否冻结',
  `allow_item_mixing` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否允许物料混放',
  `allow_batch_mixing` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否允许批次混放',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  INDEX `idx_wm_warehouse_area_code` (`code`),
  INDEX `idx_wm_warehouse_area_location_id` (`location_id`),
  INDEX `idx_wm_warehouse_area_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;


