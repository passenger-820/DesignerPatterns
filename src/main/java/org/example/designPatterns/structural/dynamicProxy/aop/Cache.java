package org.example.designPatterns.structural.dynamicProxy.aop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存类
 */
public class Cache {
    //要是static的
    private static Map<String,String> cache = new ConcurrentHashMap<>(256);
    //取缓存
    public static String get(String key){
        return cache.get(key);
    }
    //放入缓存
    public static void put(String key,String value){
        cache.put(key, value);
    }
}
