package cn.iocoder.yudao.module.gap.controller.admin.storage;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageAreaPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageAreaRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageAreaSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageAreaDO;
import cn.iocoder.yudao.module.gap.service.storage.GapStorageAreaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP StorageArea")
@RestController
@RequestMapping("/gap/storage-area")
@Validated
public class GapStorageAreaController {

    @Resource
    private GapStorageAreaService StorageAreaService;

    @PostMapping("/create")
    @Operation(summary = "创建StorageArea")
    @PreAuthorize("@ss.hasPermission('gap:storage-area:create')")
    public CommonResult<Long> createGapStorageArea(@Valid @RequestBody GapStorageAreaSaveReqVO createReqVO) {
        return success(StorageAreaService.createGapStorageArea(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新StorageArea")
    @PreAuthorize("@ss.hasPermission('gap:storage-area:update')")
    public CommonResult<Boolean> updateGapStorageArea(@Valid @RequestBody GapStorageAreaSaveReqVO updateReqVO) {
        StorageAreaService.updateGapStorageArea(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除StorageArea")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:storage-area:delete')")
    public CommonResult<Boolean> deleteGapStorageArea(@RequestParam("id") Long id) {
        StorageAreaService.deleteGapStorageArea(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得StorageArea")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:storage-area:query')")
    public CommonResult<GapStorageAreaRespVO> getGapStorageArea(@RequestParam("id") Long id) {
        GapStorageAreaDO entity = StorageAreaService.getGapStorageArea(id);
        return success(BeanUtils.toBean(entity, GapStorageAreaRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得StorageArea分页")
    @PreAuthorize("@ss.hasPermission('gap:storage-area:query')")
    public CommonResult<PageResult<GapStorageAreaRespVO>> getGapStorageAreaPage(@Valid GapStorageAreaPageReqVO pageReqVO) {
        PageResult<GapStorageAreaDO> pageResult = StorageAreaService.getGapStorageAreaPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapStorageAreaRespVO.class));
    }
}
