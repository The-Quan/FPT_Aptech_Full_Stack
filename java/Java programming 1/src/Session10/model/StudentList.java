package Session10.model;

import Session10.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentList {
private ArrayList<Student> list;
private int length;

public StudentList(){
    list = new ArrayList<>();
}
public ArrayList<Student> findByName(String name) {
    boolean found = false;
    ArrayList<Student> matches = new ArrayList<>();
    for (Student s : list) {
        String fullName = new String(s.getFirstName() + " " + s.getLastName()).toLowerCase();
        if(fullName.matches("(.*)" + name.toLowerCase() + "(.*)")){
            matches.add(s);
            found = true;
        }
    }
    if (found == false){
        System.out.println("Not found");
    }
    return matches;
}
public Student findById(int id){
    for(Student s:list){
        if(s.getId() == id){
            return s;
        }
    }
    return null;
}
public void add(Student s){
    list.add(s);
}
public void remove(int id){
    boolean found = false;
    for(Student s:list){
        if(s.getId() == id){
            int choice;
            System.out.println("Are you sure deleting this student? (1.Yes 2.No");
            choice = new Scanner(System.in).nextInt();
            if (choice == 1)
                list.remove(s);
            found = true;
        }
    }
    if (found == false){
        System.out.println("Can not find student with id " + id);
    }
}
public void sortByMarks(){
    Collections.sort(list, new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return 0;
        }
    });
}
public void showList(){
    for(Student s: list){
        s.printInfo();
    }
}
public void showList(ArrayList<Student> slist){
    for(Student s: list){
        s.printInfo();
    }
}
}
