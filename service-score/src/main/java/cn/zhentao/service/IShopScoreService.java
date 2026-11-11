package cn.zhentao.service;

import cn.zhentao.entity.ShopScore;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2026-11-10
 */
public interface IShopScoreService extends IService<ShopScore> {
    //增加积分
    Integer applend(Integer id);

}
