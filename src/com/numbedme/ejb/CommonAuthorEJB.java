package com.numbedme.ejb;

import com.numbedme.model.Author;

import java.util.List;

/**
 * Created by User on 20.10.2016.
 */
public interface CommonAuthorEJB {

    List<Author> getAllAuthors();

    List<String> getAllAuthorsNames();

    Author getAuthor(int id);

    Author getAuthor(String name);

    void addAuthor(Author author);

    void removeAuthor(Author author);

    Author merge(Author author);

    Author getReference(Object id);
}
