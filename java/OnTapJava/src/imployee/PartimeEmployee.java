package imployee;

public class PartimeEmployee extends Employee{
    private int workingHour;

    public PartimeEmployee(String name, int paymentPerHour, int workingHour) {
        super(name, paymentPerHour);
        this.workingHour = workingHour;
    }

    public int getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    public int calculateSalary(){
        return workingHour * getPaymentPerHour();
    }
}
