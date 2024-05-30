package baithithuchanh;

import java.util.List;
import java.util.Scanner;

public class Management {
    public static void main(String[] args) {
        List<Student> students = Manager.readStudentsFromFile();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Hiển thị toàn bộ sinh viên");
            System.out.println("2. Thêm sinh viên mới");
            System.out.println("3. Sửa thông tin sinh viên");
            System.out.println("4. Tìm kiếm sinh viên theo Tên hoặc ID");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayAllStudents(students);
                    break;
                case 2:
                    Student newStudent = inputStudent();
                    students.add(newStudent);
                    Manager.writeStudentsToFile(students);
                    System.out.println("Thêm sinh viên thành công.");
                    break;
                case 3:
                    editStudent(students);
                    break;
                case 4:
                    searchStudent(students);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    private static void displayAllStudents(List<Student> students) {
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    private static Student inputStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = new Student(id, name);
        // Add subjects and scores
        System.out.print("Enter number of subjects: ");
        int numOfSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.print("Enter subject name: ");
            String subjectName = scanner.nextLine();
            System.out.print("Enter scores (separated by space): ");
            String[] scoresStr = scanner.nextLine().split(" ");
            int[] scores = new int[scoresStr.length];
            for (int j = 0; j < scoresStr.length; j++) {
                scores[j] = Integer.parseInt(scoresStr[j]);
            }
            student.addSubject(new Subject(subjectName, scores));
        }
        return student;
    }

    private static void editStudent(List<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID or Name: ");
        String keyword = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(keyword) || student.getName().equals(keyword)) {
                // Add or remove subjects and scores
                // Implement your logic here
                Manager.writeStudentsToFile(students);
                System.out.println("Student information updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void searchStudent(List<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID or Name: ");
        String keyword = scanner.nextLine();
        System.out.println("Search result for '" + keyword + "':");
        boolean found = false;
        for (Student student : students) {
            if (student.getId().equals(keyword) || student.getName().equals(keyword)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching student found.");
        }
    }
}