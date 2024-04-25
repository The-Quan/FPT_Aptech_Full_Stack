package session8.model;

import session8.entity.Users;

import java.sql.*;

public class LoginDaoImpl implements LoginDAO {
    private static final Connection conn;

    static {
        try {
            conn = DBConnection.DataBase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Statement stm = null;
    private PreparedStatement pstm = null;

    @Override
    public String checkLoginStatement(Users user) {
        String query = "SELECT username FROM users WHERE username = '"+user.getUsername()+"'" + "AND password = '"+user.getPassword()+"'";
        try{
            //tạo lại
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                System.out.println("username: " + rs.getString("username"));
                return rs.getString("username");
            }
            return "Not in the database";
        }
        catch (SQLException e){
            e.printStackTrace();
            return "flase";
        }
    }

    @Override
    public String CheckLoginPreparedStatement(Users user) {
        String query = "SELECT username FROM users WHERE username like ? and password like ?";
        try {
            //tái sử dụng lại preparedStatement
            pstm = conn.prepareStatement(query);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("username is: " + rs.getString("username"));
                return rs.getString("username");
            }
           return "not in the database";
        } catch (SQLException e) {
            e.printStackTrace();
            return "false";
        }
    }
}
