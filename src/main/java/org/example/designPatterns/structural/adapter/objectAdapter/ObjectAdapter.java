package org.example.designPatterns.structural.adapter.objectAdapter;

/**
 * 对象适配器类，持有旧类，实现新接口
 */
public class ObjectAdapter implements Target {
    //组合。即对象适配器持有旧类
    private Adaptee adaptee;
    //构造一个持有旧类的适配器
    public ObjectAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        System.out.println("这是对象适配器里调用新的接口，使用持有的旧的类的方法");
        //新接口中，调用旧类的方法
        adaptee.oldRequest();
    }
}
