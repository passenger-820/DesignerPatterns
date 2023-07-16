package org.example.designPatterns.structural.dynamicProxy.jdk;

/**
 * 数据查询接口
 */
public interface DataQuery {
    String query(String queryKey);
    String queryAll(String queryKey);
}
