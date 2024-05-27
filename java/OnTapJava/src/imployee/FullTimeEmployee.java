package imployee;

public class FullTimeEmployee extends Employee{

    public FullTimeEmployee(String name, int paymentPerHour) {
        super(name, paymentPerHour);
    }
    public int calculateSarary(){
        return 8 * getPaymentPerHour();
    }
}
