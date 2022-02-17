package com.example.mybook.services;

import com.example.mybook.domain.Book;
import com.example.mybook.domain.Category;
import com.example.mybook.repositories.BookRepository;
import com.example.mybook.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBServices {
    //boas praticas para instanciar o banco de dados

    //instancio as categorias e livros do repositorio
    //camada de acesso a dados - repositorios
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    //metodo para instanciar a base de dados
    public void insDataBate () {
        Category category_one= new Category(null, "Aventura", "Aventuras sem fim");
        Book book_one = new Book(null, "O estagiário", "Fernando", "Teste teste...", category_one);
        //a categoria reconhece o livro, mas o livro ainda nao conhece a categoria

        Category category_2 = new Category(null, "Drama", "Dramas em geral");
        Category category_3 = new Category(null, "Contos", "Constos épicos");

        Book b1 = new Book(null, "O estagiário", "Fernando", "Teste teste...", category_one);
        Book b2 = new Book(null, "O junior", "Henrique", "Junior book", category_one);
        Book b3 = new Book(null, "O maquinario", "José", "Teste maquina...", category_2);
        Book b4 = new Book(null, "Olá mundo", "Antonio", "Teste mundo...", category_2);
        Book b5 = new Book(null, "Estudantes na luta", "Maria", "Teste luta...", category_2);

        //adiciono a o livro junto a categoria, adiciono o addAll para caso tenha mais de um livro com mesma categoria
        //dai pode adicionar todos de uma vez
        category_one.getBooks().addAll(Arrays.asList(b1, b2));
        category_2.getBooks().addAll(Arrays.asList(b3, b4, b5));

        //salva no db - posso salvar masi de uma instancia, por isso do asList
        this.categoryRepository.saveAll(Arrays.asList(category_one, category_2, category_3));
        this.bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5));
    }

}
