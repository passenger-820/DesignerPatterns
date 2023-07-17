package org.example.designPatterns.behavioral.strategy.basic;

/**
 * 客户端可以使用`Calculator`类来执行不同的运算
 */
public class Client {
    public static void main(String[] args) {
        //上下文类
        Calculator calculator = new Calculator();
        //设置加法策略
        calculator.setComputation(new Addition());
        System.out.println("10 + 5 = " + calculator.execute(10,5));

        //设置减法策略
        calculator.setComputation(new Subtraction());
        System.out.println("10 - 5 = " + calculator.execute(10,5));

        //设置乘法策略
        calculator.setComputation(new Multiplication());
        System.out.println("10 * 5 = " + calculator.execute(10,5));
    }
}
