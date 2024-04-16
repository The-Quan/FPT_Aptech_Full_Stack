package session8;

public class StringExample {
    //String: ko the thay doi (immutable), it du lieu, cham nhat

    //===================//
    //StringBuffer: mutable; cho nhieu luong (thread), nhanh nhi
    //StringBuilder: mutable; cho mot luong, nhanh nhat
    //phu hop voi du lieu lon, de dat duoc hieu nang cao nhat

    //trong java String la 1 lop dac biet duoc vi su dung nhieu nhat trong java vi vay no doi hoi phai co hieu suat cao va linh hoat toi uu chinh vi do String class vua la primitive(nguyen thuy)
    String message = "hello java"; // primitive, luu tru trong stack 
    String objectString = new String("hello java"); // class, luu o heap
}
