package cn.zhentao.client;

import cn.zhentao.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-stationery")
public interface StationeryClient {
    @RequestMapping("/stationery/down")
    Result<Integer> down(@RequestParam("id") Integer id);
}
