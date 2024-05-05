package Slot_4.BaiTapThuVien.entity;

import java.util.Date;

public class NewBook {
    private int bookId;
    private String nameBook;
    private String nameTacGia;
    private double gia;

    private Date ngayNhap;
    private String trangThai;

    public NewBook(int bookId,String nameBook, String nameTacGia, double gia, Date ngayNhap, String trangThai) {
        this.bookId = bookId;
        this.nameBook = nameBook;
        this.nameTacGia = nameTacGia;
        this.gia = gia;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
    }
    public NewBook(){

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public  String getNameBook() {
        return nameBook;
    }

    public  void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getNameTacGia() {
        return nameTacGia;
    }

    public void setNameTacGia(String nameTacGia) {
        this.nameTacGia = nameTacGia;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NewBook{" +
                "nameBook='" + nameBook + '\'' +
                ", nameTacGia='" + nameTacGia + '\'' +
                ", gia=" + gia +
                ", ngayNhap=" + ngayNhap +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
