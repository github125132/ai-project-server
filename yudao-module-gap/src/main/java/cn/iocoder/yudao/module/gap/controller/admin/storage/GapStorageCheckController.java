package cn.iocoder.yudao.module.gap.controller.admin.storage;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageCheckPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageCheckRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageCheckSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageCheckDO;
import cn.iocoder.yudao.module.gap.service.storage.GapStorageCheckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP StorageCheck")
@RestController
@RequestMapping("/gap/storage-check")
@Validated
public class GapStorageCheckController {

    @Resource
    private GapStorageCheckService StorageCheckService;

    @PostMapping("/create")
    @Operation(summary = "创建StorageCheck")
    @PreAuthorize("@ss.hasPermission('gap:storage-check:create')")
    public CommonResult<Long> createGapStorageCheck(@Valid @RequestBody GapStorageCheckSaveReqVO createReqVO) {
        return success(StorageCheckService.createGapStorageCheck(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新StorageCheck")
    @PreAuthorize("@ss.hasPermission('gap:storage-check:update')")
    public CommonResult<Boolean> updateGapStorageCheck(@Valid @RequestBody GapStorageCheckSaveReqVO updateReqVO) {
        StorageCheckService.updateGapStorageCheck(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除StorageCheck")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:storage-check:delete')")
    public CommonResult<Boolean> deleteGapStorageCheck(@RequestParam("id") Long id) {
        StorageCheckService.deleteGapStorageCheck(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得StorageCheck")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:storage-check:query')")
    public CommonResult<GapStorageCheckRespVO> getGapStorageCheck(@RequestParam("id") Long id) {
        GapStorageCheckDO entity = StorageCheckService.getGapStorageCheck(id);
        return success(BeanUtils.toBean(entity, GapStorageCheckRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得StorageCheck分页")
    @PreAuthorize("@ss.hasPermission('gap:storage-check:query')")
    public CommonResult<PageResult<GapStorageCheckRespVO>> getGapStorageCheckPage(@Valid GapStorageCheckPageReqVO pageReqVO) {
        PageResult<GapStorageCheckDO> pageResult = StorageCheckService.getGapStorageCheckPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapStorageCheckRespVO.class));
    }
}
