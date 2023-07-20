package org.example.designPatterns.behavioral.status.tv;

/**
 * 具体的开机状态时
 */
public class TVOnState implements TVState{
    //再开机没意义
    @Override
    public void turnOn() {
        System.out.println("TV is already on.");
    }

    //那就关机
    @Override
    public void turnOff() {
        System.out.println("Turning off the TV.");
    }

    //开机状态下可以调整音量
    @Override
    public void adjustVolume(int volume) {
        System.out.println("Adjusting volume to: " + volume);
    }
}
