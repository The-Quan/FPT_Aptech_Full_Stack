package session4;

import java.sql.Struct;
import java.util.Calendar;
import java.util.Scanner;

public class Library {
    private String bookId;
    private String bookName;
    private int yearPublish;
    private int total;
    private int numberOfPage;

    private String price;

    public Library(String bookId, String bookName, int yearPublish, int total) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.yearPublish = yearPublish;
        this.total = total;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(int yearPublish) {
        this.yearPublish = yearPublish;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString(){
        return bookId + "-" + bookName + "-" + yearPublish + " " + total;
    }
    public void inputBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Book id: ");
        bookId = sc.nextLine();
        System.out.println("Book name: ");
        bookName = sc.nextLine();
        System.out.println("Year publish");
        yearPublish = Integer.valueOf(sc.nextLine());
        System.out.println("Number of page: ");
        numberOfPage = Integer.valueOf(sc.nextLine());
    }
}
