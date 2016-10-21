package com.numbedme.ejb;

import com.numbedme.model.Book;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by User on 18.10.2016.
 */

@Stateless
@Local(LocalBookEJB.class)
public class BookService implements LocalBookEJB {
    @PersistenceContext(unitName = "unit")
    private EntityManager manager;

    public BookService() {
    }

    @Override
    public List<Book> getAllBooks() {
        return manager.createQuery("SELECT b FROM Book b order by b.name", Book.class).getResultList();
    }

    @Override
    public Book getBook(int id) {
        return manager.find(Book.class, id);
    }

    @Override
    public void addBook(Book book) {
        manager.persist(book);
    }

    @Override
    public void removeBook(Book book) {
        Book detached = manager.getReference(Book.class, book.getId());
        manager.remove(detached);
    }

    @Override
    public Book merge(Book book){
        return manager.merge(book);
    }

    @Override
    public Book getReference(Object id) {
        return manager.getReference(Book.class, id);
    }
}
