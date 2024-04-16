package luyenTapCode.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien  {
    // Khai báo một danh sách ArrayList chứa các đối tượng SinhVien
    private ArrayList<SinhVien> danhSach;
    public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
        this.danhSach = danhSach;
    }
    // Constructor mặc định của lớp DanhSachSinhVien
    public DanhSachSinhVien(){
        // Khởi tạo danh sách ArrayList
        this.danhSach = new ArrayList<SinhVien>();
    }
    // them sinh vien vao danh sach
    public void themSinhVien(SinhVien sv){
        this.danhSach.add(sv);
    }
    // in danh sach sinh vien
    public void inDanhSachSinhVien(){
        for (SinhVien sinhVien : danhSach){
            System.out.println(sinhVien);
        }
    }

    // kiem tra danh sach sinh vien co rong hay ko
    public boolean kiemTraDs(){
       return this.danhSach.isEmpty();
    }

    // lay ra so luong sinh vien trong danh sach
    public int laySoLuongSv(){
        return this.danhSach.size();
    }
    // lam rong danh sach
    public boolean lamRongDs(){
        return this.danhSach.removeAll(danhSach);
    }

    // kiem tra sinh vien co ton tai hay ko dua tren ma
    public boolean kiemTraTonTai(SinhVien sv){
        return this.danhSach.contains(sv);
    }

    // xoa 1 sinh vien ra khoi danh sach
    public boolean xoaSinhVien(SinhVien sv){
        return this.danhSach.remove(sv);
    }

    // tim tat ca sinh vien dua tren ten duoc nhap tu ban phim
    public  void  timSinVien(String ten){

    }

    // xuat ra danh sach sinh vien co diem tu cao den thap
    public void sapXepSinhVienGiamDanTheoDiem(){
        Collections.sort(this.danhSach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
              if(o1.getDiemTrungBinh() < o2.getDiemTrungBinh()){
                  return -1;
              }else if (o1.getDiemTrungBinh() > o2.getDiemTrungBinh() ){
                  return 1;
              }else {
                  return 0;
              }
            }
        });
    }
}
