package com.example.mybook.resources;

import com.example.mybook.domain.Book;
import com.example.mybook.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
