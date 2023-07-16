package org.example.designPatterns.structural.proxy.dynamicProxy.aop;

import org.springframework.stereotype.Component;

/**
 * 实现类，并将具体实现注入容器
 */
@Component
public class DatabaseDataQuery implements DataQuery{
    @Override
    public String query(String queryKey) {
        // 他会使用数据源从数据库查询数据很慢
        System.out.println("正在从数据库查询数据");
        return queryKey+"--result";
    }
}
