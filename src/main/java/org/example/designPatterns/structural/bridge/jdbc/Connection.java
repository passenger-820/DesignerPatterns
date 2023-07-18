package org.example.designPatterns.structural.bridge.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 连接类，不同的数据库厂家提供的连接
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Connection {
    private String providerName;
}
