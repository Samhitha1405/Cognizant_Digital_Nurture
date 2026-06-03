import java.sql.*;
public class JdbcTransaction {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:sqlite:bank.db");
        Statement s = con.createStatement();
        s.execute("CREATE TABLE IF NOT EXISTS accounts (id INT, balance REAL)");
        s.execute("DELETE FROM accounts");
        s.execute("INSERT INTO accounts VALUES (1, 1000)");
        s.execute("INSERT INTO accounts VALUES (2, 500)");
        con.setAutoCommit(false);
        try {
            PreparedStatement debit = con.prepareStatement("UPDATE accounts SET balance=balance-? WHERE id=?");
            PreparedStatement credit = con.prepareStatement("UPDATE accounts SET balance=balance+? WHERE id=?");
            debit.setDouble(1, 200); debit.setInt(2, 1); debit.executeUpdate();
            credit.setDouble(1, 200); credit.setInt(2, 2); credit.executeUpdate();
            con.commit();
            System.out.println("Transfer successful!");
            ResultSet rs = s.executeQuery("SELECT * FROM accounts");
            while (rs.next())
                System.out.println("Account " + rs.getInt("id") + ": $" + rs.getDouble("balance"));
        } catch (Exception e) {
            con.rollback();
            System.out.println("Transfer failed! Rolled back. Error: " + e.getMessage());
        }
        con.close();
    }
}