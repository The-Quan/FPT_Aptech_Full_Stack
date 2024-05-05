package Slot_4.controller;

import Slot_4.entity.Student;
import Slot_4.model.Studentipiplm;

import java.sql.SQLException;

public class ControllerStudent {
    Studentipiplm studentipiplm = new Studentipiplm();
    public void createStudent(Student student) throws SQLException {
        studentipiplm.createStudent(student);
    }
}
