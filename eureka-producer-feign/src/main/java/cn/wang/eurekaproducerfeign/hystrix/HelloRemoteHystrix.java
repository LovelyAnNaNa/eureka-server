package cn.wang.eurekaproducerfeign.hystrix;

import cn.wang.eurekaproducerfeign.feign.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: wbh
 * @Date: 2019/9/15 14:14
 * @Description:
 */
//出现异常时熔断器处理的方法
@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "Hello World!";
    }
}
