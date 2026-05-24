-- MySQL DDL for module: mall-trade
-- Generated from DO classes in yudao-module-trade/dal/dataobject/

-- =====================================================
-- trade_after_sale - 售后订单
-- =====================================================
DROP TABLE IF EXISTS `trade_after_sale`;
CREATE TABLE `trade_after_sale` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '售后编号',
    `no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '售后单号',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '退款状态',
    `way` tinyint(4) NOT NULL DEFAULT 0 COMMENT '售后方式',
    `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '售后类型',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `apply_reason` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '申请原因',
    `apply_description` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '补充描述',
    `apply_pic_urls` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '补充凭证图片，JSON 格式',
    `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '交易订单编号',
    `order_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '订单流水号',
    `order_item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '交易订单项编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `spu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品 SPU 名称',
    `sku_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SKU 编号',
    `properties` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '属性数组，JSON 格式',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品图片',
    `count` int(11) NOT NULL DEFAULT 0 COMMENT '退货商品数量',
    `audit_time` datetime DEFAULT NULL COMMENT '审批时间',
    `audit_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '审批人',
    `audit_reason` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审批备注',
    `refund_price` int(11) NOT NULL DEFAULT 0 COMMENT '退款金额，单位：分',
    `pay_refund_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '支付退款编号',
    `refund_time` datetime DEFAULT NULL COMMENT '退款时间',
    `logistics_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '退货物流公司编号',
    `logistics_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '退货物流单号',
    `delivery_time` datetime DEFAULT NULL COMMENT '退货时间',
    `receive_time` datetime DEFAULT NULL COMMENT '收货时间',
    `receive_reason` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '收货备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_no` (`no`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_order_id` (`order_id`) USING BTREE,
    INDEX `idx_order_item_id` (`order_item_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='售后订单';

-- =====================================================
-- trade_after_sale_log - 交易售后日志
-- =====================================================
DROP TABLE IF EXISTS `trade_after_sale_log`;
CREATE TABLE `trade_after_sale_log` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `user_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '用户类型',
    `after_sale_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '售后编号',
    `before_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '操作前状态',
    `after_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '操作后状态',
    `operate_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '操作类型',
    `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '操作明细',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_after_sale_id` (`after_sale_id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='交易售后日志';

-- =====================================================
-- trade_brokerage_record - 佣金记录
-- =====================================================
DROP TABLE IF EXISTS `trade_brokerage_record`;
CREATE TABLE `trade_brokerage_record` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `biz_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '业务编号',
    `biz_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '业务类型',
    `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '标题',
    `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '说明',
    `price` int(11) NOT NULL DEFAULT 0 COMMENT '金额',
    `total_price` int(11) NOT NULL DEFAULT 0 COMMENT '当前总佣金',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `frozen_days` int(11) NOT NULL DEFAULT 0 COMMENT '冻结时间（天）',
    `unfreeze_time` datetime DEFAULT NULL COMMENT '解冻时间',
    `source_user_level` int(11) NOT NULL DEFAULT 0 COMMENT '来源用户等级',
    `source_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '来源用户编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_biz_id` (`biz_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='佣金记录';

-- =====================================================
-- trade_brokerage_user - 分销用户
-- =====================================================
DROP TABLE IF EXISTS `trade_brokerage_user`;
CREATE TABLE `trade_brokerage_user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
    `bind_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '推广员编号',
    `bind_user_time` datetime DEFAULT NULL COMMENT '推广员绑定时间',
    `brokerage_enabled` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否有分销资格',
    `brokerage_time` datetime DEFAULT NULL COMMENT '成为分销员时间',
    `brokerage_price` int(11) NOT NULL DEFAULT 0 COMMENT '可用佣金',
    `frozen_price` int(11) NOT NULL DEFAULT 0 COMMENT '冻结佣金',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_bind_user_id` (`bind_user_id`) USING BTREE,
    INDEX `idx_brokerage_enabled` (`brokerage_enabled`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='分销用户';

-- =====================================================
-- trade_brokerage_withdraw - 佣金提现
-- =====================================================
DROP TABLE IF EXISTS `trade_brokerage_withdraw`;
CREATE TABLE `trade_brokerage_withdraw` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `price` int(11) NOT NULL DEFAULT 0 COMMENT '提现金额，单位：分',
    `fee_price` int(11) NOT NULL DEFAULT 0 COMMENT '提现手续费，单位：分',
    `total_price` int(11) NOT NULL DEFAULT 0 COMMENT '当前总佣金，单位：分',
    `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '提现类型',
    `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '提现姓名',
    `user_account` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '提现账号',
    `qr_code_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '收款码',
    `bank_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '银行名称',
    `bank_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '开户地址',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `audit_reason` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审核驳回原因',
    `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
    `pay_transfer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '转账单编号',
    `transfer_channel_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '转账渠道',
    `transfer_time` datetime DEFAULT NULL COMMENT '转账成功时间',
    `transfer_error_msg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '转账错误提示',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='佣金提现';

-- =====================================================
-- trade_cart - 购物车
-- =====================================================
DROP TABLE IF EXISTS `trade_cart`;
CREATE TABLE `trade_cart` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `sku_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SKU 编号',
    `count` int(11) NOT NULL DEFAULT 0 COMMENT '商品购买数量',
    `selected` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否选中',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_sku_id` (`sku_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='购物车';

-- =====================================================
-- trade_config - 交易中心配置
-- =====================================================
DROP TABLE IF EXISTS `trade_config`;
CREATE TABLE `trade_config` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `after_sale_refund_reasons` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '售后的退款理由，JSON 格式',
    `after_sale_return_reasons` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '售后的退货理由，JSON 格式',
    `delivery_express_free_enabled` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否启用全场包邮',
    `delivery_express_free_price` int(11) NOT NULL DEFAULT 0 COMMENT '全场包邮的最小金额，单位：分',
    `delivery_pick_up_enabled` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否开启自提',
    `brokerage_enabled` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否启用分佣',
    `brokerage_enabled_condition` tinyint(4) NOT NULL DEFAULT 0 COMMENT '分佣模式',
    `brokerage_bind_mode` tinyint(4) NOT NULL DEFAULT 0 COMMENT '分销关系绑定模式',
    `brokerage_poster_urls` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '分销海报图地址数组，JSON 格式',
    `brokerage_first_percent` int(11) NOT NULL DEFAULT 0 COMMENT '一级返佣比例',
    `brokerage_second_percent` int(11) NOT NULL DEFAULT 0 COMMENT '二级返佣比例',
    `brokerage_withdraw_min_price` int(11) NOT NULL DEFAULT 0 COMMENT '用户提现最低金额',
    `brokerage_withdraw_fee_percent` int(11) NOT NULL DEFAULT 0 COMMENT '用户提现手续费百分比',
    `brokerage_frozen_days` int(11) NOT NULL DEFAULT 0 COMMENT '佣金冻结时间(天)',
    `brokerage_withdraw_types` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '提现方式，JSON 格式',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='交易中心配置';

-- =====================================================
-- trade_delivery_express - 快递公司
-- =====================================================
DROP TABLE IF EXISTS `trade_delivery_express`;
CREATE TABLE `trade_delivery_express` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '快递公司 code',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '快递公司名称',
    `logo` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '快递公司 logo',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态：0-关闭，1-开启',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_code` (`code`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='快递公司';

-- =====================================================
-- trade_delivery_express_template - 快递运费模板
-- =====================================================
DROP TABLE IF EXISTS `trade_delivery_express_template`;
CREATE TABLE `trade_delivery_express_template` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '模板名称',
    `charge_mode` tinyint(4) NOT NULL DEFAULT 0 COMMENT '配送计费方式',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='快递运费模板';

-- =====================================================
-- trade_delivery_express_template_charge - 快递运费模板计费配置
-- =====================================================
DROP TABLE IF EXISTS `trade_delivery_express_template_charge`;
CREATE TABLE `trade_delivery_express_template_charge` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `template_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '配送模板编号',
    `area_ids` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '配送区域编号列表，JSON 格式',
    `charge_mode` tinyint(4) NOT NULL DEFAULT 0 COMMENT '配送计费方式',
    `start_count` double NOT NULL DEFAULT 0 COMMENT '首件数量(件数,重量，或体积)',
    `start_price` int(11) NOT NULL DEFAULT 0 COMMENT '起步价，单位：分',
    `extra_count` double NOT NULL DEFAULT 0 COMMENT '续件数量(件, 重量，或体积)',
    `extra_price` int(11) NOT NULL DEFAULT 0 COMMENT '额外价，单位：分',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_template_id` (`template_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='快递运费模板计费配置';

-- =====================================================
-- trade_delivery_express_template_free - 快递运费模板包邮配置
-- =====================================================
DROP TABLE IF EXISTS `trade_delivery_express_template_free`;
CREATE TABLE `trade_delivery_express_template_free` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `template_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '配送模板编号',
    `area_ids` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '配送区域编号列表，JSON 格式',
    `free_price` int(11) NOT NULL DEFAULT 0 COMMENT '包邮金额，单位：分',
    `free_count` int(11) NOT NULL DEFAULT 0 COMMENT '包邮件数',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_template_id` (`template_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='快递运费模板包邮配置';

-- =====================================================
-- trade_delivery_pick_up_store - 自提门店
-- =====================================================
DROP TABLE IF EXISTS `trade_delivery_pick_up_store`;
CREATE TABLE `trade_delivery_pick_up_store` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '门店名称',
    `introduction` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '门店简介',
    `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '门店手机',
    `area_id` int(11) NOT NULL DEFAULT 0 COMMENT '区域编号',
    `detail_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '门店详细地址',
    `logo` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '门店 logo',
    `opening_time` time DEFAULT NULL COMMENT '营业开始时间',
    `closing_time` time DEFAULT NULL COMMENT '营业结束时间',
    `latitude` double DEFAULT NULL COMMENT '纬度',
    `longitude` double DEFAULT NULL COMMENT '经度',
    `verify_user_ids` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '核销员工用户编号数组，JSON 格式',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '门店状态：0-关闭，1-开启',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_area_id` (`area_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='自提门店';

-- =====================================================
-- trade_order - 交易订单
-- =====================================================
DROP TABLE IF EXISTS `trade_order`;
CREATE TABLE `trade_order` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
    `no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '订单流水号',
    `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单类型',
    `terminal` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单来源',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `user_ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户 IP',
    `user_remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户备注',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态',
    `product_count` int(11) NOT NULL DEFAULT 0 COMMENT '购买的商品数量',
    `finish_time` datetime DEFAULT NULL COMMENT '订单完成时间',
    `cancel_time` datetime DEFAULT NULL COMMENT '订单取消时间',
    `cancel_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '取消类型',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商家备注',
    `comment_status` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否评价',
    `brokerage_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '推广人编号',
    `pay_order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '支付订单编号',
    `pay_status` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否已支付',
    `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
    `pay_channel_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '支付渠道',
    `total_price` int(11) NOT NULL DEFAULT 0 COMMENT '商品原价，单位：分',
    `discount_price` int(11) NOT NULL DEFAULT 0 COMMENT '优惠金额，单位：分',
    `delivery_price` int(11) NOT NULL DEFAULT 0 COMMENT '运费金额，单位：分',
    `adjust_price` int(11) NOT NULL DEFAULT 0 COMMENT '订单调价，单位：分',
    `pay_price` int(11) NOT NULL DEFAULT 0 COMMENT '应付金额（总），单位：分',
    `delivery_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '配送方式',
    `logistics_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '发货物流公司编号',
    `logistics_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '发货物流单号',
    `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
    `receive_time` datetime DEFAULT NULL COMMENT '收货时间',
    `receiver_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '收件人名称',
    `receiver_mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '收件人手机',
    `receiver_area_id` int(11) NOT NULL DEFAULT 0 COMMENT '收件人地区编号',
    `receiver_detail_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '收件人详细地址',
    `pick_up_store_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '自提门店编号',
    `pick_up_verify_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '自提核销码',
    `refund_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '售后状态',
    `refund_price` int(11) NOT NULL DEFAULT 0 COMMENT '退款金额，单位：分',
    `coupon_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '优惠劵编号',
    `coupon_price` int(11) NOT NULL DEFAULT 0 COMMENT '优惠劵减免金额，单位：分',
    `use_point` int(11) NOT NULL DEFAULT 0 COMMENT '使用的积分',
    `point_price` int(11) NOT NULL DEFAULT 0 COMMENT '积分抵扣的金额，单位：分',
    `give_point` int(11) NOT NULL DEFAULT 0 COMMENT '赠送的积分',
    `refund_point` int(11) NOT NULL DEFAULT 0 COMMENT '退还的使用的积分',
    `vip_price` int(11) NOT NULL DEFAULT 0 COMMENT 'VIP 减免金额，单位：分',
    `give_coupon_template_counts` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '赠送的优惠劵模版数量，JSON 格式',
    `give_coupon_ids` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '赠送的优惠劵编号，JSON 格式',
    `seckill_activity_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '秒杀活动编号',
    `bargain_activity_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '砍价活动编号',
    `bargain_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '砍价记录编号',
    `combination_activity_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '拼团活动编号',
    `combination_head_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '拼团团长编号',
    `combination_record_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '拼团记录编号',
    `point_activity_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '积分商城活动的编号',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_no` (`no`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_status` (`status`) USING BTREE,
    INDEX `idx_pay_status` (`pay_status`) USING BTREE,
    INDEX `idx_pay_order_id` (`pay_order_id`) USING BTREE,
    INDEX `idx_refund_status` (`refund_status`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE,
    INDEX `idx_delivery_type` (`delivery_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='交易订单';

-- =====================================================
-- trade_order_item - 交易订单项
-- =====================================================
DROP TABLE IF EXISTS `trade_order_item`;
CREATE TABLE `trade_order_item` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '订单编号',
    `cart_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '购物车项编号',
    `spu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SPU 编号',
    `spu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品 SPU 名称',
    `sku_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品 SKU 编号',
    `properties` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '属性数组，JSON 格式',
    `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品图片',
    `count` int(11) NOT NULL DEFAULT 0 COMMENT '购买数量',
    `comment_status` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否评价',
    `price` int(11) NOT NULL DEFAULT 0 COMMENT '商品原价（单），单位：分',
    `discount_price` int(11) NOT NULL DEFAULT 0 COMMENT '优惠金额（总），单位：分',
    `delivery_price` int(11) NOT NULL DEFAULT 0 COMMENT '运费金额（总），单位：分',
    `adjust_price` int(11) NOT NULL DEFAULT 0 COMMENT '订单调价（总），单位：分',
    `pay_price` int(11) NOT NULL DEFAULT 0 COMMENT '应付金额（总），单位：分',
    `coupon_price` int(11) NOT NULL DEFAULT 0 COMMENT '优惠劵减免金额，单位：分',
    `point_price` int(11) NOT NULL DEFAULT 0 COMMENT '积分抵扣的金额，单位：分',
    `use_point` int(11) NOT NULL DEFAULT 0 COMMENT '使用的积分',
    `give_point` int(11) NOT NULL DEFAULT 0 COMMENT '赠送的积分',
    `vip_price` int(11) NOT NULL DEFAULT 0 COMMENT 'VIP 减免金额，单位：分',
    `after_sale_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '售后单编号',
    `after_sale_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '售后状态',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_order_id` (`order_id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_spu_id` (`spu_id`) USING BTREE,
    INDEX `idx_sku_id` (`sku_id`) USING BTREE,
    INDEX `idx_after_sale_status` (`after_sale_status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='交易订单项';

-- =====================================================
-- trade_order_log - 订单日志
-- =====================================================
DROP TABLE IF EXISTS `trade_order_log`;
CREATE TABLE `trade_order_log` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户编号',
    `user_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '用户类型',
    `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '订单号',
    `before_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '操作前状态',
    `after_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '操作后状态',
    `operate_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '操作类型',
    `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '订单日志信息',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_order_id` (`order_id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单日志';
