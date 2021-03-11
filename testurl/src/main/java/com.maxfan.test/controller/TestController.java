package com.maxfan.test.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.maxfan.test.handler.SentinelHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangfan
 * @date 2021-02-03
 */
@RestController
@RequestMapping("test")
public class TestController {

    /**
     * value是规则名称，按照此规则匹配
     * blockHandlers是处理方法名称，如果被限流就执行此方法
     * fallback是处理异常的方法名称，如果异常返回此方法
     * blockHandlerClass，fallbackClass分别是限流处理类和异常处理类
     * @param name
     * @return
     */
    @SentinelResource(value = "testGetRule", blockHandlerClass = SentinelHandle.class, blockHandler = "getBlockHandle",
            fallbackClass = SentinelHandle.class, fallback = "secretFallback")
    //如果返回结果是xml则使用下面的方式指定是json，或者排除jar包内转xml的包
//    @GetMapping(value="/ge",produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    @GetMapping("/ge")
    public Object test(String name){
        return "成功";
    }

    @SentinelResource(value = "testGetRule2", blockHandlerClass = SentinelHandle.class, blockHandler = "getBlockHandle",
            fallbackClass = SentinelHandle.class, fallback = "secretFallback")
    //如果返回结果是xml则使用下面的方式指定是json，或者排除jar包内转xml的包
//    @GetMapping(value="/ge",produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    @GetMapping("/ge2/{path1}/{path2}")
    public Object test2(String name){
        System.out.println("执行方法体");

//        return Result.ofSuccessMsg(name+"写入成功");
        throw new RuntimeException("主动报错");
    }
}
