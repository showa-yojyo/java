package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class CreateTable {
    /**
     * Create a new table in the test database
     *
     * @param url SQLite connection string
     */
    public static void createNewTable(String url) {
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // SQL statement for creating a new table
            String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                    + "	id integer PRIMARY KEY,\n"
                    + "	name text NOT NULL,\n"
                    + "	capacity real\n"
                    + ");";

            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "jdbc:sqlite:" + "../../test.db"
        createNewTable("jdbc:sqlite:" + args[0]);
    }

}
