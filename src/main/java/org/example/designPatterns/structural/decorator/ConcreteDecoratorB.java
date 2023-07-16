package org.example.designPatterns.structural.decorator;

public class ConcreteDecoratorB extends Decorator{
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("ConcreteDecoratorB is adding new behavior1...");
        super.operation();
        System.out.println("ConcreteDecoratorB is adding new behavior2...");
    }
}
