package org.example.designPatterns.behavioral.observer.conventional;

public class Phone implements Observer{
    //保存观测数据
    private float temperature;
    private float humidity;
    private float pressure;
    //订阅的主题
    private Subject weatherStation;

    //构造自己，需要把自己注册到观测站
    public Phone(Subject weatherStation) {
        //拿到气象站
        this.weatherStation = weatherStation;
        //把自己注册进去
        weatherStation.registerObserver(this);
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
        //接到通知后，更新所有观测值，并展示
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    private void display() {
        System.out.println("Phone: Temperature: " + temperature + "°C, Humidity: " + humidity + "%, Pressure: " + pressure + " hPa");
    }
}
