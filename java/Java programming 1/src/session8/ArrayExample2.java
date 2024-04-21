package session8;

import java.util.Arrays;
import java.util.Collections;

public class ArrayExample2 {
    public static void main(String[] args) {
        //kiểu nguyên bản (primitive) int, float, double,string
        int[] numbers = new int[]{9,1,7,4,8,3,7,4};

        //kiểu tham chiếu class(deferdnce) kiểu "bao bọc" Integer, Float, Double,
        Integer[] nums = {9,1,7,4,8,3,7,4};

        //tang dan
        Arrays.sort(numbers);

        //giam dan
        Arrays.sort(nums, Collections.reverseOrder());

        //chon vung sap xep
        Arrays.sort(numbers, 2,4);
        //foreach: lap trong 1 tap hop cac collection(object)

        for(int num : numbers){
            System.out.println("Numbers: " + num);
        }

        String [] student = new String[]{"ngay", "hom", "nay"};
        //foreach
        for (String stu : student){
            System.out.println(stu);
        }

}
}
