package session5.sessionObjectives;

public class TaxManage {
    private static final int MAX = 100;
    private Taxpayer[] list = new Taxpayer[MAX];
    private int count = 0;

    public boolean addTaxpayer(Taxpayer taxpayer){
        if(count >= MAX){
            return false;
        }
        list [count ++] = taxpayer;
        return true;
    }
    public double getTax(){
        double sum = 0;
        for(int i = 0; i < count; i++){
            sum += list[i].pay();
        }
        return sum;
    }
}
