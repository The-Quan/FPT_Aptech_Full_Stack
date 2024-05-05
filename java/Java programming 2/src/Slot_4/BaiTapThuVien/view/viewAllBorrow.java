package Slot_4.BaiTapThuVien.view;

import Slot_4.BaiTapThuVien.controller.ControllerAllBorrow;
import Slot_4.BaiTapThuVien.entity.Borrow;

import java.sql.SQLException;
import java.util.List;

public class viewAllBorrow {
    ControllerAllBorrow controllerAllBorrow = new ControllerAllBorrow();
    public void AllBorrow() throws SQLException {
        Borrow borrow = new Borrow();
        System.out.println("------ All Student Borrow -----");
        ControllerAllBorrow controllerAllBorrow1 = new ControllerAllBorrow();
        List<Borrow> borrows = controllerAllBorrow1.AllBorrow(borrow);
        for (Borrow borrow1 : borrows){
            System.out.println(borrow1.getStudent_id());
            System.out.println(borrow1.getBook_id());
            System.out.println(borrow1.getStatus());
            System.out.println(borrow1.getBorrow_book());
            System.out.println(borrow1.getReturn_book());
            System.out.println();
        }

    }
}
