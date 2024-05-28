package JsonDataBase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IJsonDB {
    public void addStudent(Student student) throws SQLException, IOException;
    public void searchName(Student student);
    public void searchEmail(Student student);
    void getAll(Student student) throws SQLException;
}
