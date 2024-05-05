package Slot_4.model;

import Slot_4.database.DatabaseThuVien;
import Slot_4.entity.NewBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchBook implements Search{
    public static Connection connection;
    static {
        try{
            connection = DatabaseThuVien.KetNoiDatebaseThuVien();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public final String searchName = "SELECT * FROM Sach WHERE nameBook LIKE CONCAT('%', ?, '%')";
    public final String searchTacGia= "SELECT * FROM Sach WHERE nameTacgia LIKE CONCAT('%', ?, '%') ";
    public final String searchGia = "SELECT * FROM Sach WHERE gia LIKE ? ";


    @Override
    public List<NewBook> searchNameBook(String newBook) throws SQLException {
        List<NewBook> NewBooks = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(searchName);
        pstm.setString(1, newBook);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            NewBook newBook1 = new NewBook();
            newBook1.setBookId(resultSet.getInt(1));
            newBook1.setNameBook(resultSet.getString(2));
            newBook1.setNameTacGia(resultSet.getString(3));
            newBook1.setGia(resultSet.getDouble(4));
            newBook1.setNgayNhap(resultSet.getDate(5));
            newBook1.setTrangThai(resultSet.getString(6));
            NewBooks.add(newBook1);
        }
        return NewBooks;
    }

    @Override
    public List<NewBook> searchTacGia(String newBook) throws SQLException {
        List<NewBook> tenTacGia = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(searchTacGia);
        pstm.setString(1,newBook);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            NewBook newBook1 = new NewBook();
            newBook1.setBookId(rs.getInt(1));
            newBook1.setNameBook(rs.getString( 2));
            newBook1.setNameTacGia(rs.getString(3));
            newBook1.setGia(rs.getDouble( 4));
            newBook1.setNgayNhap(rs.getDate(5));
            newBook1.setTrangThai(rs.getString(6));
            tenTacGia.add(newBook1);
        }
      return tenTacGia;
    }

    @Override
    public List<NewBook> searchGia(double gia) throws SQLException {
        List<NewBook> newBooks = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(searchGia);
        pstm.setDouble(1,gia);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            NewBook newBook = new NewBook();
            newBook.setBookId(rs.getInt(1));
            newBook.setNameBook(rs.getString(2));
            newBook.setNameTacGia(rs.getString(3));
            newBook.setGia(rs.getDouble(4));
            newBook.setNgayNhap(rs.getDate(5));
            newBook.setTrangThai(rs.getString(6));
           newBooks.add(newBook);
        }
        return newBooks;
    }
}
