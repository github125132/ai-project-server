package cn.iocoder.yudao.module.gap.controller.admin.variety;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.variety.vo.GapVarietyPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.variety.vo.GapVarietyRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.variety.vo.GapVarietySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.variety.GapVarietyDO;
import cn.iocoder.yudao.module.gap.service.variety.GapVarietyService;
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

@Tag(name = "管理后台 - GAP 品种档案")
@RestController
@RequestMapping("/gap/variety")
@Validated
public class GapVarietyController {

    @Resource
    private GapVarietyService varietyService;

    @PostMapping("/create")
    @Operation(summary = "创建品种档案")
    @PreAuthorize("@ss.hasPermission('gap:variety:create')")
    public CommonResult<Long> createVariety(@Valid @RequestBody GapVarietySaveReqVO createReqVO) {
        return success(varietyService.createVariety(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新品种档案")
    @PreAuthorize("@ss.hasPermission('gap:variety:update')")
    public CommonResult<Boolean> updateVariety(@Valid @RequestBody GapVarietySaveReqVO updateReqVO) {
        varietyService.updateVariety(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除品种档案")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:variety:delete')")
    public CommonResult<Boolean> deleteVariety(@RequestParam("id") Long id) {
        varietyService.deleteVariety(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得品种档案")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:variety:query')")
    public CommonResult<GapVarietyRespVO> getVariety(@RequestParam("id") Long id) {
        GapVarietyDO variety = varietyService.getVariety(id);
        return success(BeanUtils.toBean(variety, GapVarietyRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得品种档案分页")
    @PreAuthorize("@ss.hasPermission('gap:variety:query')")
    public CommonResult<PageResult<GapVarietyRespVO>> getVarietyPage(@Valid GapVarietyPageReqVO pageReqVO) {
        PageResult<GapVarietyDO> pageResult = varietyService.getVarietyPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapVarietyRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得品种档案列表")
    @PreAuthorize("@ss.hasPermission('gap:variety:query')")
    public CommonResult<List<GapVarietyRespVO>> getVarietyList() {
        List<GapVarietyDO> list = varietyService.getVarietyList();
        return success(BeanUtils.toBean(list, GapVarietyRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出品种档案 Excel")
    @PreAuthorize("@ss.hasPermission('gap:variety:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportVarietyExcel(@Valid GapVarietyPageReqVO pageReqVO,
                                   HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapVarietyDO> list = varietyService.getVarietyPage(pageReqVO).getList();
        ExcelUtils.write(response, "品种档案.xls", "数据", GapVarietyRespVO.class,
                BeanUtils.toBean(list, GapVarietyRespVO.class));
    }

}
