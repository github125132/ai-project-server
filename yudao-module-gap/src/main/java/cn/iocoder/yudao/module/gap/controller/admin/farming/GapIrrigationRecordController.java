package cn.iocoder.yudao.module.gap.controller.admin.farming;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapIrrigationRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapIrrigationRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapIrrigationRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapIrrigationRecordDO;
import cn.iocoder.yudao.module.gap.service.farming.GapIrrigationRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP IrrigationRecord")
@RestController
@RequestMapping("/gap/irrigation-record")
@Validated
public class GapIrrigationRecordController {

    @Resource
    private GapIrrigationRecordService IrrigationRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建IrrigationRecord")
    @PreAuthorize("@ss.hasPermission('gap:irrigation-record:create')")
    public CommonResult<Long> createGapIrrigationRecord(@Valid @RequestBody GapIrrigationRecordSaveReqVO createReqVO) {
        return success(IrrigationRecordService.createGapIrrigationRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新IrrigationRecord")
    @PreAuthorize("@ss.hasPermission('gap:irrigation-record:update')")
    public CommonResult<Boolean> updateGapIrrigationRecord(@Valid @RequestBody GapIrrigationRecordSaveReqVO updateReqVO) {
        IrrigationRecordService.updateGapIrrigationRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除IrrigationRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:irrigation-record:delete')")
    public CommonResult<Boolean> deleteGapIrrigationRecord(@RequestParam("id") Long id) {
        IrrigationRecordService.deleteGapIrrigationRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得IrrigationRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:irrigation-record:query')")
    public CommonResult<GapIrrigationRecordRespVO> getGapIrrigationRecord(@RequestParam("id") Long id) {
        GapIrrigationRecordDO entity = IrrigationRecordService.getGapIrrigationRecord(id);
        return success(BeanUtils.toBean(entity, GapIrrigationRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得IrrigationRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:irrigation-record:query')")
    public CommonResult<PageResult<GapIrrigationRecordRespVO>> getGapIrrigationRecordPage(@Valid GapIrrigationRecordPageReqVO pageReqVO) {
        PageResult<GapIrrigationRecordDO> pageResult = IrrigationRecordService.getGapIrrigationRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapIrrigationRecordRespVO.class));
    }
}
