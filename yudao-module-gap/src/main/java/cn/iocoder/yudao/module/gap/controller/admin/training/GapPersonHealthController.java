package cn.iocoder.yudao.module.gap.controller.admin.training;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapPersonHealthPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapPersonHealthRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapPersonHealthSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapPersonHealthDO;
import cn.iocoder.yudao.module.gap.service.training.GapPersonHealthService;
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

/**
 * 管理后台 - GAP 人员健康档案
 *
 * @author 芋道源码
 */
@Tag(name = "管理后台 - GAP 人员健康档案")
@RestController
@RequestMapping("/gap/person-health")
@Validated
public class GapPersonHealthController {

    @Resource
    private GapPersonHealthService personHealthService;

    @PostMapping("/create")
    @Operation(summary = "创建人员健康档案")
    @PreAuthorize("@ss.hasPermission('gap:person-health:create')")
    public CommonResult<Long> createPersonHealth(@Valid @RequestBody GapPersonHealthSaveReqVO createReqVO) {
        return success(personHealthService.createPersonHealth(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新人员健康档案")
    @PreAuthorize("@ss.hasPermission('gap:person-health:update')")
    public CommonResult<Boolean> updatePersonHealth(@Valid @RequestBody GapPersonHealthSaveReqVO updateReqVO) {
        personHealthService.updatePersonHealth(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除人员健康档案")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:person-health:delete')")
    public CommonResult<Boolean> deletePersonHealth(@RequestParam("id") Long id) {
        personHealthService.deletePersonHealth(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得人员健康档案")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:person-health:query')")
    public CommonResult<GapPersonHealthRespVO> getPersonHealth(@RequestParam("id") Long id) {
        GapPersonHealthDO personHealth = personHealthService.getPersonHealth(id);
        return success(BeanUtils.toBean(personHealth, GapPersonHealthRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得人员健康档案分页")
    @PreAuthorize("@ss.hasPermission('gap:person-health:query')")
    public CommonResult<PageResult<GapPersonHealthRespVO>> getPersonHealthPage(@Valid GapPersonHealthPageReqVO pageReqVO) {
        PageResult<GapPersonHealthDO> pageResult = personHealthService.getPersonHealthPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapPersonHealthRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得人员健康档案列表")
    @PreAuthorize("@ss.hasPermission('gap:person-health:query')")
    public CommonResult<List<GapPersonHealthRespVO>> getPersonHealthList() {
        List<GapPersonHealthDO> list = personHealthService.getPersonHealthList();
        return success(BeanUtils.toBean(list, GapPersonHealthRespVO.class));
    }

    @GetMapping("/list-by-user")
    @Operation(summary = "根据人员编号获得健康档案列表")
    @Parameter(name = "userId", description = "人员编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:person-health:query')")
    public CommonResult<List<GapPersonHealthRespVO>> getPersonHealthListByUserId(@RequestParam("userId") Long userId) {
        List<GapPersonHealthDO> list = personHealthService.getPersonHealthListByUserId(userId);
        return success(BeanUtils.toBean(list, GapPersonHealthRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出人员健康档案 Excel")
    @PreAuthorize("@ss.hasPermission('gap:person-health:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPersonHealthExcel(@Valid GapPersonHealthPageReqVO pageReqVO,
                                        HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapPersonHealthDO> list = personHealthService.getPersonHealthPage(pageReqVO).getList();
        ExcelUtils.write(response, "人员健康档案.xls", "数据", GapPersonHealthRespVO.class,
                BeanUtils.toBean(list, GapPersonHealthRespVO.class));
    }

}
