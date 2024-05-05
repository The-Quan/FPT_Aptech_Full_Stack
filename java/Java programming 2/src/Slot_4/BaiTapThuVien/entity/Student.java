package Slot_4.BaiTapThuVien.entity;

public class Student {
    private int student_id;
    private String student_name;
    private String email;
    private String phone;

    public Student(int student_id, String student_name, String email, String phone) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.email = email;
        this.phone = phone;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
