package session4;

public class ApplicationDemo {
    public static void main(String[] args) {
        // tao doi tuong
        Student student = new Student("Quan","Bac Kan","2005");
        System.out.println("student info: " + student.toString());


        Student student1 = new Student();
        student1.setName("Quan");
        student1.setAddress("Ha Noi");
        student1.setBornYear("2004");
        System.out.println("student1 info: " + student1.toString());


        Student student2 = new Student("Quan");
        System.out.println("student2 info: " + student2.toString());


    }
}
