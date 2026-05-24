package cn.iocoder.yudao.module.gap.controller.admin.process;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapProcessRecordDO;
import cn.iocoder.yudao.module.gap.service.process.GapProcessRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP ProcessRecord")
@RestController
@RequestMapping("/gap/process-record")
@Validated
public class GapProcessRecordController {

    @Resource
    private GapProcessRecordService ProcessRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建ProcessRecord")
    @PreAuthorize("@ss.hasPermission('gap:process-record:create')")
    public CommonResult<Long> createGapProcessRecord(@Valid @RequestBody GapProcessRecordSaveReqVO createReqVO) {
        return success(ProcessRecordService.createGapProcessRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新ProcessRecord")
    @PreAuthorize("@ss.hasPermission('gap:process-record:update')")
    public CommonResult<Boolean> updateGapProcessRecord(@Valid @RequestBody GapProcessRecordSaveReqVO updateReqVO) {
        ProcessRecordService.updateGapProcessRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除ProcessRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:process-record:delete')")
    public CommonResult<Boolean> deleteGapProcessRecord(@RequestParam("id") Long id) {
        ProcessRecordService.deleteGapProcessRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得ProcessRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:process-record:query')")
    public CommonResult<GapProcessRecordRespVO> getGapProcessRecord(@RequestParam("id") Long id) {
        GapProcessRecordDO entity = ProcessRecordService.getGapProcessRecord(id);
        return success(BeanUtils.toBean(entity, GapProcessRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得ProcessRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:process-record:query')")
    public CommonResult<PageResult<GapProcessRecordRespVO>> getGapProcessRecordPage(@Valid GapProcessRecordPageReqVO pageReqVO) {
        PageResult<GapProcessRecordDO> pageResult = ProcessRecordService.getGapProcessRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapProcessRecordRespVO.class));
    }
}
