package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The base class for SelectApp, InsertApp, UpdateApp, DeleteApp, etc.
 */
abstract class AppBase {
    /** SQLite connection string */
    protected String url;

    /**
     * @param args
     */
    protected AppBase(String[] args) {
        // SQLite connection string
        this.url = "jdbc:sqlite:" + args[0];
    }

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    protected Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
