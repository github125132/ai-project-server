package cn.iocoder.yudao.module.gap.controller.admin.base;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.GapBaseInfoPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.GapBaseInfoRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.GapBaseInfoSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.GapBaseInfoDO;
import cn.iocoder.yudao.module.gap.service.base.GapBaseInfoService;
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

@Tag(name = "管理后台 - GAP 基地信息")
@RestController
@RequestMapping("/gap/base-info")
@Validated
public class GapBaseInfoController {

    @Resource
    private GapBaseInfoService baseInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建基地信息")
    @PreAuthorize("@ss.hasPermission('gap:base-info:create')")
    public CommonResult<Long> createBaseInfo(@Valid @RequestBody GapBaseInfoSaveReqVO createReqVO) {
        return success(baseInfoService.createBaseInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新基地信息")
    @PreAuthorize("@ss.hasPermission('gap:base-info:update')")
    public CommonResult<Boolean> updateBaseInfo(@Valid @RequestBody GapBaseInfoSaveReqVO updateReqVO) {
        baseInfoService.updateBaseInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除基地信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:base-info:delete')")
    public CommonResult<Boolean> deleteBaseInfo(@RequestParam("id") Long id) {
        baseInfoService.deleteBaseInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基地信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:base-info:query')")
    public CommonResult<GapBaseInfoRespVO> getBaseInfo(@RequestParam("id") Long id) {
        GapBaseInfoDO baseInfo = baseInfoService.getBaseInfo(id);
        return success(BeanUtils.toBean(baseInfo, GapBaseInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得基地信息分页")
    @PreAuthorize("@ss.hasPermission('gap:base-info:query')")
    public CommonResult<PageResult<GapBaseInfoRespVO>> getBaseInfoPage(@Valid GapBaseInfoPageReqVO pageReqVO) {
        PageResult<GapBaseInfoDO> pageResult = baseInfoService.getBaseInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapBaseInfoRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得基地信息列表")
    @PreAuthorize("@ss.hasPermission('gap:base-info:query')")
    public CommonResult<List<GapBaseInfoRespVO>> getBaseInfoList() {
        List<GapBaseInfoDO> list = baseInfoService.getBaseInfoList();
        return success(BeanUtils.toBean(list, GapBaseInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出基地信息 Excel")
    @PreAuthorize("@ss.hasPermission('gap:base-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportBaseInfoExcel(@Valid GapBaseInfoPageReqVO pageReqVO,
                                    HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapBaseInfoDO> list = baseInfoService.getBaseInfoPage(pageReqVO).getList();
        ExcelUtils.write(response, "基地信息.xls", "数据", GapBaseInfoRespVO.class,
                BeanUtils.toBean(list, GapBaseInfoRespVO.class));
    }

}
