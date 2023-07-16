package org.example.designPatterns.structural.decorator;

/**
 * 一个抽象装饰器类，继承基类，并将被装饰对象作为属性[使用组合的形式进行装饰]
 * 装饰器类和被装饰对象通常实现同一个接口或继承同一个类，以保证二者可以互相替代
 * 即装饰器类也可以作为被装饰对象
 */
public abstract class Decorator implements Component{
    //使用组合的形式进行装饰
    protected Component component;
    //构造包装器，持有被包装类
    public Decorator(Component component) {
        this.component = component;
    }

    //在抽象类中实现该方法
    //这样子类都默认实现了该方法，即执行被包装类的方法
    @Override
    public void operation() {
        component.operation();
    }
}
