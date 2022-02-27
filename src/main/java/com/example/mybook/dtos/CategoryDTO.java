package com.example.mybook.dtos;

import com.example.mybook.domain.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTO implements Serializable {
    //padrao DTO - serve para omitir algumas informaçoes em algumas requisiçoes
    //Objeto de Transferência de Dados
    //omite os livros, quando se quer apenas as categorias
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo NAMES não pode ser vazio!")
    @Length(min = 3, max = 100, message = "O campo NAMES deve ter entre 3 e 100 caracteres")
    private String names;

    @NotEmpty(message = "Campo DESCRIPTION não pode ser vazio!")
    @Length(min = 3, max = 200, message = "O campo DESCRIPTION deve ter entre 3 e 200 caracteres")
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
