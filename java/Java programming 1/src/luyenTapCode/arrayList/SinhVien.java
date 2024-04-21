package luyenTapCode.arrayList;

public class SinhVien implements Comparable<SinhVien>{
    private  String maMaSinhVien;
    private String hoVaTen;
    private int namSinh;
    private float diemTrungBinh;

    public SinhVien(String maMaSinhVien, String hoVaTen, int namSinh, float diemTrungBinh) {
        this.maMaSinhVien = maMaSinhVien;
        this.hoVaTen = hoVaTen;
        this.namSinh = namSinh;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getMaMaSinhVien() {
        return maMaSinhVien;
    }

    public void setMaMaSinhVien(String maMaSinhVien) {
        this.maMaSinhVien = maMaSinhVien;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public float getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maMaSinhVien = '" + maMaSinhVien + '\'' +
                ", hoVaTen = '" + hoVaTen + '\'' +
                ", namSinh = " + namSinh +
                ", diemTrungBinh = " + diemTrungBinh +
                '}';
    }
    @Override
    public int compareTo(SinhVien o) {
        return this.maMaSinhVien.compareTo(o.maMaSinhVien);
    }

}
