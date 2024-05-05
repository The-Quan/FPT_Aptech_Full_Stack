package Slot_4.model;

import Slot_4.database.DatabaseThuVien;
import Slot_4.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Studentipiplm implements StudentDAO {
    public final Connection connection;

    {
        try {
            connection = DatabaseThuVien.KetNoiDatebaseThuVien();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String SQL_CreateStudent = "INSERT INTO student VALUES (?,?,?,?)";
    @Override
    public void createStudent(Student student) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_CreateStudent);
        pstm.setInt(1,student.getStudent_id());
        pstm.setString(2,student.getStudent_name());
        pstm.setString(3,student.getEmail());
        pstm.setString(4,student.getPhone());
        pstm.executeUpdate();
    }
}
