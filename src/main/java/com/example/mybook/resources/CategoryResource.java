package com.example.mybook.resources;

import com.example.mybook.domain.Category;
import com.example.mybook.dtos.CategoryDTO;
import com.example.mybook.services.CategoryServices;
import com.mysql.cj.x.protobuf.MysqlxSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.stream.Collectors;

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

    //quando nao tiver nada dps de categoria, entao entra nesse metodo, e busca apenas a categoria
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> list = categoryServices.findAll();
        //transforma uma lista de categoria em uma lista de categoria dto
        List<CategoryDTO> listDTO = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


}
//serializacao - nesse caso, quando chama uma categoria, o livro tbm tem uma categoria como padrao
//isso pode causar um loop
//locahost:8080/category/1