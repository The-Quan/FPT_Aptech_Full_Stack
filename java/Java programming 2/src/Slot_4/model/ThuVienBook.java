package Slot_4.model;

import Slot_4.database.DatabaseThuVien;
import Slot_4.entity.NewBook;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThuVienBook implements ThuVien{
    public static Connection connection;
    static {
        try{
            connection = DatabaseThuVien.KetNoiDatebaseThuVien();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public final String SQL_CREATE_BOOK = "INSERT INTO Sach values (?,?,?,?,?,?)";
    @Override
    public void Book(NewBook newBook) throws SQLException {
        java.util.Date utilDate = newBook.getNgayNhap();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        PreparedStatement pstm = connection.prepareStatement(SQL_CREATE_BOOK);
        pstm.setInt(1,newBook.getBookId());
        pstm.setString(2,newBook.getNameBook());
        pstm.setString(3,newBook.getNameTacGia());
        pstm.setDouble(4,newBook.getGia());
        pstm.setDate(5, sqlDate);
        pstm.setString(6,newBook.getTrangThai());
        pstm.executeUpdate();
    }
}
