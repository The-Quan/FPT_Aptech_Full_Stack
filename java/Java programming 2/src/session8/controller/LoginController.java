package session8.controller;

import session8.model.LoginDaoImpl;
import session8.entity.Users;

public class LoginController {
    LoginDaoImpl loginDao = new LoginDaoImpl();
    private String password;

    //step 1
    public String loginStatementController(Users user){
        //step 2 ,3 call model and return to view
        return loginDao.checkLoginStatement(user);
    }
    public String loginPreparedController(Users user){
        return loginDao.CheckLoginPreparedStatement(user);
    }
}
