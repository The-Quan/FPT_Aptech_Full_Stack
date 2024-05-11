package StoreBook_2025.model;


import StoreBook_2025.entity.Login;
import StoreBook_2025.view.ViewCustomer;

import java.sql.SQLException;

public interface LoginDao<T> {
    public ViewCustomer LoginStore(T n) throws SQLException;
}
