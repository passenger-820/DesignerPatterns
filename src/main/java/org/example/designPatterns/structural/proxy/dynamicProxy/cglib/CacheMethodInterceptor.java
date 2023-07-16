package org.example.designPatterns.structural.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * 记得引入cglib
 */
public class CacheMethodInterceptor implements MethodInterceptor {

    //定义缓存
    private Map<String,String> cache = new LinkedHashMap<>(256);
    //被代理类
    private DatabaseDataQuery databaseDataQuery;
    //通过new被代理类，构造代理类
    public CacheMethodInterceptor() {
        this.databaseDataQuery = new DatabaseDataQuery();
    }

    //this这个被增强的对象，拦截的方法，拦截的参数，proxy用来调用父类的方法（比如没拦截的）
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        //这里面的内容和jdk的invoke一样
        String result = null;
        // 1、判断是哪一个方法，如果是query
        //注意是用method.getName()拿到方法名
        if ("query".equals(method.getName())){
            // 2、查询缓存，如果命中直接返回
            result = cache.get(args[0].toString());
            if (null != result){
                System.out.println("数据从缓存重获取。");
                return result;
            }
            // 3、未命中，查数据库（需要代理实例）
            //注意是用method.invoke()调用代理的方法，不要自己手动用对象调
            result = (String) method.invoke(databaseDataQuery,args);
            // 4、如果查询到了,进行缓存
            if (null!=result){
                cache.put(args[0].toString(),result);
            }
            return result;
        }
        //不是query方法的
        // 否则，如果是其他方法，直接调用原生的方法
        return method.invoke(databaseDataQuery,args);
    }

}
