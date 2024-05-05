package Slot_4.BaiTapThuVien.controller;

import Slot_4.BaiTapThuVien.entity.NewBook;
import Slot_4.BaiTapThuVien.model.SearchBook;

import java.sql.SQLException;
import java.util.List;

public class ControllerSearch {
    SearchBook searchBook = new SearchBook();
    public List<NewBook> searchName(String newBook) throws SQLException {
        SearchBook searchBook1 = new SearchBook();
        List<NewBook> newBooks;
        newBooks = searchBook1.searchNameBook(newBook);
        return newBooks;
    }
    public List<NewBook> searchGiaController(double gia) throws SQLException {
        SearchBook searchBook1 = new SearchBook();
        List<NewBook> newBooks;
        newBooks = searchBook1.searchGia(gia);
        return  newBooks;
    }
    public List<NewBook> searchTacGia(String newBook) throws SQLException{
        SearchBook searchBook1 = new SearchBook();
        List<NewBook> tacgia;
        tacgia = searchBook1.searchTacGia(newBook);
        return tacgia;
    }
}
