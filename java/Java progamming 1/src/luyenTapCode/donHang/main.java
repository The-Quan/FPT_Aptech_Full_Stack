package luyenTapCode.donHang;

public class main {
    public static void main(String[] args) {
    HoaDon hd = new HoaDon("Trung Nguyen", 200.000, 2);
        System.out.println("Tong tien: " + hd.tinhTongTien() + "VND");
        System.out.println("kien tra kl > 5kg: " + hd.kiemTraKhoiLuongLonHon(5));
        System.out.println("kien tra kl > 1kg: " + hd.kiemTraKhoiLuongLonHon(1));
        System.out.println("kien tra Tong Tien > 500k: " + hd.kiemTraTongTienLonHon500k());
        System.out.println("Giam gia cua hd: " + hd.giamGia(10.0));
    }
}
