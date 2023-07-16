package org.example.designPatterns.creational.singleton.problems.reflectionIntrusion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 要阻止其他人构造实例，仅仅私有化构造器还是不够的，
 * 因为我们还可以使用反射获取私有构造器进行构造，当然使用枚举的方式是可以解决这个问题的，
 * 对于其他的书写方案，我们通过下边的方式解决：
 */
public class DclSingleton {
    private volatile static DclSingleton instance;
    private DclSingleton(){
        //在双重检查锁的私有化构造器中做判断
        //如果实例本就存在，此时还有人想实例化对象（比如反射入侵），就抛个异常
        if (null != instance){
            throw new RuntimeException("实例：【"
                    + this.getClass().getName() + "】已经存在，该实例只允许实例化一次");
        }
    }

    public static DclSingleton getInstance(){
        if (null == instance){
            synchronized (DclSingleton.class){
                if (null == instance){
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }

    //为了方便记录与查看，junit或spring测试类不单独写，此后基本遵照此方式
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<DclSingleton> clazz = DclSingleton.class;
        Constructor<DclSingleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        boolean flag = DclSingleton.getInstance() == constructor.newInstance();
        System.out.println(flag);
    }

}
