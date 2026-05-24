package cn.iocoder.yudao.module.gap.controller.admin.base.weather;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.weather.GapBaseWeatherPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.weather.GapBaseWeatherRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.weather.GapBaseWeatherSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.weather.GapBaseWeatherDO;
import cn.iocoder.yudao.module.gap.service.base.weather.GapBaseWeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP 气象数据")
@RestController
@RequestMapping("/gap/base-weather")
@Validated
public class GapBaseWeatherController {

    @Resource
    private GapBaseWeatherService weatherService;

    @PostMapping("/create")
    @Operation(summary = "创建气象数据")
    @PreAuthorize("@ss.hasPermission('gap:base-weather:create')")
    public CommonResult<Long> createWeather(@Valid @RequestBody GapBaseWeatherSaveReqVO createReqVO) {
        return success(weatherService.createWeather(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新气象数据")
    @PreAuthorize("@ss.hasPermission('gap:base-weather:update')")
    public CommonResult<Boolean> updateWeather(@Valid @RequestBody GapBaseWeatherSaveReqVO updateReqVO) {
        weatherService.updateWeather(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除气象数据")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:base-weather:delete')")
    public CommonResult<Boolean> deleteWeather(@RequestParam("id") Long id) {
        weatherService.deleteWeather(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得气象数据")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:base-weather:query')")
    public CommonResult<GapBaseWeatherRespVO> getWeather(@RequestParam("id") Long id) {
        GapBaseWeatherDO weather = weatherService.getWeather(id);
        return success(BeanUtils.toBean(weather, GapBaseWeatherRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得气象数据分页")
    @PreAuthorize("@ss.hasPermission('gap:base-weather:query')")
    public CommonResult<PageResult<GapBaseWeatherRespVO>> getWeatherPage(@Valid GapBaseWeatherPageReqVO pageReqVO) {
        PageResult<GapBaseWeatherDO> pageResult = weatherService.getWeatherPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapBaseWeatherRespVO.class));
    }

    @GetMapping("/list-by-base")
    @Operation(summary = "根据基地获得气象数据列表")
    @Parameter(name = "baseId", description = "基地编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:base-weather:query')")
    public CommonResult<List<GapBaseWeatherRespVO>> getWeatherListByBaseId(@RequestParam("baseId") Long baseId) {
        List<GapBaseWeatherDO> list = weatherService.getWeatherListByBaseId(baseId);
        return success(BeanUtils.toBean(list, GapBaseWeatherRespVO.class));
    }

}
