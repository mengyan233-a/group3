package cn.zhentao.client;

import cn.zhentao.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-score")
public interface ScoreClient {
    @RequestMapping("/shopScore/applend")
    Result<Integer> applend(@RequestParam("id") Integer id);
}
