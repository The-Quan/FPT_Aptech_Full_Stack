package Slot_4.controller;

import Slot_4.entity.NewBook;
import Slot_4.model.ThuVienBook;

import java.sql.SQLException;

public class ControllerBook {
    ThuVienBook thuVienBook = new ThuVienBook();
    public void createBook(NewBook newBook) throws SQLException {
        thuVienBook.Book(newBook);
    }
}
