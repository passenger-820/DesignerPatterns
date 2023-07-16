package org.example.designPatterns.structural.proxy.staticProxy;

/**
 * 在客户端代码中使用缓存代理
 */
public class Client {
    public static void main(String[] args) {
        DataQuery databaseDataQuery = new DatabaseDataQuery();
        DataQuery cachingDataQueryProxy = new CachingDataQueryProxy(databaseDataQuery);
        String queryKey = "example_key";
        //第一次查询，应当是去数据库
        System.out.println(cachingDataQueryProxy.query(queryKey));
        //第二次查询，应当是去缓存
        System.out.println(cachingDataQueryProxy.query(queryKey));
    }
}
