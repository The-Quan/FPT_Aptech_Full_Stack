package luyenTapCode.donHang;

public class HoaDon {
    private String tenLoaiCafe;
    private Double giaTien1kg;
    private Integer khoiLuong;

    public  HoaDon(String ten, Double gia, Integer kl)
    {
        this.tenLoaiCafe = ten;
        this.giaTien1kg = gia  ;
        this.khoiLuong = kl;
    }
    public Double tinhTongTien(){
        return this.giaTien1kg * this.khoiLuong ;
    }
    public Boolean kiemTraKhoiLuongLonHon(Integer kl){
        return this.khoiLuong > kl;
    }
    public Boolean kiemTraTongTienLonHon500k(){
        return this.tinhTongTien() > 500.000;
    }
    public Double giamGia(Double x) {
        if (this.tinhTongTien() > 500.000) {
            return (x / 100) * this.tinhTongTien();
        }else{
           System.out.println("Ko dung yeu cau");
           return 0.0;
        }
    }
}
