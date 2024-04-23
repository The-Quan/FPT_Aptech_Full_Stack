package statementss8;

public class LoginController {
    LoginDaoImpl loginDao = new LoginDaoImpl();
    //step 1
    public String loginStatementController(Users user){
        //step 2
        return loginDao.checkLoginStatement(user, password);
    }
    public String loginPreparedController(Users user){
        return loginDao.CheckLoginPreparedStatement(user);
    }
}
