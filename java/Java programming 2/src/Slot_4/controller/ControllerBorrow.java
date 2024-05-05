package Slot_4.controller;

import Slot_4.entity.Borrow;
import Slot_4.model.Borrowimpl;

import java.sql.SQLException;

public class ControllerBorrow {
    Borrowimpl borrowimpl = new Borrowimpl();
    public void borrow(Borrow borrow) throws SQLException {
        borrowimpl.borrowBook(borrow);
    }
    public void returnBook(Borrow borrow) throws SQLException {
        borrowimpl.returnBook(borrow);
    }
}
