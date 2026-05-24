package cn.iocoder.yudao.module.gap.controller.admin.storage;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapTransportRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapTransportRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapTransportRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapTransportRecordDO;
import cn.iocoder.yudao.module.gap.service.storage.GapTransportRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP TransportRecord")
@RestController
@RequestMapping("/gap/transport-record")
@Validated
public class GapTransportRecordController {

    @Resource
    private GapTransportRecordService TransportRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建TransportRecord")
    @PreAuthorize("@ss.hasPermission('gap:transport-record:create')")
    public CommonResult<Long> createGapTransportRecord(@Valid @RequestBody GapTransportRecordSaveReqVO createReqVO) {
        return success(TransportRecordService.createGapTransportRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新TransportRecord")
    @PreAuthorize("@ss.hasPermission('gap:transport-record:update')")
    public CommonResult<Boolean> updateGapTransportRecord(@Valid @RequestBody GapTransportRecordSaveReqVO updateReqVO) {
        TransportRecordService.updateGapTransportRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除TransportRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:transport-record:delete')")
    public CommonResult<Boolean> deleteGapTransportRecord(@RequestParam("id") Long id) {
        TransportRecordService.deleteGapTransportRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得TransportRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:transport-record:query')")
    public CommonResult<GapTransportRecordRespVO> getGapTransportRecord(@RequestParam("id") Long id) {
        GapTransportRecordDO entity = TransportRecordService.getGapTransportRecord(id);
        return success(BeanUtils.toBean(entity, GapTransportRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得TransportRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:transport-record:query')")
    public CommonResult<PageResult<GapTransportRecordRespVO>> getGapTransportRecordPage(@Valid GapTransportRecordPageReqVO pageReqVO) {
        PageResult<GapTransportRecordDO> pageResult = TransportRecordService.getGapTransportRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapTransportRecordRespVO.class));
    }
}
