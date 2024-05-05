package Slot_4.BaiTapThuVien.model;

import Slot_4.BaiTapThuVien.controller.ControllerBorrow;
import Slot_4.BaiTapThuVien.database.DatabaseThuVien;
import Slot_4.BaiTapThuVien.entity.Borrow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Borrowimpl implements borrow{
    private static Connection connection;
    static {
        try {
            connection = DatabaseThuVien.KetNoiDatebaseThuVien();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public final String SQL_BORROW = "INSERT INTO borrow VALUES(?,?,?,?,?)";
    private final String SQL_ReturnBook = "UPDATE borrow set status = ? WHERE student_id = ? AND book_id = ?";

    @Override
    public void borrowBook(Borrow borrow) throws SQLException {
        java.util.Date utilDate = borrow.getBorrow_book();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        PreparedStatement pstm = connection.prepareStatement(SQL_BORROW);
        pstm.setInt(1,borrow.getStudent_id());
        pstm.setInt(2,borrow.getBook_id());
        pstm.setInt(3,borrow.getStatus());
        pstm.setDate(4,sqlDate);
        pstm.setString(5,borrow.getReturn_book());
        pstm.executeUpdate();
    }

    @Override
    public void returnBook(Borrow borrow) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_ReturnBook);
        pstm.setInt(1,borrow.getStatus());
        pstm.setInt(2,borrow.getStudent_id());
        pstm.setInt(3,borrow.getBook_id());
        pstm.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {
        Borrow borrow = new Borrow(5,1,0,new Date(), "2025-1-24");
        ControllerBorrow controllerBorrow = new ControllerBorrow();
        controllerBorrow.borrow(borrow);
    }

}
