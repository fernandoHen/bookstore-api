package com.example.mybook.services;

import com.example.mybook.domain.Category;
import com.example.mybook.repositories.CategoryRepository;
import com.example.mybook.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//camada das logicas de negocio

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository categoryRepository;

    //() -> funcao anonima
    public Category findById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado. ID: " + id + ", Tipo: " + Category.class.getName()));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category create(Category objCategory) {
        objCategory.setId(null); // se ja existir o id na bd, entao o jpa vcai entender que é uma atualização apenas
        //questao de segurança
        return categoryRepository.save(objCategory);
    }

    public Category update(Integer id, Category objCategoryDTO) {
        //verificar se a categoria passada como parametro, realmente existe
        Category obj = findById(id);
        //se ja existe o id, apenas entao atualiza as informaçoes no banco de dados
        obj.setNames(objCategoryDTO.getNames());
        obj.setDescription(objCategoryDTO.getDescription());
        return categoryRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        categoryRepository.deleteById(id);
    }
}
