package com.numbedme.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by User on 20.10.2016.
 */

@Entity
public class Author {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String name;

    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
