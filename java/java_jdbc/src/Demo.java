import java.sql.*;

public class Demo {
    public static void main(String[] args) throws SQLException {

        String sql = "SELECT name FROM category WHERE category_id = 5;";
        String url = "jdbc:postgresql://localhost:5432/study";
        String username = "postgres";
        String password = "sql";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String name = rs.getString(1);
        System.out.println(name);
        rs.close();
        st.close();
        con.close();
    }
}
