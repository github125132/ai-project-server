package cn.iocoder.yudao.module.gap.controller.admin.storage;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageInRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageInRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageInRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageInRecordDO;
import cn.iocoder.yudao.module.gap.service.storage.GapStorageInRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP StorageInRecord")
@RestController
@RequestMapping("/gap/storage-in-record")
@Validated
public class GapStorageInRecordController {

    @Resource
    private GapStorageInRecordService StorageInRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建StorageInRecord")
    @PreAuthorize("@ss.hasPermission('gap:storage-in-record:create')")
    public CommonResult<Long> createGapStorageInRecord(@Valid @RequestBody GapStorageInRecordSaveReqVO createReqVO) {
        return success(StorageInRecordService.createGapStorageInRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新StorageInRecord")
    @PreAuthorize("@ss.hasPermission('gap:storage-in-record:update')")
    public CommonResult<Boolean> updateGapStorageInRecord(@Valid @RequestBody GapStorageInRecordSaveReqVO updateReqVO) {
        StorageInRecordService.updateGapStorageInRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除StorageInRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:storage-in-record:delete')")
    public CommonResult<Boolean> deleteGapStorageInRecord(@RequestParam("id") Long id) {
        StorageInRecordService.deleteGapStorageInRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得StorageInRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:storage-in-record:query')")
    public CommonResult<GapStorageInRecordRespVO> getGapStorageInRecord(@RequestParam("id") Long id) {
        GapStorageInRecordDO entity = StorageInRecordService.getGapStorageInRecord(id);
        return success(BeanUtils.toBean(entity, GapStorageInRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得StorageInRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:storage-in-record:query')")
    public CommonResult<PageResult<GapStorageInRecordRespVO>> getGapStorageInRecordPage(@Valid GapStorageInRecordPageReqVO pageReqVO) {
        PageResult<GapStorageInRecordDO> pageResult = StorageInRecordService.getGapStorageInRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapStorageInRecordRespVO.class));
    }
}
