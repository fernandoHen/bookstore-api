package com.example.mybook.dtos;

import com.example.mybook.domain.Category;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
    //padrao DTO - serve para omitir algumas informaçoes em algumas requisiçoes
    //Objeto de Transferência de Dados
    //omite os livros, quando se quer apenas as categorias
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String names;
    private String description;

    public CategoryDTO() {
        super();
    }

    public CategoryDTO(Category objCategory) {
        super();
        this.id = objCategory.getId();
        this.names = objCategory.getNames();
        this.description = objCategory.getDescription();
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

}
