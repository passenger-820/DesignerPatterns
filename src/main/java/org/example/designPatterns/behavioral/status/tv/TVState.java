package org.example.designPatterns.behavioral.status.tv;

/**
 * 抽象状态接口，将每一个修改状态的动作抽象成一个接口
 */
public interface TVState {
    void turnOn();
    void turnOff();
    void adjustVolume(int volume);
}
