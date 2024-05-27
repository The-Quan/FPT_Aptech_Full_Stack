package luyenTapCode;

public class test {
    public static class A {
        public int x = 10;
    }

    public static class B extends A {

        public int x = 20;

        public String display() {
            System.out.println(this.x);

            return null;
        }

    }

    public static void main(String[] args) {
        B b = new B();
        b.display();

    }
}



