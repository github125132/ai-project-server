package cn.iocoder.yudao.module.gap.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * GAP 错误码枚举类
 * <p>
 * gap 系统，使用 1-050-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== GAP 基础数据-基地信息（1-050-100-000） ==========
    ErrorCode BASE_NOT_EXISTS = new ErrorCode(1_050_100_000, "基地信息不存在");
    ErrorCode BASE_CODE_DUPLICATE = new ErrorCode(1_050_100_001, "基地编码已存在");
    ErrorCode BASE_NAME_DUPLICATE = new ErrorCode(1_050_100_002, "基地名称已存在");

    // ========== GAP 基础数据-地块信息（1-050-101-000） ==========
    ErrorCode PLOT_NOT_EXISTS = new ErrorCode(1_050_101_000, "地块信息不存在");
    ErrorCode PLOT_CODE_DUPLICATE = new ErrorCode(1_050_101_001, "地块编码已存在");

    // ========== GAP 基础数据-品种档案（1-050-102-000） ==========
    ErrorCode VARIETY_NOT_EXISTS = new ErrorCode(1_050_102_000, "品种档案不存在");
    ErrorCode VARIETY_CODE_DUPLICATE = new ErrorCode(1_050_102_001, "品种编码已存在");

    // ========== GAP 基础数据-种子种苗批次（1-050-103-000） ==========
    ErrorCode SEED_BATCH_NOT_EXISTS = new ErrorCode(1_050_103_000, "种子种苗批次不存在");
    ErrorCode SEED_BATCH_CODE_DUPLICATE = new ErrorCode(1_050_103_001, "种子种苗批次号已存在");

    // ========== GAP 投入品管理-投入品分类（1-050-200-000） ==========
    ErrorCode INPUT_CATEGORY_NOT_EXISTS = new ErrorCode(1_050_200_000, "投入品分类不存在");
    ErrorCode INPUT_CATEGORY_EXITS_CHILDREN = new ErrorCode(1_050_200_001, "存在子分类，无法删除");
    ErrorCode INPUT_CATEGORY_PARENT_NOT_EXITS = new ErrorCode(1_050_200_002, "父级分类不存在");

    // ========== GAP 投入品管理-投入品产品（1-050-201-000） ==========
    ErrorCode INPUT_PRODUCT_NOT_EXISTS = new ErrorCode(1_050_201_000, "投入品产品不存在");
    ErrorCode INPUT_PRODUCT_CODE_DUPLICATE = new ErrorCode(1_050_201_001, "投入品编码已存在");
    ErrorCode INPUT_PRODUCT_IS_BANNED = new ErrorCode(1_050_201_002, "该投入品为禁用农药，不允许使用");

    // ========== GAP 投入品管理-供应商（1-050-202-000） ==========
    ErrorCode INPUT_SUPPLIER_NOT_EXISTS = new ErrorCode(1_050_202_000, "供应商档案不存在");
    ErrorCode INPUT_SUPPLIER_CODE_DUPLICATE = new ErrorCode(1_050_202_001, "供应商编码已存在");

    // ========== GAP 农事活动-种植计划（1-050-300-000） ==========
    ErrorCode PLANTING_PLAN_NOT_EXISTS = new ErrorCode(1_050_300_000, "种植计划不存在");

    // ========== GAP 农事活动-农事记录（1-050-301-000） ==========
    ErrorCode FARMING_RECORD_NOT_EXISTS = new ErrorCode(1_050_301_000, "农事记录不存在");

    // ========== GAP 采收加工-采收记录（1-050-400-000） ==========
    ErrorCode HARVEST_RECORD_NOT_EXISTS = new ErrorCode(1_050_400_000, "采收记录不存在");
    ErrorCode HARVEST_BATCH_NO_DUPLICATE = new ErrorCode(1_050_400_001, "采收批次号已存在");

    // ========== GAP 采收加工-加工记录（1-050-401-000） ==========
    ErrorCode PROCESS_RECORD_NOT_EXISTS = new ErrorCode(1_050_401_000, "加工记录不存在");

    // ========== GAP 质量检测-检验任务（1-050-500-000） ==========
    ErrorCode INSPECT_TASK_NOT_EXISTS = new ErrorCode(1_050_500_000, "检验任务不存在");

    // ========== GAP 质量检测-检验报告（1-050-501-000） ==========
    ErrorCode INSPECT_REPORT_NOT_EXISTS = new ErrorCode(1_050_501_000, "检验报告不存在");

    // ========== GAP 质量检测-放行审核（1-050-502-000） ==========
    ErrorCode RELEASE_NOT_EXISTS = new ErrorCode(1_050_502_000, "放行记录不存在");
    ErrorCode RELEASE_NO_PERMISSION = new ErrorCode(1_050_502_001, "只有质量负责人有权审批放行");

    // ========== GAP 质量检测-留样管理（1-050-503-000） ==========
    ErrorCode SAMPLE_RECORD_NOT_EXISTS = new ErrorCode(1_050_503_000, "留样记录不存在");

    // ========== GAP 仓储物流-仓库分区（1-050-600-000） ==========
    ErrorCode STORAGE_AREA_NOT_EXISTS = new ErrorCode(1_050_600_000, "仓库分区不存在");
    ErrorCode STORAGE_AREA_CODE_DUPLICATE = new ErrorCode(1_050_600_001, "仓库分区编码已存在");

    // ========== GAP 仓储物流-入库记录（1-050-601-000） ==========
    ErrorCode STORAGE_IN_NOT_EXISTS = new ErrorCode(1_050_601_000, "入库记录不存在");

    // ========== GAP 仓储物流-出库记录（1-050-602-000） ==========
    ErrorCode STORAGE_OUT_NOT_EXISTS = new ErrorCode(1_050_602_000, "出库记录不存在");
    ErrorCode STORAGE_OUT_BATCH_NOT_RELEASED = new ErrorCode(1_050_602_001, "批次未放行，不允许出库");

    // ========== GAP 文件体系-文件档案（1-050-700-000） ==========
    ErrorCode DOCUMENT_NOT_EXISTS = new ErrorCode(1_050_700_000, "文件档案不存在");

    // ========== GAP 培训管理-培训课程（1-050-800-000） ==========
    ErrorCode TRAINING_COURSE_NOT_EXISTS = new ErrorCode(1_050_800_000, "培训课程不存在");

    // ========== GAP 内部审核-审核计划（1-050-900-000） ==========
    ErrorCode AUDIT_PLAN_NOT_EXISTS = new ErrorCode(1_050_900_000, "审核计划不存在");

    // ========== GAP 内部审核-不符合项（1-050-901-000） ==========
    ErrorCode NC_ITEM_NOT_EXISTS = new ErrorCode(1_050_901_000, "不符合项不存在");

    // ========== GAP 变更投诉召回（1-050-910-000） ==========
    ErrorCode CHANGE_RECORD_NOT_EXISTS = new ErrorCode(1_050_910_000, "变更记录不存在");
    ErrorCode COMPLAINT_NOT_EXISTS = new ErrorCode(1_050_910_001, "投诉记录不存在");
    ErrorCode RECALL_RECORD_NOT_EXISTS = new ErrorCode(1_050_910_002, "召回记录不存在");

    // ========== GAP 溯源管理-溯源批次（1-050-920-000） ==========
    ErrorCode TRACE_BATCH_NOT_EXISTS = new ErrorCode(1_050_920_000, "溯源批次不存在");

}
