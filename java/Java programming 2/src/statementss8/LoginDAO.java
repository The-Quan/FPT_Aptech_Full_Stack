package statementss8;

public interface LoginDAO {
    public String checkLoginStatement(Users user, String password);
    public String CheckLoginPreparedStatement(Users user);
}
