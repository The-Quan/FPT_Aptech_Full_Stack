package btLyThuyet.interfaceInJava;

public class TestMayTinh {
    public static void main(String[] args) {
        System.out.println("Test-------------------------------------Test ");
        MayTinhFx500 mtFx = new MayTinhFx500();
        MayTinhVn500 mtVn = new MayTinhVn500();

        System.out.println("10 + 5 = " + mtFx.cong(10,5));
        System.out.println("10 + 5 = " + mtFx.tru(10,5));
        System.out.println("10 + 5 = " + mtFx.nhan(10,5));
        System.out.println("10 + 5 = " + mtFx.chia(10,5));

        System.out.println("Test-------------------------------------Test ");
        double[] arr = new double[]{1,5,3,7,3,9,3,7};
        double[] arr2 = new double[]{4,2,6,9,3,0,2,8};

        SapXepChen sxChen = new SapXepChen();
        SapXepChon sxChon = new SapXepChon();

        sxChen.sapXepTang(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "  ");
        }

        System.out.println();

        sxChon.sapXepGiam(arr2);
        for (int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i] + "  ");
        }
        System.out.println();
        System.out.println("Test-------------------------------------Test ");
        
        PhanMenMayTinh PmMt = new PhanMenMayTinh();
        System.out.println("20 + 5 = " + PmMt.cong(20,5));

        double[] arr3 = new double[]{9,7,4,8,2,7,8,5,3};
        PmMt.sapXepTang(arr3);
        for (int i = 0; i < arr3.length; i++){
            System.out.print(arr3[i] + "  ");
        }

    }
}
