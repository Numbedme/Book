package com.numbedme.ejb;

import com.numbedme.model.Book;

import java.util.List;

/**
 * Created by User on 18.10.2016.
 */

public interface CommonEJB {

    List<Book> getAllBooks();

    Book getBook(int id);

    void addBook(Book book);

    void removeBook(Book book);

    Book merge(Book book);

    Book getReference(Object id);
}
