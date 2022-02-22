package com.example.mybook.repositories;

import com.example.mybook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//camada de dados
@Repository
public interface BookRepository extends JpaRepository <Book, Integer> {



}
