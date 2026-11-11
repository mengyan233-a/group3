package cn.zhentao.service.impl;

import cn.zhentao.client.ScoreClient;
import cn.zhentao.client.StationeryClient;
import cn.zhentao.dto.Dto;
import cn.zhentao.entity.StationOrder;
import cn.zhentao.mapper.StationOrderMapper;
import cn.zhentao.service.IStationOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2026-11-10
 */
@Service
public class StationOrderServiceImpl extends ServiceImpl<StationOrderMapper, StationOrder> implements IStationOrderService {
    @Autowired
    private ScoreClient scoreClient;
    @Autowired
    private StationeryClient stationeryClient;

    @Override
    @GlobalTransactional
    public Integer create(Dto dto) {
        //通过dto传参，给订单创建数据
        StationOrder stationOrder = new StationOrder();
        stationOrder.setStationId(dto.getStationId());
        stationOrder.setUserId(dto.getUserId());
        stationOrder.setAmount(dto.getAmount());
        stationOrder.setTime(LocalDateTime.now());
        int i = baseMapper.insert(stationOrder);
        //远程调用扣减库存
        stationeryClient.down(dto.getStationId());
        //远程调用增加积分
        scoreClient.applend(dto.getUserId());
        //制造异常，模拟异常回滚
        //int a=1/0;
        return i;
    }
}
