package session10.entity;

public class Product {
    private int product_id ;
    private String productName;
    private String productDesc;
    private Double price;

    public Product(int product_id, String productName, String productDesc, Double price) {
        this.product_id = product_id;
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
    }

    public Product() {

    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "\n"+
                "product_id = " + product_id +
                ", productName = '" + productName + '\'' +
                ", productDesc = '" + productDesc + '\'' +
                ", price = " + price ;
    }
}
