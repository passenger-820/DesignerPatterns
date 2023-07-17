package org.example.designPatterns.behavioral.strategy.factory;

import java.util.Scanner;

/**
 * 客户端可以使用`Calculator`类来执行不同的运算
 */
public class Client {
    public static void main(String[] args) {
        //上下文类
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        //定义两个数值
        double num1 = 10.0F;
        double num2 = 8.0F;
        //根据输入的+ - *，从工厂拿具体策略，然后计算
        while (true){
            System.out.println("请输入计算符：");
            String sign = scanner.next();
            Computation computation = ComputationFactory.create(sign);
            calculator.setComputation(computation);
            calculator.execute(sign,num1,num2);
        }
    }
}
