package session8;

import java.util.Scanner;

public class ArrayExample {
    Scanner sc = new Scanner(System.in);

    public void createArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print("nhap gia tri " + i + " la: ");
            arr[i] = sc.nextInt();
        }
    }
    public void showArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public void ascSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) { // Sử dụng dấu ">" thay vì "<"
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void descSort(int arr[]){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) { // Sử dụng dấu ">" thay vì "<"
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
