package StoreBook_2025.controller;

import StoreBook_2025.entity.ShowOrderDetail;
import StoreBook_2025.model.StoreBookMD;

import java.sql.SQLException;
import java.util.List;

public class StoreBookController<T> {
    StoreBookMD storeBookMD = new StoreBookMD();

    public boolean add(T entity) {
        return storeBookMD.add(entity);
    }

    public void update(T entity) {
        storeBookMD.update(entity);
    }

    public void delete(T entity) {
        storeBookMD.delete(entity);
    }

    public List<T> search(T entity) throws SQLException {
        List<T> search = storeBookMD.search(entity);
        return search;
    }

    public List<T> getAll(T entity) throws SQLException {
        List<T> getAlls = storeBookMD.getAll(entity);
        return getAlls;
    }

    public void order(T entity) throws SQLException {
        storeBookMD.order(entity);
    }

    public List<T> showOrder(T entity) {
        List<T> getAllOrder = storeBookMD.showOrder(entity);
        return getAllOrder;
    }

    public void addOrderDetail(T entyti) throws IllegalAccessException {
        storeBookMD.addOrderDetail(entyti);
    }

    public List<ShowOrderDetail> showOrderDetails(ShowOrderDetail showOrderDetail) {
        List<ShowOrderDetail> showOrderDetail1 = storeBookMD.showOrderDetail(showOrderDetail);
        return showOrderDetail1;
    }
}
