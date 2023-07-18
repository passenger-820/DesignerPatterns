package org.example.designPatterns.structural.facade.database;

/**
 * 数据库，能够执行sql
 */
public interface Database {
    void execute(String sql);
}
