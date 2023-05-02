
package employee.management.system;
import java.util.*; // Scanner class

public class Main {
    
    public static void main(String[] args)
    {
        String name;
        int id;
        EmployeeInt obj1 = new EmployeeImp();
        System.out.println("Welcome Employee Management System");
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1. Add Employee\n"+
                    "2. Show all employee\n"+
                    "3. Show Employee Based On Id\n"+
                    "4. Update Employee\n"+
                    "5. Delete Empolyee\n" );
            System.out.println("Enter Your Choice");
            int ch=sc.nextInt();
            switch(ch){
                case 1 :
                    Employee emp = new Employee();
                    System.out.println("Enter Id: ");
                    id = sc.nextInt();
                    System.out.println("Enter Name: ");
                    name = sc.next();
                    System.out.println("Enter Salary: ");
                    double salary = sc.nextDouble();
                    System.out.println("Enter Salary: ");
                    int age = sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);

                    obj1.createEmployee(emp);
                    break;
                
                case 2: 
                    obj1.showAllEmployee();
                    break;
                    
                case 3:
                    System.out.println("Enter emmployee id");
                    int empid = sc.nextInt();
                    obj1.showEmployeeBasedOnID(empid);
                    break;
                 
                case 4:
                    System.out.println("Enter id to update the details");
                    int empid1 = sc.nextInt();
                    System.out.println("Enter the new Name");
                    name = sc.next();
                    obj1.updateEmployee(empid1,name);
                    break;
                case 5 :
                    System.out.println("Enter id to delete the employee:");
                    id = sc.nextInt();
                    obj1.deleteEmployee(id);
                    break;
                        
                case 6 :
                    System.out.println("Thank for using application");
                    System.exit(0);
                default:
                    System.out.println("Please Enter Correct Choice");
                    break;
            }
                   
        }while(true);
        
    }
}
