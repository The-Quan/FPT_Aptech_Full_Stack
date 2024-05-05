package Slot_4.model;

import Slot_4.entity.Borrow;

import java.sql.SQLException;

public interface borrow {
    public void borrowBook (Borrow borrow) throws SQLException;
    public void returnBook (Borrow borrow) throws SQLException;

}
