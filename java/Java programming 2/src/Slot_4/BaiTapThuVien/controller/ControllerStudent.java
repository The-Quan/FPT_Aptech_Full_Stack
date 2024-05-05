package Slot_4.BaiTapThuVien.controller;

import Slot_4.BaiTapThuVien.entity.Student;
import Slot_4.BaiTapThuVien.model.Studentipiplm;

import java.sql.SQLException;

public class ControllerStudent {
    Studentipiplm studentipiplm = new Studentipiplm();
    public void createStudent(Student student) throws SQLException {
        studentipiplm.createStudent(student);
    }
}
