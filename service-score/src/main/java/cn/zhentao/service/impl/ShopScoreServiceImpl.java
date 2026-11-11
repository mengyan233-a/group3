package cn.zhentao.service.impl;

import cn.zhentao.entity.ShopScore;
import cn.zhentao.mapper.ShopScoreMapper;
import cn.zhentao.service.IShopScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2026-11-10
 */
@Service
public class ShopScoreServiceImpl extends ServiceImpl<ShopScoreMapper, ShopScore> implements IShopScoreService {
    //增加积分方法的实现类

    @Override
    @GlobalTransactional
    public Integer applend(Integer id) {
        ShopScore score = baseMapper.selectById(id);
        score.setScore(score.getScore() + 5);
        //制造异常，模拟其中一个模块异常，从而回滚
//        int a = 1 / 0;
        return baseMapper.updateById(score);
    }
}
