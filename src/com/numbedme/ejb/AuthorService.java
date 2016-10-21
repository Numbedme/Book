package com.numbedme.ejb;

import com.numbedme.model.Author;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by User on 20.10.2016.
 */
@Named
@Stateless
@Local(LocalAuthorEJB.class)
public class AuthorService implements LocalAuthorEJB {

    @PersistenceContext(unitName = "unit")
    private EntityManager manager;

    @Override
    public List<Author> getAllAuthors() {
        return manager.createQuery( "SELECT a FROM Author a", Author.class).getResultList();
    }

    @Override
    public List<String> getAllAuthorsNames() {
        return manager.createQuery( "SELECT a.name FROM Author a", String.class).getResultList();
    }

    @Override
    public Author getAuthor(int id) {
        return manager.find(Author.class, id);
    }

    @Override
    public Author getAuthor(String name) {
        return manager.createQuery("SELECT a FROM Author a WHERE a.name = :name", Author.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public void addAuthor(Author author) {
        manager.persist(author);
    }

    @Override
    public void removeAuthor(Author author) {
        Author detached = manager.getReference(Author.class, author.getId());
        manager.remove(detached);
    }

    @Override
    public Author merge(Author author) {
        return manager.merge(author);
    }

    @Override
    public Author getReference(Object id) {
        return manager.getReference(Author.class, id);
    }
}
