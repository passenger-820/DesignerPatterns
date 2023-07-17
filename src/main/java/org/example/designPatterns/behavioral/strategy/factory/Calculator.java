package org.example.designPatterns.behavioral.strategy.factory;

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
    public void execute(String sign, double num1, double num2){
        double result = computation.compute(num1, num2);
        System.out.println(num1 + sign + num2 + "=" + result);
    }
}
