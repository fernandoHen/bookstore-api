package com.example.mybook.services;

import com.example.mybook.domain.Book;
import com.example.mybook.repositories.BookRepository;
import com.example.mybook.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
//CAMADA DE SERVIÇOS - REGRAS DE NEGOCIOS - CRUD
//notaçao service, para poder injetar instanciaas

@Service
public class BookServices {

    //informa para o spring que é ele que vai gerenciar
    //essa instancia que estamos injetando (criar, gerenciar e destruir)
    @Autowired
    private BookRepository bookRepository;

    public Book findById(Integer id) {
        Optional<Book> objBooks = bookRepository.findById(id);
        return objBooks.orElseThrow(() -> new ObjectNotFoundException(
                "Livro não encontrado. ID: " + id + " , Tipo: " + Book.class.getName()));
    }


}
