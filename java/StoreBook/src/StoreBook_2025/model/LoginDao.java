package StoreBook_2025.model;


import StoreBook_2025.entity.Login;

import java.sql.SQLException;

public interface LoginDao {
    public void LoginStore(Login login) throws SQLException;
}
