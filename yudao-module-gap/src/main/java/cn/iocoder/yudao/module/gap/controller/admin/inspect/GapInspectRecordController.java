package cn.iocoder.yudao.module.gap.controller.admin.inspect;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectRecordDO;
import cn.iocoder.yudao.module.gap.service.inspect.GapInspectRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP InspectRecord")
@RestController
@RequestMapping("/gap/inspect-record")
@Validated
public class GapInspectRecordController {

    @Resource
    private GapInspectRecordService InspectRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建InspectRecord")
    @PreAuthorize("@ss.hasPermission('gap:inspect-record:create')")
    public CommonResult<Long> createGapInspectRecord(@Valid @RequestBody GapInspectRecordSaveReqVO createReqVO) {
        return success(InspectRecordService.createGapInspectRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新InspectRecord")
    @PreAuthorize("@ss.hasPermission('gap:inspect-record:update')")
    public CommonResult<Boolean> updateGapInspectRecord(@Valid @RequestBody GapInspectRecordSaveReqVO updateReqVO) {
        InspectRecordService.updateGapInspectRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除InspectRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:inspect-record:delete')")
    public CommonResult<Boolean> deleteGapInspectRecord(@RequestParam("id") Long id) {
        InspectRecordService.deleteGapInspectRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得InspectRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:inspect-record:query')")
    public CommonResult<GapInspectRecordRespVO> getGapInspectRecord(@RequestParam("id") Long id) {
        GapInspectRecordDO entity = InspectRecordService.getGapInspectRecord(id);
        return success(BeanUtils.toBean(entity, GapInspectRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得InspectRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:inspect-record:query')")
    public CommonResult<PageResult<GapInspectRecordRespVO>> getGapInspectRecordPage(@Valid GapInspectRecordPageReqVO pageReqVO) {
        PageResult<GapInspectRecordDO> pageResult = InspectRecordService.getGapInspectRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapInspectRecordRespVO.class));
    }
}
