package statementss8.model;

import statementss8.entity.Users;

public interface LoginDAO {
    public String checkLoginStatement(Users user);
    public String CheckLoginPreparedStatement(Users user);
}
