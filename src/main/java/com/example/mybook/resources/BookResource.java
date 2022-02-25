package com.example.mybook.resources;

import com.example.mybook.domain.Book;
import com.example.mybook.dtos.BookDTO;
import com.example.mybook.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

    //SPRING QUE GERENCIA ESSA INSTANCIA
    @Autowired
    private BookServices bookServices;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        Book objBook = bookServices.findById(id);
        return ResponseEntity.ok().body(objBook);
    }

    //https://www.baeldung.com/spring-request-param
    //Simplificando, podemos usar @RequestParam para extrair parâmetros de consulta,
    // parâmetros de formulário e até mesmo arquivos da solicitação.
    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Integer id_categoty) {
        //estrutura - localhost:8080/books?category=1 - lista todos os livros de uma categoria
        //primeiro chamo a lista de livros depois converto para uma lista de livros DTO

        List<Book> list = bookServices.findAll(id_categoty);

        //converti uma lista de livros, para uma lista de livros dto
        List<BookDTO> listBookDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listBookDTO);
    }

}
