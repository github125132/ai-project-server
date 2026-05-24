-- MySQL DDL for module: iot
-- Generated from DO classes in yudao-module-iot-biz/dal/dataobject/
-- Note: IotDeviceMessageDO (TDengine) and IotDevicePropertyDO (Redis) are non-MySQL entities, skipped.

-- =====================================================
-- iot_alert_config - IoT 告警配置
-- =====================================================
DROP TABLE IF EXISTS `iot_alert_config`;
CREATE TABLE `iot_alert_config` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '配置编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '配置名称',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '配置描述',
    `level` tinyint(4) NOT NULL DEFAULT 0 COMMENT '告警级别',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '配置状态：0-关闭，1-开启',
    `scene_rule_ids` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '关联的场景联动规则编号数组，JSON 格式',
    `receive_user_ids` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '接收的用户编号数组，JSON 格式',
    `receive_types` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '接收的类型数组，JSON 格式',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 告警配置';

-- =====================================================
-- iot_alert_record - IoT 告警记录
-- =====================================================
DROP TABLE IF EXISTS `iot_alert_record`;
CREATE TABLE `iot_alert_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    `config_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '告警配置编号',
    `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '告警名称',
    `config_level` tinyint(4) NOT NULL DEFAULT 0 COMMENT '告警级别',
    `scene_rule_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '场景规则编号',
    `product_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品编号',
    `device_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '设备编号',
    `device_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '触发的设备消息，JSON 格式',
    `process_status` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否处理',
    `process_remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '处理结果（备注）',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_config_id` (`config_id`) USING BTREE,
    INDEX `idx_scene_rule_id` (`scene_rule_id`) USING BTREE,
    INDEX `idx_product_id` (`product_id`) USING BTREE,
    INDEX `idx_device_id` (`device_id`) USING BTREE,
    INDEX `idx_process_status` (`process_status`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 告警记录';

-- =====================================================
-- iot_device - IoT 设备
-- =====================================================
DROP TABLE IF EXISTS `iot_device`;
CREATE TABLE `iot_device` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '设备 ID',
    `device_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '设备名称，在产品内唯一',
    `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '设备备注名称',
    `serial_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '设备序列号',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '设备图片',
    `group_ids` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '设备分组编号集合，JSON 格式',
    `product_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品编号',
    `product_key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '产品标识',
    `device_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '设备类型',
    `gateway_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '网关设备编号',
    `state` tinyint(4) NOT NULL DEFAULT 0 COMMENT '设备状态',
    `online_time` datetime DEFAULT NULL COMMENT '最后上线时间',
    `offline_time` datetime DEFAULT NULL COMMENT '最后离线时间',
    `active_time` datetime DEFAULT NULL COMMENT '设备激活时间',
    `firmware_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '固件编号',
    `device_secret` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '设备密钥，用于设备认证',
    `latitude` decimal(24,6) DEFAULT NULL COMMENT '设备位置的纬度',
    `longitude` decimal(24,6) DEFAULT NULL COMMENT '设备位置的经度',
    `config` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '设备配置，JSON 格式',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_product_id` (`product_id`) USING BTREE,
    INDEX `idx_product_key` (`product_key`) USING BTREE,
    INDEX `idx_device_type` (`device_type`) USING BTREE,
    INDEX `idx_gateway_id` (`gateway_id`) USING BTREE,
    INDEX `idx_state` (`state`) USING BTREE,
    INDEX `idx_serial_number` (`serial_number`) USING BTREE,
    INDEX `idx_tenant_id` (`tenant_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 设备';

-- =====================================================
-- iot_device_group - IoT 设备分组
-- =====================================================
DROP TABLE IF EXISTS `iot_device_group`;
CREATE TABLE `iot_device_group` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分组 ID',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '分组名字',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '分组状态：0-关闭，1-开启',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '分组描述',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 设备分组';

-- =====================================================
-- iot_device_modbus_config - IoT 设备 Modbus 连接配置
-- =====================================================
DROP TABLE IF EXISTS `iot_device_modbus_config`;
CREATE TABLE `iot_device_modbus_config` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `product_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品编号',
    `device_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '设备编号',
    `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Modbus 服务器 IP 地址',
    `port` int(11) NOT NULL DEFAULT 0 COMMENT 'Modbus 服务器端口',
    `slave_id` int(11) NOT NULL DEFAULT 0 COMMENT '从站地址',
    `timeout` int(11) NOT NULL DEFAULT 0 COMMENT '连接超时时间，单位：毫秒',
    `retry_interval` int(11) NOT NULL DEFAULT 0 COMMENT '重试间隔，单位：毫秒',
    `mode` tinyint(4) NOT NULL DEFAULT 0 COMMENT 'Modbus 模式',
    `frame_format` tinyint(4) NOT NULL DEFAULT 0 COMMENT '数据帧格式',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0-关闭，1-开启',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_product_id` (`product_id`) USING BTREE,
    INDEX `idx_device_id` (`device_id`) USING BTREE,
    INDEX `idx_tenant_id` (`tenant_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 设备 Modbus 连接配置';

-- =====================================================
-- iot_device_modbus_point - IoT 设备 Modbus 点位配置
-- =====================================================
DROP TABLE IF EXISTS `iot_device_modbus_point`;
CREATE TABLE `iot_device_modbus_point` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `device_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '设备编号',
    `thing_model_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物模型属性编号',
    `identifier` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '属性标识符',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '属性名称',
    `function_code` tinyint(4) NOT NULL DEFAULT 0 COMMENT 'Modbus 功能码',
    `register_address` int(11) NOT NULL DEFAULT 0 COMMENT '寄存器起始地址',
    `register_count` int(11) NOT NULL DEFAULT 0 COMMENT '寄存器数量',
    `byte_order` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '字节序',
    `raw_data_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '原始数据类型',
    `scale` decimal(24,6) DEFAULT NULL COMMENT '缩放因子',
    `poll_interval` int(11) NOT NULL DEFAULT 0 COMMENT '轮询间隔（毫秒）',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0-关闭，1-开启',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_device_id` (`device_id`) USING BTREE,
    INDEX `idx_thing_model_id` (`thing_model_id`) USING BTREE,
    INDEX `idx_identifier` (`identifier`) USING BTREE,
    INDEX `idx_tenant_id` (`tenant_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 设备 Modbus 点位配置';

-- =====================================================
-- iot_ota_firmware - IoT OTA 固件
-- =====================================================
DROP TABLE IF EXISTS `iot_ota_firmware`;
CREATE TABLE `iot_ota_firmware` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '固件编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '固件名称',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '固件描述',
    `version` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '版本号',
    `product_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品编号',
    `file_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '固件文件 URL',
    `file_size` bigint(20) NOT NULL DEFAULT 0 COMMENT '固件文件大小',
    `file_digest_algorithm` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '固件文件签名算法',
    `file_digest_value` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '固件文件签名结果',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_product_id` (`product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT OTA 固件';

-- =====================================================
-- iot_ota_task - IoT OTA 升级任务
-- =====================================================
DROP TABLE IF EXISTS `iot_ota_task`;
CREATE TABLE `iot_ota_task` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '任务名称',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '任务描述',
    `firmware_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '固件编号',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '任务状态',
    `device_scope` tinyint(4) NOT NULL DEFAULT 0 COMMENT '设备升级范围',
    `device_total_count` int(11) NOT NULL DEFAULT 0 COMMENT '设备总数数量',
    `device_success_count` int(11) NOT NULL DEFAULT 0 COMMENT '设备成功数量',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_firmware_id` (`firmware_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT OTA 升级任务';

-- =====================================================
-- iot_ota_task_record - IoT OTA 升级任务记录
-- =====================================================
DROP TABLE IF EXISTS `iot_ota_task_record`;
CREATE TABLE `iot_ota_task_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '升级记录编号',
    `firmware_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '固件编号',
    `task_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '任务编号',
    `device_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '设备编号',
    `from_firmware_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源的固件编号',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '升级状态',
    `progress` int(11) NOT NULL DEFAULT 0 COMMENT '升级进度，百分比',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '升级进度描述',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_firmware_id` (`firmware_id`) USING BTREE,
    INDEX `idx_task_id` (`task_id`) USING BTREE,
    INDEX `idx_device_id` (`device_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT OTA 升级任务记录';

-- =====================================================
-- iot_product_category - IoT 产品分类
-- =====================================================
DROP TABLE IF EXISTS `iot_product_category`;
CREATE TABLE `iot_product_category` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类 ID',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '分类名字',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '分类排序',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '分类状态：0-关闭，1-开启',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '分类描述',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 产品分类';

-- =====================================================
-- iot_product - IoT 产品
-- =====================================================
DROP TABLE IF EXISTS `iot_product`;
CREATE TABLE `iot_product` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品 ID',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '产品名称',
    `product_key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '产品标识',
    `product_secret` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '产品密钥，用于一型一密动态注册',
    `register_enabled` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否开启动态注册',
    `category_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品分类编号',
    `icon` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '产品图标',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '产品图片',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '产品描述',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '产品状态',
    `device_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '设备类型',
    `net_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '联网方式',
    `protocol_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '协议类型',
    `serialize_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '序列化类型',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_product_key` (`product_key`) USING BTREE,
    INDEX `idx_category_id` (`category_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_tenant_id` (`tenant_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 产品';

-- =====================================================
-- iot_data_rule - IoT 数据流转规则
-- =====================================================
DROP TABLE IF EXISTS `iot_data_rule`;
CREATE TABLE `iot_data_rule` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据流转规格编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '数据流转规格名称',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '数据流转规格描述',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '数据流转规格状态：0-关闭，1-开启',
    `source_configs` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '数据源配置数组，JSON 格式',
    `sink_ids` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '数据目的编号数组，JSON 格式',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 数据流转规则';

-- =====================================================
-- iot_data_sink - IoT 数据流转目的
-- =====================================================
DROP TABLE IF EXISTS `iot_data_sink`;
CREATE TABLE `iot_data_sink` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据流转目的编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '数据流转目的名称',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '数据流转目的描述',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '数据流转目的状态：0-关闭，1-开启',
    `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '数据流转目的类型',
    `config` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '数据流转目的配置，JSON 格式',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_type` (`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 数据流转目的';

-- =====================================================
-- iot_scene_rule - IoT 场景联动规则
-- =====================================================
DROP TABLE IF EXISTS `iot_scene_rule`;
CREATE TABLE `iot_scene_rule` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '场景联动编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '场景联动名称',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '场景联动描述',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '场景联动状态：0-关闭，1-开启',
    `last_trigger_time` datetime DEFAULT NULL COMMENT '最后触发时间',
    `triggers` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '场景定义配置，JSON 格式',
    `actions` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '场景动作配置，JSON 格式',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_tenant_id` (`tenant_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 场景联动规则';

-- =====================================================
-- iot_thing_model - IoT 产品物模型功能
-- =====================================================
DROP TABLE IF EXISTS `iot_thing_model`;
CREATE TABLE `iot_thing_model` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物模型功能编号',
    `identifier` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '功能标识',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '功能名称',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '功能描述',
    `product_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '产品编号',
    `product_key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '产品标识',
    `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '功能类型',
    `property` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '属性定义，JSON 格式',
    `event` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '事件定义，JSON 格式',
    `service` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '服务定义，JSON 格式',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_product_id` (`product_id`) USING BTREE,
    INDEX `idx_product_key` (`product_key`) USING BTREE,
    INDEX `idx_identifier` (`identifier`) USING BTREE,
    INDEX `idx_type` (`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IoT 产品物模型功能';
