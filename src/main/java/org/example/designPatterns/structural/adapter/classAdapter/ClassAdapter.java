package org.example.designPatterns.structural.adapter.classAdapter;

/**
 * 类适配器类，继承旧类，实现新接口
 */
public class ClassAdapter extends Adaptee implements Target{
    @Override
    public void request() {
        System.out.println("这是类适配器里调用新的接口，实现了使用旧类的方法");
        //新接口中，调用旧类的方法
        oldRequest();
    }
}
