package org.example.designPatterns.behavioral.strategy.basic;

/**
 * 具体策略类：乘法
 */
public class Multiplication implements Computation{
    @Override
    public double compute(double num1, double num2) {
        return num1 * num2;
    }
}
