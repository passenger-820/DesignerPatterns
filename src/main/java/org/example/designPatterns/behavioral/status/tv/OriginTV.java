package org.example.designPatterns.behavioral.status.tv;

/**
 * 一个简易的电视遥控器，具有开启、关闭和调整音量的功能。
 * 不使用设计模式，需要针对电视机当前的状态为每一次操作编写判断逻辑：
 * 即【希望实现某功能时，才做状态判断】
 * 我们的状态比较少，所以代码看起来也不是很复杂，但是状态如果变多了呢？
 * 为了解决这种问题，可以考虑把状态及每个状态下有的功能都定义好，不同的状态下可以实现具体的功能
 */
public class OriginTV {
    private boolean isOn;
    private int volume;

    public OriginTV() {
        isOn = false;
        volume = 0;
    }

    public void turnOn() {
        // 如果是开启状态
        if (isOn) {
            System.out.println("TV is already on.");
            // 否则打开电视
        } else {
            isOn = true;
            System.out.println("Turning on the TV.");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Turning off the TV.");
        } else {
            System.out.println("TV is already off.");
        }
    }

    public void adjustVolume(int volume) {
        if (isOn) {
            this.volume = volume;
            System.out.println("Adjusting volume to: " + volume);
        } else {
            System.out.println("Cannot adjust volume, TV is off.");
        }
    }

    public static void main(String[] args) {
        OriginTV tv = new OriginTV();

        tv.turnOn();
        tv.adjustVolume(10);
        tv.turnOff();
    }
}
