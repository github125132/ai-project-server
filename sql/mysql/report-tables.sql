-- MySQL DDL for module: report
-- Generated from DO classes in yudao-module-report/dal/dataobject/

-- =============================================
-- Table: report_go_view_project (GoView 项目表)
-- =============================================
DROP TABLE IF EXISTS `report_go_view_project`;
CREATE TABLE `report_go_view_project` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) NOT NULL DEFAULT '' COMMENT '项目名称',
    `pic_url` varchar(500) DEFAULT '' COMMENT '预览图片 URL',
    `content` longtext COMMENT '报表内容(JSON 配置)',
    `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '发布状态',
    `remark` varchar(500) DEFAULT '' COMMENT '项目备注',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`),
    INDEX `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'GoView 项目表';
