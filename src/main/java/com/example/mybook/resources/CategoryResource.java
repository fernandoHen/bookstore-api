package com.example.mybook.resources;

import com.example.mybook.domain.Category;
import com.example.mybook.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//camada que recebe os valores do front-end

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category objCategory = categoryServices.findById(id);
        return ResponseEntity.ok().body(objCategory);
    }

}
//serializacao - nesse caso, quando chama uma categoria, o livro tbm tem uma categoria como padrao
//isso pode causar um loop
//locahost:8080/category/1