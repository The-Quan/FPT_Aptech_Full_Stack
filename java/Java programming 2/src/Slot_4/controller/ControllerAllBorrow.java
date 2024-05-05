package Slot_4.controller;

import Slot_4.entity.Borrow;
import Slot_4.model.AllStudentBorrowIplm;
import Slot_4.model.AllStudentRorrow;

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
