import java.sql.*;
public class StudentDAO {
    Connection con;
    StudentDAO() throws Exception {
        con = DriverManager.getConnection("jdbc:sqlite:students.db");
        con.createStatement().execute("CREATE TABLE IF NOT EXISTS students (id INT, name TEXT)");
    }
    void insert(int id, String name) throws Exception {
        PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES (?, ?)");
        ps.setInt(1, id); ps.setString(2, name);
        ps.executeUpdate();
        System.out.println("Inserted: " + name);
    }
    void update(int id, String name) throws Exception {
        PreparedStatement ps = con.prepareStatement("UPDATE students SET name=? WHERE id=?");
        ps.setString(1, name); ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Updated ID " + id + " to: " + name);
    }
    public static void main(String[] args) throws Exception {
        StudentDAO dao = new StudentDAO();
        dao.insert(1, "Alice");
        dao.insert(2, "Bob");
        dao.update(2, "Bobby");
        dao.con.close();
    }
}