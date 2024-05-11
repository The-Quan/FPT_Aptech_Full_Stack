package StoreBook_2025.model;

import java.sql.SQLException;
import java.util.List;

public interface StoreBookDao<T> {
    // Customer
    public boolean add(T n) throws SQLException;
    public boolean update(T n) throws SQLException;
    public void delete(T n) throws SQLException;
    public List<T> getAll() throws SQLException;
}
