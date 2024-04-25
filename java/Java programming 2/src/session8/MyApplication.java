package session8;

import session8.view.LoginConsoleUI;

import java.io.IOException;

public class MyApplication {
    public static void main(String[] args) throws IOException {
        LoginConsoleUI loginConsoleUI = new LoginConsoleUI();
        loginConsoleUI.start();
    }
}
