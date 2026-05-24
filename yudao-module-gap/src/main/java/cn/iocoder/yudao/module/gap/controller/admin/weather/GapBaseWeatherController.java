package cn.iocoder.yudao.module.gap.controller.admin.weather;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.weather.vo.GapBaseWeatherPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.weather.vo.GapBaseWeatherRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.weather.vo.GapBaseWeatherSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.weather.GapBaseWeatherDO;
import cn.iocoder.yudao.module.gap.service.weather.GapBaseWeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP BaseWeather")
@RestController
@RequestMapping("/gap/base-weather")
@Validated
public class GapBaseWeatherController {

    @Resource
    private GapBaseWeatherService BaseWeatherService;

    @PostMapping("/create")
    @Operation(summary = "创建BaseWeather")
    @PreAuthorize("@ss.hasPermission('gap:base-weather:create')")
    public CommonResult<Long> createGapBaseWeather(@Valid @RequestBody GapBaseWeatherSaveReqVO createReqVO) {
        return success(BaseWeatherService.createGapBaseWeather(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新BaseWeather")
    @PreAuthorize("@ss.hasPermission('gap:base-weather:update')")
    public CommonResult<Boolean> updateGapBaseWeather(@Valid @RequestBody GapBaseWeatherSaveReqVO updateReqVO) {
        BaseWeatherService.updateGapBaseWeather(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除BaseWeather")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:base-weather:delete')")
    public CommonResult<Boolean> deleteGapBaseWeather(@RequestParam("id") Long id) {
        BaseWeatherService.deleteGapBaseWeather(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得BaseWeather")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:base-weather:query')")
    public CommonResult<GapBaseWeatherRespVO> getGapBaseWeather(@RequestParam("id") Long id) {
        GapBaseWeatherDO entity = BaseWeatherService.getGapBaseWeather(id);
        return success(BeanUtils.toBean(entity, GapBaseWeatherRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得BaseWeather分页")
    @PreAuthorize("@ss.hasPermission('gap:base-weather:query')")
    public CommonResult<PageResult<GapBaseWeatherRespVO>> getGapBaseWeatherPage(@Valid GapBaseWeatherPageReqVO pageReqVO) {
        PageResult<GapBaseWeatherDO> pageResult = BaseWeatherService.getGapBaseWeatherPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapBaseWeatherRespVO.class));
    }
}
