package Slot_4.BaiTapThuVien.model;

import Slot_4.BaiTapThuVien.entity.Borrow;

import java.sql.SQLException;

public interface borrow {
    public void borrowBook (Borrow borrow) throws SQLException;
    public void returnBook (Borrow borrow) throws SQLException;

}
