-- ============================================================================
-- Module: GAP (中药材生产质量管理规范)
-- Description: 基于《中药材GAP检查指南》(2023年6月) 的完整业务表结构
-- ============================================================================
-- 说明:
--   1. 复用 yudao 已有模块:
--      - system_user / system_dept / system_post / system_role → 人员管理
--      - system_dict_data / system_dict_type → 数据字典
--      - infra_file → 文件附件
--      - infra_api_access_log / infra_api_error_log → API日志
--      - bpm_process_instance / bpm_task → 审批流程
--      - wms_warehouse / wms_receipt_order / wms_shipment_order → 仓储管理
--      - mes_dv_machinery / mes_dv_check_record → 设备台账
--   2. 数据流: 基地→地块→种植计划→农事记录→采收→加工→入库→检验→放行→追溯
--   3. 审计字段: creator, create_time, updater, update_time, deleted, tenant_id
-- ============================================================================

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ============================================================================
-- Module 1: 基地档案管理 (第三章 设施与设备)
-- ============================================================================

-- 基地信息主表
DROP TABLE IF EXISTS `gap_base_info`;
CREATE TABLE `gap_base_info` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '基地编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '基地编码',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '基地名称',
    `province` varchar(64) DEFAULT '' COMMENT '省份',
    `city` varchar(64) DEFAULT '' COMMENT '城市',
    `district` varchar(64) DEFAULT '' COMMENT '区县',
    `address` varchar(500) DEFAULT '' COMMENT '详细地址',
    `longitude` decimal(12,8) DEFAULT NULL COMMENT '经度',
    `latitude` decimal(12,8) DEFAULT NULL COMMENT '纬度',
    `area` decimal(16,4) DEFAULT NULL COMMENT '总面积(亩)',
    `planting_area` decimal(16,4) DEFAULT NULL COMMENT '种植面积(亩)',
    `altitude` decimal(10,2) DEFAULT NULL COMMENT '海拔(m)',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0正常 1停用)',
    `env_assess_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '环境评估状态',
    `env_assess_date` date DEFAULT NULL COMMENT '环境评估日期',
    `env_assess_report_url` varchar(500) DEFAULT '' COMMENT '环境评估报告附件',
    `responsible_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地负责人',
    `manager_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '生产负责人',
    `quality_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '质量负责人',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_code` (`code`),
    KEY `idx_name` (`name`),
    KEY `idx_status` (`status`),
    KEY `idx_responsible_user_id` (`responsible_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-基地信息';

-- 基地环境评估
DROP TABLE IF EXISTS `gap_base_environment`;
CREATE TABLE `gap_base_environment` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `assess_date` date DEFAULT NULL COMMENT '评估日期',
    `assess_org` varchar(255) DEFAULT '' COMMENT '评估机构',
    `assess_person` varchar(100) DEFAULT '' COMMENT '评估人',
    `surroundings` text COMMENT '周边环境描述',
    `pollution_source` varchar(500) DEFAULT '' COMMENT '污染源情况',
    `air_quality` varchar(100) DEFAULT '' COMMENT '空气质量',
    `noise_level` varchar(100) DEFAULT '' COMMENT '噪声水平',
    `assess_result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '评估结果(0合格 1不合格)',
    `report_url` varchar(500) DEFAULT '' COMMENT '评估报告附件',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_assess_date` (`assess_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-基地环境评估';

-- 土壤检测记录
DROP TABLE IF EXISTS `gap_base_soil`;
CREATE TABLE `gap_base_soil` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `plot_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '地块编号',
    `sample_no` varchar(64) DEFAULT '' COMMENT '样品编号',
    `sample_date` date DEFAULT NULL COMMENT '采样日期',
    `sample_location` varchar(255) DEFAULT '' COMMENT '采样点位',
    `soil_type` varchar(64) DEFAULT '' COMMENT '土壤类型',
    `ph_value` decimal(5,2) DEFAULT NULL COMMENT 'pH值',
    `organic_matter` decimal(8,3) DEFAULT NULL COMMENT '有机质含量(g/kg)',
    `nitrogen` decimal(8,3) DEFAULT NULL COMMENT '全氮(g/kg)',
    `phosphorus` decimal(8,3) DEFAULT NULL COMMENT '有效磷(mg/kg)',
    `potassium` decimal(8,3) DEFAULT NULL COMMENT '速效钾(mg/kg)',
    `cadmium` decimal(10,6) DEFAULT NULL COMMENT '镉(Cd) mg/kg',
    `lead` decimal(10,6) DEFAULT NULL COMMENT '铅(Pb) mg/kg',
    `arsenic` decimal(10,6) DEFAULT NULL COMMENT '砷(As) mg/kg',
    `mercury` decimal(10,6) DEFAULT NULL COMMENT '汞(Hg) mg/kg',
    `chromium` decimal(10,6) DEFAULT NULL COMMENT '铬(Cr) mg/kg',
    `report_url` varchar(500) DEFAULT '' COMMENT '检测报告附件',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0正常 1不合格)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_plot_id` (`plot_id`),
    KEY `idx_sample_date` (`sample_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-土壤检测';

