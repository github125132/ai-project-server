-- MySQL DDL for module: member
-- Generated from DO classes in yudao-module-member/dal/dataobject/

-- =============================================
-- Table: member_address (用户收件地址)
-- =============================================
DROP TABLE IF EXISTS `member_address`;
CREATE TABLE `member_address` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL COMMENT '用户编号',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '收件人名称',
    `mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
    `area_id` bigint(20) DEFAULT NULL COMMENT '地区编号',
    `detail_address` varchar(500) NOT NULL DEFAULT '' COMMENT '收件详细地址',
    `default_status` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否默认',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id` (`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户收件地址';

-- =============================================
-- Table: member_config (会员配置)
-- =============================================
DROP TABLE IF EXISTS `member_config`;
CREATE TABLE `member_config` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `point_trade_deduct_enable` bit(1) NOT NULL DEFAULT b'0' COMMENT '积分抵扣开关',
    `point_trade_deduct_unit_price` int(11) NOT NULL DEFAULT 0 COMMENT '积分抵扣，单位：分',
    `point_trade_deduct_max_price` int(11) NOT NULL DEFAULT 0 COMMENT '积分抵扣最大值',
    `point_trade_give_point` int(11) NOT NULL DEFAULT 0 COMMENT '1 元赠送多少分',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '会员配置';

-- =============================================
-- Table: member_group (用户分组)
-- =============================================
DROP TABLE IF EXISTS `member_group`;
CREATE TABLE `member_group` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户分组';

-- =============================================
-- Table: member_experience_record (会员经验记录)
-- =============================================
DROP TABLE IF EXISTS `member_experience_record`;
CREATE TABLE `member_experience_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL COMMENT '用户编号',
    `biz_type` tinyint(4) NOT NULL COMMENT '业务类型',
    `biz_id` varchar(64) NOT NULL DEFAULT '' COMMENT '业务编号',
    `title` varchar(255) NOT NULL DEFAULT '' COMMENT '标题',
    `description` varchar(500) DEFAULT '' COMMENT '描述',
    `experience` int(11) NOT NULL DEFAULT 0 COMMENT '经验',
    `total_experience` int(11) NOT NULL DEFAULT 0 COMMENT '变更后的经验',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id` (`user_id`),
    INDEX `idx_biz_type` (`biz_type`),
    INDEX `idx_biz_id` (`biz_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '会员经验记录';

-- =============================================
-- Table: member_level (会员等级)
-- =============================================
DROP TABLE IF EXISTS `member_level`;
CREATE TABLE `member_level` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '等级名称',
    `level` int(11) NOT NULL DEFAULT 0 COMMENT '等级',
    `experience` int(11) NOT NULL DEFAULT 0 COMMENT '升级经验',
    `discount_percent` int(11) NOT NULL DEFAULT 100 COMMENT '享受折扣',
    `icon` varchar(500) DEFAULT '' COMMENT '等级图标',
    `background_url` varchar(500) DEFAULT '' COMMENT '等级背景图',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_status` (`status`),
    INDEX `idx_level` (`level`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '会员等级';

-- =============================================
-- Table: member_level_record (会员等级记录)
-- =============================================
DROP TABLE IF EXISTS `member_level_record`;
CREATE TABLE `member_level_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL COMMENT '用户编号',
    `level_id` bigint(20) NOT NULL COMMENT '等级编号',
    `level` int(11) NOT NULL DEFAULT 0 COMMENT '会员等级',
    `discount_percent` int(11) NOT NULL DEFAULT 100 COMMENT '享受折扣',
    `experience` int(11) NOT NULL DEFAULT 0 COMMENT '升级经验',
    `user_experience` int(11) NOT NULL DEFAULT 0 COMMENT '会员此时的经验',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `description` varchar(500) DEFAULT '' COMMENT '描述',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id` (`user_id`),
    INDEX `idx_level_id` (`level_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '会员等级记录';

-- =============================================
-- Table: member_point_record (用户积分记录)
-- =============================================
DROP TABLE IF EXISTS `member_point_record`;
CREATE TABLE `member_point_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户编号',
    `biz_id` varchar(64) NOT NULL DEFAULT '' COMMENT '业务编码',
    `biz_type` tinyint(4) NOT NULL COMMENT '业务类型',
    `title` varchar(255) NOT NULL DEFAULT '' COMMENT '积分标题',
    `description` varchar(500) DEFAULT '' COMMENT '积分描述',
    `point` int(11) NOT NULL DEFAULT 0 COMMENT '变动积分',
    `total_point` int(11) NOT NULL DEFAULT 0 COMMENT '变动后的积分',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id` (`user_id`),
    INDEX `idx_biz_type` (`biz_type`),
    INDEX `idx_biz_id` (`biz_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户积分记录';

-- =============================================
-- Table: member_sign_in_config (签到规则)
-- =============================================
DROP TABLE IF EXISTS `member_sign_in_config`;
CREATE TABLE `member_sign_in_config` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规则自增主键',
    `day` int(11) NOT NULL COMMENT '签到第 x 天',
    `point` int(11) NOT NULL DEFAULT 0 COMMENT '奖励积分',
    `experience` int(11) NOT NULL DEFAULT 0 COMMENT '奖励经验',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_status` (`status`),
    INDEX `idx_day` (`day`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '签到规则';

-- =============================================
-- Table: member_sign_in_record (签到记录)
-- =============================================
DROP TABLE IF EXISTS `member_sign_in_record`;
CREATE TABLE `member_sign_in_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL COMMENT '签到用户',
    `day` int(11) NOT NULL COMMENT '第几天签到',
    `point` int(11) NOT NULL DEFAULT 0 COMMENT '签到的积分',
    `experience` int(11) NOT NULL DEFAULT 0 COMMENT '签到的经验',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id` (`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '签到记录';

-- =============================================
-- Table: member_tag (会员标签)
-- =============================================
DROP TABLE IF EXISTS `member_tag`;
CREATE TABLE `member_tag` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '标签名称',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '会员标签';

-- =============================================
-- Table: member_user (会员用户)
-- =============================================
DROP TABLE IF EXISTS `member_user`;
CREATE TABLE `member_user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '手机',
    `password` varchar(255) NOT NULL DEFAULT '' COMMENT '加密后的密码',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '帐号状态',
    `register_ip` varchar(64) DEFAULT '' COMMENT '注册 IP',
    `register_terminal` tinyint(4) DEFAULT NULL COMMENT '注册终端',
    `login_ip` varchar(64) DEFAULT '' COMMENT '最后登录IP',
    `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
    `nickname` varchar(100) DEFAULT '' COMMENT '用户昵称',
    `avatar` varchar(500) DEFAULT '' COMMENT '用户头像',
    `name` varchar(100) DEFAULT '' COMMENT '真实名字',
    `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
    `birthday` datetime DEFAULT NULL COMMENT '出生日期',
    `area_id` int(11) DEFAULT NULL COMMENT '所在地',
    `mark` varchar(500) DEFAULT '' COMMENT '用户备注',
    `point` int(11) NOT NULL DEFAULT 0 COMMENT '积分',
    `tag_ids` varchar(2000) DEFAULT NULL COMMENT '会员标签列表(逗号分隔)',
    `level_id` bigint(20) DEFAULT NULL COMMENT '会员级别编号',
    `experience` int(11) NOT NULL DEFAULT 0 COMMENT '会员经验',
    `group_id` bigint(20) DEFAULT NULL COMMENT '用户分组编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_mobile` (`mobile`),
    INDEX `idx_level_id` (`level_id`),
    INDEX `idx_group_id` (`group_id`),
    INDEX `idx_status` (`status`),
    INDEX `idx_tenant_id` (`tenant_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '会员用户';
