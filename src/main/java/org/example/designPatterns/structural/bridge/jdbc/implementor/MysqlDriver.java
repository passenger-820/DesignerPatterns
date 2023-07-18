package org.example.designPatterns.structural.bridge.jdbc.implementor;

import org.example.designPatterns.structural.bridge.jdbc.Connection;
import org.example.designPatterns.structural.bridge.jdbc.abstractor.Driver;

public class MysqlDriver implements Driver {
    @Override
    public Connection connect() {
        return new Connection("mysql 提供的");
    }
}
