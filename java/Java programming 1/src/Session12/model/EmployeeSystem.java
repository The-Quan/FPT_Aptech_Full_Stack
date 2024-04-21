package Session12.model;

import Session12.entity.Employee;
import btLyThuyet.encapsulation.Encapsulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class CustomExeption extends Exception {
    private static final long serialVersionUID = 1L;

    public CustomExeption(String str) {
        super();
        System.out.println(str);
        EmployeeSystem.operations();
    }
}
public class EmployeeSystem {
    public static Map<Integer, Employee> map = new HashMap<>();
    public static void addEmployee(String name, int age, int id){
        Employee emp = new Employee(name, age, id);
        map.put(id, emp);

        operations();
    }
    public static void deleteEmployee(int EmpId) throws CustomExeption{
        if(map.containsKey(EmpId)){
            map.remove(EmpId);
            System.out.println("Successfully Deleted from the list !!");
        }else {
            throw new CustomExeption("Not Found Exception");
        }
        operations();
    }
    public static void searchEmPloyee(int EmpId) throws CustomExeption{
        if(map.containsKey(EmpId)){
            // map.get(EmoId)
            System.out.println("Employee Details :- " + map.get(EmpId));
        }
      operations();
    }
    public static void employeeList(){
        System.out.println(map.toString());
    }
    public static void operations(){
        System.out.println("\n********* Employee management system *********** ");
        System.out.println("1. Add Employee");
        System.out.println("2. Delete Employee");
        System.out.println("3. Search Employee");
        System.out.println("4. Employee list");
        System.out.println();
        System.out.print("lua chon cua ban: ");

        Scanner sc = new Scanner(System.in);
            int  userInput = sc.nextInt();
            if (userInput == 1) {
                System.out.println("Enter Employee Details(Name, age, Id)");
                Scanner sc1 = new Scanner(System.in);

                String name = sc1.nextLine();
                int age = sc1.nextInt();
                int id = sc1.nextInt();

                if (!name.equals("") && age !=0 && id != 0){
                    addEmployee(name, age, id);
                }
            }else if (userInput == 2){
                System.out.println("Enter Employee Id");
                Scanner sc2 = new Scanner(System.in);

                int EmpId = sc2.nextInt();
                try{
                    deleteEmployee(EmpId);
                }catch (CustomExeption e){
                    // e.printStackTrace();
                }
            }else if(userInput == 3){
                System.out.println("Enter Employee Id");
                Scanner sc3 = new Scanner(System.in);

                int EmpId = sc3.nextInt();
                try{
                    searchEmPloyee(EmpId);

                }catch (CustomExeption e){
                    // e.printStackTrace;
                }
                operations();
            }else if (userInput == 4){
                employeeList();
                operations();
            }
    }

    public static void main(String[] args) {
        operations();
    }

}

