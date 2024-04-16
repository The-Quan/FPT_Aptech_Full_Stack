package luyenTapCode.arrayList;

import java.util.Scanner;

public class TestArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        int luaChon = 0;
        do{
            System.out.println(
                    "--------Menu---------- \n" +
                    "1. them sinh vien vao danh sach. \n" +
                    "2. in danh sach sinh vien. \n" +
                    "3. kiem tra danh sach co rong hay khong. \n" +
                    "4. lay ra so luong sinh vien trong danh sach. \n" +
                    "5. lam rong danh sach sach sinh vien. \n" +
                    "6. kiem tra sinh vien co ton tai trong danh sach hay khong dua tren ma sinh vien. \n" +
                    "7. xoa mot sinh vien ra khoi danh sach dua tren ma sinh vien. \n" +
                    "8. tim kiem tat ca sinh vien dua tren ten duoc nhap tu ban phim. \n" +
                    "9. xuat danh sach sinh vien co diem tu cao den thap. \n" +
                    "0. thoat khoi truong trinh");

            System.out.println( );
            System.out.print("lua chon cua ban: ");
            luaChon = sc.nextInt();
            sc.nextLine();

//            switch (luaChon){
//                case 1:
//                    System.out.println("ok");
//            }
            // 1.them sinh vien
            if (luaChon == 1){
                System.out.print("nhap ma sv: ");
                String maSinhVien = sc.nextLine();

                System.out.print("nhap ho va ten: ");
                String hoVaTen = sc.nextLine();

                System.out.print("nhap nam sinh: ");
                int namSinh = sc.nextInt();

                System.out.print("nhap diem trung binh: ");
                float dtb = sc.nextFloat();

                SinhVien sv = new SinhVien(maSinhVien,hoVaTen,namSinh,dtb);
                dssv.themSinhVien(sv);

                // 2.in danh sach sinh vien
            }else if (luaChon == 2){
                dssv.inDanhSachSinhVien();

                // 3.kiem tra danh sach sinh vien co rong hay ko
            }else if (luaChon == 3){
                System.out.println("danh sách rỗng: " + dssv.kiemTraDs() );

                // 4.lay ra so luong sinh vien trong danh sach
            }else if (luaChon == 4){
                System.out.println("số lượng hiện tại: " + dssv.laySoLuongSv());

                // 5.lam rong danh sach sinh vien
            }else if (luaChon == 5){
                dssv.lamRongDs();

                // 6 kiem tra sinh vien co  ton tai trong danh sach hay ko dua tren ma sinh vien
            }else if (luaChon == 6){

            }else if (luaChon == 7){

            }else if (luaChon == 8){

            }else if (luaChon == 9){

            }
        }while(luaChon != 0);
    }
}
