package Slot_4.model;

import Slot_4.database.DatabaseThuVien;
import Slot_4.entity.Borrow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllStudentBorrowIplm implements AllStudentRorrow{
    public static Connection connection;

    static {
        try {
            connection = DatabaseThuVien.KetNoiDatebaseThuVien();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public final String SQL_AllBorrow = "SELECT s.student_id, s.student_name, s2.bookId, s2.nameBook, br.status, br.ngayMuon, br.ngayTra\n" +
            "FROM student s \n" +
            "INNER JOIN borrow br ON s.student_id = br.student_id\n" +
            "INNER JOIN sach s2 ON br.book_id = s2.bookId\n" +
            "WHERE s.student_id and s2.bookId ";

    @Override
    public List<Borrow> AllStudentRorrow(Borrow borrow1) throws SQLException {
        List<Borrow> borrows = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(SQL_AllBorrow);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Borrow borrow = new Borrow();
            borrow.setStudent_id(rs.getInt(1));
            borrow.setBook_id(rs.getInt(3));
            borrow.setStatus(rs.getInt(5));
            borrow.setBorrow_book(rs.getDate(6));
            borrow.setReturn_book(rs.getString(7));
            borrows.add(borrow);
        }
        return borrows;
    }
}
