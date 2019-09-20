package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResourceMethods {

    static final String JDBC_Driver = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:./Database/Resource";

    static final String USER = "";
    static final String PASS = "";

    public void connectDatabase() {
        Connection connect = null;

        try {
            System.out.println("Attempting to connect to DB...");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to DB!");

        } catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public void closeDatabase() {

    }
}
