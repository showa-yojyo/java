package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author sqlitetutorial.net
 */
public class SelectApp extends AppBase{
    /**
     * The consructor
     *
     * @param url SQLite connection string
     */
    public SelectApp(String url) {
        super(url);
    }

    /**
     * select all rows in the warehouses table
     */
    public void selectAll() {
        String sql = "SELECT id, name, capacity FROM warehouses";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Get the warehouse whose capacity greater than a specified capacity
     *
     * @param capacity
     */
    public void getCapacityGreaterThan(double capacity) {
        String sql = "SELECT id, name, capacity "
                + "FROM warehouses WHERE capacity > ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setDouble(1, capacity);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "jdbc:sqlite:" + "../../test.db"
        SelectApp app = new SelectApp("jdbc:sqlite:" + args[0]);
        //app.selectAll();
        app.getCapacityGreaterThan(3600);
    }
}
