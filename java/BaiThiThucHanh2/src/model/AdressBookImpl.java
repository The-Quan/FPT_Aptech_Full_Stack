package model;

import entity.AddressBooks;

import java.sql.SQLException;
import java.util.List;

public interface AdressBookImpl {
    public void addContact(AddressBooks addressBooks) throws SQLException;
    public List<AddressBooks> searchContact(AddressBooks addressBooks) throws SQLException;
    public List<AddressBooks> getAllContact(AddressBooks addressBooks) throws SQLException;
}
