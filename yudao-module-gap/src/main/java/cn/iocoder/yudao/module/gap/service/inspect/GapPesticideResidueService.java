package cn.iocoder.yudao.module.gap.service.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapPesticideResiduePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapPesticideResidueSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapPesticideResidueDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 农残检测明细 Service 接口
 *
 * @author 芋道源码
 */
public interface GapPesticideResidueService {

    /**
     * 创建农残检测明细
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPesticideResidue(@Valid GapPesticideResidueSaveReqVO createReqVO);

    /**
     * 更新农残检测明细
     *
     * @param updateReqVO 更新信息
     */
    void updatePesticideResidue(@Valid GapPesticideResidueSaveReqVO updateReqVO);

    /**
     * 删除农残检测明细
     *
     * @param id 编号
     */
    void deletePesticideResidue(Long id);

    /**
     * 获得农残检测明细
     *
     * @param id 编号
     * @return 农残检测明细
     */
    GapPesticideResidueDO getPesticideResidue(Long id);

    /**
     * 获得农残检测明细分页
     *
     * @param pageReqVO 分页查询
     * @return 农残检测明细分页
     */
    PageResult<GapPesticideResidueDO> getPesticideResiduePage(GapPesticideResiduePageReqVO pageReqVO);

    /**
     * 获得农残检测明细列表
     *
     * @return 农残检测明细列表
     */
    List<GapPesticideResidueDO> getPesticideResidueList();

    /**
     * 获得农残检测明细列表
     *
     * @param ids 编号集合
     * @return 农残检测明细列表
     */
    List<GapPesticideResidueDO> getPesticideResidueList(Collection<Long> ids);

    /**
     * 根据任务编号获得农残检测明细列表
     *
     * @param taskId 任务编号
     * @return 农残检测明细列表
     */
    List<GapPesticideResidueDO> getPesticideResidueListByTaskId(Long taskId);

    /**
     * 根据报告编号获得农残检测明细列表
     *
     * @param reportId 报告编号
     * @return 农残检测明细列表
     */
    List<GapPesticideResidueDO> getPesticideResidueListByReportId(Long reportId);

    /**
     * 校验农残检测明细存在
     *
     * @param id 编号
     * @return 农残检测明细
     */
    GapPesticideResidueDO validatePesticideResidueExists(Long id);

}
