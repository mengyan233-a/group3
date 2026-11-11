package cn.zhentao.service;

import cn.zhentao.entity.Stationery;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2026-11-10
 */
public interface IStationeryService extends IService<Stationery> {
    //库存减少
     Integer down(Integer id);

}
