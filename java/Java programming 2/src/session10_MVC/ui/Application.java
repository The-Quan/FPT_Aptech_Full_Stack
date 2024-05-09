package session10_MVC.ui;

import session10_MVC.view.Main;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
       Main main = new Main();
       main.start();
    }
}