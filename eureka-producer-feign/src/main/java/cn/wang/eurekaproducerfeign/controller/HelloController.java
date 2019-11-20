package cn.wang.eurekaproducerfeign.controller;

import cn.wang.eurekaproducerfeign.feign.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Auther: wbh
 * @Date: 2019/9/15 10:56
 * @Description:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private HelloRemote helloRemote;

//    @RequestMapping(value = "/{name}") @PathVariable("name") String name
    @GetMapping
    public Object name(){
        return helloRemote.hello(123+"!");
    }
}
