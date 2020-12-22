import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbo {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=master";
        String user = "sa";
        String password = "Hej12345";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO patient\n" +
                    "VALUES (123456789,'Hans','bolo','m','stationsvagn 19',0735333," +
                    "'1998-01-16','1000-01-01',12345678)";

            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);

            if (rows > 0){
                System.out.println("Row has been inserted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
