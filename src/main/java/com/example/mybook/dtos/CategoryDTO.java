package com.example.mybook.dtos;

import com.example.mybook.domain.Category;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
    //padrao DTO - serve para omitir algumas informaçoes em algumas requisiçoes
    //Objeto de Transferência de Dados
    //omite os livros, quando se quer apenas as categorias
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String descriptios;

    public CategoryDTO() {
        super();
    }

    public CategoryDTO(Category objCategory) {
        super();
        this.id = objCategory.getId();
        this.name = objCategory.getNames();
        this.descriptios = objCategory.getDescription();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptios() {
        return descriptios;
    }

    public void setDescriptios(String descriptios) {
        this.descriptios = descriptios;
    }

}
