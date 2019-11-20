package cn.wang.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wbh
 * @Date: 2019/9/18 14:06
 * @Description:
 */
@RefreshScope//自动刷新配置文件属性
@RestController
public class HelloController {

    @Value("${neo.hello:error}")
    private String profile;

    @RequestMapping(value = "/info")
    public String info(){
          return profile;
    }
}
