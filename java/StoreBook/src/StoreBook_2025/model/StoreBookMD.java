package StoreBook_2025.model;

import StoreBook_2025.controller.StoreBookController;
import StoreBook_2025.dataBase.DBStoreBook;
import StoreBook_2025.entity.Customers;
import StoreBook_2025.entity.Orders;
import StoreBook_2025.entity.Products;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class StoreBookMD<T> implements StoreBookDao<T> {
    private final Connection connection;

    {
        try {
            connection = DBStoreBook.DBStoreBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getTableName(Class<?> entityClass) {
        String tableName = entityClass.getSimpleName();
        return tableName;
    }

    @Override
    public boolean add(T entity) {
        String tableName = getTableName(entity.getClass()); // lấy tên bảng ứng với lớp entity

        StringBuilder queryBuilder = new StringBuilder("INSERT INTO "); // khơi tạo StringBuilder với một chuỗi ban đầu "insert into"

        queryBuilder.append(tableName).append(" ("); // thêm tên bảng queryBuilder sau đó thêm dấu ' ( '

        Field[] fields = entity.getClass().getDeclaredFields(); // getDeclaredFields lấy danh sách các trường trong fields của đối tượng entity
        for (int i = 0; i < fields.length; i++) { // bắt đầu vong lặp qua mang fileds, mảng này chứa các đối tượng fileds biểu diễn các trường đối tượng
            if (i > 0) {
                queryBuilder.append(", "); // kiểm tra xem có phải kí tự đầu tiên ko, nếu ko phải trường đầu tiên thì thêm dấu ' , '
            }
            queryBuilder.append(fields[i].getName()); // thêm tên trường vào queryBuilder và lấy tên trường
        }

        queryBuilder.append(") VALUES ("); // thêm vào queryBuilder " ) values ("

        for (int i = 0; i < fields.length; i++) { // lặp qua mang fieilds
            if (i > 0) {
                queryBuilder.append(", "); // ko phải trường đầu tiên thì thêm dấu phẩy
            }
            queryBuilder.append("?"); // thêm dấu ?
        }

        queryBuilder.append(")"); // thêm dấu )

        //  queryBuilder = INSERT INTO (tên trường, tên trường 2,...) VALUSE (?,?,?,...);

        try (connection) {
            PreparedStatement pstm = connection.prepareStatement(queryBuilder.toString()); // queryBuilder.toString() chuyển đổi queryBuilder như thường
            // và tạo một đối tượng ' PreparedStatement ' từ chuỗi sql truyền vào ( queryBuilder )
            int parameterIndex = 1;
            for (Field field : fields) { // lặp qua mảng field là danh sách các trường của entity
                field.setAccessible(true); // gọi phương thức setAccessible(true) để có thể truy cập vào các trường private hoặc protected của entity
                Object value = field.get(entity); // sử dụng get để lấy giá trị các trường trong entity và trả về một object chứa giá trị của trường tương ứng
                pstm.setObject(parameterIndex++, value); //Sử dụng pstm (PreparedStatement) để đặt giá trị của tham số trong câu lệnh SQL
                // Biến parameterIndex được sử dụng để xác định vị trí của tham số trong câu lệnh SQL.
                //  Mỗi lần lặp, giá trị của parameterIndex được tăng lên và giá trị của trường
                //  được đặt vào tham số tương ứng trong câu lệnh SQL.
            }

            int rowsAdd = pstm.executeUpdate(); // thực hiện truy vẫn và kết quả được gán cho rowsInserted
            return rowsAdd > 0; // thành công
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void update(T entity) {
        String tableName = getTableName(entity.getClass());

        StringBuilder queryBuilder = new StringBuilder(" UPDATE ");
        queryBuilder.append(tableName).append(" SET ");

        Field[] fields = entity.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            if (i > 0) {
                queryBuilder.append(", ");
            }
            queryBuilder.append(fields[i].getName()).append(" = ?");
        }
        queryBuilder.append(" WHERE ");
        for (int i = 0; i < fields.length; i++) {
            if (i > 0) {
                queryBuilder.append(" OR ");
            }
            queryBuilder.append(fields[i].getName()).append(" = ?");
        }
        try (connection) {
            PreparedStatement pstm = connection.prepareStatement(queryBuilder.toString());
            int parameterIndex = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                Object values = field.get(entity);
                pstm.setObject(parameterIndex++, values);
            }
            // Thêm tham số cho phần WHERE (giá trị của các trường)
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(entity);
                pstm.setObject(parameterIndex++, value);
            }
            pstm.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {
        String tableName = getTableName(entity.getClass());
        StringBuilder queryBuilder = new StringBuilder("DELETE ");
        queryBuilder.append("FROM ").append(tableName);
        queryBuilder.append(" Where ");
        Field[] fields = entity.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            if (i > 0) {
                queryBuilder.append(" or ");
            }
            queryBuilder.append(fields[i].getName()).append(" = ? ");
        }
        try (connection) {
            PreparedStatement pstm = connection.prepareStatement(queryBuilder.toString());
            int parameterIndex = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(entity);
                pstm.setObject(parameterIndex++, value);
            }
            pstm.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> search(T entity) throws SQLException {
        String tableName = getTableName(entity.getClass());
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ");
        queryBuilder.append(tableName).append(" WHERE ");

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (i > 0) {
                queryBuilder.append(" OR ");
            }
            queryBuilder.append(fields[i].getName()).append(" = ?");
        }

        try (PreparedStatement pstm = connection.prepareStatement(queryBuilder.toString())) {
            int parameterIndex = 1; // Start index for parameter binding
            for (Field field : fields) {
                field.setAccessible(true);
                pstm.setObject(parameterIndex++, field.get(entity));
            }

            try (ResultSet rs = pstm.executeQuery()) {
                List<T> search = new ArrayList<>();
                while (rs.next()) {
                    T search2 = (T) entity.getClass().newInstance();
                    Field[] fields1 = entity.getClass().getDeclaredFields();
                    for (Field field : fields1) {
                        field.setAccessible(true);
                        field.set(search2, rs.getObject(field.getName()));
                    }
                    search.add(search2);
                }
                return search;
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<T> getAll(T entity) throws SQLException {

        String tableName = getTableName(entity.getClass());
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ");
        queryBuilder.append(tableName);

        try (PreparedStatement pstm = connection.prepareStatement(queryBuilder.toString())) {
            try (ResultSet rs = pstm.executeQuery()) {
                List<T> getAll = new ArrayList<>();
                while (rs.next()) {
                    T text = (T) entity.getClass().newInstance(); // .newInstance()  là một phương thức của lớp Class,
                    // được sử dụng để tạo một đối tượng mới từ lớp mà Class
                    // Phương thức này tạo một phiên bản mới của đối tượng, tương tự như việc sử dụng toán tử new để tạo một đối tượng mới.
                    Field[] fields = entity.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        field.set(text, rs.getObject(field.getName()));
                    }
                    getAll.add(text);
                }
                return getAll;
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void order(T entity) throws SQLException {
        String tableName = getTableName(entity.getClass());
        StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
        queryBuilder.append(tableName).append(" (");

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (i > 0) {
                queryBuilder.append(", ");
            }
            queryBuilder.append(fields[i].getName());
        }

        queryBuilder.append(") VALUES (");
        for (int i = 0; i < fields.length; i++) {
            if (i > 0) {
                queryBuilder.append(", ");
            }
            queryBuilder.append("?");
        }
        queryBuilder.append(")");
        try (connection) {
            PreparedStatement pstm = connection.prepareStatement(queryBuilder.toString());
            int paramIndex = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                Object values = field.get(entity);
                pstm.setObject(paramIndex++, values);
            }
            pstm.executeUpdate();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        Customers customers = new Customers();
        customers.setCustomerId(5);
        StoreBookController<Customers> customersStoreBookController = new StoreBookController<>();
        List<Customers> allCustomers = customersStoreBookController.search(customers);
        for (Customers customer : allCustomers) {
            System.out.println(customer.getCustomerId());
            System.out.println(customer.getName());
            System.out.println(customer.getEmail());
        }
    }

}
