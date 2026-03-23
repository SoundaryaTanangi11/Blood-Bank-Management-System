package ProjBack;
import java.sql.*;


public class ConnectionProvider {
    public static Connection getCon() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection
            		("jdbc:oracle:thin:@192.168.64.2:1521:xe","BloodBank","BloodBank");
            System.out.println("Alien DB connection" + connection);
          
            return connection;
            
            /*Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodBank", "root", "Alien@1110");
            System.out.println( +connection);
          
            return connection;*/
        }       
        catch(Exception e) {
            return null;
        }
    }
            
}
