package JsonDataBase;



import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MDJsonDB implements IJsonDB{
    private static List<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void addStudent(Student student) throws SQLException, IOException {
        System.out.println("enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("enter name: ");
        String name = sc.nextLine();
        System.out.println("enter address: ");
        String address = sc.nextLine();
        System.out.println("enter email: ");
        String email = sc.nextLine();
        System.out.println("enter phone: ");
        String phone = sc.nextLine();
        System.out.println("enter DOB (yyyy-mm-dd)");
        String dob =sc.nextLine();

        Student student1 = new Student(id,name,address,email,phone,dob);
        students.add(student1);
        System.out.println("Student added successfully.");
    }

    @Override
    public void searchName(Student student) {
        System.out.print("Enter Name to search: ");
        String name = sc.nextLine();
        for (Student student1 : students) {
            if (student1.getName().equalsIgnoreCase(name)) {
                System.out.println(student1);
            }
        }
    }

    @Override
    public void searchEmail(Student student) {
        System.out.print("Enter Email to search: ");
        String email = sc.nextLine();
        for (Student students : students) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                System.out.println(students);
            }
        }
    }

    @Override
    public void getAll (Student student) throws SQLException {
        for (Student students : students) {
            System.out.println(students);
        }
    }


    public static void main(String[] args) {

    }
}
