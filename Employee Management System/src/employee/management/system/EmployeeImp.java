
package employee.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class EmployeeImp implements EmployeeInt {

    Connection con;
    @Override
    public void createEmployee(Employee emp) {
        con=DBConnection.createDBConnection();
        String query = "insert into employee values(?,?,?,?)";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4, emp.getAge());
            
            int cnt = pstm.executeUpdate();
               if(cnt!=0)
               {
                   System.out.println("Employee inserted successfully!!");
               }
            
        } catch (Exception e)
        {
            System.out.println(e);
        }
        
    }

    @Override
    public void showAllEmployee() {
        con = DBConnection.createDBConnection();
        String query = "select * from employee";
        System.out.println("Employee Details:");        
        System.out.println("----------------------------------------------------");
        System.out.format("%S\t%S\t%S\t%S\t\n","Id","Name","Salary","Age");
        System.out.println("----------------------------------------------------");

        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4)
                        );
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void showEmployeeBasedOnID(int id) {
    
        con = DBConnection.createDBConnection();
        String query = "select * from employee where id ="+id;
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
             while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4)
                        );
            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    
    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnection();
        String query = "update employee set name=? where id = ?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt = pstm.executeUpdate();
            if(cnt!=0)
            {
                System.out.println("Employee Details Updated Succesfully!");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        
        con = DBConnection.createDBConnection();
        String query = "delete from employee where id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            int cnt = pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Deleted Successfully!"+id);
                
            
        }catch(Exception e)
        {
            System.out.println(e);
        }

    }
    
}
