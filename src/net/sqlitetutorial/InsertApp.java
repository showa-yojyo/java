package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class InsertApp extends AppBase{
    /**
     * The constructor
     *
     * @param args the command line arguments
     */
    public InsertApp(String[] args) {
        super(args);
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name name of the warehouse
     * @param capacity capacity of the warehouse
     */
    public void insert(String name, double capacity) {
        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "jdbc:sqlite:" + "../../test.db"
        InsertApp app = new InsertApp(args);
        // insert three new rows
        app.insert("Raw Materials", 3000);
        app.insert("Semifinished Goods", 4000);
        app.insert("Finished Goods", 5000);
    }
}
