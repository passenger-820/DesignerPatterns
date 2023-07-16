package org.example.designPatterns.behavioral.observer.conventional;

/**
 * 观察者
 * 当所订阅的主题的行为发生了，则调用方法
 */
public interface Observer {
    void update(float temperature, float humidity, float pressure);
}
