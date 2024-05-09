package onTapCode.Thread;

import java.util.ArrayList;

public class Buffer {
    // khả năng chứa tối đa
    private int capacity;
    // danh sách sản phẩm
    private ArrayList<Integer> products;
    public Buffer(int capacity) {
        products = new ArrayList<>();
        this.capacity = capacity;
    }
    public void addProduct(int product, int producerId){
        System.out.println("--------- vao ------------");
        System.out.println("nhà sản suất " + producerId + " đã thêm sản phẩm " + product);
        products.add(product);
        System.out.println("số lượng tồn kho: " + products.size());
    }

    public void removeProduct(int customerId){
        System.out.println("---------- ra -----------");
        System.out.println("khach hang " + customerId + "da mua san pham " + products.get(1));
        products.remove(1);
        System.out.println("số lượng tồn kho: " + products.size());
    }
    public int getSize(){
        return this.products.size();
    }

    public int getCapacity() {
        return capacity;
    }


}
