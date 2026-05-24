-- MySQL DDL for module: yudao-module-mp

-- =============================================
-- 公众号账号表
-- =============================================
DROP TABLE IF EXISTS `mp_account`;
CREATE TABLE `mp_account` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) DEFAULT NULL COMMENT '公众号名称',
    `account` varchar(100) DEFAULT NULL COMMENT '公众号账号',
    `app_id` varchar(100) DEFAULT NULL COMMENT '公众号appid',
    `app_secret` varchar(100) DEFAULT NULL COMMENT '公众号密钥',
    `token` varchar(100) DEFAULT NULL COMMENT '公众号token',
    `aes_key` varchar(100) DEFAULT NULL COMMENT '消息加解密密钥',
    `qr_code_url` varchar(500) DEFAULT NULL COMMENT '二维码图片URL',
    `remark` varchar(500) DEFAULT NULL COMMENT '备注',
    `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_tenant_id` (`tenant_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公众号账号';

-- =============================================
-- 公众号素材表
-- =============================================
DROP TABLE IF EXISTS `mp_material`;
CREATE TABLE `mp_material` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `account_id` bigint(20) DEFAULT NULL COMMENT '公众号账号的编号',
    `app_id` varchar(100) DEFAULT NULL COMMENT '公众号appId',
    `media_id` varchar(100) DEFAULT NULL COMMENT '公众号素材id',
    `type` varchar(32) DEFAULT NULL COMMENT '文件类型',
    `permanent` bit(1) DEFAULT NULL COMMENT '是否永久',
    `url` varchar(500) DEFAULT NULL COMMENT '文件服务器的URL',
    `name` varchar(255) DEFAULT NULL COMMENT '名字',
    `mp_url` varchar(500) DEFAULT NULL COMMENT '公众号文件URL',
    `title` varchar(255) DEFAULT NULL COMMENT '视频素材的标题',
    `introduction` varchar(500) DEFAULT NULL COMMENT '视频素材的描述',
    `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_account_id` (`account_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公众号素材';

-- =============================================
-- 公众号菜单表
-- =============================================
DROP TABLE IF EXISTS `mp_menu`;
CREATE TABLE `mp_menu` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `account_id` bigint(20) DEFAULT NULL COMMENT '公众号账号的编号',
    `app_id` varchar(100) DEFAULT NULL COMMENT '公众号appId',
    `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
    `menu_key` varchar(100) DEFAULT NULL COMMENT '菜单标识',
    `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单编号',
    `type` varchar(32) DEFAULT NULL COMMENT '按钮类型',
    `url` varchar(1024) DEFAULT NULL COMMENT '网页链接',
    `mini_program_app_id` varchar(100) DEFAULT NULL COMMENT '小程序的appId',
    `mini_program_page_path` varchar(500) DEFAULT NULL COMMENT '小程序的页面路径',
    `article_id` varchar(100) DEFAULT NULL COMMENT '跳转图文的媒体编号',
    `reply_message_type` varchar(32) DEFAULT NULL COMMENT '消息类型',
    `reply_content` text DEFAULT NULL COMMENT '回复的消息内容',
    `reply_media_id` varchar(100) DEFAULT NULL COMMENT '回复的媒体id',
    `reply_media_url` varchar(500) DEFAULT NULL COMMENT '回复的媒体URL',
    `reply_title` varchar(255) DEFAULT NULL COMMENT '回复的标题',
    `reply_description` varchar(500) DEFAULT NULL COMMENT '回复的描述',
    `reply_thumb_media_id` varchar(100) DEFAULT NULL COMMENT '回复的缩略图的媒体id',
    `reply_thumb_media_url` varchar(500) DEFAULT NULL COMMENT '回复的缩略图的媒体URL',
    `reply_articles` text DEFAULT NULL COMMENT '回复的图文消息数组',
    `reply_music_url` varchar(500) DEFAULT NULL COMMENT '回复的音乐链接',
    `reply_hq_music_url` varchar(500) DEFAULT NULL COMMENT '回复的高质量音乐链接',
    `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_account_id` (`account_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公众号菜单';

-- =============================================
-- 公众号消息自动回复表
-- =============================================
DROP TABLE IF EXISTS `mp_auto_reply`;
CREATE TABLE `mp_auto_reply` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `account_id` bigint(20) DEFAULT NULL COMMENT '公众号账号的编号',
    `app_id` varchar(100) DEFAULT NULL COMMENT '公众号appId',
    `type` int(11) DEFAULT NULL COMMENT '回复类型',
    `request_keyword` varchar(255) DEFAULT NULL COMMENT '请求的关键字',
    `request_match` int(11) DEFAULT NULL COMMENT '请求的关键字的匹配',
    `request_message_type` varchar(32) DEFAULT NULL COMMENT '请求的消息类型',
    `response_message_type` varchar(32) DEFAULT NULL COMMENT '回复的消息类型',
    `response_content` text DEFAULT NULL COMMENT '回复的消息内容',
    `response_media_id` varchar(100) DEFAULT NULL COMMENT '回复的媒体id',
    `response_media_url` varchar(500) DEFAULT NULL COMMENT '回复的媒体URL',
    `response_title` varchar(255) DEFAULT NULL COMMENT '回复的标题',
    `response_description` varchar(500) DEFAULT NULL COMMENT '回复的描述',
    `response_thumb_media_id` varchar(100) DEFAULT NULL COMMENT '回复的缩略图的媒体id',
    `response_thumb_media_url` varchar(500) DEFAULT NULL COMMENT '回复的缩略图的媒体URL',
    `response_articles` text DEFAULT NULL COMMENT '回复的图文消息',
    `response_music_url` varchar(500) DEFAULT NULL COMMENT '回复的音乐链接',
    `response_hq_music_url` varchar(500) DEFAULT NULL COMMENT '回复的高质量音乐链接',
    `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_account_id` (`account_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公众号消息自动回复';

-- =============================================
-- 公众号消息表
-- =============================================
DROP TABLE IF EXISTS `mp_message`;
CREATE TABLE `mp_message` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `msg_id` bigint(20) DEFAULT NULL COMMENT '微信公众号消息id',
    `account_id` bigint(20) DEFAULT NULL COMMENT '公众号账号的ID',
    `app_id` varchar(100) DEFAULT NULL COMMENT '公众号appid',
    `user_id` bigint(20) DEFAULT NULL COMMENT '公众号粉丝的编号',
    `openid` varchar(100) DEFAULT NULL COMMENT '公众号粉丝标志',
    `type` varchar(32) DEFAULT NULL COMMENT '消息类型',
    `send_from` int(11) DEFAULT NULL COMMENT '消息来源',
    `content` text DEFAULT NULL COMMENT '消息内容',
    `media_id` varchar(100) DEFAULT NULL COMMENT '媒体文件的编号',
    `media_url` varchar(500) DEFAULT NULL COMMENT '媒体文件的URL',
    `recognition` varchar(500) DEFAULT NULL COMMENT '语音识别后文本',
    `format` varchar(32) DEFAULT NULL COMMENT '语音格式',
    `title` varchar(255) DEFAULT NULL COMMENT '标题',
    `description` varchar(500) DEFAULT NULL COMMENT '描述',
    `thumb_media_id` varchar(100) DEFAULT NULL COMMENT '缩略图的媒体id',
    `thumb_media_url` varchar(500) DEFAULT NULL COMMENT '缩略图的媒体URL',
    `url` varchar(500) DEFAULT NULL COMMENT '点击图文消息跳转链接',
    `location_x` double DEFAULT NULL COMMENT '地理位置维度',
    `location_y` double DEFAULT NULL COMMENT '地理位置经度',
    `scale` double DEFAULT NULL COMMENT '地图缩放大小',
    `label` varchar(255) DEFAULT NULL COMMENT '详细地址',
    `articles` text DEFAULT NULL COMMENT '图文消息数组',
    `music_url` varchar(500) DEFAULT NULL COMMENT '音乐链接',
    `hq_music_url` varchar(500) DEFAULT NULL COMMENT '高质量音乐链接',
    `event` varchar(32) DEFAULT NULL COMMENT '事件类型',
    `event_key` varchar(255) DEFAULT NULL COMMENT '事件Key',
    `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_account_id` (`account_id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_msg_id` (`msg_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公众号消息';

-- =============================================
-- 公众号模板消息表
-- =============================================
DROP TABLE IF EXISTS `mp_message_template`;
CREATE TABLE `mp_message_template` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `account_id` bigint(20) DEFAULT NULL COMMENT '公众号账号的编号',
    `app_id` varchar(100) DEFAULT NULL COMMENT '公众号appId',
    `template_id` varchar(100) DEFAULT NULL COMMENT '公众号模板ID',
    `title` varchar(255) DEFAULT NULL COMMENT '标题',
    `content` text DEFAULT NULL COMMENT '模板内容',
    `example` text DEFAULT NULL COMMENT '模板示例',
    `primary_industry` varchar(255) DEFAULT NULL COMMENT '模板所属行业的一级行业',
    `deputy_industry` varchar(255) DEFAULT NULL COMMENT '模板所属行业的二级行业',
    `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_account_id` (`account_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公众号模板消息';

-- =============================================
-- 公众号标签表
-- =============================================
DROP TABLE IF EXISTS `mp_tag`;
CREATE TABLE `mp_tag` (
    `id` bigint(20) NOT NULL COMMENT '主键',
    `tag_id` bigint(20) DEFAULT NULL COMMENT '公众号标签id',
    `name` varchar(100) DEFAULT NULL COMMENT '标签名',
    `count` int(11) DEFAULT NULL COMMENT '此标签下粉丝数',
    `account_id` bigint(20) DEFAULT NULL COMMENT '公众号账号的编号',
    `app_id` varchar(100) DEFAULT NULL COMMENT '公众号appId',
    `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_account_id` (`account_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公众号标签';

-- =============================================
-- 微信公众号粉丝表
-- =============================================
DROP TABLE IF EXISTS `mp_user`;
CREATE TABLE `mp_user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `openid` varchar(100) DEFAULT NULL COMMENT '粉丝标识',
    `union_id` varchar(100) DEFAULT NULL COMMENT '微信生态唯一标识',
    `subscribe_status` int(11) DEFAULT NULL COMMENT '关注状态',
    `subscribe_time` datetime DEFAULT NULL COMMENT '关注时间',
    `unsubscribe_time` datetime DEFAULT NULL COMMENT '取消关注时间',
    `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
    `head_image_url` varchar(500) DEFAULT NULL COMMENT '头像地址',
    `language` varchar(32) DEFAULT NULL COMMENT '语言',
    `country` varchar(100) DEFAULT NULL COMMENT '国家',
    `province` varchar(100) DEFAULT NULL COMMENT '省份',
    `city` varchar(100) DEFAULT NULL COMMENT '城市',
    `remark` varchar(500) DEFAULT NULL COMMENT '备注',
    `tag_ids` varchar(2000) DEFAULT NULL COMMENT '标签编号数组',
    `account_id` bigint(20) DEFAULT NULL COMMENT '公众号账号的编号',
    `app_id` varchar(100) DEFAULT NULL COMMENT '公众号appId',
    `creator` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_account_id` (`account_id`) USING BTREE,
    INDEX `idx_openid` (`openid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='微信公众号粉丝';
