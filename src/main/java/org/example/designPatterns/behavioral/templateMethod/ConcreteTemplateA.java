package org.example.designPatterns.behavioral.templateMethod;

public class ConcreteTemplateA extends AbstractTemplate{
    @Override
    protected void step2() {
        System.out.println("Step 2 (A): 这是子类实现的抽象方法");
    }
}
