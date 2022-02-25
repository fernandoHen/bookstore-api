package com.example.mybook.dtos;

import com.example.mybook.domain.Book;

import java.io.Serializable;

public class BookDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;

    public BookDTO() {
        super();
    }

    public BookDTO(Book objBook) {
        super();
        this.id = objBook.getId();
        this.titulo = objBook.getTitle();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
