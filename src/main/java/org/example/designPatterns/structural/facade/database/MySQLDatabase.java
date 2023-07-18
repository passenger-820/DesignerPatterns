package org.example.designPatterns.structural.facade.database;

/**
 * mysql的执行
 */
public class MySQLDatabase implements Database{
    @Override
    public void execute(String sql) {
        System.out.println("Executing " + sql + " in MySQL database");
    }
}
