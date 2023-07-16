package org.example.designPatterns.creational.singleton.problems.serialize;

import java.io.*;

/**
 * 事实上，光解决反射入侵还不够，我们的单例依然是有漏洞的，看如下代码：
 * (别忘了实现序列化接口)
 * 解决办法：加readResolve()方法
 */
public class DclSingleton implements Serializable {
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

    /*
    readResolve()方法可以用于替换从流中读取的对象，在进行反序列化时，
    会尝试执行readResolve方法，并将返回值作为反序列化的结果，而不会克隆一个新的实例，保证jvm中仅仅有一个实例存在：
     */
    // 需要加这么一个方法
    public Object readResolve(){
        return instance;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 获取单例并序列化
        DclSingleton singleton = DclSingleton.getInstance();
        FileOutputStream fout = new FileOutputStream("E://singleton.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(singleton);
        // 将实例反序列化出来
        FileInputStream fin = new FileInputStream("E://singleton.txt");
        ObjectInputStream in = new ObjectInputStream(fin);
        Object o = in.readObject();
        System.out.println("o==singleton ? " + (o == singleton)); //false，加了readResolve后就是true
    }

}
