package Slot_4.BaiTapThuVien.model;


import Slot_4.BaiTapThuVien.entity.Student;

import java.sql.SQLException;

public interface StudentDAO {
    public void createStudent(Student student) throws SQLException;
}
