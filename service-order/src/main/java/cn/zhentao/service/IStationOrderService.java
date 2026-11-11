package cn.zhentao.service;

import cn.zhentao.dto.Dto;
import cn.zhentao.entity.StationOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2026-11-10
 */
public interface IStationOrderService extends IService<StationOrder> {
    //下单服务
    Integer create(Dto dto);

}
