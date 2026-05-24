package cn.iocoder.yudao.module.gap.controller.admin.process;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapPackageRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapPackageRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapPackageRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapPackageRecordDO;
import cn.iocoder.yudao.module.gap.service.process.GapPackageRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP PackageRecord")
@RestController
@RequestMapping("/gap/package-record")
@Validated
public class GapPackageRecordController {

    @Resource
    private GapPackageRecordService PackageRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建PackageRecord")
    @PreAuthorize("@ss.hasPermission('gap:package-record:create')")
    public CommonResult<Long> createGapPackageRecord(@Valid @RequestBody GapPackageRecordSaveReqVO createReqVO) {
        return success(PackageRecordService.createGapPackageRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新PackageRecord")
    @PreAuthorize("@ss.hasPermission('gap:package-record:update')")
    public CommonResult<Boolean> updateGapPackageRecord(@Valid @RequestBody GapPackageRecordSaveReqVO updateReqVO) {
        PackageRecordService.updateGapPackageRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除PackageRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:package-record:delete')")
    public CommonResult<Boolean> deleteGapPackageRecord(@RequestParam("id") Long id) {
        PackageRecordService.deleteGapPackageRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得PackageRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:package-record:query')")
    public CommonResult<GapPackageRecordRespVO> getGapPackageRecord(@RequestParam("id") Long id) {
        GapPackageRecordDO entity = PackageRecordService.getGapPackageRecord(id);
        return success(BeanUtils.toBean(entity, GapPackageRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得PackageRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:package-record:query')")
    public CommonResult<PageResult<GapPackageRecordRespVO>> getGapPackageRecordPage(@Valid GapPackageRecordPageReqVO pageReqVO) {
        PageResult<GapPackageRecordDO> pageResult = PackageRecordService.getGapPackageRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapPackageRecordRespVO.class));
    }
}
