import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySinhVien {
    private int id;
    private String name;
    private String assress;
    private String phoneNumber;
    private ArrayList<QuanLySinhVien> sinhViens = new ArrayList<>();

    public QuanLySinhVien(int id, String name, String assress, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.assress = assress;
        this.phoneNumber = phoneNumber;
    }

    public QuanLySinhVien() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssress() {
        return assress;
    }

    public void setAssress(String assress) {
        this.assress = assress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void themSinhVien() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------ Them Sinh Vien -----");
        System.out.println("nhap id");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("nhap name");
        String name = sc.nextLine();
        System.out.println("nhap address");
        String address = sc.nextLine();
        System.out.println("Phone number");
        String phone = sc.nextLine();

        QuanLySinhVien quanLySinhVien = new QuanLySinhVien(id, name, address, phone);
        sinhViens.add(quanLySinhVien);
        System.out.println(" thanh cong");
    }

    public List<QuanLySinhVien> showSinhVien() {
        System.out.println("----- tat ca sinh vien -----");
        for (QuanLySinhVien quanLySinhVien : sinhViens) {
            System.out.println("ID: " + quanLySinhVien.getId());
            System.out.println("Name: " + quanLySinhVien.getName());
            System.out.println("Phone: " + quanLySinhVien.getPhoneNumber());
            System.out.println("address: " + quanLySinhVien.getAssress());
            System.out.println("------------");
        }
        return sinhViens;
    }

    public static void main(String[] args) {
        QuanLySinhVien quanLySinhVien = new QuanLySinhVien();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----- menu -----");
            System.out.println("1, them sinh vien.   2, show sinh vien");
            System.out.print("nhap: ");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    quanLySinhVien.themSinhVien();
                    break;
                case 2:
                    quanLySinhVien.showSinhVien();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("nhap sai");
                    break;
            }

        }

    }
}
