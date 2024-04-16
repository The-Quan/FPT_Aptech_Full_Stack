package session8;

import java.util.Scanner;

public class ApplicationClient {
    public static void main(String[] args) {
        ArrayExample ax = new ArrayExample();
        System.out.print("ban muon luu bao nhieu pt mang: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int intArray[] = new int[size];//int type mang tam thoi
        // student st; // object type

        //truyen mang tam cho ham createArray(int arr[])
        ax.createArray(intArray);
        System.out.print("mang vua nhap la: " );
        ax.showArray(intArray);
        System.out.println();

        System.out.print("mang sau khi sap xep tang dan: ");
        ax.ascSort(intArray);
        System.out.println();

        System.out.print("mang sau khi sap xep giam dan: ");
        ax.descSort(intArray);
    }
}
