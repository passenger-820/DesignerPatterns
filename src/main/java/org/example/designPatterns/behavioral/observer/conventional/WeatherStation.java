package org.example.designPatterns.behavioral.observer.conventional;

import java.util.ArrayList;

/**
 * 具体的主题
 */
public class WeatherStation implements Subject{
    //订阅了我这个主题的所有观察者
    private ArrayList<Observer> observers;
    // 温度
    private float temperature;
    // 湿度
    private float humidity;
    // 大气压
    private float pressure;
    //构造气象站主题
    public WeatherStation() {
        observers = new ArrayList<>();
    }

    //观测值发生变化，气象站修改数据
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        //因为发生了数据变动，所以需要通知所有观察者
        measurementsChanged();
    }

    //发生了数据变动，通知所有观察者
    private void measurementsChanged() {
        notifyObservers();
    }


    // 注册一个观察者的方法
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    // 移除一个观察者的方法
    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index >= 0){
            observers.remove(index);
        }
    }

    // 通知所有的观察者
    @Override
    public void notifyObservers() {
        //这里显然是单线程的
        for (Observer o : observers) {
            o.update(temperature,humidity,pressure);
        }
    }
}
