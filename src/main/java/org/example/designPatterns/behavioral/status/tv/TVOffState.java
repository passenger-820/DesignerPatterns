package org.example.designPatterns.behavioral.status.tv;

public class TVOffState implements TVState{
    //那就开机
    @Override
    public void turnOn() {
        System.out.println("Turning on the TV.");
    }

    //没意义
    @Override
    public void turnOff() {
        System.out.println("TV is already off.");
    }

    //关机状态下调不了音量
    @Override
    public void adjustVolume(int volume) {
        System.out.println("Cannot adjust volume, TV is off.");
    }
}
