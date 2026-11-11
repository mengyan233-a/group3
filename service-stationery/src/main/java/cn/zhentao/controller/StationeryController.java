package cn.zhentao.controller;


import cn.zhentao.entity.Stationery;
import cn.zhentao.result.Result;
import cn.zhentao.service.IStationeryService;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2026-11-10
 */
@RestController
@RequestMapping("/stationery")
public class StationeryController {
    @Autowired
    private IStationeryService service;

    //库存减少
    @RequestMapping("/down")

    public Result<Integer> down(@RequestParam("id") Integer id) {
        Integer down = service.down(id);
        return Result.success(down, "扣减成功");
    }
    //增加商品
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody Stationery stationery){
        boolean b = service.save(stationery);
        return Result.success(b,"新增商品成功");
    }
    //删除商品
    @RequestMapping("/delete")
    public Result<Boolean> delete(@RequestParam("id")Integer id){
        return Result.success(service.removeById(id), "删除成功");
    }
    //根据id查询商品
    @RequestMapping("/select")
    public Result<Stationery> select(@RequestParam("id") Integer id){
        Stationery stationery = service.getById(id);
        return Result.success(stationery, "查询成功");
    }

}
