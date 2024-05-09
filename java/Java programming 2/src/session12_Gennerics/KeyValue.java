package session12_Gennerics;

import java.util.HashMap;
import java.util.Map;

public class KeyValue <K,V>{
    private Map<K,V> map;

    public KeyValue(Map<K, V> map) {
        this.map = map;
    }
    public KeyValue(){
        this.map = new HashMap<>();
    }

    public void put( K key, V value){
        map.put(key,value);
    }
    public V get( K Key){
        return map.get(Key);
    }
    public Iterable<V> value(){
        return map.values();
    }
}
class product{
    private int id;
    private String name;
    private double price;

    public product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + name +   " price: " + price ;
    }
}
class Customer{
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "id: " + id + " name: " + name + " email: " + email ;
    }

    public static void main(String[] args) {
        KeyValue<Integer, product> productmap = new KeyValue<>();
        productmap.put(1,new product(1,"Apple",55.5));
        productmap.put(2,new product(2,"Apple1",55.6));
        productmap.put(3,new product(3,"Apple2",55.7));
        System.out.println("--------- Product List ---------");
        for (product product: productmap.value()){
            System.out.println(product.toString());
        }
        System.out.println("------------ Customer List ---------");
        KeyValue<Integer, Customer> customermap = new KeyValue<>();
        customermap.put(1,new Customer(1,"Quan", "quan@gamil.com"));
        customermap.put(2,new Customer(2,"Thanh", "thanh@gamil.com"));
        customermap.put(3,new Customer(3,"Tung", "tung@gamil.com"));
        for (Customer customer: customermap.value()){
            System.out.println(customer.toString());
        }
    }

}
