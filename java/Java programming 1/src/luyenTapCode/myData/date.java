package luyenTapCode.myData;

public class date {
    private int day;
    private int month;
    private int year;
    public date(int d, int m, int year){
        this.day = d;
        this.month = m;
        this.year = year;
    }
    public void printDat(){
        System.out.println("Day:  790-" + this.day);
    }public void printMonth(){
        System.out.println("Month: " + this.month);
    }
    public void printYear(){
        System.out.println("Year: " + this.year);
    }
    public void data(){
        System.out.println("data: " + this.day + "-" + this.month+ "-" +this.year);
    }
}
