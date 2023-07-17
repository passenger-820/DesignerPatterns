package org.example.designPatterns.behavioral.strategy.basic;

/**
 * 上下文类`Calculator`，持有一个策略对象，让客户端可以使用这个类来执行不同的运算
 */
public class Calculator {
    //持有策略对象（接口）
    private Computation computation;
    //选择具体计算策略
    public void setComputation(Computation computation){
        this.computation =computation;
    }
    //获得计算结果
    public double execute(double num1, double num2){
        return computation.compute(num1,num2);
    }
}
