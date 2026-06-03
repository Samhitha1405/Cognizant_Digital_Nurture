import java.sql.*;
public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:sqlite:students.db");
        Statement stmt = con.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS students (id INT, name TEXT)");
        stmt.execute("INSERT INTO students VALUES (1, 'Alice')");
        stmt.execute("INSERT INTO students VALUES (2, 'Bob')");
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
        }
        con.close();
    }
}