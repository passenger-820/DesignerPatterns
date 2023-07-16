package org.example.designPatterns.creational.singleton;

public class EagerSingleton {
    //1.static唯一实例,不是懒加载，线程安全由JVM实现
    //在类加载时就已经创建了实例，之后无法再对instance进行修改，因此不需要使用final关键字来限制instance的可变性
    private static EagerSingleton instance = new EagerSingleton();
    //2.私有化构造器
    private EagerSingleton(){}
    //3.暴露一个获取实例方法
    public static EagerSingleton getEagerSingleton(){
        return instance;
    }
}
