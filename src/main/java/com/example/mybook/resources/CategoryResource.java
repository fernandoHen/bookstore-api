package com.example.mybook.resources;

import com.example.mybook.domain.Category;
import com.example.mybook.dtos.CategoryDTO;
import com.example.mybook.services.CategoryServices;
import com.mysql.cj.x.protobuf.MysqlxSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.stream.Collectors;

//camada que recebe os valores do front-end
//https://www.baeldung.com/spring-response-entity
//ResponseEntity representa toda a resposta HTTP: código de status,
// cabeçalhos e corpo . Como resultado, podemos usá-lo para configurar totalmente a resposta HTTP.
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

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category objCategory) {
        objCategory = categoryServices.create(objCategory);
        //boas praticas retorna para o usuario uma nova uri, se cria uma uri de acesso para nova class, para o objeto
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objCategory.getId()).toUri();
        // ou desse forma ResponseEntity.created(uri).build(null)
        return ResponseEntity.created(uri).body(objCategory);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Integer id, @RequestBody Category objCategoryDTO) {
        //objCategoryDTO: são as informaçoes dos objetos atualizadas
        Category newObj = categoryServices.update(id, objCategoryDTO);
        //retorno agora uma nova instancia de categoria dto
        return ResponseEntity.ok().body(new CategoryDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoryServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}
//serializacao - nesse caso, quando chama uma categoria, o livro tbm tem uma categoria como padrao
//isso pode causar um loop
//locahost:8080/category/1