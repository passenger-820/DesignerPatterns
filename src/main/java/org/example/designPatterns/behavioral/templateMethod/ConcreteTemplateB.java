package org.example.designPatterns.behavioral.templateMethod;

public class ConcreteTemplateB extends AbstractTemplate{
    @Override
    protected void step2() {
        System.out.println("Step 2 (B): 这是子类实现的抽象方法");
    }
}
