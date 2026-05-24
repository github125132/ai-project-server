package cn.iocoder.yudao.module.gap.controller.admin.storage;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageOutRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageOutRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageOutRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageOutRecordDO;
import cn.iocoder.yudao.module.gap.service.storage.GapStorageOutRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP StorageOutRecord")
@RestController
@RequestMapping("/gap/storage-out-record")
@Validated
public class GapStorageOutRecordController {

    @Resource
    private GapStorageOutRecordService StorageOutRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建StorageOutRecord")
    @PreAuthorize("@ss.hasPermission('gap:storage-out-record:create')")
    public CommonResult<Long> createGapStorageOutRecord(@Valid @RequestBody GapStorageOutRecordSaveReqVO createReqVO) {
        return success(StorageOutRecordService.createGapStorageOutRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新StorageOutRecord")
    @PreAuthorize("@ss.hasPermission('gap:storage-out-record:update')")
    public CommonResult<Boolean> updateGapStorageOutRecord(@Valid @RequestBody GapStorageOutRecordSaveReqVO updateReqVO) {
        StorageOutRecordService.updateGapStorageOutRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除StorageOutRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:storage-out-record:delete')")
    public CommonResult<Boolean> deleteGapStorageOutRecord(@RequestParam("id") Long id) {
        StorageOutRecordService.deleteGapStorageOutRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得StorageOutRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:storage-out-record:query')")
    public CommonResult<GapStorageOutRecordRespVO> getGapStorageOutRecord(@RequestParam("id") Long id) {
        GapStorageOutRecordDO entity = StorageOutRecordService.getGapStorageOutRecord(id);
        return success(BeanUtils.toBean(entity, GapStorageOutRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得StorageOutRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:storage-out-record:query')")
    public CommonResult<PageResult<GapStorageOutRecordRespVO>> getGapStorageOutRecordPage(@Valid GapStorageOutRecordPageReqVO pageReqVO) {
        PageResult<GapStorageOutRecordDO> pageResult = StorageOutRecordService.getGapStorageOutRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapStorageOutRecordRespVO.class));
    }
}
