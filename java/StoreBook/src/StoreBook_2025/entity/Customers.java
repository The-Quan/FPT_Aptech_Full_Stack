package StoreBook_2025.entity;

public class Customers {
    private int customer_id;
    private String name;
    private String email;
    private String phone;

    public Customers(int customer_id, String name, String email, String phone) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Customers() {

    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customerId) {
        this.customer_id = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
