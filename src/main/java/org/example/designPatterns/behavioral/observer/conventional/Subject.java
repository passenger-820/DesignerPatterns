package org.example.designPatterns.behavioral.observer.conventional;

/**
 * 主题
 * 注册、通知、删除观察者的能力
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
