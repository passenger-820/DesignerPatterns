package org.example.designPatterns.behavioral.status.tv;

public class Main {
    public static void main(String[] args) {
        //初始化的电视是关机状态
        NewTV tv = new NewTV();
        //开机
        tv.turnOn();
        //调音量
        tv.adjustVolume(10);
        //再关机
        tv.turnOff();
        //调音量
        tv.adjustVolume(10);
        //开机
        tv.turnOn();
        //还开机
        tv.turnOn();
        /*
        Turning on the TV.
        Adjusting volume to: 10
        Turning off the TV.
        Cannot adjust volume, TV is off.
        Turning on the TV.
        TV is already on.
         */
    }
}
