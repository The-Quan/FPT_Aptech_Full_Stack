package JsonDataBase;

import java.io.IOException;
import java.sql.SQLException;

public class Controler {
    MDJsonDB mdJsonDB = new MDJsonDB();
    public void add(Student student) throws SQLException, IOException {
        mdJsonDB.addStudent(student);
    }
}
