package cn.iocoder.yudao.module.gap.controller.admin.change;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapRecallRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapRecallRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapRecallRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapRecallRecordDO;
import cn.iocoder.yudao.module.gap.service.change.GapRecallRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP RecallRecord")
@RestController
@RequestMapping("/gap/recall-record")
@Validated
public class GapRecallRecordController {

    @Resource
    private GapRecallRecordService RecallRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建RecallRecord")
    @PreAuthorize("@ss.hasPermission('gap:recall-record:create')")
    public CommonResult<Long> createGapRecallRecord(@Valid @RequestBody GapRecallRecordSaveReqVO createReqVO) {
        return success(RecallRecordService.createGapRecallRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新RecallRecord")
    @PreAuthorize("@ss.hasPermission('gap:recall-record:update')")
    public CommonResult<Boolean> updateGapRecallRecord(@Valid @RequestBody GapRecallRecordSaveReqVO updateReqVO) {
        RecallRecordService.updateGapRecallRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除RecallRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:recall-record:delete')")
    public CommonResult<Boolean> deleteGapRecallRecord(@RequestParam("id") Long id) {
        RecallRecordService.deleteGapRecallRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得RecallRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:recall-record:query')")
    public CommonResult<GapRecallRecordRespVO> getGapRecallRecord(@RequestParam("id") Long id) {
        GapRecallRecordDO entity = RecallRecordService.getGapRecallRecord(id);
        return success(BeanUtils.toBean(entity, GapRecallRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得RecallRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:recall-record:query')")
    public CommonResult<PageResult<GapRecallRecordRespVO>> getGapRecallRecordPage(@Valid GapRecallRecordPageReqVO pageReqVO) {
        PageResult<GapRecallRecordDO> pageResult = RecallRecordService.getGapRecallRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapRecallRecordRespVO.class));
    }
}
