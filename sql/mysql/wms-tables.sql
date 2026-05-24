-- MySQL DDL for module: wms
-- Generated from DO classes in yudao-module-wms/dal/dataobject/

-- =============================================
-- Table: wms_inventory (WMS 库存)
-- =============================================
DROP TABLE IF EXISTS `wms_inventory`;
CREATE TABLE `wms_inventory` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `sku_id` bigint(20) NOT NULL COMMENT '商品 SKU 编号',
    `warehouse_id` bigint(20) NOT NULL COMMENT '仓库编号',
    `quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '库存数量',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_sku_warehouse` (`sku_id`, `warehouse_id`),
    INDEX `idx_sku_id` (`sku_id`),
    INDEX `idx_warehouse_id` (`warehouse_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 库存';

-- =============================================
-- Table: wms_inventory_history (WMS 库存流水)
-- =============================================
DROP TABLE IF EXISTS `wms_inventory_history`;
CREATE TABLE `wms_inventory_history` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `warehouse_id` bigint(20) NOT NULL COMMENT '仓库编号',
    `sku_id` bigint(20) NOT NULL COMMENT '商品 SKU 编号',
    `quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '库存变化数量',
    `before_quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '变化前库存数量',
    `after_quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '变化后库存数量',
    `price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '单价',
    `total_price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '库存变化金额',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `order_id` bigint(20) DEFAULT NULL COMMENT '单据编号',
    `order_no` varchar(64) DEFAULT '' COMMENT '单据号',
    `order_type` tinyint(4) DEFAULT NULL COMMENT '单据类型',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_warehouse_id` (`warehouse_id`),
    INDEX `idx_sku_id` (`sku_id`),
    INDEX `idx_order_id` (`order_id`),
    INDEX `idx_order_type` (`order_type`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 库存流水';

-- =============================================
-- Table: wms_item_brand (WMS 商品品牌)
-- =============================================
DROP TABLE IF EXISTS `wms_item_brand`;
CREATE TABLE `wms_item_brand` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '品牌编号',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '品牌名称',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_code` (`code`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 商品品牌';

-- =============================================
-- Table: wms_item_category (WMS 商品分类)
-- =============================================
DROP TABLE IF EXISTS `wms_item_category`;
CREATE TABLE `wms_item_category` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父级编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '分类编号',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '分类名称',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_parent_id` (`parent_id`),
    INDEX `idx_code` (`code`),
    INDEX `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 商品分类';

-- =============================================
-- Table: wms_item (WMS 商品)
-- =============================================
DROP TABLE IF EXISTS `wms_item`;
CREATE TABLE `wms_item` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '商品编号',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '商品名称',
    `unit` varchar(32) NOT NULL DEFAULT '' COMMENT '单位',
    `category_id` bigint(20) DEFAULT NULL COMMENT '商品分类编号',
    `brand_id` bigint(20) DEFAULT NULL COMMENT '商品品牌编号',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_code` (`code`),
    INDEX `idx_category_id` (`category_id`),
    INDEX `idx_brand_id` (`brand_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 商品';

-- =============================================
-- Table: wms_item_sku (WMS 商品 SKU)
-- =============================================
DROP TABLE IF EXISTS `wms_item_sku`;
CREATE TABLE `wms_item_sku` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '规格名称',
    `item_id` bigint(20) NOT NULL COMMENT '商品编号',
    `bar_code` varchar(64) DEFAULT '' COMMENT '条码',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '规格编号',
    `length` decimal(24,6) DEFAULT NULL COMMENT '长，单位 cm',
    `width` decimal(24,6) DEFAULT NULL COMMENT '宽，单位 cm',
    `height` decimal(24,6) DEFAULT NULL COMMENT '高，单位 cm',
    `gross_weight` decimal(24,6) DEFAULT NULL COMMENT '毛重，单位 kg',
    `net_weight` decimal(24,6) DEFAULT NULL COMMENT '净重，单位 kg',
    `cost_price` decimal(24,6) DEFAULT NULL COMMENT '成本价，单位元',
    `selling_price` decimal(24,6) DEFAULT NULL COMMENT '销售价，单位元',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_item_id` (`item_id`),
    INDEX `idx_code` (`code`),
    INDEX `idx_bar_code` (`bar_code`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 商品 SKU';

-- =============================================
-- Table: wms_merchant (WMS 往来企业)
-- =============================================
DROP TABLE IF EXISTS `wms_merchant`;
CREATE TABLE `wms_merchant` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '往来企业编号',
    `name` varchar(255) NOT NULL DEFAULT '' COMMENT '往来企业名称',
    `type` tinyint(4) NOT NULL COMMENT '往来企业类型',
    `level` varchar(32) DEFAULT '' COMMENT '级别',
    `bank_name` varchar(255) DEFAULT '' COMMENT '开户行',
    `bank_account` varchar(64) DEFAULT '' COMMENT '银行账户',
    `address` varchar(500) DEFAULT '' COMMENT '地址',
    `mobile` varchar(20) DEFAULT '' COMMENT '手机号',
    `telephone` varchar(20) DEFAULT '' COMMENT '座机号',
    `contact` varchar(100) DEFAULT '' COMMENT '联系人',
    `email` varchar(100) DEFAULT '' COMMENT 'Email',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_code` (`code`),
    INDEX `idx_type` (`type`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 往来企业';

-- =============================================
-- Table: wms_warehouse (WMS 仓库)
-- =============================================
DROP TABLE IF EXISTS `wms_warehouse`;
CREATE TABLE `wms_warehouse` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `code` varchar(64) NOT NULL DEFAULT '' COMMENT '仓库编号',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_code` (`code`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 仓库';

-- =============================================
-- Table: wms_check_order (WMS 盘库单)
-- =============================================
DROP TABLE IF EXISTS `wms_check_order`;
CREATE TABLE `wms_check_order` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `no` varchar(64) NOT NULL DEFAULT '' COMMENT '盘库单号',
    `order_time` datetime NOT NULL COMMENT '单据日期',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '盘库状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `warehouse_id` bigint(20) NOT NULL COMMENT '仓库编号',
    `total_quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '盈亏数量（实盘数量 - 账面数量）',
    `total_price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '总金额（账面数量 * 单价）',
    `actual_price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '实际金额（实盘数量 * 单价）',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_no` (`no`),
    INDEX `idx_warehouse_id` (`warehouse_id`),
    INDEX `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 盘库单';

-- =============================================
-- Table: wms_check_order_detail (WMS 盘库单明细)
-- =============================================
DROP TABLE IF EXISTS `wms_check_order_detail`;
CREATE TABLE `wms_check_order_detail` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `order_id` bigint(20) NOT NULL COMMENT '盘库单编号',
    `sku_id` bigint(20) NOT NULL COMMENT '商品 SKU 编号',
    `warehouse_id` bigint(20) NOT NULL COMMENT '仓库编号',
    `inventory_id` bigint(20) DEFAULT NULL COMMENT '库存编号',
    `receipt_time` datetime DEFAULT NULL COMMENT '入库时间',
    `quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '账面数量',
    `check_quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '实盘数量',
    `price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '单价',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_order_id` (`order_id`),
    INDEX `idx_sku_id` (`sku_id`),
    INDEX `idx_warehouse_id` (`warehouse_id`),
    INDEX `idx_inventory_id` (`inventory_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 盘库单明细';

-- =============================================
-- Table: wms_movement_order (WMS 移库单)
-- =============================================
DROP TABLE IF EXISTS `wms_movement_order`;
CREATE TABLE `wms_movement_order` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `no` varchar(64) NOT NULL DEFAULT '' COMMENT '移库单号',
    `order_time` datetime NOT NULL COMMENT '单据日期',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '移库状态',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `source_warehouse_id` bigint(20) NOT NULL COMMENT '来源仓库编号',
    `target_warehouse_id` bigint(20) NOT NULL COMMENT '目标仓库编号',
    `total_quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '总数量',
    `total_price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '总金额',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_no` (`no`),
    INDEX `idx_source_warehouse_id` (`source_warehouse_id`),
    INDEX `idx_target_warehouse_id` (`target_warehouse_id`),
    INDEX `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 移库单';

-- =============================================
-- Table: wms_movement_order_detail (WMS 移库单明细)
-- =============================================
DROP TABLE IF EXISTS `wms_movement_order_detail`;
CREATE TABLE `wms_movement_order_detail` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `order_id` bigint(20) NOT NULL COMMENT '移库单编号',
    `sku_id` bigint(20) NOT NULL COMMENT '商品 SKU 编号',
    `source_warehouse_id` bigint(20) NOT NULL COMMENT '来源仓库编号',
    `target_warehouse_id` bigint(20) NOT NULL COMMENT '目标仓库编号',
    `quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '移库数量',
    `price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '单价',
    `total_price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '行金额（数量 * 单价）',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_order_id` (`order_id`),
    INDEX `idx_sku_id` (`sku_id`),
    INDEX `idx_source_warehouse_id` (`source_warehouse_id`),
    INDEX `idx_target_warehouse_id` (`target_warehouse_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 移库单明细';

-- =============================================
-- Table: wms_receipt_order (WMS 入库单)
-- =============================================
DROP TABLE IF EXISTS `wms_receipt_order`;
CREATE TABLE `wms_receipt_order` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `no` varchar(64) NOT NULL DEFAULT '' COMMENT '入库单号',
    `type` tinyint(4) NOT NULL COMMENT '入库类型',
    `order_time` datetime NOT NULL COMMENT '单据日期',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '入库状态',
    `biz_order_no` varchar(64) DEFAULT '' COMMENT '业务订单号',
    `merchant_id` bigint(20) DEFAULT NULL COMMENT '供应商编号',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `warehouse_id` bigint(20) NOT NULL COMMENT '仓库编号',
    `total_quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '总数量',
    `total_price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '总金额',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_no` (`no`),
    INDEX `idx_warehouse_id` (`warehouse_id`),
    INDEX `idx_merchant_id` (`merchant_id`),
    INDEX `idx_status` (`status`),
    INDEX `idx_type` (`type`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 入库单';

-- =============================================
-- Table: wms_receipt_order_detail (WMS 入库单明细)
-- =============================================
DROP TABLE IF EXISTS `wms_receipt_order_detail`;
CREATE TABLE `wms_receipt_order_detail` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `order_id` bigint(20) NOT NULL COMMENT '入库单编号',
    `sku_id` bigint(20) NOT NULL COMMENT '商品 SKU 编号',
    `warehouse_id` bigint(20) NOT NULL COMMENT '仓库编号',
    `quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '入库数量',
    `price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '单价',
    `total_price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '行金额（数量 * 单价）',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_order_id` (`order_id`),
    INDEX `idx_sku_id` (`sku_id`),
    INDEX `idx_warehouse_id` (`warehouse_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 入库单明细';

-- =============================================
-- Table: wms_shipment_order (WMS 出库单)
-- =============================================
DROP TABLE IF EXISTS `wms_shipment_order`;
CREATE TABLE `wms_shipment_order` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `no` varchar(64) NOT NULL DEFAULT '' COMMENT '出库单号',
    `type` tinyint(4) NOT NULL COMMENT '出库类型',
    `order_time` datetime NOT NULL COMMENT '单据日期',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '出库状态',
    `biz_order_no` varchar(64) DEFAULT '' COMMENT '业务订单号',
    `merchant_id` bigint(20) DEFAULT NULL COMMENT '客户编号',
    `remark` varchar(500) DEFAULT '' COMMENT '备注',
    `warehouse_id` bigint(20) NOT NULL COMMENT '仓库编号',
    `total_quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '总数量',
    `total_price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '总金额',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_no` (`no`),
    INDEX `idx_warehouse_id` (`warehouse_id`),
    INDEX `idx_merchant_id` (`merchant_id`),
    INDEX `idx_status` (`status`),
    INDEX `idx_type` (`type`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 出库单';

-- =============================================
-- Table: wms_shipment_order_detail (WMS 出库单明细)
-- =============================================
DROP TABLE IF EXISTS `wms_shipment_order_detail`;
CREATE TABLE `wms_shipment_order_detail` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `order_id` bigint(20) NOT NULL COMMENT '出库单编号',
    `sku_id` bigint(20) NOT NULL COMMENT '商品 SKU 编号',
    `warehouse_id` bigint(20) NOT NULL COMMENT '仓库编号',
    `quantity` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '出库数量',
    `price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '单价',
    `total_price` decimal(24,6) NOT NULL DEFAULT 0.000000 COMMENT '行金额（数量 * 单价）',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_order_id` (`order_id`),
    INDEX `idx_sku_id` (`sku_id`),
    INDEX `idx_warehouse_id` (`warehouse_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'WMS 出库单明细';
