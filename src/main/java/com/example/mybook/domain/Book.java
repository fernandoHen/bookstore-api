package com.example.mybook.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo TITLE não pode ser vazio!")
    @Length(min = 3, max = 50, message = "O campo TITLE deve ter entre 3 e 50 caracteres")
    private String title;

    @NotEmpty(message = "Campo AUTHOTNAME não pode ser vazio!")
    @Length(min = 3, max = 50, message = "O campo AUTHOTNAME deve ter entre 3 e 50 caracteres")
    private String authorName;

    @NotEmpty(message = "Campo TEXTOFBOOK não pode ser vazio!")
    @Length(min = 10, max = 200000, message = "O campo TEXTOFBOOK deve ter entre 3 e 2.000.000 caracteres")
    private String textOfBook;

    //JsonIgnore - ignora a categiria quando chamar, trago apenas o livro
    //evita serialização
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
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
