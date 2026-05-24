-- MySQL DDL for module: mall-promotion
-- Generated from DO classes in yudao-module-promotion/dal/dataobject/

-- =====================================================
-- promotion_article_category - 文章分类
-- =====================================================
DROP TABLE IF EXISTS `promotion_article_category`;
CREATE TABLE `promotion_article_category` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章分类编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文章分类名称',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '图标地址',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0-关闭，1-开启',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='文章分类';

-- =====================================================
-- promotion_article - 文章管理
-- =====================================================
DROP TABLE IF EXISTS `promotion_article`;
CREATE TABLE `promotion_article` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章管理编号',
    `category_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '分类编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '关联商品编号',
    `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文章标题',
    `author` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文章作者',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文章封面图片地址',
    `introduction` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文章简介',
    `browse_count` int(11) NOT NULL DEFAULT 0 COMMENT '浏览次数',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0-关闭，1-开启',
    `recommend_hot` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否热门(小程序)',
    `recommend_banner` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否轮播图(小程序)',
    `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '文章内容',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_category_id` (`category_id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='文章管理';

-- =====================================================
-- promotion_banner - Banner
-- =====================================================
DROP TABLE IF EXISTS `promotion_banner`;
CREATE TABLE `promotion_banner` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '标题',
    `url` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '跳转链接',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '图片链接',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0-关闭，1-开启',
    `position` tinyint(4) NOT NULL DEFAULT 0 COMMENT '定位',
    `memo` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `browse_count` int(11) NOT NULL DEFAULT 0 COMMENT '点击次数',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_position` (`position`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Banner';

-- =====================================================
-- promotion_bargain_activity - 砍价活动
-- =====================================================
DROP TABLE IF EXISTS `promotion_bargain_activity`;
CREATE TABLE `promotion_bargain_activity` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '砍价活动编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '砍价活动名称',
    `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '活动开始时间',
    `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '活动结束时间',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '活动状态：0-关闭，1-开启',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `sku_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SKU 编号',
    `bargain_first_price` int(11) NOT NULL DEFAULT 0 COMMENT '砍价起始价格，单位：分',
    `bargain_min_price` int(11) NOT NULL DEFAULT 0 COMMENT '砍价底价，单位：分',
    `stock` int(11) NOT NULL DEFAULT 0 COMMENT '砍价库存(剩余库存砍价时扣减)',
    `total_stock` int(11) NOT NULL DEFAULT 0 COMMENT '砍价总库存',
    `help_max_count` int(11) NOT NULL DEFAULT 0 COMMENT '砍价人数，需要多少人砍价才能成功',
    `bargain_count` int(11) NOT NULL DEFAULT 0 COMMENT '帮砍次数，单个活动用户可以帮砍的次数',
    `total_limit_count` int(11) NOT NULL DEFAULT 0 COMMENT '总限购数量',
    `random_min_price` int(11) NOT NULL DEFAULT 0 COMMENT '用户每次砍价的最小金额，单位：分',
    `random_max_price` int(11) NOT NULL DEFAULT 0 COMMENT '用户每次砍价的最大金额，单位：分',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_sku_id` (`sku_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_start_time` (`start_time`) USING BTREE,
    INDEX `idx_end_time` (`end_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='砍价活动';

-- =====================================================
-- promotion_bargain_help - 砍价助力
-- =====================================================
DROP TABLE IF EXISTS `promotion_bargain_help`;
CREATE TABLE `promotion_bargain_help` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `activity_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '砍价活动编号',
    `record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '砍价记录编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `reduce_price` int(11) NOT NULL DEFAULT 0 COMMENT '减少价格，单位：分',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_activity_id` (`activity_id`) USING BTREE,
    INDEX `idx_record_id` (`record_id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='砍价助力';

-- =====================================================
-- promotion_bargain_record - 砍价记录
-- =====================================================
DROP TABLE IF EXISTS `promotion_bargain_record`;
CREATE TABLE `promotion_bargain_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `activity_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '砍价活动编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `sku_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SKU 编号',
    `bargain_first_price` int(11) NOT NULL DEFAULT 0 COMMENT '砍价起始价格，单位：分',
    `bargain_price` int(11) NOT NULL DEFAULT 0 COMMENT '当前砍价，单位：分',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '砍价状态',
    `end_time` datetime DEFAULT NULL COMMENT '结束时间',
    `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '订单编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_activity_id` (`activity_id`) USING BTREE,
    INDEX `idx_order_id` (`order_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='砍价记录';

-- =====================================================
-- promotion_combination_activity - 拼团活动
-- =====================================================
DROP TABLE IF EXISTS `promotion_combination_activity`;
CREATE TABLE `promotion_combination_activity` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '拼团活动编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '拼团名称',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `total_limit_count` int(11) NOT NULL DEFAULT 0 COMMENT '总限购数量',
    `single_limit_count` int(11) NOT NULL DEFAULT 0 COMMENT '单次限购数量',
    `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
    `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
    `user_size` int(11) NOT NULL DEFAULT 0 COMMENT '几人团',
    `virtual_group` bit(1) NOT NULL DEFAULT b'0' COMMENT '虚拟成团',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '活动状态：0-关闭，1-开启',
    `limit_duration` int(11) NOT NULL DEFAULT 0 COMMENT '限制时长（小时）',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_start_time` (`start_time`) USING BTREE,
    INDEX `idx_end_time` (`end_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='拼团活动';

-- =====================================================
-- promotion_combination_product - 拼团商品
-- =====================================================
DROP TABLE IF EXISTS `promotion_combination_product`;
CREATE TABLE `promotion_combination_product` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `activity_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '拼团活动编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `sku_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SKU 编号',
    `combination_price` int(11) NOT NULL DEFAULT 0 COMMENT '拼团价格，单位：分',
    `activity_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '拼团商品状态',
    `activity_start_time` datetime DEFAULT NULL COMMENT '活动开始时间点',
    `activity_end_time` datetime DEFAULT NULL COMMENT '活动结束时间点',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_activity_id` (`activity_id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_sku_id` (`sku_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='拼团商品';

-- =====================================================
-- promotion_combination_record - 拼团记录
-- =====================================================
DROP TABLE IF EXISTS `promotion_combination_record`;
CREATE TABLE `promotion_combination_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `activity_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '拼团活动编号',
    `combination_price` int(11) NOT NULL DEFAULT 0 COMMENT '拼团商品单价',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT 'SPU 编号',
    `spu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品名字',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品图片',
    `sku_id` bigint(20) NOT NULL DEFAULT 0 COMMENT 'SKU 编号',
    `count` int(11) NOT NULL DEFAULT 0 COMMENT '购买的商品数量',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户昵称',
    `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户头像',
    `head_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '团长编号，0-团长',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '开团状态',
    `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '订单编号',
    `user_size` int(11) NOT NULL DEFAULT 0 COMMENT '开团需要人数',
    `user_count` int(11) NOT NULL DEFAULT 0 COMMENT '已加入拼团人数',
    `virtual_group` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否虚拟成团',
    `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
    `start_time` datetime DEFAULT NULL COMMENT '开始时间（订单付款后开始的时间）',
    `end_time` datetime DEFAULT NULL COMMENT '结束时间（成团时间/失败时间）',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_activity_id` (`activity_id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_head_id` (`head_id`) USING BTREE,
    INDEX `idx_order_id` (`order_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_expire_time` (`expire_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='拼团记录';

-- =====================================================
-- promotion_coupon_template - 优惠劵模板
-- =====================================================
DROP TABLE IF EXISTS `promotion_coupon_template`;
CREATE TABLE `promotion_coupon_template` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模板编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '优惠劵名',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '优惠券说明',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0-关闭，1-开启',
    `total_count` int(11) NOT NULL DEFAULT 0 COMMENT '发放数量，-1-不限制',
    `take_limit_count` int(11) NOT NULL DEFAULT 0 COMMENT '每人限领个数，-1-不限制',
    `take_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '领取方式',
    `use_price` int(11) NOT NULL DEFAULT 0 COMMENT '是否设置满多少金额可用，单位：分，0-不限制',
    `product_scope` tinyint(4) NOT NULL DEFAULT 0 COMMENT '商品范围',
    `product_scope_values` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '商品范围编号的数组，JSON 格式',
    `validity_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '生效日期类型',
    `valid_start_time` datetime DEFAULT NULL COMMENT '固定日期-生效开始时间',
    `valid_end_time` datetime DEFAULT NULL COMMENT '固定日期-生效结束时间',
    `fixed_start_term` int(11) NOT NULL DEFAULT 0 COMMENT '领取日期-开始天数',
    `fixed_end_term` int(11) NOT NULL DEFAULT 0 COMMENT '领取日期-结束天数',
    `discount_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '折扣类型',
    `discount_percent` int(11) NOT NULL DEFAULT 0 COMMENT '折扣百分比',
    `discount_price` int(11) NOT NULL DEFAULT 0 COMMENT '优惠金额，单位：分',
    `discount_limit_price` int(11) NOT NULL DEFAULT 0 COMMENT '折扣上限，单位：分',
    `take_count` int(11) NOT NULL DEFAULT 0 COMMENT '领取优惠券的数量',
    `use_count` int(11) NOT NULL DEFAULT 0 COMMENT '使用优惠券的次数',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_take_type` (`take_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='优惠劵模板';

-- =====================================================
-- promotion_coupon - 优惠劵
-- =====================================================
DROP TABLE IF EXISTS `promotion_coupon`;
CREATE TABLE `promotion_coupon` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '优惠劵编号',
    `template_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '优惠劵模板编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '优惠劵名',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '优惠码状态',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `take_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '领取类型',
    `use_price` int(11) NOT NULL DEFAULT 0 COMMENT '是否设置满多少金额可用，单位：分',
    `valid_start_time` datetime DEFAULT NULL COMMENT '生效开始时间',
    `valid_end_time` datetime DEFAULT NULL COMMENT '生效结束时间',
    `product_scope` tinyint(4) NOT NULL DEFAULT 0 COMMENT '商品范围',
    `product_scope_values` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '商品范围编号的数组，JSON 格式',
    `discount_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '折扣类型',
    `discount_percent` int(11) NOT NULL DEFAULT 0 COMMENT '折扣百分比',
    `discount_price` int(11) NOT NULL DEFAULT 0 COMMENT '优惠金额，单位：分',
    `discount_limit_price` int(11) NOT NULL DEFAULT 0 COMMENT '折扣上限，单位：分',
    `use_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '使用订单号',
    `use_time` datetime DEFAULT NULL COMMENT '使用时间',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_template_id` (`template_id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_valid_start_time` (`valid_start_time`) USING BTREE,
    INDEX `idx_valid_end_time` (`valid_end_time`) USING BTREE,
    INDEX `idx_use_order_id` (`use_order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='优惠劵';

-- =====================================================
-- promotion_discount_activity - 限时折扣活动
-- =====================================================
DROP TABLE IF EXISTS `promotion_discount_activity`;
CREATE TABLE `promotion_discount_activity` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '活动编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '活动标题',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0-关闭，1-开启',
    `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
    `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_start_time` (`start_time`) USING BTREE,
    INDEX `idx_end_time` (`end_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='限时折扣活动';

-- =====================================================
-- promotion_discount_product - 限时折扣商品
-- =====================================================
DROP TABLE IF EXISTS `promotion_discount_product`;
CREATE TABLE `promotion_discount_product` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `activity_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '限时折扣活动的编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `sku_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SKU 编号',
    `discount_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '折扣类型',
    `discount_percent` int(11) NOT NULL DEFAULT 0 COMMENT '折扣百分比',
    `discount_price` int(11) NOT NULL DEFAULT 0 COMMENT '优惠金额，单位：分',
    `activity_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '活动标题',
    `activity_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '活动状态',
    `activity_start_time` datetime DEFAULT NULL COMMENT '活动开始时间点',
    `activity_end_time` datetime DEFAULT NULL COMMENT '活动结束时间点',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_activity_id` (`activity_id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_sku_id` (`sku_id`) USING BTREE,
    INDEX `idx_activity_status` (`activity_status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='限时折扣商品';

-- =====================================================
-- promotion_diy_template - 装修模板
-- =====================================================
DROP TABLE IF EXISTS `promotion_diy_template`;
CREATE TABLE `promotion_diy_template` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '装修模板编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '模板名称',
    `used` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否使用',
    `used_time` datetime DEFAULT NULL COMMENT '使用时间',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `preview_pic_urls` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '预览图，JSON 格式',
    `property` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT 'uni-app 底部导航属性，JSON 格式',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='装修模板';

-- =====================================================
-- promotion_diy_page - 装修页面
-- =====================================================
DROP TABLE IF EXISTS `promotion_diy_page`;
CREATE TABLE `promotion_diy_page` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '装修页面编号',
    `template_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '装修模板编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '页面名称',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `preview_pic_urls` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '预览图，JSON 格式',
    `property` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '页面属性，JSON 格式',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_template_id` (`template_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='装修页面';

-- =====================================================
-- promotion_kefu_conversation - 客服会话
-- =====================================================
DROP TABLE IF EXISTS `promotion_kefu_conversation`;
CREATE TABLE `promotion_kefu_conversation` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '会话所属用户',
    `last_message_time` datetime DEFAULT NULL COMMENT '最后聊天时间',
    `last_message_content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '最后聊天内容',
    `last_message_content_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '最后发送的消息类型',
    `admin_pinned` bit(1) NOT NULL DEFAULT b'0' COMMENT '管理端置顶',
    `user_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '用户是否可见：0-可见，1-不可见',
    `admin_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '管理员是否可见：0-可见，1-不可见',
    `admin_unread_message_count` int(11) NOT NULL DEFAULT 0 COMMENT '管理员未读消息数',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_last_message_time` (`last_message_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='客服会话';

-- =====================================================
-- promotion_kefu_message - 客服消息
-- =====================================================
DROP TABLE IF EXISTS `promotion_kefu_message`;
CREATE TABLE `promotion_kefu_message` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `conversation_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '会话编号',
    `sender_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '发送人编号',
    `sender_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '发送人类型',
    `receiver_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '接收人编号',
    `receiver_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '接收人类型',
    `content_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '消息类型',
    `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '消息',
    `read_status` bit(1) NOT NULL DEFAULT b'0' COMMENT '是/否已读',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_conversation_id` (`conversation_id`) USING BTREE,
    INDEX `idx_sender_id` (`sender_id`) USING BTREE,
    INDEX `idx_receiver_id` (`receiver_id`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='客服消息';

-- =====================================================
-- promotion_point_activity - 积分商城活动
-- =====================================================
DROP TABLE IF EXISTS `promotion_point_activity`;
CREATE TABLE `promotion_point_activity` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分商城活动编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '积分商城活动商品',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '活动状态：0-关闭，1-开启',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `stock` int(11) NOT NULL DEFAULT 0 COMMENT '积分商城活动库存(剩余库存积分兑换时扣减)',
    `total_stock` int(11) NOT NULL DEFAULT 0 COMMENT '积分商城活动总库存',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='积分商城活动';

-- =====================================================
-- promotion_point_product - 积分商城商品
-- =====================================================
DROP TABLE IF EXISTS `promotion_point_product`;
CREATE TABLE `promotion_point_product` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '积分商城商品编号',
    `activity_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '积分商城活动 id',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `sku_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SKU 编号',
    `count` int(11) NOT NULL DEFAULT 0 COMMENT '可兑换次数',
    `point` int(11) NOT NULL DEFAULT 0 COMMENT '所需兑换积分',
    `price` int(11) NOT NULL DEFAULT 0 COMMENT '所需兑换金额，单位：分',
    `stock` int(11) NOT NULL DEFAULT 0 COMMENT '积分商城商品库存',
    `activity_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '积分商城商品状态',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_activity_id` (`activity_id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_sku_id` (`sku_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='积分商城商品';

-- =====================================================
-- promotion_reward_activity - 满减送活动
-- =====================================================
DROP TABLE IF EXISTS `promotion_reward_activity`;
CREATE TABLE `promotion_reward_activity` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '活动编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '活动标题',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0-关闭，1-开启',
    `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
    `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `condition_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '条件类型',
    `product_scope` tinyint(4) NOT NULL DEFAULT 0 COMMENT '商品范围',
    `product_scope_values` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '商品 SPU 编号的数组，JSON 格式',
    `rules` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '优惠规则的数组，JSON 格式',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_start_time` (`start_time`) USING BTREE,
    INDEX `idx_end_time` (`end_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='满减送活动';

-- =====================================================
-- promotion_seckill_activity - 秒杀活动
-- =====================================================
DROP TABLE IF EXISTS `promotion_seckill_activity`;
CREATE TABLE `promotion_seckill_activity` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀活动编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '秒杀活动商品',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '秒杀活动名称',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '活动状态：0-关闭，1-开启',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '活动开始时间',
    `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '活动结束时间',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `config_ids` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '秒杀时段id数组，JSON 格式',
    `total_limit_count` int(11) NOT NULL DEFAULT 0 COMMENT '总限购数量',
    `single_limit_count` int(11) NOT NULL DEFAULT 0 COMMENT '单次限够数量',
    `stock` int(11) NOT NULL DEFAULT 0 COMMENT '秒杀库存(剩余库存秒杀时扣减)',
    `total_stock` int(11) NOT NULL DEFAULT 0 COMMENT '秒杀总库存',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_start_time` (`start_time`) USING BTREE,
    INDEX `idx_end_time` (`end_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='秒杀活动';

-- =====================================================
-- promotion_seckill_config - 秒杀时段
-- =====================================================
DROP TABLE IF EXISTS `promotion_seckill_config`;
CREATE TABLE `promotion_seckill_config` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '秒杀时段名称',
    `start_time` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '开始时间点',
    `end_time` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '结束时间点',
    `slider_pic_urls` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '秒杀轮播图，JSON 格式',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0-关闭，1-开启',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='秒杀时段';

-- =====================================================
-- promotion_seckill_product - 秒杀参与商品
-- =====================================================
DROP TABLE IF EXISTS `promotion_seckill_product`;
CREATE TABLE `promotion_seckill_product` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀参与商品编号',
    `activity_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '秒杀活动 id',
    `config_ids` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '秒杀时段id数组，JSON 格式',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `sku_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SKU 编号',
    `seckill_price` int(11) NOT NULL DEFAULT 0 COMMENT '秒杀金额，单位：分',
    `stock` int(11) NOT NULL DEFAULT 0 COMMENT '秒杀库存',
    `activity_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '秒杀商品状态',
    `activity_start_time` datetime DEFAULT NULL COMMENT '活动开始时间点',
    `activity_end_time` datetime DEFAULT NULL COMMENT '活动结束时间点',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_activity_id` (`activity_id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_sku_id` (`sku_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='秒杀参与商品';
