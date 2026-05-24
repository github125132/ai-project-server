package cn.iocoder.yudao.module.gap.controller.admin.log;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataReviewPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataReviewRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataReviewSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapDataReviewDO;
import cn.iocoder.yudao.module.gap.service.log.GapDataReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP DataReview")
@RestController
@RequestMapping("/gap/data-review")
@Validated
public class GapDataReviewController {

    @Resource
    private GapDataReviewService DataReviewService;

    @PostMapping("/create")
    @Operation(summary = "创建DataReview")
    @PreAuthorize("@ss.hasPermission('gap:data-review:create')")
    public CommonResult<Long> createGapDataReview(@Valid @RequestBody GapDataReviewSaveReqVO createReqVO) {
        return success(DataReviewService.createGapDataReview(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新DataReview")
    @PreAuthorize("@ss.hasPermission('gap:data-review:update')")
    public CommonResult<Boolean> updateGapDataReview(@Valid @RequestBody GapDataReviewSaveReqVO updateReqVO) {
        DataReviewService.updateGapDataReview(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除DataReview")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:data-review:delete')")
    public CommonResult<Boolean> deleteGapDataReview(@RequestParam("id") Long id) {
        DataReviewService.deleteGapDataReview(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得DataReview")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:data-review:query')")
    public CommonResult<GapDataReviewRespVO> getGapDataReview(@RequestParam("id") Long id) {
        GapDataReviewDO entity = DataReviewService.getGapDataReview(id);
        return success(BeanUtils.toBean(entity, GapDataReviewRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得DataReview分页")
    @PreAuthorize("@ss.hasPermission('gap:data-review:query')")
    public CommonResult<PageResult<GapDataReviewRespVO>> getGapDataReviewPage(@Valid GapDataReviewPageReqVO pageReqVO) {
        PageResult<GapDataReviewDO> pageResult = DataReviewService.getGapDataReviewPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapDataReviewRespVO.class));
    }
}
