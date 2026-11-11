package cn.zhentao.controller;


import cn.zhentao.dto.Dto;
import cn.zhentao.result.Result;
import cn.zhentao.service.IStationOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2026-11-10
 */
@RestController
@RequestMapping("/stationOrder")
public class StationOrderController {
    @Autowired
    private IStationOrderService service;
    @PostMapping("/create")
    public Result<Integer> create(@RequestBody Dto dto){
        return Result.success( service.create(dto), "订单创建成功");
    }

}
