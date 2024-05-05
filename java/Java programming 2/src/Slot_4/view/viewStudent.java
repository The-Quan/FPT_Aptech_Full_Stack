package Slot_4.view;

import Slot_4.controller.ControllerStudent;
import Slot_4.entity.Student;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class viewStudent {
    final Scanner sc;

    public viewStudent() {
        this.sc = new Scanner(System.in);
    }
    ControllerStudent controllerStudent = new ControllerStudent();
    public void createStudent() throws SQLException {
        System.out.println("------ create student --------");
        System.out.println("nhap id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("nhap name: ");
        String name = sc.nextLine();
        System.out.println("nhap email");
        String email = sc.nextLine();
        System.out.println("nhap phone: ");
        String phone = sc.nextLine();

        Student student = new Student(id,name,email,phone);
        controllerStudent.createStudent(student);
        System.out.println("====> thanh cong");
    }
}
