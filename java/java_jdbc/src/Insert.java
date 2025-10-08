import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/study";
        String username = "postgres";
        String password = "sql";
        String sql = "INSERT INTO category (name) VALUES (?);";

        try (Connection con = DriverManager.getConnection(url, username, password); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "Massas");

            int rowsAffected = ps.executeUpdate();
            System.out.println("Linhas inseridas: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}
