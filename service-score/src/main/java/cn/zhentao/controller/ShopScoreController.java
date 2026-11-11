package cn.zhentao.controller;


import cn.zhentao.entity.ShopScore;
import cn.zhentao.result.Result;
import cn.zhentao.service.IShopScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2026-11-10
 */
@RestController
@RequestMapping("/shopScore")
public class ShopScoreController {
    @Autowired
    private IShopScoreService service;
    //增加积分功能
    @RequestMapping("applend")
    public Result<Integer> applend(@RequestParam("id") Integer id){
        Integer integer = service.applend(id);
        return Result.success(integer, "积分增加成功");
    }
    //增加用户功能
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody ShopScore score){
      return Result.success( service.save(score), "新增成功");
    }
    //删除功能
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestParam("id") Integer id){
        boolean b = service.removeById(id);
        return Result.success(b,"删除成功");
    }
    //根据id查询
    @RequestMapping("select")
    public Result<ShopScore> select(@RequestParam("id") Integer id){
        ShopScore byId = service.getById(id);
        return Result.success(byId, "查询成功");
    }

}
