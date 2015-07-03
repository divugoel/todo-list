import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
        } catch (Exception e) {
            System.out.println("Slite driver not found");
            return;
        }

        String url = "jdbc:sqlite:todo_list.db";

        try {
            Connection conn  = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            String query = "CREATE TABLE `list` ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `title` TEXT NOT NULL, `description` TEXT );";
            stmt.executeUpdate(query);
            
            String title = "Another task task";
            String description = "fladjg ahdjfoadf oahsdfoadf oaodshfoahd";

            query = "INSERT INTO list (title, description) values ('" + title + "', '" + description + "')";
            System.out.println(query);

            stmt.executeUpdate(query);


            ResultSet result = stmt.executeQuery("SELECT * from list");

            while(result.next()) {
                System.out.println("id: " + result.getInt("id"));
                System.out.println("title: " + result.getString("title"));
                System.out.println("description: " + result.getString("description"));
//                System.out.println("done: " + result.getBoolean("done"));
                System.out.println("\n\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
