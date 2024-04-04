package btLyThuyet.inheritance;

public class KeThuaThuBac {
    void cat(){
        System.out.println("Con meo");
    }
}
class bac1 extends KeThuaThuBac{
    void dog(){
        System.out.println("con cho");
    }
}
class bac2 extends KeThuaThuBac{
    void bird(){
        System.out.println("con chim");
    }
}
class test2{
    public static void main(String[] args) {
        System.out.println("ket qua");
        bac1 k = new bac1();
      k.dog();
      k.cat();
        //   k.bird();ko run dc do chi dc run 1 bac
    }
}