import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println("Mysql driver not found");
            return;
        }

        String url = "jdbc:mysql://localhost/todo_list";
        String username = "codekamp";
        String password = "codekamp.in";


        try {
            Connection conn  = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * from list WHERE id = 1");

            while(result.next()) {
                System.out.println("id: " + result.getInt("id"));
                System.out.println("title: " + result.getString("title"));
                System.out.println("description: " + result.getString("description"));
                System.out.println("done: " + result.getBoolean("done"));
                System.out.println("\n\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
