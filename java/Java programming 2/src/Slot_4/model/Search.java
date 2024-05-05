package Slot_4.model;

import Slot_4.entity.NewBook;

import java.sql.SQLException;
import java.util.List;

public interface Search {
    public List<NewBook> searchNameBook(String newBook) throws SQLException;

    public List<NewBook> searchTacGia(String newBook) throws SQLException;

    public List<NewBook> searchGia(double gia) throws SQLException;
}
