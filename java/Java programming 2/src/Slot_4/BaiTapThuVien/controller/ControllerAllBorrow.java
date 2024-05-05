package Slot_4.BaiTapThuVien.controller;

import Slot_4.BaiTapThuVien.entity.Borrow;
import Slot_4.BaiTapThuVien.model.AllStudentBorrowIplm;

import java.sql.SQLException;
import java.util.List;

public class ControllerAllBorrow {
    AllStudentBorrowIplm allStudentBorrowIplm = new AllStudentBorrowIplm();
    public List<Borrow> AllBorrow(Borrow borrow) throws SQLException {
        AllStudentBorrowIplm allStudentRorrow = new AllStudentBorrowIplm();
        List<Borrow> allBorrow;
        allBorrow = allStudentRorrow.AllStudentRorrow(borrow);
        return allBorrow;
    }
}
