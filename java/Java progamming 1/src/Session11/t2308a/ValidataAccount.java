package Session11.t2308a;

public class ValidataAccount {
    // kiểm tra đăng nhập
    public final String MOBILE = "123456789";
    public final String PASSWORLD = "Nguyen Van A";

    public boolean checkAcount(String mobile, String password){
        if(mobile.equals(MOBILE)){
            if (password.equals(PASSWORLD)){
                System.out.println("Đăng nhập thành công");
                return true;
            }else{
                System.out.println("Mật khẩu sai, vui lòng nhập lại");
                return false;
            }
        }else{
            System.out.println("kiểm tra lại số điện thoại hoặc mật khẩu");
            return false;
        }
    }
}
