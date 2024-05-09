package StoreBook_2025.model;

import StoreBook_2025.dataBase.DBStoreBook;
import StoreBook_2025.entity.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMD implements LoginDao {
    public static final Connection conn;

    static {
        try {
            conn = DBStoreBook.DBStoreBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void LoginStore(Login login) throws SQLException {
        String query = "SELECT username FROM users WHERE username = ?'" + login.getUsername()+"'" + "AND password = ?'" + login.getPassword()+"'";
        PreparedStatement pstm = conn.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            pstm.setString(rs.getString(1));
        }
    }

    public static void main(String[] args) throws SQLException {
        Login login = new Login("quan123","quan");
        LoginMD loginMD = new LoginMD();
        loginMD.LoginStore(login);
    }
}
