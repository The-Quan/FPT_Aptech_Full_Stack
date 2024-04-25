package statementss8.controller;

import statementss8.model.LoginDaoImpl;
import statementss8.entity.Users;

public class LoginController {
    LoginDaoImpl loginDao = new LoginDaoImpl();
    private String password;

    //step 1
    public String loginStatementController(Users user){
        //step 2
        return loginDao.checkLoginStatement(user);
    }
    public String loginPreparedController(Users user){
        return loginDao.CheckLoginPreparedStatement(user);
    }
}
