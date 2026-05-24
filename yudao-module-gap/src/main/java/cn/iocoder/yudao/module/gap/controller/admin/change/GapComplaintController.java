package cn.iocoder.yudao.module.gap.controller.admin.change;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapComplaintPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapComplaintRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapComplaintSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapComplaintDO;
import cn.iocoder.yudao.module.gap.service.change.GapComplaintService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP Complaint")
@RestController
@RequestMapping("/gap/complaint")
@Validated
public class GapComplaintController {

    @Resource
    private GapComplaintService ComplaintService;

    @PostMapping("/create")
    @Operation(summary = "创建Complaint")
    @PreAuthorize("@ss.hasPermission('gap:complaint:create')")
    public CommonResult<Long> createGapComplaint(@Valid @RequestBody GapComplaintSaveReqVO createReqVO) {
        return success(ComplaintService.createGapComplaint(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新Complaint")
    @PreAuthorize("@ss.hasPermission('gap:complaint:update')")
    public CommonResult<Boolean> updateGapComplaint(@Valid @RequestBody GapComplaintSaveReqVO updateReqVO) {
        ComplaintService.updateGapComplaint(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除Complaint")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:complaint:delete')")
    public CommonResult<Boolean> deleteGapComplaint(@RequestParam("id") Long id) {
        ComplaintService.deleteGapComplaint(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得Complaint")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:complaint:query')")
    public CommonResult<GapComplaintRespVO> getGapComplaint(@RequestParam("id") Long id) {
        GapComplaintDO entity = ComplaintService.getGapComplaint(id);
        return success(BeanUtils.toBean(entity, GapComplaintRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得Complaint分页")
    @PreAuthorize("@ss.hasPermission('gap:complaint:query')")
    public CommonResult<PageResult<GapComplaintRespVO>> getGapComplaintPage(@Valid GapComplaintPageReqVO pageReqVO) {
        PageResult<GapComplaintDO> pageResult = ComplaintService.getGapComplaintPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapComplaintRespVO.class));
    }
}
