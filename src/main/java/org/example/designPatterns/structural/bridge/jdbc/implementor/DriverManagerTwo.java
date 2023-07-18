package org.example.designPatterns.structural.bridge.jdbc.implementor;

import org.example.designPatterns.structural.bridge.jdbc.Connection;
import org.example.designPatterns.structural.bridge.jdbc.abstractor.DriverManager;

public class DriverManagerTwo extends DriverManager {
    @Override
    public Connection getConnection() {
        System.out.println("这是由DriverManagerTwo来管理的连接。");
        //返回连接，直接调用父类的方法
        return super.getConnection();
    }
}
