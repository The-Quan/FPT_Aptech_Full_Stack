package UI;

import view.ViewAddressBooks;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        ViewAddressBooks viewAddressBooks = new ViewAddressBooks();
        viewAddressBooks.start();
    }
}
