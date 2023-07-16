package org.example.designPatterns.structural.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 *在使用代理类时，创建被代理类的对象和代理类的对象，并使用 `Enhancer.create` 方法生成代理对象。
 */
public class Client {
    public static void main(String[] args) {

        /*
         Caused by: net.sf.cglib.core.CodeGenerationException: java.lang.reflect.InaccessibleObjectException-->
         Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
         throws java.lang.ClassFormatError accessible: module java.base does not "opens java.lang" to unnamed module @573fd745
         解决办法，二选一即可，在VM Options中加入：
         --add-opens java.base/java.lang=ALL-UNNAMED
         --add-exports java.base/jdk.internal.module=ALL-UNNAMED
         */
        //cglib通过Enhancer
        Enhancer enhancer = new Enhancer();
        //设置他要增强的父类
        enhancer.setSuperclass(DatabaseDataQuery.class);
        //设置一个方法拦截器，用来拦截父类里的方法
        enhancer.setCallback(new CacheMethodInterceptor());
        //创建代理类
        DatabaseDataQuery databaseDataQuery = (DatabaseDataQuery) enhancer.create();

        databaseDataQuery.query("key1");
        databaseDataQuery.query("key1");
        databaseDataQuery.query("key1");
        databaseDataQuery.query("key2");
        databaseDataQuery.query("key2");
        databaseDataQuery.queryAll("key1");
        databaseDataQuery.queryAll("key1");
        databaseDataQuery.queryAll("key2");
        databaseDataQuery.queryAll("key3");
    }
}
