package Slot_4.BaiTapThuVien.model;

import Slot_4.BaiTapThuVien.entity.NewBook;

import java.sql.SQLException;

public interface ThuVien {
    public void Book(NewBook newBook) throws SQLException;
}
