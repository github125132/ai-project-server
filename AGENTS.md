# {{SUBREPO_BACKEND_DIR}} 后端

基于 [ruoyi-vue-pro](https://gitee.com/zhijiantianya/ruoyi-vue-pro) `master-jdk17` 分支构建的后端服务，为 PC 管理后台、移动端 APP、大屏驾驶舱和外部 H5 提供统一 API。

## 技术栈

- Java 17 + Spring Boot 3 + Maven
- MySQL + MyBatis-Plus + Redis + Redisson
- Spring Security + Token 认证
- Flowable 工作流（按需）
- MapStruct + Lombok
- Swagger/OpenAPI 接口文档

## 模块结构

| 模块 | 说明 | 是否启用 |
|------|------|----------|
| `yudao-dependencies` | 依赖版本管理 | 是 |
| `yudao-framework` | 框架核心（web/security/mybatis/redis/mq 等 starter） | 是 |
| `yudao-server` | 启动入口 | 是 |
| `yudao-module-system` | 系统管理（用户、角色、菜单、租户、字典） | 是 |
| `yudao-module-infra` | 基础设施（配置、文件、日志、定时任务、代码生成） | 是 |
| `yudao-module-bpm` | 工作流程 | 按需启用 |
| `yudao-module-report` | 报表 | 按需启用 |
| `yudao-module-mp` | 微信公众号 | 按需启用 |
| `yudao-module-pay` | 支付 | 按需启用 |
| `yudao-module-mall` | 商城 | 按需启用 |
| `yudao-module-crm` | CRM | 按需启用 |
| `yudao-module-erp` | ERP | 按需启用 |
| `yudao-module-iot` | IoT 物联网 | 按需启用 |
| `yudao-module-mes` | MES 制造 | 按需启用 |
| `yudao-module-ai` | AI 大模型 | 按需启用 |
| `{{BACKEND_MODULE_NAME}}` | 本项目业务模块 | 规划新增 |

未启用的模块可在根 `pom.xml` 中取消注释来激活。业务代码优先放入独立 `{{BACKEND_MODULE_NAME}}` 模块，禁止散落到 `system`、`infra`、`framework` 等通用模块中。

## 包结构约定（业务模块）

```text
{{BACKEND_PACKAGE}}
├── controller/admin/{domain}/vo/   # PC 管理后台 API，路径前缀 {{API_PREFIX_ADMIN}}
├── controller/app/{domain}/vo/     # 移动端/H5 API，路径前缀 {{API_PREFIX_APP}}
├── api/{domain}/                   # 模块间 API 接口 + DTO
├── service/{domain}/               # 业务接口
├── service/impl/{domain}/          # 业务实现
├── dal/dataobject/{domain}/        # 数据库实体 DO
├── dal/mysql/{domain}/             # Mapper 接口
├── convert/{domain}/               # MapStruct 转换器
├── enums/                          # 枚举 + ErrorCodeConstants
├── job/                            # 定时任务
├── mq/                             # 消息队列
└── framework/                      # 模块内框架代码
```

## 编码规范

### 分层职责

- **Controller**：参数接收、权限控制（`@PreAuthorize`）、Swagger 注解（`@Tag`/`@Operation`）、调用 Service、返回结果。不得编写业务逻辑或状态流转。
- **Service**：业务校验、事务管理、状态流转、审计留痕、跨 Mapper 协调。
- **Mapper**：继承 `BaseMapperX`，查询使用 `LambdaQueryWrapperX` 的 `eqIfPresent`/`likeIfPresent`/`betweenIfPresent`。
- **DO**：继承 `BaseDO`，字段注释中文，状态字段注释引用对应枚举。
- **VO**：使用 `@Schema` 和 jakarta validation，校验提示中文。
- **Convert**：优先使用 `BeanUtils.toBean` 或 MapStruct `XxxConvert.INSTANCE`。
- **ErrorCode**：集中维护在模块 `enums/ErrorCodeConstants.java`，错误信息中文。

### 路径命名

- 管理端 API：`{{API_PREFIX_ADMIN}}/{功能}`
- 移动端/H5 API：`{{API_PREFIX_APP}}/{功能}`
- 常规 CRUD 路径：`/create`、`/update`、`/delete`、`/delete-list`、`/get`、`/page`、`/export-excel`
- 类名大驼峰，方法名小驼峰，URL 路径使用短横线 `-` 分隔

### 返回值

- 统一使用 `CommonResult<T>` 包装
- 分页查询使用 `PageResult<T>`
- 字典数据返回 `label` + `value` 结构
- 涉及状态、类型、结论、阶段等字段时，按根仓"状态字段双轨规则"决定返回方式

### 状态枚举与魔法数（强制）

- **禁止**使用魔法数或裸字符串判断、更新业务状态（如 `status == 1`、`"APPROVED".equals(status)`）
- 固定且影响流程的状态 → 定义枚举；可运营配置的分类 → 使用系统字典
- 状态判断必须通过枚举方法（如 `XxxStatusEnum.PENDING.eq(status)`）
- 状态更新必须设置枚举值（如 `XxxStatusEnum.APPROVED.getStatus()`）
- 审核、归档、整改等关键状态流转必须在 Service 层完成，保留操作人、操作时间、原因
- 新增状态字段时，同步补充枚举、中文名称、接口展示字段和状态流转校验

### 数据库表命名

- 业务表使用 `{{PROJECT_CODE}}_` 前缀
- 必须包含基础字段：`id`、`creator`、`create_time`、`updater`、`update_time`、`deleted`、`tenant_id`
- 业务字段注释使用中文，类名和变量名使用英文

### 权限与接口文档

- 所有管理端接口添加 `@PreAuthorize` 权限控制
- 所有 API 接口添加 Swagger 注解
- 权限码格式：`{{PERM_PREFIX}}:{模块}:{动作}`（如 `{{PERM_PREFIX}}:base:query`）

## 新增业务模块步骤

1. 在根 `pom.xml` 的 `<modules>` 中添加 `{{BACKEND_MODULE_NAME}}`
2. 创建 `{{BACKEND_MODULE_NAME}}` 目录和模块 `pom.xml`
3. 在 `yudao-server/pom.xml` 中添加 `{{BACKEND_MODULE_NAME}}` 依赖
4. 按包结构创建业务代码
5. 使用代码生成器生成基础 CRUD，再按业务规则手动调整
6. 在系统菜单中配置 PC 管理后台菜单和权限码

## 关键配置文件

- 应用配置：`yudao-server/src/main/resources/application.yaml`
- 多环境配置：`application-local.yaml`、`application-dev.yaml`（含敏感信息的 local 配置文件不进仓库）
- 数据库配置：`spring.datasource.dynamic.datasource.master`
- Redis 配置：`spring.data.redis`

## Git 远端管理

本子仓采用双远端策略：

- `upstream`：保留框架上游仓库，用于同步框架更新
- `origin`：指向内网业务仓库，用于日常开发提交

初始化命令模板（首次克隆后执行）：

```bash
git remote rename origin upstream
git remote add origin "http://${GIT_INTERNAL_USER}@${GIT_INTERNAL_HOST}/{{GIT_INTERNAL_GROUP}}/{{SUBREPO_BACKEND_DIR}}.git"
git config user.name  "$GIT_USER_NAME"
git config user.email "$GIT_USER_EMAIL"
```

同步上游框架更新：

```bash
git fetch upstream
git merge upstream/master-jdk17
```

环境变量（`GIT_INTERNAL_HOST`、`GIT_INTERNAL_USER`、`GIT_USER_NAME`、`GIT_USER_EMAIL`）由根仓 `.env` 注入。

当前默认分支：`master-jdk17`

## 提交规范

与根仓一致：`{类型}: {模块}: {简述}`。类型见根仓 `docs/02-Git仓库初始化引导.md` 第 8 节。

## 禁止事项

- 不得修改 `yudao-framework` 核心代码（除非明确是框架级 bug）
- 不得把业务代码散落到 `system`、`infra`、`framework` 等通用模块
- 不得在 Controller 层编写状态流转逻辑
- 不得使用魔法数或裸字符串判断/更新状态
- 不得提交含真实密码的 `application-local.yaml`
- 不得将子仓源码提交到根仓
