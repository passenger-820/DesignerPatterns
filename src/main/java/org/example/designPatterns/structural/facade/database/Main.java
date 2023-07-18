package org.example.designPatterns.structural.facade.database;

public class Main {
    public static void main(String[] args) {
        DatabaseFacade databaseFacade = new DatabaseFacade();
        databaseFacade.executeSQL("select * from table","mysql");
        /*
        Executing select * from table in MySQL database
         */
    }
}
