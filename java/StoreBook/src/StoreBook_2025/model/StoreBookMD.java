package StoreBook_2025.model;

import StoreBook_2025.dataBase.DBStoreBook;
import StoreBook_2025.entity.*;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;


public class StoreBookMD<T> implements StoreBookDao<T> {
    private final Connection connection;

    {
        try {
            connection = DBStoreBook.DBStoreBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getTableName(Class<?> entityClass) { // entityClass, thuộc kiểu Class<?>.
        //  phương thức này nhận vào một lớp thực thể, mà lớp này có thể là bất kỳ loại nào (<?> là ký hiệu wildcard trong Java để chỉ bất kỳ loại nào).
        String tableName = entityClass.getSimpleName(); // Phương thức getSimpleName() được sử dụng để lấy tên đơn giản của lớp thực thể mà không bao gồm phần tên gói.
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

    @Override
    public List<T> showOrder(T entity) {
        String tablName = getTableName(entity.getClass());
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ");
        queryBuilder.append(tablName);
        try(PreparedStatement pstm = connection.prepareStatement(queryBuilder.toString())){
            try(ResultSet rs = pstm.executeQuery()){
                List<T> getAllOrder = new ArrayList<>();
                while (rs.next()){
                    T getAll = (T) entity.getClass().newInstance();
                    Field[] field =  entity.getClass().getDeclaredFields();
                    for (Field field1 : field){
                        field1.setAccessible(true);
                        field1.set(getAll, rs.getObject(field1.getName()));
                    }
                    getAllOrder.add(getAll);
                }
                return getAllOrder;
            }
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addOrderDetail(T entity) throws IllegalAccessException {
        String tablename = getTableName(entity.getClass());
        StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
        queryBuilder.append(tablename).append(" (");
        Field[] fields = entity.getClass().getDeclaredFields(); // lay danh sach cac truong
        for (int i = 0; i < fields.length; i++){
            if (i > 0){
                queryBuilder.append(", ");
            }
            queryBuilder.append(fields[i].getName());
        }
        queryBuilder.append(") VALUES (");
        for (int i = 0; i < fields.length; i++){
            if (i > 0){
                queryBuilder.append(", ");
            }
            queryBuilder.append("?");
        }
        queryBuilder.append(")");

        try(connection){
            PreparedStatement pstm = connection.prepareStatement(queryBuilder.toString());
            int paramIndex = 1;
            for (Field field : fields){
                field.setAccessible(true);
                Object object = field.get(entity);
                pstm.setObject(paramIndex++, object);
            }
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<ShowOrderDetail> showOrderDetail(ShowOrderDetail showOrderDetail){
        List<ShowOrderDetail> orderDetails = new ArrayList<>();
     final String SQL_showOrderDetail = "SELECT o.order_id, c.customer_id, c.name AS customer_name, p.product_id, p.name AS product_name, o.address, odd.date, odd.total " +
                "FROM " +
                " orderDetail odd" +
                " INNER JOIN " +
                " orders o ON odd.order_id = o.order_id" +
                " INNER JOIN " +
                " customers c ON odd.customer_id = c.customer_id" +
                " INNER JOIN " +
                " products p ON odd.product_id = p.product_id";
     try(PreparedStatement pstm = connection.prepareStatement(SQL_showOrderDetail)){
         ResultSet  rs = pstm.executeQuery();
         while (rs.next()){
             OrderDetail orderDetail = new OrderDetail();
             orderDetail.setDatetimes(rs.getDate("date"));
             orderDetail.setTotal(rs.getDouble("total"));

             Orders orders = new Orders();
             orders.setOrder_id(rs.getInt("order_id"));
             orders.setAddress(rs.getString("address"));

             Customers customers = new Customers();
             customers.setCustomerId(rs.getInt("customer_id"));
             customers.setName(rs.getString("customer_name"));

             Products products = new Products();
             products.setproduct_id(rs.getInt("product_id"));
             products.setName(rs.getString("product_name"));

             ShowOrderDetail showOrderDetail2 = new ShowOrderDetail(orders,customers,products,orderDetail);
             orderDetails.add(showOrderDetail2);

         }

     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
     return orderDetails;
    }

    public static void main(String[] args) throws SQLException, IllegalAccessException {
        StoreBookMD storeBookMD = new StoreBookMD();
        ShowOrderDetail showOrderDetail = new ShowOrderDetail();
        List<ShowOrderDetail> showOrderDetails = storeBookMD.showOrderDetail(showOrderDetail);
        for (ShowOrderDetail showOrderDetail1: showOrderDetails){
            System.out.println(showOrderDetail1.getOrder().getOrder_id());
            System.out.println(showOrderDetail1.getCustomer().getCustomerId());
            System.out.println(showOrderDetail1.getCustomer().getName());
            System.out.println(showOrderDetail1.getProduct().getproduct_id());
            System.out.println(showOrderDetail1.getProduct().getproduct_id());
            System.out.println(showOrderDetail1.getOrder().getAddress());
            System.out.println(showOrderDetail1.getOrderDetail().getDatetimes());
            System.out.println(showOrderDetail1.getOrderDetail().getTotal());
            System.out.println("--------------------");
        }

    }
}
