package org.example.designPatterns.behavioral.strategy.computationFactory;

/**
 * 具体策略类：减法
 */
public class Subtraction implements Computation {
    @Override
    public double compute(double num1, double num2) {
        return num1 - num2;
    }
}
