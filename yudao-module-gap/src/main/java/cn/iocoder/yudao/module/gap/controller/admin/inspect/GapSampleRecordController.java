package cn.iocoder.yudao.module.gap.controller.admin.inspect;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapSampleRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapSampleRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapSampleRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapSampleRecordDO;
import cn.iocoder.yudao.module.gap.service.inspect.GapSampleRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP SampleRecord")
@RestController
@RequestMapping("/gap/sample-record")
@Validated
public class GapSampleRecordController {

    @Resource
    private GapSampleRecordService SampleRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建SampleRecord")
    @PreAuthorize("@ss.hasPermission('gap:sample-record:create')")
    public CommonResult<Long> createGapSampleRecord(@Valid @RequestBody GapSampleRecordSaveReqVO createReqVO) {
        return success(SampleRecordService.createGapSampleRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新SampleRecord")
    @PreAuthorize("@ss.hasPermission('gap:sample-record:update')")
    public CommonResult<Boolean> updateGapSampleRecord(@Valid @RequestBody GapSampleRecordSaveReqVO updateReqVO) {
        SampleRecordService.updateGapSampleRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除SampleRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:sample-record:delete')")
    public CommonResult<Boolean> deleteGapSampleRecord(@RequestParam("id") Long id) {
        SampleRecordService.deleteGapSampleRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得SampleRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:sample-record:query')")
    public CommonResult<GapSampleRecordRespVO> getGapSampleRecord(@RequestParam("id") Long id) {
        GapSampleRecordDO entity = SampleRecordService.getGapSampleRecord(id);
        return success(BeanUtils.toBean(entity, GapSampleRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得SampleRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:sample-record:query')")
    public CommonResult<PageResult<GapSampleRecordRespVO>> getGapSampleRecordPage(@Valid GapSampleRecordPageReqVO pageReqVO) {
        PageResult<GapSampleRecordDO> pageResult = SampleRecordService.getGapSampleRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapSampleRecordRespVO.class));
    }
}
