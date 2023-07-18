package org.example.designPatterns.structural.facade.database;

/**
 * 数据库门面，甭管你用哪家数据库，都从我这走
 */
public class DatabaseFacade {
    private Database mysqlDatabase;
    private Database oracleDatabase;

    public DatabaseFacade() {
        mysqlDatabase = new MySQLDatabase();
        oracleDatabase = new OracleDatabase();
    }

    // 你只管输入数据库类型和具体的sql即可，其他的交由门面来做
    public void executeSQL(String sql, String databaseType) {
        if (databaseType.equals("mysql")){
            mysqlDatabase.execute(sql);
        } else if (databaseType.equals("Oracle")) {
            oracleDatabase.execute(sql);
        } else {
            throw new IllegalArgumentException("Unknown database type: " + databaseType);
        }
    }
}
