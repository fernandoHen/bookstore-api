package com.example.mybook.services;

import com.example.mybook.domain.Book;
import com.example.mybook.repositories.BookRepository;
import com.example.mybook.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
//CAMADA DE SERVIÇOS - REGRAS DE NEGOCIOS - CRUD
//notaçao service, para poder injetar instanciaas

@Service
public class BookServices {

    //informa para o spring que é ele que vai gerenciar
    //essa instancia que estamos injetando (criar, gerenciar e destruir)
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryServices categoryServices;

    public Book findById(Integer id) {
        Optional<Book> objBooks = bookRepository.findById(id);
        return objBooks.orElseThrow(() -> new ObjectNotFoundException(
                "Livro não encontrado. ID: " + id + " , Tipo: " + Book.class.getName()));
    }

    public List<Book> findAll(Integer id_categoty) {
        categoryServices.findById(id_categoty); // se ja tiver esse id, entao volta uma exception
        return bookRepository.findAllByCategory(id_categoty);
    }

    public Book update(Integer id, Book objBookUpdate) {
        //as informaçoes de objBookUpdate tem que ser passada para o newObjBook
        Book newObjBook = findById(id); // traz o livro com as infdormaçoes desatualizadas
        updateData(newObjBook, objBookUpdate);// metodo paara atualizar os dados do objeto
        return bookRepository.save(newObjBook);
    }

    private void updateData(Book newObjBook, Book objBookUpdate) {
        //metodo criado para ter funcionalidades, transfere ibformacoes
        newObjBook.setTitle(objBookUpdate.getTitle());
        //o newObjBook tem informaçoes desatualizadas
        //seto a informaçao objBookUpdate.X, assim atualizo o newObjBook
        newObjBook.setAuthorName(objBookUpdate.getAuthorName());
        newObjBook.setTextOfBook(objBookUpdate.getTextOfBook());
    }
}
