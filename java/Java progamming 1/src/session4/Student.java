package session4;

public class Student {

    private String name;
    private String address;
    private  String bornYear;

    public Student(){

    }
    public Student(String name){
        this.name = name;
    }

    public Student(String name, String address, String bornYear) {
        this.name = name;
        this.address = address;
        this.bornYear = bornYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBornYear() {
        return bornYear;
    }

    public void setBornYear(String bornYear) {
        this.bornYear = bornYear;
    }

    @Override
    public String toString() {
        return getName() + " " + getAddress() + " " + getBornYear();
    }
}
