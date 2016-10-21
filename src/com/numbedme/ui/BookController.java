package com.numbedme.ui;

import com.numbedme.ejb.LocalAuthorEJB;
import com.numbedme.ejb.LocalBookEJB;
import com.numbedme.interceptor.SimpleLogger;
import com.numbedme.model.Author;
import com.numbedme.model.Book;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.10.2016.
 */

@Named
@RequestScoped
@Interceptors(SimpleLogger.class)
public class BookController {

    @EJB
    private LocalBookEJB service;

    @EJB
    private LocalAuthorEJB authorService;
    private Book book;
    private List<Book> bookList = new ArrayList<>();

    public BookController() {
        book = new Book();
        book.setAuthor(new Author());
    }

    public void createBook(){
        service.addBook(book);
    }

    public void findAllBooks(){
        bookList = service.getAllBooks();
    }

    public void findBook(){
        book = service.getBook(book.getId());
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        findAllBooks();
        return bookList;
    }

    public void update(){
        service.merge(book);
    }

    public void remove(Book book){

        service.removeBook(book);
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}