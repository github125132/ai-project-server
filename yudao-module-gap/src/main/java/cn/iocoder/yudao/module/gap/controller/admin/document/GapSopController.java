package cn.iocoder.yudao.module.gap.controller.admin.document;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapSopPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapSopRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapSopSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapSopDO;
import cn.iocoder.yudao.module.gap.service.document.GapSopService;
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

@Tag(name = "管理后台 - GAP SOP库")
@RestController
@RequestMapping("/gap/sop")
@Validated
public class GapSopController {

    @Resource
    private GapSopService sopService;

    @PostMapping("/create")
    @Operation(summary = "创建SOP")
    @PreAuthorize("@ss.hasPermission('gap:sop:create')")
    public CommonResult<Long> createSop(@Valid @RequestBody GapSopSaveReqVO createReqVO) {
        return success(sopService.createSop(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新SOP")
    @PreAuthorize("@ss.hasPermission('gap:sop:update')")
    public CommonResult<Boolean> updateSop(@Valid @RequestBody GapSopSaveReqVO updateReqVO) {
        sopService.updateSop(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除SOP")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:sop:delete')")
    public CommonResult<Boolean> deleteSop(@RequestParam("id") Long id) {
        sopService.deleteSop(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得SOP")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:sop:query')")
    public CommonResult<GapSopRespVO> getSop(@RequestParam("id") Long id) {
        GapSopDO sop = sopService.getSop(id);
        return success(BeanUtils.toBean(sop, GapSopRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得SOP分页")
    @PreAuthorize("@ss.hasPermission('gap:sop:query')")
    public CommonResult<PageResult<GapSopRespVO>> getSopPage(@Valid GapSopPageReqVO pageReqVO) {
        PageResult<GapSopDO> pageResult = sopService.getSopPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapSopRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得SOP列表")
    @PreAuthorize("@ss.hasPermission('gap:sop:query')")
    public CommonResult<List<GapSopRespVO>> getSopList() {
        List<GapSopDO> list = sopService.getSopList();
        return success(BeanUtils.toBean(list, GapSopRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出SOP Excel")
    @PreAuthorize("@ss.hasPermission('gap:sop:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSopExcel(@Valid GapSopPageReqVO pageReqVO,
                               HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapSopDO> list = sopService.getSopPage(pageReqVO).getList();
        ExcelUtils.write(response, "SOP库.xls", "数据", GapSopRespVO.class,
                BeanUtils.toBean(list, GapSopRespVO.class));
    }

}
