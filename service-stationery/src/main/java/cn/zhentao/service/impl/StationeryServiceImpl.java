package cn.zhentao.service.impl;

import cn.zhentao.entity.Stationery;
import cn.zhentao.mapper.StationeryMapper;
import cn.zhentao.service.IStationeryService;
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
public class StationeryServiceImpl extends ServiceImpl<StationeryMapper, Stationery> implements IStationeryService {

    @Override
    @GlobalTransactional
    public Integer down(Integer id) {
        Stationery stationery = baseMapper.selectById(id);
        Integer stock = stationery.getStock();
        stationery.setStock(stock - 1);
        return baseMapper.updateById(stationery);
    }
}
