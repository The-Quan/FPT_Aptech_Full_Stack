package model;

import DB.DataBase;
import entity.AddressBooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookMD implements AdressBookImpl{
    private final Connection connection;

    {
        try {
            connection = DataBase.DBAddressBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addContact(AddressBooks addressBooks) throws SQLException {
        String Sql_addContact = "INSERT INTO addressBooks VALUES (?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(Sql_addContact);
        pstm.setString(1,addressBooks.getName());
        pstm.setString(2,addressBooks.getCompany());
        pstm.setString(3,addressBooks.getEmail());
        pstm.setString(4,addressBooks.getPhone());
        pstm.executeUpdate();
    }

    @Override
    public List<AddressBooks> searchContact(AddressBooks addressBooks) throws SQLException {
        List<AddressBooks> addressBooksList = new ArrayList<>();
      String Sql_search ="select * from addressBooks where name  LIKE CONCAT('%', ?, '%')";
      PreparedStatement pstm = connection.prepareStatement(Sql_search);
      pstm.setString(1, addressBooks.getName());
      ResultSet rs = pstm.executeQuery();
      while (rs.next()){
          AddressBooks addressBooks1 = new AddressBooks();
          addressBooks1.setName(rs.getString("name"));
          addressBooks1.setCompany(rs.getString("company"));
          addressBooks1.setEmail(rs.getString("email"));
          addressBooks1.setPhone(rs.getString("phone"));
          addressBooksList.add(addressBooks1);
      }
      return addressBooksList;
    }

    @Override
    public List<AddressBooks> getAllContact(AddressBooks addressBooks1) throws SQLException {
        String Sql_getAll = "select * from addressBooks";
        PreparedStatement pstm = connection.prepareStatement(Sql_getAll);
        List<AddressBooks> addressBooks2 = new ArrayList<>();
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            AddressBooks addressBooks = new AddressBooks();
            addressBooks.setName(rs.getString(1));
            addressBooks.setCompany(rs.getString(2));
            addressBooks.setEmail(rs.getString(3));
            addressBooks.setPhone(rs.getString(4));
            addressBooks2.add(addressBooks);
        }
        return addressBooks2;
    }
}
