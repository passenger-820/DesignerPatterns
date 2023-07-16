package org.example.designPatterns.structural.proxy.dynamicProxy.aop;

import jakarta.annotation.Resource;
import org.example.designPatterns.structural.proxy.dynamicProxy.aop.DataQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {

    @Resource
    private DataQuery dataQuery;


    @Test
    public void test(){
        dataQuery.query("key1");
        dataQuery.query("key1");
        dataQuery.query("key2");
    }
}
