package org.example.designPatterns.structural.bridge.jdbc;

import org.example.designPatterns.structural.bridge.jdbc.abstractor.Driver;
import org.example.designPatterns.structural.bridge.jdbc.abstractor.DriverManager;
import org.example.designPatterns.structural.bridge.jdbc.implementor.DriverManagerOne;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        // 先创建一个驱动实例,我们可以通过反射来构建
        Driver driver = (Driver) Class.forName("org.example.designPatterns.structural.bridge.jdbc.implementor.OracleDriver").newInstance();

        //注册给driver管理
        DriverManager driverManager = new DriverManagerOne();
        driverManager.register(driver);

        Connection connection = driverManager.getConnection();
        System.out.println(connection);

        /*
        driver里面有connection，整个driver注册到了driverManager，进而从中拿到connection
         */
    }
}