-- 水源检测记录
DROP TABLE IF EXISTS `gap_base_water`;
CREATE TABLE `gap_base_water` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `water_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '水源类型(0灌溉水 1加工用水)',
    `sample_no` varchar(64) DEFAULT '' COMMENT '样品编号',
    `sample_date` date DEFAULT NULL COMMENT '采样日期',
    `sample_location` varchar(255) DEFAULT '' COMMENT '采样点位',
    `ph_value` decimal(5,2) DEFAULT NULL COMMENT 'pH值',
    `cod` decimal(8,3) DEFAULT NULL COMMENT '化学需氧量(mg/L)',
    `bod5` decimal(8,3) DEFAULT NULL COMMENT '生化需氧量(mg/L)',
    `ammonia_nitrogen` decimal(8,3) DEFAULT NULL COMMENT '氨氮(mg/L)',
    `total_nitrogen` decimal(8,3) DEFAULT NULL COMMENT '总氮(mg/L)',
    `total_phosphorus` decimal(8,3) DEFAULT NULL COMMENT '总磷(mg/L)',
    `cadmium` decimal(10,6) DEFAULT NULL COMMENT '镉(mg/L)',
    `lead` decimal(10,6) DEFAULT NULL COMMENT '铅(mg/L)',
    `arsenic` decimal(10,6) DEFAULT NULL COMMENT '砷(mg/L)',
    `mercury` decimal(10,6) DEFAULT NULL COMMENT '汞(mg/L)',
    `chromium` decimal(10,6) DEFAULT NULL COMMENT '铬(mg/L)',
    `report_url` varchar(500) DEFAULT '' COMMENT '检测报告附件',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0合格 1不合格)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE=utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE=utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_water_type` (`water_type`),
    KEY `idx_sample_date` (`sample_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-水源检测';

-- 气象数据记录
DROP TABLE IF EXISTS `gap_base_weather`;
CREATE TABLE `gap_base_weather` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `record_date` date NOT NULL COMMENT '记录日期',
    `max_temp` decimal(5,1) DEFAULT NULL COMMENT '最高温度(°C)',
    `min_temp` decimal(5,1) DEFAULT NULL COMMENT '最低温度(°C)',
    `avg_temp` decimal(5,1) DEFAULT NULL COMMENT '平均气温(°C)',
    `precipitation` decimal(8,1) DEFAULT NULL COMMENT '降水量(mm)',
    `humidity` decimal(5,1) DEFAULT NULL COMMENT '相对湿度(%)',
    `sunshine_hours` decimal(5,1) DEFAULT NULL COMMENT '日照时数(h)',
    `wind_speed` decimal(5,1) DEFAULT NULL COMMENT '风速(m/s)',
    `wind_direction` varchar(20) DEFAULT '' COMMENT '风向',
    `weather_desc` varchar(100) DEFAULT '' COMMENT '天气描述',
    `frost_free_days` int(11) DEFAULT NULL COMMENT '无霜期(天)',
    `data_source` tinyint(4) NOT NULL DEFAULT 0 COMMENT '数据来源(0手动录入 1自动采集)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_record_date` (`record_date`),
    KEY `idx_base_date` (`base_id`, `record_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-气象数据';

-- 基地设施设备
DROP TABLE IF EXISTS `gap_base_facility`;
CREATE TABLE `gap_base_facility` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `facility_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '设施类型(0道路 1排灌 2防护林 3隔离带 4仓库 5废弃物处理)',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '设施名称',
    `code` varchar(64) DEFAULT '' COMMENT '设施编码',
    `specification` varchar(255) DEFAULT '' COMMENT '规格参数',
    `quantity` int(11) DEFAULT NULL COMMENT '数量',
    `unit` varchar(32) DEFAULT '' COMMENT '单位',
    `build_date` date DEFAULT NULL COMMENT '建设日期',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0正常 1维修 2报废)',
    `location_desc` varchar(500) DEFAULT '' COMMENT '位置描述',
    `photo_url` varchar(500) DEFAULT '' COMMENT '照片附件',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_facility_type` (`facility_type`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-基地设施设备';

-- 地块管理
DROP TABLE IF EXISTS `gap_plot`;
CREATE TABLE `gap_plot` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '地块编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '地块编码',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '地块名称',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '所属基地编号',
    `area` decimal(16,4) DEFAULT NULL COMMENT '面积(亩)',
    `soil_type` varchar(64) DEFAULT '' COMMENT '土壤类型',
    `soil_ph` decimal(5,2) DEFAULT NULL COMMENT '土壤pH',
    `elevation` decimal(10,2) DEFAULT NULL COMMENT '海拔(m)',
    `slope` decimal(5,2) DEFAULT NULL COMMENT '坡度(°)',
    `exposure` varchar(64) DEFAULT '' COMMENT '坡向',
    `previous_crop` varchar(100) DEFAULT '' COMMENT '前茬作物',
    `current_variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '当前种植品种',
    `current_batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '当前种植批次',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0空闲 1种植中 2休养)',
    `gis_boundary` text COMMENT 'GIS边界坐标',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_code` (`code`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_status` (`status`),
    KEY `idx_current_variety_id` (`current_variety_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-地块管理';

-- 地块种植历史记录
DROP TABLE IF EXISTS `gap_plot_planting`;
CREATE TABLE `gap_plot_planting` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `plot_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '地块编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '种植批次号',
    `planting_date` date DEFAULT NULL COMMENT '种植日期',
    `harvest_date` date DEFAULT NULL COMMENT '采收日期',
    `area` decimal(16,4) DEFAULT NULL COMMENT '种植面积(亩)',
    `planting_density` varchar(100) DEFAULT '' COMMENT '种植密度',
    `planting_method` varchar(100) DEFAULT '' COMMENT '种植方式',
    `yield_estimate` decimal(16,4) DEFAULT NULL COMMENT '预计产量(kg)',
    `yield_actual` decimal(16,4) DEFAULT NULL COMMENT '实际产量(kg)',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0种植中 1已采收 2已完成)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_plot_id` (`plot_id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_variety_id` (`variety_id`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_planting_date` (`planting_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-地块种植历史';

-- ============================================================================
-- Module 2: 品种种子管理 (第四章 种源与种子管理)
-- ============================================================================

-- 品种档案
DROP TABLE IF EXISTS `gap_variety`;
CREATE TABLE `gap_variety` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '品种编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '品种编码',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '品种名称',
    `latin_name` varchar(255) DEFAULT '' COMMENT '拉丁学名',
    `family` varchar(100) DEFAULT '' COMMENT '科',
    `genus` varchar(100) DEFAULT '' COMMENT '属',
    `species` varchar(100) DEFAULT '' COMMENT '种',
    `variety_name` varchar(100) DEFAULT '' COMMENT '品种',
    `medicinal_part` varchar(100) DEFAULT '' COMMENT '药用部位',
    `origin_area` varchar(255) DEFAULT '' COMMENT '道地产区',
    `growth_cycle` int(11) DEFAULT NULL COMMENT '生长周期(月)',
    `suitable_climate` varchar(255) DEFAULT '' COMMENT '适宜气候',
    `suitable_soil` varchar(255) DEFAULT '' COMMENT '适宜土壤',
    `yield_per_mu` decimal(10,2) DEFAULT NULL COMMENT '亩产(kg)',
    `quality_standard_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '质量标准编号',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0正常 1停用)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_code` (`code`),
    KEY `idx_name` (`name`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-品种档案';

-- 种子种苗批次
DROP TABLE IF EXISTS `gap_seed_batch`;
CREATE TABLE `gap_seed_batch` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '批次编号',
    `batch_no` varchar(64) NOT NULL DEFAULT '' COMMENT '批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `seed_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '类型(0种子 1种苗)',
    `source_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '来源(0自繁 1外购 2野生采集)',
    `supplier_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '供应商编号',
    `quantity` decimal(16,4) DEFAULT NULL COMMENT '数量',
    `unit` varchar(32) DEFAULT '' COMMENT '单位',
    `purchase_date` date DEFAULT NULL COMMENT '采购/采集日期',
    `storage_location` varchar(255) DEFAULT '' COMMENT '储存位置',
    `storage_condition` varchar(255) DEFAULT '' COMMENT '储存条件',
    `validity_period` date DEFAULT NULL COMMENT '有效期限',
    `origin_identify_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基源鉴定编号',
    `quarantine_cert_no` varchar(100) DEFAULT '' COMMENT '检疫证号',
    `quarantine_cert_url` varchar(500) DEFAULT '' COMMENT '检疫证书附件',
    `purity` decimal(5,2) DEFAULT NULL COMMENT '纯度(%)',
    `germination_rate` decimal(5,2) DEFAULT NULL COMMENT '发芽率(%)',
    `moisture` decimal(5,2) DEFAULT NULL COMMENT '水分(%)',
    `cleanliness` decimal(5,2) DEFAULT NULL COMMENT '净度(%)',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0待验 1合格 2不合格 3已使用)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_batch_no` (`batch_no`),
    KEY `idx_variety_id` (`variety_id`),
    KEY `idx_seed_type` (`seed_type`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-种子种苗批次';

-- 基源鉴定
DROP TABLE IF EXISTS `gap_origin_identify`;
CREATE TABLE `gap_origin_identify` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '鉴定编号',
    `identify_no` varchar(64) NOT NULL DEFAULT '' COMMENT '鉴定报告编号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `seed_batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '种子批次编号',
    `identify_method` varchar(255) DEFAULT '' COMMENT '鉴定方法(形态学/DNA条形码等)',
    `identify_org` varchar(255) DEFAULT '' COMMENT '鉴定机构',
    `identify_person` varchar(100) DEFAULT '' COMMENT '鉴定人',
    `identify_date` date DEFAULT NULL COMMENT '鉴定日期',
    `identify_result` text COMMENT '鉴定结果',
    `conclusion` varchar(500) DEFAULT '' COMMENT '鉴定结论',
    `report_url` varchar(500) DEFAULT '' COMMENT '鉴定报告附件',
    `specimen_url` varchar(500) DEFAULT '' COMMENT '标本照片附件',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_identify_no` (`identify_no`),
    KEY `idx_variety_id` (`variety_id`),
    KEY `idx_seed_batch_id` (`seed_batch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-基源鉴定';

-- 种子处理记录
DROP TABLE IF EXISTS `gap_seed_treatment`;
CREATE TABLE `gap_seed_treatment` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `seed_batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '种子批次编号',
    `treatment_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '处理方式(0消毒 1浸种 2催芽 3包衣)',
    `treatment_date` date DEFAULT NULL COMMENT '处理日期',
    `method` varchar(255) DEFAULT '' COMMENT '处理方法',
    `medicine_name` varchar(255) DEFAULT '' COMMENT '药剂名称',
    `medicine_dosage` varchar(100) DEFAULT '' COMMENT '药剂用量',
    `duration` varchar(100) DEFAULT '' COMMENT '处理时长',
    `operator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '操作人员',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_seed_batch_id` (`seed_batch_id`),
    KEY `idx_treatment_date` (`treatment_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-种子处理记录';

-- ============================================================================
-- Module 3: 投入品管理
-- ============================================================================

-- 投入品分类
DROP TABLE IF EXISTS `gap_input_category`;
CREATE TABLE `gap_input_category` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
    `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父分类编号',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '分类名称',
    `code` varchar(64) DEFAULT '' COMMENT '分类编码',
    `category_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '大类(0农药 1肥料 2生物制剂 3其他)',
    `is_banned` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否禁用',
    `ban_reason` varchar(500) DEFAULT '' COMMENT '禁用原因',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_parent_id` (`parent_id`),
    KEY `idx_category_type` (`category_type`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-投入品分类';

-- 投入品产品
DROP TABLE IF EXISTS `gap_input_product`;
CREATE TABLE `gap_input_product` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '产品编码',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '产品名称',
    `category_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '分类编号',
    `category_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '大类(0农药 1肥料 2生物制剂 3其他)',
    `brand` varchar(100) DEFAULT '' COMMENT '品牌',
    `specification` varchar(255) DEFAULT '' COMMENT '规格',
    `manufacturer` varchar(255) DEFAULT '' COMMENT '生产厂家',
    `registration_no` varchar(100) DEFAULT '' COMMENT '登记证号',
    `production_license` varchar(100) DEFAULT '' COMMENT '生产许可证号',
    `active_ingredient` varchar(255) DEFAULT '' COMMENT '有效成分',
    `content` varchar(100) DEFAULT '' COMMENT '含量',
    `unit` varchar(32) DEFAULT '' COMMENT '单位',
    `formulation` varchar(100) DEFAULT '' COMMENT '剂型',
    `is_banned` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否禁用农药',
    `is_restricted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否限用',
    `restricted_note` varchar(500) DEFAULT '' COMMENT '限用说明',
    `safety_interval` int(11) DEFAULT NULL COMMENT '安全间隔期(天)',
    `max_residue_limit` varchar(100) DEFAULT '' COMMENT '最大残留限量',
    `usage_scope` varchar(500) DEFAULT '' COMMENT '适用作物/范围',
    `storage_condition` varchar(255) DEFAULT '' COMMENT '储存条件',
    `shelf_life` int(11) DEFAULT NULL COMMENT '保质期(月)',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0正常 1停用)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_code` (`code`),
    KEY `idx_category_id` (`category_id`),
    KEY `idx_name` (`name`),
    KEY `idx_is_banned` (`is_banned`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-投入品产品';

-- 投入品供应商
DROP TABLE IF EXISTS `gap_input_supplier`;
CREATE TABLE `gap_input_supplier` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '供应商编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '供应商编码',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '供应商名称',
    `contact_person` varchar(100) DEFAULT '' COMMENT '联系人',
    `contact_phone` varchar(32) DEFAULT '' COMMENT '联系电话',
    `address` varchar(500) DEFAULT '' COMMENT '地址',
    `business_license` varchar(100) DEFAULT '' COMMENT '营业执照号',
    `license_url` varchar(500) DEFAULT '' COMMENT '营业执照附件',
    `production_license` varchar(100) DEFAULT '' COMMENT '生产许可证号',
    `quality_agreement_url` varchar(500) DEFAULT '' COMMENT '质量协议附件',
    `audit_date` date DEFAULT NULL COMMENT '审计日期',
    `audit_result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '审计结果(0合格 1不合格)',
    `audit_report_url` varchar(500) DEFAULT '' COMMENT '审计报告附件',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0合格供应商 1观察 2不合格)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_code` (`code`),
    KEY `idx_name` (`name`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-投入品供应商';

-- 投入品库存
DROP TABLE IF EXISTS `gap_input_inventory`;
CREATE TABLE `gap_input_inventory` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `product_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `supplier_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '供应商编号',
    `purchase_date` date DEFAULT NULL COMMENT '采购日期',
    `quantity` decimal(16,4) NOT NULL DEFAULT 0.0000 COMMENT '库存数量',
    `unit` varchar(32) DEFAULT '' COMMENT '单位',
    `warehouse_location` varchar(255) DEFAULT '' COMMENT '存放位置',
    `production_date` date DEFAULT NULL COMMENT '生产日期',
    `validity_date` date DEFAULT NULL COMMENT '有效期至',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0正常 1近效期 2过期 3用完)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_product_id` (`product_id`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-投入品库存';

-- 投入品使用记录
DROP TABLE IF EXISTS `gap_input_use_record`;
CREATE TABLE `gap_input_use_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `record_no` varchar(64) DEFAULT '' COMMENT '使用单号',
    `product_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品编号',
    `inventory_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '库存编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '产品批次号',
    `use_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '使用类型(0农药 1肥料 2其他)',
    `use_date` date NOT NULL COMMENT '使用日期',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `plot_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '地块编号',
    `plot_batch_no` varchar(64) DEFAULT '' COMMENT '地块种植批次',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `quantity` decimal(16,4) DEFAULT NULL COMMENT '使用量',
    `unit` varchar(32) DEFAULT '' COMMENT '单位',
    `dilution_ratio` varchar(100) DEFAULT '' COMMENT '稀释倍数',
    `application_area` decimal(16,4) DEFAULT NULL COMMENT '施用面积(亩)',
    `application_method` varchar(100) DEFAULT '' COMMENT '施用方法',
    `weather_condition` varchar(100) DEFAULT '' COMMENT '天气条件',
    `wind_direction` varchar(20) DEFAULT '' COMMENT '风向',
    `wind_speed` varchar(20) DEFAULT '' COMMENT '风速',
    `temperature` decimal(5,1) DEFAULT NULL COMMENT '气温',
    `operator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '操作人员',
    `safety_interval` int(11) DEFAULT NULL COMMENT '安全间隔期(天)',
    `earliest_harvest_date` date DEFAULT NULL COMMENT '最早采收日期',
    `is_banned_check` bit(1) NOT NULL DEFAULT b'0' COMMENT '禁用拦截校验',
    `photo_url` varchar(500) DEFAULT '' COMMENT '使用现场照片',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_record_no` (`record_no`),
    KEY `idx_product_id` (`product_id`),
    KEY `idx_use_date` (`use_date`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_plot_id` (`plot_id`),
    KEY `idx_plot_batch_no` (`plot_batch_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-投入品使用记录';

-- 废弃物处理记录
DROP TABLE IF EXISTS `gap_waste_disposal`;
CREATE TABLE `gap_waste_disposal` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `record_no` varchar(64) DEFAULT '' COMMENT '处理单号',
    `waste_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '废弃物类型(0农药包装 1农药残液 2肥料袋 3其他)',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `source_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源记录编号',
    `quantity` decimal(16,4) DEFAULT NULL COMMENT '数量',
    `unit` varchar(32) DEFAULT '' COMMENT '单位',
    `disposal_date` date DEFAULT NULL COMMENT '处理日期',
    `disposal_method` varchar(255) DEFAULT '' COMMENT '处理方式',
    `disposal_location` varchar(255) DEFAULT '' COMMENT '处理地点',
    `handler_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '处理人',
    `witness_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '见证人',
    `photo_url` varchar(500) DEFAULT '' COMMENT '处理照片',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_record_no` (`record_no`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_waste_type` (`waste_type`),
    KEY `idx_disposal_date` (`disposal_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-废弃物处理记录';

-- ============================================================================
-- Module 4: 农事活动管理 (第五章 种植管理)
-- ============================================================================

-- 种植计划
DROP TABLE IF EXISTS `gap_planting_plan`;
CREATE TABLE `gap_planting_plan` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划编号',
    `plan_no` varchar(64) NOT NULL DEFAULT '' COMMENT '计划编号',
    `year` int(11) NOT NULL COMMENT '年度',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `plot_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '地块编号',
    `planned_area` decimal(16,4) DEFAULT NULL COMMENT '计划面积(亩)',
    `planned_quantity` decimal(16,4) DEFAULT NULL COMMENT '计划产量(kg)',
    `seed_batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '种子批次编号',
    `seed_quantity` decimal(16,4) DEFAULT NULL COMMENT '种子用量',
    `seed_unit` varchar(32) DEFAULT '' COMMENT '种子单位',
    `planned_plant_date` date DEFAULT NULL COMMENT '计划种植日期',
    `planned_harvest_date` date DEFAULT NULL COMMENT '计划采收日期',
    `planting_method` varchar(100) DEFAULT '' COMMENT '种植方式',
    `planting_density` varchar(100) DEFAULT '' COMMENT '种植密度',
    `rotation_crop` varchar(100) DEFAULT '' COMMENT '轮作作物',
    `approver_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审批人',
    `approve_time` datetime DEFAULT NULL COMMENT '审批时间',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0草稿 1待审批 2已批准 3已执行 4已取消)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_plan_no` (`plan_no`),
    KEY `idx_year` (`year`),
    KEY `idx_variety_id` (`variety_id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_plot_id` (`plot_id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-种植计划';

-- 农事记录主表
DROP TABLE IF EXISTS `gap_farming_record`;
CREATE TABLE `gap_farming_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    `record_no` varchar(64) NOT NULL DEFAULT '' COMMENT '记录单号',
    `record_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '农事类型(0整地 1播种 2育苗 3移栽 4中耕 5除草 6灌溉 7施肥 8整枝 9覆盖 10病虫害防治 11采收)',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `plot_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '地块编号',
    `plot_batch_no` varchar(64) DEFAULT '' COMMENT '地块种植批次',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `operate_date` date NOT NULL COMMENT '操作日期',
    `weather` varchar(100) DEFAULT '' COMMENT '天气情况',
    `temperature` decimal(5,1) DEFAULT NULL COMMENT '气温',
    `operator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '操作人',
    `supervisor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '监督人',
    `work_hours` decimal(5,1) DEFAULT NULL COMMENT '工时(h)',
    `workers_count` int(11) DEFAULT NULL COMMENT '用工人数',
    `work_area` decimal(16,4) DEFAULT NULL COMMENT '作业面积(亩)',
    `is_weather_checked` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否核对气象',
    `photo_url` varchar(500) DEFAULT '' COMMENT '现场照片',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0草稿 1已提交 2已审核)',
    `audit_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审核人',
    `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_record_no` (`record_no`),
    KEY `idx_record_type` (`record_type`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_plot_id` (`plot_id`),
    KEY `idx_plot_batch_no` (`plot_batch_no`),
    KEY `idx_operate_date` (`operate_date`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-农事记录';

-- 农事记录明细
DROP TABLE IF EXISTS `gap_farming_detail`;
CREATE TABLE `gap_farming_detail` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '明细编号',
    `record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '农事记录编号',
    `detail_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '明细类型(0整地深度 1播种量 2移栽密度 3除草方式 4灌溉量 5肥料种类 6施肥量 7整枝方式 8覆盖材料 9防治对象 10采收量)',
    `item_name` varchar(255) DEFAULT '' COMMENT '项目/物品名称',
    `item_value` varchar(255) DEFAULT '' COMMENT '数值/用量',
    `item_unit` varchar(32) DEFAULT '' COMMENT '单位',
    `item_spec` varchar(255) DEFAULT '' COMMENT '规格说明',
    `before_status` varchar(255) DEFAULT '' COMMENT '操作前状态',
    `after_status` varchar(255) DEFAULT '' COMMENT '操作后状态',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_record_id` (`record_id`),
    KEY `idx_detail_type` (`detail_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-农事记录明细';

-- 病虫害防治方案
DROP TABLE IF EXISTS `gap_pest_control`;
CREATE TABLE `gap_pest_control` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '方案编号',
    `plan_no` varchar(64) NOT NULL DEFAULT '' COMMENT '方案编号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `pest_name` varchar(255) DEFAULT '' COMMENT '病虫害名称',
    `pest_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '类型(0病害 1虫害 2草害 3鼠害)',
    `control_principle` varchar(255) DEFAULT '' COMMENT '防治原则',
    `agricultural_method` text COMMENT '农业防治措施',
    `physical_method` text COMMENT '物理防治措施',
    `biological_method` text COMMENT '生物防治措施',
    `chemical_method` text COMMENT '化学防治措施',
    `approved_pesticide_ids` varchar(500) DEFAULT '' COMMENT '批准使用农药编号列表',
    `prevention_period` varchar(100) DEFAULT '' COMMENT '预防时期',
    `warning_threshold` varchar(100) DEFAULT '' COMMENT '预警阈值',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0草稿 1已审批 2执行中 3已完成)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_plan_no` (`plan_no`),
    KEY `idx_variety_id` (`variety_id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-病虫害防治方案';

-- 灌溉记录
DROP TABLE IF EXISTS `gap_irrigation_record`;
CREATE TABLE `gap_irrigation_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `record_no` varchar(64) DEFAULT '' COMMENT '记录单号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `plot_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '地块编号',
    `plot_batch_no` varchar(64) DEFAULT '' COMMENT '地块种植批次',
    `irrigate_date` date NOT NULL COMMENT '灌溉日期',
    `irrigate_time` varchar(50) DEFAULT '' COMMENT '灌溉时段',
    `irrigate_method` varchar(100) DEFAULT '' COMMENT '灌溉方式',
    `water_source` varchar(100) DEFAULT '' COMMENT '水源',
    `water_volume` decimal(16,4) DEFAULT NULL COMMENT '用水量(m³)',
    `irrigate_area` decimal(16,4) DEFAULT NULL COMMENT '灌溉面积(亩)',
    `soil_moisture_before` decimal(5,2) DEFAULT NULL COMMENT '灌溉前土壤湿度(%)',
    `soil_moisture_after` decimal(5,2) DEFAULT NULL COMMENT '灌溉后土壤湿度(%)',
    `operator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '操作人',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_plot_id` (`plot_id`),
    KEY `idx_irrigate_date` (`irrigate_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-灌溉记录';

-- 施肥记录
DROP TABLE IF EXISTS `gap_fertilization_record`;
CREATE TABLE `gap_fertilization_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `record_no` varchar(64) DEFAULT '' COMMENT '记录单号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `plot_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '地块编号',
    `plot_batch_no` varchar(64) DEFAULT '' COMMENT '地块种植批次',
    `fertilize_date` date NOT NULL COMMENT '施肥日期',
    `fertilize_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '肥料类型(0基肥 1追肥 2叶面肥)',
    `fertilize_stage` varchar(100) DEFAULT '' COMMENT '施肥时期',
    `fertilize_method` varchar(100) DEFAULT '' COMMENT '施肥方法',
    `operator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '操作人',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_plot_id` (`plot_id`),
    KEY `idx_fertilize_date` (`fertilize_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-施肥记录';

-- 施肥明细
DROP TABLE IF EXISTS `gap_fertilization_detail`;
CREATE TABLE `gap_fertilization_detail` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '施肥记录编号',
    `product_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '肥料产品编号',
    `product_name` varchar(255) DEFAULT '' COMMENT '肥料名称',
    `quantity` decimal(16,4) DEFAULT NULL COMMENT '用量',
    `unit` varchar(32) DEFAULT '' COMMENT '单位',
    `active_ingredient` varchar(255) DEFAULT '' COMMENT '有效成分',
    `application_area` decimal(16,4) DEFAULT NULL COMMENT '施用面积(亩)',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_record_id` (`record_id`),
    KEY `idx_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-施肥明细';

-- ============================================================================
-- Module 5: 采收加工管理 (第六章 采收与产地加工)
-- ============================================================================

-- 采收计划
DROP TABLE IF EXISTS `gap_harvest_plan`;
CREATE TABLE `gap_harvest_plan` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划编号',
    `plan_no` varchar(64) NOT NULL DEFAULT '' COMMENT '计划编号',
    `planting_plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '种植计划编号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `plot_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '地块编号',
    `plot_batch_no` varchar(64) DEFAULT '' COMMENT '地块种植批次',
    `planned_harvest_date` date DEFAULT NULL COMMENT '计划采收日期',
    `planned_quantity` decimal(16,4) DEFAULT NULL COMMENT '计划采收量(kg)',
    `harvest_criteria` text COMMENT '采收标准',
    `harvest_method` varchar(255) DEFAULT '' COMMENT '采收方式',
    `harvest_tool` varchar(255) DEFAULT '' COMMENT '采收工具',
    `weather_requirement` varchar(255) DEFAULT '' COMMENT '天气要求',
    `operator_ids` varchar(500) DEFAULT '' COMMENT '采收人员列表',
    `approver_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审批人',
    `approve_time` datetime DEFAULT NULL COMMENT '审批时间',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0草稿 1待审批 2已批准 3已执行 4已取消)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_plan_no` (`plan_no`),
    KEY `idx_planting_plan_id` (`planting_plan_id`),
    KEY `idx_variety_id` (`variety_id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_plot_id` (`plot_id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-采收计划';

-- 采收记录
DROP TABLE IF EXISTS `gap_harvest_record`;
CREATE TABLE `gap_harvest_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    `record_no` varchar(64) NOT NULL DEFAULT '' COMMENT '记录单号',
    `harvest_plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '采收计划编号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `plot_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '地块编号',
    `plot_batch_no` varchar(64) DEFAULT '' COMMENT '地块种植批次',
    `harvest_date` date NOT NULL COMMENT '采收日期',
    `harvest_time` varchar(50) DEFAULT '' COMMENT '采收时段',
    `weather` varchar(100) DEFAULT '' COMMENT '天气情况',
    `temperature` decimal(5,1) DEFAULT NULL COMMENT '气温',
    `harvest_area` decimal(16,4) DEFAULT NULL COMMENT '采收面积(亩)',
    `fresh_weight` decimal(16,4) DEFAULT NULL COMMENT '鲜品重量(kg)',
    `harvest_method` varchar(100) DEFAULT '' COMMENT '采收方式',
    `harvest_tool` varchar(255) DEFAULT '' COMMENT '采收工具',
    `operator_ids` varchar(500) DEFAULT '' COMMENT '采收人员',
    `supervisor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '监督人',
    `batch_no` varchar(64) DEFAULT '' COMMENT '采收批次号(关联追溯)',
    `harvest_cert_no` varchar(64) DEFAULT '' COMMENT '采收合格证号',
    `photo_url` varchar(500) DEFAULT '' COMMENT '采收照片',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0已采收 1已运送 2已加工)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_record_no` (`record_no`),
    KEY `idx_harvest_plan_id` (`harvest_plan_id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_plot_id` (`plot_id`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_harvest_date` (`harvest_date`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-采收记录';

-- 加工记录
DROP TABLE IF EXISTS `gap_process_record`;
CREATE TABLE `gap_process_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    `record_no` varchar(64) NOT NULL DEFAULT '' COMMENT '记录单号',
    `harvest_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '采收记录编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '加工批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `process_date` date NOT NULL COMMENT '加工日期',
    `process_location` varchar(255) DEFAULT '' COMMENT '加工场所',
    `fresh_weight_in` decimal(16,4) DEFAULT NULL COMMENT '鲜品投入量(kg)',
    `dry_weight_out` decimal(16,4) DEFAULT NULL COMMENT '干品产出量(kg)',
    `yield_rate` decimal(5,2) DEFAULT NULL COMMENT '出成率(%)',
    `sop_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '加工SOP编号',
    `operator_ids` varchar(500) DEFAULT '' COMMENT '操作人员',
    `supervisor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '监督人',
    `process_start_time` datetime DEFAULT NULL COMMENT '加工开始时间',
    `process_end_time` datetime DEFAULT NULL COMMENT '加工结束时间',
    `equipment_ids` varchar(500) DEFAULT '' COMMENT '使用设备编号',
    `water_source` varchar(255) DEFAULT '' COMMENT '用水来源',
    `water_test_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '水质检测编号',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0加工中 1已完成 2检验中)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_record_no` (`record_no`),
    KEY `idx_harvest_record_id` (`harvest_record_id`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_variety_id` (`variety_id`),
    KEY `idx_process_date` (`process_date`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-加工记录';

-- 加工工序明细
DROP TABLE IF EXISTS `gap_process_detail`;
CREATE TABLE `gap_process_detail` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `process_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '加工记录编号',
    `process_step` tinyint(4) NOT NULL DEFAULT 0 COMMENT '工序序号',
    `process_name` varchar(100) NOT NULL DEFAULT '' COMMENT '工序名称(0清洗 1去皮 2切制 3干燥 4挑选 5分级 6蒸制 7煮制 8烫制 9发汗)',
    `start_time` datetime DEFAULT NULL COMMENT '开始时间',
    `end_time` datetime DEFAULT NULL COMMENT '结束时间',
    `duration` int(11) DEFAULT NULL COMMENT '时长(分钟)',
    `temperature` decimal(6,2) DEFAULT NULL COMMENT '温度(°C)',
    `humidity` decimal(5,1) DEFAULT NULL COMMENT '湿度(%)',
    `parameter` varchar(255) DEFAULT '' COMMENT '工艺参数',
    `weight_before` decimal(16,4) DEFAULT NULL COMMENT '工序前重量(kg)',
    `weight_after` decimal(16,4) DEFAULT NULL COMMENT '工序后重量(kg)',
    `operator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '操作人',
    `supervisor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '监督人',
    `check_result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检查结果(0合格 1不合格)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_process_record_id` (`process_record_id`),
    KEY `idx_process_step` (`process_step`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-加工工序明细';

-- 干燥记录
DROP TABLE IF EXISTS `gap_drying_record`;
CREATE TABLE `gap_drying_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `process_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '加工记录编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `drying_method` tinyint(4) NOT NULL DEFAULT 0 COMMENT '干燥方式(0晒干 1阴干 2烘干 3风干)',
    `drying_start_time` datetime DEFAULT NULL COMMENT '干燥开始时间',
    `drying_end_time` datetime DEFAULT NULL COMMENT '干燥结束时间',
    `drying_duration` int(11) DEFAULT NULL COMMENT '干燥时长(小时)',
    `initial_moisture` decimal(5,2) DEFAULT NULL COMMENT '初始水分(%)',
    `target_moisture` decimal(5,2) DEFAULT NULL COMMENT '目标水分(%)',
    `final_moisture` decimal(5,2) DEFAULT NULL COMMENT '最终水分(%)',
    `max_temp` decimal(6,2) DEFAULT NULL COMMENT '最高温度(°C)',
    `min_temp` decimal(6,2) DEFAULT NULL COMMENT '最低温度(°C)',
    `avg_temp` decimal(6,2) DEFAULT NULL COMMENT '平均温度(°C)',
    `humidity` decimal(5,1) DEFAULT NULL COMMENT '环境湿度(%)',
    `operator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '操作人',
    `moisture_test_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '水分检测编号',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0干燥中 1已完成 2不合格)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_process_record_id` (`process_record_id`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_drying_method` (`drying_method`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-干燥记录';

-- 包装记录
DROP TABLE IF EXISTS `gap_package_record`;
CREATE TABLE `gap_package_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `process_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '加工记录编号',
    `record_no` varchar(64) DEFAULT '' COMMENT '记录单号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `package_date` date NOT NULL COMMENT '包装日期',
    `package_material` varchar(255) DEFAULT '' COMMENT '包装材料',
    `material_batch_no` varchar(64) DEFAULT '' COMMENT '包材批次号',
    `package_weight` decimal(10,3) DEFAULT NULL COMMENT '包装规格(kg/包)',
    `package_count` int(11) DEFAULT NULL COMMENT '包装数量',
    `total_weight` decimal(16,4) DEFAULT NULL COMMENT '总重量(kg)',
    `label_content` varchar(500) DEFAULT '' COMMENT '标签内容',
    `label_sample_url` varchar(500) DEFAULT '' COMMENT '标签样张附件',
    `operator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '操作人',
    `supervisor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '监督人',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_process_record_id` (`process_record_id`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_package_date` (`package_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-包装记录';

-- ============================================================================
-- Module 6: 仓储物流管理 (第七章 包装、放行与储运)
-- ============================================================================

-- 仓库分区（扩展 wms_warehouse）
DROP TABLE IF EXISTS `gap_storage_area`;
CREATE TABLE `gap_storage_area` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联WMS仓库编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '分区编码',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '分区名称',
    `area_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '区域类型(0待验区 1合格区 2不合格区 3退货区 4发货区)',
    `area` decimal(10,2) DEFAULT NULL COMMENT '面积(m²)',
    `location_desc` varchar(500) DEFAULT '' COMMENT '位置描述',
    `capacity` decimal(16,4) DEFAULT NULL COMMENT '容量(kg)',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0正常 1停用)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_warehouse_id` (`warehouse_id`),
    KEY `idx_code` (`code`),
    KEY `idx_area_type` (`area_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-仓库分区';

-- 药材入库记录
DROP TABLE IF EXISTS `gap_storage_in_record`;
CREATE TABLE `gap_storage_in_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `record_no` varchar(64) NOT NULL DEFAULT '' COMMENT '入库单号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '药材批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `process_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '加工记录编号',
    `package_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '包装记录编号',
    `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
    `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '分区编号',
    `in_date` date NOT NULL COMMENT '入库日期',
    `quantity` decimal(16,4) DEFAULT NULL COMMENT '入库数量(kg)',
    `package_count` int(11) DEFAULT NULL COMMENT '包装件数',
    `quality_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '质量状态(0待验 1合格 2不合格)',
    `appearance_check` varchar(500) DEFAULT '' COMMENT '外观检查',
    `label_check` varchar(255) DEFAULT '' COMMENT '标签检查',
    `inspector_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '验收人',
    `storage_condition` varchar(255) DEFAULT '' COMMENT '储存条件',
    `temperature` decimal(5,1) DEFAULT NULL COMMENT '温度(°C)',
    `humidity` decimal(5,1) DEFAULT NULL COMMENT '湿度(%)',
    `reinspect_date` date DEFAULT NULL COMMENT '复验日期',
    `validity_date` date DEFAULT NULL COMMENT '有效期至',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0待验 1已入库 2已移库 3已出库)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_record_no` (`record_no`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_warehouse_id` (`warehouse_id`),
    KEY `idx_variety_id` (`variety_id`),
    KEY `idx_in_date` (`in_date`),
    KEY `idx_quality_status` (`quality_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-药材入库记录';

-- 药材出库记录
DROP TABLE IF EXISTS `gap_storage_out_record`;
CREATE TABLE `gap_storage_out_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `record_no` varchar(64) NOT NULL DEFAULT '' COMMENT '出库单号',
    `in_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '入库记录编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '药材批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
    `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '分区编号',
    `out_date` date NOT NULL COMMENT '出库日期',
    `quantity` decimal(16,4) DEFAULT NULL COMMENT '出库数量(kg)',
    `package_count` int(11) DEFAULT NULL COMMENT '出库件数',
    `out_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '出库类型(0销售 1调拨 2取样 3退货 4销毁)',
    `receiver` varchar(255) DEFAULT '' COMMENT '接收方',
    `receiver_contact` varchar(100) DEFAULT '' COMMENT '接收方联系人',
    `receiver_address` varchar(500) DEFAULT '' COMMENT '接收地址',
    `transport_no` varchar(64) DEFAULT '' COMMENT '运输单号',
    `release_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '放行单编号',
    `operator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '出库人',
    `checker_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '复核人',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0待出库 1已出库)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_record_no` (`record_no`),
    KEY `idx_in_record_id` (`in_record_id`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_out_date` (`out_date`),
    KEY `idx_out_type` (`out_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-药材出库记录';

-- 养护检查记录
DROP TABLE IF EXISTS `gap_storage_check`;
CREATE TABLE `gap_storage_check` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `record_no` varchar(64) DEFAULT '' COMMENT '检查单号',
    `warehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库编号',
    `area_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '分区编号',
    `check_date` date NOT NULL COMMENT '检查日期',
    `check_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检查类型(0日常巡检 1定期养护 2特殊检查)',
    `temperature` decimal(5,1) DEFAULT NULL COMMENT '温度(°C)',
    `humidity` decimal(5,1) DEFAULT NULL COMMENT '湿度(%)',
    `ventilation` tinyint(4) NOT NULL DEFAULT 0 COMMENT '通风情况(0良好 1一般 2差)',
    `lighting` tinyint(4) NOT NULL DEFAULT 0 COMMENT '光照情况(0正常 1异常)',
    `pest_check` tinyint(4) NOT NULL DEFAULT 0 COMMENT '虫害检查(0无 1有)',
    `mold_check` tinyint(4) NOT NULL DEFAULT 0 COMMENT '霉变检查(0无 1有)',
    `odor_check` tinyint(4) NOT NULL DEFAULT 0 COMMENT '异味检查(0无 1有)',
    `abnormal_desc` varchar(500) DEFAULT '' COMMENT '异常描述',
    `handling_measure` varchar(500) DEFAULT '' COMMENT '处理措施',
    `handler_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '处理人',
    `checker_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检查人',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0正常 1有异常已处理 2有异常待处理)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_warehouse_id` (`warehouse_id`),
    KEY `idx_check_date` (`check_date`),
    KEY `idx_check_type` (`check_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-养护检查记录';

-- 运输记录
DROP TABLE IF EXISTS `gap_transport_record`;
CREATE TABLE `gap_transport_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `transport_no` varchar(64) NOT NULL DEFAULT '' COMMENT '运输单号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '药材批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `out_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '出库记录编号',
    `vehicle_no` varchar(32) DEFAULT '' COMMENT '车辆编号/车牌号',
    `driver_name` varchar(100) DEFAULT '' COMMENT '司机姓名',
    `driver_phone` varchar(32) DEFAULT '' COMMENT '司机电话',
    `transport_start_time` datetime DEFAULT NULL COMMENT '运输开始时间',
    `transport_end_time` datetime DEFAULT NULL COMMENT '运输结束时间',
    `from_location` varchar(500) DEFAULT '' COMMENT '起运地',
    `to_location` varchar(500) DEFAULT '' COMMENT '目的地',
    `quantity` decimal(16,4) DEFAULT NULL COMMENT '运输数量(kg)',
    `package_count` int(11) DEFAULT NULL COMMENT '件数',
    `vehicle_clean_check` bit(1) NOT NULL DEFAULT b'0' COMMENT '车辆清洁检查',
    `weather_protection` bit(1) NOT NULL DEFAULT b'0' COMMENT '防雨措施',
    `seal_no` varchar(64) DEFAULT '' COMMENT '封签号',
    `temp_monitor_url` varchar(500) DEFAULT '' COMMENT '温湿度监控记录',
    `receiver_name` varchar(100) DEFAULT '' COMMENT '收货人',
    `receiver_sign_url` varchar(500) DEFAULT '' COMMENT '签收单附件',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0待运输 1运输中 2已送达 3异常)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_transport_no` (`transport_no`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_vehicle_no` (`vehicle_no`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-运输记录';

-- 不合格品处理
DROP TABLE IF EXISTS `gap_unqualified_handle`;
CREATE TABLE `gap_unqualified_handle` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `record_no` varchar(64) DEFAULT '' COMMENT '处理单号',
    `source_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '来源类型(0采收 1加工 2检验 3仓储)',
    `source_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源记录编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `unqualified_reason` varchar(500) DEFAULT '' COMMENT '不合格原因',
    `quantity` decimal(16,4) DEFAULT NULL COMMENT '数量(kg)',
    `handle_method` tinyint(4) NOT NULL DEFAULT 0 COMMENT '处理方式(0返工 1降级 2销毁 3退货)',
    `handle_result` varchar(500) DEFAULT '' COMMENT '处理结果',
    `handle_date` date DEFAULT NULL COMMENT '处理日期',
    `handler_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '处理人',
    `supervisor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '监督人',
    `photo_url` varchar(500) DEFAULT '' COMMENT '处理照片',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0待处理 1处理中 2已处理)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_record_no` (`record_no`),
    KEY `idx_source_record_id` (`source_record_id`),
    KEY `idx_batch_no` (`batch_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-不合格品处理';

-- ============================================================================
-- Module 7: 质量检测管理 (第九章 质量检验)
-- ============================================================================

-- 质量标准
DROP TABLE IF EXISTS `gap_quality_standard`;
CREATE TABLE `gap_quality_standard` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标准编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '标准编码',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '标准名称',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `standard_level` tinyint(4) NOT NULL DEFAULT 0 COMMENT '标准级别(0企业内控 1国家标准 2行业标准)',
    `version` varchar(32) DEFAULT '' COMMENT '版本号',
    `effective_date` date DEFAULT NULL COMMENT '生效日期',
    `expiry_date` date DEFAULT NULL COMMENT '失效日期',
    `source_species` varchar(255) DEFAULT '' COMMENT '基源要求',
    `appearance_desc` text COMMENT '性状描述',
    `identification_method` text COMMENT '鉴别方法',
    `inspection_items` text COMMENT '检查项目',
    `moisture_limit` decimal(5,2) DEFAULT NULL COMMENT '水分限度(%)',
    `ash_limit` decimal(5,2) DEFAULT NULL COMMENT '灰分限度(%)',
    `extract_limit` decimal(5,2) DEFAULT NULL COMMENT '浸出物限度(%)',
    `content_limit` varchar(255) DEFAULT '' COMMENT '含量测定限度',
    `pesticide_limit` text COMMENT '农药残留限度',
    `heavy_metal_limit` text COMMENT '重金属限度',
    `mould_limit` varchar(255) DEFAULT '' COMMENT '霉菌限度',
    `aflatoxin_limit` varchar(255) DEFAULT '' COMMENT '黄曲霉毒素限度',
    `approver_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批准人',
    `approve_time` datetime DEFAULT NULL COMMENT '批准时间',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0草稿 1已批准 2已废止)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_code` (`code`),
    KEY `idx_variety_id` (`variety_id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-质量标准';

-- 检验任务
DROP TABLE IF EXISTS `gap_inspect_task`;
CREATE TABLE `gap_inspect_task` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务编号',
    `task_no` varchar(64) NOT NULL DEFAULT '' COMMENT '任务单号',
    `task_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '任务类型(0原料检验 1过程检验 2成品检验 3农残检测 4重金属检测 5委托检验)',
    `source_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '来源类型(0采收 1加工 2入库 3在库 4出库)',
    `source_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源记录编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `standard_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '质量标准编号',
    `sample_quantity` decimal(10,3) DEFAULT NULL COMMENT '取样量',
    `sample_unit` varchar(32) DEFAULT '' COMMENT '取样单位',
    `sample_date` date DEFAULT NULL COMMENT '取样日期',
    `sampler_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '取样人',
    `sample_method` varchar(255) DEFAULT '' COMMENT '取样方法',
    `sample_location` varchar(255) DEFAULT '' COMMENT '取样地点',
    `inspect_org` varchar(255) DEFAULT '' COMMENT '检验机构(内部/委托)',
    `planned_complete_date` date DEFAULT NULL COMMENT '计划完成日期',
    `actual_complete_date` date DEFAULT NULL COMMENT '实际完成日期',
    `inspector_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验人',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0待取样 1已取样 2检验中 3已完成 4不合格)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_task_no` (`task_no`),
    KEY `idx_task_type` (`task_type`),
    KEY `idx_source_record_id` (`source_record_id`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-检验任务';

-- 检验记录
DROP TABLE IF EXISTS `gap_inspect_record`;
CREATE TABLE `gap_inspect_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    `record_no` varchar(64) NOT NULL DEFAULT '' COMMENT '检验单号',
    `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验任务编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `standard_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '质量标准编号',
    `inspect_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检验类型(0性状 1鉴别 2检查 3含量测定 4农残 5重金属)',
    `inspect_date` date NOT NULL COMMENT '检验日期',
    `inspect_method` varchar(255) DEFAULT '' COMMENT '检验方法',
    `instrument` varchar(255) DEFAULT '' COMMENT '检验仪器',
    `result_value` varchar(255) DEFAULT '' COMMENT '检验结果值',
    `standard_value` varchar(255) DEFAULT '' COMMENT '标准值',
    `unit` varchar(32) DEFAULT '' COMMENT '单位',
    `conclusion` tinyint(4) NOT NULL DEFAULT 0 COMMENT '单项结论(0合格 1不合格 2未检)',
    `inspector_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验人',
    `reviewer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '复核人',
    `original_record_url` varchar(500) DEFAULT '' COMMENT '原始记录附件',
    `photo_url` varchar(500) DEFAULT '' COMMENT '检验照片',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_record_no` (`record_no`),
    KEY `idx_task_id` (`task_id`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_inspect_type` (`inspect_type`),
    KEY `idx_inspect_date` (`inspect_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-检验记录';

-- 检验报告
DROP TABLE IF EXISTS `gap_inspect_report`;
CREATE TABLE `gap_inspect_report` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '报告编号',
    `report_no` varchar(64) NOT NULL DEFAULT '' COMMENT '报告编号',
    `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验任务编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `sample_no` varchar(64) DEFAULT '' COMMENT '样品编号',
    `report_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '报告类型(0全检 1委托 2抽检)',
    `inspect_org` varchar(255) DEFAULT '' COMMENT '检验机构',
    `inspect_date` date DEFAULT NULL COMMENT '检验日期',
    `report_date` date DEFAULT NULL COMMENT '报告日期',
    `overall_conclusion` tinyint(4) NOT NULL DEFAULT 0 COMMENT '综合结论(0合格 1不合格)',
    `overall_conclusion_desc` varchar(500) DEFAULT '' COMMENT '综合结论描述',
    `report_url` varchar(500) DEFAULT '' COMMENT '报告附件',
    `inspector_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验人',
    `reviewer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '复核人',
    `approver_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批准人',
    `approve_time` datetime DEFAULT NULL COMMENT '批准时间',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0草稿 1已审核 2已批准)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_report_no` (`report_no`),
    KEY `idx_task_id` (`task_id`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_report_date` (`report_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-检验报告';

-- 农残检测明细
DROP TABLE IF EXISTS `gap_pesticide_residue`;
CREATE TABLE `gap_pesticide_residue` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验任务编号',
    `report_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验报告编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `pesticide_name` varchar(255) DEFAULT '' COMMENT '农药名称',
    `pesticide_category` varchar(64) DEFAULT '' COMMENT '农药类别(有机氯/有机磷/氨基甲酸酯等)',
    `is_banned` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否禁用农药',
    `detected_value` decimal(10,6) DEFAULT NULL COMMENT '检出值(mg/kg)',
    `limit_value` decimal(10,6) DEFAULT NULL COMMENT '限量值(mg/kg)',
    `unit` varchar(32) DEFAULT 'mg/kg' COMMENT '单位',
    `detection_limit` decimal(10,6) DEFAULT NULL COMMENT '检测限',
    `conclusion` tinyint(4) NOT NULL DEFAULT 0 COMMENT '结论(0合格 1不合格 2未检出)',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_task_id` (`task_id`),
    KEY `idx_report_id` (`report_id`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_pesticide_name` (`pesticide_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-农残检测明细';

-- 重金属检测明细
DROP TABLE IF EXISTS `gap_heavy_metal`;
CREATE TABLE `gap_heavy_metal` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验任务编号',
    `report_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验报告编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `element_name` varchar(64) DEFAULT '' COMMENT '元素名称(铅/镉/砷/汞/铜)',
    `detected_value` decimal(10,6) DEFAULT NULL COMMENT '检出值(mg/kg)',
    `limit_value` decimal(10,6) DEFAULT NULL COMMENT '限量值(mg/kg)',
    `unit` varchar(32) DEFAULT 'mg/kg' COMMENT '单位',
    `conclusion` tinyint(4) NOT NULL DEFAULT 0 COMMENT '结论(0合格 1不合格)',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_task_id` (`task_id`),
    KEY `idx_report_id` (`report_id`),
    KEY `idx_batch_no` (`batch_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-重金属检测明细';

-- 留样记录
DROP TABLE IF EXISTS `gap_sample_record`;
CREATE TABLE `gap_sample_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `sample_no` varchar(64) NOT NULL DEFAULT '' COMMENT '留样编号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `inspect_task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联检验任务',
    `sample_quantity` decimal(10,3) DEFAULT NULL COMMENT '留样量(kg)',
    `sample_date` date DEFAULT NULL COMMENT '取样日期',
    `storage_location` varchar(255) DEFAULT '' COMMENT '留样位置',
    `storage_condition` varchar(255) DEFAULT '' COMMENT '留样条件',
    `expiry_date` date DEFAULT NULL COMMENT '留样有效期',
    `destroy_date` date DEFAULT NULL COMMENT '销毁日期',
    `destroy_method` varchar(255) DEFAULT '' COMMENT '销毁方式',
    `destroyer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '销毁人',
    `witness_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '见证人',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0留样中 1已到期 2已销毁)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_sample_no` (`sample_no`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_expiry_date` (`expiry_date`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-留样记录';

-- 放行审核记录
DROP TABLE IF EXISTS `gap_release_record`;
CREATE TABLE `gap_release_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `release_no` varchar(64) NOT NULL DEFAULT '' COMMENT '放行单号',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `source_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '来源类型(0加工 1入库)',
    `source_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源记录编号',
    `quantity` decimal(16,4) DEFAULT NULL COMMENT '数量(kg)',
    `inspect_report_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验报告编号',
    `inspect_conclusion` tinyint(4) NOT NULL DEFAULT 0 COMMENT '检验结论(0合格 1不合格)',
    `release_items` text COMMENT '放行审核项目',
    `quality_reviewer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '质量审核人',
    `quality_review_time` datetime DEFAULT NULL COMMENT '质量审核时间',
    `quality_review_opinion` varchar(500) DEFAULT '' COMMENT '质量审核意见',
    `approver_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批准人',
    `approve_time` datetime DEFAULT NULL COMMENT '批准时间',
    `approve_opinion` varchar(500) DEFAULT '' COMMENT '批准意见',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0待审核 1质量审核通过 2已批准 3拒绝)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_release_no` (`release_no`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_source_record_id` (`source_record_id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-放行审核记录';

-- ============================================================================
-- Module 8: 文件体系管理 (第八章 文件管理)
-- ============================================================================

-- 文件分类
DROP TABLE IF EXISTS `gap_document_category`;
CREATE TABLE `gap_document_category` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
    `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父分类编号',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '分类名称',
    `code` varchar(64) DEFAULT '' COMMENT '分类编码',
    `category_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '文件类型(0质量手册 1程序文件 2SOP 3记录表单 4技术标准 5管理制度)',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_parent_id` (`parent_id`),
    KEY `idx_category_type` (`category_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-文件分类';

-- 文件档案
DROP TABLE IF EXISTS `gap_document`;
CREATE TABLE `gap_document` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件编号',
    `doc_no` varchar(64) NOT NULL DEFAULT '' COMMENT '文件编号',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '文件名称',
    `category_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '分类编号',
    `version` varchar(32) DEFAULT 'V1.0' COMMENT '版本号',
    `content` text COMMENT '文件内容/正文',
    `scope` varchar(500) DEFAULT '' COMMENT '适用范围',
    `drafter_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '起草人',
    `draft_date` date DEFAULT NULL COMMENT '起草日期',
    `reviewer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审核人',
    `review_date` date DEFAULT NULL COMMENT '审核日期',
    `review_opinion` varchar(500) DEFAULT '' COMMENT '审核意见',
    `approver_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批准人',
    `approve_date` date DEFAULT NULL COMMENT '批准日期',
    `effective_date` date DEFAULT NULL COMMENT '生效日期',
    `expiry_date` date DEFAULT NULL COMMENT '失效日期',
    `file_url` varchar(500) DEFAULT '' COMMENT '文件附件',
    `distribution_scope` varchar(500) DEFAULT '' COMMENT '发放范围',
    `retention_period` int(11) DEFAULT 5 COMMENT '保存期限(年)',
    `is_effective` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否现行有效',
    `replaced_doc_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '替代文件编号',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0草稿 1审核中 2已批准 3已废止)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_doc_no` (`doc_no`),
    KEY `idx_category_id` (`category_id`),
    KEY `idx_name` (`name`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-文件档案';

-- SOP库
DROP TABLE IF EXISTS `gap_sop`;
CREATE TABLE `gap_sop` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'SOP编号',
    `sop_no` varchar(64) NOT NULL DEFAULT '' COMMENT 'SOP编号',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT 'SOP名称',
    `category` tinyint(4) NOT NULL DEFAULT 0 COMMENT '类别(0种植 1采收 2加工 3仓储 4检验 5设备 6卫生)',
    `version` varchar(32) DEFAULT 'V1.0' COMMENT '版本号',
    `purpose` text COMMENT '目的',
    `scope` varchar(500) DEFAULT '' COMMENT '适用范围',
    `responsibility` varchar(500) DEFAULT '' COMMENT '职责',
    `procedure` text COMMENT '操作步骤',
    `precautions` text COMMENT '注意事项',
    `related_docs` varchar(500) DEFAULT '' COMMENT '相关文件',
    `related_records` varchar(500) DEFAULT '' COMMENT '相关记录',
    `effective_date` date DEFAULT NULL COMMENT '生效日期',
    `file_url` varchar(500) DEFAULT '' COMMENT '附件',
    `approver_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '批准人',
    `approve_date` date DEFAULT NULL COMMENT '批准日期',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0草稿 1已批准 2已废止)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_sop_no` (`sop_no`),
    KEY `idx_category` (`category`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-SOP库';

-- 记录模板
DROP TABLE IF EXISTS `gap_record_template`;
CREATE TABLE `gap_record_template` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模板编号',
    `template_no` varchar(64) NOT NULL DEFAULT '' COMMENT '模板编号',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '模板名称',
    `category_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '分类编号',
    `template_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '模板类型(0原始记录 1台账 2报告)',
    `content` longtext COMMENT '模板内容(JSON)',
    `fill_rules` text COMMENT '填写规范',
    `modify_rules` text COMMENT '修改规范',
    `review_rules` text COMMENT '复核规范',
    `retention_period` int(11) DEFAULT 5 COMMENT '保存期限(年)',
    `effective_date` date DEFAULT NULL COMMENT '生效日期',
    `file_url` varchar(500) DEFAULT '' COMMENT '模板附件',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_template_no` (`template_no`),
    KEY `idx_category_id` (`category_id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-记录模板';

-- ============================================================================
-- Module 9: 培训管理 (第二章 机构与人员)
-- ============================================================================

-- 培训课程
DROP TABLE IF EXISTS `gap_training_course`;
CREATE TABLE `gap_training_course` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '课程编码',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '课程名称',
    `category` tinyint(4) NOT NULL DEFAULT 0 COMMENT '类别(0GAP法规 1SOP 2安全生产 3职业道德 4专业技术 5质量管理)',
    `content` text COMMENT '课程内容',
    `duration` int(11) DEFAULT NULL COMMENT '课时(小时)',
    `instructor` varchar(100) DEFAULT '' COMMENT '讲师',
    `instructor_org` varchar(255) DEFAULT '' COMMENT '讲师单位',
    `material_url` varchar(500) DEFAULT '' COMMENT '培训资料附件',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_code` (`code`),
    KEY `idx_category` (`category`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-培训课程';

-- 培训计划
DROP TABLE IF EXISTS `gap_training_plan`;
CREATE TABLE `gap_training_plan` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划编号',
    `plan_no` varchar(64) NOT NULL DEFAULT '' COMMENT '计划编号',
    `year` int(11) NOT NULL COMMENT '年度',
    `plan_name` varchar(255) NOT NULL DEFAULT '' COMMENT '计划名称',
    `course_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '课程编号',
    `training_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '培训类型(0新员工 1在岗 2转岗 3晋升 4继续教育)',
    `target_dept_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '目标部门',
    `target_post_ids` varchar(500) DEFAULT '' COMMENT '目标岗位',
    `planned_start_date` date DEFAULT NULL COMMENT '计划开始日期',
    `planned_end_date` date DEFAULT NULL COMMENT '计划结束日期',
    `planned_participants` int(11) DEFAULT NULL COMMENT '计划人数',
    `training_location` varchar(255) DEFAULT '' COMMENT '培训地点',
    `training_method` varchar(100) DEFAULT '' COMMENT '培训方式',
    `approver_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审批人',
    `approve_time` datetime DEFAULT NULL COMMENT '审批时间',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0草稿 1待审批 2已批准 3执行中 4已完成)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_plan_no` (`plan_no`),
    KEY `idx_year` (`year`),
    KEY `idx_course_id` (`course_id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-培训计划';

-- 培训记录
DROP TABLE IF EXISTS `gap_training_record`;
CREATE TABLE `gap_training_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    `record_no` varchar(64) NOT NULL DEFAULT '' COMMENT '记录单号',
    `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '培训计划编号',
    `course_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '课程编号',
    `training_date` date NOT NULL COMMENT '培训日期',
    `training_start_time` datetime DEFAULT NULL COMMENT '开始时间',
    `training_end_time` datetime DEFAULT NULL COMMENT '结束时间',
    `training_location` varchar(255) DEFAULT '' COMMENT '培训地点',
    `instructor` varchar(100) DEFAULT '' COMMENT '讲师',
    `participant_count` int(11) DEFAULT NULL COMMENT '参加人数',
    `content_snapshot` text COMMENT '培训内容快照',
    `attendance_url` varchar(500) DEFAULT '' COMMENT '签到表附件',
    `photo_url` varchar(500) DEFAULT '' COMMENT '培训照片',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0已计划 1已完成 2已考核)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_record_no` (`record_no`),
    KEY `idx_plan_id` (`plan_id`),
    KEY `idx_course_id` (`course_id`),
    KEY `idx_training_date` (`training_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-培训记录';

-- 培训参与明细
DROP TABLE IF EXISTS `gap_training_participant`;
CREATE TABLE `gap_training_participant` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '培训记录编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '参训人员',
    `dept_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '部门',
    `post_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '岗位',
    `is_attended` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否出席',
    `attendance_time` datetime DEFAULT NULL COMMENT '签到时间',
    `exam_score` decimal(5,1) DEFAULT NULL COMMENT '考核成绩',
    `exam_result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '考核结果(0合格 1不合格 2未考核)',
    `cert_no` varchar(64) DEFAULT '' COMMENT '证书编号',
    `cert_url` varchar(500) DEFAULT '' COMMENT '证书附件',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_record_id` (`record_id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_exam_result` (`exam_result`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-培训参与明细';

-- 人员健康档案
DROP TABLE IF EXISTS `gap_person_health`;
CREATE TABLE `gap_person_health` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '人员编号',
    `check_date` date NOT NULL COMMENT '体检日期',
    `check_org` varchar(255) DEFAULT '' COMMENT '体检机构',
    `check_item` varchar(500) DEFAULT '' COMMENT '检查项目',
    `check_result` varchar(500) DEFAULT '' COMMENT '检查结果',
    `is_contagious` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否传染病',
    `is_skin_disease` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否皮肤病',
    `is_qualified` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否合格',
    `health_cert_no` varchar(64) DEFAULT '' COMMENT '健康证号',
    `health_cert_url` varchar(500) DEFAULT '' COMMENT '健康证附件',
    `validity_date` date DEFAULT NULL COMMENT '有效期至',
    `next_check_date` date DEFAULT NULL COMMENT '下次体检日期',
    `warning_sent` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否已发送到期预警',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0有效 1即将过期 2已过期)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_check_date` (`check_date`),
    KEY `idx_validity_date` (`validity_date`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-人员健康档案';

-- ============================================================================
-- Module 10: 内部审核管理 (第一章 自检)
-- ============================================================================

-- 审核计划
DROP TABLE IF EXISTS `gap_audit_plan`;
CREATE TABLE `gap_audit_plan` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划编号',
    `plan_no` varchar(64) NOT NULL DEFAULT '' COMMENT '计划编号',
    `year` int(11) NOT NULL COMMENT '年度',
    `plan_name` varchar(255) NOT NULL DEFAULT '' COMMENT '计划名称',
    `audit_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '审核类型(0内部审核 1管理评审 2专项检查)',
    `audit_scope` varchar(500) DEFAULT '' COMMENT '审核范围',
    `planned_start_date` date DEFAULT NULL COMMENT '计划开始日期',
    `planned_end_date` date DEFAULT NULL COMMENT '计划结束日期',
    `auditor_leader_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审核组长',
    `auditor_ids` varchar(500) DEFAULT '' COMMENT '审核组员',
    `audited_dept_ids` varchar(500) DEFAULT '' COMMENT '被审核部门',
    `approver_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审批人',
    `approve_time` datetime DEFAULT NULL COMMENT '审批时间',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0草稿 1待审批 2已批准 3执行中 4已完成)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_plan_no` (`plan_no`),
    KEY `idx_year` (`year`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-审核计划';

-- 检查表
DROP TABLE IF EXISTS `gap_audit_checklist`;
CREATE TABLE `gap_audit_checklist` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '检查表编号',
    `checklist_no` varchar(64) NOT NULL DEFAULT '' COMMENT '检查表编号',
    `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审核计划编号',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '检查表名称',
    `check_chapter` varchar(100) DEFAULT '' COMMENT '检查章节',
    `applicable_clauses` varchar(500) DEFAULT '' COMMENT '适用条款',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_checklist_no` (`checklist_no`),
    KEY `idx_plan_id` (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-检查表';

-- 检查表项目
DROP TABLE IF EXISTS `gap_audit_checklist_item`;
CREATE TABLE `gap_audit_checklist_item` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `checklist_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检查表编号',
    `item_no` varchar(32) DEFAULT '' COMMENT '项目编号',
    `chapter` varchar(100) DEFAULT '' COMMENT '章节',
    `clause` varchar(100) DEFAULT '' COMMENT '条款',
    `check_content` text COMMENT '检查内容',
    `check_method` varchar(255) DEFAULT '' COMMENT '检查方法',
    `check_standard` varchar(500) DEFAULT '' COMMENT '检查标准',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_checklist_id` (`checklist_id`),
    KEY `idx_chapter` (`chapter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-检查表项目';

-- 不符合项
DROP TABLE IF EXISTS `gap_nc_item`;
CREATE TABLE `gap_nc_item` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `nc_no` varchar(64) NOT NULL DEFAULT '' COMMENT '不符合项编号',
    `plan_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审核计划编号',
    `checklist_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检查表编号',
    `checklist_item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检查项目编号',
    `nc_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '不符合类型(0一般 1严重)',
    `nc_desc` text COMMENT '不符合描述',
    `clause_reference` varchar(255) DEFAULT '' COMMENT '引用条款',
    `evidence` varchar(500) DEFAULT '' COMMENT '证据',
    `audited_dept_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '责任部门',
    `responsible_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '责任人',
    `root_cause` text COMMENT '根本原因分析',
    `corrective_action` text COMMENT '纠正措施',
    `corrective_deadline` date DEFAULT NULL COMMENT '纠正期限',
    `corrective_completion_date` date DEFAULT NULL COMMENT '纠正完成日期',
    `preventive_action` text COMMENT '预防措施',
    `preventive_deadline` date DEFAULT NULL COMMENT '预防期限',
    `preventive_completion_date` date DEFAULT NULL COMMENT '预防完成日期',
    `verifier_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '验证人',
    `verify_date` date DEFAULT NULL COMMENT '验证日期',
    `verify_result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '验证结果(0待验证 1有效 2无效)',
    `verify_opinion` varchar(500) DEFAULT '' COMMENT '验证意见',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0待整改 1整改中 2待验证 3已关闭)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_nc_no` (`nc_no`),
    KEY `idx_plan_id` (`plan_id`),
    KEY `idx_responsible_user_id` (`responsible_user_id`),
    KEY `idx_status` (`status`),
    KEY `idx_nc_type` (`nc_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-不符合项';

-- ============================================================================
-- Module 11: 变更/投诉/召回管理
-- ============================================================================

-- 变更记录
DROP TABLE IF EXISTS `gap_change_record`;
CREATE TABLE `gap_change_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `change_no` varchar(64) NOT NULL DEFAULT '' COMMENT '变更单号',
    `change_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '变更类型(0基地 1品种 2工艺 3设备 4人员 5SOP 6供应商)',
    `change_title` varchar(255) NOT NULL DEFAULT '' COMMENT '变更标题',
    `change_desc` text COMMENT '变更描述',
    `before_status` text COMMENT '变更前状态',
    `after_status` text COMMENT '变更后状态',
    `affect_analysis` text COMMENT '影响分析',
    `risk_assessment` text COMMENT '风险评估',
    `validation_plan` text COMMENT '验证计划',
    `proposer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '提出人',
    `propose_date` date DEFAULT NULL COMMENT '提出日期',
    `planned_date` date DEFAULT NULL COMMENT '计划实施日期',
    `actual_date` date DEFAULT NULL COMMENT '实际实施日期',
    `approver_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审批人',
    `approve_time` datetime DEFAULT NULL COMMENT '审批时间',
    `approve_opinion` varchar(500) DEFAULT '' COMMENT '审批意见',
    `process_instance_id` varchar(64) DEFAULT '' COMMENT '审批流程实例ID(关联bpm)',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0待评估 1评估中 2待审批 3已批准 4已实施 5已验证 6已关闭)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_change_no` (`change_no`),
    KEY `idx_change_type` (`change_type`),
    KEY `idx_proposer_id` (`proposer_id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-变更记录';

-- 投诉记录
DROP TABLE IF EXISTS `gap_complaint`;
CREATE TABLE `gap_complaint` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `complaint_no` varchar(64) NOT NULL DEFAULT '' COMMENT '投诉编号',
    `complaint_date` date NOT NULL COMMENT '投诉日期',
    `complainant` varchar(255) DEFAULT '' COMMENT '投诉人',
    `contact_info` varchar(255) DEFAULT '' COMMENT '联系方式',
    `complaint_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '投诉类型(0质量 1包装 2运输 3其他)',
    `batch_no` varchar(64) DEFAULT '' COMMENT '涉及批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '涉及品种',
    `complaint_content` text COMMENT '投诉内容',
    `investigation` text COMMENT '调查结果',
    `conclusion` varchar(500) DEFAULT '' COMMENT '处理结论',
    `handler_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '处理人',
    `handle_date` date DEFAULT NULL COMMENT '处理日期',
    `response_content` text COMMENT '回复内容',
    `response_date` date DEFAULT NULL COMMENT '回复日期',
    `customer_satisfaction` tinyint(4) NOT NULL DEFAULT 0 COMMENT '客户满意度(0满意 1一般 2不满意)',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0待处理 1处理中 2已回复 3已关闭)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_complaint_no` (`complaint_no`),
    KEY `idx_complaint_date` (`complaint_date`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-投诉记录';

-- 召回记录
DROP TABLE IF EXISTS `gap_recall_record`;
CREATE TABLE `gap_recall_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `recall_no` varchar(64) NOT NULL DEFAULT '' COMMENT '召回编号',
    `recall_date` date NOT NULL COMMENT '召回日期',
    `batch_no` varchar(64) DEFAULT '' COMMENT '召回批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `recall_reason` text COMMENT '召回原因',
    `recall_scope` varchar(500) DEFAULT '' COMMENT '召回范围',
    `recall_quantity` decimal(16,4) DEFAULT NULL COMMENT '召回数量(kg)',
    `recall_method` varchar(255) DEFAULT '' COMMENT '召回方式',
    `recall_progress` decimal(5,2) DEFAULT NULL COMMENT '召回进度(%)',
    `recalled_quantity` decimal(16,4) DEFAULT NULL COMMENT '已召回数量(kg)',
    `destroy_quantity` decimal(16,4) DEFAULT NULL COMMENT '销毁数量(kg)',
    `handle_result` text COMMENT '处理结果',
    `handler_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '处理人',
    `close_date` date DEFAULT NULL COMMENT '关闭日期',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0启动 1进行中 2已完成 3已关闭)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_recall_no` (`recall_no`),
    KEY `idx_recall_date` (`recall_date`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-召回记录';

-- ============================================================================
-- Module 12: 溯源管理
-- ============================================================================

-- 溯源批次
DROP TABLE IF EXISTS `gap_trace_batch`;
CREATE TABLE `gap_trace_batch` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `trace_code` varchar(64) NOT NULL DEFAULT '' COMMENT '追溯码',
    `batch_no` varchar(64) DEFAULT '' COMMENT '批次号',
    `variety_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '品种编号',
    `variety_name` varchar(255) DEFAULT '' COMMENT '品种名称(快照)',
    `base_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '基地编号',
    `base_name` varchar(255) DEFAULT '' COMMENT '基地名称(快照)',
    `base_address` varchar(500) DEFAULT '' COMMENT '基地地址(快照)',
    `plot_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '地块编号',
    `plot_name` varchar(255) DEFAULT '' COMMENT '地块名称(快照)',
    `seed_batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '种子批次编号',
    `planting_date` date DEFAULT NULL COMMENT '种植日期',
    `harvest_date` date DEFAULT NULL COMMENT '采收日期',
    `process_date` date DEFAULT NULL COMMENT '加工日期',
    `package_date` date DEFAULT NULL COMMENT '包装日期',
    `package_weight` decimal(10,3) DEFAULT NULL COMMENT '包装规格',
    `total_weight` decimal(16,4) DEFAULT NULL COMMENT '总重量(kg)',
    `package_count` int(11) DEFAULT NULL COMMENT '包装件数',
    `quality_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '质量状态(0合格 1不合格)',
    `inspect_report_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '检验报告编号',
    `release_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '放行单编号',
    `qr_code_url` varchar(500) DEFAULT '' COMMENT '二维码图片',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0种植中 1已采收 2已加工 3已入库 4已放行 5已出库 6已销售)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_trace_code` (`trace_code`),
    KEY `idx_batch_no` (`batch_no`),
    KEY `idx_variety_id` (`variety_id`),
    KEY `idx_base_id` (`base_id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-溯源批次';

-- 溯源节点
DROP TABLE IF EXISTS `gap_trace_node`;
CREATE TABLE `gap_trace_node` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `trace_batch_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '溯源批次编号',
    `trace_code` varchar(64) DEFAULT '' COMMENT '追溯码',
    `node_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '节点类型(0种植 1农事 2采收 3加工 4包装 5入库 6检验 7放行 8出库 9运输)',
    `node_name` varchar(255) DEFAULT '' COMMENT '节点名称',
    `node_time` datetime DEFAULT NULL COMMENT '节点时间',
    `source_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '源记录编号',
    `source_record_no` varchar(64) DEFAULT '' COMMENT '源记录单号',
    `operator_name` varchar(100) DEFAULT '' COMMENT '操作人',
    `location` varchar(500) DEFAULT '' COMMENT '地点',
    `description` text COMMENT '节点描述',
    `photo_url` varchar(500) DEFAULT '' COMMENT '照片附件',
    `detail_json` longtext COMMENT '节点详情(JSON)',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_trace_batch_id` (`trace_batch_id`),
    KEY `idx_trace_code` (`trace_code`),
    KEY `idx_node_type` (`node_type`),
    KEY `idx_node_time` (`node_time`),
    KEY `idx_sort` (`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-溯源节点';

-- ============================================================================
-- Module 13: 审计日志 (数据完整性)
-- ============================================================================

-- GAP业务操作日志
DROP TABLE IF EXISTS `gap_operation_log`;
CREATE TABLE `gap_operation_log` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `log_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '日志类型(0新增 1修改 2删除 3查询 4导入 5导出 6审批)',
    `module_type` varchar(64) DEFAULT '' COMMENT '业务模块',
    `table_name` varchar(100) DEFAULT '' COMMENT '表名',
    `record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '记录编号',
    `record_no` varchar(64) DEFAULT '' COMMENT '记录单号',
    `operation_desc` varchar(500) DEFAULT '' COMMENT '操作描述',
    `request_data` longtext COMMENT '请求数据',
    `response_data` longtext COMMENT '响应数据',
    `operator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '操作人',
    `operator_name` varchar(100) DEFAULT '' COMMENT '操作人姓名',
    `operate_ip` varchar(64) DEFAULT '' COMMENT '操作IP',
    `operate_time` datetime NOT NULL COMMENT '操作时间',
    `duration` int(11) DEFAULT NULL COMMENT '耗时(ms)',
    `result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '结果(0成功 1失败)',
    `error_msg` varchar(500) DEFAULT '' COMMENT '错误信息',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_log_type` (`log_type`),
    KEY `idx_module_type` (`module_type`),
    KEY `idx_table_name` (`table_name`),
    KEY `idx_record_id` (`record_id`),
    KEY `idx_operator_id` (`operator_id`),
    KEY `idx_operate_time` (`operate_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-业务操作日志';

-- GAP数据变更日志 (审计追踪)
DROP TABLE IF EXISTS `gap_data_change_log`;
CREATE TABLE `gap_data_change_log` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `table_name` varchar(100) NOT NULL DEFAULT '' COMMENT '表名',
    `record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '记录编号',
    `change_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '变更类型(0新增 1修改 2删除)',
    `field_name` varchar(100) DEFAULT '' COMMENT '字段名',
    `field_label` varchar(100) DEFAULT '' COMMENT '字段中文名',
    `old_value` text COMMENT '旧值',
    `new_value` text COMMENT '新值',
    `change_reason` varchar(500) DEFAULT '' COMMENT '变更原因(GAP要求)',
    `operator_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '操作人',
    `operator_name` varchar(100) DEFAULT '' COMMENT '操作人姓名',
    `operate_time` datetime NOT NULL COMMENT '操作时间',
    `operate_ip` varchar(64) DEFAULT '' COMMENT '操作IP',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_table_name` (`table_name`),
    KEY `idx_record_id` (`record_id`),
    KEY `idx_change_type` (`change_type`),
    KEY `idx_field_name` (`field_name`),
    KEY `idx_operator_id` (`operator_id`),
    KEY `idx_operate_time` (`operate_time`),
    KEY `idx_table_record` (`table_name`, `record_id`, `version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-数据变更日志(审计追踪)';

-- GAP关键数据复核记录
DROP TABLE IF EXISTS `gap_data_review`;
CREATE TABLE `gap_data_review` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `table_name` varchar(100) NOT NULL DEFAULT '' COMMENT '表名',
    `record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '记录编号',
    `record_no` varchar(64) DEFAULT '' COMMENT '记录单号',
    `review_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '复核类型(0录入复核 1定期复核 2专项复核)',
    `review_content` text COMMENT '复核内容',
    `review_result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '复核结果(0合格 1不合格)',
    `findings` varchar(500) DEFAULT '' COMMENT '发现问题',
    `reviewer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '复核人',
    `review_time` datetime DEFAULT NULL COMMENT '复核时间',
    `corrective_action` varchar(500) DEFAULT '' COMMENT '纠正措施',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态(0待复核 1已复核 2已纠正)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    KEY `idx_table_name` (`table_name`),
    KEY `idx_record_id` (`record_id`),
    KEY `idx_reviewer_id` (`reviewer_id`),
    KEY `idx_review_time` (`review_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='GAP-关键数据复核记录';

SET FOREIGN_KEY_CHECKS = 1;

