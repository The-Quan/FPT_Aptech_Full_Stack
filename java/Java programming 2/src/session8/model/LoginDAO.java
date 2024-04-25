package session8.model;

import session8.entity.Users;

public interface LoginDAO {
    public String checkLoginStatement(Users user);
    public String CheckLoginPreparedStatement(Users user);
}
