package com.example.mybook.services;

import com.example.mybook.domain.Category;
import com.example.mybook.repositories.CategoryRepository;
import com.example.mybook.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
}
