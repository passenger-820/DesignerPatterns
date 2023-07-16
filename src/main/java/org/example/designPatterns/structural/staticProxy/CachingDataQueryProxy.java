package org.example.designPatterns.structural.staticProxy;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存代理类，它实现了 DataQuery 接口，并在内部使用 HashMap 作为缓存
 */
public class CachingDataQueryProxy implements DataQuery{
    //代理谁就应该持有谁
    private final DatabaseDataQuery realQuery;
    //实现缓存需要一个数据结构，最常用HashMap
    private final Map<String,String> cache;

    public CachingDataQueryProxy(DataQuery realDataQuery) {
        this.realQuery = new DatabaseDataQuery();
        this.cache = new HashMap<>(8);
    }

    //对被代理对象的方法做增强
    @Override
    public String query(String queryKey) {
        //2.1 查询缓存，命中则返回
        String result = cache.get(queryKey);
        if (result != null){
            System.out.println("Result retrieved from cache.");
        } else {
            //2.2 缓存中不存在，则查询数据库，并把结果缓存
            result = realQuery.query(queryKey);
            cache.put(queryKey,result);
            System.out.println("Result retrieved from database and added to cache.");
        }
        return result;
    }
}
