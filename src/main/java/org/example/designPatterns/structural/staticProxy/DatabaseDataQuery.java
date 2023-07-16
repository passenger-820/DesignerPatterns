package org.example.designPatterns.structural.staticProxy;

/**
 * 数据查询类，它从数据库中检索数据
 */
public class DatabaseDataQuery implements DataQuery{
    @Override
    public String query(String queryKey) {
        // 查询数据库并返回结果
        return "This is your result from queryKey: " + queryKey;
    }
}
