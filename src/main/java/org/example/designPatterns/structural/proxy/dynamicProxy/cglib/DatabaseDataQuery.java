package org.example.designPatterns.structural.proxy.dynamicProxy.cglib;

/**
 * 数据查询类，它从数据库中检索数据
 */
public class DatabaseDataQuery {
    public String query(String queryKey) {
        // 他会使用数据源从数据库查询数据很慢
        System.out.println("正在从数据库查询数据");
        return queryKey+"--result";
    }

    public String queryAll(String queryKey) {
        // 他会使用数据源从数据库查询数据很慢
        System.out.println("正在从数据库查询数据");
        return queryKey+"--all result";
    }
}
