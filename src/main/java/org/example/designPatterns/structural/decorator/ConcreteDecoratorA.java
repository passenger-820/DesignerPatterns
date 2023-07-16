package org.example.designPatterns.structural.decorator;

public class ConcreteDecoratorA extends Decorator{
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("ConcreteDecoratorA is adding new behavior1...");
        super.operation();
        System.out.println("ConcreteDecoratorA is adding new behavior2...");
    }
}
