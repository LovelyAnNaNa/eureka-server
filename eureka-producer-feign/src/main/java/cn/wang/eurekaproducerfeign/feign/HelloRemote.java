package cn.wang.eurekaproducerfeign.feign;

import cn.wang.eurekaproducerfeign.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//第一个参数指定所要使用的生产者,第二个指定出现异常调用的类
@FeignClient(name="eureka-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping("/hello/")
    String hello(@RequestParam(value = "name") String name);
}
