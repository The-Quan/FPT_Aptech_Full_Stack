package statementss8;

import java.sql.*;

public class LoginDaoImpl implements LoginDAO{
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
    public String checkLoginStatement(Users user, String password) {
        String query = "SELECT username FROM users WHERE username = '"+user.getUsername()+"'" + "AND password = '"+user.getPassword(password)+"'";
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

    @Override
    public String CheckLoginPreparedStatement(Users user) {
        String query = "SELECT username FROM users WHERE username like ? and password like ?";
        try {
            pstm = conn.prepareCall(query);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword(query));
            ResultSet rs = pstm.executeQuery(query);
            while (rs.next()) {
                System.out.println("username is: " + rs.getString("username"));
                return rs.getString("username");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
