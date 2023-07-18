package org.example.designPatterns.structural.facade.database;

/**
 * oracle的执行
 */
public class OracleDatabase implements Database{
    @Override
    public void execute(String sql) {
        System.out.println("Executing " + sql + " in Oracle database");
    }
}
