package org.example.designPatterns.structural.proxy.dynamicProxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheInvocationHandler implements InvocationHandler {
    //定义缓存
    private final Map<String,String> cache = new HashMap<>(256);
    //被代理类
    private DatabaseDataQuery databaseDataQuery;

    //传入被代理类，构造代理类
    public CacheInvocationHandler(DataQuery databaseDataQuery) {
        this.databaseDataQuery = (DatabaseDataQuery) databaseDataQuery;
    }
    //也可以通过new被代理类，构造代理类
    public CacheInvocationHandler() {
        this.databaseDataQuery = new DatabaseDataQuery();
    }

    //传入了被代理的对象，被代理的方法，参数
    //本例只代理query方法，不代理queryAll方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
