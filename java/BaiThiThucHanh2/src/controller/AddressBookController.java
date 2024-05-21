package controller;

import entity.AddressBooks;
import model.AddressBookMD;

import java.sql.SQLException;
import java.util.List;

public class AddressBookController {
    AddressBookMD addressBookMD = new AddressBookMD();
    public void add(AddressBooks addressBooks) throws SQLException {
        addressBookMD.addContact(addressBooks);
    }
    public List<AddressBooks> search(AddressBooks addressBooks) throws SQLException {
        List<AddressBooks> addressBooks1 = addressBookMD.searchContact(addressBooks);
        return addressBooks1;
    }
    public List<AddressBooks> getAll(AddressBooks addressBooks) throws SQLException {
        List<AddressBooks> getAlls = addressBookMD.getAllContact(addressBooks);
        return getAlls;
    }
}
