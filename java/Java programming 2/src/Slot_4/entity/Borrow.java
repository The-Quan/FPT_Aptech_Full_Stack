package Slot_4.entity;

import java.util.Date;

public class Borrow {
    private int student_id;
    private int book_id;
    private int status;
    private Date borrow_book;
    private String return_book;

    public Borrow(int student_id, int book_id,int status, Date borrow_book, String return_book) {
        this.student_id = student_id;
        this.book_id = book_id;
        this.status = status;
        this.borrow_book = borrow_book;
        this.return_book = return_book;
    }
    public  Borrow(){

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public Date getBorrow_book() {
        return borrow_book;
    }

    public void setBorrow_book(Date borrow_book) {
        this.borrow_book = borrow_book;
    }

    public String getReturn_book() {
        return return_book;
    }

    public void setReturn_book(String return_book) {
        this.return_book = return_book;
    }
}
