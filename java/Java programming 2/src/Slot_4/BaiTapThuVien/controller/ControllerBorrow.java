package Slot_4.BaiTapThuVien.controller;

import Slot_4.BaiTapThuVien.entity.Borrow;
import Slot_4.BaiTapThuVien.model.Borrowimpl;

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
