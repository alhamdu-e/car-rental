import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnecter {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String USERNAME = "CAR";
    private static final String PASSWORD = "0000";
    Connection connection = null;

    public Connection conMethod() {

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
              if (connection != null) {
            System.out.println("Connected database successfully...");
        } else {
          System.out.println("nFailed to connect to Oracle DB");
        }
        }
            catch (ClassNotFoundException | SQLException e) {

         System.out.println(e);
        
        }
        return connection;
    }
    
}
