
package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    
    static Connection con;
    public static Connection createDBConnection() // this method will return connection.
    {
       
        try{
             // load driver
//             Class.forName("com.mysql.jdbc.Driver");
             
             // get connection
             String url="jdbc:mysql://localhost:3306/employeeDB";
             String username="root";
             String password="root";
             // Drivermanager class is having getconn method.
             con=DriverManager.getConnection(url,username,password);
             
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }

    static Connection createDBconnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
