package org.example.designPatterns.structural.bridge.jdbc.abstractor;

import org.example.designPatterns.structural.bridge.jdbc.Connection;

/**
 * DriverManager抽象类，负责注册driver和获取连接
 * 得持有Driver
 */
public abstract class DriverManager {
    // 面向抽象，而不是具体的Driver实现
    private Driver driver;

    //获取连接
    public Connection getConnection(){
        return driver.connect();
    }

    //注册driver
    public void register(Driver driver){
        this.driver = driver;
    }
}
