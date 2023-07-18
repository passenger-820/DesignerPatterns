package org.example.designPatterns.structural.bridge.jdbc.abstractor;

import org.example.designPatterns.structural.bridge.jdbc.Connection;

/**
 * Driver抽象，能够连接数据库
 */
public interface Driver {
    Connection connect();
}
