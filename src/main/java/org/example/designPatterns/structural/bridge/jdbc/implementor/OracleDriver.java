package org.example.designPatterns.structural.bridge.jdbc.implementor;

import org.example.designPatterns.structural.bridge.jdbc.Connection;
import org.example.designPatterns.structural.bridge.jdbc.abstractor.Driver;

public class OracleDriver implements Driver {
    @Override
    public Connection connect() {
        return new Connection("Oracle 提供的");
    }
}
