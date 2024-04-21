package session3.exercise1;

public class Client {
    public static class CheckClient{
        public static void main(String[] args) {
           Student studentA;
           Student studentB;
           Student studentC;

           studentA=new Student();
           studentB=new Student(2,"Nguyen Van B",true);
           studentC=new Student(4,"Nguyen Van C", true);

           studentA.printInfo();
           studentA.setName("Quan");
            studentA.printInfo();

           studentB.setName("Nguyen Van E");
           studentB.printInfo();

           studentC.setId(3);
           studentC.setName("Nguyen Van D");
           studentC.printInfo();


        }
    }
}
