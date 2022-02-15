package com.example.mybook.domain;

import jdk.dynalink.linker.LinkerServices;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category {

    private Integer id;
    private  String names;
    private String description;

    private List<Book> books = new ArrayList<>();

    public Category() {
        super();
    }

    public Category(Integer id, String names, String description, List<Book> books) {
        super();
        this.id = id;
        this.names = names;
        this.description = description;
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
