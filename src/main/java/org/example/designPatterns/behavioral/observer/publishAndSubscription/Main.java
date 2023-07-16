package org.example.designPatterns.behavioral.observer.publishAndSubscription;

public class Main {
    public static void main(String[] args) {
        // 订阅者
        Subscriber app = new App();
        Subscriber web = new Web();
        //事件总线
        EventBus eventBus = new EventBus();

        // 注册订阅者，让他订阅某类事件
        eventBus.registerSubscriber("changeTemperature",app);
        eventBus.registerSubscriber("changeTemperature",web);
        eventBus.registerSubscriber("changePressure",web);

        //气象站
        WeatherStation weatherStation = new WeatherStation(eventBus);
        //模拟改变温度、气压
        weatherStation.changeTemperature(33.5F);
        weatherStation.changePressure(1011.0F);
        System.out.println("--------------------------");
        //不让web订阅温度
        eventBus.removeSubscriber("changeTemperature",web);
        //模拟改变温度、气压
        weatherStation.changeTemperature(30.5F);
        weatherStation.changePressure(1012.0F);
    }
}
