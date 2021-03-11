package com.maxfan.test.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

import java.util.Map;

public class SentinelHandle {

    public static final int CODE_LIMIT = -100;

    public static final int CODE_FUSE = -200;

    public static Object getBlockHandle(String name, BlockException exception) {
        System.out.println("测试方法不可用:  handleBlock");
        return "测试方法不可用:  handleBlock";
    }

    public static Object secretFallback(String name, Throwable throwable) {
        System.out.println("get限流接口发生异常:  handleFallback(" + throwable.getMessage() + ")");
        return "get限流接口发生异常:  handleFallback(" + throwable.getMessage() + ")";

    }

}
