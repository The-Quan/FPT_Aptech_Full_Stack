package Session10.entity;

import java.util.Scanner;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private double mark;

    public Student(int id, String firstName, String lastName, double mark) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }
    public void scanInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id: ");
        this.id = sc.nextInt();
        System.out.println("Enter first name: ");
        this.firstName = sc.nextLine();
        System.out.println("Enter last name: ");
        this.lastName = sc.nextLine();
        System.out.println("Enter mark: ");
        this.mark = sc.nextInt();
    }

    public void  printInfo(){
        System.out.printf("%3d|%10s%10a|%5f\n", getId(), getFirstName(),getLastName(),getMark());
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getMark() {
        return mark;
    }
}
