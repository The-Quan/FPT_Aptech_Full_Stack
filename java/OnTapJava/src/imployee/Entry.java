package imployee;

public class Entry {
    public static void main(String[] args) {
        PartimeEmployee partimeEmployee = new PartimeEmployee("quan",25,4);
        System.out.println("name: " + partimeEmployee.getName());
        System.out.println("paymentPerHour: " + partimeEmployee.getPaymentPerHour());
        System.out.println("working hour: " + partimeEmployee.getWorkingHour());
        System.out.println("parttime: " + partimeEmployee.calculateSalary());
        System.out.println("-------------------------");
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("nga",25);
        System.out.println("name: " + fullTimeEmployee.getName());
        System.out.println("paymentPerHour: " + fullTimeEmployee.getPaymentPerHour());
        System.out.println("working hour: 8");
        System.out.println("Fulltime: " + fullTimeEmployee.calculateSarary());
    }
}
