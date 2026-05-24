package cn.iocoder.yudao.module.gap.controller.admin.inspect;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapReleaseRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapReleaseRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapReleaseRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapReleaseRecordDO;
import cn.iocoder.yudao.module.gap.service.inspect.GapReleaseRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP ReleaseRecord")
@RestController
@RequestMapping("/gap/release-record")
@Validated
public class GapReleaseRecordController {

    @Resource
    private GapReleaseRecordService ReleaseRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建ReleaseRecord")
    @PreAuthorize("@ss.hasPermission('gap:release-record:create')")
    public CommonResult<Long> createGapReleaseRecord(@Valid @RequestBody GapReleaseRecordSaveReqVO createReqVO) {
        return success(ReleaseRecordService.createGapReleaseRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新ReleaseRecord")
    @PreAuthorize("@ss.hasPermission('gap:release-record:update')")
    public CommonResult<Boolean> updateGapReleaseRecord(@Valid @RequestBody GapReleaseRecordSaveReqVO updateReqVO) {
        ReleaseRecordService.updateGapReleaseRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除ReleaseRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:release-record:delete')")
    public CommonResult<Boolean> deleteGapReleaseRecord(@RequestParam("id") Long id) {
        ReleaseRecordService.deleteGapReleaseRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得ReleaseRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:release-record:query')")
    public CommonResult<GapReleaseRecordRespVO> getGapReleaseRecord(@RequestParam("id") Long id) {
        GapReleaseRecordDO entity = ReleaseRecordService.getGapReleaseRecord(id);
        return success(BeanUtils.toBean(entity, GapReleaseRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得ReleaseRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:release-record:query')")
    public CommonResult<PageResult<GapReleaseRecordRespVO>> getGapReleaseRecordPage(@Valid GapReleaseRecordPageReqVO pageReqVO) {
        PageResult<GapReleaseRecordDO> pageResult = ReleaseRecordService.getGapReleaseRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapReleaseRecordRespVO.class));
    }
}
