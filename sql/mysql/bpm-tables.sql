-- MySQL DDL for module: bpm
-- Generated from DO classes in yudao-module-bpm/dal/dataobject/

-- =============================================
-- Table: bpm_category (BPM 流程分类)
-- =============================================
DROP TABLE IF EXISTS `bpm_category`;
CREATE TABLE `bpm_category` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '分类名',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '分类标志',
    `description` varchar(500) DEFAULT '' COMMENT '分类描述',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '分类状态',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '分类排序',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_code` (`code`),
    INDEX `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'BPM 流程分类';

-- =============================================
-- Table: bpm_form (BPM 工作流的表单定义)
-- =============================================
DROP TABLE IF EXISTS `bpm_form`;
CREATE TABLE `bpm_form` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '表单名',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `conf` text COMMENT '表单的配置',
    `fields` text COMMENT '表单项的数组(JSON)',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'BPM 工作流的表单定义';

-- =============================================
-- Table: bpm_process_definition_info (BPM 流程定义的拓信息)
-- =============================================
DROP TABLE IF EXISTS `bpm_process_definition_info`;
CREATE TABLE `bpm_process_definition_info` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `process_definition_id` varchar(64) NOT NULL DEFAULT '' COMMENT '流程定义的编号',
    `model_id` varchar(64) NOT NULL DEFAULT '' COMMENT '流程模型的编号',
    `model_type` int(11) NOT NULL DEFAULT 0 COMMENT '流程模型的类型',
    `category` varchar(64) DEFAULT '' COMMENT '流程分类的编码',
    `icon` varchar(500) DEFAULT '' COMMENT '图标',
    `description` varchar(500) DEFAULT '' COMMENT '描述',
    `form_type` int(11) DEFAULT NULL COMMENT '表单类型',
    `form_id` bigint(20) DEFAULT NULL COMMENT '动态表单编号',
    `form_conf` text COMMENT '表单的配置',
    `form_fields` text COMMENT '表单项的数组(JSON)',
    `form_custom_create_path` varchar(500) DEFAULT '' COMMENT '自定义表单的提交路径',
    `form_custom_view_path` varchar(500) DEFAULT '' COMMENT '自定义表单的查看路径',
    `simple_model` longtext COMMENT 'SIMPLE 设计器模型数据 json 格式',
    `visible` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否可见',
    `sort` bigint(20) DEFAULT 0 COMMENT '排序值',
    `start_user_ids` text COMMENT '可发起用户编号数组',
    `start_dept_ids` text COMMENT '可发起部门编号数组',
    `manager_user_ids` text COMMENT '可管理用户编号数组',
    `allow_cancel_running_process` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否允许撤销审批中的申请',
    `allow_withdraw_task` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否允许审批人撤回任务',
    `process_id_rule` text COMMENT '流程 ID 规则(JSON)',
    `auto_approval_type` tinyint(4) DEFAULT NULL COMMENT '自动去重类型',
    `title_setting` text COMMENT '标题设置(JSON)',
    `summary_setting` text COMMENT '摘要设置(JSON)',
    `process_before_trigger_setting` text COMMENT '流程前置通知设置(JSON)',
    `process_after_trigger_setting` text COMMENT '流程后置通知设置(JSON)',
    `task_before_trigger_setting` text COMMENT '任务前置通知设置(JSON)',
    `task_after_trigger_setting` text COMMENT '任务后置通知设置(JSON)',
    `print_template_setting` text COMMENT '自定义打印模板设置(JSON)',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_process_definition_id` (`process_definition_id`),
    INDEX `idx_model_id` (`model_id`),
    INDEX `idx_category` (`category`),
    INDEX `idx_form_id` (`form_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'BPM 流程定义的拓信息';

-- =============================================
-- Table: bpm_process_expression (BPM 流程表达式)
-- =============================================
DROP TABLE IF EXISTS `bpm_process_expression`;
CREATE TABLE `bpm_process_expression` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '表达式名字',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '表达式状态',
    `expression` varchar(2000) NOT NULL DEFAULT '' COMMENT '表达式',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'BPM 流程表达式';

-- =============================================
-- Table: bpm_process_listener (BPM 流程监听器)
-- =============================================
DROP TABLE IF EXISTS `bpm_process_listener`;
CREATE TABLE `bpm_process_listener` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键 ID，自增',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '监听器名字',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `type` varchar(32) NOT NULL DEFAULT '' COMMENT '监听类型',
    `event` varchar(64) NOT NULL DEFAULT '' COMMENT '监听事件',
    `value_type` varchar(32) NOT NULL DEFAULT '' COMMENT '值类型',
    `value` varchar(500) NOT NULL DEFAULT '' COMMENT '值',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_status` (`status`),
    INDEX `idx_type` (`type`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'BPM 流程监听器';

-- =============================================
-- Table: bpm_user_group (BPM 用户组)
-- =============================================
DROP TABLE IF EXISTS `bpm_user_group`;
CREATE TABLE `bpm_user_group` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号，自增',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '组名',
    `description` varchar(500) DEFAULT '' COMMENT '描述',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `user_ids` text COMMENT '成员用户编号数组(JSON)',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'BPM 用户组';

-- =============================================
-- Table: bpm_oa_leave (OA 请假申请)
-- =============================================
DROP TABLE IF EXISTS `bpm_oa_leave`;
CREATE TABLE `bpm_oa_leave` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '请假表单主键',
    `user_id` bigint(20) NOT NULL COMMENT '申请人的用户编号',
    `type` tinyint(4) NOT NULL COMMENT '请假类型',
    `reason` varchar(500) DEFAULT '' COMMENT '原因',
    `start_time` datetime NOT NULL COMMENT '开始时间',
    `end_time` datetime NOT NULL COMMENT '结束时间',
    `day` bigint(20) NOT NULL DEFAULT 0 COMMENT '请假天数',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '审批结果',
    `process_instance_id` varchar(64) DEFAULT NULL COMMENT '对应的流程编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id` (`user_id`),
    INDEX `idx_process_instance_id` (`process_instance_id`),
    INDEX `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'OA 请假申请';

-- =============================================
-- Table: bpm_process_instance_copy (流程抄送)
-- =============================================
DROP TABLE IF EXISTS `bpm_process_instance_copy`;
CREATE TABLE `bpm_process_instance_copy` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `start_user_id` bigint(20) NOT NULL COMMENT '发起人 Id',
    `process_instance_name` varchar(255) DEFAULT '' COMMENT '流程名',
    `process_instance_id` varchar(64) NOT NULL COMMENT '流程实例的编号',
    `process_definition_id` varchar(64) DEFAULT '' COMMENT '流程实例的流程定义编号',
    `category` varchar(64) DEFAULT '' COMMENT '流程分类',
    `activity_id` varchar(64) DEFAULT '' COMMENT '流程活动的编号',
    `activity_name` varchar(255) DEFAULT '' COMMENT '流程活动的名字',
    `task_id` varchar(64) DEFAULT '' COMMENT '流程活动的编号',
    `user_id` bigint(20) NOT NULL COMMENT '用户编号（被抄送的用户编号）',
    `reason` varchar(500) DEFAULT '' COMMENT '抄送意见',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_process_instance_id` (`process_instance_id`),
    INDEX `idx_user_id` (`user_id`),
    INDEX `idx_start_user_id` (`start_user_id`),
    INDEX `idx_task_id` (`task_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '流程抄送';
