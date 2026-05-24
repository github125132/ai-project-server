package cn.iocoder.yudao.module.gap.controller.admin.input;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputUseRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputUseRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputUseRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputUseRecordDO;
import cn.iocoder.yudao.module.gap.service.input.GapInputUseRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP 投入品使用记录")
@RestController
@RequestMapping("/gap/input-use-record")
@Validated
public class GapInputUseRecordController {

    @Resource
    private GapInputUseRecordService inputUseRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建投入品使用记录")
    @PreAuthorize("@ss.hasPermission('gap:input-use-record:create')")
    public CommonResult<Long> createInputUseRecord(@Valid @RequestBody GapInputUseRecordSaveReqVO createReqVO) {
        return success(inputUseRecordService.createInputUseRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新投入品使用记录")
    @PreAuthorize("@ss.hasPermission('gap:input-use-record:update')")
    public CommonResult<Boolean> updateInputUseRecord(@Valid @RequestBody GapInputUseRecordSaveReqVO updateReqVO) {
        inputUseRecordService.updateInputUseRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除投入品使用记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:input-use-record:delete')")
    public CommonResult<Boolean> deleteInputUseRecord(@RequestParam("id") Long id) {
        inputUseRecordService.deleteInputUseRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得投入品使用记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:input-use-record:query')")
    public CommonResult<GapInputUseRecordRespVO> getInputUseRecord(@RequestParam("id") Long id) {
        GapInputUseRecordDO record = inputUseRecordService.getInputUseRecord(id);
        return success(BeanUtils.toBean(record, GapInputUseRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得投入品使用记录分页")
    @PreAuthorize("@ss.hasPermission('gap:input-use-record:query')")
    public CommonResult<PageResult<GapInputUseRecordRespVO>> getInputUseRecordPage(@Valid GapInputUseRecordPageReqVO pageReqVO) {
        PageResult<GapInputUseRecordDO> pageResult = inputUseRecordService.getInputUseRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapInputUseRecordRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得投入品使用记录列表")
    @PreAuthorize("@ss.hasPermission('gap:input-use-record:query')")
    public CommonResult<List<GapInputUseRecordRespVO>> getInputUseRecordList() {
        List<GapInputUseRecordDO> list = inputUseRecordService.getInputUseRecordList();
        return success(BeanUtils.toBean(list, GapInputUseRecordRespVO.class));
    }

    @GetMapping("/list-by-base")
    @Operation(summary = "根据基地编号获得使用记录列表")
    @Parameter(name = "baseId", description = "基地编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:input-use-record:query')")
    public CommonResult<List<GapInputUseRecordRespVO>> getInputUseRecordListByBaseId(@RequestParam("baseId") Long baseId) {
        List<GapInputUseRecordDO> list = inputUseRecordService.getInputUseRecordListByBaseId(baseId);
        return success(BeanUtils.toBean(list, GapInputUseRecordRespVO.class));
    }

    @GetMapping("/list-by-plot")
    @Operation(summary = "根据地块编号获得使用记录列表")
    @Parameter(name = "plotId", description = "地块编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:input-use-record:query')")
    public CommonResult<List<GapInputUseRecordRespVO>> getInputUseRecordListByPlotId(@RequestParam("plotId") Long plotId) {
        List<GapInputUseRecordDO> list = inputUseRecordService.getInputUseRecordListByPlotId(plotId);
        return success(BeanUtils.toBean(list, GapInputUseRecordRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出投入品使用记录 Excel")
    @PreAuthorize("@ss.hasPermission('gap:input-use-record:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportInputUseRecordExcel(@Valid GapInputUseRecordPageReqVO pageReqVO,
                                           HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapInputUseRecordDO> list = inputUseRecordService.getInputUseRecordPage(pageReqVO).getList();
        ExcelUtils.write(response, "投入品使用记录.xls", "数据", GapInputUseRecordRespVO.class,
                BeanUtils.toBean(list, GapInputUseRecordRespVO.class));
    }

}
