package org.example.designPatterns.creational.singleton;

// 对于枚举类，任何一个枚举项就是一个天然的单例
// 本质上就是 static final EnumSingleton INSTANCE = new EnumSingleton();
public enum EnumSingletonEnum {
    INSTANCE;
}
