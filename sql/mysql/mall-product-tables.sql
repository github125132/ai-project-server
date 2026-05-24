-- MySQL DDL for module: mall-product
-- Generated from DO classes in yudao-module-product/dal/dataobject/

-- =====================================================
-- product_brand - 商品品牌
-- =====================================================
DROP TABLE IF EXISTS `product_brand`;
CREATE TABLE `product_brand` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '品牌编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '品牌名称',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '品牌图片',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '品牌排序',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '品牌描述',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0-关闭，1-开启',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品品牌';

-- =====================================================
-- product_category - 商品分类
-- =====================================================
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
    `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父分类编号，0-根分类',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '分类名称',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '移动端分类图',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '分类排序',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '开启状态：0-关闭，1-开启',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_parent_id` (`parent_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品分类';

-- =====================================================
-- product_comment - 商品评论
-- =====================================================
DROP TABLE IF EXISTS `product_comment`;
CREATE TABLE `product_comment` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '评价人的用户编号',
    `user_nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '评价人名称',
    `user_avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '评价人头像',
    `anonymous` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否匿名',
    `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '交易订单编号',
    `order_item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '交易订单项编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `spu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品 SPU 名称',
    `sku_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SKU 编号',
    `sku_pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品 SKU 图片地址',
    `sku_properties` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '属性数组，JSON 格式',
    `visible` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否可见',
    `scores` tinyint(4) NOT NULL DEFAULT 0 COMMENT '评分星级，1-5',
    `description_scores` tinyint(4) NOT NULL DEFAULT 0 COMMENT '描述星级，1-5',
    `benefit_scores` tinyint(4) NOT NULL DEFAULT 0 COMMENT '服务星级，1-5',
    `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '评论内容',
    `pic_urls` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '评论图片地址数组，JSON 格式',
    `reply_status` bit(1) NOT NULL DEFAULT b'0' COMMENT '商家是否回复',
    `reply_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '回复管理员编号',
    `reply_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '商家回复内容',
    `reply_time` datetime DEFAULT NULL COMMENT '商家回复时间',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_order_id` (`order_id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_sku_id` (`sku_id`) USING BTREE,
    INDEX `idx_reply_status` (`reply_status`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品评论';

-- =====================================================
-- product_favorite - 商品收藏
-- =====================================================
DROP TABLE IF EXISTS `product_favorite`;
CREATE TABLE `product_favorite` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    UNIQUE INDEX `uk_user_spu` (`user_id`, `spu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品收藏';

-- =====================================================
-- product_browse_history - 商品浏览记录
-- =====================================================
DROP TABLE IF EXISTS `product_browse_history`;
CREATE TABLE `product_browse_history` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `user_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '用户是否删除',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品浏览记录';

-- =====================================================
-- product_property - 商品属性项
-- =====================================================
DROP TABLE IF EXISTS `product_property`;
CREATE TABLE `product_property` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '名称',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品属性项';

-- =====================================================
-- product_property_value - 商品属性值
-- =====================================================
DROP TABLE IF EXISTS `product_property_value`;
CREATE TABLE `product_property_value` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `property_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '属性项的编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '名称',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_property_id` (`property_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品属性值';

-- =====================================================
-- product_sku - 商品 SKU
-- =====================================================
DROP TABLE IF EXISTS `product_sku`;
CREATE TABLE `product_sku` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品 SKU 编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT 'SPU 编号',
    `properties` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '属性数组，JSON 格式',
    `price` int(11) NOT NULL DEFAULT 0 COMMENT '商品价格，单位：分',
    `market_price` int(11) NOT NULL DEFAULT 0 COMMENT '市场价，单位：分',
    `cost_price` int(11) NOT NULL DEFAULT 0 COMMENT '成本价，单位：分',
    `bar_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品条码',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '图片地址',
    `stock` int(11) NOT NULL DEFAULT 0 COMMENT '库存',
    `weight` double NOT NULL DEFAULT 0 COMMENT '商品重量，单位：kg 千克',
    `volume` double NOT NULL DEFAULT 0 COMMENT '商品体积，单位：m^3',
    `first_brokerage_price` int(11) NOT NULL DEFAULT 0 COMMENT '一级分销的佣金，单位：分',
    `second_brokerage_price` int(11) NOT NULL DEFAULT 0 COMMENT '二级分销的佣金，单位：分',
    `sales_count` int(11) NOT NULL DEFAULT 0 COMMENT '商品销量',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_bar_code` (`bar_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品 SKU';

-- =====================================================
-- product_spu - 商品 SPU
-- =====================================================
DROP TABLE IF EXISTS `product_spu`;
CREATE TABLE `product_spu` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品 SPU 编号',
    `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品名称',
    `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '关键字',
    `introduction` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品简介',
    `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '商品详情',
    `category_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品分类编号',
    `brand_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品品牌编号',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品封面图',
    `slider_pic_urls` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '商品轮播图，JSON 格式',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序字段',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '商品状态',
    `spec_type` bit(1) NOT NULL DEFAULT b'0' COMMENT '规格类型：0-单规格，1-多规格',
    `price` int(11) NOT NULL DEFAULT 0 COMMENT '商品价格，单位：分',
    `market_price` int(11) NOT NULL DEFAULT 0 COMMENT '市场价，单位：分',
    `cost_price` int(11) NOT NULL DEFAULT 0 COMMENT '成本价，单位：分',
    `stock` int(11) NOT NULL DEFAULT 0 COMMENT '库存',
    `delivery_types` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '配送方式数组，JSON 格式',
    `delivery_template_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '物流配置模板编号',
    `give_integral` int(11) NOT NULL DEFAULT 0 COMMENT '赠送积分',
    `sub_commission_type` bit(1) NOT NULL DEFAULT b'0' COMMENT '分销类型：0-默认，1-自行设置',
    `sales_count` int(11) NOT NULL DEFAULT 0 COMMENT '商品销量',
    `virtual_sales_count` int(11) NOT NULL DEFAULT 0 COMMENT '虚拟销量',
    `browse_count` int(11) NOT NULL DEFAULT 0 COMMENT '浏览量',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_category_id` (`category_id`) USING BTREE,
    INDEX `idx_brand_id` (`brand_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品 SPU';
