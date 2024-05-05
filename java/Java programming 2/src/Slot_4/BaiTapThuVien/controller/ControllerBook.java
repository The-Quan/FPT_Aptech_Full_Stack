package Slot_4.BaiTapThuVien.controller;

import Slot_4.BaiTapThuVien.entity.NewBook;
import Slot_4.BaiTapThuVien.model.ThuVienBook;

import java.sql.SQLException;

public class ControllerBook {
    ThuVienBook thuVienBook = new ThuVienBook();
    public void createBook(NewBook newBook) throws SQLException {
        thuVienBook.Book(newBook);
    }
}
