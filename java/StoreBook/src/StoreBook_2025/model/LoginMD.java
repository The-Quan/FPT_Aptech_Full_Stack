package StoreBook_2025.model;

import StoreBook_2025.dataBase.DBStoreBook;
import StoreBook_2025.entity.Login;
import StoreBook_2025.view.ViewCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMD implements LoginDao<Login> {
    public static final Connection conn;

    static {
        try {
            conn = DBStoreBook.DBStoreBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ViewCustomer LoginStore(Login login){
        String query = "SELECT username FROM login WHERE username = '" + login.getUsername()+"'" + "AND password = '" + login.getPassword()+"'";
        try{
            //tạo lại
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery(query);
            while (rs.next()){
                ViewCustomer viewCustomer = new ViewCustomer();
                return viewCustomer;
            }
            System.out.println("ko thanh cong");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("false");
        }
        return null;
    }
    public static void main(String[] args) throws SQLException {
        Login login = new Login("quan123","quan");
        LoginMD loginMD = new LoginMD();
        loginMD.LoginStore(login);
    }
}
