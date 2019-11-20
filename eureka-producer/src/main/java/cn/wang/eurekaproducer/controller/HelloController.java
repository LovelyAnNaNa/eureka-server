package cn.wang.eurekaproducer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: wbh
 * @Date: 2019/9/15 10:04
 * @Description:
 */
@RestController
public class HelloController {

    @Value("${index}")
    private int index;

    @RequestMapping(value = "/hello")
    public String hello(String name){
          return index + ",Hello," + name + new Date();
    }
}
