package org.example.designPatterns.behavioral.strategy.computationFactory;

/**
 * 具体策略类：加法
 */
public class Addition implements Computation {
    @Override
    public double compute(double num1, double num2) {
        return num1 +num2;
    }
}
