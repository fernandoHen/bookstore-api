package com.example.mybook.domain;

import java.util.Objects;

public class Book {

    private Integer id;
    private String title;
    private String authorName;
    private String textOfBook;

    private Category category;

    public Book() {
        super();
    }

    public Book(Integer id, String title, String authorName, String textOfBook, Category category) {
        super();
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.textOfBook = textOfBook;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTextOfBook() {
        return textOfBook;
    }

    public void setTextOfBook(String textOfBook) {
        this.textOfBook = textOfBook;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
