package org.example.designPatterns.behavioral.observer.conventional;

public class Main {
    public static void main(String[] args) {
        //气象站，这里用Subject的话，会拿不到weatherStation.setMeasurements()
        WeatherStation weatherStation = new WeatherStation();
        //订阅气象站的终端，目前只有两个
        Observer phone = new Phone(weatherStation);
        Observer website = new Website(weatherStation);
        //气象站数据更新
        weatherStation.setMeasurements(25, 65, 1010);
        System.out.println("-------------------------------------------");
        weatherStation.setMeasurements(22, 58, 1005);
        System.out.println("-------------------------------------------");
        //新的订阅气象站的终端，目前共3个
        Observer pad = new Pad(weatherStation);
        weatherStation.setMeasurements(18, 52, 1008);
    }
}
