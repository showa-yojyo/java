package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class UpdateApp extends AppBase{
    /**
     * The consructor
     *
     * @param args the command line arguments
     */
    public UpdateApp(String[] args) {
        super(args);
    }

    /**
     * Update data of a warehouse specified by the id
     *
     * @param id
     * @param name     name of the warehouse
     * @param capacity capacity of the warehouse
     */
    public void update(int id, String name, double capacity) {
        String sql = "UPDATE warehouses SET name = ? , "
                + "capacity = ? "
                + "WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.setInt(3, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UpdateApp app = new UpdateApp(args);
        // update the warehouse with id 3
        app.update(3, "Finished Products", 5500);
    }

}
