package Slot_4.model;


import Slot_4.entity.Student;

import java.sql.SQLException;

public interface StudentDAO {
    public void createStudent(Student student) throws SQLException;
}
