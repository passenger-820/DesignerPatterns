package org.example.designPatterns.structural.proxy.dynamicProxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 在使用代理类时，创建被代理类的对象和代理类的对象，并使用 `Proxy.newProxyInstance` 方法生成代理对象
 */
public class Client {
    public static void main(String[] args) {
        // jdk提供的代理实现，主要是使用Proxy类来完成
        // 主要看Proxy.newProxyInstance的3个参数
        // 1、参数1：classLoader：被代理类的类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 2、参数2：代理类需要实现的接口数组
        Class[] interfaces = new Class[]{DataQuery.class};
        // 3、参数3：InvocationHandler
        InvocationHandler invocationHandler = new CacheInvocationHandler();
        // 4、用 `Proxy.newProxyInstance` 方法生成代理对象
        DataQuery dataQuery = (DataQuery) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        // 事实上调用query方法的时候，他是调用了invoke
        String result = dataQuery.query("key1");
        System.out.println(result);
        System.out.println("--------------------");
        result = dataQuery.query("key1");
        System.out.println(result);
        System.out.println("--------------------");
        result = dataQuery.query("key2");
        System.out.println(result);
        System.out.println("++++++++++++++++++++++++++++++++++++");

        // 事实上调用queryAll方法的时候，他还是去调用invoke
        result = dataQuery.queryAll("key1");
        System.out.println(result);
        System.out.println("--------------------");
        result = dataQuery.queryAll("key1");
        System.out.println(result);
        System.out.println("--------------------");
        result = dataQuery.queryAll("key2");
        System.out.println(result);
        System.out.println("--------------------");
    }
}
