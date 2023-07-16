package org.example.designPatterns.structural.decorator;

/**
 * 具体的被装饰对象，实现基类中的方法
 */
public class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("ConcreteComponent is doing something...");
    }
}
