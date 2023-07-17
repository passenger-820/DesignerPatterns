package org.example.designPatterns.behavioral.strategy.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略工厂，缓存所有具体策略，根据策略type直接返回
 */
public class ComputationFactory {
    //使用静态代码块+HashMap缓存所有产品
    private static Map<String,Computation> computationMap = new HashMap<>(8);

    static {
        computationMap.put("+", new Addition());
        computationMap.put("-", new Subtraction());
        computationMap.put("*", new Multiplication());
    }

    public static Computation create(String type){
        return computationMap.get(type);
    }
}
