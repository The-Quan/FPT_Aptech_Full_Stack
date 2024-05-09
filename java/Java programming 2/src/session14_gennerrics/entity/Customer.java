package session14_gennerrics.entity;
// dữ liệu trong enitty <t> => t là dữ liệu của trường khóa chính
// primary
public class Customer extends Entity<Integer>{
    private String name;
    private String address;
    private String phone;
    private String email;


    public Customer(Integer id) {
        super(id);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
