package org.example.designPatterns.behavioral.templateMethod;

public abstract class AbstractTemplate {

    // 模板方法，定义算法的骨架，不允许改动，所以要用final
    public final void templateMethod(){
        step1();
        step2();
        step3();
    }

    // 基本方法，用于定义算法中不会变化的步骤
    private void step1(){
        System.out.println("Step 1: 基本方法，抽象类里已经实现了");
    }

    // 抽象方法，不同子类可以不同，必须由子类实现
    protected abstract void step2();

    // 基本方法，用于定义算法中不会变化的步骤
    private void step3(){
        System.out.println("Step 3: 基本方法，抽象类里已经实现了");
    }
}
