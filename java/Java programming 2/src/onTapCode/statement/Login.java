package onTapCode.statement;

import session8.model.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login implements api{
    private static final Connection conn;

    static {
        try {
            conn = DBConnection.DataBase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Statement stm = null;
    @Override
    public String Statement(User user) {

        String query = "SELECT username FROM users WHERE username = '"+user.getUsername()+"'" + "AND password = '"+user.getPassword()+"'";
        try{
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
}
