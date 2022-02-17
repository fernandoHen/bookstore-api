package com.example.mybook;

import com.example.mybook.domain.Book;
import com.example.mybook.domain.Category;
import com.example.mybook.repositories.BookRepository;
import com.example.mybook.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class MybookApplication implements CommandLineRunner {
//    CommandLineRunner --> ao iniciar a aplicação executa o codigo dentro desse metodo

    //instancio as categorias e livros do repositorio
    //camada de acesso a dados - repositorios
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(MybookApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category_one = new Category(null, "Aventura", "Contos do stag");
        Book book_one = new Book(null, "O estagiário", "Fernando", "Teste teste...", category_one);
        //a categoria reconhece o livro, mas o livro ainda nao conhece a categoria

        //adiciono a o livro junto a categoria, adiciono o addAll para caso tenha mais de um livro com mesma categoria
        //dai pode adicionar todos de uma vez
        category_one.getBooks().addAll(Arrays.asList(book_one));

        //salva no db - posso salvar masi de uma instancia, por isso do asList
        this.categoryRepository.saveAll(Arrays.asList(category_one));
        this.bookRepository.saveAll(Arrays.asList(book_one));
    }


    //teste removi linhas
}
