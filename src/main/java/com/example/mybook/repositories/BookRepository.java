package com.example.mybook.repositories;

import com.example.mybook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//camada de dados
@Repository
public interface BookRepository extends JpaRepository <Book, Integer> {

    //cria a query em formato jpql
    //metodo que lista todos os livros pela categoria que eu passei como argumento
    @Query("SELECT objBook FROM Book objBook WHERE objBook.category.id = :id_categoty ORDER BY title")
    List<Book> findAllByCategory(@Param(value = "id_categoty") Integer id_categoty);
}
