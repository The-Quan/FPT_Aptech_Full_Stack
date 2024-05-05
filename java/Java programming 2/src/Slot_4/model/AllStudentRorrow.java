package Slot_4.model;

import Slot_4.entity.Borrow;

import java.sql.SQLException;
import java.util.List;

public interface AllStudentRorrow {
    public List<Borrow> AllStudentRorrow(Borrow borrow) throws SQLException;
}
