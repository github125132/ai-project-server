package cn.iocoder.yudao.module.gap.controller.admin.change;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapChangeRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapChangeRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapChangeRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapChangeRecordDO;
import cn.iocoder.yudao.module.gap.service.change.GapChangeRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP ChangeRecord")
@RestController
@RequestMapping("/gap/change-record")
@Validated
public class GapChangeRecordController {

    @Resource
    private GapChangeRecordService ChangeRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建ChangeRecord")
    @PreAuthorize("@ss.hasPermission('gap:change-record:create')")
    public CommonResult<Long> createGapChangeRecord(@Valid @RequestBody GapChangeRecordSaveReqVO createReqVO) {
        return success(ChangeRecordService.createGapChangeRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新ChangeRecord")
    @PreAuthorize("@ss.hasPermission('gap:change-record:update')")
    public CommonResult<Boolean> updateGapChangeRecord(@Valid @RequestBody GapChangeRecordSaveReqVO updateReqVO) {
        ChangeRecordService.updateGapChangeRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除ChangeRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:change-record:delete')")
    public CommonResult<Boolean> deleteGapChangeRecord(@RequestParam("id") Long id) {
        ChangeRecordService.deleteGapChangeRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得ChangeRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:change-record:query')")
    public CommonResult<GapChangeRecordRespVO> getGapChangeRecord(@RequestParam("id") Long id) {
        GapChangeRecordDO entity = ChangeRecordService.getGapChangeRecord(id);
        return success(BeanUtils.toBean(entity, GapChangeRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得ChangeRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:change-record:query')")
    public CommonResult<PageResult<GapChangeRecordRespVO>> getGapChangeRecordPage(@Valid GapChangeRecordPageReqVO pageReqVO) {
        PageResult<GapChangeRecordDO> pageResult = ChangeRecordService.getGapChangeRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapChangeRecordRespVO.class));
    }
}
